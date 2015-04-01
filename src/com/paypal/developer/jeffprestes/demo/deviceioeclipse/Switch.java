/**
 * 
 */
package com.paypal.developer.jeffprestes.demo.deviceioeclipse;

import java.io.IOException;

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
}
