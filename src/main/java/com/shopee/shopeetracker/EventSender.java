package com.shopee.shopeetracker;

import android.net.ConnectivityManager;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.shopeetracker.api.SendEventAPI;
import com.shopee.shopeetracker.bimodel.TrackingMeta;
import com.shopee.shopeetracker.model.UserAction;
import com.shopee.shopeetracker.utils.ExceptionHandler;
import com.shopee.shopeetracker.utils.GsonUtils;
import com.shopee.shopeetracker.utils.Logger;
import com.shopee.shopeetracker.utils.TrackLogger;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EventSender {
    private static final String ACTION_DATA = "actiondatas";
    private static final String ACTION_RN_DATA = "Data";
    private static final int LOOP = 100;
    private static final String TRACKING_DATA_EVENTS = "events";
    private static final String TRACKING_DATA_META = "meta";
    public static final String TRACKING_DATA_SEQUENCE_ID = "sequence_id";
    public static final String TRACKING_DATA_SESSION_ID = "session_id";
    public static final String TRACKING_DATA_USAGE_ID = "usage_id";
    private static final String TRACKING_DATA_UUID = "uuid";
    private SendEventAPI api;
    private int batchSize;
    private ExceptionHandler exceptionHandler;
    private Map<String, String> extras;
    private boolean isWifi = false;
    private TrackLogger mTrackLogger;
    private EventRepository repository;
    private HashSet<Long> shouldDeleteSet = new HashSet<>();

    EventSender(EventRepository eventRepository, SendEventAPI sendEventAPI, int i, Map<String, String> map, ExceptionHandler exceptionHandler2, TrackLogger trackLogger) {
        this.repository = eventRepository;
        this.api = sendEventAPI;
        this.batchSize = i;
        this.extras = map;
        this.exceptionHandler = exceptionHandler2;
        this.mTrackLogger = trackLogger;
    }

    public void delete() {
        HashSet<Long> hashSet = this.shouldDeleteSet;
        if (hashSet != null && !hashSet.isEmpty()) {
            try {
                if (this.repository.removeByIds(this.shouldDeleteSet).get().intValue() != 0) {
                    this.shouldDeleteSet.clear();
                }
            } catch (Exception e2) {
                Logger.debug(e2.toString());
            }
        }
    }

    private l buildPostData(List<UserAction> list, int i) {
        if (i == 0) {
            o oVar = new o();
            i iVar = new i();
            for (UserAction actionData : list) {
                iVar.a((l) GsonUtils.fromString(actionData.getActionData()));
            }
            oVar.a(ACTION_DATA, (l) iVar);
            for (String next : this.extras.keySet()) {
                oVar.a(next, this.extras.get(next));
            }
            return oVar;
        } else if (i == 1) {
            o oVar2 = new o();
            i iVar2 = new i();
            for (UserAction actionData2 : list) {
                iVar2.a(actionData2.getActionData());
            }
            oVar2.a(ACTION_RN_DATA, (l) iVar2);
            return oVar2;
        } else if (i == 2) {
            o oVar3 = new o();
            TrackingMeta trackingMeta = ShopeeTracker.getInstance().getTrackingMeta();
            trackingMeta.wifi = this.isWifi;
            oVar3.a(TRACKING_DATA_UUID, trackingMeta.finger_print);
            oVar3.a(TRACKING_DATA_META, (l) GsonUtils.fromString(GsonUtils.toJson(trackingMeta, true)));
            i iVar3 = new i();
            for (UserAction actionData3 : list) {
                iVar3.a((l) GsonUtils.fromString(actionData3.getActionData()));
            }
            oVar3.a(TRACKING_DATA_EVENTS, (l) iVar3);
            return oVar3;
        } else if (i != 3) {
            return new o();
        } else {
            i iVar4 = new i();
            for (UserAction actionData4 : list) {
                iVar4.a((l) GsonUtils.fromString(actionData4.getActionData()));
            }
            return iVar4;
        }
    }

    public void sendEvents() {
        try {
            setWifi(((ConnectivityManager) ShopeeTracker.getInstance().getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected());
            sendEventsInternal();
        } catch (Exception e2) {
            Logger.debug((Throwable) e2);
        }
    }

    private void sendEventsInternal() {
        sendEventForType(0);
        sendEventForType(1);
        sendEventForType(2);
        sendEventForType(3);
    }

    private void sendEventForType(int i) {
        for (int i2 = 0; i2 < 100 && loadAndSendEvents(i); i2++) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0192, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e6 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean loadAndSendEvents(int r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.shopee.shopeetracker.EventRepository r0 = r9.repository     // Catch:{ all -> 0x0193 }
            int r1 = r9.batchSize     // Catch:{ all -> 0x0193 }
            java.util.concurrent.Future r0 = r0.queryAll(r1, r10)     // Catch:{ all -> 0x0193 }
            r1 = 0
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x0013, ExecutionException -> 0x0011 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ InterruptedException -> 0x0013, ExecutionException -> 0x0011 }
            goto L_0x003f
        L_0x0011:
            r0 = move-exception
            goto L_0x0014
        L_0x0013:
            r0 = move-exception
        L_0x0014:
            com.shopee.shopeetracker.utils.Logger.debug((java.lang.Throwable) r0)     // Catch:{ all -> 0x0193 }
            com.shopee.shopeetracker.utils.TrackLogger r2 = r9.mTrackLogger     // Catch:{ all -> 0x0193 }
            if (r2 == 0) goto L_0x0039
            com.shopee.shopeetracker.utils.TrackLogger r2 = r9.mTrackLogger     // Catch:{ all -> 0x0193 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0193 }
            r3.<init>()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = "Exception from listFuture.get(), Thread name: "
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0193 }
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0193 }
            r2.onErrorSendEvents(r3, r0, r1)     // Catch:{ all -> 0x0193 }
        L_0x0039:
            com.shopee.shopeetracker.utils.ExceptionHandler r2 = r9.exceptionHandler     // Catch:{ all -> 0x0193 }
            r2.onException(r0)     // Catch:{ all -> 0x0193 }
            r0 = r1
        L_0x003f:
            r1 = 0
            if (r0 == 0) goto L_0x0191
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0193 }
            if (r2 == 0) goto L_0x004a
            goto L_0x0191
        L_0x004a:
            java.lang.String r2 = "EVENT_SENDER"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0193 }
            r3.<init>()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = "shouldDeleteSet = "
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.util.HashSet<java.lang.Long> r4 = r9.shouldDeleteSet     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0193 }
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0193 }
            com.shopee.shopeetracker.utils.Logger.debug(r2, r3)     // Catch:{ all -> 0x0193 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0193 }
        L_0x006a:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0193 }
            if (r3 == 0) goto L_0x008a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0193 }
            com.shopee.shopeetracker.model.UserAction r3 = (com.shopee.shopeetracker.model.UserAction) r3     // Catch:{ all -> 0x0193 }
            long r3 = r3.getId()     // Catch:{ all -> 0x0193 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0193 }
            java.util.HashSet<java.lang.Long> r4 = r9.shouldDeleteSet     // Catch:{ all -> 0x0193 }
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x0193 }
            if (r3 == 0) goto L_0x006a
            r2.remove()     // Catch:{ all -> 0x0193 }
            goto L_0x006a
        L_0x008a:
            java.lang.String r2 = "EVENT_SENDER"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0193 }
            r3.<init>()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = "should send userActions = "
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0193 }
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0193 }
            com.shopee.shopeetracker.utils.Logger.debug(r2, r3)     // Catch:{ all -> 0x0193 }
            com.google.a.l r2 = r9.buildPostData(r0, r10)     // Catch:{ all -> 0x0193 }
            com.shopee.shopeetracker.ShopeeTracker r3 = com.shopee.shopeetracker.ShopeeTracker.getInstance()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = ""
            r5 = 1
            if (r10 == 0) goto L_0x00db
            if (r10 == r5) goto L_0x00d6
            r6 = 2
            if (r10 == r6) goto L_0x00d1
            r6 = 3
            if (r10 == r6) goto L_0x00bb
        L_0x00b9:
            r10 = 0
            goto L_0x00e0
        L_0x00bb:
            java.lang.String r10 = r3.getTracingUrlV2()     // Catch:{ all -> 0x0193 }
            boolean r4 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0193 }
            if (r4 == 0) goto L_0x00c7
            monitor-exit(r9)
            return r1
        L_0x00c7:
            java.lang.String r4 = "/tr"
            java.lang.String r6 = "/pf"
            java.lang.String r4 = r10.replace(r4, r6)     // Catch:{ all -> 0x0193 }
            r10 = 1
            goto L_0x00e0
        L_0x00d1:
            java.lang.String r4 = r3.getTracingUrlV2()     // Catch:{ all -> 0x0193 }
            goto L_0x00b9
        L_0x00d6:
            java.lang.String r4 = r3.getRnEndPoint()     // Catch:{ all -> 0x0193 }
            goto L_0x00b9
        L_0x00db:
            java.lang.String r4 = r3.getEndPoint()     // Catch:{ all -> 0x0193 }
            goto L_0x00b9
        L_0x00e0:
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0193 }
            if (r6 == 0) goto L_0x00e8
            monitor-exit(r9)
            return r1
        L_0x00e8:
            java.lang.String r6 = ""
            com.shopee.shopeetracker.bimodel.TrackingMeta r7 = r3.getTrackingMeta()     // Catch:{ all -> 0x0193 }
            if (r7 == 0) goto L_0x00f6
            com.shopee.shopeetracker.bimodel.TrackingMeta r3 = r3.getTrackingMeta()     // Catch:{ all -> 0x0193 }
            java.lang.String r6 = r3.finger_print     // Catch:{ all -> 0x0193 }
        L_0x00f6:
            com.shopee.shopeetracker.utils.TrackLogger r3 = r9.mTrackLogger     // Catch:{ Exception -> 0x015c }
            if (r3 == 0) goto L_0x0110
            com.shopee.shopeetracker.utils.TrackLogger r3 = r9.mTrackLogger     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r7.<init>()     // Catch:{ Exception -> 0x015c }
            java.lang.String r8 = "endpoint: "
            r7.append(r8)     // Catch:{ Exception -> 0x015c }
            r7.append(r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x015c }
            r3.onStartSendEvents(r7, r0)     // Catch:{ Exception -> 0x015c }
        L_0x0110:
            if (r10 == 0) goto L_0x012d
            java.lang.String r10 = "application/json"
            okhttp3.MediaType r10 = okhttp3.MediaType.parse(r10)     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x015c }
            okhttp3.RequestBody r10 = okhttp3.RequestBody.create((okhttp3.MediaType) r10, (java.lang.String) r2)     // Catch:{ Exception -> 0x015c }
            com.shopee.shopeetracker.api.SendEventAPI r2 = com.shopee.shopeetracker.Injection.provideSendEventAPI(r5)     // Catch:{ Exception -> 0x015c }
            f.b r10 = r2.send((java.lang.String) r4, (java.lang.String) r6, (okhttp3.RequestBody) r10)     // Catch:{ Exception -> 0x015c }
            f.m r10 = r10.a()     // Catch:{ Exception -> 0x015c }
            goto L_0x0137
        L_0x012d:
            com.shopee.shopeetracker.api.SendEventAPI r10 = r9.api     // Catch:{ Exception -> 0x015c }
            f.b r10 = r10.send((java.lang.String) r4, (java.lang.String) r6, (com.google.a.l) r2)     // Catch:{ Exception -> 0x015c }
            f.m r10 = r10.a()     // Catch:{ Exception -> 0x015c }
        L_0x0137:
            boolean r10 = r10.d()     // Catch:{ Exception -> 0x015c }
            if (r10 == 0) goto L_0x0140
            r9.deleteAction(r0)     // Catch:{ Exception -> 0x015c }
        L_0x0140:
            com.shopee.shopeetracker.utils.TrackLogger r10 = r9.mTrackLogger     // Catch:{ Exception -> 0x015c }
            if (r10 == 0) goto L_0x015a
            com.shopee.shopeetracker.utils.TrackLogger r10 = r9.mTrackLogger     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r2.<init>()     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = "endpoint: "
            r2.append(r3)     // Catch:{ Exception -> 0x015c }
            r2.append(r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x015c }
            r10.onSuccessSendEvents(r2, r0)     // Catch:{ Exception -> 0x015c }
        L_0x015a:
            monitor-exit(r9)
            return r5
        L_0x015c:
            r10 = move-exception
            com.shopee.shopeetracker.utils.Logger.debug((java.lang.Throwable) r10)     // Catch:{ all -> 0x0193 }
            com.shopee.shopeetracker.utils.TrackLogger r2 = r9.mTrackLogger     // Catch:{ all -> 0x0193 }
            if (r2 == 0) goto L_0x018a
            com.shopee.shopeetracker.utils.TrackLogger r2 = r9.mTrackLogger     // Catch:{ all -> 0x0193 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0193 }
            r3.<init>()     // Catch:{ all -> 0x0193 }
            java.lang.String r5 = "Exception from api.send "
            r3.append(r5)     // Catch:{ all -> 0x0193 }
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = " Thread name: "
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0193 }
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0193 }
            r2.onErrorSendEvents(r3, r10, r0)     // Catch:{ all -> 0x0193 }
        L_0x018a:
            com.shopee.shopeetracker.utils.ExceptionHandler r0 = r9.exceptionHandler     // Catch:{ all -> 0x0193 }
            r0.onException(r10)     // Catch:{ all -> 0x0193 }
            monitor-exit(r9)
            return r1
        L_0x0191:
            monitor-exit(r9)
            return r1
        L_0x0193:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0197
        L_0x0196:
            throw r10
        L_0x0197:
            goto L_0x0196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.shopeetracker.EventSender.loadAndSendEvents(int):boolean");
    }

    private void deleteAction(List<UserAction> list) throws Exception {
        HashSet hashSet = new HashSet();
        for (UserAction id : list) {
            hashSet.add(Long.valueOf(id.getId()));
        }
        Logger.debug("EVENT_SENDER", "before add delete actionIdList = " + hashSet.toString());
        hashSet.addAll(this.shouldDeleteSet);
        Logger.debug("EVENT_SENDER", "actionIdList = " + hashSet.toString());
        if (!hashSet.isEmpty()) {
            int intValue = this.repository.removeByIds(hashSet).get(3, TimeUnit.SECONDS).intValue();
            Logger.debug("EVENT_SENDER", "delete count = " + intValue + "actionIdList count = " + hashSet.size());
            if (intValue == 0) {
                this.shouldDeleteSet.addAll(hashSet);
            } else {
                this.shouldDeleteSet.removeAll(hashSet);
            }
        }
        Logger.debug("EVENT_SENDER", "shouldDeleteSet = " + this.shouldDeleteSet.toString());
    }

    private boolean isEmpty(i iVar) {
        return iVar == null || iVar.a() == 0;
    }

    public void setWifi(boolean z) {
        this.isWifi = z;
    }
}
