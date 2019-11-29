package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbb  reason: invalid package */
public final class zzbb {
    private static final zzv<String, String> zzhw = new zzy().zzb("trace_sampling_rate", "sampling").zzb("network_sampling_rate", "sampling").zzp();
    private static final zzv<String, String> zzhx = new zzy().zzb("sessions_sampling_percentage", "fpr_vc_session_sampling_rate").zzb("trace_sampling_rate", "fpr_vc_trace_sampling_rate").zzb("network_sampling_rate", "fpr_vc_network_request_sampling_rate").zzp();

    public static String zzl(String str) {
        return zzhw.getOrDefault(str, str);
    }

    public static String zzm(String str) {
        return zzhx.getOrDefault(str, str);
    }
}
