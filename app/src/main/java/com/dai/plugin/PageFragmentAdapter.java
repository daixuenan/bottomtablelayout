package com.dai.plugin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 2017/3/7.
 */

public class PageFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public PageFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void refresh(List<Fragment> fragmentList) {
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    public boolean onBackPressed() {
        boolean isBack = true;
        return isBack;
    }

}
