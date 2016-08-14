package com.dolphin.dolphinsms.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dolphin.dolphinsms.R;
import com.dolphin.dolphinsms.domain.Contact;
import com.dolphin.dolphinsms.fragment.ContactListFragment;
import com.dolphin.dolphinsms.fragment.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ContactListFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Contact contact) {

    }
}
