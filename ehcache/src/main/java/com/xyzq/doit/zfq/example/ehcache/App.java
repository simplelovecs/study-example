package com.xyzq.doit.zfq.example.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws URISyntaxException {
        ehcache();
        mycache();
        jcache();
    }

    public static void ehcache() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                                                       .withCache("preConfigured",
                                                                  CacheConfigurationBuilder
                                                                          .newCacheConfigurationBuilder(Long.class,
                                                                                                        String.class,
                                                                                                        ResourcePoolsBuilder
                                                                                                                .heap(100))
                                                                          .build())
                                                       .build(true);

        Cache<Long, String> preConfigured
                = cacheManager.getCache("preConfigured", Long.class, String.class);

        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                                                               CacheConfigurationBuilder
                                                                       .newCacheConfigurationBuilder(Long.class,
                                                                                                     String.class,
                                                                                                     ResourcePoolsBuilder
                                                                                                             .heap(100))
                                                                       .build());

        myCache.put(1L, "中国人!");
        String value = myCache.get(1L);
        System.out.println(value);

        cacheManager.close();

        System.out.println("Hello World!");
    }

    public static void jcache() throws URISyntaxException {
//         //如果依赖中有多个jcache实现，这里可以指定ehcache实现Caching.getCachingProvider(“org.ehcache.jsr107.EhcacheCachingProvider”);，如果只有一个jcache实现，则Caching.getCachingProvider()可以找到对应的实现，查找逻辑后面有提到
//         CachingProvider cachingProvider = Caching.getCachingProvider();
//         //getCacheManager第一个参数为一个uri，对于ehcache来说该uri应该是ehcache的配置文件，ehcache实现在这里就会初始化配置文件中的cache
//        javax.cache.CacheManager manager = cachingProvider.getCacheManager(
//                                 Thread.currentThread().getClass().getResource("/ehcache.xml").toURI(),
//                                 Thread.currentThread().getClass().getClass().getClassLoader());
//         //从manager获得已配置的cache
//
        CachingProvider provider = Caching.getCachingProvider();
//        javax.cache.CacheManager manager = provider.getCacheManager();

        javax.cache.CacheManager manager = provider.getCacheManager(
                                 Thread.currentThread().getClass().getResource("/ehcache.xml").toURI(),
                                 Thread.currentThread().getClass().getClass().getClassLoader());

        javax.cache.Cache<Long, String> cache1 = manager.getCache("ready-cache");
        cache1.put(1L, "这是测试！");
        String h = cache1.get(1L);
        System.out.println(h);


        MutableConfiguration<Integer, Date> config = new MutableConfiguration();

        String cacheName = "sampleCache";
        javax.cache.Cache<Integer, Date> cacheDate = manager. createCache(cacheName,config);
        javax.cache.Cache<Integer, Date> cache = manager.getCache(cacheName);
        Date value1 = new Date();
        Integer key = 1;
        cache.put(key, value1);
        Date value2 = cache.get(key);
        System.out.println(value2);
//                Cache<Long, String> readyCache = manager.getCache("ready-cache", Long.class, String.class);class
    }

    public static void mycache() {
        CachingProvider cachingProvider = Caching. getCachingProvider();

        javax.cache.CacheManager cacheManager = cachingProvider. getCacheManager();

        MutableConfiguration<String, String> config = new MutableConfiguration();

        javax.cache.Cache<String, String> cache = cacheManager. createCache("JDKCodeNames",config);
//
        cache.put("JDK1.5","Tiger");

        cache.put("JDK1.6","Mustang");

        cache.put("JDK1.7","Dolphin");

        String jdk7CodeName = cache.get("JDK1.7");
        System.out.println(jdk7CodeName);

    }
}
