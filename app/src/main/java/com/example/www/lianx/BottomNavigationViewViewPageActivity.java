package com.example.www.lianx;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.www.lianx.adapter.ViewPageAdapter;
import com.example.www.lianx.fragment.ChatFragment;
import com.example.www.lianx.fragment.ContactFragment;

public class BottomNavigationViewViewPageActivity extends AppCompatActivity implements ChatFragment.OnFragmentInteractionListener,ContactFragment.OnFragmentInteractionListener {


    // viewPager 页面导航
    private ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    m_selectIndex(0);
                    return true;
                case R.id.navigation_dashboard:
                    m_selectIndex(1);
                    return true;
                case R.id.navigation_notifications:
                    m_selectIndex(2);
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


        /*********************************************************************************/

        Toolbar toolbar = findViewById(R.id.activity_tool_bar);

        // 设置标题
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "click return ", Toast.LENGTH_SHORT);

                toast.show();
            }
        });




        /*************************************************************************************/

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.view_page_menu,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    // 重写选项菜单被 点击的函数
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int itemId = item.getItemId();

        switch (itemId){


            case R.id.tool_bar_add:{

                LayoutInflater layoutInflater = getLayoutInflater();

                View view = layoutInflater.inflate(R.layout.tool_bar_menu, null, false);


                Button button = view.findViewById(R.id.tool_bar_menu_add);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"click button ",Toast.LENGTH_SHORT).show();
                    }
                });




                PopupWindow popupWindow = new PopupWindow(view, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);





                // 设置获取焦点
                popupWindow.setFocusable(true);
                // 设置外部可以触控
                popupWindow.setOutsideTouchable(true);
                // 设置显示的位置view
                // 显示的锚点
                View anchor = findViewById(R.id.tool_bar_menu_add);

                //
                popupWindow.showAsDropDown(anchor,0,0);






                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
