package com.dolphin.dolphinsms.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.dolphin.dolphinsms.R;
import com.dolphin.dolphinsms.domain.Contact;
import com.dolphin.dolphinsms.fragment.ContactListFragment;

public class MainActivity extends AppCompatActivity implements ContactListFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {

        // Request permission for read contacts, this can probably be broken off
        // into its own function and then called here for code cleanliness
        if (ContextCompat.checkSelfPermission(MainActivity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity, Manifest.permission.READ_CONTACTS)) {
                // Show message regarding permission if needed
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(MainActivity, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }
    }

    @Override
    public void onListFragmentInteraction(Contact contact) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    // Carry on with Bootycalling
                } else {
                    // Permission Denied
                }
                return;
            }
        }
    }

}
