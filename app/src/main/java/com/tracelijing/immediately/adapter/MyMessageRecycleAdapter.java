package com.tracelijing.immediately.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.widget.GridPicLayout;
import com.tracelijing.tlibrary.ViewUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trace (Tapatalk) on 2016/4/12.
 */
public class MyMessageRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private Activity mActivity;

	public void setMessageInfos(List<MessageInfo> messageInfos) {
		this.messageInfos = messageInfos;
	}

	private List<MessageInfo> messageInfos = new ArrayList<>();

	public MyMessageRecycleAdapter(Activity activity){
		this.mActivity = activity;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(mActivity).inflate(R.layout.message_item,parent,false);
		RecyclerView.ViewHolder viewHolder = new MessageViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		MessageInfo messageInfo = messageInfos.get(position);
		MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
		messageViewHolder.username.setText(messageInfo.getMessagePrefix());
		messageViewHolder.time.setText(messageInfo.getUpdatedAt());
		messageViewHolder.content.setText(messageInfo.getContent());
		if (messageInfo.getPictureUrls().size() > 0) {
			messageViewHolder.images.setVisibility(View.VISIBLE);
			messageViewHolder.images.setPictureInfos((ArrayList<MessageInfo.PictureInfo>) messageInfo.getPictureUrls());
			messageViewHolder.images.checkRecyclerStatus();
		} else {
			messageViewHolder.images.setVisibility(View.GONE);
			messageViewHolder.images.setTag(position);
		}
	}

	@Override
	public int getItemCount() {
		return messageInfos.size();
	}

	public class MessageViewHolder extends  RecyclerView.ViewHolder{
		public ImageView imageView;
		public TextView username,time,content;
		public GridPicLayout images;
		public MessageViewHolder(View itemView) {
			super(itemView);
			this.imageView = ViewUtil.$(itemView,R.id.avatar);
			this.username = ViewUtil.$(itemView,R.id.username);
			this.time = ViewUtil.$(itemView,R.id.time);
			this.content = ViewUtil.$(itemView,R.id.content);
			this.images = ViewUtil.$(itemView,R.id.imgs);
		}
	}
}
