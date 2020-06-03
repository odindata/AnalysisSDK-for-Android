package com.odin.analysis.demo.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.odin.analysis.demo.R;

public abstract class BaseFragment extends Fragment {

    protected View view = null;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), null);
            initData();
            initHeaderView(view);
            initView(view);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    private void initHeaderView(View view) {
        ImageView mImgBack = view.findViewById(R.id.img_header_back);
        if (mImgBack != null) {
            mImgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
        }
        TextView mTvTitle = view.findViewById(R.id.tv_header_title);
        mTvTitle.setText(getTitle());
    }

    public abstract String getName();

    public abstract String getTitle();

    public abstract void initView(View mView);

    public abstract void initData();

    public abstract int getLayoutId();

}
