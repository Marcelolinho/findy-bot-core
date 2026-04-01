package com.mpp.findy.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Serviço centralizado para operações de cache Redis.
 * Permite salvar, buscar, verificar e remover dados do cache
 * com controle de TTL por operação ou usando o padrão de 20 minutos.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CacheManagerService {

    private static final long DEFAULT_TTL_MINUTES = 20;

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * Salva um valor no cache com TTL padrão de 20 minutos.
     *
     * @param key   chave do cache
     * @param value valor a ser armazenado
     */
    public void save(String key, Object value) {
        save(key, value, DEFAULT_TTL_MINUTES, TimeUnit.MINUTES);
    }

    /**
     * Salva um valor no cache com TTL customizado.
     *
     * @param key      chave do cache
     * @param value    valor a ser armazenado
     * @param timeout  duração do TTL
     * @param timeUnit unidade de tempo
     */
    public void save(String key, Object value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        log.debug("Cache salvo: key={}, ttl={}{}",
                key, timeout, timeUnit.name().toLowerCase());
    }

    /**
     * Busca um valor no cache.
     *
     * @param key  chave do cache
     * @param type classe do tipo esperado
     * @return Optional com o valor ou empty se não encontrado
     */
    public <T> Optional<T> get(String key, Class<T> type) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            log.debug("Cache miss: key={}", key);
            return Optional.empty();
        }
        log.debug("Cache hit: key={}", key);
        return Optional.of(type.cast(value));
    }

    /**
     * Verifica se uma chave existe no cache.
     *
     * @param key chave do cache
     * @return true se a chave existe
     */
    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * Remove uma chave do cache.
     *
     * @param key chave a ser removida
     * @return true se a chave foi removida
     */
    public boolean evict(String key) {
        boolean deleted = Boolean.TRUE.equals(redisTemplate.delete(key));
        log.debug("Cache evict: key={}, removed={}", key, deleted);
        return deleted;
    }

    /**
     * Remove todas as chaves que correspondem a um padrão.
     * Exemplo: evictByPattern("user:*") remove todas as chaves que começam com "user:".
     *
     * @param pattern padrão de chave (suporta glob: *, ?, [])
     */
    public void evictByPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
            log.debug("Cache evict por padrão: pattern={}, removidos={}", pattern, keys.size());
        }
    }

    /**
     * Retorna o TTL restante de uma chave em segundos.
     *
     * @param key chave do cache
     * @return tempo restante em segundos, ou -1 se sem expiração, ou -2 se não existe
     */
    public long getTimeToLive(String key) {
        Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return ttl != null ? ttl : -2;
    }

    /**
     * Atualiza o TTL de uma chave existente sem alterar o valor.
     *
     * @param key     chave do cache
     * @param timeout nova duração
     * @return true se o TTL foi atualizado
     */
    public boolean refreshTtl(String key, Duration timeout) {
        return Boolean.TRUE.equals(
                redisTemplate.expire(key, timeout.toSeconds(), TimeUnit.SECONDS));
    }
}