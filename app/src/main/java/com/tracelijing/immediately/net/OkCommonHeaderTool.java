package com.tracelijing.immediately.net;

import android.content.Context;

import com.tracelijing.tlibrary.AppUtils;
import com.tracelijing.tlibrary.PhoneUtil;

import java.util.HashMap;

/**
 * Created by Trace (Tapatalk) on 2016/3/23.
 */
public class OkCommonHeaderTool {
	public static HashMap<String,String> hashMap;
	public static HashMap<String,String> getCommentHeaders(Context context){
		if(hashMap == null) {
			hashMap = new HashMap<>();
			hashMap.put("Manufacturer", PhoneUtil.getBrand());
			hashMap.put("OS-Version", PhoneUtil.getVersion());
			hashMap.put("Model", PhoneUtil.getModel());
			hashMap.put("OS", "android");
			hashMap.put("App-BuildNo", AppUtils.getAppVersionString(context));
			hashMap.put("App-Version", String.valueOf(AppUtils.getAppVersion(context)));
			hashMap.put("Host:", "app.jike.ruguoapp.com");
			hashMap.put("Accept-Encoding", "gzip");
		}
		return hashMap;
	}
}
