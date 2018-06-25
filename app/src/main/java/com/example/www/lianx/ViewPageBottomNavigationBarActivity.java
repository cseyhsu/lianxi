package com.example.www.lianx;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.bumptech.glide.Glide;
import com.example.www.lianx.fragment.ChatFragment;

public class ViewPageBottomNavigationBarActivity extends AppCompatActivity  implements ChatFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_bottom_navigation_bar);


        viewPager = findViewById(R.id.activity_view_page_bottom_navigation_bar);


        bottomNavigationBar = findViewById(R.id.activity_view_page_bottom_navigation_navigation);

        TextBadgeItem textBadgeItem = new TextBadgeItem();

        final BottomNavigationItem bottomNavigationItem = new BottomNavigationItem(R.drawable.bottom_chat_activate, "会话");



        textBadgeItem.setText("23");
        textBadgeItem.setBorderWidth(3);
        textBadgeItem.setHideOnSelect(true);
        textBadgeItem.setAnimationDuration(3000);
        textBadgeItem.setBackgroundColor(R.color.black);
        bottomNavigationItem.setInActiveColor(R.color.colorAccent);
        bottomNavigationItem.setInactiveIcon(getResources().getDrawable(R.drawable.bottom_chat_normal));
        bottomNavigationItem.setActiveColor(R.color.black);
        bottomNavigationItem.setBadgeItem(textBadgeItem);


        bottomNavigationBar.addItem(bottomNavigationItem);

        bottomNavigationBar.setSelected(true);


        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.bottom_main, "首页").setActiveColorResource(R.color.black).setInactiveIcon(getResources().getDrawable(R.drawable.main_inactivate)))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "音乐").setActiveColorResource(R.color.white).setInactiveIcon(getResources().getDrawable(R.drawable.music_normal)))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "游戏").setActiveColorResource(R.color.white))
                .setFirstSelectedPosition(0) // 设置默认选中第一项
                .initialise(); //所有的设置需在调用该方法前完成






      bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){

          @Override
          public void onTabSelected(int position) {
              System.out.println("current + "+ position);
              viewPager.setCurrentItem(position);
          }

          @Override
          public void onTabUnselected(int position) {

          }

          @Override
          public void onTabReselected(int position) {


              viewPager.setCurrentItem(position);

          }
      });



        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {

                return 4;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                bottomNavigationBar.setFirstSelectedPosition(position);
                bottomNavigationBar.initialise();

                if(position %2==0){

                    TextView textView = new TextView(container.getContext());

                    textView.setText("position "+  position);

                    textView.setGravity(Gravity.CENTER);
                    textView.setTextSize(40);

                    viewPager.addView(textView);


                    return textView;

                }

                View v = getLayoutInflater().inflate(R.layout.layout_fragment_containter,null);
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();


                fragment = new ChatFragment();


                transaction.replace(R.id.activity_fragment_container,fragment);

                transaction.commit();




               // viewPager.removeAllViews();

               // viewPager.removeView(findViewById(R.id.activity_fragment_container));

              //  viewPager.removeAllViews();


               // viewPager.addView(findViewById(R.id.activity_fragment_container));


                // viewPager.removeView(findViewById(R.id.activity_fragment_container));


                View view = findViewById(R.id.activity_fragment_container);
                Toast.makeText(getApplicationContext(),"postion "+ position, Toast.LENGTH_SHORT).show();

                System.out.println("tag instantiateItem "+ position);

                return view;

//                ImageView imageView = new ImageView(container.getContext());
//
//                // 加载图片
//                Glide.with(container.getContext()).load("http://cn.bing.com/az/hprichbg/rb/ReichenauSommer_ROW12109751601_1920x1080.jpg").into(imageView);
//
//
//                viewPager.addView(imageView);
//                return imageView;
            }


            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

                //super.destroyItem(container, position, object);
                // todo
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}



