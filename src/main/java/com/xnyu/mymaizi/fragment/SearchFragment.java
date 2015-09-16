package com.xnyu.mymaizi.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xnyu.mymaizi.R;

/**
 * Created by xnyu on 2015/9/16 0016.
 */
public class SearchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,null);
        return view;
    }
}
