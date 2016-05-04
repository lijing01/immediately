package com.tracelijing.immediately.net;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Created by Trace (Tapatalk) on 2016/2/18.
 * https://support.google.com/faqs/answer/6346016
 * http://blog.fordemobile.com/2012/04/https-requests-on-android.html
 */
public class MyX509TrustManager implements X509TrustManager {
	private X509TrustManager standardTrustManager = null;

	public MyX509TrustManager(KeyStore keystore){
		super();
		try {
			TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			factory.init(keystore);
			TrustManager[] trustmanagers = factory.getTrustManagers();
			if (trustmanagers.length == 0) {
				throw new NoSuchAlgorithmException("no trust manager found");
			}
			standardTrustManager = (X509TrustManager)trustmanagers[0];
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) {
		try {
			standardTrustManager.checkClientTrusted(chain, authType);
		} catch (CertificateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) {
		try {
			standardTrustManager.checkServerTrusted(chain, authType);
		} catch (CertificateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		try {
			return this.standardTrustManager.getAcceptedIssuers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}