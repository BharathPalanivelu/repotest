package com.salesforce.android.chat.core.internal.logging.event;

import com.salesforce.android.service.common.liveagentlogging.event.BackgroundedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.event.DeviceEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent;
import com.salesforce.android.service.common.liveagentlogging.event.LifecycleEvent;
import com.salesforce.android.service.common.liveagentlogging.event.OrientationEvent;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

public interface LoggingEventFactory {
    AgentGroupConferenceEvent createAgentGroupConferenceEvent(String str, String str2, String str3);

    BackgroundedEvent createBackgroundedEvent(String str, boolean z);

    BatteryEvent createBatteryEvent(String str, int i);

    ChatFileTransferEvent createChatFileTransferEvent(String str, String str2, String str3);

    ChatMessageEvent createChatMessageEvent(String str, String str2);

    ConnectivityEvent createConnectivityEvent(String str, String str2, String str3);

    DeviceEvent createDeviceEvent(String str, String str2, String str3, String str4, String str5, String str6);

    ErrorEvent createErrorEvent(String str, String str2, Integer num, String str3);

    LifecycleEvent createLifecycleEvent(String str, String str2, String str3);

    LifecycleEvent createLifecycleEvent(String str, String str2, String str3, String str4);

    OrientationEvent createOrientationEvent(String str, Orientation orientation);
}
