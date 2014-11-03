/*
 *  Copyright (c) 2011 by Twilio, Inc., all rights reserved.
 *
 *  Use of this software is subject to the terms and conditions of 
 *  the Twilio Terms of Service located at http://www.twilio.com/legal/tos
 */

package com.twilio.phone;

import java.util.HashMap;
import java.util.Map;

import com.twilio.phone.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class TwilioDialer extends Activity implements OnClickListener,
		OnLongClickListener {
	private TwilioPhone phone;
	private EditText numberField;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main);

		// initialize a Twilio Phone instance
		phone = new TwilioPhone(getApplicationContext());
		
		// initialize the Number textpad
		numberField = (EditText) findViewById(R.id.numberField);
		Button cancelKey = (Button) findViewById(R.id.clearTextBtn);
		cancelKey.setOnClickListener(this);
		Button cancelKeyLongPress = (Button) findViewById(R.id.clearTextBtn);
		cancelKeyLongPress.setOnLongClickListener(this);

		// initialize dialPad buttons
		Button dialPad0 = (Button) findViewById(R.id.dialKey0);
		dialPad0.setOnClickListener(this);
		Button dialPad1 = (Button) findViewById(R.id.dialKey1);
		dialPad1.setOnClickListener(this);
		Button dialPad2 = (Button) findViewById(R.id.dialKey2);
		dialPad2.setOnClickListener(this);
		Button dialPad3 = (Button) findViewById(R.id.dialKey3);
		dialPad3.setOnClickListener(this);
		Button dialPad4 = (Button) findViewById(R.id.dialKey4);
		dialPad4.setOnClickListener(this);
		Button dialPad5 = (Button) findViewById(R.id.dialKey5);
		dialPad5.setOnClickListener(this);
		Button dialPad6 = (Button) findViewById(R.id.dialKey6);
		dialPad6.setOnClickListener(this);
		Button dialPad7 = (Button) findViewById(R.id.dialKey7);
		dialPad7.setOnClickListener(this);
		Button dialPad8 = (Button) findViewById(R.id.dialKey8);
		dialPad8.setOnClickListener(this);
		Button dialPad9 = (Button) findViewById(R.id.dialKey9);
		dialPad9.setOnClickListener(this);
		Button dialButton = (Button) findViewById(R.id.buttonCall);
		dialButton.setOnClickListener(this);
		Button hangupButton = (Button) findViewById(R.id.buttonHangup);
		hangupButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.dialKey0:
			numberField.append("0");
			numberField.requestFocus();
			break;
		case R.id.dialKey1:
			numberField.append("1");
			numberField.requestFocus();
			break;
		case R.id.dialKey2:
			numberField.append("2");
			numberField.requestFocus();
			break;
		case R.id.dialKey3:
			numberField.append("3");
			numberField.requestFocus();
			break;
		case R.id.dialKey4:
			numberField.append("4");
			numberField.requestFocus();
			break;
		case R.id.dialKey5:
			numberField.append("5");
			numberField.requestFocus();
			break;
		case R.id.dialKey6:
			numberField.append("6");
			numberField.requestFocus();
			break;
		case R.id.dialKey7:
			numberField.append("7");
			numberField.requestFocus();
			break;
		case R.id.dialKey8:
			numberField.append("8");
			numberField.requestFocus();
			break;
		case R.id.dialKey9:
			numberField.append("9");
			numberField.requestFocus();
			break;
		case R.id.dialKeyPound:
			numberField.append("#");
			numberField.requestFocus();
			break;
		case R.id.dialKeyStar:
			numberField.append("*");
			numberField.requestFocus();
			break;			
		case R.id.buttonCall:
			String phoneNumber = numberField.getText().toString();
			Map<String, String> phoneNumberMap = new HashMap<String, String>();
			phoneNumberMap.put("phoneNumber", phoneNumber);
			phone.connect(phoneNumber, null);
			break;
		case R.id.buttonHangup:
			phone.disconnect();
			break;
		case R.id.clearTextBtn:
			String numberFieldText = numberField.getText().toString().trim();
			if (numberFieldText.length() != 0) {
				numberFieldText = numberFieldText.substring(0,
						numberFieldText.length() - 1);

				numberField.setText(numberFieldText);
			}
		}
	}

	@Override
	public boolean onLongClick(View v) {
		// On long click, clear the number 
		String numberFieldText = "";
		numberField.setText(numberFieldText);
		return false;
	}

}
