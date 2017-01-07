package com.tracelijing.immediately.action;

import android.content.Context;

import com.tracelijing.immediately.net.OkHttpAction;
import com.tracelijing.immediately.utils.UrlManager;

import java.util.HashMap;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class UserLoginAction {
	private Context mContext;
	private OkHttpAction.ActionCallBack iActionCallBack;

	public UserLoginAction(Context context,OkHttpAction.ActionCallBack actionCallBack){
		this.mContext = context;
		this.iActionCallBack = actionCallBack;
	}


	public void call(HashMap<String, Object> params) {
		OkHttpAction okHttpAction = new OkHttpAction(mContext);
		okHttpAction.postJsonObjectAction(UrlManager.USER_LOGIN,params,iActionCallBack);
	}

}
