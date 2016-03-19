package com.tracelijing.immediately;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class EntryActivityFragment extends Fragment {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public EntryActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_entry, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getData();
	}

	private void getData() {
		 new Thread(){
			public void run(){
				try {
					String url = "https://app.jike.ruguoapp.com/1.0/users/messages/list";
					OkHttpClient client = new OkHttpClient();
					RequestBody body = RequestBody.create(JSON, "{\"messageIdLessThan\":2147483647,\"limit\":25}");
					Request request = new Request.Builder()
							.url(url)
							.post(body)
							.build();

					Response response = client.newCall(request).execute();
					if(response!=null && response.body()!=null) {
						Log.v("lijing", request.body().toString());
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}.start();

	}
}
