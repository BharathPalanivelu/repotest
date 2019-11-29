package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.g.m;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.ui.webview.simpleweb.SimpleWebPageActivity_;
import com.shopee.app.util.bm;
import com.shopee.app.util.i;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.id.R;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static CharSequence[] f20023a = new CharSequence[2];

    /* renamed from: b  reason: collision with root package name */
    private static CharSequence[] f20024b = new CharSequence[1];

    /* renamed from: c  reason: collision with root package name */
    private static CharSequence[] f20025c = new CharSequence[2];

    /* renamed from: d  reason: collision with root package name */
    private static CharSequence[] f20026d = new CharSequence[3];

    static {
        f20023a[0] = b.e(R.string.sp_label_resend);
        f20023a[1] = b.e(R.string.sp_label_delete);
        f20024b[0] = b.e(R.string.sp_label_copy_text);
        f20025c[0] = b.e(R.string.sp_label_copy_text);
        f20025c[1] = b.e(R.string.sp_go_to_link);
        f20026d[0] = b.e(R.string.sp_label_resend);
        f20026d[1] = b.e(R.string.sp_label_copy_text);
        f20026d[2] = b.e(R.string.sp_label_delete);
    }

    public static void a(View view, final ChatMessage chatMessage) {
        a(view, f20023a, new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i != 0) {
                    if (i == 1 && !TextUtils.isEmpty(chatMessage.getRequestId())) {
                        com.garena.android.appkit.b.b.a("CHAT_MSG_DELETE", new com.garena.android.appkit.b.a(chatMessage), b.a.NETWORK_BUS);
                    }
                } else if (!TextUtils.isEmpty(chatMessage.getRequestId())) {
                    com.garena.android.appkit.b.b.a("CHAT_MSG_RESEND", new com.garena.android.appkit.b.a(chatMessage), b.a.NETWORK_BUS);
                }
                fVar.dismiss();
            }
        });
    }

    public static void b(View view, final ChatMessage chatMessage) {
        a(view, f20024b, new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (!TextUtils.isEmpty(chatMessage.getText())) {
                    m.a(chatMessage.getText(), com.garena.android.appkit.tools.b.e(R.string.sp_copy_text_done));
                }
                fVar.dismiss();
            }
        });
    }

    public static void c(final View view, final ChatMessage chatMessage) {
        a(view, f20025c, new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i != 0) {
                    if (i == 1) {
                        Context context = view.getContext();
                        NavbarMessage navbarMessage = new NavbarMessage();
                        navbarMessage.setTitle(chatMessage.getLinkUrl());
                        if (chatMessage.isWhitelistCensored()) {
                            bm.a(context, chatMessage.getLinkUrl());
                        } else {
                            boolean z = false;
                            try {
                                if (Uri.parse(chatMessage.getLinkUrl()).getHost().endsWith(i.f7042e)) {
                                    try {
                                        WebPageActivity_.a(context).a(WebRegister.GSON.b((Object) navbarMessage)).b(chatMessage.getLinkUrl()).a();
                                    } catch (Exception unused) {
                                    }
                                    z = true;
                                }
                            } catch (Exception unused2) {
                            }
                            if (!z) {
                                SimpleWebPageActivity_.a(context).a(WebRegister.GSON.b((Object) navbarMessage)).b(chatMessage.getLinkUrl()).a(true).a();
                            }
                        }
                    }
                } else if (!TextUtils.isEmpty(chatMessage.getText())) {
                    if (chatMessage.getLinkUrl() == null || chatMessage.getLinkUrl().isEmpty() || !chatMessage.isWhitelistCensored()) {
                        m.a(chatMessage.getText(), com.garena.android.appkit.tools.b.e(R.string.sp_copy_text_done));
                    } else {
                        a.a(view.getContext(), chatMessage.getText());
                    }
                }
                fVar.dismiss();
            }
        });
    }

    public static void a(Context context, final String str) {
        com.shopee.app.ui.dialog.a.a(context, com.garena.android.appkit.tools.b.e(R.string.sp_title_copy_text_alert), com.garena.android.appkit.tools.b.e(R.string.sp_label_copy_text_alert_content), com.garena.android.appkit.tools.b.e(R.string.sp_label_cancel), com.garena.android.appkit.tools.b.e(R.string.sp_label_yes_i_am_sure), (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                m.a(str, com.garena.android.appkit.tools.b.e(R.string.sp_copy_text_done));
            }
        });
    }

    private static void a(View view, CharSequence[] charSequenceArr, a.c cVar) {
        com.shopee.app.ui.dialog.a.a(view.getContext(), charSequenceArr, cVar);
    }
}
