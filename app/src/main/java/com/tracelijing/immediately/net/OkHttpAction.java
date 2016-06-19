package com.tracelijing.immediately.net;

/**
 * Created by Trace (Tapatalk) on 2016/3/23.
 */

import android.content.Context;

import com.tracelijing.immediately.MyApplication;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;


/**
 * Created by Trace (Tapatalk) on 2016/3/22.
 */
public class OkHttpAction {
	private Context mContext;
	public static final String URL_TAG = "trace_call";

	public OkHttpAction(Context context) {
		this.mContext = context;
	}

	public void postJsonObjectAction(final String callUrl, final HashMap<String, String> params,
									 final ActionCallBack callBack) {
		try {
			// Create a trust manager that does not validate certificate chains
			MyApplication.getOkHttpClient();
			HashMap<String, String> headers = OkCommonHeaderTool.getCommentHeaders(mContext);
			String content = OkCommonHeaderTool.hashMapToJson(params);
			PostJsonRequest postJsonRequest = new PostJsonRequest(callUrl, URL_TAG, null, headers, content,content.hashCode());
			postJsonRequest.build().execute(new OkJsonCallback() {
				@Override
				public void onError(Call call, Exception e, int id) {
					callBack.actionErrorBack(call, e);
				}

				@Override
				public void onResponse(JSONObject response, int id) {
					callBack.actionCallBack(response);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public interface ActionCallBack {
		void actionCallBack(Object result);

		void actionErrorBack(Call call, Exception e);
	}
}
