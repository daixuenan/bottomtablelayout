package com.dai.plugin;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dai.plugin.bottomtablelayout.BottomTabLayout;
import com.dai.plugin.bottomtablelayout.bean.TabItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    BottomTabLayout tabLayout;

    private PageFragmentAdapter pageFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        //初始化ViewPager和TableLayout
        List<Fragment> pageList = new ArrayList<>();
        pageList.add(new HomeFragment());
        pageList.add(new MeFragment());
        pageFragmentAdapter = new PageFragmentAdapter(getSupportFragmentManager(), pageList);
        viewPager.setOffscreenPageLimit(pageList.size());
        viewPager.setAdapter(pageFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //添加数据
        List<TabItem> tabItems = new ArrayList<>();
        TabItem tabItem1 = new TabItem(this);
        tabItem1.mText = "首页";
        tabItem1.mUnSelectedIconUrl = "http://img1.imgtn.bdimg.com/it/u=3392580235,766145748&fm=26&gp=0.jpg";
        tabItem1.mSelectedIconUrl = "http://img4.imgtn.bdimg.com/it/u=2267727531,3230746931&fm=26&gp=0.jpg";
        tabItems.add(tabItem1);

        TabItem tabItem2 = new TabItem(this);
        tabItem2.mText = "我的";
        tabItem2.mUnSelectedIconUrl = "http://img4.imgtn.bdimg.com/it/u=2030296515,204221599&fm=26&gp=0.jpg";
        tabItem2.mSelectedIconUrl = "http://img5.imgtn.bdimg.com/it/u=359150190,2955201467&fm=26&gp=0.jpg";
        tabItems.add(tabItem2);

        //绑定数据 注意tabItems数量与Fragment保持一致
        tabLayout.setData(tabItems);
    }
}
