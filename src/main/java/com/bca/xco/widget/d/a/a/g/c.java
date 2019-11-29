package com.bca.xco.widget.d.a.a.g;

public enum c {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: g  reason: collision with root package name */
    public final int f4909g;

    private c(int i) {
        this.f4909g = i;
    }

    public static c a(int i) {
        for (c cVar : values()) {
            if (cVar.f4909g == i) {
                return cVar;
            }
        }
        return null;
    }
}
