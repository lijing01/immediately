package com.tracelijing.immediately.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.action.GetUserMessageListAction;
import com.tracelijing.immediately.adapter.MyMessageRecycleAdapter;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.utils.RecyclerViewOnScrollListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class MessagesFragment extends BaseFragment {
	private Activity mActivity;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private RecyclerView mRecyclerView;
	private MyMessageRecycleAdapter myMessageRecycleAdapter;
	private int lastMessageId;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mSwipeRefreshLayout = (SwipeRefreshLayout) inflater.inflate(R.layout.message_lay,container,false);
		mRecyclerView = (RecyclerView) mSwipeRefreshLayout.findViewById(R.id.message_list);
		return mSwipeRefreshLayout;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mActivity = getActivity();
		getMessages();

		LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity);
		mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(mLayoutManager);
		myMessageRecycleAdapter = new MyMessageRecycleAdapter(mActivity);
		mRecyclerView.setAdapter(myMessageRecycleAdapter);
		mRecyclerView.addOnScrollListener(new RecyclerViewOnScrollListener(mLayoutManager) {
			@Override
			public void onLoadMore(int current_page) {
				getMessages();
			}
		});

	}

	private void getMessages(){
		HashMap<String,String> params = new HashMap<>();
		params.put("limit","25");
		if(lastMessageId!=0){
			params.put("messageIdLessThan",String.valueOf(lastMessageId));
		}
		GetUserMessageListAction getUserMessageListAction = new GetUserMessageListAction(mActivity, new GetUserMessageListAction.IGetUerMessageCallback() {
			@Override
			public void getMessageSuccessBack(ArrayList<MessageInfo> messageInfos, int lstMsgId) {
				lastMessageId = lstMsgId;
				myMessageRecycleAdapter.setDataList(messageInfos);
				myMessageRecycleAdapter.notifyDataSetChanged();
			}

			@Override
			public void getMessageErrorBack() {

			}
		});
//		ArrayList<MessageInfo> cMessageInfos = getUserMessageListAction.getMessageInfoFromCache();
//		if(cMessageInfos!=null && cMessageInfos.size()>0){
//			myMessageRecycleAdapter.setDataList(cMessageInfos);
//			myMessageRecycleAdapter.notifyDataSetChanged();
//		}
		getUserMessageListAction.call(params);
	}
}
