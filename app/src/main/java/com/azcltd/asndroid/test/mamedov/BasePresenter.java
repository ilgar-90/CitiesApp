package com.azcltd.asndroid.test.mamedov;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by ilgar on 9/12/2017.
 */

public abstract class BasePresenter<M, V> {
    protected M model;
    protected V view;

    public void bindView(V view) {
        this.view = view;
    }

    public void unbindView() {
        this.view = null;
    }
}
