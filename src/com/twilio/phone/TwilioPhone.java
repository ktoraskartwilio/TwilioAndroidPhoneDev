/*
 *  Copyright (c) 2011 by Twilio, Inc., all rights reserved.
 *
 *  Use of this software is subject to the terms and conditions of 
 *  the Twilio Terms of Service located at http://www.twilio.com/legal/tos
 */

package com.twilio.phone;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.util.Log;
import com.twilio.client.Connection;
import com.twilio.client.Device;
import com.twilio.client.Twilio;

public class TwilioPhone implements Twilio.InitListener {
	private Device device;
	private Connection connection;
	private String TAG = "TwilioPhone";
	private static String capabilityToken = null;

	public TwilioPhone(Context context) {
		if (Twilio.isInitialized()) {
			Log.d(TAG, "is initialized ");
			return;
		} else
			Twilio.initialize(context, this /* Twilio.InitListener */);
	}

	@Override
	/* Twilio.InitListener method */
	public void onInitialized() {
		Log.d(TAG, "Twilio SDK is ready");
		try {
			capabilityToken = HttpHelper.httpGet(Constants.tokenServerUrl);
			device = Twilio
					.createDevice(capabilityToken, null /* DeviceListener */);
			Log.d(TAG, "Capability Token obtained " + capabilityToken);
		} catch (Exception e) {
			Log.e(TAG,
					"Failed to obtain capability token: "
							+ e.getLocalizedMessage());
		}
	}

	public void disconnect() {
		if (connection != null) {
			Log.d(TAG,
					"Connection state before disconnecting: "
							+ connection.getState());
			connection.disconnect();
		}
	}

	public static void shutDown() {
		Twilio.shutdown();
	}

	public void connect(String phoneNumber, Map<String, String> dataParams) {

		
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			
			/** 
			   If you want to pass a custom object to your webserver to share application context
		   		then add it to the parameters object and it pass it on the connect method 
			 	parameters.put("parameterName", Value);
			 **/
			if (device == null) {
				Log.w(TAG, "Regenerating Capability Token");
				if (capabilityToken == null)
					capabilityToken =
					HttpHelper
							.httpGet(Constants.tokenServerUrl);
				device = Twilio.createDevice(capabilityToken, null);
			}
			connection = device
					.connect(parameters, null /* ConnectionListener */);

			if (connection == null)
				Log.w(TAG, "Failed to create new connection");
			else {
				Log.d(TAG, "Connection is not null - " + connection.getState());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void muteConnection() {
		connection.setMuted(true);
	}

	public void unmuteConnection() {

		connection.setMuted(false);
	}

	@Override
	protected void finalize() {
		if (connection != null) {
			Log.d(TAG,
					"Connection state before disconnecting: "
							+ connection.getState());
			connection.disconnect();
		}
		if (device != null)
			device.release();
	}

	@Override
	public void onError(Exception arg0) {
		// TODO Auto-generated method stub
		Log.e(TAG, "Twilio SDK couldn't start: " + arg0.getLocalizedMessage());
	}
}