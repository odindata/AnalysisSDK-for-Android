package com.odin.analysis.demo.ui.activity;

import androidx.viewpager.widget.ViewPager;

import com.odin.analysis.demo.BaseActivity;
import com.odin.analysis.demo.R;
import com.odin.analysis.demo.adapter.PageFragAdapter;
import com.odin.analysis.demo.ui.frag.BaseFragment;
import com.odin.analysis.demo.ui.frag.PageAFragment;
import com.odin.analysis.demo.ui.frag.PageBFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends BaseActivity {

    private List<BaseFragment> mFragmentList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment;
    }

    @Override
    public void initViews() {
        ViewPager mViewPager = findViewById(R.id.viewpager);
        PageFragAdapter pageFragAdapter = new PageFragAdapter(getSupportFragmentManager());

        PageAFragment pageAFragment = PageAFragment.newInstance();
        mFragmentList.add(pageAFragment);
        PageBFragment pageBFragment = PageBFragment.newInstance();
        mFragmentList.add(pageBFragment);

        pageFragAdapter.setFragments(mFragmentList);
        mViewPager.setAdapter(pageFragAdapter);
        mViewPager.setOffscreenPageLimit(1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
