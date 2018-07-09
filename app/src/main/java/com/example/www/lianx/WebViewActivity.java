package com.example.www.lianx;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;


import java.util.Random;

public class WebViewActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        final WebView webView = findViewById(R.id.webview);

        // text = findViewById(R.id.text);
        //   text.setText(""+0);

        webView.loadUrl("http://www.tuween.com/");


        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_fresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // 生成随机数对象, 使用当前的时间毫秒数作为种子
                Random random = new Random(System.currentTimeMillis());
                // 生成一个整型的  随机数
                int i = random.nextInt(100);

                // 如果随机数是偶数
                if (i % 2 == 0) {

                    //   text.setText(""+i);

                    webView.loadUrl("http://www.tuween.com/");

                } else {
                    // text.setText(""+i);
                    // 从本地加载html 文件
                    webView.loadUrl("file:///android_asset/html.html");
                }
                //  修改刷新状态

                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}
