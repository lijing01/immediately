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
import com.tracelijing.immediately.action.ApiWrapper;
import com.tracelijing.immediately.adapter.MyMessageRecycleAdapter;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.utils.RecyclerViewOnScrollListener;

import java.util.ArrayList;
import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 */
public class MessagesFragment extends BaseFragment {
	Activity mActivity;
	private ApiWrapper mApiWrapper;
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

		mApiWrapper = new ApiWrapper(mActivity);
		getMessages();

	}

	private void getMessages(){
		if(!isLoadingMore) {
			HashMap<String, Object> params = new HashMap<>();
			params.put("limit", 25);
			if (lastMessageId != 0) {
				params.put("messageIdLessThan", String.valueOf(lastMessageId));
			}

			myMessageRecycleAdapter.showFooterLoading();
			isLoadingMore = true;

			mApiWrapper.getMessageInfo(params)
					.subscribeOn(Schedulers.io())
					.observeOn(AndroidSchedulers.mainThread())
					.subscribe(new Subscriber<ArrayList<MessageInfo>>() {
						@Override
						public void onCompleted() {

						}

						@Override
						public void onError(Throwable e) {
							myMessageRecycleAdapter.removeFooterLoading();
							isLoadingMore = false;
						}

						@Override
						public void onNext(ArrayList<MessageInfo> messageInfos) {
							lastMessageId = messageInfos.get(messageInfos.size()-1).getMessageId();
							if(lastMessageId == 0){
								myMessageRecycleAdapter.getDataList().clear();
							}
							myMessageRecycleAdapter.removeFooterLoading();
							mSwipeRefreshLayout.setRefreshing(false);
							isLoadingMore = false;
							myMessageRecycleAdapter.setDataList(messageInfos);
							myMessageRecycleAdapter.notifyDataSetChanged();
						}
					});
		}
	}
}
