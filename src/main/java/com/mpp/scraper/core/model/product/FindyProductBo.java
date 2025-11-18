package com.mpp.scraper.core.model.product;

import com.mpp.scraper.core.enums.PlatformsEnum;

public class FindyProductBo {

    private Long id;
    private String name;
    private String description;
    private String websiteUrl;
    private PlatformsEnum platform;

    public FindyProductBo(Long id, String name, String description, String websiteUrl, PlatformsEnum platform) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.platform = platform;
    }

    public FindyProductBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public PlatformsEnum getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformsEnum platform) {
        this.platform = platform;
    }
}
