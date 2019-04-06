package com.norbertcseh.cabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
	// public LocalResolver localResolver() {
	// SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	// localeResolver.setDefaultLocale(Locale.US);
	// return localeResolver;
	// }

	// @Bean
	// ResourceBundleMessageSource bundleMessageSource() {
	// ResourceBundleMessageSource messageSource = new
	// ResourceBundleMessageSource();
	// messageSource.setBasename("message");
	// return messageSource;
	// }

}
