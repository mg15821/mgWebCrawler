package com.mg.WebCrawler.controllers;

import com.mg.WebCrawler.models.PageTreeInformation;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-04T20:28:16.650Z")

@Api(value = "crawler", description = "the MG Web Crawler API")
public interface CrawlerApi {
    @ApiOperation(value = "Get the web page tree information upto specified depth", notes = "", response = PageTreeInformation.class, authorizations = {
            @Authorization(value = "basicAuth")}, tags = {"mg-crawler",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = PageTreeInformation.class),
            @ApiResponse(code = 400, message = "Invalid page url", response = Void.class),
            @ApiResponse(code = 401, message = "Unauthorized to use the service", response = Void.class),
            @ApiResponse(code = 404, message = "Page not found", response = Void.class)})
    ResponseEntity<PageTreeInformation> getWebPageTreeInfo(
            @ApiParam(value = "Url of the webpage for getting tree info", required = true) String url,
            @ApiParam(value = "Desired depth for crawling") Integer depth);
}
