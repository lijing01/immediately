package com.tracelijing.immediately.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.action.UserLoginAction;
import com.tracelijing.immediately.net.OkHttpAction;
import com.tracelijing.tlibrary.ToastUtil;

import java.util.HashMap;

import okhttp3.Call;

/**
 * 之后需要实现知乎日报 splash view
 * <a href="http://www.cnblogs.com/carbs/p/5139223.html></a>
 */
public class SplashActivity extends AppCompatActivity {
	/** 防止重复调用 intent**/
	private boolean intentTo = false;
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
		tryLogin();

	}

	private void tryLogin() {
		HashMap<String, Object> params = new HashMap<>();
		params.put("username", "7203c6f7-b16a-42f5-9905-10a412c98219");
		params.put("password", "123");
		UserLoginAction userLoginAction = new UserLoginAction(this, new OkHttpAction.ActionCallBack() {
			@Override
			public void actionCallBack(Object result) {
				intentToEntry();
				ToastUtil.showLong(SplashActivity.this, "登录成功");
			}

			@Override
			public void actionErrorBack(Call call, Exception e) {
				ToastUtil.showLong(SplashActivity.this,"登录失败");
			}
		});

		userLoginAction.call(params);
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
