package org.redis.RTopic;

import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

public class Publish {
    public static void main(String[] args) {
        Config config = new Config();
        config.setCodec(new StringCodec())
                .useSingleServer()
                .setAddress("redis://13.42.172.87:6379")
                .setPassword("redis@password")
                //dev used 0th database
                .setDatabase(0);

        RedissonClient redisClient = Redisson.create(config);
        RTopic rTopic = redisClient.getTopic("topic");

        rTopic.publish("passing to subscriber");
        rTopic.publish("second pub");
    }
}
