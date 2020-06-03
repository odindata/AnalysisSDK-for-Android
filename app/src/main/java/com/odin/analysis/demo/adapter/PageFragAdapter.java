package com.odin.analysis.demo.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.odin.analysis.demo.ui.frag.BaseFragment;

import java.util.List;

public class PageFragAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private List<BaseFragment> fragments;

    public PageFragAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public BaseFragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    public List<BaseFragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<BaseFragment> fragments) {
        this.fragments = fragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
