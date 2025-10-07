package pe.edu.pe.mspracticas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPracticasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPracticasApplication.class, args);
    }

}
