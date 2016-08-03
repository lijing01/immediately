package com.tracelijing.immediately;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class MyApplication extends Application {
	private static Context sContext;
	private static  RefWatcher refWatcher;
	public static RefWatcher getRefWatcher() {
		return refWatcher;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		refWatcher = LeakCanary.install(this);
		MyApplication.sContext = getApplicationContext();
	}


	public static Context getAppContext() {
		return MyApplication.sContext;
	}
}
