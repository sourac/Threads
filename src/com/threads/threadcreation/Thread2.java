/**
 * 
 */
package com.threads.threadcreation;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */
class RunnabelThread implements Runnable {

	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i+" ");
			
		}

	}

}

public class Thread2 {

	public static void main(String[] args) {

		Thread t1 = new Thread(new RunnabelThread());
		Thread t2 = new Thread(new RunnabelThread());

		t1.start();
		t2.start();

	}

}
