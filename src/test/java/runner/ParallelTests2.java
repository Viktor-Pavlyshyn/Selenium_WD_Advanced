package runner;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class ParallelTests2 {

    @SneakyThrows
    @Test
    public void test1(){
        Thread.sleep(6000);
        System.out.println("test1  " + Thread.currentThread().getName());
    }

    @SneakyThrows
    @Test
    public void test2(){
        Thread.sleep(6000);
        System.out.println("test2  " + Thread.currentThread().getName());
    }

    @SneakyThrows
    @Test
    public void test3(){
        Thread.sleep(6000);
        System.out.println("test3  " + Thread.currentThread().getName());
    }
}
