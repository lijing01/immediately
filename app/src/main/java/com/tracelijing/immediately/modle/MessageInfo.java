package com.tracelijing.immediately.modle;

import java.util.List;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class MessageInfo {

	/**
	 * id : 5782662a3e63af11009105e5
	 * content : (1) 大巴司机冷静处置，42名乘客躲过塌方：发现没风但树在摇，果断倒车
	 (2) 周渝民太太孕照首次曝光，身孕已过六个月
	 (3) 为套取拆迁补偿农户私建房屋，倒塌致一家4口遇难
	 (4) 上海市委统战部首开大V培训班，要求20万新媒体人爱惜羽毛
	 (5) 叙利亚四名球员被IS以“间谍”罪名斩首，事件前其宗教领袖巴格达迪曾称踢球、看球、支持球队都是“反伊斯兰”行为
	 * title : 今天微博都在热议什么
	 * messageId : 169607
	 * topicId : 454
	 * linkUrl : http://medium.ruguoapp.com/2016/07/10/jin-tian-wei-bo-zai-re-yi-shi-yao-92/
	 * sourceRawValue : link
	 * messagePrefix : 今日微博热点
	 * collectCount : 109
	 * commentCount : 14
	 * popularity : 109
	 * createdAt : 2016-07-10T15:13:46.417Z
	 * updatedAt : 2016-07-10T18:06:36.501Z
	 * topic : {"id":"55963702e4b0d84d2c30ce6f","content":"今天微博都在热议什么","thumbnailUrl":"http://cdn.ruguoapp.com/o_1a94vqkfpjpp3pg1f3b10kl3es8u.jpeg?imageView2/0/w/120/h/120/interlace/1"}
	 * pictureUrls : [{"thumbnailUrl":"http://cdn.ruguoapp.com/o_1analg826biv5fu1b5ar7c2d33.jpeg?imageView/2/w/100/h/100/q/100","middlePicUrl":"http://cdn.ruguoapp.com/o_1analg826biv5fu1b5ar7c2d33.jpeg?imageView2/0/h/500/interlace/1/q/30","picUrl":"http://cdn.ruguoapp.com/o_1analg826biv5fu1b5ar7c2d33.jpeg?imageView2/0/h/1000/interlace/0","cropperPosX":0.564444,"cropperPosY":0.4,"format":"jpeg","width":600,"height":800},{"thumbnailUrl":"http://cdn.ruguoapp.com/o_1analath21foa1h8q1od71qml3jq2.jpeg?imageView/2/w/100/h/100/q/100","middlePicUrl":"http://cdn.ruguoapp.com/o_1analath21foa1h8q1od71qml3jq2.jpeg?imageView2/0/h/500/interlace/1/q/30","picUrl":"http://cdn.ruguoapp.com/o_1analath21foa1h8q1od71qml3jq2.jpeg?imageView2/0/h/1000/interlace/0","cropperPosX":0.5,"cropperPosY":0.5,"format":"jpeg","width":458,"height":412},{"thumbnailUrl":"http://cdn.ruguoapp.com/o_1analkils9na1lcf23migv32a0.jpeg?imageView/2/w/100/h/100/q/100","middlePicUrl":"http://cdn.ruguoapp.com/o_1analkils9na1lcf23migv32a0.jpeg?imageView2/0/h/500/interlace/1/q/30","picUrl":"http://cdn.ruguoapp.com/o_1analkils9na1lcf23migv32a0.jpeg?imageView2/0/h/1000/interlace/0","cropperPosX":0.5,"cropperPosY":0.5,"format":"jpeg","width":540,"height":360},{"thumbnailUrl":"http://cdn.ruguoapp.com/o_1analj0rpu3n2bhdaa15iutne0.jpeg?imageView/2/w/100/h/100/q/100","middlePicUrl":"http://cdn.ruguoapp.com/o_1analj0rpu3n2bhdaa15iutne0.jpeg?imageView2/0/h/500/interlace/1/q/30","picUrl":"http://cdn.ruguoapp.com/o_1analj0rpu3n2bhdaa15iutne0.jpeg?imageView2/0/h/1000/interlace/0","cropperPosX":0.5,"cropperPosY":0.5,"format":"jpeg","width":600,"height":399},{"thumbnailUrl":"http://cdn.ruguoapp.com/o_1anakndac13qnkn31scmfgli361.jpeg?imageView/2/w/100/h/100/q/100","middlePicUrl":"http://cdn.ruguoapp.com/o_1anakndac13qnkn31scmfgli361.jpeg?imageView2/0/h/500/interlace/1/q/30","picUrl":"http://cdn.ruguoapp.com/o_1anakndac13qnkn31scmfgli361.jpeg?imageView2/0/h/1000/interlace/0","cropperPosX":0.5,"cropperPosY":0.5,"format":"jpeg","width":634,"height":619}]
	 * collected : false
	 */

	private String id;
	private String content;
	private String title;
	private int messageId;
	private int topicId;
	private String linkUrl;
	private String sourceRawValue;
	private String messagePrefix;
	private int collectCount;
	private int commentCount;
	private int popularity;
	private String createdAt;
	private String updatedAt;

	/**
	 * id : 5784cb199c0d481200b05302
	 * title : The Mass
	 * author : Era
	 * coverUrl : http://cdn.ruguoapp.com/o_1anfbin0v1pev1j9r1lo41ukr14he8?imageView2/1/w/120/h/120
	 * originCoverUrl : http://7xlgp5.com2.z0.glb.qiniucdn.com/o_1anfbin0v1pev1j9r1lo41ukr14he8
	 * url : http://p2.music.126.net/hKyA0usmddlqqcE5GBp9nQ==/3350211931087770.mp3
	 */

	private MediaBean media;

	/**
	 * id : 55963702e4b0d84d2c30ce6f
	 * content : 今天微博都在热议什么
	 * thumbnailUrl : http://cdn.ruguoapp.com/o_1a94vqkfpjpp3pg1f3b10kl3es8u.jpeg?imageView2/0/w/120/h/120/interlace/1
	 */

	private TopicBean topic;

	private VideoBean video;
	private boolean collected;
	/**
	 * thumbnailUrl : http://cdn.ruguoapp.com/o_1analg826biv5fu1b5ar7c2d33.jpeg?imageView/2/w/100/h/100/q/100
	 * middlePicUrl : http://cdn.ruguoapp.com/o_1analg826biv5fu1b5ar7c2d33.jpeg?imageView2/0/h/500/interlace/1/q/30
	 * picUrl : http://cdn.ruguoapp.com/o_1analg826biv5fu1b5ar7c2d33.jpeg?imageView2/0/h/1000/interlace/0
	 * cropperPosX : 0.564444
	 * cropperPosY : 0.4
	 * format : jpeg
	 * width : 600
	 * height : 800
	 */

	private List<PictureUrlsBean> pictureUrls;

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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
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

	public TopicBean getTopic() {
		return topic;
	}

	public void setTopic(TopicBean topic) {
		this.topic = topic;
	}

	public MediaBean getMedia() {
		return media;
	}

	public void setMedia(MediaBean media) {
		this.media = media;
	}


	public VideoBean getVideo() {
		return video;
	}

	public void setVideo(VideoBean video) {
		this.video = video;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	public List<PictureUrlsBean> getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(List<PictureUrlsBean> pictureUrls) {
		this.pictureUrls = pictureUrls;
	}

	public static class TopicBean {
		private String id;
		private String content;
		private String thumbnailUrl;

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

		public String getThumbnailUrl() {
			return thumbnailUrl;
		}

		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}
	}

	public static class PictureUrlsBean {
		private String thumbnailUrl;
		private String middlePicUrl;
		private String picUrl;
		private double cropperPosX;
		private double cropperPosY;
		private String format;
		private int width;
		private int height;

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

	public static class MediaBean{

		private String id;
		private String title;
		private String author;
		private String coverUrl;
		private String originCoverUrl;
		private String url;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getCoverUrl() {
			return coverUrl;
		}

		public void setCoverUrl(String coverUrl) {
			this.coverUrl = coverUrl;
		}

		public String getOriginCoverUrl() {
			return originCoverUrl;
		}

		public void setOriginCoverUrl(String originCoverUrl) {
			this.originCoverUrl = originCoverUrl;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

	public static class VideoBean{

		/**
		 * source : []
		 * thumbnailUrl : http://wsqncdn.miaopai.com/stream/CVmnMIn0Z8bT8km4mDvfKg___m.jpg
		 */

		private String thumbnailUrl;
		private List<String> source;

		public String getThumbnailUrl() {
			return thumbnailUrl;
		}

		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}

		public List<String> getSource() {
			return source;
		}

		public void setSource(List<String> source) {
			this.source = source;
		}
	}
}
