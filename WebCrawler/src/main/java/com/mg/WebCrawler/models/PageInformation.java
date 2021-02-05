package com.mg.WebCrawler.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jsoup.select.Elements;


import java.io.Serializable;

@Data
@AllArgsConstructor
public class PageInformation implements Serializable {

    private static final long serialVersionUID = 1234567L;

    private String title;

    private String url;

    private Elements links;
}
