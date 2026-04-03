package com.mpp.integration.handler;

import com.mpp.domain.FindyEndpointSearch;
import org.springframework.messaging.Message;

public class FindyMercadoLivreHandler extends AbstractFindyServiceHandler {

    @Override
    public Message<FindyEndpointSearch> handleGateway() {
        return null;
    }
}
