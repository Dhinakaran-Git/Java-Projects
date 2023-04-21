package org.redis.redissonStream;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RStream;
import org.redisson.api.StreamMessageId;
import org.redisson.api.stream.StreamAddArgs;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.HashMap;
import java.util.Map;

public class Rstream {
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
        RStream<String, String> rstream = client.getStream("mystreams");

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("key1", "value1");
        stringMap.put("key2", "value2");

        StreamMessageId id = rstream.add(StreamAddArgs.entries(stringMap));
        System.out.println(id);

        //For retrieving a stream
//        Map<StreamMessageId, Map<String, String>> messages = rstream.read(StreamMessageId.ALL);
//        for (Map.Entry<StreamMessageId, Map<String, String>> entry : messages.entrySet()) {
//            Map<String, String> msg = entry.getValue();
//            System.out.println(msg);
//        }
        client.shutdown();
    }
}
