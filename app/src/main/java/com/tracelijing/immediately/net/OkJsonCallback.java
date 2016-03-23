package com.tracelijing.immediately.net;

import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import okhttp3.Response;

/**
 * Created by Trace (Tapatalk) on 2016/3/22.
 */
public abstract class OkJsonCallback extends Callback<JSONObject> {
	@Override
	public JSONObject parseNetworkResponse(Response response) throws Exception
	{
		return new JSONObject(response.body().string());
	}

}
