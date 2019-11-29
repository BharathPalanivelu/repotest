package com.shopee.live.livestreaming.ui.anchor;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.NativeProtocol;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.g;
import com.shopee.live.livestreaming.util.k;
import com.shopee.live.livestreaming.util.s;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;

public class b {
    public static void a() {
        o oVar = new o();
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar2 = new o();
        oVar2.a("is_back", (Boolean) false);
        oVar2.a("is_initial", (Boolean) true);
        oVar.a("view_common", (l) oVar2);
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_preview_view", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_preview_view: " + f2 + "," + f2 + "," + a2 + "," + l);
    }

    public static void b() {
        o oVar = new o();
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar2 = new o();
        oVar2.a("is_back", (Boolean) false);
        oVar2.a("is_initial", (Boolean) true);
        oVar.a("view_common", (l) oVar2);
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_live_view", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_live_view: " + f2 + "," + a2 + "," + l);
    }

    public static void a(int i, String str) {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        oVar.a("event_code", (Number) Integer.valueOf(i));
        oVar.a("event_message", str);
        g.b("streaming_room_push_action_push_event", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_action_push_event: " + f2 + "," + a2 + "," + l + i + "," + str);
    }

    public static void c() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.b("streaming_room_push_network_disconnect_dialog_impression", oVar2);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_network_disconnect_dialog_impression: " + f2 + "," + a2 + "," + l);
    }

    public static void d() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_network_disconnect_dialog_cancel_btn_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_network_disconnect_dialog_cancel_btn_click: " + f2 + "," + a2 + "," + l);
    }

    public static void e() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_network_disconnect_dialog_retry_btn_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_network_disconnect_dialog_retry_btn_click: " + f2 + "," + a2 + "," + l);
    }

    public static void f() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.b("streaming_room_push_weak_network_alert_impression", oVar2);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_weak_network_alert_impression: " + f2 + "," + a2 + "," + l);
    }

    public static void g() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_go_live_btn_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_go_live_btn_click: " + f2 + "," + a2 + "," + l);
    }

    public static void h() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_action_go_live_success", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_action_go_live_success: " + f2 + "," + a2 + "," + l);
    }

    public static void a(long j) {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        oVar.a(NativeProtocol.BRIDGE_ARG_ERROR_CODE, (Number) Long.valueOf(j));
        g.b("streaming_room_push_action_go_live_fail", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_action_go_live_fail: " + f2 + "," + a2 + "," + l + j);
    }

    public static void i() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.b("streaming_room_push_violation_alert_impression", oVar2);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_violation_alert_impression: " + f2 + "," + a2 + "," + l);
    }

    public static void j() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_action_receive_violation_end", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_action_receive_violation_end: " + f2 + "," + a2 + "," + l);
    }

    public static void k() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_close_streaming_btn_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_close_streaming_btn_click: " + f2 + "," + a2 + "," + l);
    }

    public static void l() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.b("streaming_room_push_quit_live_confirm_impression", oVar2);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_quit_live_confirm_impression: " + f2 + "," + a2 + "," + l);
    }

    public static void m() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_quit_live_confirm_confirm_btn_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_quit_live_confirm_confirm_btn_click: " + f2 + "," + a2 + "," + l);
    }

    public static void n() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_quit_live_confirm_cancel_btn_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_quit_live_confirm_cancel_btn_click: " + f2 + "," + a2 + "," + l);
    }

    public static void o() {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        g.b("streaming_room_push_action_end_live_success", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_action_end_live_success: " + f2 + "," + a2 + "," + l);
    }

    public static void b(long j) {
        int f2 = f.a().f();
        String a2 = k.a();
        long l = f.a().l();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("models", a2);
        oVar.a("streaming_start_time", (Number) Long.valueOf(l));
        oVar.a(NativeProtocol.BRIDGE_ARG_ERROR_CODE, (Number) Long.valueOf(j));
        g.b("streaming_room_push_action_end_live_fail", oVar);
        a.a("AnchorUploadDataHelper %s", "streaming_room_push_action_end_live_fail: " + f2 + "," + a2 + "," + l + "," + j);
    }

    public static void a(Context context, Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            try {
                int f2 = f.a().f();
                String a2 = k.a();
                long l = f.a().l();
                String string = bundle2.getString(TXLiveConstants.NET_STATUS_CPU_USAGE);
                String str = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT);
                String str2 = bundle2.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps";
                String str3 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS) + "";
                String str4 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s";
                String str5 = bundle2.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps";
                String str6 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps";
                String string2 = bundle2.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
                String sDKVersionStr = TXLiveBase.getSDKVersionStr();
                String valueOf = String.valueOf(f.a().c());
                String a3 = s.a(context);
                o oVar = new o();
                oVar.a("streaming_id", (Number) Integer.valueOf(f2));
                oVar.a("models", a2);
                oVar.a("streaming_start_time", (Number) Long.valueOf(l));
                oVar.a("cpu", string);
                oVar.a("cache_size", "");
                oVar.a(UriUtil.LOCAL_RESOURCE_SCHEME, str);
                oVar.a("speed", str2);
                oVar.a("fps", str3);
                oVar.a("gop", str4);
                oVar.a("ara", str5);
                oVar.a("vra", str6);
                oVar.a("svr", string2);
                oVar.a("drp_cnt", "");
                oVar.a("drp_size", "");
                oVar.a("sdk_version", sDKVersionStr);
                oVar.a("battery", valueOf);
                oVar.a("network_status", a3);
                g.b("streaming_room_push_action_live_details", oVar);
                StringBuilder sb = new StringBuilder();
                sb.append("streaming_room_push_action_live_details: ");
                sb.append(f2);
                String str7 = ",";
                sb.append(str7);
                sb.append(a2);
                sb.append(str7);
                sb.append(l);
                sb.append(str7);
                sb.append(str3);
                a.a("AnchorUploadDataHelper %s", sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void p() {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        g.a("streamer_streaming_room_voucher_entrance_click", oVar);
        a.a("AnchorUploadDataHelper %s", "streamer_streaming_room_voucher_entrance_click:" + f2);
    }

    public static void a(long j, String str, int i, boolean z) {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        oVar.a("is_available", Boolean.valueOf(z));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        String a2 = a("streamer_streaming_room_voucher_impression", ": ", Long.valueOf(j), ", ", str, ", ", Integer.valueOf(i), ", ", Boolean.valueOf(z));
        g.a("streamer_streaming_room_voucher_impression", oVar2);
        a.a("AnchorUploadDataHelper %s", a2);
    }

    public static void b(long j, String str, int i, boolean z) {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        oVar.a("is_show", Boolean.valueOf(z));
        String a2 = a("streamer_streaming_room_voucher_click", ": ", Long.valueOf(j), ", ", str, ", ", Integer.valueOf(i), ", ", Boolean.valueOf(z));
        g.a("streamer_streaming_room_voucher_click", oVar);
        a.a("AnchorUploadDataHelper %s", a2);
    }

    public static void c(long j, String str, int i, boolean z) {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        oVar.a("is_close", Boolean.valueOf(z));
        String a2 = a("streamer_streaming_room_remove_voucher_click", ": ", Long.valueOf(j), ", ", str, ", ", Integer.valueOf(i), ", ", Boolean.valueOf(z));
        g.a("streamer_streaming_room_remove_voucher_click", oVar);
        a.a("AnchorUploadDataHelper %s", a2);
    }

    private static String a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
