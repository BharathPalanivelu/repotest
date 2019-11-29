package com.salesforce.android.chat.core.internal.availability.response;

import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.o;
import com.google.a.p;
import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Iterator;

public class AvailabilityResponseDeserializer implements k<AvailabilityResponse> {
    private static final String Availability = "Availability";
    private static final String IsAvailable = "isAvailable";
    private static final String MessageField = "message";
    private static final String MessagesField = "messages";
    private static final String NewUrl = "newUrl";
    private static final String ResultsField = "results";
    private static final String SwitchServer = "SwitchServer";
    private static final String TypeField = "type";
    private static final ServiceLogger log = ServiceLogging.getLogger(AvailabilityResponseDeserializer.class);
    private String mLastPod;

    public AvailabilityResponseDeserializer(String str) {
        this.mLastPod = str;
    }

    public AvailabilityResponse deserialize(l lVar, Type type, j jVar) throws p {
        AvailabilityState.Status status = AvailabilityState.Status.Unknown;
        String str = this.mLastPod;
        Iterator<l> it = ((o) lVar).d(MessagesField).iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            String c2 = oVar.c("type").c();
            char c3 = 65535;
            int hashCode = c2.hashCode();
            if (hashCode != -2133104261) {
                if (hashCode == 1393356727 && c2.equals("SwitchServer")) {
                    c3 = 1;
                }
            } else if (c2.equals(Availability)) {
                c3 = 0;
            }
            if (c3 == 0) {
                o e2 = oVar.e("message");
                AvailabilityState.Status status2 = AvailabilityState.Status.NoAgentsAvailable;
                Iterator<l> it2 = e2.d(ResultsField).iterator();
                while (it2.hasNext()) {
                    l c4 = ((o) it2.next()).c(IsAvailable);
                    if (c4 != null && c4.h()) {
                        status2 = AvailabilityState.Status.AgentsAvailable;
                    }
                }
                status = status2;
            } else if (c3 == 1) {
                try {
                    str = new URI(oVar.e("message").c(NewUrl).c()).getHost();
                    this.mLastPod = str;
                } catch (Exception e3) {
                    log.error(e3.toString());
                }
            }
        }
        return new AvailabilityResponse(status, str);
    }
}
