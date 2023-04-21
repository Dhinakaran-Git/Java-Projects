package in.bassure.training.batch7.java;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureConceptDemo {

    public static void main(String[] args) throws Exception {
        System.out.println(new Date().getTime());
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> result = es.submit(
                () -> {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception ex) {
                    }
                    return "abcd";
                }
        );

        System.out.println(new Date().getTime());
        String data = result.get();
        System.out.println(data);
        System.out.println(new Date().getTime());
        es.shutdownNow();
    }

}
