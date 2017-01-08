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
import com.tracelijing.immediately.action.UserMessageListAction;
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
	private boolean isLoadingMore = false;

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
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				mSwipeRefreshLayout.setRefreshing(true);
				lastMessageId = 0;
				getMessages();
			}
		});

		getMessages();

	}

	private void getMessages(){
		if(!isLoadingMore) {
			HashMap<String, Object> params = new HashMap<>();
			params.put("limit", 25);
			if (lastMessageId != 0) {
				params.put("messageIdLessThan", String.valueOf(lastMessageId));
			}
			UserMessageListAction getUserMessageListAction = new UserMessageListAction(mActivity, new UserMessageListAction.IGetUerMessageCallback() {
				@Override
				public void getMessageSuccessBack(ArrayList<MessageInfo> messageInfos) {
					if(lastMessageId == 0){
						myMessageRecycleAdapter.getDataList().clear();
					}
					myMessageRecycleAdapter.removeFooterLoading();
					mSwipeRefreshLayout.setRefreshing(false);
					isLoadingMore = false;
					lastMessageId = messageInfos.get(messageInfos.size()-1).getMessageId();
					myMessageRecycleAdapter.setDataList(messageInfos);
					myMessageRecycleAdapter.notifyDataSetChanged();
				}

				@Override
				public void getMessageErrorBack(Exception e) {
					myMessageRecycleAdapter.removeFooterLoading();
					isLoadingMore = false;
				}
			});
			getUserMessageListAction.call(params);
			myMessageRecycleAdapter.showFooterLoading();
			isLoadingMore = true;
		}
	}
}
