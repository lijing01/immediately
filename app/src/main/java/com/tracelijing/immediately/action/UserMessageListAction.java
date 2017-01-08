package com.tracelijing.immediately.action;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.net.OkHttpAction;
import com.tracelijing.immediately.utils.UrlManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Trace (Tapatalk) on 2016/3/27.
 */
public class UserMessageListAction {
	private Context mContext;
	private OkHttpAction okHttpAction;
	private IGetUerMessageCallback iGetUerMessageCallback;

	public UserMessageListAction(Context context, IGetUerMessageCallback getUerMessageCallback) {
		this.mContext = context;
		this.iGetUerMessageCallback = getUerMessageCallback;
	}

	public void call(HashMap<String, Object> params) {
		okHttpAction = new OkHttpAction(mContext);
		okHttpAction.postJsonObjectAction(UrlManager.USER_MESSAGE_LIST, params, new OkHttpAction.ActionCallBack() {
			@Override
			public void actionCallBack(Object result) {
				/**
				 * 解析message 对象
				 */
				JSONObject resultObj = (JSONObject)result;
				JSONArray messageJArr = resultObj.optJSONArray("data");
//				GsonBuilder builder = new GsonBuilder();
//				// 不转换没有 @Expose 注解的字段
//				builder.excludeFieldsWithoutExposeAnnotation();
				Gson gson = new Gson();
				ArrayList<MessageInfo> messageInfos = new ArrayList<MessageInfo>();
				for(int i=0;i<messageJArr.length();i++){
					JSONObject mObj = null;
					try {
						mObj = messageJArr.getJSONObject(i);
						java.lang.reflect.Type type = new TypeToken<MessageInfo>() {}.getType();
						MessageInfo messageInfo = gson.fromJson(mObj.toString(),type);
						messageInfos.add(messageInfo);
					} catch (JSONException e) {
						e.printStackTrace();
						iGetUerMessageCallback.getMessageErrorBack(e);
					}

				}
				iGetUerMessageCallback.getMessageSuccessBack(messageInfos);
			}

			@Override
			public void actionErrorBack(Call call, Exception e) {
				iGetUerMessageCallback.getMessageErrorBack(e);
			}
		});
	}


	public interface IGetUerMessageCallback {
		void getMessageSuccessBack(ArrayList<MessageInfo> messageInfos);
		void getMessageErrorBack(Exception e);
	}

}
