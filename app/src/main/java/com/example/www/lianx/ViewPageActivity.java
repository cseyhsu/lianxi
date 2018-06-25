package com.example.www.lianx;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);


        final ViewPager viewPager = findViewById(R.id.view_page_container);

        // 设置viewpager的适配器
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                if(position == 0){
                    View view = LayoutInflater.from(ViewPageActivity.this).inflate(R.layout.view_page_welcome, null);

                    viewPager.addView(view);
                    return view;
                }

                if(position == 1){
                    TextView tv = new TextView(ViewPageActivity.this);

                    tv.setText("hello View Pager");

                    viewPager.addView(tv);

                    return tv;
                }

                final ImageView imageView = new ImageView(ViewPageActivity.this);
                Glide.with(ViewPageActivity.this).load("http://cn.bing.com/az/hprichbg/rb/ReichenauSommer_ROW12109751601_1920x1080.jpg").into(imageView);

                new Thread(){
                    @Override
                    public void run() {

                        //
                    }
                    // 加载图片
                }.start();
                viewPager.addView(imageView, position, ViewGroup.LayoutParams.MATCH_PARENT);
                return imageView;
            }
        });
    }
}
