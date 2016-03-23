package com.tracelijing.immediately.net;

import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONArray;

import okhttp3.Response;

/**
 * Created by Trace (Tapatalk) on 2016/3/22.
 */
public abstract class OkJsonArrayCallback extends Callback<JSONArray> {
	@Override
	public JSONArray parseNetworkResponse(Response response) throws Exception
	{
		return new JSONArray(response.body().string());
	}

}
