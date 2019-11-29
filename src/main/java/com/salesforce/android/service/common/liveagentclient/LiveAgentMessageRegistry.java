package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.response.message.AsyncResult;
import com.salesforce.android.service.common.liveagentclient.response.message.SwitchServerMessage;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.HashMap;
import java.util.Map;

public class LiveAgentMessageRegistry {
    private static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentMessageRegistry.class);
    private Map<String, Class> mMessageContentMap = new HashMap();

    public LiveAgentMessageRegistry() {
        register(AsyncResult.TYPE, AsyncResult.class);
        register(SwitchServerMessage.TYPE, SwitchServerMessage.class);
    }

    public LiveAgentMessageRegistry register(String str, Class cls) {
        this.mMessageContentMap.put(str, cls);
        log.trace("Registered LiveAgentMessage content type {} as class {}", str, cls.getSimpleName());
        return this;
    }

    public Class getContentType(String str) {
        return this.mMessageContentMap.get(str);
    }
}
