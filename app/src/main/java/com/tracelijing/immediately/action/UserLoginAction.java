package com.tracelijing.immediately.action;

import android.content.Context;

import com.tracelijing.immediately.net.OkCommonHeaderTool;
import com.tracelijing.immediately.net.OkJsonCallback;
import com.tracelijing.immediately.net.PostJsonRequest;
import com.tracelijing.immediately.utils.UrlManager;
import com.zhy.http.okhttp.utils.L;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class UserLoginAction {
	public static final String USER_LOGIN_ACTION = "user_login_action";
	private Context mContext;
	private IUserLoginCallback iUserLoginCallback;

	public UserLoginAction(Context context,IUserLoginCallback userLoginCallback){
		this.mContext = context;
		this.iUserLoginCallback = userLoginCallback;
	}


	public void call(HashMap<String, String> params) {
		HashMap<String, String> headers = OkCommonHeaderTool.getCommentHeaders(mContext);
//		String cookiesStr = "jike:sess.sig=OchC-Ss6qa1z3byv-0Xw1fIqokc; jike:sess=eyJfdWlkIjoiNTcwMjJkMGM0ZjkzYjkxMjAwMTUzOWJjIiwiX3Nlc3Npb25Ub2tlbiI6IkowQThxZGJ3dFFsQ0J5UkhMS3FudFBkNEUifQ==; env=default";
//		headers.put("Cookie", cookiesStr);
		String content = OkCommonHeaderTool.hashMapToJson(params);
		PostJsonRequest postJsonRequest = new PostJsonRequest(UrlManager.USER_LOGIN, USER_LOGIN_ACTION, null, headers, content);
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

	public interface IUserLoginCallback{
		void loginSuccessBack();
		void loginErrorBack();
	}
}
