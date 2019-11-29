package com.salesforce.android.service.common.liveagentclient.json;

import com.facebook.share.internal.ShareConstants;
import com.google.a.i;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.o;
import com.google.a.p;
import com.salesforce.android.service.common.liveagentclient.response.ReconnectResponse;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;

public class LiveAgentReconnectResponseDeserializer implements k<ReconnectResponse> {
    private static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentReconnectResponseDeserializer.class);

    public ReconnectResponse deserialize(l lVar, Type type, j jVar) throws p {
        if (lVar == null) {
            log.warn("Unable to deserialize ReconnectResponse - Element is null");
            return null;
        }
        i d2 = lVar.m().d("messages");
        if (d2.a() == 0) {
            log.warn("Reconnect message body is not present. Unable to parse response.");
            return null;
        }
        o m = d2.a(0).m().c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE).m();
        if (!m.b("affinityToken")) {
            throw new p("ReconnectResponse does not contain an affinity token.");
        } else if (m.b("resetSequence")) {
            return new ReconnectResponse(m.c("resetSequence").h(), m.c("affinityToken").c());
        } else {
            return new ReconnectResponse(m.c("affinityToken").c());
        }
    }
}
