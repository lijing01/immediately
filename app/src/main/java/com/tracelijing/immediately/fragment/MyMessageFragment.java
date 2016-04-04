package com.tracelijing.immediately.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.action.UserLoginAction;

import java.util.HashMap;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class MyMessageFragment extends BaseFragment {
	private Activity mActivity;
	View view;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.my_message,container,false);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mActivity = getActivity();
//		HashMap<String,String> params = new HashMap<>();
//		params.put("limit","25");
//		GetUserMessageListAction getUserMessageListAction = new GetUserMessageListAction(mActivity, new GetUserMessageListAction.IGetUerMessageCallback() {
//			@Override
//			public void getMessageSuccessBack() {
//
//			}
//
//			@Override
//			public void getMessageErrorBack() {
//
//			}
//		});
//		getUserMessageListAction.call(params);

		UserLoginAction userLoginAction = new UserLoginAction(mActivity, new UserLoginAction.IUserLoginCallback() {
			@Override
			public void loginSuccessBack() {

			}

			@Override
			public void loginErrorBack() {

			}
		});
		HashMap<String,String> params = new HashMap<>();
		params.put("username","7203c6f7-b16a-42f5-9905-10a412c98219");
		params.put("password","123");
		userLoginAction.call(params);


	}
}
