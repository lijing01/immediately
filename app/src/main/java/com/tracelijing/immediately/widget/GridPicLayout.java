package com.tracelijing.immediately.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tracelijing.immediately.R;
import com.tracelijing.immediately.modle.MessageInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trace (Tapatalk) on 2016/4/12.
 */
public class GridPicLayout extends ViewGroup {
	private Context mContext;
	/**
	 * 定义图片情况数组
	 **/
	private static final int[][] i = {{1, 0, 0}, {2, 0, 0}, {3, 0, 0},
			{1, 3, 0}, {2, 3, 0}, {3, 3, 0},
			{1, 3, 3}, {2, 3, 3}, {3, 3, 3}};
	private List<MessageInfo.PictureInfo> pictureInfos = new ArrayList<>();
	private List<RelativeLayout> imageViews = new ArrayList<>();
	/**
	 * view 长宽比
	 **/
	private float e = 0.5625F;
	private int oneImageWidth;
	private int oneImageHeight;
	private int twoImageWidth;
	private int thereImageWidth;
	private int diverWidth;

	private int j[][];
	private IImageOnClickListener iImageOnClickListener;


	public GridPicLayout(Context context) {
		this(context, null, 0);
	}

	public GridPicLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GridPicLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		int[] arrayOfInt = {9, 2};
		this.j = ((int[][]) Array.newInstance(Integer.TYPE, arrayOfInt));
		init();
	}


	private void init() {
		diverWidth = (int) mContext.getResources().getDimension(R.dimen.dimen_8);
		int m = 0;
		for (int n = 0; n < 9; n++)
			getCView(n);
		if (isInEditMode()) {
		ArrayList localArrayList = new ArrayList();
		while (m < 7) {
			localArrayList.add(new MessageInfo.PictureInfo("test string for Edit Mode"));
			m++;
		}
		setPictureInfos(localArrayList);
		}
	}

	public void checkRecyclerStatus(){
		int n = getPicSize();
		for(int i=0;i<n; i++){
			imageViews.get(i).setVisibility(View.VISIBLE);
		}
		for(int k=n;k<9;k++){
			imageViews.get(k).setVisibility(View.GONE);
		}
	}


	private void getCView(int n) {
		RelativeLayout localView1 = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.image_layout,null,false);
		/** for test **/
		switch(n){
			case 0:
				localView1.setBackgroundColor(Color.BLACK);
				break;
			case 1:
				localView1.setBackgroundColor(Color.BLUE);
				break;
			case 2:
				localView1.setBackgroundColor(Color.GREEN);
				break;
			case 3:
				localView1.setBackgroundColor(Color.RED);
				break;
			case 4:
				localView1.setBackgroundColor(Color.YELLOW);
				break;
			case 5:
				localView1.setBackgroundColor(Color.CYAN);
				break;
			case 6:
				localView1.setBackgroundColor(Color.GRAY);
				break;
			case 7:
				localView1.setBackgroundColor(Color.DKGRAY);
				break;
			case 8:
				localView1.setBackgroundColor(Color.MAGENTA);
				break;
		}
		ImageView gifIcon = (ImageView) localView1.findViewById(R.id.gif_btn);
		RelativeLayout.LayoutParams p = ((RelativeLayout.LayoutParams)gifIcon.getLayoutParams());
		p.addRule(RelativeLayout.CENTER_IN_PARENT);
		gifIcon.setLayoutParams(p);
		this.imageViews.add(localView1);
		addView(localView1);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		Log.v("lijing","start to layout child view");
		int m = getPicSize();
		if (m == 0)
			return;
		int[] arrayOfInt = i[(m - 1)];
		int n=0;
		while (n<m){
			int w1=0,h1=0,w2=0,h2=0;
			int line = j[n][0];
			int row = j[n][1];
			if(line == 0){
				switch (arrayOfInt[0]){
					default:
						w1 = 0;
						h1 = 0;
					case 1:
						w1 = oneImageWidth;
						h1 = oneImageHeight;
						break;
					case 2:
						w1 = twoImageWidth;
						h1 = twoImageWidth;

						break;
					case 3:
						w1 = thereImageWidth;
						h1 = thereImageWidth;

				}
				((RelativeLayout) imageViews.get(n)).measure(w1, h1);
				int cl = (w1+diverWidth)*row;
				int cr = cl+w1;
				((RelativeLayout) imageViews.get(n)).layout(cl,0,cr,h1);
				Log.v("lijing", "image " + n + " cl=" + cl + "& cr=" + cr);
				n++;
			}else{
				w2 = thereImageWidth;
				h2 = thereImageWidth;
				((RelativeLayout)imageViews.get(n)).measure(w2,h2);
				int cl = (w2+diverWidth)*row;
				int cr = cl+w2;
				int ct = getFirstRowHeight()+(diverWidth)*line + thereImageWidth*(line-1);
				int cb = ct+h2;
				((RelativeLayout) imageViews.get(n)).layout(cl,ct,cr,ct+h2);
				Log.v("lijing", "image " + n + " cl=" + cl + "& cr=" + cr+ " ct=" + ct + "& cb=" + cb);
				n++;
			}
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.v("lijing","start to get parent view size");
		this.oneImageWidth = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
		this.oneImageHeight = ((int) (this.oneImageWidth * this.e));
		this.twoImageWidth = ((this.oneImageWidth - this.diverWidth) / 2);
		this.thereImageWidth = ((this.oneImageWidth - 2 * this.diverWidth) / 3);
		getChildViewSize();
		int m = getLayoutHeight();
		setMeasuredDimension(this.oneImageWidth, m);
	}

	private void getChildViewSize() {
		Log.v("lijing","start to get child view size");
		int m = getPicSize();
		if (m == 0)
			return;
		int[] arrayOfInt = i[(m - 1)];
		int n=0;
		while (n<m){
			int w1,h1,w2,h2;
			int line = j[n][0];
			int row = j[n][1];
			if(line == 0){
				switch (arrayOfInt[0]){
					default:
						w1 = 0;
						h1 = 0;
					case 1:
						w1 = oneImageWidth;
						h1 = oneImageHeight;
						break;
					case 2:
						w1 = twoImageWidth;
						h1 = twoImageWidth;
						break;
					case 3:
						w1 = thereImageWidth;
						h1 = thereImageWidth;

				}

				((RelativeLayout) imageViews.get(n)).measure(w1, h1);
				n++;
				Log.v("lijing", "image " + n + " w=" + w1 + "& h=" + h1);
			}else{
				w2 = thereImageWidth;
				h2 = thereImageWidth;
				((RelativeLayout)imageViews.get(n)).measure(w2,h2);
				Log.v("lijing","image "+ n +" w="+w2+"& h="+h2);
				n++;
			}
		}
	}

	/**
	 * 获取第一行的高度
	 **/
	private int getFirstRowHeight() {
		if (getPicSize() == 0)
			return 0;
		int m = i[(-1 + getPicSize())][0];
		if (m == 1)
			return oneImageHeight;
		if (m == 2)
			return twoImageWidth;
		return thereImageWidth;
	}

	/**
	 * 获取整个view 的高度
	 **/
	private int getLayoutHeight() {
		int m = getPicSize();
		if (m == 0)
			return 0;
		int n = this.j[(m - 1)][0];
		return getFirstRowHeight() + n * (this.thereImageWidth + this.diverWidth);
	}

	private int getPicSize() {
		return Math.min(pictureInfos.size(), 9);
	}

	public void setOnImageClickListener(IImageOnClickListener onClickListener) {
		this.iImageOnClickListener = onClickListener;
	}


	/**
	 *
	 * @param pInfos
	 */
	public void setPictureInfos(ArrayList<MessageInfo.PictureInfo> pInfos) {
		if (pInfos.isEmpty()) {
			return;
		}

			int n = 0;
			if (n < Math.min(pInfos.size(), 9)) {
				int[] arrayOfInt = i[(-1 + Math.min(pInfos.size(), 9))];
				while (n < arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2]) {
					if (n < arrayOfInt[0]) {
						this.j[n][0] = 0;
						this.j[n][1] = n;
					} else if (n < arrayOfInt[1] + arrayOfInt[0]) {
						this.j[n][0] = 1;
						this.j[n][1] = (n - arrayOfInt[0]);
					} else {
						this.j[n][0] = 2;
						this.j[n][1] = (n - arrayOfInt[0] - arrayOfInt[1]);
					}
					n++;
				}
			}
			requestLayout();
		if ((!this.pictureInfos.containsAll(pInfos)) || (!pInfos.containsAll(this.pictureInfos))) {
			this.pictureInfos = pInfos;
			Log.v("lijing","images size is "+ pictureInfos.size());
		}else{
			Log.v("lijing","images contaions");
		}

	}

	@Override
	protected LayoutParams generateLayoutParams(LayoutParams p) {
		return new MarginLayoutParams(p);
	}

	public interface IImageOnClickListener {
		void onClick(View v, int position);
	}

}
