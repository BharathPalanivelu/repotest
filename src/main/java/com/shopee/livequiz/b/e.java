package com.shopee.livequiz.b;

import com.facebook.internal.NativeProtocol;
import com.garena.android.appkit.d.a;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.livequiz.data.b;
import com.shopee.livequiz.data.bean.GameData;

public class e {
    public static void a() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        o oVar2 = new o();
        oVar2.a("is_back", (Boolean) false);
        oVar2.a("is_initial", (Boolean) true);
        oVar.a("view_common", (l) oVar2);
        b.a("room_view", oVar);
        a.b("LiveQuizUploadDataHelper %s", "room_view");
    }

    public static void a(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("question_sn", (Number) Integer.valueOf(i2));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("question_panel_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "question_panel_impression");
    }

    public static void b(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("question_sn", (Number) Integer.valueOf(i2));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("answer_panel_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "answer_panel_impression");
    }

    public static void a(int i, int i2, int i3, boolean z) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("question_sn", (Number) Integer.valueOf(i2));
        oVar.a("answer_id", (Number) Integer.valueOf(i3));
        oVar.a("revive", Boolean.valueOf(z));
        b.a("answer_option_item_click", oVar);
        a.b("LiveQuizUploadDataHelper %s", "answer_option_item_click");
    }

    public static void c(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("answer_id", (Number) Integer.valueOf(i2));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("extra_life_confirm_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "extra_life_confirm_impression");
    }

    public static void d(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("answer_id", (Number) Integer.valueOf(i2));
        b.a("extra_life_confirm_use_button_click", oVar);
        a.b("LiveQuizUploadDataHelper %s", "extra_life_confirm_use_button_click");
    }

    public static void e(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("answer_id", (Number) Integer.valueOf(i2));
        b.a("extra_life_confirm_not_now_button_click", oVar);
        a.b("LiveQuizUploadDataHelper %s", "extra_life_confirm_not_now_button_click");
    }

    public static void a(String str) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("alert_reason", str);
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("system_alert_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "system_alert_impression");
    }

    public static void b() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("session_success_panel_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "session_success_panel_impression");
    }

    public static void a(int i) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("session_fail_panel_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "session_fail_panel_impression");
    }

    public static void c() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        b.a("quit_game_confirm_impression", oVar2);
        a.b("LiveQuizUploadDataHelper %s", "quit_game_confirm_impression");
    }

    public static void d() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        b.a("quit_game_confirm_quit_game_btn_click", oVar);
        a.b("LiveQuizUploadDataHelper %s", "quit_game_confirm_quit_game_btn_click");
    }

    public static void e() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        b.a("quit_game_confirm_back_game_btn_click", oVar);
        a.b("LiveQuizUploadDataHelper %s", "quit_game_confirm_back_game_btn_click");
    }

    public static void f(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_id", (Number) Integer.valueOf(i));
        oVar.a("answer_id", (Number) Integer.valueOf(i2));
        b.a("action_extra_life_auto_use", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_extra_life_auto_use");
    }

    public static void f() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        b.a("action_end_live", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_end_live");
    }

    public static void g() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        b.a("action_login_complete", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_login_complete");
    }

    public static void b(String str) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("target_action", str);
        b.a("triggle_video_button_click", oVar);
        a.b("LiveQuizUploadDataHelper %s", "triggle_video_button_click");
    }

    public static void h() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        b.a("action_enter_background", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_enter_background");
    }

    public static void i() {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        b.a("action_enter_foreground", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_enter_foreground");
    }

    public static void b(int i) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_sn", (Number) Integer.valueOf(i));
        b.a("action_submit_answer_success", oVar);
        a.b("LiveQuizUploadDataHelper %s", "room_view");
    }

    public static void g(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_sn", (Number) Integer.valueOf(i));
        oVar.a("status_code", (Number) Integer.valueOf(i2));
        b.a("action_submit_answer_network_fail", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_submit_answer_network_fail");
    }

    public static void h(int i, int i2) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("question_sn", (Number) Integer.valueOf(i));
        oVar.a(NativeProtocol.BRIDGE_ARG_ERROR_CODE, (Number) Integer.valueOf(i2));
        b.a("action_submit_answer_business_fail", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_submit_answer_business_fail");
    }

    public static void a(String str, int i) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("type", str);
        if (i > 0) {
            oVar.a("question_sn", (Number) Integer.valueOf(i));
        }
        b.a("action_receive_message", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_receive_message");
    }

    public static void a(GameData gameData, long j) {
        if (gameData != null) {
            o oVar = new o();
            oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
            oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
            oVar.a("type", gameData.msg_type);
            if ((GameData.TYPE_ANSWER.equals(gameData.msg_type) || GameData.TYPE_QUEATION.equals(gameData.msg_type)) && gameData.msg_body != null) {
                oVar.a("sn", (Number) Integer.valueOf(gameData.msg_body.sn));
                oVar.a("question_id", (Number) Integer.valueOf(gameData.msg_body.question_id));
            }
            oVar.a("receive_timestamp", (Number) Long.valueOf(j));
            b.a("action_receive_txim_message", oVar);
            a.b("LiveQuizUploadDataHelper %s", "action_receive_txim_message");
        }
    }

    public static void b(GameData gameData, long j) {
        if (gameData != null) {
            o oVar = new o();
            oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
            oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
            oVar.a("type", gameData.msg_type);
            if ((GameData.TYPE_ANSWER.equals(gameData.msg_type) || GameData.TYPE_QUEATION.equals(gameData.msg_type)) && gameData.msg_body != null) {
                oVar.a("sn", (Number) Integer.valueOf(gameData.msg_body.sn));
                oVar.a("question_id", (Number) Integer.valueOf(gameData.msg_body.question_id));
            }
            oVar.a("receive_timestamp", (Number) Long.valueOf(j));
            b.a("action_receive_spim_message", oVar);
            a.b("LiveQuizUploadDataHelper %s", "action_receive_spim_message");
        }
    }

    public static void a(GameData gameData, long j, long j2) {
        if (gameData != null) {
            o oVar = new o();
            oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
            oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
            oVar.a("type", gameData.msg_type);
            if ((GameData.TYPE_ANSWER.equals(gameData.msg_type) || GameData.TYPE_QUEATION.equals(gameData.msg_type)) && gameData.msg_body != null) {
                oVar.a("sn", (Number) Integer.valueOf(gameData.msg_body.sn));
                oVar.a("question_id", (Number) Integer.valueOf(gameData.msg_body.question_id));
            }
            String str = "spim";
            if (j2 > 0 && j > 0) {
                if (j2 <= j) {
                    str = "txim";
                }
                oVar.a("use_source", str);
                oVar.a("receive_type", "txspim");
            } else if (j2 > 0) {
                oVar.a("use_source", "txim");
                oVar.a("receive_type", "txim");
                j = System.currentTimeMillis();
            } else if (j > 0) {
                oVar.a("use_source", str);
                oVar.a("receive_type", str);
                j2 = System.currentTimeMillis();
            }
            oVar.a("spim_receive_timestamp", (Number) Long.valueOf(j));
            oVar.a("txim_receive_timestamp", (Number) Long.valueOf(j2));
            oVar.a("time_difference", (Number) Long.valueOf(Math.abs(j - j2)));
            b.a("action_receive_txim_spim_message", oVar);
            a.b("LiveQuizUploadDataHelper %s", "action_receive_txim_spim_message");
        }
    }

    public static void a(long j) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("show_timestamp", (Number) Long.valueOf(j));
        b.a("action_anchor_absent_notify_show", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_anchor_absent_notify_show");
    }

    public static void a(long j, long j2, boolean z) {
        o oVar = new o();
        oVar.a("game_event_id", (Number) Integer.valueOf(b.a().c()));
        oVar.a("game_session_id", (Number) Integer.valueOf(b.a().d()));
        oVar.a("dismiss_timestamp", (Number) Long.valueOf(j));
        oVar.a("showing_duration", (Number) Long.valueOf(j2));
        oVar.a("dismiss_type", z ? "auto" : "manual");
        b.a("action_anchor_absent_notify_dismiss", oVar);
        a.b("LiveQuizUploadDataHelper %s", "action_anchor_absent_notify_dismiss");
    }
}
