package br.com.hospital.hpem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableWebMvc
public class HpemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HpemApplication.class, args);
	}

}
