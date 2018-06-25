package com.example.www.lianx;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;

import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.www.lianx.fragment.ChatFragment;


public class BottomNavigationActivity extends AppCompatActivity implements ChatFragment.OnFragmentInteractionListener {

    Fragment fragment;
    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        // 设置显示模式
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_DEFAULT);

        bottomNavigationBar.setBackgroundResource(R.drawable.bottom_main);

        bottomNavigationBar.setBackgroundColor(getResources().getColor(R.color.black));
        // 设置背景
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);


        // 设置激活的颜色
        bottomNavigationBar.setActiveColor(R.color.colorAccent);

       // new BottomNavigationItem()

        final BottomNavigationItem bottomNavigationItem = new BottomNavigationItem(R.drawable.bottom_chat_activate, "会话");




        TextBadgeItem textBadgeItem = new TextBadgeItem();

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




        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();


                fragment = new ChatFragment();

                fragmentTransaction.replace(R.id.fragment_container,fragment);

                fragmentTransaction.commit();

                System.out.println("onTabSelected : " + position);





            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


        ShapeBadgeItem badgeItem = new ShapeBadgeItem();
        badgeItem.setGravity(Gravity.CENTER);


        badgeItem.setAnimationDuration(200);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.bottom_main, "首页").setActiveColorResource(R.color.black).setInactiveIcon(getResources().getDrawable(R.drawable.main_inactivate)))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "音乐").setActiveColorResource(R.color.white).setInactiveIcon(getResources().getDrawable(R.drawable.music_normal)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "电影").setActiveColorResource(R.color.white).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "游戏").setActiveColorResource(R.color.white))
                .setFirstSelectedPosition(0) // 设置默认选中第一项
                .initialise(); //所有的设置需在调用该方法前完成




      //  bottomNavigationBar.show();


        bottomNavigationBar.toggle(true);




    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // todo
    }
}
