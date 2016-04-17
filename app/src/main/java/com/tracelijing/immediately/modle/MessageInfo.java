package com.tracelijing.immediately.modle;

import java.util.List;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class MessageInfo {

	/**
	 * id : 57027b955002b912000e69b4
	 * content : 香澄果穗访谈：AV女优引退之后
	 * title : 抽屉新热榜每日最热
	 * messageId : 111179
	 * topicId : 768
	 * linkUrl : http://jandan.net/2016/04/04/kasumi-kaho.html
	 * sourceRawValue : link
	 * topic : 56164987b5ec2010000cbc8c
	 * messagePrefix : 抽屉新热榜
	 * collectCount : 14
	 * popularity : 14
	 * topicPicUrl : http://cdn.ruguoapp.com/o_1a94vumcv1ucb15gp16b41c5gv202n.jpeg?imageView2/0/w/120/h/120/interlace/1
	 * createdAt : 2016-04-04T14:35:01.197Z
	 * updatedAt : 2016-04-04T14:35:01.509Z
	 * pictureUrls : [{"thumbnailUrl":"http://cdn.ruguoapp.com/o_1afgfpelrndb1gkf1vsm4ba13f4t.jpg?imageView/2/w/100/h/100/q/100","middlePicUrl":"http://cdn.ruguoapp.com/o_1afgfpelrndb1gkf1vsm4ba13f4t.jpg?imageView2/0/h/500/interlace/1/q/30","picUrl":"http://cdn.ruguoapp.com/o_1afgfpelrndb1gkf1vsm4ba13f4t.jpg?imageView2/0/h/1000/interlace/1","cropperPosX":0.29,"cropperPosY":0.395604,"format":"jpeg","width":600,"height":364}]
	 * collected : false
	 */

	private String id;
	private String content;
	private String title;
	private int messageId;
	private int topicId;
	private String linkUrl;
	private String sourceRawValue;
	private String topic;
	private String messagePrefix;
	private int collectCount;
	private int popularity;
	private String topicPicUrl;
	private String createdAt;
	private String updatedAt;
	private boolean collected;
	/**
	 * thumbnailUrl : http://cdn.ruguoapp.com/o_1afgfpelrndb1gkf1vsm4ba13f4t.jpg?imageView/2/w/100/h/100/q/100
	 * middlePicUrl : http://cdn.ruguoapp.com/o_1afgfpelrndb1gkf1vsm4ba13f4t.jpg?imageView2/0/h/500/interlace/1/q/30
	 * picUrl : http://cdn.ruguoapp.com/o_1afgfpelrndb1gkf1vsm4ba13f4t.jpg?imageView2/0/h/1000/interlace/1
	 * cropperPosX : 0.29
	 * cropperPosY : 0.395604
	 * format : jpeg
	 * width : 600
	 * height : 364
	 */

	private List<PictureInfo> pictureUrls;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getSourceRawValue() {
		return sourceRawValue;
	}

	public void setSourceRawValue(String sourceRawValue) {
		this.sourceRawValue = sourceRawValue;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessagePrefix() {
		return messagePrefix;
	}

	public void setMessagePrefix(String messagePrefix) {
		this.messagePrefix = messagePrefix;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getTopicPicUrl() {
		return topicPicUrl;
	}

	public void setTopicPicUrl(String topicPicUrl) {
		this.topicPicUrl = topicPicUrl;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	public List<PictureInfo> getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(List<PictureInfo> pictureUrls) {
		this.pictureUrls = pictureUrls;
	}

	public static class PictureInfo {
		private String thumbnailUrl;
		private String middlePicUrl;
		private String picUrl;
		private double cropperPosX;
		private double cropperPosY;
		private String format;
		private int width;
		private int height;
		public PictureInfo(String thumbnailUrl){
			this.thumbnailUrl = thumbnailUrl;
		}

		public String getThumbnailUrl() {
			return thumbnailUrl;
		}

		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}

		public String getMiddlePicUrl() {
			return middlePicUrl;
		}

		public void setMiddlePicUrl(String middlePicUrl) {
			this.middlePicUrl = middlePicUrl;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public double getCropperPosX() {
			return cropperPosX;
		}

		public void setCropperPosX(double cropperPosX) {
			this.cropperPosX = cropperPosX;
		}

		public double getCropperPosY() {
			return cropperPosY;
		}

		public void setCropperPosY(double cropperPosY) {
			this.cropperPosY = cropperPosY;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}


	}
}
