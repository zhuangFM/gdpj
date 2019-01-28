package indi.fimi.gdpj.shoppingcart.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("base-module")
public interface BaseModuleApi {
    @GetMapping("/get_user")
    Map<String,Object> getUserInfoByUid(@RequestParam(value = "id", defaultValue = "1") Integer id);
}
