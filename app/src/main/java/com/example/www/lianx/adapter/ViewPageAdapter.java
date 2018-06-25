package com.example.www.lianx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.www.lianx.fragment.ChatFragment;
import com.example.www.lianx.fragment.ContactFragment;

// view pageAdapter
public class ViewPageAdapter extends FragmentPagerAdapter {

    //由于页面已经固定,故这里把Adapter需要的fragment提前创建
    private Fragment[] mFragments = new Fragment[]{new ChatFragment(), new ChatFragment(), new ContactFragment(),new ContactFragment()};

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {



        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }
}
