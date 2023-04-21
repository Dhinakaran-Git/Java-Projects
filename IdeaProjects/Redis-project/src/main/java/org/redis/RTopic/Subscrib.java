package org.redis.RTopic;

import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

public class Subscrib {
    public static void main(String[] args) {
        Config config = new Config();
        config.setCodec(new StringCodec())
                .useSingleServer()
                .setAddress("redis://13.42.172.87:6379")
                .setPassword("redis@password")
                //dev used 0th database
                .setDatabase(0);

        RedissonClient subscriber = Redisson.create(config);
        RTopic rTopic = subscriber.getTopic("topic");

        rTopic.addListener(String.class, (channel, message) -> {
            System.out.println("This is the publisher : " + message);
        });
    }
}
