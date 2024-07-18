package org.example.bigdata.config;

import com.slack.api.Slack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackWebhookConfig {

    @Bean
    public Slack slack(){
        return Slack.getInstance();
    }

}
