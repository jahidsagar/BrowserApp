package com.example.sagar.browserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button click;
    EditText urlname;
    WebView browser_android;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operUrl();


    }
    public void operUrl(){
        click = findViewById(R.id.button1);
        urlname = findViewById(R.id.edittext1);
        browser_android = findViewById(R.id.webview1);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String url = urlname.getText().toString();
                    browser_android.getSettings().setLoadsImagesAutomatically(true);
                    browser_android.getSettings().setJavaScriptEnabled(true);
                    browser_android.setWebViewClient(new WebViewClient());
                    browser_android.loadUrl(url);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
