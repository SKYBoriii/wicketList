package skyboriii.wicketList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WicketListApplication {

	public static void main(String[] args) {
		SpringApplication.run(WicketListApplication.class, args);
	}

}
