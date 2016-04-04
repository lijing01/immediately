package com.tracelijing.immediately.modle;

/**
 * Created by Trace (Tapatalk) on 2016/4/4.
 */
public class PictureInfo {

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
