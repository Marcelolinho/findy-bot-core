package com.mpp.scraper.core.model.product;

import com.mpp.scraper.core.enums.PriceTypeEnum;

import java.math.BigDecimal;

public class FindyPriceHistoryBo {

    private Long id;
    private BigDecimal price;
    private PriceTypeEnum priceType;
    private FindyProductBo product;

    public FindyPriceHistoryBo(Long id, BigDecimal price, PriceTypeEnum priceType, FindyProductBo product) {
        this.id = id;
        this.price = price;
        this.priceType = priceType;
        this.product = product;
    }

    public FindyPriceHistoryBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
    }

    public FindyProductBo getProduct() {
        return product;
    }

    public void setProduct(FindyProductBo product) {
        this.product = product;
    }
}
