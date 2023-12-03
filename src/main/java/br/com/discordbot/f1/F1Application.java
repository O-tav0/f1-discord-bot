package br.com.discordbot.f1;

import br.com.discordbot.f1.configuration.ApiConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class F1Application {

	@Value("${bot.token}")
	private String token;
	public static void main(String[] args) {
		SpringApplication.run(F1Application.class, args);
	}

	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi() {
		ApiConfiguration apiConfiguration = new ApiConfiguration();
		return ApiConfiguration.getApi();
	}
}
