package com.feicui.fragmentdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.feicui.fragmentdemo.fragment.Fragment_Two;

/**
 * Created by lenovo on 2016/9/1.
 */
public class PagerAndTableAdapter extends FragmentPagerAdapter {


    public PagerAndTableAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment_Two();//注意，这里必须填充一个Fragment否则获取子碎片管理器那里会空指针，并且不能是本身的Fragment，否则会堆栈溢出报错
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Type"+(position+1);
    }
}
