package org.redis;

import org.redisson.Redisson;
import org.redisson.api.RJsonBucket;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisConnection;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.redisson.misc.RedisURI;

public class ConnectToRedis {
    public static void main(String[] args) {
        Config config = new Config();
        config
                .setCodec(new StringCodec())
                .useSingleServer()
                .setAddress("redis://13.42.172.87:6379")
                .setPassword("redis@password")
                //dev used 0th database
                .setDatabase(0);

        RedissonClient client = Redisson.create(config);
        RQueue<String> key = client.getQueue("mycar");
        key.add("hello");

        System.out.println("redis connected");
        client.shutdown();
    }
}
