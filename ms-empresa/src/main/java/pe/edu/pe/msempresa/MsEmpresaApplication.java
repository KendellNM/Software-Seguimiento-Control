package pe.edu.pe.msempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsEmpresaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEmpresaApplication.class, args);
    }

}
