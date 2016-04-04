package com.tracelijing.immediately;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class MyApplication extends Application {
	public static RefWatcher getRefWatcher(Context context) {
		try {
			MyApplication application = (MyApplication) context.getApplicationContext();
			return application.refWatcher;
		}catch (Exception e){
			return null;
		}
	}

	private RefWatcher refWatcher;

	@Override
	public void onCreate() {
		super.onCreate();
		refWatcher = LeakCanary.install(this);
	}
}
