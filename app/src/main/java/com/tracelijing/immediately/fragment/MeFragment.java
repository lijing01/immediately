package com.tracelijing.immediately.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tracelijing.immediately.R;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class MeFragment extends BaseFragment{
	View view;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.me_lay,container,false);
		return view;
	}
}
