package com.tracelijing.immediately.net;

import android.content.Context;

import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.MemoryCookieStore;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import okhttp3.OkHttpClient;

/**
 * Created by Trace (Tapatalk) on 2016/7/11.
 */
public class OkHttpClientUtil {
	private static OkHttpClient mInstance;

	public static OkHttpClient getInstance(Context context) {
		if (mInstance == null) {
			SSLContext sslContext = null;
			try {
				sslContext = SSLContext.getInstance("TLS");
				TrustManager trustManager = new UnSafeTrustManager();
				sslContext.init(null, new TrustManager[]{trustManager}, null);

			} catch (Exception e) {
				e.printStackTrace();
			}

			OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
			okHttpClientBuilder.sslSocketFactory(sslContext.getSocketFactory())
					.hostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(String hostname, SSLSession session) {
							return true;
						}
					})
					.cookieJar(new CookieJarImpl(new MemoryCookieStore()));
//					.cookieJar(new CookiesManager(context));
			mInstance = okHttpClientBuilder.build();
			return mInstance;
		}
		return mInstance;
	}
}
