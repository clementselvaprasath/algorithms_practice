package ood.lockersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestThreadPool {

	public static void main(String[] args) {
		
		ExecutorService executor = new ThreadPoolExecutor(1,
                1,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
		Future<String> f1 = executor.submit(() -> process1());
		Future<String> f2 = executor.submit(() -> process2());
		List<Future<String>> list = new ArrayList<>();
		list.add(f1);
		list.add(f2);
		executor.shutdown();
		List<String> result = list.stream().map(t -> {
			try {
				String s = t.get(2, TimeUnit.SECONDS);
				//System.out.println(s);
				return s;
			} catch (Exception e) {
				System.out.println("Failed: " + e.getMessage());
				return "Failed";
			}
		}).collect(Collectors.toList());
		
		for (String s : result) {
			System.out.print(s + ", ");
		}
	}

	private static String process1() {
		try {
			Thread.sleep(3000);
			return Thread.currentThread().getId() + ": Success";
		} catch(Exception e) {
			
		}
		return "Failed";
	}
	
	private static String process2() {
		try {
			Thread.sleep(1000);
			return Thread.currentThread().getId() + ": Success";
		} catch(Exception e) {
			
		}
		return "Failed";
	}
}
