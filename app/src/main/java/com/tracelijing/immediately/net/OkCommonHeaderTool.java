package com.tracelijing.immediately.net;

import android.content.Context;

import com.tracelijing.tlibrary.PhoneUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
			hashMap.put("App-BuildNo", "117");
			hashMap.put("App-Version", "2.4.0.2");
			hashMap.put("Host:", "app.jike.ruguoapp.com");
//			hashMap.put("Accept-Encoding", "gzip");
		}
		return hashMap;
	}

	public static String hashMapToJson(HashMap map) {
		String string = "{";
		for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry e = (Map.Entry) it.next();
			string += "\""+ e.getKey() + "\":";
			string += "\"" + e.getValue() + "\",";
		}
		string = string.substring(0, string.lastIndexOf(","));
		string += "}";
		return string;
	}
}
