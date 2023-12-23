package com.hackathon.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class FirstAidActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid1);
WebView webView = findViewById(R.id.web);

String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/4e7evinsfm0?si=wMoX3RCIrSLgsbK4\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
webView.loadData(video,"text/html","utf-8");
webView.getSettings().setJavaScriptEnabled(true);
webView.setWebChromeClient(new WebChromeClient());


    }
}