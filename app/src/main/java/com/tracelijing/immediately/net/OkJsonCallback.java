package com.tracelijing.immediately.net;

import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import okhttp3.Response;

/**
 * Created by Trace (Tapatalk) on 2016/3/22.
 */
public abstract class OkJsonCallback extends Callback<JSONObject> {
	@Override
	public JSONObject parseNetworkResponse(Response response,final int id) throws Exception
	{
		String resultStr = response.body().string();
		JSONObject resultJ = new JSONObject(resultStr);
		return resultJ;
	}

}
