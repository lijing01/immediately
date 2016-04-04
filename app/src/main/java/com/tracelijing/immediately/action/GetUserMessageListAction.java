package com.tracelijing.immediately.action;

import android.app.Activity;

import com.tracelijing.immediately.net.OkHttpAction;
import com.tracelijing.immediately.utils.UrlManager;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class GetUserMessageListAction {
	private Activity mContext;
	private IGetUerMessageCallback iGetUerMessageCallback;

	public GetUserMessageListAction(Activity context, IGetUerMessageCallback getUerMessageCallback) {
		this.mContext = context;
		this.iGetUerMessageCallback = getUerMessageCallback;
	}

	public void call(HashMap<String, String> params) {
		OkHttpAction okHttpAction = new OkHttpAction(mContext);
		okHttpAction.postJsonObjectAction(UrlManager.USER_MESSAGE_LIST, params, new OkHttpAction.ActionCallBack() {
			@Override
			public void actionCallBack(Object result) {
				iGetUerMessageCallback.getMessageSuccessBack();
			}

			@Override
			public void actionErrorBack(Call call, Exception e) {
				iGetUerMessageCallback.getMessageErrorBack();
			}
		});
	}


	public interface IGetUerMessageCallback {
		void getMessageSuccessBack();
		void getMessageErrorBack();
	}

}
