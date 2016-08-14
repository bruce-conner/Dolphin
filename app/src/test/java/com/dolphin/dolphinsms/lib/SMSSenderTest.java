package com.dolphin.dolphinsms.lib;

import android.telephony.SmsManager;

import com.dolphin.dolphinsms.BuildConfig;
import com.dolphin.dolphinsms.domain.Contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowSmsManager;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SMSSenderTest {

    private SMSSender smsSender;

    @Before
    public void setUp() {
        smsSender = Robolectric.setupActivity(SMSSender.class);
    }

    @Test
    public void sendSMSSendsSMSToSpecifiedNumber() {
        String expectedPhoneNumber = "3307141437";
        String expectedMessage = "Yo Dawg";

        Contact contact = new Contact(expectedPhoneNumber, "Arbitrary Name");

        smsSender.sendSMS(contact, expectedMessage);

        ShadowSmsManager shadowSmsManager = shadowOf(SmsManager.getDefault());
        ShadowSmsManager.TextSmsParams lastSentTextMessageParams = shadowSmsManager.getLastSentTextMessageParams();

        assertEquals(expectedPhoneNumber, lastSentTextMessageParams.getDestinationAddress());
        assertEquals(expectedMessage, lastSentTextMessageParams.getText());
    }
}
