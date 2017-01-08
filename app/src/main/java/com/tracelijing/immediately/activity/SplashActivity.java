package com.tracelijing.immediately.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.action.ApiWrapper;
import com.tracelijing.immediately.modle.LoginInfo;
import com.tracelijing.tlibrary.ToastUtil;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 之后需要实现知乎日报 splash view
 * <a href="http://www.cnblogs.com/carbs/p/5139223.html></a>
 */
public class SplashActivity extends AppCompatActivity {
	/** 防止重复调用 intent**/
	private boolean intentTo = false;
	private ApiWrapper mApiWrapper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*set it to be no title*/
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/*set it to be full screen*/
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				intentToEntry();
			}
		}, 3 * 1000);
//		tryLogin();

	}

	private void tryLogin() {
		HashMap<String, Object> params = new HashMap<>();
		params.put("username", "7203c6f7-b16a-42f5-9905-10a412c98219");
		params.put("password", "123");
		mApiWrapper = new ApiWrapper(this);
		mApiWrapper.login(params)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<LoginInfo>() {
					@Override
					public void onCompleted() {
						Log.v(ApiWrapper.TAG_STRING,"login onCompleted");
						intentToEntry();
						ToastUtil.showLong(SplashActivity.this, "登录成功");
					}

					@Override
					public void onError(Throwable e) {
						Log.v(ApiWrapper.TAG_STRING,"login onError");
						ToastUtil.showLong(SplashActivity.this,"登录失败");
					}

					@Override
					public void onNext(LoginInfo loginInfo) {
						Log.v(ApiWrapper.TAG_STRING,"login onNext");
					}
				});


	}

	private void intentToEntry() {
		if(!intentTo) {
			intentTo = true;
			Intent intent = new Intent(SplashActivity.this, EntryActivity.class);
			startActivity(intent);
			finish();
		}
	}
}
