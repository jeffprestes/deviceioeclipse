/**
 * 
 */
package com.paypal.developer.jeffprestes.demo.deviceioeclipse;

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
		
		mySwitch.switchOn();
		
		System.out.println("What is the status of bulb? It is: " + mySwitch.getStatus());
		
		mySwitch.switchOff();
		
		mySwitch.blink(3);
		
		mySwitch.blink(10, 500);
	}

}
