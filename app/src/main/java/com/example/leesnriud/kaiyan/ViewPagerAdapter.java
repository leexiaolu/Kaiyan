package com.example.leesnriud.kaiyan;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String titles[] = new String[]{ "首页", "作品", "动态"};
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    //设置不同的fragment，考虑第一个fragment的页面与后面两个不一样
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new OneFragment();
            Bundle bundle=new Bundle();
            bundle.putString("title",titles[position]);
            fragment.setArguments(bundle);
        }else{
            fragment = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title",titles[position]);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}