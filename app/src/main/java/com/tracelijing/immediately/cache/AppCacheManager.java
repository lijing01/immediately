package com.tracelijing.immediately.cache;

import android.content.Context;
import android.os.Environment;

import com.tracelijing.immediately.modle.MessageInfo;

import java.util.ArrayList;

/**
 * Created by Trace (Tapatalk) on 2016/6/21.
 */
public class AppCacheManager {
	public String getDiskCacheDir(Context context) {
		String cachePath = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = context.getExternalCacheDir().getPath();
		} else {
			cachePath = context.getCacheDir().getPath();
		}
		return cachePath;
	}

	public void saveMessageListData(Context context,String key,ArrayList<MessageInfo> messageInfos){
		ACache aCache = ACache.get(context,getDiskCacheDir(context));
		aCache.put(key,messageInfos);
	}
}
