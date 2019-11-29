package com.salesforce.android.service.common.liveagentclient.json;

import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import java.lang.reflect.Type;

public class LiveAgentStringResponseDeserializer implements k<LiveAgentStringResponse> {
    public LiveAgentStringResponse deserialize(l lVar, Type type, j jVar) throws p {
        return new LiveAgentStringResponse(lVar.c());
    }
}
