package com.tracelijing.immediately;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tracelijing.immediately.net.MyX509TrustManager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.MemoryCookieStore;

import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import okhttp3.Cookie;
import okhttp3.OkHttpClient;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class MyApplication extends Application {
	private static MyApplication instance;
	private static OkHttpClient mOkHttpClient;
	public static RefWatcher getRefWatcher(Context context) {
		try {
			MyApplication application = (MyApplication) context.getApplicationContext();
			return application.refWatcher;
		}catch (Exception e){
			return null;
		}
	}

	private RefWatcher refWatcher;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		refWatcher = LeakCanary.install(this);
	}

	public static MyApplication getInstance(){
		return instance;
	}

	public static OkHttpClient getOkHttpClient(){
		if(mOkHttpClient == null) {
			try {
				KeyStore trustStore;
				trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
				SSLContext sslContext = SSLContext.getInstance("TLS");
				TrustManager trustManager = new MyX509TrustManager(trustStore);
				sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());

				//init httpClient
				MemoryCookieStore cookieStore = new MemoryCookieStore();
				ArrayList<Cookie> cookies = (ArrayList<Cookie>) cookieStore.getCookies();
				OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

				okHttpClientBuilder.socketFactory(sslContext.getSocketFactory())
						.cookieJar(new CookieJarImpl(cookieStore))
						.hostnameVerifier(new HostnameVerifier() {
							@Override
							public boolean verify(String hostname, SSLSession session) {
								return true;
							}
						});
				mOkHttpClient = okHttpClientBuilder.build();
				OkHttpUtils.initClient(mOkHttpClient);
			} catch (Exception e) {

			}
		}
		return mOkHttpClient;
	}

	public static void initHttpUtils() {

	}
}
