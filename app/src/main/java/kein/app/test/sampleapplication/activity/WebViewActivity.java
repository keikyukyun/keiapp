package kein.app.test.sampleapplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import kein.app.test.sampleapplication.R;

/**
 * Created by murakamikei on 2016/07/06.
 */
public class WebViewActivity extends ToolbarBaseActivity {
    /**
     * WebView。
     */
    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.webview_layout);
        setupWebView();
    }

    /**
     * WebViewを設定する。
     */
    private void setupWebView() {
        mWebView = (WebView) findViewById(R.id.webView);
        if (mWebView == null) {
            mWebView = new WebView(this);
        }

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onLoadResource(WebView view, String url) {
                if (url.startsWith("aaa")) {
                    this.shouldOverrideUrlLoading(view, url);
                }

                super.onLoadResource(view, url);
            }
        });
    }
}
