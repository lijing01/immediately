package com.tracelijing.immediately.fragment;

import android.support.v4.app.Fragment;

import com.squareup.leakcanary.RefWatcher;
import com.tracelijing.immediately.MyApplication;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 * BaseFragment contaion LeakCanary
 */
public class BaseFragment extends Fragment {
	public void onResume() {
		super.onResume();
	}

	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
		if(refWatcher != null) {
			refWatcher.watch(this);
		}
	}
}
