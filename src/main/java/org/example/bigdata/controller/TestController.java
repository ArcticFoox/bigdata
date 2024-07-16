package org.example.bigdata.controller;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class TestController {

    @Value("${slack.notification.url}")
    private String url;

    private final Slack slack;

    @GetMapping("/")
    public void test() throws IOException {
        slack.send(url, Payload.builder()
                        .text("error")
                    .build());
        log.error("error");
    }
}
