package com.shopee.app.tracking;

import com.google.a.l;
import com.google.a.o;
import com.shopee.app.web.WebRegister;
import com.shopee.shopeetracker.bimodel.TrackingAction;
import com.shopee.shopeetracker.bimodel.TrackingActionEvent;
import com.shopee.shopeetracker.bimodel.TrackingClick;
import com.shopee.shopeetracker.bimodel.TrackingClickEvent;
import com.shopee.shopeetracker.bimodel.TrackingEvent;
import com.shopee.shopeetracker.bimodel.TrackingImpression;
import com.shopee.shopeetracker.bimodel.TrackingImpressions;
import com.shopee.shopeetracker.bimodel.TrackingImpressionsEvent;
import com.shopee.shopeetracker.model.UserActionV2;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19157a;

    /* renamed from: b  reason: collision with root package name */
    private String f19158b;

    /* renamed from: c  reason: collision with root package name */
    private String f19159c;

    public c(boolean z, String str, String str2) {
        this.f19157a = z;
        this.f19158b = str;
        this.f19159c = str2;
    }

    public void a(String str, o oVar) {
        if (this.f19157a) {
            TrackingClickEvent trackingClickEvent = new TrackingClickEvent();
            TrackingClick trackingClick = new TrackingClick();
            trackingClick.targetType = a(str);
            trackingClick.targetData = WebRegister.GSON.a((l) oVar);
            trackingClickEvent.click = trackingClick;
            trackingClickEvent.pageId = this.f19158b;
            UserActionV2.create((TrackingEvent) trackingClickEvent).log();
        }
    }

    public void b(String str, o oVar) {
        if (this.f19157a) {
            TrackingAction trackingAction = new TrackingAction();
            trackingAction.action = str;
            trackingAction.data = WebRegister.GSON.a((l) oVar);
            TrackingActionEvent trackingActionEvent = new TrackingActionEvent();
            trackingActionEvent.action = trackingAction;
            trackingActionEvent.pageId = this.f19158b;
            UserActionV2.create((TrackingEvent) trackingActionEvent).log();
        }
    }

    public void a(String str, List<TrackingImpression> list) {
        if (this.f19157a && list != null && !list.isEmpty() && str != null && !str.isEmpty()) {
            TrackingImpressions trackingImpressions = new TrackingImpressions();
            trackingImpressions.impressions = list;
            trackingImpressions.targetType = a(str);
            TrackingImpressionsEvent trackingImpressionsEvent = new TrackingImpressionsEvent();
            trackingImpressionsEvent.impressions = trackingImpressions;
            trackingImpressionsEvent.pageId = this.f19158b;
            UserActionV2.create((TrackingEvent) trackingImpressionsEvent).log();
        }
    }

    private String a(String str) {
        return this.f19159c + "." + str;
    }
}
