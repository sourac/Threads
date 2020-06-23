/**
 * 
 */
package com.threads.threadcreation;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */
class PNC {

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void producer() throws InterruptedException {

		synchronized (this) {
			System.out.println("producer started...");
			Thread.sleep(100);
			wait();
			System.out.println("producer resumed...");

		}

	}

	/**
	 * 
	 */
	public void consumer() {
		synchronized (this) {
			System.out.println("consumer started..");
			notify();
		}

	}

}

public class Thread5ProducerConsumer {

	public static void main(String[] args) {

		PNC pnc = new PNC();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pnc.producer();

				} catch (InterruptedException e) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				pnc.consumer();

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
