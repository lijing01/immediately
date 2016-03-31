package com.tracelijing.tlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class ViewUtil {
	/**
	 * ***********************************************************
	 * findViewById的一种更优雅的写法
	 * 原理:泛型的类型推断
	 * ***********************************************************
	 */
	public static <T extends View> T $(Activity activity, int viewId) {
		return (T) activity.findViewById(viewId);
	}

	public static <T extends View> T $(View view, int viewId) {
		return (T) view.findViewById(viewId);
	}

	public static <T extends View> T $(Dialog dialog, int viewId) {
		return (T) dialog.findViewById(viewId);
	}
}
