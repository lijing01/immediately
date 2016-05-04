package com.tracelijing.immediately.net;

/**
 * Created by Trace (Tapatalk) on 2016/3/23.
 */

import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONObject;

import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import okhttp3.Call;


/**
 * Created by Trace (Tapatalk) on 2016/3/22.
 */
public class OkHttpAction {
	private Context mContext;
	public static final String URL_TAG = "trace_call";

	public OkHttpAction(Context context) {
		this.mContext = context;
	}

	public void postJsonObjectAction(final String callUrl, final HashMap<String, String> params,
									 final ActionCallBack callBack) {
		try {
			// Create a trust manager that does not validate certificate chains

			KeyStore trustStore;
			org.apache.http.conn.ssl.SSLSocketFactory sf;
			trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			SSLContext sslContext = SSLContext.getInstance("TLS");
			TrustManager trustManager = new MyX509TrustManager(trustStore);
			sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());

			OkHttpUtils.getInstance().getOkHttpClient().newBuilder()
					.sslSocketFactory(sslContext.getSocketFactory())
					.hostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(String hostname, SSLSession session) {
							return true;
						}
					})
					.cookieJar(new CookiesManager(mContext));
			HashMap<String, String> headers = OkCommonHeaderTool.getCommentHeaders(mContext);
			String content = OkCommonHeaderTool.hashMapToJson(params);
			PostJsonRequest postJsonRequest = new PostJsonRequest(callUrl, URL_TAG, null, headers, content);
			postJsonRequest.build().execute(new OkJsonCallback() {
				@Override
				public void onError(Call call, Exception e) {
					callBack.actionErrorBack(call, e);
				}

				@Override
				public void onResponse(JSONObject response) {
					callBack.actionCallBack(response);
				}
			});
		} catch (Exception e) {

		}
	}


	public interface ActionCallBack {
		void actionCallBack(Object result);

		void actionErrorBack(Call call, Exception e);
	}
}
