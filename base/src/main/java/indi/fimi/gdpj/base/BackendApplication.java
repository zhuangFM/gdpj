package indi.fimi.gdpj.base;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
public class BackendApplication {
    public static void main(String[] args){
        SpringApplication.run(BackendApplication.class);
    }

    @RequestMapping("/base-module")
    class BaseModuleController{
        @Autowired
        DiscoveryClient discoveryClient;

        @RequestMapping("/base-module")
        public String dc(){
            String services = "Services: " + discoveryClient.getServices();
            System.out.println(services);
            return services;
        }
    }

}
