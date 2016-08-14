package com.dolphin.dolphinsms.activity;

import com.dolphin.dolphinsms.BuildConfig;
import com.dolphin.dolphinsms.activity.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {
    @Test
    public void mainActivityCanBeCreated() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);

        assertNotNull(mainActivity);
    }
}