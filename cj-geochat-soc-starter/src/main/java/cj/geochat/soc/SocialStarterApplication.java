package cj.geochat.soc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cj.geochat.soc"})
public class SocialStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialStarterApplication.class, args);
    }

}
