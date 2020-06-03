package com.odin.analysis.demo.ui.frag;

import android.view.View;

import com.odin.analysis.demo.R;

public class PageAFragment extends BaseFragment {

    public static final String NAME = PageAFragment.class.getSimpleName();

    public static PageAFragment newInstance() {
        return new PageAFragment();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "PageA";
    }

    @Override
    public void initView(View mView) {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_pagea;
    }

}
