package com.tracelijing.immediately.net;

/**
 * Created by Trace (Tapatalk) on 2016/3/23.
 */

import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;


/**
 * Created by Trace (Tapatalk) on 2016/3/22.
 */
public class OkHttpAction {
	private Context mContext;

	public OkHttpAction(Context context) {
		this.mContext = context;
	}

	public void getJsonObjectAction(final String callUrl, final ActionCallBack callBack) {
		OkHttpUtils.get().url(callUrl).build().execute(new OkJsonCallback() {
			@Override
			public void onError(Call call, Exception e) {
				callBack.actionErrorBack(call, e);
			}

			@Override
			public void onResponse(JSONObject response) {
				callBack.actionCallBack(response);
			}
		});
	}

	public void getJsonArrayAction(final String callUrl, final ActionCallBack callBack) {
		OkHttpUtils.get().url(callUrl).build().execute(new OkJsonArrayCallback() {
			@Override
			public void onError(Call call, Exception e) {
				callBack.actionErrorBack(call, e);
			}

			@Override
			public void onResponse(JSONArray response) {
				callBack.actionCallBack(response);
			}
		});
	}

	public void postJsonObjectAction(final String callUrl, final HashMap<String, String> param,
									 final ActionCallBack callBack) {
		OkHttpUtils.post().url(callUrl).params(param).build().execute(new OkJsonCallback() {
			@Override
			public void onError(Call call, Exception e) {
				callBack.actionErrorBack(call, e);
			}

			@Override
			public void onResponse(JSONObject response) {
				callBack.actionCallBack(response);
			}
		});
	}

	/**
	 * 和 getJsonArrayPostAction 对应
	 **/
	public void postJsonArrayPostAction(final String callUrl, final HashMap<String, String> param,
										final ActionCallBack callBack) {
		OkHttpUtils.post().url(callUrl).params(param).build().execute(new OkJsonArrayCallback() {
			@Override
			public void onError(Call call, Exception e) {
				callBack.actionErrorBack(call, e);
			}

			@Override
			public void onResponse(JSONArray response) {
				callBack.actionCallBack(response);
			}
		});
	}

	public void deleteJsonObjectAction(final String callUrl, final ActionCallBack callBack) {
		OkHttpUtils.delete().url(callUrl).build().execute(new OkJsonCallback() {
			@Override
			public void onError(Call call, Exception e) {
				callBack.actionErrorBack(call, e);
			}

			@Override
			public void onResponse(JSONObject response) {
				callBack.actionCallBack(response);
			}
		});
	}

	public void putJsonObjectAction(final String callUrl, final ActionCallBack callBack) {
		OkHttpUtils.put().url(callUrl).build().execute(new OkJsonCallback() {
			@Override
			public void onError(Call call, Exception e) {
				callBack.actionErrorBack(call, e);
			}

			@Override
			public void onResponse(JSONObject response) {
				callBack.actionCallBack(response);
			}
		});
	}


	public interface ActionCallBack {
		void actionCallBack(Object result);

		void actionErrorBack(Call call, Exception e);
	}
}
