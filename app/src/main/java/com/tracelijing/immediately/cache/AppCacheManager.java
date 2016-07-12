package com.tracelijing.immediately.cache;

import android.content.Context;
import android.os.Environment;

import com.tracelijing.immediately.modle.MessageInfo;

import java.util.ArrayList;

/**
 * Created by Trace (Tapatalk) on 2016/6/21.
 */
public class AppCacheManager {

	public static final String USER_MESSAGE_LIST_CACHE_KEY = "user_message_list_cache_key";
	public static String getDiskCacheDir(Context context) {
		String cachePath = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = context.getExternalCacheDir().getPath();
		} else {
			cachePath = context.getCacheDir().getPath();
		}
		return cachePath;
	}

	public static void saveMessageListData(Context context,ArrayList<MessageInfo> messageInfos){
		ACache aCache = ACache.get(context,getDiskCacheDir(context));
		aCache.put(USER_MESSAGE_LIST_CACHE_KEY,messageInfos);
	}

	public static ArrayList<MessageInfo> getMessageInfo(Context context){
		ACache aCache = ACache.get(context,getDiskCacheDir(context));
		ArrayList<MessageInfo> messageInfos = (ArrayList<MessageInfo>) aCache.getAsObject(USER_MESSAGE_LIST_CACHE_KEY);
		return messageInfos;
	}
}
