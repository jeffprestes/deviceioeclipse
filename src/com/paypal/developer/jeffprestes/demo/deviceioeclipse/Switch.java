/**
 * 
 */
package com.paypal.developer.jeffprestes.demo.deviceioeclipse;

import java.io.IOException;
import java.security.InvalidParameterException;

import jdk.dio.DeviceConfig;
import jdk.dio.DeviceManager;
import jdk.dio.gpio.GPIOPin;
import jdk.dio.gpio.GPIOPinConfig;

/**
 * Class that represents a switch to our light bulb
 * It uses Device I/O API.
 * Check details at http://docs.oracle.com/javame/config/cldc/opt-pkgs/api/dio-jmee8/api/index.html?overview-summary.html
 * @author jprestes
 */
public class Switch {
	
	private final int GPIO_PIN_NUMBER = 23;
	private GPIOPin pinLight = null;
	
	/**
	 * Constructor to initialize class variables and other resources
	 */
	public Switch()	{
		
		//Docs at http://docs.oracle.com/javame/config/cldc/opt-pkgs/api/dio-jmee8/api/jdk/dio/gpio/GPIOPinConfig.html
		GPIOPinConfig pinConfigOutput = new GPIOPinConfig(DeviceConfig.DEFAULT, 
													GPIO_PIN_NUMBER,
													GPIOPinConfig.DIR_OUTPUT_ONLY, 
													GPIOPinConfig.MODE_OUTPUT_PUSH_PULL, 
													GPIOPinConfig.TRIGGER_NONE, 
													true);
		
		try {
			pinLight = DeviceManager.open(GPIOPin.class, pinConfigOutput);
		} catch (IOException e) {
			System.err.println("Error when a GPIO pin was being set: " + e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Turning On the GPIO Pin
	 */
	public void switchOn()	{
		try {
			this.pinLight.setValue(false);
		} catch (IOException e) {
			System.err.println("Error when a GPIO pin was being set ON: " + e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Turning Off the GPIO Pin
	 */
	public void switchOff()		{
		try {
			this.pinLight.setValue(true);
		} catch (IOException e) {
			System.err.println("Error when a GPIO pin was being set OFF: " + e.getLocalizedMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the GPIO Pin status
	 */
	public boolean getStatus()	{
		try {
			return this.pinLight.getValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error when trying to get GPIO status: " + e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * Blink the bulb
	 * @param numberOfTimes you want the bulb blinks
	 * @param timeItStillsOn the amount of time you want the bulb stills on before turn off
	 */
	public void blink(int numberOfTimes, int timeItStillsOn)		{
		if (numberOfTimes<2)	{
			throw new InvalidParameterException("You must define more than 2 times or use only switchOn and switchOff methods");
		}
		
		if (timeItStillsOn < 500)	{
			throw new InvalidParameterException("You must define at least 500ms or your audience won't be able to see the bulb blinks");
		}
		
		for (byte a=0; a<numberOfTimes; a++)	{
			this.switchOn();
			try {
				Thread.sleep(timeItStillsOn);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.switchOff();
		}
	}
	
	/**
	 * Blink the bulb for one second
	 * @param numberOfTimes you want the bulb blinks
	 */
	public void blink(int numberOfTimes)		{
		this.blink(numberOfTimes, 1000);
	}
}
