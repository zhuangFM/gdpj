package indi.fimi.gdpj.transaction.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("foodstuff-module")
public interface FoodstuffModuleApi {
    @GetMapping("/get_foodstuff_by_id")
    Map<String,Object> getFoodstuffInfoById(@RequestParam(name = "id") Integer id);
}
