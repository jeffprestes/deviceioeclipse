/**
 * 
 */
package com.paypal.developer.jeffprestes.demo.deviceioeclipse;

import com.paypal.developer.jeffprestes.demo.deviceioeclipse.Switch;

/**
 * @author jprestes
 * Initial class of our application
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		
		Switch mySwitch = new Switch();
		
		mySwitch.switchOff();
		mySwitch.switchOn();
		mySwitch.switchOff();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mySwitch.switchOn();
		
	}

}
