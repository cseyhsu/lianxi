package com.example.www.lianx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // md5加密
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            String string = "helloworld"+System.currentTimeMillis();
            byte[] bytes = md5.digest(string.getBytes());

            System.out.println("原生"+new String(bytes));

            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }

            TextView textView = findViewById(R.id.text_md5);
            textView.setText("md5加密 "+result+" , "+" 原生 "+new String(bytes));
            SharedPreferences sharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();

            edit.putString("pwd",result);

            edit.apply();

            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public void navigation(View view) {

        Intent intent = new Intent(MainActivity.this, BottomNavigationActivity.class);

        startActivity(intent);



    }

    // goto bottom sheet
    public void bottomSheet(View view) {

        Intent intent = new Intent(MainActivity.this, BottomSheetRecyclerViewActivity.class);

        startActivity(intent);
    }

    // 跳转到 view pager activity
    public void viewPage(View view) {

        Intent intent = new Intent(MainActivity.this, ViewPageActivity.class);

        startActivity(intent);
    }

    public void linearBottomSheet(View view) {

        Intent intent = new Intent(MainActivity.this, LinearBottomSheetActivity.class);

        startActivity(intent);
    }

    // 开启底部 sheet dialog
    public void bottomsheetdialog(View view) {

        Intent intent = new Intent(MainActivity.this, BottomSheetDialogActivity.class);

        startActivity(intent);
    }

    // 开启 viewpage 和bottom navigation bar 结合的activity
    public void viewpage_bottomNavigation(View view) {

        Intent intent = new Intent(MainActivity.this, ViewPageBottomNavigationBarActivity.class);

        startActivity(intent);
    }

    public void bottomViewViewPager(View view) {

        Intent intent = new Intent(MainActivity.this, BottomNavigationViewViewPageActivity.class);

        startActivity(intent);
    }


    // 旋转菜单
    public void statelliteMenu(View view) {

        Intent intent = new Intent(MainActivity.this, StateLLiteMenuActivity.class);

        startActivity(intent);

    }

    public void loginActivity(View view) {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);

        startActivity(intent);
    }



    public void tabActivity(View view) {

        Intent intent = new Intent(MainActivity.this, TabActivity.class);

        startActivity(intent);


    }


    // 跳转到全屏activity
    //
    public void fullScreenActivity(View view) {


        Intent intent = new Intent(this, FullscreenActivity.class);

        startActivity(intent);
    }

    public void camera(View view) {


        Intent intent = new Intent(MainActivity.this, ResultIntentActivity.class);



        startActivity(intent);
    }

    public void onLogin(View view) {

        Intent intent = new Intent(MainActivity.this, OnLoginActivity.class);

        startActivity(intent);
    }

    //聊天窗口
    public void chatSample(View view) {


        Intent intent = new Intent(MainActivity.this, ChatDemoActivity.class);

        startActivity(intent);
    }

    public void gallery(View view) {
        Intent intent = new Intent(MainActivity.this, GalleryActivity.class);

        startActivity(intent);
    }

    //跳转到爆炸效果的菜单
    public void boomMenuButton(View view) {

        startActivity(new Intent(MainActivity.this, BoomMenuButtonActivity.class));
    }

    public void CollapsingToolbarLayout(View view) {

        Intent intent = new Intent(this, CollapsingToolbarLayoutActivity.class);

        startActivity(intent);
    }

    public void chatkitDemo(View view) {

        Intent intent = new Intent(this, ChatKitDemoActivity.class);


        startActivity(intent);
    }

    public void viewpage_welcome(View view) {

        Intent intent = new Intent(this, ViewActivity.class);

        startActivity(intent);
    }

    public void snackbarTop(View view) {
        View snack_view = getLayoutInflater().inflate(R.layout.layout_snackbar, null);

        Snackbar snackbar = Snackbar.make(view, "yyyyy", Snackbar.LENGTH_LONG);


        snackbar.setAction("nulll", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"yyyy",Toast.LENGTH_LONG).show();
            }
        });


        snackbar.show();
    }


    public void androidadvanceTopsnackbar(View view) {
        TSnackbar.make(findViewById(android.R.id.content),"Hello from TSnackBar.",TSnackbar.LENGTH_LONG).show();

    }

    // 滑动返回
    public void swipeBack(View view) {

        Intent intent = new Intent(this, MeSwipeBackActivity.class);

        startActivity(intent);
    }


    // google风格的底部导航条
    public void spaceNavigationViewBottom(View view) {

        Intent intent = new Intent(this, SpaceNavigationViewActivity.class);

        startActivity(intent);
    }

    public void webViewZip(View view) {

        Intent intent = new Intent(this, WebViewActivity.class);

        startActivity(intent);
    }
}
