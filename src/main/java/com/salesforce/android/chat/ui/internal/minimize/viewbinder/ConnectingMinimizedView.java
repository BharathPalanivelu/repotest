package com.salesforce.android.chat.ui.internal.minimize.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.minimize.presenter.ConnectingMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.view.ViewBinderBuilder;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ConnectingMinimizedView implements MinimizeViewBinder {
    private View mContentView;
    private ImageView mImageView;
    private final ConnectingMinimizedPresenter mPresenter;
    private SalesforceTextView mText;

    public boolean onBackPressed() {
        return false;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    private ConnectingMinimizedView(Builder builder) {
        this.mPresenter = builder.mPresenter;
    }

    public Boolean maximize() {
        return false;
    }

    public void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mContentView = layoutInflater.inflate(R.layout.chat_minimized_connecting, viewGroup, true);
        this.mImageView = (ImageView) this.mContentView.findViewById(R.id.chat_minimized_connecting_image);
        this.mText = (SalesforceTextView) this.mContentView.findViewById(R.id.chat_minimized_connecting_text);
        this.mPresenter.onViewCreated((MinimizeViewBinder) this);
    }

    public void onDestroyView() {
        this.mPresenter.onViewDestroyed((MinimizeViewBinder) this);
    }

    public static class Builder implements ViewBinderBuilder<ConnectingMinimizedView, ConnectingMinimizedPresenter> {
        /* access modifiers changed from: private */
        public ConnectingMinimizedPresenter mPresenter;

        public int getKey() {
            return 2;
        }

        public Builder setPresenter(ConnectingMinimizedPresenter connectingMinimizedPresenter) {
            this.mPresenter = connectingMinimizedPresenter;
            return this;
        }

        public ConnectingMinimizedView build() {
            Arguments.checkNotNull(this.mPresenter);
            return new ConnectingMinimizedView(this);
        }
    }
}
