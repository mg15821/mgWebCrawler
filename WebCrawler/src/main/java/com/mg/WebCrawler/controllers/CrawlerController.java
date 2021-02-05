package com.mg.WebCrawler.controllers;

import com.mg.WebCrawler.configuration.AppProperties;
import com.mg.WebCrawler.models.PageTreeInformation;
import com.mg.WebCrawler.service.CrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Optional;



@Slf4j
@RestController
public class CrawlerController implements CrawlerApi {

    private final CrawlerService crawlerService;

    @Value("#{appProperties.crawler}")
    private AppProperties.CrawlerProperties crawlerProperties;

    public CrawlerController(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }


    @Override
    @GetMapping(value = "/webcrawler", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PageTreeInformation> getWebPageTreeInfo(
            @NotNull @RequestParam(value = "url") final String url,
            @RequestParam(value = "depth", required = false) final Integer depth) {

        log.info("Request for deep crawling received for url: {}, depth: {}", url, depth);
        final int newDepth = Integer.min(Optional.ofNullable(depth).orElse(crawlerProperties.getDefaultDepth()),
                crawlerProperties.getMaxDepthAllowed());
        log.info(
                "Depth can go upto Max defined in property:'app.crawler.max-depth-allowed'. optimized depth: {}",
                newDepth);
        return new ResponseEntity<>(crawlerService.deepCrawl(url, depth, null), HttpStatus.OK);
    }
}
