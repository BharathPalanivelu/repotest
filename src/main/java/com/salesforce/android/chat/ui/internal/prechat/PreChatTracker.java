package com.salesforce.android.chat.ui.internal.prechat;

import android.app.Activity;
import android.content.Context;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.core.model.PreChatField;
import com.salesforce.android.chat.ui.PreChatUIListener;
import com.salesforce.android.chat.ui.internal.model.PreChatInput;
import com.salesforce.android.chat.ui.internal.presenter.PresenterManager;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.OptionalReference;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PreChatTracker implements ActivityTracker.OnCreateListener, ActivityTracker.OnDestroyListener {
    private ActivityTracker mActivityTracker;
    private final Context mApplicationContext;
    private final IntentFactory mIntentFactory;
    private OptionalReference<PreChatActivityDelegate> mPreChatActivityDelegateReference;
    private final List<ChatUserData> mPreChatInputs;
    private Set<PreChatUIListener> mPreChatUIListeners;
    private final PresenterManager mPresenterManager;
    private BasicAsync<Boolean> mResult;

    private PreChatTracker(Builder builder) {
        this.mPreChatUIListeners = Collections.newSetFromMap(new ConcurrentHashMap());
        this.mPreChatInputs = filterPreChatInput(builder.mChatUserData);
        this.mApplicationContext = builder.mApplicationContext;
        this.mIntentFactory = builder.mIntentFactory;
        this.mPresenterManager = builder.mPresenterManager;
        this.mPreChatActivityDelegateReference = builder.mPreChatActivityDelegateOptionalReference;
        this.mActivityTracker = builder.mActivityTracker;
    }

    private List<ChatUserData> filterPreChatInput(List<ChatUserData> list) {
        ArrayList arrayList = new ArrayList();
        for (ChatUserData next : list) {
            boolean z = (next instanceof PreChatField) && !((PreChatField) next).isHidden().booleanValue();
            if ((next instanceof PreChatInput) || z) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Async<Boolean> showPreChatView() {
        BasicAsync<Boolean> basicAsync = this.mResult;
        if (basicAsync != null) {
            return basicAsync;
        }
        this.mResult = new BasicAsync<>();
        this.mActivityTracker.onCreate(this).onDestroy(this);
        this.mApplicationContext.startActivity(PreChatActivityDelegate.createStartIntent(this.mApplicationContext, this.mIntentFactory));
        return this.mResult;
    }

    /* access modifiers changed from: package-private */
    public List<ChatUserData> getPreChatInputs() {
        return this.mPreChatInputs;
    }

    public void addPreChatListener(PreChatUIListener preChatUIListener) {
        this.mPreChatUIListeners.add(preChatUIListener);
    }

    public void removePreChatListener(PreChatUIListener preChatUIListener) {
        this.mPreChatUIListeners.remove(preChatUIListener);
    }

    /* access modifiers changed from: package-private */
    public void sendResult(Boolean bool) {
        PreChatActivityDelegate preChatActivityDelegate = this.mPreChatActivityDelegateReference.get();
        if (!(this.mResult == null || preChatActivityDelegate == null)) {
            preChatActivityDelegate.setPreChatTracker((PreChatTracker) null);
            this.mResult.setResult(bool);
            notifyPreChatResult(bool.booleanValue());
        }
        this.mPreChatActivityDelegateReference.clear();
        this.mResult = null;
    }

    public void onActivityCreate(Activity activity) {
        if (activity instanceof PreChatActivity) {
            PreChatActivity preChatActivity = (PreChatActivity) activity;
            preChatActivity.getActivityDelegate().setPreChatTracker(this);
            preChatActivity.getActivityDelegate().setPresenterManager(this.mPresenterManager);
            this.mPreChatActivityDelegateReference = new OptionalReference<>(preChatActivity.getActivityDelegate());
        }
    }

    public void onActivityDestroy(Activity activity) {
        if (activity instanceof PreChatActivity) {
            this.mPreChatActivityDelegateReference.clearIfSame(((PreChatActivity) activity).getActivityDelegate());
            this.mPresenterManager.destroyPresenter(6);
        }
    }

    private void notifyPreChatResult(boolean z) {
        for (PreChatUIListener next : this.mPreChatUIListeners) {
            if (z) {
                next.onPreChatSubmitted();
            } else {
                next.onPreChatCancelled();
            }
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ActivityTracker mActivityTracker;
        /* access modifiers changed from: private */
        public Context mApplicationContext;
        /* access modifiers changed from: private */
        public List<ChatUserData> mChatUserData;
        /* access modifiers changed from: private */
        public IntentFactory mIntentFactory;
        OptionalReference<PreChatActivityDelegate> mPreChatActivityDelegateOptionalReference;
        /* access modifiers changed from: private */
        public PresenterManager mPresenterManager;

        public Builder chatUserData(List<ChatUserData> list) {
            this.mChatUserData = list;
            return this;
        }

        public Builder presenterManager(PresenterManager presenterManager) {
            this.mPresenterManager = presenterManager;
            return this;
        }

        public Builder applicationContext(Context context) {
            this.mApplicationContext = context;
            return this;
        }

        public Builder activityTracker(ActivityTracker activityTracker) {
            this.mActivityTracker = activityTracker;
            return this;
        }

        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder preChatActivityDelegateReference(OptionalReference<PreChatActivityDelegate> optionalReference) {
            this.mPreChatActivityDelegateOptionalReference = optionalReference;
            return this;
        }

        public PreChatTracker build() {
            Arguments.checkNotNull(this.mChatUserData);
            Arguments.checkNotNull(this.mIntentFactory);
            Arguments.checkNotNull(this.mActivityTracker);
            Arguments.checkNotNull(this.mPresenterManager);
            if (this.mPreChatActivityDelegateOptionalReference == null) {
                this.mPreChatActivityDelegateOptionalReference = new OptionalReference<>(null);
            }
            return new PreChatTracker(this);
        }
    }
}
