package com.example.itoshun.samplenfc;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NfcAdapter mNfcAdapter;

    /**
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get NFC instance
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    /**
     * onResume
     * レジューム機能
     */
    @Override
    protected void onResume() {
        super.onResume();

        // NFC Intent の作成
        Intent intent  = new Intent(new, this.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        // PendingIntent (待機状態の受け取り)
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(), 0, intent, 0);
        // 前面で処理する
        mNfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);

    }

}
