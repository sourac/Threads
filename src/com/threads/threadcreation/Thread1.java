/**
 * 
 */
package com.threads.threadcreation;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */

class Magic extends Thread {

	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Run count : " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class Thread1 {

	public static void main(String[] args) throws InterruptedException {
		Magic magic = new Magic();
		magic.start();
		magic.join();
		Magic magic1 = new Magic();
		magic1.start();
		magic1.join();
	}

}
