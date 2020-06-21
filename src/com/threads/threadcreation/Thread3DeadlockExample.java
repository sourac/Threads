/**
 * 
 */
package com.threads.threadcreation;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */

class Noob {

	/**
	 * 
	 */
	public void firstMethod() {
		synchronized (String.class) {
			synchronized (Integer.class) {
				System.out.println("lol..");
			}
		}

	}

	/**
	 * 
	 */
	public void secondMethod() {
		synchronized (Integer.class) {
			synchronized (String.class) {
				System.out.println("lol lol...");
			}
		}

	}

}

public class Thread3DeadlockExample {

	public static void main(String[] args) {
		Noob noob = new Noob();
		Noob noob1 = new Noob();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				noob.firstMethod();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				noob1.secondMethod();
			}
		});

		t1.start();
		t2.start();

	}

}
