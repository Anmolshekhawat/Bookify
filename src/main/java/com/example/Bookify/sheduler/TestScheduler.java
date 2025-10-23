//package com.example.Bookify.sheduler;
//
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestScheduler {
//
//
////    @Scheduled(cron = "0 0 0")
//    public static void main(String [] args) {
//
//        long start = System.currentTimeMillis();
//
//        List<Long> list = new ArrayList<>();
//
//
//
//        for (long i = 0; i < 1000000; i++) {
//            list.add(i);
//        }
//
//        list.parallelStream().forEach(
//                i -> System.out.println("Hello " + i)
//        );
//
//        long end = System.currentTimeMillis();
//
//
//        System.out.println("Total time taken "+(end-start));
//
//    }
//
//}
