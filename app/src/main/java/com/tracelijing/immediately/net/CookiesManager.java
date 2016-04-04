package com.tracelijing.immediately.net;

import android.content.Context;

import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class CookiesManager implements CookieJar {
	private Context mContext;
	private final PersistentCookieStore cookieStore;

	public CookiesManager(Context context){
		this.mContext = context;
		cookieStore = new PersistentCookieStore(mContext);
	}


	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		cookieStore.add(url, cookies);
	}

	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		List<Cookie> cookies = cookieStore.get(url);
		return cookies;
	}
}
