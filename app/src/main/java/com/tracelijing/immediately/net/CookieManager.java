package com.tracelijing.immediately.net;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Trace (Tapatalk) on 2016/7/12.
 */
public class CookieManager implements CookieJar {
	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

	}

	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		return null;
	}
}
