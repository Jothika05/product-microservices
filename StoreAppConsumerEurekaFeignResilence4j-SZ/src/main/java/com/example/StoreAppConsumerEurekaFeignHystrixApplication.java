
package com.example;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@SpringBootApplication
public class  StoreAppConsumerEurekaFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run( StoreAppConsumerEurekaFeignHystrixApplication.class, args);
	}
	@Bean
	public Sampler alwaysSampler (){
           return Sampler.ALWAYS_SAMPLE;

	}

}


