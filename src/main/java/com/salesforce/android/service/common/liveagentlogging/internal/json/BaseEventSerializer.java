package com.salesforce.android.service.common.liveagentlogging.internal.json;

import com.google.a.l;
import com.google.a.o;
import com.google.a.s;
import com.google.a.t;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;
import java.util.Date;

public class BaseEventSerializer implements t<BaseEvent> {
    private static final ServiceLogger log = ServiceLogging.getLogger(BaseEventSerializer.class);

    public l serialize(BaseEvent baseEvent, Type type, s sVar) {
        Date timestamp = baseEvent.getTimestamp();
        o oVar = new o();
        oVar.a("service", baseEvent.getSdk());
        oVar.a("clientType", "android");
        oVar.a("organizationId", baseEvent.getOrganizationId());
        oVar.a("correlationId", baseEvent.getCorrelationId());
        oVar.a("clientTimestamp", sVar.a(timestamp));
        oVar.a("uniqueId", baseEvent.getUniqueId());
        log.debug("Serializing BaseEvent {} with correlation ID {}", baseEvent.getClass().getSimpleName(), baseEvent.getCorrelationId());
        l a2 = sVar.a(baseEvent);
        a2.m().a("basicInfo", (l) oVar);
        return a2;
    }
}
