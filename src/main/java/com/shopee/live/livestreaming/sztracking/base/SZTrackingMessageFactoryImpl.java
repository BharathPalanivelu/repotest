package com.shopee.live.livestreaming.sztracking.base;

import com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBModel;
import com.shopee.live.livestreaming.sztracking.proto.Event;
import com.shopee.live.livestreaming.sztracking.proto.EventList;
import com.squareup.wire.Wire;
import e.f;

public class SZTrackingMessageFactoryImpl implements SZTrackingMessageFactory<Event, EventList> {
    private Wire wire = new Wire((Class<?>[]) new Class[0]);

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d A[LOOP:0: B:5:0x0011->B:18:0x005d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.shopee.live.livestreaming.sztracking.proto.EventList outToPost(java.util.List<com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBModel> r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r8 == 0) goto L_0x0078
            int r1 = r8.size()
            if (r1 <= 0) goto L_0x0078
            java.util.Iterator r8 = r8.iterator()
        L_0x0011:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0078
            java.lang.Object r1 = r8.next()
            com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBModel r1 = (com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBModel) r1
            java.lang.String r2 = r1.header
            e.f r2 = e.f.c(r2)
            r3 = 0
            com.squareup.wire.Wire r4 = r7.wire     // Catch:{ IOException -> 0x0050 }
            byte[] r2 = r2.i()     // Catch:{ IOException -> 0x0050 }
            java.lang.Class<com.shopee.live.livestreaming.sztracking.proto.Header> r5 = com.shopee.live.livestreaming.sztracking.proto.Header.class
            com.squareup.wire.Message r2 = r4.parseFrom((byte[]) r2, r5)     // Catch:{ IOException -> 0x0050 }
            com.shopee.live.livestreaming.sztracking.proto.Header r2 = (com.shopee.live.livestreaming.sztracking.proto.Header) r2     // Catch:{ IOException -> 0x0050 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004e }
            r4.<init>()     // Catch:{ IOException -> 0x004e }
            java.lang.String r5 = "report "
            r4.append(r5)     // Catch:{ IOException -> 0x004e }
            java.lang.Integer r5 = r2.id     // Catch:{ IOException -> 0x004e }
            r4.append(r5)     // Catch:{ IOException -> 0x004e }
            java.lang.String r5 = " event"
            r4.append(r5)     // Catch:{ IOException -> 0x004e }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x004e }
            com.shopee.e.a.a.a((java.lang.Object) r4)     // Catch:{ IOException -> 0x004e }
            goto L_0x005a
        L_0x004e:
            r4 = move-exception
            goto L_0x0052
        L_0x0050:
            r4 = move-exception
            r2 = r3
        L_0x0052:
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = ""
            com.shopee.e.a.a.a(r4, r6, r5)
        L_0x005a:
            if (r2 != 0) goto L_0x005d
            return r3
        L_0x005d:
            com.shopee.live.livestreaming.sztracking.proto.Event$Builder r3 = new com.shopee.live.livestreaming.sztracking.proto.Event$Builder
            r3.<init>()
            com.shopee.live.livestreaming.sztracking.proto.Event$Builder r2 = r3.header(r2)
            java.lang.String r1 = r1.body
            e.f r1 = e.f.c(r1)
            com.shopee.live.livestreaming.sztracking.proto.Event$Builder r1 = r2.body(r1)
            com.shopee.live.livestreaming.sztracking.proto.Event r1 = r1.build()
            r0.add(r1)
            goto L_0x0011
        L_0x0078:
            com.shopee.live.livestreaming.sztracking.proto.EventList$Builder r8 = new com.shopee.live.livestreaming.sztracking.proto.EventList$Builder
            r8.<init>()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0085
            java.util.List<com.shopee.live.livestreaming.sztracking.proto.Event> r0 = com.shopee.live.livestreaming.sztracking.proto.EventList.DEFAULT_EVENTS
        L_0x0085:
            com.shopee.live.livestreaming.sztracking.proto.EventList$Builder r8 = r8.events(r0)
            com.shopee.live.livestreaming.sztracking.proto.EventList r8 = r8.build()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.sztracking.base.SZTrackingMessageFactoryImpl.outToPost(java.util.List):com.shopee.live.livestreaming.sztracking.proto.EventList");
    }

    public SZTrackingDBModel inToSave(Event event) {
        if (event == null || event.header == null || event.body == null) {
            return null;
        }
        SZTrackingDBModel sZTrackingDBModel = new SZTrackingDBModel();
        sZTrackingDBModel.eventId = event.header.id.intValue();
        sZTrackingDBModel.sceneId = event.header.scene_id.intValue();
        sZTrackingDBModel.timestamp = event.header.timestamp.longValue();
        sZTrackingDBModel.header = f.a(event.header.toByteArray()).f();
        sZTrackingDBModel.body = event.body.f();
        return sZTrackingDBModel;
    }
}
