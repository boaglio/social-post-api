package com.boaglio.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boaglio.api.YouTubeVideo;
import com.boaglio.crawler.CrawlerUtil;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterV2;
import twitter4j.TwitterV2ExKt;

public class TwitterUtil {

    private TwitterUtil() {
    }

    static Logger logger = LoggerFactory.getLogger(TwitterUtil.class);

    public static void sendSimpleMessage(String textMessage) {

        try {
            Twitter twitter = new TwitterFactory().getInstance();
            final TwitterV2 v2 = TwitterV2ExKt.getV2(twitter);

            logger.info("Tweeting...");
            v2.createTweet(null, null, null, null, null, null, null, null, null, null, null, textMessage);

        } catch (Exception e) {
            logger.error("Exception when calling TwitterV2", e);
        }

    }

    public static void sendYoutubeLink(String youtubeLink) {

        logger.info("Crawling...");
        YouTubeVideo youtubeVideo = CrawlerUtil.getYoutubeInfo(youtubeLink);
        String txtTweet = youtubeVideo.title() + " " + youtubeVideo.url();
        logger.info("Got it:[ {} ]", txtTweet);

        try {
            Twitter twitter = new TwitterFactory().getInstance();
            final TwitterV2 v2 = TwitterV2ExKt.getV2(twitter);

            logger.info("Tweeting...");
            v2.createTweet(null, null, null, null, null, null, null, null, null, null, null, txtTweet);

        } catch (Exception e) {
            logger.error("Exception when calling TwitterV2", e);
        }

    }

}
