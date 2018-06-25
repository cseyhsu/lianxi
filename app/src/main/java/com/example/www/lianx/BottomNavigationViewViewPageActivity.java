package com.example.www.lianx;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.www.lianx.adapter.ViewPageAdapter;
import com.example.www.lianx.fragment.ChatFragment;
import com.example.www.lianx.fragment.ContactFragment;

public class BottomNavigationViewViewPageActivity extends AppCompatActivity implements ChatFragment.OnFragmentInteractionListener,ContactFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    // viewPager 页面导航
    private ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                 //  mTextMessage.setText(R.string.title_home);
                    m_selectIndex(0);
                    return true;
                case R.id.navigation_dashboard:
                  // mTextMessage.setText(R.string.title_dashboard);
                    m_selectIndex(1);
                    return true;
                case R.id.navigation_notifications:
                    m_selectIndex(2);
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;

                case R.id.navigation_more:{
                    m_selectIndex(3);
                    return true;
                }
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view_view_page);

        mTextMessage = (TextView) findViewById(R.id.message);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        viewPager = findViewById(R.id.viewpager);


        viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager()));


        



        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                switch (itemId){
                    case R.id.navigation_home:{
                        //todo

                        m_selectIndex(0);

                        return true;
                    }

                    case R.id.navigation_dashboard:{
                        // todo

                        m_selectIndex(1);
                        return true;
                    }

                    case R.id.navigation_notifications:{

                        m_selectIndex(2);
                        return true;
                    }

                    case R.id.navigation_more:{
                        m_selectIndex(3);

                        return true;
                    }
                }
                return false;
            }
        });






        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:{
                        navigation.setSelectedItemId(R.id.navigation_home);
                    } break;

                    case 1:{
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                    }break;


                    case 2:{
                        navigation.setSelectedItemId(R.id.navigation_notifications);

                    }break;

                    case 3:{
                        navigation.setSelectedItemId(R.id.navigation_more);
                    } break;

                    default:{

                        // TODO
                    } break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    // 选择页面
    private void m_selectIndex(int position){
        viewPager.setCurrentItem(position,false);
    }
}
