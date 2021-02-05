package com.mg.WebCrawler.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@Named
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    @Valid
    private final CrawlerProperties crawler = new CrawlerProperties();

    /**
     * Nested property group bound to 'mg.WebCrawler'.
     */
    @Data
    @Validated
    public static class CrawlerProperties {

        /**
         * default depth for Web Crawler.
         */
        @Min(0)

        private int defaultDepth;

        /**
         * max depth allowed for a request based on service capability
         */
        @Min(0)
        private int maxDepthAllowed;

        /**
         * timeout for http requests in seconds
         */
        @Min(5)
        private int timeOut;

        /**
         * follow redirects for the given url
         */
        private boolean followRedirects;

    }
}
