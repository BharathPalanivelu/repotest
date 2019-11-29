package com.salesforce.android.chat.ui.internal.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.appcompat.a.a.a;
import androidx.core.app.i;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.messaging.AgentInformationListener;
import com.salesforce.android.chat.ui.internal.messaging.AgentMessageListener;
import com.salesforce.android.chat.ui.internal.messaging.MessageReceiver;
import com.salesforce.android.service.common.ui.internal.utils.DrawableUtils;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationManager;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationManager;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatNotificationManager implements AgentInformationListener, AgentMessageListener, BackgroundTracker.Listener {
    static final int NOTIFICATION_ID = 789789;
    private static final ServiceLogger log = ServiceLogging.getLogger(ChatNotificationManager.class);
    private final Bitmap mAgentAvatar;
    private AgentInformation mAgentInformation;
    private final BackgroundTracker mBackgroundTracker;
    List<ChatMessage> mChatMessages;
    private final PendingIntent mLaunchIntent;
    private final NotificationBuilder mNotificationBuilder;
    private final NotificationManager mNotificationManager;

    public void onAgentJoinedConference(String str) {
    }

    public void onAgentLeftConference(String str) {
    }

    public void onTransferToButtonInitiated() {
    }

    private ChatNotificationManager(Builder builder) {
        this.mChatMessages = new ArrayList();
        MessageReceiver access$000 = builder.mMessageReceiver;
        this.mBackgroundTracker = builder.mBackgroundTracker;
        this.mNotificationManager = builder.mNotificationManager;
        this.mNotificationBuilder = builder.mNotificationBuilder;
        this.mAgentAvatar = builder.mAgentAvatar;
        this.mLaunchIntent = builder.mLaunchIntent;
        builder.mNotificationManager.createNotificationChannel(builder.mNotificationChannel);
        this.mBackgroundTracker.start();
        this.mBackgroundTracker.addListener(this);
        this.mBackgroundTracker.onActivityResume((Activity) null);
        access$000.addAgentMessageListener(this);
        access$000.addAgentInformationListener(this);
    }

    /* access modifiers changed from: package-private */
    public Notification createNotification(String str, String str2, i.g gVar) {
        return this.mNotificationBuilder.setSmallIcon(R.drawable.salesforce_chat_service_icon).setLargeIcon(this.mAgentAvatar).setWhen(new Date().getTime()).setContentTitle(str).setContentText(str2).setStyle(gVar).setAutoCancel(true).setVibrate(new long[0]).setDefaults(-1).setPriority(1).setContentIntent(this.mLaunchIntent).build();
    }

    /* access modifiers changed from: package-private */
    public void showNotification(Notification notification) {
        log.debug("Notifying the user of a new message.");
        this.mNotificationManager.notify(NOTIFICATION_ID, notification);
    }

    private i.g createNotificationStyle(List<ChatMessage> list) {
        i.f fVar = new i.f();
        for (ChatMessage text : list) {
            fVar.c(text.getText());
        }
        return fVar;
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        if (this.mBackgroundTracker.isInBackground()) {
            AgentInformation agentInformation = this.mAgentInformation;
            if (agentInformation == null) {
                log.warn("Agent message received but Agent Information is not available: {}", chatMessage.getText());
                return;
            }
            log.debug("Agent message received. {}: \"{}\"", agentInformation.getAgentName(), chatMessage.getText());
            this.mChatMessages.add(chatMessage);
            showNotification(createNotification(this.mAgentInformation.getAgentName(), chatMessage.getText(), createNotificationStyle(this.mChatMessages)));
        }
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        this.mAgentInformation = agentInformation;
    }

    public void onBackgroundChange(boolean z) {
        if (!z) {
            this.mChatMessages.clear();
        }
    }

    public static class Builder {
        private ActivityTracker mActivityTracker;
        /* access modifiers changed from: private */
        public Bitmap mAgentAvatar;
        /* access modifiers changed from: private */
        public BackgroundTracker mBackgroundTracker;
        private Context mContext;
        private final IntentFactory mIntentFactory = new IntentFactory();
        /* access modifiers changed from: private */
        public PendingIntent mLaunchIntent;
        /* access modifiers changed from: private */
        public MessageReceiver mMessageReceiver;
        /* access modifiers changed from: private */
        public NotificationBuilder mNotificationBuilder;
        /* access modifiers changed from: private */
        public NotificationChannel mNotificationChannel;
        /* access modifiers changed from: private */
        public NotificationManager mNotificationManager;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder messageReceiver(MessageReceiver messageReceiver) {
            this.mMessageReceiver = messageReceiver;
            return this;
        }

        public Builder activityTracker(ActivityTracker activityTracker) {
            this.mActivityTracker = activityTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder backgroundTracker(BackgroundTracker backgroundTracker) {
            this.mBackgroundTracker = backgroundTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder notificationChannel(NotificationChannel notificationChannel) {
            this.mNotificationChannel = notificationChannel;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder notificationManager(NotificationManager notificationManager) {
            this.mNotificationManager = notificationManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder notificationBuilder(NotificationBuilder notificationBuilder) {
            this.mNotificationBuilder = notificationBuilder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder agentAvatar(Bitmap bitmap) {
            this.mAgentAvatar = bitmap;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder launchIntent(PendingIntent pendingIntent) {
            this.mLaunchIntent = pendingIntent;
            return this;
        }

        public ChatNotificationManager build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mMessageReceiver);
            Arguments.checkNotNull(this.mActivityTracker);
            if (this.mBackgroundTracker == null) {
                this.mBackgroundTracker = BackgroundTracker.create(this.mActivityTracker);
            }
            if (this.mNotificationChannel == null) {
                this.mNotificationChannel = new SalesforceNotificationChannel(this.mContext.getString(R.string.chat_message_notification_channel_id), this.mContext.getString(R.string.chat_message_notification_channel_name), 4);
            }
            if (this.mNotificationManager == null) {
                this.mNotificationManager = SalesforceNotificationManager.from(this.mContext);
            }
            if (this.mNotificationBuilder == null) {
                this.mNotificationBuilder = new SalesforceNotificationBuilder.Builder().channel(this.mNotificationChannel).build(this.mContext);
            }
            if (this.mAgentAvatar == null) {
                Drawable b2 = a.b(this.mContext, R.drawable.salesforce_agent_avatar);
                if (b2 == null) {
                    b2 = a.b(this.mContext, R.drawable.salesforce_chat_service_icon);
                }
                this.mAgentAvatar = DrawableUtils.drawableToBitmap(b2);
            }
            if (this.mLaunchIntent == null) {
                this.mLaunchIntent = this.mIntentFactory.createActivityPendingIntent(this.mContext, 0, this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName()), 134217728);
            }
            return new ChatNotificationManager(this);
        }
    }
}
