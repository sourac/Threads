/**
 * 
 */
package com.threads.threadcreation;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */

public class Thread4OddEven {
	boolean odd;
	int count = 1;
	int MAX = 20;

	public static void main(String[] args) {

		Thread4OddEven odev = new Thread4OddEven();
		odev.odd = true;

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				odev.printEven();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {

				odev.printOddd();

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

	/**
	 * 
	 */
	protected void printOddd() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	protected void printEven() {
		// TODO Auto-generated method stub
		
	}

}
