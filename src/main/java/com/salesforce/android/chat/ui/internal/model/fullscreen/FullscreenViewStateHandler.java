package com.salesforce.android.chat.ui.internal.model.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.facebook.internal.ServerProtocol;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.fullscreen.viewholder.FullscreenViewHolder;
import com.salesforce.android.chat.ui.internal.model.ViewStateHandler;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import d.d.b.j;

@Mockable
public class FullscreenViewStateHandler implements QueueListener, SessionStateListener, ViewStateHandler {
    private final ActivityTracker mActivityTracker;
    private ActivityReference<Activity> mAttachedTo = ActivityReference.none();
    private ChatClient mChatClient;
    private final InternalChatUIClient mChatUIClient;
    private ChatSessionState mCurrentState = ChatSessionState.Ready;
    private FullscreenViewHolder mFullscreenViewHolder;
    private final boolean mQueuePositionHidden;

    public void attachTo(Activity activity) {
        j.b(activity, "activity");
    }

    public int getCurrentPresenter() {
        return -1;
    }

    public FullscreenViewStateHandler(InternalChatUIClient internalChatUIClient, ActivityTracker activityTracker, boolean z) {
        j.b(internalChatUIClient, "mChatUIClient");
        j.b(activityTracker, "mActivityTracker");
        this.mChatUIClient = internalChatUIClient;
        this.mActivityTracker = activityTracker;
        this.mQueuePositionHidden = z;
        addListeners();
        this.mChatUIClient.launchChatFeedUI();
        this.mCurrentState = ChatSessionState.Initializing;
    }

    public void onCreate(ViewGroup viewGroup, Context context) {
        j.b(viewGroup, "container");
        j.b(context, "context");
        show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show() {
        /*
            r2 = this;
            com.salesforce.android.service.common.utilities.activity.ActivityReference<android.app.Activity> r0 = r2.mAttachedTo
            if (r0 == 0) goto L_0x001d
            if (r0 != 0) goto L_0x0009
            d.d.b.j.a()
        L_0x0009:
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x001d
            com.salesforce.android.service.common.utilities.activity.ActivityReference<android.app.Activity> r0 = r2.mAttachedTo
            if (r0 != 0) goto L_0x0016
            d.d.b.j.a()
        L_0x0016:
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            goto L_0x0023
        L_0x001d:
            com.salesforce.android.service.common.utilities.activity.ActivityTracker r0 = r2.mActivityTracker
            android.app.Activity r0 = r0.getForegroundActivity()
        L_0x0023:
            if (r0 == 0) goto L_0x002f
            com.salesforce.android.chat.core.model.ChatSessionState r1 = r2.getCurrentState()
            r2.createFullscreenView(r0, r1)
            r2.setAttachedTo(r0)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.model.fullscreen.FullscreenViewStateHandler.show():void");
    }

    public void onMinimizePressed() {
        removeListeners();
    }

    public void onSessionStateChange(ChatSessionState chatSessionState) {
        j.b(chatSessionState, ServerProtocol.DIALOG_PARAM_STATE);
        this.mCurrentState = chatSessionState;
        show();
    }

    public void onSessionEnded(ChatEndReason chatEndReason) {
        j.b(chatEndReason, "endReason");
        teardown();
        FullscreenViewHolder fullscreenViewHolder = this.mFullscreenViewHolder;
        if (fullscreenViewHolder != null) {
            fullscreenViewHolder.onSessionEnded(chatEndReason);
        }
    }

    public void teardown() {
        removeListeners();
    }

    public ChatSessionState getCurrentState() {
        return this.mCurrentState;
    }

    public ChatClient getChatClient() {
        return this.mChatClient;
    }

    public void setChatClient(ChatClient chatClient) {
        this.mChatClient = chatClient;
    }

    public void onQueuePositionUpdate(int i) {
        if (!this.mQueuePositionHidden) {
            FullscreenViewHolder fullscreenViewHolder = this.mFullscreenViewHolder;
            if (fullscreenViewHolder != null) {
                fullscreenViewHolder.updateQueuePositionText(i);
            }
        }
    }

    private void setAttachedTo(Activity activity) {
        this.mAttachedTo = ActivityReference.create(activity);
    }

    private void createFullscreenView(Activity activity, ChatSessionState chatSessionState) {
        if (this.mFullscreenViewHolder == null) {
            this.mFullscreenViewHolder = new FullscreenViewHolder(activity);
        }
        FullscreenViewHolder fullscreenViewHolder = this.mFullscreenViewHolder;
        if (fullscreenViewHolder != null) {
            fullscreenViewHolder.attachTo(chatSessionState);
        }
    }

    private final void addListeners() {
        this.mChatUIClient.addSessionStateListener(this);
        this.mChatUIClient.getMessageReceiver().addQueueListener(this);
    }

    public void removeListeners() {
        this.mChatUIClient.removeSessionStateListener(this);
        this.mChatUIClient.getMessageReceiver().removeQueueListener(this);
    }
}
