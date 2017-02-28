package com.lupanh.anderson_guerra.lupanhjs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView navegador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navegador = (WebView) findViewById(R.id.navegador);

        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.getSettings().setGeolocationEnabled(true);
        navegador.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        navegador.loadUrl("file:///android_asset/mapa.html");
    }
}
