package observer.design.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverDesignPattern {

    public static void main(String[] args) {
        SpringApplication.run(ObserverDesignPattern.class, args);
        //LocalDateTime dateTime = LocalDateTime.now();
        //Instant instant = dateTime.atZone(ZoneId.of("UCT")).toInstant();
        //System.out.println("---------------------------------------------------------"+instant);
    }

}
