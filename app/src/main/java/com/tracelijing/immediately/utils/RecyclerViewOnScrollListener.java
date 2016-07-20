package com.tracelijing.immediately.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Trace (Tapatalk) on 2016/7/20.
 */
public abstract class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {

	private int totalItemCount, lastInScreen;
	private int page = 1;

	private LinearLayoutManager mLinearLayoutManager;

	public RecyclerViewOnScrollListener(LinearLayoutManager linearLayoutManager) {
		this.mLinearLayoutManager = linearLayoutManager;
	}

	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		super.onScrolled(recyclerView, dx, dy);

		lastInScreen = mLinearLayoutManager.findFirstVisibleItemPosition() + mLinearLayoutManager.getChildCount();
		totalItemCount = mLinearLayoutManager.getItemCount();
		boolean shouldLoadingMore = lastInScreen != 0 && lastInScreen >= totalItemCount;

		if (shouldLoadingMore) {
			page++;
			onLoadMore(page);
		}
	}

	public abstract void onLoadMore(int current_page);

}
