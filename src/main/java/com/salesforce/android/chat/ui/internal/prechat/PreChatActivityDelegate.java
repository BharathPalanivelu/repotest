package com.salesforce.android.chat.ui.internal.prechat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.prechat.PreChatViewBinder;
import com.salesforce.android.chat.ui.internal.presenter.PresenterManager;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import tencent.tls.platform.SigType;

class PreChatActivityDelegate {
    /* access modifiers changed from: private */
    public final PreChatActivity mPreChatActivity;
    /* access modifiers changed from: private */
    public PreChatTracker mPreChatTracker;
    private PreChatView mPreChatView;
    private final PreChatViewBinder.Builder mPreChatViewBinderBuilder;
    private PresenterManager mPresenterManager;

    static Intent createStartIntent(Context context, IntentFactory intentFactory) {
        Intent createIntent = intentFactory.createIntent(context, PreChatActivity.class);
        createIntent.addFlags(SigType.TLS);
        return createIntent;
    }

    private PreChatActivityDelegate(Builder builder) {
        this.mPreChatActivity = builder.mPreChatActivity;
        this.mPreChatViewBinderBuilder = builder.mPreChatViewBinderBuilder;
    }

    /* access modifiers changed from: package-private */
    public void setPreChatTracker(PreChatTracker preChatTracker) {
        this.mPreChatTracker = preChatTracker;
    }

    /* access modifiers changed from: package-private */
    public void setPresenterManager(PresenterManager presenterManager) {
        this.mPresenterManager = presenterManager;
    }

    /* access modifiers changed from: package-private */
    public void onCreate(Bundle bundle) {
        this.mPreChatActivity.setContentView(R.layout.pre_chat);
        LayoutInflater layoutInflater = this.mPreChatActivity.getLayoutInflater();
        Arguments.checkNotNull(this.mPresenterManager);
        PreChatPresenter preChatPresenter = (PreChatPresenter) this.mPresenterManager.getPresenter(6);
        preChatPresenter.setPreChatInputs(this.mPreChatTracker.getPreChatInputs());
        this.mPreChatView = this.mPreChatViewBinderBuilder.activity(this.mPreChatActivity).presenter(preChatPresenter).preChatAdapter(new PreChatAdapter(this.mPreChatTracker.getPreChatInputs(), preChatPresenter)).build();
        Arguments.checkNotNull(this.mPreChatView);
        ViewGroup viewGroup = (ViewGroup) this.mPreChatActivity.findViewById(16908290);
        this.mPreChatActivity.setSupportActionBar((Toolbar) viewGroup.findViewById(R.id.pre_chat_toolbar));
        Arguments.checkNotNull(this.mPreChatActivity.getSupportActionBar());
        this.mPreChatActivity.getSupportActionBar().a((CharSequence) null);
        this.mPreChatActivity.getSupportActionBar().a(R.string.chat_end_session_content_description);
        this.mPreChatView.onCreateView(layoutInflater, viewGroup);
        this.mPreChatView.onPreChatComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                PreChatActivityDelegate.this.mPreChatTracker.sendResult(true);
                PreChatActivityDelegate.this.mPreChatActivity.finish();
            }
        });
        PreChatView preChatView = this.mPreChatView;
        if (preChatView != null && bundle != null) {
            preChatView.onRestoreInstanceState(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.mPreChatTracker = null;
        this.mPresenterManager = null;
        this.mPreChatView = null;
    }

    /* access modifiers changed from: package-private */
    public boolean onBackPressed() {
        PreChatTracker preChatTracker = this.mPreChatTracker;
        if (preChatTracker == null) {
            return true;
        }
        preChatTracker.sendResult(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.mPreChatTracker.sendResult(false);
        this.mPreChatActivity.finish();
        return true;
    }

    static class Builder {
        /* access modifiers changed from: private */
        public PreChatActivity mPreChatActivity;
        /* access modifiers changed from: private */
        public PreChatViewBinder.Builder mPreChatViewBinderBuilder;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder preChatActivity(PreChatActivity preChatActivity) {
            this.mPreChatActivity = preChatActivity;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder preChatViewBinderBuilder(PreChatViewBinder.Builder builder) {
            this.mPreChatViewBinderBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public PreChatActivityDelegate build() {
            Arguments.checkNotNull(this.mPreChatActivity);
            if (this.mPreChatViewBinderBuilder == null) {
                this.mPreChatViewBinderBuilder = new PreChatViewBinder.Builder();
            }
            return new PreChatActivityDelegate(this);
        }
    }
}
