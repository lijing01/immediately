package com.tracelijing.immediately.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.utils.BaseFragment;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class ExploreFragment extends BaseFragment {
	RelativeLayout view;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = (RelativeLayout) inflater.inflate(R.layout.explore_lay, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}