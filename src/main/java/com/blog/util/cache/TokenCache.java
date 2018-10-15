package com.blog.util.cache;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class TokenCache {
    private static Logger logger= LoggerFactory.getLogger(TokenCache.class);
    private static int expired=10800;
    private static Cache<String,Object> localCache =  Caffeine.newBuilder()
            .expireAfterAccess(expired, TimeUnit.SECONDS)
            .maximumSize(10000)
            .build();

    public static void set(String key,Object value){
        localCache.put(key,value);
    }
    public static <T> T get(String key){
        T value =null;
        try{
            //以阻塞的方式调用
            value=(T) localCache.getIfPresent(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error:"+e.getMessage());
        }
        return null;
    }
    public static void delete(String key){
        localCache.invalidate(key);
    }
   
    public static int getExpired(){
        return expired;
    }

  


}

