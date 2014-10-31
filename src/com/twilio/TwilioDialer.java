/*
 *  Copyright (c) 2011 by Twilio, Inc., all rights reserved.
 *
 *  Use of this software is subject to the terms and conditions of 
 *  the Twilio Terms of Service located at http://www.twilio.com/legal/tos
 */

package com.twilio;

import java.util.HashMap;
import java.util.Map;

import com.twilio.example.hellomonkey.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class TwilioDialer extends Activity implements OnClickListener
{
    private MonkeyPhone phone;
    private EditText numberField;

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main);

        phone = new MonkeyPhone(getApplicationContext());

//        Button dialButton = (Button)findViewById(R.id.buttonCall);
//        dialButton.setOnClickListener(this);
//
//        Button hangupButton = (Button)findViewById(R.id.buttonHangup);
//        hangupButton.setOnClickListener(this);

        numberField = (EditText)findViewById(R.id.numberField);
        
//        // initialize dialPad buttons
//        Button dialPad0 = (Button)findViewById(R.id.button0);
//        dialPad0.setOnClickListener(this);
//        Button dialPad1 = (Button)findViewById(R.id.button1);
//        dialPad1.setOnClickListener(this);
//        Button dialPad2 = (Button)findViewById(R.id.button2);
//        dialPad2.setOnClickListener(this);
//        Button dialPad3 = (Button)findViewById(R.id.button3);
//        dialPad3.setOnClickListener(this);
//        Button dialPad4 = (Button)findViewById(R.id.button4);
//        dialPad4.setOnClickListener(this);
//        Button dialPad5 = (Button)findViewById(R.id.button5);
//        dialPad5.setOnClickListener(this);
//        Button dialPad6 = (Button)findViewById(R.id.button6);
//        dialPad6.setOnClickListener(this);
//        Button dialPad7 = (Button)findViewById(R.id.button7);
//        dialPad7.setOnClickListener(this);
//        Button dialPad8 = (Button)findViewById(R.id.button8);
//        dialPad8.setOnClickListener(this);
//        Button dialPad9 = (Button)findViewById(R.id.button9);
//        dialPad9.setOnClickListener(this);
//        
    }

    @Override
    public void onClick(View view)
    {
    
//	      switch(view.getId()) {
//	        case R.id.button0:
//	        	numberField.append("0");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button1:
//	        	numberField.append("1");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button2:
//	        	numberField.append("2");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button3:
//	        	numberField.append("3");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button4:
//	        	numberField.append("4");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button5:
//	        	numberField.append("5");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button6:
//	        	numberField.append("6");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.button7:
//	        	numberField.append("7");
//	        	numberField.requestFocus();
//	          break;
//	       case R.id.button8:
//	    	    numberField.append("8");
//	    	    numberField.requestFocus();
//	          break;
//	        case R.id.button9:
//	        	numberField.append("9");
//	        	numberField.requestFocus();
//	          break;
//	        case R.id.buttonCall:
//	        	String phoneNumber = numberField.getText().toString();
//	        	Map<String, String> phoneNumberMap = new HashMap<String, String>();
//	        	phoneNumberMap.put("phoneNumber", phoneNumber);
//	            phone.connect(phoneNumber, null);
//	          break;
//	        case R.id.buttonHangup:
//	        	phone.disconnect();
//	          break;
//	      }
    }
    
}


