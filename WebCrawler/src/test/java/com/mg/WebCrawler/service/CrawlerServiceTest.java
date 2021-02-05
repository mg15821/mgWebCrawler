package com.mg.WebCrawler.service;

import com.mg.WebCrawler.models.PageInformation;
import com.mg.WebCrawler.models.PageTreeInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class CrawlerServiceTest {

    @Value("#{cacheManager.getCache('${spring.application.name}')}")
    private Cache applicationCache;

    @Inject
    private CrawlerService crawlerService;

    @Test
    public void testCacheOnDeepCrawl() {
        final PageTreeInformation info = crawlerService.deepCrawl("http://wiprodigital.com", 0, null);
        assertThat(info).isNotNull().satisfies(treeInfo -> {
            assertThat(treeInfo.getTitle()).contains("wiprodigital");
            assertThat(treeInfo.getUrl()).contains("http://wiprodigital.com");
        });
        assertThat(applicationCache.getName()).isNotNull();
        assertThat(applicationCache.get(new SimpleKey("http://wiprodigital.com", 0, null))).isNotNull();
    }

    @Test
    public void testCacheOnCrawl() {
        final Optional<PageInformation> info = crawlerService.crawl("http://wiprodigital.com");
        assertThat(info).isPresent();
        assertThat(info.get().getTitle()).contains("wiprodigital");
        assertThat(info.get().getUrl()).contains("http://wiprodigital.com");
        assertThat(info.get().getLinks().size()).isGreaterThan(20);

        assertThat(applicationCache.get("http://wiprodigital.com")).isNotNull();
    }

}
