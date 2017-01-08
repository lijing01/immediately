package com.tracelijing.immediately.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.tracelijing.immediately.R;
import com.tracelijing.immediately.modle.MessageInfo;
import com.tracelijing.immediately.widget.GridPicLayout;
import com.tracelijing.tlibrary.ViewUtil;

import java.util.ArrayList;

/**
 * Created by Trace (Tapatalk) on 2016/4/12.
 */
public class MyMessageRecycleAdapter extends BaseRecyclerAdapter {

	private static final int TYPE_MESSAGE_INFO = 1001;

	public MyMessageRecycleAdapter(Activity activity) {
		super(activity);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if(viewType == TYPE_MESSAGE_INFO) {
			View v = LayoutInflater.from(mActivity).inflate(R.layout.message_item, parent, false);
			RecyclerView.ViewHolder viewHolder = new MessageViewHolder(v);
			return viewHolder;
		}
		return super.onCreateViewHolder(parent,viewType);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		super.onBindViewHolder(holder,position);
		if(getItemViewType(position) == TYPE_MESSAGE_INFO) {
			MessageInfo messageInfo = (MessageInfo) getDataList().get(position);
			MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
			messageViewHolder.username.setText(messageInfo.getMessagePrefix());
			messageViewHolder.time.setText(messageInfo.getUpdatedAt());
			messageViewHolder.content.setText(messageInfo.getContent());
			if (messageInfo.getPictureUrls().size() > 0) {
				messageViewHolder.images.setVisibility(View.VISIBLE);
				messageViewHolder.images.setPictureInfos((ArrayList<MessageInfo.PictureUrlsBean>) messageInfo.getPictureUrls());
				messageViewHolder.images.checkRecyclerStatus();
			} else {
				messageViewHolder.images.setVisibility(View.GONE);
				messageViewHolder.images.setTag(position);
			}
			if (messageInfo.getTopic() != null) {
				DraweeController controller = Fresco.newDraweeControllerBuilder()
						.setImageRequest(ImageRequest.fromUri(messageInfo.getTopic().getThumbnailUrl()))
						.setOldController(messageViewHolder.imageView.getController())
						.build();
				messageViewHolder.imageView.setController(controller);
			}
		}
	}


	@Override
	public int getItemViewType(int position) {

		if(getDataList().get(position) instanceof MessageInfo){
			return TYPE_MESSAGE_INFO;
		}
		return super.getItemViewType(position);
	}

	private static class MessageViewHolder extends RecyclerView.ViewHolder {
		SimpleDraweeView imageView;
		TextView username, time, content;
		GridPicLayout images;

		MessageViewHolder(View itemView) {
			super(itemView);
			this.imageView = ViewUtil.$(itemView, R.id.avatar);
			this.username = ViewUtil.$(itemView, R.id.username);
			this.time = ViewUtil.$(itemView, R.id.time);
			this.content = ViewUtil.$(itemView, R.id.content);
			this.images = ViewUtil.$(itemView, R.id.imgs);
		}
	}
}
