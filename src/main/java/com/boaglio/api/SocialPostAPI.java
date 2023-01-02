package com.boaglio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.boaglio.discord.DiscordUtil;
import com.boaglio.twitter.TwitterUtil;

@RestController
@RequestMapping("/api")
public class SocialPostAPI {

    private static final String SENT_MSG = "Mensagem enviada";

    @Autowired
    private DiscordUtil discordUtil;

    @ResponseBody
    @PostMapping(value = "/message")
    public ResponseEntity<String> simpleMessage(@RequestBody String message) {
        try {
            discordUtil.sendSimpleMessage(message);
            TwitterUtil.sendSimpleMessage(message);
            return ResponseEntity.status(HttpStatus.OK).body(SENT_MSG);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Serviço Indisponível", exc);
        }
    }

    @ResponseBody
    @PostMapping(value = "/youtubelink")
    public ResponseEntity<String> youtubeLink(@RequestBody String message) {
        try {
            discordUtil.sendYoutubeLink(message);
            TwitterUtil.sendYoutubeLink(message);
            return ResponseEntity.status(HttpStatus.OK).body(SENT_MSG);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Serviço Indisponível", exc);
        }
    }

}
