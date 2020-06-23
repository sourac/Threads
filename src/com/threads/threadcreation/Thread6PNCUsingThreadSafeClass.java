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
class TestC {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public void producer() throws InterruptedException {
		
		while (true) {
			queue.put(new Random().nextInt());
		}

	}

	public void consumer() {
		// TODO Auto-generated method stub

	}

}

public class Thread6PNCUsingThreadSafeClass {

	public static void main(String[] args) {
		TestC test = new TestC();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					test.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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
