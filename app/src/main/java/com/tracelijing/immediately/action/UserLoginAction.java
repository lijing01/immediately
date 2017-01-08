package com.tracelijing.immediately.action;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tracelijing.immediately.modle.LoginInfo;
import com.tracelijing.immediately.net.OkHttpAction;
import com.tracelijing.immediately.utils.UrlManager;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class UserLoginAction {
	private Context mContext;
	private OkHttpAction okHttpAction;
	private OkHttpAction.ActionCallBack iActionCallBack;

	public UserLoginAction(Context context,OkHttpAction.ActionCallBack actionCallBack){
		this.mContext = context;
		this.iActionCallBack = actionCallBack;
	}


	public void call(HashMap<String, Object> params) {
		okHttpAction = new OkHttpAction(mContext);
		okHttpAction.postJsonObjectAction(UrlManager.USER_LOGIN, params, new OkHttpAction.ActionCallBack() {
			@Override
			public void actionCallBack(Object result) {
				JSONObject resultObj = (JSONObject)result;
				JSONObject userObj = resultObj.optJSONObject("user");
				Gson gson = new Gson();
				java.lang.reflect.Type type = new TypeToken<LoginInfo>() {}.getType();
				LoginInfo loginInfo = gson.fromJson(userObj.toString(),type);
				iActionCallBack.actionCallBack(loginInfo);
				}

			@Override
			public void actionErrorBack(Call call, Exception e) {
				iActionCallBack.actionErrorBack(call,e);
			}
		});
	}

}
