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

	}

}

public class Thread2 {

	public static void main(String[] args) {

		Thread t1 = new Thread(new RunnabelThread());
		Thread t2 = new Thread(new RunnabelThread());

	}

}
