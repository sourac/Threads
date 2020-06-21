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
				try {
					odev.printEven();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

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
		synchronized (this) {
			while (count < MAX) {
				while (!odd) {

					try {
						System.out.println("waiting for odd..");
						wait();
						System.out.println("notified for odd..");
					} catch (Exception e) {
					}

				}
				System.out.println("odd number :" + count);
				odd = false;
				count++;
				notify();
			}

		}

	}

	/**
	 * @throws InterruptedException
	 * 
	 */
	protected void printEven() throws InterruptedException {
		Thread.sleep(100);

		synchronized (this) {
			while (count < MAX) {
				while (odd) {
					System.out.println("waiting for even...");
					wait();
					System.out.println("notified for even..");

				}
				System.out.println("even number : " + count);
				count++;
				odd = true;
				notify();
			}
		}

	}

}
