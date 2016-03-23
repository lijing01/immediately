package com.tracelijing.tlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Trace (Tapatalk) on 2016/2/17.
 * keyboard 辅助类
 */
public class KeyBoardUtils {

	/**
	 * hide the soft keyboard
	 * */
	public static void hideSoftKeyb(Context context, View inputText) {
		try{
			if (context != null && inputText != null && inputText.getWindowToken()!=null) {
				InputMethodManager imm = (InputMethodManager) context
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(inputText.getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}catch(Exception e){

		}
	}

	/**
	 * show the soft keyboard
	 */
	public static void showSoftKeyb(Context context, View inputText) {
		try {
			if (context != null && inputText != null) {
				InputMethodManager imm = (InputMethodManager) context
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(inputText, InputMethodManager.SHOW_IMPLICIT);
			}
		} catch (Exception e) {

		}
	}

		
	public static void setKeyboardFocus(final EditText primaryTextField, long delaySeconds) {
		(new Handler()).postDelayed(new Runnable() {
			public void run() {
				primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 1, 1, 0));
				primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 1, 1, 0));
			}
		}, delaySeconds);
	}
}
