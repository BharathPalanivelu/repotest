package com.salesforce.android.chat.ui.internal.prechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.service.common.ui.views.SalesforceButton;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class PreChatViewBinder implements PreChatView {
    private static final float DISABLED_ALPHA = 0.3f;
    private static final float ENABLED_ALPHA = 1.0f;
    private final PreChatActivity mPreChatActivity;
    private final PreChatAdapter mPreChatAdapter;
    /* access modifiers changed from: private */
    public final BasicAsync<Void> mPreChatComplete;
    /* access modifiers changed from: private */
    public final PreChatPresenter mPreChatPresenter;
    private SalesforceButton mStartButton;

    public boolean onBackPressed() {
        return false;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    private PreChatViewBinder(Builder builder) {
        this.mPreChatActivity = builder.mPreChatActivity;
        this.mPreChatPresenter = builder.mPreChatPresenter;
        this.mPreChatAdapter = builder.mPreChatAdapter;
        this.mPreChatComplete = builder.mPreChatComplete;
    }

    public void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        bind(viewGroup);
        this.mPreChatPresenter.onViewCreated(this);
    }

    public void onDestroyView() {
        this.mPreChatPresenter.onViewDestroyed(this);
    }

    public void onSatisfiedUpdated(Boolean bool) {
        this.mStartButton.setEnabled(bool.booleanValue());
        this.mStartButton.setAlpha(bool.booleanValue() ? ENABLED_ALPHA : DISABLED_ALPHA);
    }

    public void onPreChatComplete(Async.CompletionHandler completionHandler) {
        this.mPreChatComplete.onComplete(completionHandler);
    }

    public void onToolbarInflated(Toolbar toolbar) {
        toolbar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PreChatViewBinder.this.mPreChatComplete.complete();
            }
        });
    }

    private void bind(ViewGroup viewGroup) {
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.pre_chat_fields);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mPreChatActivity));
        recyclerView.setAdapter(this.mPreChatAdapter);
        this.mStartButton = (SalesforceButton) viewGroup.findViewById(R.id.pre_chat_accept);
        this.mStartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PreChatViewBinder.this.mPreChatPresenter.isAllFieldsSatisfied()) {
                    PreChatViewBinder.this.closeKeyboard();
                    PreChatViewBinder.this.mPreChatComplete.complete();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mPreChatActivity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(1, 0);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public PreChatActivity mPreChatActivity;
        /* access modifiers changed from: private */
        public PreChatAdapter mPreChatAdapter;
        /* access modifiers changed from: private */
        public BasicAsync<Void> mPreChatComplete;
        /* access modifiers changed from: private */
        public PreChatPresenter mPreChatPresenter;

        public Builder presenter(PreChatPresenter preChatPresenter) {
            this.mPreChatPresenter = preChatPresenter;
            return this;
        }

        public Builder activity(PreChatActivity preChatActivity) {
            this.mPreChatActivity = preChatActivity;
            return this;
        }

        public Builder preChatAdapter(PreChatAdapter preChatAdapter) {
            this.mPreChatAdapter = preChatAdapter;
            return this;
        }

        public Builder preChatComplete(BasicAsync<Void> basicAsync) {
            this.mPreChatComplete = basicAsync;
            return this;
        }

        public PreChatView build() {
            Arguments.checkNotNull(this.mPreChatPresenter);
            Arguments.checkNotNull(this.mPreChatActivity);
            Arguments.checkNotNull(this.mPreChatAdapter);
            if (this.mPreChatComplete == null) {
                this.mPreChatComplete = new BasicAsync<>();
            }
            return new PreChatViewBinder(this);
        }
    }
}
