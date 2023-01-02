package com.boaglio.discord;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.boaglio.api.YouTubeVideo;
import com.boaglio.crawler.CrawlerUtil;

@Configuration
@PropertySource("classpath:discord.properties")
public class DiscordUtil {

    @Value("${webhook.url}")
    private String webhookUrl;

    public void sendSimpleMessage(String textMessage) throws IOException {

        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);
        webhook.setContent(textMessage);
        webhook.execute();

    }

    public void sendYoutubeLink(String youtubeLink) throws IOException {

        YouTubeVideo youtubeVideo = CrawlerUtil.getYoutubeInfo(youtubeLink);

        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);
        webhook.setContent(youtubeVideo.title() + " - " + youtubeVideo.url());
        webhook.setTts(true);
        webhook.execute();

    }

}
