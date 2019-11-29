package com.shopee.app.util.sfchat;

import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.chat.core.model.ChatEndReason;

public final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f26521a = new int[AvailabilityState.Status.values().length];

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f26522b = new int[ChatEndReason.values().length];

    static {
        f26521a[AvailabilityState.Status.AgentsAvailable.ordinal()] = 1;
        f26521a[AvailabilityState.Status.NoAgentsAvailable.ordinal()] = 2;
        f26522b[ChatEndReason.NoAgentsAvailable.ordinal()] = 1;
        f26522b[ChatEndReason.EndedByAgent.ordinal()] = 2;
    }
}
