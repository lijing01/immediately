package com.tracelijing.immediately.utils;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by Trace (Tapatalk) on 2017/1/8.
 * 带异常处理的 subscriber
 * http://www.open-open.com/lib/view/open1477020338949.html
 */

public class ErrorHandlerSubscriber<T> extends Subscriber<T> {
	private Action1<T> onNext;
	private Action1<Throwable> onError;

	public ErrorHandlerSubscriber(Action1<T> onNext, Action1<Throwable> onError) {
		this.onNext = onNext;
		this.onError = onError;
	}

	@Override
	public void onCompleted() {
	}

	@Override
	public void onError(Throwable e) {
		if (onError != null) {
			onError.call(e);
		}
	}

	@Override
	public void onNext(T t) {
		try {
			if (onNext != null) {
				onNext.call(t);
			}
		} catch (Exception e) {
			if (onError != null) {
				onError.call(e);
			} else {
				// log it
				e.printStackTrace();
			}
		}
	}
}
