package org.redis.RBucket;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    public static void main(String[] args) throws JsonProcessingException {
        Config config = new Config();
        config
                .setCodec(new StringCodec())
                .useSingleServer()
                .setAddress("redis://13.42.172.87:6379")
                .setPassword("redis@password")
                //dev used 0th database
                .setDatabase(0);

        RedissonClient client = Redisson.create(config);
        RBucket<List<Car>> rBucket = client.getBucket("mybucket");
        //set Object to RBucket
//        rBucket.set(new Car(1, "Audi", "normal"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry"));
        cars.add(new Car(2, "Honda", "Accord"));
        cars.add(new Car(3, "Ford", "Mustang"));

// Serialize the list of Car objects to a JSON string
//        String json = new ObjectMapper().writeValueAsString(cars);
        rBucket.set(cars);
        System.out.println("retrieving : " + rBucket.get());
    }
}
