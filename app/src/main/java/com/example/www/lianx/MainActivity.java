package com.example.www.lianx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
