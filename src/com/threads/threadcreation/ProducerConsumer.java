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
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				pnc.consumer();
				
			}
		});
		
		t1.start();
		t2.start();

	}

}
