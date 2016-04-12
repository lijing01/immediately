package com.tracelijing.immediately.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.tracelijing.immediately.modle.MessageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trace (Tapatalk) on 2016/4/12.
 */
public class GridPicLayout extends ViewGroup {
	/** 定义图片情况数组**/
	private static final int[][] i = {{1, 0, 0}, {2, 0, 0}, {3, 0, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}, {1, 3, 3}, {2, 3, 3}, {3, 3, 3}};
	private List<MessageInfo.PictureInfo> pictureInfos = new ArrayList<>();
	private List<View> imageViews = new ArrayList<>();
	/** view 长宽比**/
	private float e = 0.5625F;


	public GridPicLayout(Context context) {
		super(context);
	}

	public GridPicLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GridPicLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}


	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

	}
}
