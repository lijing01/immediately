package com.tracelijing.immediately.fragment;

import com.squareup.leakcanary.RefWatcher;
import com.tracelijing.immediately.MyApplication;
import com.trello.rxlifecycle.components.RxFragment;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 * BaseFragment contaion LeakCanary
 */
public class BaseFragment extends RxFragment {
	public void onResume() {
		super.onResume();
	}

	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity().getApplication());
		if(refWatcher != null) {
			refWatcher.watch(this);
		}

	}

}
