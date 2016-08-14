package com.dolphin.dolphinsms.lib;

import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;

import com.dolphin.dolphinsms.domain.Contact;

public class SMSSender extends AppCompatActivity {

    public void sendSMS(Contact contact, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(contact.getNumber(), null, message, null, null);
    }

}
