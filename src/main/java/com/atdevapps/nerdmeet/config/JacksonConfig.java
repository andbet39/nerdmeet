package com.atdevapps.nerdmeet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bedatadriven.jackson.datatype.jts.JtsModule;

@Configuration
public class JacksonConfig {

	@Bean
	public JtsModule jtsmodule() {
		return new JtsModule();
	}
}
