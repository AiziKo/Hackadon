package com.sumup.sdksampleapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.MediaController;
import android.widget.VideoView;
import com.sumup.merchant.Models.TransactionInfo;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpLogin;
import com.sumup.merchant.api.SumUpPayment;
import android.net.Uri;
import java.math.BigDecimal;
import java.util.UUID;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_LOGIN = 1;
    private static final int REQUEST_CODE_PAYMENT = 2;
    private static final int REQUEST_CODE_PAYMENT_SETTINGS = 3;

    private TextView mResultCode;
    private TextView mResultMessage;
    private TextView mTxCode;
    private TextView mReceiptSent;
    private TextView mTxInfo;
    private int TotalDonation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Please go to https://me.sumup.com/developers to get your Affiliate Key by entering the application ID of your app. (e.g. com.sumup.sdksampleapp)
        SumUpLogin sumupLogin = SumUpLogin.builder("7ca84f17-84a5-4140-8df6-6ebeed8540fc").build();
        SumUpAPI.openLoginActivity(MainActivity.this, sumupLogin, REQUEST_CODE_LOGIN);

        TextView tv = (TextView)findViewById(R.id.counter);
        tv.setText("0 0 0 0 0 €");
       /* Button logMerchant = (Button) findViewById(R.id.button_log_merchant);
        logMerchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!SumUpAPI.isLoggedIn()) {
                    mResultCode.setText("Result code: " + SumUpAPI.Response.ResultCode.ERROR_NOT_LOGGED_IN);
                    mResultMessage.setText("Message: Not logged in");
                } else {
                    mResultCode.setText("Result code: " + SumUpAPI.Response.ResultCode.SUCCESSFUL);
                    mResultMessage.setText(
                            String.format("Currency: %s, Merchant Code: %s", SumUpAPI.getCurrentMerchant().getCurrency().getIsoCode(),
                                    SumUpAPI.getCurrentMerchant().getMerchantCode()));
                }
            }
        });
*/
        ImageButton btnCharge1 = (ImageButton) findViewById(R.id.button_charge_1);
        btnCharge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpPayment payment = SumUpPayment.builder()
                        // mandatory parameters
                        .total(new BigDecimal("1.00")) // minimum 1.00
                        .currency(SumUpPayment.Currency.EUR)
                        // optional: add details
                        .title("Entrepreneurs du monde")
                        .receiptEmail("email")
                        .receiptSMS("téléphone")
                        // optional: Add metadata
                        // optional: foreign transaction ID, must be unique!
                        .foreignTransactionId(UUID.randomUUID().toString()) // can not exceed 128 chars
                        .build();

                SumUpAPI.checkout(MainActivity.this, payment, REQUEST_CODE_PAYMENT);
                TotalDonation = TotalDonation + 1;
                TextView tv = (TextView)findViewById(R.id.counter);
                tv.setText(Integer.toString(TotalDonation));
            }
        });

        ImageButton btnCharge2 = (ImageButton) findViewById(R.id.button_charge_2);
        btnCharge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpPayment payment = SumUpPayment.builder()
                        // mandatory parameters
                        .total(new BigDecimal("2.00")) // minimum 1.00
                        .currency(SumUpPayment.Currency.EUR)
                        // optional: add details
                        .title("Entrepreneurs du monde")
                        .receiptEmail("email")
                        .receiptSMS("téléphone")
                        // optional: Add metadata
                        // optional: foreign transaction ID, must be unique!
                        .foreignTransactionId(UUID.randomUUID().toString()) // can not exceed 128 chars
                        .build();

                SumUpAPI.checkout(MainActivity.this, payment, REQUEST_CODE_PAYMENT);
                TotalDonation = TotalDonation + 2;
                TextView tv = (TextView)findViewById(R.id.counter);
                tv.setText(Integer.toString(TotalDonation));
            }
        });

        ImageButton btnCharge5 = (ImageButton) findViewById(R.id.button_charge_5);
        btnCharge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpPayment payment = SumUpPayment.builder()
                        // mandatory parameters
                        .total(new BigDecimal("5.00")) // minimum 1.00
                        .currency(SumUpPayment.Currency.EUR)
                        // optional: add details
                        .title("Entrepreneurs du monde")
                        .receiptEmail("email")
                        .receiptSMS("téléphone")
                        // optional: Add metadata
                        // optional: foreign transaction ID, must be unique!
                        .foreignTransactionId(UUID.randomUUID().toString()) // can not exceed 128 chars
                        .build();

                SumUpAPI.checkout(MainActivity.this, payment, REQUEST_CODE_PAYMENT);
                TotalDonation = TotalDonation + 5;
                TextView tv = (TextView)findViewById(R.id.counter);
                tv.setText(Integer.toString(TotalDonation));
            }
        });

        ImageButton btnCharge10 = (ImageButton) findViewById(R.id.button_charge_10);
        btnCharge10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpPayment payment = SumUpPayment.builder()
                        // mandatory parameters
                        .total(new BigDecimal("10.00")) // minimum 1.00
                        .currency(SumUpPayment.Currency.EUR)
                        // optional: add details
                        .title("Entrepreneurs du monde")
                        .receiptEmail("email")
                        .receiptSMS("téléphone")
                        // optional: Add metadata
                        // optional: foreign transaction ID, must be unique!
                        .foreignTransactionId(UUID.randomUUID().toString()) // can not exceed 128 chars
                        .build();

                SumUpAPI.checkout(MainActivity.this, payment, REQUEST_CODE_PAYMENT);
                TotalDonation = TotalDonation + 10;
                TextView tv = (TextView)findViewById(R.id.counter);
                String tmp2 = Integer.toString(TotalDonation) + "€";
                String tmp = "0 0 0 0" + tmp2 + " €";
                tv.setText(tmp);
            }
        });

      /*  Button paymentSettings = (Button) findViewById(R.id.button_payment_settings);
        paymentSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpAPI.openPaymentSettingsActivity(MainActivity.this, REQUEST_CODE_PAYMENT_SETTINGS);
            }
        });

        Button prepareCardTerminal = (Button) findViewById(R.id.button_prepare_card_terminal);
        prepareCardTerminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpAPI.prepareForCheckout();
            }
        });*/
/*
        Button btnLogout = (Button) findViewById(R.id.button_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumUpAPI.logout();
            }
        });
*/
        // VIDEO HANDLER
        VideoView videoView = findViewById(R.id.video_asso);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.spot_asso;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(null);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.setVolume(0f,0f);
            }
        });



    }
}