package com.tracelijing.immediately.action;

import android.app.Activity;

import com.tracelijing.immediately.net.OkCommonHeaderTool;
import com.tracelijing.immediately.net.OkJsonCallback;
import com.tracelijing.immediately.net.PostJsonRequest;
import com.tracelijing.immediately.utils.UrlManager;
import com.zhy.http.okhttp.utils.L;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class GetUserMessageListAction {
	public static final String GET_USER_TAG = "get_user_tag";
	private Activity mContext;
	private IGetUerMessageCallback iGetUerMessageCallback;

	public GetUserMessageListAction(Activity context, IGetUerMessageCallback getUerMessageCallback) {
		this.mContext = context;
		this.iGetUerMessageCallback = getUerMessageCallback;
	}

	public void call(HashMap<String, String> params) {
		HashMap<String, String> headers = OkCommonHeaderTool.getCommentHeaders(mContext);
		//cookies 信息，之后需要调研如何获取到jike 的cookies 信息
		String cookiesStr = "jike:sess.sig=HPN2GRVryCZ2AWi6iEt3q3hgdZk; jike:sess=eyJfdWlkIjoiNTcwMjAxMTM5OTg1N2IxMTAwYTg1Y2Y1IiwiX3Nlc3Npb25Ub2tlbiI6IlQ1RXFDMTlCbmNGNlZBV3gwMU9uWHIyNG4ifQ==; env=default";
		headers.put("Cookie", cookiesStr);
		String content = OkCommonHeaderTool.hashMapToJson(params);
		PostJsonRequest postJsonRequest = new PostJsonRequest(UrlManager.USER_MESSAGE_LIST, GET_USER_TAG, null, headers, content);
		postJsonRequest.build().execute(new OkJsonCallback() {
			@Override
			public void onError(Call call, Exception e) {
				L.e(e.toString());
			}

			@Override
			public void onResponse(JSONObject response) {
				L.e(response.toString());
			}
		});
	}


	public interface IGetUerMessageCallback {
		void getMessageSuccessBack();

		void getMessageErrorBack();
	}

}
