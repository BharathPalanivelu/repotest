package com.salesforce.android.chat.ui.internal.minimize.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.minimize.presenter.QueuedMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.view.ViewBinderBuilder;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class QueuedMinimizedView implements MinimizeViewBinder {
    private View mContentView;
    private final QueuedMinimizedPresenter mPresenter;
    private SalesforceTextView mQueueCounter;
    private SalesforceTextView mText;

    public boolean onBackPressed() {
        return false;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    private QueuedMinimizedView(Builder builder) {
        this.mPresenter = builder.mPresenter;
    }

    public Boolean maximize() {
        return false;
    }

    public void setQueuePosition(int i) {
        this.mQueueCounter.setText("#" + (i + 1));
    }

    public void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mContentView = layoutInflater.inflate(R.layout.chat_minimized_queued, viewGroup, true);
        this.mQueueCounter = (SalesforceTextView) this.mContentView.findViewById(R.id.chat_minimized_queued_counter_text);
        this.mText = (SalesforceTextView) this.mContentView.findViewById(R.id.chat_minimized_queued_text);
        this.mPresenter.onViewCreated((MinimizeViewBinder) this);
    }

    public void onDestroyView() {
        this.mPresenter.onViewDestroyed((MinimizeViewBinder) this);
    }

    public static class Builder implements ViewBinderBuilder<QueuedMinimizedView, QueuedMinimizedPresenter> {
        /* access modifiers changed from: private */
        public QueuedMinimizedPresenter mPresenter;

        public int getKey() {
            return 3;
        }

        public Builder setPresenter(QueuedMinimizedPresenter queuedMinimizedPresenter) {
            this.mPresenter = queuedMinimizedPresenter;
            return this;
        }

        public QueuedMinimizedView build() {
            Arguments.checkNotNull(this.mPresenter);
            return new QueuedMinimizedView(this);
        }
    }
}
