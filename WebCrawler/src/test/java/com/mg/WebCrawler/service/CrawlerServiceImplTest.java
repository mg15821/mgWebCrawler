package com.mg.WebCrawler.service;

import com.mg.WebCrawler.models.PageInformation;
import com.mg.WebCrawler.models.PageTreeInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CrawlerServiceImplTest {

    @Inject
    private CrawlerService crawlerService;

    @Test
    public void testDeepCrawl() {
        final PageTreeInformation info = crawlerService.deepCrawl("http://wiprodigital.com", 1, null);
        assertThat(info).isNotNull().satisfies(treeInfo -> {
            assertThat(treeInfo.getTitle()).contains("wiprodigital");
            assertThat(treeInfo.getUrl()).contains("http://wiprodigital.com");
            assertThat(treeInfo.getNodes().size()).isGreaterThan(20);
        });
    }

    @Test
    public void testCrawl() {
        final Optional<PageInformation> info = crawlerService.crawl("http://wiprodigital.com");
        assertThat(info).isPresent();
        assertThat(info.get().getTitle()).contains("wiprodigital");
        assertThat(info.get().getUrl()).contains("http://wiprodigital.com");
        assertThat(info.get().getLinks().size()).isGreaterThan(10);
    }
}
