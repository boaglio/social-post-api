package com.boaglio.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boaglio.api.YouTubeVideo;

public class CrawlerUtil {

    private CrawlerUtil() {
    }

    static Logger logger = LoggerFactory.getLogger(CrawlerUtil.class);

    public static YouTubeVideo getYoutubeInfo(String url) {

        YouTubeVideo youtubeVideo = null;
        String ytTitle = null;
        String ytUrl = null;
        String ytDesc = null;
        Document doc;
        try {
            doc = Jsoup.connect(url).timeout(6000).get();
            Elements metaTags = doc.getElementsByTag("meta");
            for (Element metaTag : metaTags) {
                String content = metaTag.attr("content");
                String name = metaTag.attr("name");

                if ("title".equals(name)) {
                    ytTitle = content;
                    logger.info("name: {}", content);
                }
                if ("description".equals(name)) {
                    logger.info("desc: {}", content);
                    ytDesc = content;
                }
                if ("twitter:url".equals(name)) {
                    logger.info("url: {}", content);
                    ytUrl = content;
                }
            }
            youtubeVideo = new YouTubeVideo(ytUrl, ytTitle, ytDesc);
        } catch (IOException e) {
            logger.error("crawling error: ", e);
        }
        return youtubeVideo;
    }

}
