package com.tracelijing.immediately.action;

import android.content.Context;

import com.tracelijing.immediately.modle.LoginInfo;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.net.OkHttpAction;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * Created by Trace (Tapatalk) on 2017/1/7.
 */

public class ApiWrapper {
	public static final String TAG_STRING = "rx_api";

	Context mContext;

	public ApiWrapper(Context context){
		this.mContext = context;
	}


	public Observable<LoginInfo> login(final HashMap<String, Object> params) {
		return Observable.create(new OnSubscribe<LoginInfo>() {
			@Override
			public void call(final Subscriber<? super LoginInfo> subscriber) {
				new UserLoginAction(mContext, new OkHttpAction.ActionCallBack() {
					@Override
					public void actionCallBack(Object result) {
						LoginInfo loginInfo = new LoginInfo();
						subscriber.onNext(loginInfo);
						subscriber.onCompleted();
					}

					@Override
					public void actionErrorBack(Call call, Exception e) {
						subscriber.onError(e);
					}
				}).call(params);
			}
		});
	}

	public Observable<ArrayList<MessageInfo>> getMessageInfo(final HashMap<String, Object> params){
		return Observable.create(new OnSubscribe<ArrayList<MessageInfo>>(){

			@Override
			public void call(final Subscriber<? super ArrayList<MessageInfo>> subscriber) {
				UserMessageListAction getUserMessageListAction
						= new UserMessageListAction(mContext, new UserMessageListAction.IGetUerMessageCallback() {
					@Override
					public void getMessageSuccessBack(ArrayList<MessageInfo> messageInfos) {
						subscriber.onNext(messageInfos);
					}

					@Override
					public void getMessageErrorBack(Exception e) {
					    subscriber.onError(e);
					}
				});

				getUserMessageListAction.call(params);
			}
		});
	}
}
