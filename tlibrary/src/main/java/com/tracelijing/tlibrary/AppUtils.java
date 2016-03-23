package com.tracelijing.tlibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Trace (Tapatalk) on 2016/2/17.
 * App 相关信息工具类
 */
public class AppUtils {

	/**
	 * 获取当前应用的版本号。
	 *
	 * @return -1 for Exception
	 */
	public static int getAppVersion(Context context) {
		int version;
		if (context != null) {
			try {
				PackageManager manager = context.getPackageManager();
				PackageInfo info = manager.getPackageInfo(context.getPackageName(),
						0);
				version = info.versionCode;
			} catch (Exception e) {
				version = -1;
			}
		} else {
			version = -1;
		}

		return version;
	}

	public static String getAppVersionString(Context context) {
		if (context == null) {
			return "";
		}

		try {
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
			return info.versionName;
		} catch (Exception e) {
			return "";
		}
	}
}
