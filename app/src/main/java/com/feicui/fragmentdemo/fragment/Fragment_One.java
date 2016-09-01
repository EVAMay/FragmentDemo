package com.feicui.fragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feicui.fragmentdemo.R;
import com.feicui.fragmentdemo.adapter.PagerAndTableAdapter;

/**
 * Created by lenovo on 2016/9/1.
 *   app:tabMode="scrollable"布局中需要设置TableLayout的模式，否则会挤在一起
 */
public class Fragment_One extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAndTableAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager= (ViewPager) view.findViewById(R.id.viewPager);
        adapter=new PagerAndTableAdapter(getChildFragmentManager());//参数是获取子碎片管理器
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);//这里与ViewPager关联
    }
}
