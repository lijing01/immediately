package com.tracelijing.immediately.net;

import com.zhy.http.okhttp.request.OkHttpRequest;
import com.zhy.http.okhttp.utils.Exceptions;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class PostJsonRequest extends OkHttpRequest {
	private static MediaType MEDIA_TYPE_PLAIN = MediaType.parse("application/json;charset=utf-8");

	private String content;
	private MediaType mediaType;

	public PostJsonRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers,String content,int id) {
		super(url, tag, params, headers,id);
		this.content = content;
		this.mediaType = mediaType;

		if (this.content == null) {
			Exceptions.illegalArgument("the content can not be null !");
		}
		if (this.mediaType == null) {
			this.mediaType = MEDIA_TYPE_PLAIN;
		}
	}

	@Override
	protected RequestBody buildRequestBody() {
		return RequestBody.create(mediaType, content);
	}

	@Override
	protected Request buildRequest(RequestBody requestBody) {
		return builder.post(requestBody).build();
	}
}
