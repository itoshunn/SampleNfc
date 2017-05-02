package com.example.itoshun.samplenfc;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Arrays;

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
        Intent intent  = new Intent(this, this.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        // PendingIntent (待機状態の受け取り)
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(), 0, intent, 0);
        // 前面で処理する
        mNfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);

    }

    /**
     * onPause
     * ポーズ状態
     */
    @Override
    protected void onPause() {
        super.onPause();

        // ポーズ時の停止
        mNfcAdapter.disableForegroundDispatch(this);
    }


    /**
     * onNewIntent
     * @param intent
     * 読み込んだ結果を新しい Intent として取得
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        byte[] uid = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);     //  NFC-UID を取得

        // 表示
        setUidText(Arrays.toString(uid));
    }

    /**
     * uid をテキストとして表示
     * @param uid
     */
    private void setUidText( String uid ) {
        String msg = "uid :";

        msg = msg.concat(uid);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
