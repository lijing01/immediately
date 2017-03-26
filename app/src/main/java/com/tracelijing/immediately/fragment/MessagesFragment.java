package com.tracelijing.immediately.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.thefinestartist.finestwebview.FinestWebView;
import com.tracelijing.immediately.R;
import com.tracelijing.immediately.action.ApiWrapper;
import com.tracelijing.immediately.adapter.BaseRecyclerAdapter;
import com.tracelijing.immediately.adapter.MyMessageRecycleAdapter;
import com.tracelijing.immediately.modle.LoginInfo;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.utils.RecyclerViewOnScrollListener;

import java.util.ArrayList;
import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Trace (Tapatalk) on 2016/3/31.
 * 消息信息页面
 */
public class MessagesFragment extends BaseFragment {
	Activity mActivity;
	private ApiWrapper mApiWrapper;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private RecyclerView mRecyclerView;
	private MyMessageRecycleAdapter myMessageRecycleAdapter;
	private int lastMessageId;
	private boolean isLoadingMore = false;
	private HashMap<String, Object> messageListParams = new HashMap<>();

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

		myMessageRecycleAdapter.setOnItemClickListener(new BaseRecyclerAdapter.IOnRecyclerViewItemClickListener(){
			@Override
			public void onItemClick(View v, int position) {
				MessageInfo messageInfo = (MessageInfo)myMessageRecycleAdapter.getDataList().get(position);
				if(messageInfo.getLinkUrl()!=null && !messageInfo.getLinkUrl().equals("")
						&& !messageInfo.getLinkUrl().startsWith("jike")) {
					new FinestWebView.Builder(mActivity).show(messageInfo.getLinkUrl());
				}else{
					setAnimation(v);
				}
			}
		});

		mApiWrapper = new ApiWrapper(mActivity);
		messageListParams.put("limit", 25);
		getMessages();

	}

	private void getMessages(){
		if(!isLoadingMore) {
			if (lastMessageId != 0) {
				messageListParams.put("messageIdLessThan", String.valueOf(lastMessageId));
			}
			myMessageRecycleAdapter.showFooterLoading();
			isLoadingMore = true;

			//先登录，再获取信息，串联rx action
			HashMap<String, Object> loginParams = new HashMap<>();
			loginParams.put("username", "7203c6f7-b16a-42f5-9905-10a412c98219");
			loginParams.put("password", "123");
			mApiWrapper.login(loginParams)
					.onErrorReturn(new Func1<Throwable, LoginInfo>() {
						@Override
						public LoginInfo call(Throwable throwable) {
							Log.v(ApiWrapper.TAG_STRING,"login Exception");
							return null;
						}
					})
					.flatMap(new Func1<LoginInfo, Observable<ArrayList<MessageInfo>>>() {
						@Override
						public Observable<ArrayList<MessageInfo>> call(LoginInfo loginInfo) {
							if(loginInfo != null) {
								return mApiWrapper.getMessageInfo(messageListParams);
							}else{
								return null;
							}
						}
					})
					.compose(this.<ArrayList<MessageInfo>>bindToLifecycle())
					.subscribeOn(Schedulers.io())
					.observeOn(AndroidSchedulers.mainThread())
					.subscribe(new Subscriber<ArrayList<MessageInfo>>() {
						@Override
						public void onCompleted() {
							Log.v(ApiWrapper.TAG_STRING,"getMessage onCompleted");
							//根据数据添加 empty view 等异常情况处理
						}

						@Override
						public void onError(Throwable e) {
							Log.v(ApiWrapper.TAG_STRING,"getMessage onError");
							myMessageRecycleAdapter.removeFooterLoading();
							isLoadingMore = false;
						}

						@Override
						public void onNext(ArrayList<MessageInfo> messageInfos) {
							Log.v(ApiWrapper.TAG_STRING,"getMessage onNext");
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

	private void setAnimation(View viewToAnimate) {
		Animation animation = AnimationUtils.loadAnimation(mActivity, R.anim.shake);
		viewToAnimate.startAnimation(animation);
	}
}
