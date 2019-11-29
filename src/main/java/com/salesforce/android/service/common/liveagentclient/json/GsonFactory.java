package com.salesforce.android.service.common.liveagentclient.json;

import com.google.a.f;
import com.google.a.g;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.liveagentclient.response.ReconnectResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import java.lang.reflect.Type;
import java.util.Collection;

public class GsonFactory {
    public static f createGson(g gVar, LiveAgentMessageRegistry liveAgentMessageRegistry, boolean z) {
        if (z) {
            gVar.a((Class<?>) Collection.class, (Object) new CollectionSerializer());
        }
        return gVar.a((Type) ReconnectResponse.class, (Object) new LiveAgentReconnectResponseDeserializer()).a((Type) LiveAgentStringResponse.class, (Object) new LiveAgentStringResponseDeserializer()).a((Class<?>) LiveAgentMessage.class, (Object) new LiveAgentMessageDeserializer(liveAgentMessageRegistry)).d();
    }
}
