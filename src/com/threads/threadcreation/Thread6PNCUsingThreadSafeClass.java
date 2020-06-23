/**
 * 
 */
package com.threads.threadcreation;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */
public class Thread6PNCUsingThreadSafeClass {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void producer() throws InterruptedException {

		while (true) {
			queue.put(new Random().nextInt());
		}

	}

	public static void consumer() {
		Integer val = 0;
		while (true) {
			if (new Random().nextInt(10) == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}

			try {
				val = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("value taken from queue : " + val + "Queue size : " + queue.size());
		}

	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				consumer();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
