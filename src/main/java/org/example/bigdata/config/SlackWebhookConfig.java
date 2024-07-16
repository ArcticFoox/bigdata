package org.example.bigdata.config;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackWebhookConfig {

    @Value("${slack.notification.url}")
    private String url;

    @Bean
    public Slack slack(){
        return Slack.getInstance();
    }
}
