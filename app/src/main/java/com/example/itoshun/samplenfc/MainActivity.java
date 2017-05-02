package com.example.itoshun.samplenfc;

import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get NFC instance
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }



}
