package com.tiryaki.redisexample.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Cacheable(cacheNames = "cacheExample")
    public String longRunnigMethod() throws InterruptedException{
        Thread.sleep(5000L);
        return "method worked!";
    }

    @CacheEvict(cacheNames = "cacheExample")
    public void clearCache(){
        System.out.println("Cache cleaned");
    }
}
