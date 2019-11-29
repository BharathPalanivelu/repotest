package com.shopee.live.livestreaming.ui.audience;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.util.UriUtil;
import com.facebook.places.model.PlaceFields;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.util.a.e;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.g;
import com.shopee.live.livestreaming.util.k;
import com.shopee.live.livestreaming.util.s;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;

public class c {
    public static void a(boolean z, boolean z2) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streamer_id", (Number) Integer.valueOf(k));
        oVar.a("from_source", e2);
        o oVar2 = new o();
        oVar2.a("is_back", Boolean.valueOf(z));
        oVar2.a("is_initial", Boolean.valueOf(z2));
        oVar.a("view_common", (l) oVar2);
        g.a("streaming_room_display", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_display: " + f2 + "," + k + "," + e2);
    }

    public static void a() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_close_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_close_click: " + f2 + "," + k + "," + e2);
    }

    public static void b() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_anchor_info_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_anchor_info_click: " + f2 + "," + k + "," + e2);
    }

    public static void c() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_exit_clean_mode_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_exit_clean_mode_click: " + f2 + "," + k + "," + e2);
    }

    public static void d() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_clean_mode_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_clean_mode_button_click: " + f2 + "," + k + "," + e2);
    }

    public static void e() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_follow_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_follow_click: " + f2 + "," + k + "," + e2);
    }

    public static void a(long j, int i) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a("itemid", (Number) Long.valueOf(j));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_show_product_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_show_product_impression: " + f2 + "," + k + "," + e2 + "," + i + "," + j);
    }

    public static void b(long j, int i) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a("itemid", (Number) Long.valueOf(j));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        g.a("streaming_room_show_product_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_show_product_click: " + f2 + "," + k + "," + e2 + "," + i + "," + j);
    }

    public static void f() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_bottom_basket_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_bottom_basket_click: " + f2 + "," + k + "," + e2);
    }

    public static void a(long j, int i, int i2) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("itemid", (Number) Long.valueOf(j));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_product_item_show", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_product_item_show: " + f2 + "," + k + "," + e2 + "," + i + "," + j + "," + i2);
    }

    public static void b(long j, int i, int i2) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a("itemid", (Number) Long.valueOf(j));
        g.a("streaming_room_product_item_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_product_item_click: " + f2 + "," + k + "," + e2 + "," + i + "," + j + "," + i2);
    }

    public static void a(boolean z) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a("is_banned", Boolean.valueOf(z));
        g.a("streaming_room_comment_bar_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_comment_bar_click: " + f2 + "," + k + "," + e2 + "," + z);
    }

    public static void g() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_comment_send_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_comment_send_click: " + f2 + "," + k + "," + e2);
    }

    public static void h() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_report_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_report_click: " + f2 + "," + f2 + "," + e2);
    }

    public static void i() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_share_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_share_click: " + f2 + "," + k + "," + e2);
    }

    public static void a(String str) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a("option_id", str);
        g.a("streaming_room_share_item_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_share_item_click: " + f2 + "," + k + "," + e2 + "," + str);
    }

    public static void j() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_like_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_like_click: " + f2 + "," + k + "," + e2);
    }

    public static void b(boolean z, boolean z2) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        o oVar2 = new o();
        oVar2.a("is_back", Boolean.valueOf(z));
        oVar2.a("is_initial", Boolean.valueOf(z2));
        oVar.a("view_common", (l) oVar2);
        g.a("streaming_room_replay_display", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_display: " + f2 + "," + k + "," + e2);
    }

    public static void k() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_replay_anchor_info_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_anchor_info_click: " + f2 + "," + k + "," + e2);
    }

    public static void l() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_replay_follow_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_follow_click: " + f2 + "," + k + "," + e2);
    }

    public static void m() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_replay_item_basket_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_item_basket_click: " + f2 + "," + k + "," + e2);
    }

    public static void c(long j, int i, int i2) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a("itemid", (Number) Long.valueOf(j));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_replay_product_item_display", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_product_item_display: " + f2 + "," + k + "," + e2 + "," + i + "," + j + "," + i2);
    }

    public static void d(long j, int i, int i2) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a("itemid", (Number) Long.valueOf(j));
        g.a("streaming_room_replay_product_item_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_product_item_click: " + f2 + "," + k + "," + e2 + "," + i + "," + j + "," + i2);
    }

    public static void n() {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        g.a("streaming_room_replay_share_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_share_click: " + f2 + "," + k + "," + e2);
    }

    public static void b(String str) {
        int f2 = f.a().f();
        int k = f.a().k();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("ctx_streamer_id", (Number) Integer.valueOf(k));
        oVar.a("option_id", str);
        g.a("streaming_room_replay_share_item_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_share_item_click: " + f2 + "," + k + "," + e2 + "," + str);
    }

    public static void o() {
        new o().a("streaming_id", (Number) Integer.valueOf(f.a().f()));
        g.a("streaming_room_float_window_start", (o) null);
        a.a("AudienceUploadDataHelper %s", "streaming_room_float_window_start");
    }

    public static void p() {
        new o().a("streaming_id", (Number) Integer.valueOf(f.a().f()));
        g.a("streaming_room_float_window_close", (o) null);
        a.a("AudienceUploadDataHelper %s", "streaming_room_float_window_close");
    }

    public static void q() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        g.a("streaming_room_app_went_background", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_app_went_background: " + f2);
    }

    public static void r() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        g.a("streaming_room_app_come_foreground", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_app_come_foreground: " + f2);
    }

    public static void s() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        g.a("streaming_room_action_exit_streaming", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_action_exit_streaming: " + f2);
    }

    public static void a(int i) {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("coin_status", (Number) Integer.valueOf(i));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_audience_check_in_coin_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_audience_check_in_coin_impression: " + f2 + "," + i + "," + e2);
    }

    public static void t() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_audience_check_in_coin_claim_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_audience_check_in_coin_claim_click: " + f2 + "," + e2);
    }

    public static void u() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_audience_check_in_coin_login_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_audience_check_in_coin_login_click: " + f2 + "," + e2);
    }

    public static void a(int i, String str) {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("event_code", (Number) Integer.valueOf(i));
        oVar.a("event_message", str);
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        g.b("streaming_room_action_play_event", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_action_play_event: " + f2);
    }

    public static void v() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.b("streaming_room_no_internet_alert_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_no_internet_alert_impression: " + f2);
    }

    public static void w() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        g.b("streaming_room_no_internet_alert_cancel_btn_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_no_internet_alert_cancel_btn_click: " + f2);
    }

    public static void x() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        g.b("streaming_room_no_internet_alert_retry_btn_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_no_internet_alert_retry_btn_click: " + f2);
    }

    public static void y() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.b("streaming_room_video_stream_interrupt_alert_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_video_stream_interrupt_alert_impression: " + f2);
    }

    public static void z() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        g.b("streaming_room_video_stream_interrupt_alert_retry_btn_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_video_stream_interrupt_alert_retry_btn_click: " + f2);
    }

    public static void A() {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        g.b("streaming_room_video_stream_interrupt_alert_cancel_btn_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_video_stream_interrupt_alert_cancel_btn_click: " + f2);
    }

    public static void b(int i, String str) {
        int f2 = f.a().f();
        o oVar = new o();
        oVar.a("streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("event_code", (Number) Integer.valueOf(i));
        oVar.a("event_message", str);
        oVar.a("streaming_start_time", (Number) Long.valueOf(f.a().l()));
        oVar.a("models", k.a());
        g.b("streaming_room_replay_action_replay_event", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_action_replay_event: " + f2);
    }

    public static void a(Context context, Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            try {
                if (e.a()) {
                    int f2 = f.a().f();
                    String a2 = k.a();
                    long l = f.a().l();
                    String valueOf = String.valueOf(f.a().c());
                    String string = bundle2.getString(TXLiveConstants.NET_STATUS_CPU_USAGE);
                    String str = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT);
                    String str2 = bundle2.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps";
                    String str3 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS) + "";
                    String str4 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s";
                    String str5 = bundle2.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps";
                    String str6 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps";
                    String string2 = bundle2.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
                    String sDKVersionStr = TXLiveBase.getSDKVersionStr();
                    String str7 = valueOf;
                    String a3 = s.a(context);
                    String valueOf2 = String.valueOf(bundle2.getInt(TXLiveConstants.NET_STATUS_NET_JITTER));
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
                    oVar.a("battery", str7);
                    oVar.a("network_status", a3);
                    oVar.a("jitter", valueOf2);
                    g.b("streaming_room_action_live_details", oVar);
                    StringBuilder sb = new StringBuilder();
                    sb.append("streaming_room_action_live_details: ");
                    sb.append(f2);
                    String str8 = ",";
                    sb.append(str8);
                    sb.append(a2);
                    sb.append(str8);
                    sb.append(l);
                    sb.append(str8);
                    sb.append(str3);
                    a.a("AudienceUploadDataHelper %s", sb.toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(long j) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ad_spot_id", (Number) Long.valueOf(j));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        String a2 = a("streaming_room_ad_spot_impression", " : ", Integer.valueOf(f2), ",", Long.valueOf(j));
        g.a("streaming_room_ad_spot_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", a2);
    }

    public static void b(long j) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ad_spot_id", (Number) Long.valueOf(j));
        String a2 = a("streaming_room_ad_spot_click", ": ", Integer.valueOf(f2), ",", Long.valueOf(j));
        g.a("streaming_room_ad_spot_click", oVar);
        a.a("AudienceUploadDataHelper %s", a2);
    }

    public static void c(boolean z, boolean z2) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("is_slide", Boolean.valueOf(z));
        oVar.a("is_clear_mode", Boolean.valueOf(z2));
        String a2 = a("streaming_room_clear_mode_click", ": ", Integer.valueOf(f2), ",", Boolean.valueOf(z), ",", Boolean.valueOf(z2));
        g.a("streaming_room_clear_mode_click", oVar);
        a.a("AudienceUploadDataHelper %s", a2);
    }

    public static void a(long j, String str, int i) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        String a2 = a("streaming_room_voucher_impression", ": ", Long.valueOf(j), ", ", str, ", ", Integer.valueOf(f2), ", ", Integer.valueOf(i));
        g.a("streaming_room_voucher_impression", oVar);
        a.a("AudienceUploadDataHelper %s", a2);
    }

    public static void a(long j, String str, boolean z, int i) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("is_full_displayed", Boolean.valueOf(z));
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        String a2 = a("streaming_room_show_voucher_click", ": ", Long.valueOf(j), ", ", str, ", ", Boolean.valueOf(z), ", ", Integer.valueOf(f2), ", ", Integer.valueOf(i));
        g.a("streaming_room_show_voucher_click", oVar);
        a.a("AudienceUploadDataHelper %s", a2);
    }

    public static void b(long j, String str, int i) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        String a2 = a("streaming_room_voucher_click", ": ", Long.valueOf(j), ", ", str, ", ", Integer.valueOf(f2), ", ", Integer.valueOf(i));
        g.a("streaming_room_voucher_click", oVar);
        a.a("AudienceUploadDataHelper %s", a2);
    }

    public static void a(long j, String str, int i, int i2) {
        o oVar = new o();
        int f2 = f.a().f();
        oVar.a("promotion_id", (Number) Long.valueOf(j));
        oVar.a("code", str);
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("voucher_type", (Number) Integer.valueOf(i));
        oVar.a("claim_status", (Number) Integer.valueOf(i2));
        String a2 = a("streaming_room_voucher_action_voucher_claim_status", ": ", Long.valueOf(j), ", ", str, ", ", Integer.valueOf(f2), ", ", Integer.valueOf(i), ", ", Integer.valueOf(i2));
        g.a("streaming_room_voucher_action_voucher_claim_status", oVar);
        a.a("AudienceUploadDataHelper %s", a2);
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

    public static void B() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_switch_to_horizontal_button_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_switch_to_horizontal_button_impression: " + f2 + "," + e2);
    }

    public static void C() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_switch_to_horizontal_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_switch_to_horizontal_button_click: " + f2 + "," + e2);
    }

    public static void D() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_action_enter_horizontal_view", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_action_enter_horizontal_view: " + f2 + "," + e2);
    }

    public static void E() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_action_exit_horizontal_view", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_action_exit_horizontal_view: " + f2 + "," + e2);
    }

    public static void F() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_switch_back_vertical_button_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_switch_back_vertical_button_impression: " + f2 + "," + e2);
    }

    public static void G() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_switch_back_vertical_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_switch_back_vertical_button_click: " + f2 + "," + e2);
    }

    public static void H() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_replay_switch_to_horizontal_button_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_switch_to_horizontal_button_impression: " + f2 + "," + e2);
    }

    public static void I() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_replay_switch_to_horizontal_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_switch_to_horizontal_button_click: " + f2 + "," + e2);
    }

    public static void J() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_replay_action_enter_horizontal_view", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_action_enter_horizontal_view: " + f2 + "," + e2);
    }

    public static void K() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_replay_action_exit_horizontal_view", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_action_exit_horizontal_view: " + f2 + "," + e2);
    }

    public static void L() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        g.a("streaming_room_replay_switch_back_vertical_button_impression", oVar2);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_switch_back_vertical_button_impression: " + f2 + "," + e2);
    }

    public static void M() {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_replay_switch_back_vertical_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_switch_back_vertical_button_click: " + f2 + "," + e2);
    }

    public static void c(String str) {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        oVar.a("url", str);
        g.a("streaming_room_action_active_in_streaming", 1, oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_action_active_in_streaming: " + f2 + "," + e2);
    }

    public static void e(long j, int i, int i2) {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("itemid", (Number) Long.valueOf(j));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_add_to_cart_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_add_to_cart_button_click: " + f2 + "," + e2);
    }

    public static void f(long j, int i, int i2) {
        int f2 = f.a().f();
        String e2 = f.a().e();
        o oVar = new o();
        oVar.a("itemid", (Number) Long.valueOf(j));
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        oVar.a("ctx_streaming_id", (Number) Integer.valueOf(f2));
        oVar.a("ctx_from_source", e2);
        g.a("streaming_room_replay_add_to_cart_button_click", oVar);
        a.a("AudienceUploadDataHelper %s", "streaming_room_replay_add_to_cart_button_click: " + f2 + "," + e2);
    }
}
