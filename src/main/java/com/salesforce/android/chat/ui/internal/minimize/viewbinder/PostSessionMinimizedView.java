package com.salesforce.android.chat.ui.internal.minimize.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.minimize.presenter.PostSessionMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.view.ViewBinderBuilder;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class PostSessionMinimizedView implements MinimizeViewBinder {
    private View mContentView;
    private ImageView mImageView;
    private final PostSessionMinimizedPresenter mPresenter;
    private SalesforceTextView mText;

    public boolean onBackPressed() {
        return false;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    private PostSessionMinimizedView(Builder builder) {
        this.mPresenter = builder.mPresenter;
    }

    public Boolean maximize() {
        return true;
    }

    public void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mContentView = layoutInflater.inflate(R.layout.chat_minimized_post_session, viewGroup, true);
        this.mImageView = (ImageView) this.mContentView.findViewById(R.id.chat_minimized_post_session_image);
        this.mText = (SalesforceTextView) this.mContentView.findViewById(R.id.chat_minimized_post_session_text);
        this.mPresenter.onViewCreated((MinimizeViewBinder) this);
    }

    public void onDestroyView() {
        this.mPresenter.onViewDestroyed((MinimizeViewBinder) this);
    }

    public static class Builder implements ViewBinderBuilder<PostSessionMinimizedView, PostSessionMinimizedPresenter> {
        /* access modifiers changed from: private */
        public PostSessionMinimizedPresenter mPresenter;

        public int getKey() {
            return 5;
        }

        public Builder setPresenter(PostSessionMinimizedPresenter postSessionMinimizedPresenter) {
            this.mPresenter = postSessionMinimizedPresenter;
            return this;
        }

        public PostSessionMinimizedView build() {
            Arguments.checkNotNull(this.mPresenter);
            return new PostSessionMinimizedView(this);
        }
    }
}
