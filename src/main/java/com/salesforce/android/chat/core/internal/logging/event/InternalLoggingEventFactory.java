package com.salesforce.android.chat.core.internal.logging.event;

import com.salesforce.android.service.common.liveagentlogging.event.BackgroundedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.event.DeviceEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent;
import com.salesforce.android.service.common.liveagentlogging.event.LifecycleEvent;
import com.salesforce.android.service.common.liveagentlogging.event.OrientationEvent;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

public class InternalLoggingEventFactory implements LoggingEventFactory {
    public ChatMessageEvent createChatMessageEvent(String str, String str2) {
        return new ChatMessageEvent(str, str2);
    }

    public DeviceEvent createDeviceEvent(String str, String str2, String str3, String str4, String str5, String str6) {
        return new DeviceEvent(BaseEvent.SDK_CHAT, str, str2, str3, str4, str5, str6);
    }

    public LifecycleEvent createLifecycleEvent(String str, String str2, String str3) {
        return new LifecycleEvent(BaseEvent.SDK_CHAT, str, str2, str3);
    }

    public LifecycleEvent createLifecycleEvent(String str, String str2, String str3, String str4) {
        return new LifecycleEvent(BaseEvent.SDK_CHAT, str, str2, str3, str4);
    }

    public ConnectivityEvent createConnectivityEvent(String str, String str2, String str3) {
        return new ConnectivityEvent(BaseEvent.SDK_CHAT, str, str2, str3);
    }

    public BatteryEvent createBatteryEvent(String str, int i) {
        return new BatteryEvent(BaseEvent.SDK_CHAT, str, i);
    }

    public OrientationEvent createOrientationEvent(String str, Orientation orientation) {
        return new OrientationEvent(BaseEvent.SDK_CHAT, str, orientation);
    }

    public BackgroundedEvent createBackgroundedEvent(String str, boolean z) {
        return new BackgroundedEvent(BaseEvent.SDK_CHAT, str, z);
    }

    public ErrorEvent createErrorEvent(String str, String str2, Integer num, String str3) {
        return new ErrorEvent(BaseEvent.SDK_CHAT, str, str2, num, str3);
    }

    public ChatFileTransferEvent createChatFileTransferEvent(String str, String str2, String str3) {
        return new ChatFileTransferEvent(str, str2, str3);
    }

    public AgentGroupConferenceEvent createAgentGroupConferenceEvent(String str, String str2, String str3) {
        return new AgentGroupConferenceEvent(str, str2, str3);
    }
}
