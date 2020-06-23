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
	 * 
	 */
	public void producer() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void consumer() {
		// TODO Auto-generated method stub
		
	}

}

public class ProducerConsumer {

	public static void main(String[] args) {

		PNC pnc = new PNC();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				pnc.producer();
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
