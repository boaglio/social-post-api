package com.boaglio;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.boaglio.api.YouTubeVideo;
import com.boaglio.crawler.CrawlerUtil;
import com.boaglio.discord.DiscordUtil;
import com.boaglio.twitter.TwitterUtil;

@SpringBootTest
@Disabled
class SocialPostApplicationTests {

    static final String VIDEO_MSG  = "https://youtu.be/fwpWAH9-b_g";
    static final String SIMPLE_MSG = "Bot Test";

    @Test
    void crawlerTest() throws IOException {
        YouTubeVideo youtubeVideo = CrawlerUtil.getYoutubeInfo(VIDEO_MSG);
        assertThat(youtubeVideo.url()).isNotNull();
        assertThat(youtubeVideo.title()).isNotNull();
    }

    @Test
    void discordYoutubeTest() throws IOException {
        new DiscordUtil().sendYoutubeLink(VIDEO_MSG);
    }

    @Test
    void discordSimpleTest() throws IOException {
        new DiscordUtil().sendSimpleMessage(SIMPLE_MSG);
    }

    @Test
    void twitterYoutubeTest() throws IOException {
        TwitterUtil.sendYoutubeLink(VIDEO_MSG);
    }

    @Test
    void twitterSimpleTest() throws IOException {
        TwitterUtil.sendSimpleMessage(SIMPLE_MSG);
    }

}
