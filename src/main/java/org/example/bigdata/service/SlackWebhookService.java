package org.example.bigdata.service;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class SlackWebhookService {

    @Value("${slack.notification.url}")
    private String url;

    private final Slack slackClient;

    public void sendMessage(String body) throws IOException {
        slackClient.send(url, Payload.builder()
                        .text(body)
                        .build());
    }
}
