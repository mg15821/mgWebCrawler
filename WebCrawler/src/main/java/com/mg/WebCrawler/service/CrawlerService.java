package com.mg.WebCrawler.service;

import com.mg.WebCrawler.models.PageInformation;
import com.mg.WebCrawler.models.PageTreeInformation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrawlerService {

    public PageTreeInformation deepCrawl(final String url, final int depth, List<String> processedUrls);

    public Optional<PageInformation> crawl(String url);
}
