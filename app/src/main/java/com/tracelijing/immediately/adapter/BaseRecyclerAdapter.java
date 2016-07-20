package com.tracelijing.immediately.adapter;

/**
 * Created by Trace (Tapatalk) on 2016/7/20.
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tracelijing.immediately.R;

import java.util.ArrayList;


/**
 * Created by wuwei on 2015/12/24.
 */
public class BaseRecyclerAdapter extends RecyclerView.Adapter {

	public final String FOOTER_LOADING = "footer_loading";
	public static final int TYPE_LOADING = 1000;
	private ArrayList<Object> mDataList = new ArrayList<>();
	public Activity mActivity;

	public BaseRecyclerAdapter(Activity activity) {
		this.mActivity = activity;
	}

	protected RecyclerView.ViewHolder getLoadingViewHodler(ViewGroup parent) {
		View convertView = LayoutInflater.from(mActivity).inflate(R.layout.bottom_progressbar,
				parent, false);
		return new RecyclerView.ViewHolder(convertView) {
		};
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return getLoadingViewHodler(parent);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if (TYPE_LOADING == getItemViewType(position)) {
			return;
		}
	}

	@Override
	public int getItemViewType(int position) {
		Object object = getDataList().get(position);
		if (object instanceof String) {
			if (FOOTER_LOADING.equals(object)) {
				return TYPE_LOADING;
			}
		}
		return super.getItemViewType(position);
	}

	@Override
	public int getItemCount() {
		return getDataList().size();
	}

	public ArrayList<Object> getDataList() {
		if (mDataList == null) {
			mDataList = new ArrayList<>();
		}
		return mDataList;
	}

	public void setDataList(ArrayList list) {
		getDataList().addAll(list);
	}

	public void showFooterLoading() {
		if (!getDataList().contains(FOOTER_LOADING)) {
			getDataList().add(FOOTER_LOADING);
			notifyDataSetChanged();
		}
	}

	public void removeFooterLoading() {
		if (getDataList().contains(FOOTER_LOADING)) {
			getDataList().remove(FOOTER_LOADING);
		}
	}
}
