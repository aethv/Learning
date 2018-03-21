package info.kzthink.springjpahibernateredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class SpringJpaHibernateRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateRedisApplication.class, args);
	}

}
