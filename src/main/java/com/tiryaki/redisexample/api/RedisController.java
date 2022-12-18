package com.tiryaki.redisexample.api;

import com.tiryaki.redisexample.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RedisController {
    private final RedisService redisService;
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }
    public static final int CACHE_TRY_LIMIT = 3;
    private int counter = 0;

    @GetMapping
    public String executeService() throws InterruptedException {
        if (counter == CACHE_TRY_LIMIT){
            redisService.clearCache();
            counter = 0;
        }
        counter++;
        return redisService.longRunnigMethod();
    }

}
