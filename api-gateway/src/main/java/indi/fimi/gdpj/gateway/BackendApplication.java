package indi.fimi.gdpj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class BackendApplication {
    public static void main(String[] args){
        SpringApplication.run(BackendApplication.class);
    }
}
