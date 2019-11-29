package com.salesforce.android.service.common.liveagentlogging.internal.json;

import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.google.a.s;
import com.google.a.t;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;

public class BatchedEventsSerializer implements t<BatchedEvents> {
    private static final ServiceLogger log = ServiceLogging.getLogger(BatchedEventsSerializer.class);

    public l serialize(BatchedEvents batchedEvents, Type type, s sVar) {
        o oVar = new o();
        for (BaseEvent next : batchedEvents.getEvents()) {
            String groupIdFromEvent = groupIdFromEvent(next);
            if (groupIdFromEvent == null) {
                log.warn("Ignoring unknown batched event {}", next);
            } else {
                if (!oVar.b(groupIdFromEvent)) {
                    oVar.a(groupIdFromEvent, (l) new i());
                }
                oVar.c(groupIdFromEvent).n().a(sVar.a(next, BaseEvent.class));
            }
        }
        return oVar;
    }

    private String groupIdFromEvent(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(BatchedEvent.class)) {
            return ((BatchedEvent) cls.getAnnotation(BatchedEvent.class)).groupId();
        }
        return null;
    }
}
