package com.tracelijing.immediately.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.widget.GridPicLayout;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class FindArticleFragment extends BaseFragment {
	RelativeLayout view;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = (RelativeLayout) inflater.inflate(R.layout.find_message, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		GridPicLayout gridLayout = new GridPicLayout(getActivity());
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		p.leftMargin = (int)getResources().getDimension(R.dimen.dimen_16);
		p.rightMargin = (int)getResources().getDimension(R.dimen.dimen_16);
		view.addView(gridLayout, p);
	}

}