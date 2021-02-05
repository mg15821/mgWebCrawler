package com.mg.WebCrawler.service;

import com.mg.WebCrawler.configuration.AppProperties;
import com.mg.WebCrawler.models.PageInformation;
import com.mg.WebCrawler.models.PageTreeInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.cache.annotation.CacheResult;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Named
public class CrawlerServiceImpl implements CrawlerService {

    @Value("#{applicationProperties.crawler}")
    private AppProperties.CrawlerProperties crawlerProperties;

    @Override
    @CacheResult(cacheName = "mg-crawler")
    public PageTreeInformation deepCrawl(final String url, final int depth, final List<String> processedUrls) {

        log.debug("Starting crawler for url {} for depth {}", url, depth);
        if (depth < 0) {
            log.info("Maximum depth reached, backing out for url {}", url);
            return null;
        } else {
            final List<String> updatedProcessedUrls = Optional.ofNullable(processedUrls).orElse(new ArrayList<>());
            if (!updatedProcessedUrls.contains(url)) {
                updatedProcessedUrls.add(url);
                final PageTreeInformation pageTreeInfo = new PageTreeInformation(url);
                crawl(url).ifPresent(pageInfo -> {
                    pageTreeInfo.title(pageInfo.getTitle()).valid(true);
                    log.info("Found {} links on the web page: {}", pageInfo.getLinks(), url);
                    pageInfo.getLinks().forEach(link -> {
                        pageTreeInfo.addNodesItem(deepCrawl(link.attr("abs:href"), depth - 1, updatedProcessedUrls));
                    });

                });
                return pageTreeInfo;
            } else {
                return null;
            }
        }

    }

    @Override
    public Optional<PageInformation> crawl(String url) {
        return Optional.empty();
    }
}
