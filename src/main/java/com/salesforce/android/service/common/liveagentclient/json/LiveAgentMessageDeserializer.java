package com.salesforce.android.service.common.liveagentclient.json;

import com.facebook.share.internal.ShareConstants;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.o;
import com.google.a.p;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import com.salesforce.android.service.common.liveagentclient.response.message.UnregisteredMessage;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;

class LiveAgentMessageDeserializer implements k<LiveAgentMessage> {
    private static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentMessageDeserializer.class);
    private final LiveAgentMessageRegistry mLiveAgentMessageRegistry;

    public LiveAgentMessageDeserializer(LiveAgentMessageRegistry liveAgentMessageRegistry) {
        this.mLiveAgentMessageRegistry = liveAgentMessageRegistry;
    }

    public LiveAgentMessage deserialize(l lVar, Type type, j jVar) throws p {
        if (lVar == null) {
            log.warn("Unable to deserialize LiveAgentMessage - Element is null");
            return null;
        }
        o m = lVar.m();
        String c2 = m.c("type").c();
        l c3 = m.c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Class contentType = this.mLiveAgentMessageRegistry.getContentType(c2);
        if (contentType == null) {
            log.error("Unregistered LiveAgent Message encountered. Type[{}] - Content[{}] ", c2, c3);
            return new UnregisteredMessage(c2, c3);
        }
        log.trace("De-serializing LiveAgentMessage - Type[{}] - Class[{}] - Content[{}]", c2, contentType.getSimpleName(), c3);
        return new LiveAgentMessage(c2, jVar.a(c3, contentType));
    }
}
