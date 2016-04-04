package com.tracelijing.immediately.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class UnSafeTrustManager implements X509TrustManager
{
	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException
	{
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException
	{
	}

	@Override
	public X509Certificate[] getAcceptedIssuers()
	{
		return new java.security.cert.X509Certificate[]{};
	}
}