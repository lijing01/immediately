package com.tracelijing.immediately;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class MyApplication extends Application {
	private static  RefWatcher refWatcher;
	public static RefWatcher getRefWatcher(Application context) {
		if(refWatcher == null){
			refWatcher = LeakCanary.install(context);
		}
		return refWatcher;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		refWatcher = LeakCanary.install(this);
	}
}
