package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableBefore8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Integer>> results = new ArrayList<>();
        for ( int i = 0; i < 3; i++) {
            int temp = i;
            results.add(pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(1000);
                    return temp * 2;
                }
            }));
        }
        for (Future result : results) {
            System.out.println(result.get());
        }


        pool.shutdown();


    }
}
