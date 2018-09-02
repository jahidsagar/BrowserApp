package com.example.sagar.browserapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class BrowserTabFragment extends Fragment {
    private Button button_search;
    private EditText url_text;
    private WebView browser;

    private static  final String ARG_SEC_NUMBER = "section_number";

    public static BrowserTabFragment newInstance(int sectionNumber){
        BrowserTabFragment fragment = new BrowserTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SEC_NUMBER , sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_main , container , false);
        button_search = rootview.findViewById(R.id.button1);
        url_text = rootview.findViewById(R.id.edittext1);
        browser = rootview.findViewById(R.id.webview1);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String url = url_text.getText().toString();
                    browser.getSettings().setLoadsImagesAutomatically(true);
                    browser.getSettings().setJavaScriptEnabled(true);
                    browser.setWebViewClient(new WebViewClient());
                    browser.loadUrl(url);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



        return rootview;
    }
}
