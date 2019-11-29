package com.shopee.app.util.sfchat;

import android.app.Activity;
import android.content.Context;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.ChatCore;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.ChatUI;
import com.salesforce.android.chat.ui.ChatUIClient;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedActivity;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.service.common.ui.internal.minimize.Minimizer;
import com.salesforce.android.service.common.utilities.control.Async;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.setting.SalesforceConfigs;
import com.shopee.app.h.r;
import com.shopee.app.react.ReactTransparentActivity_;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.util.ac;
import com.shopee.app.util.ak;
import com.shopee.app.util.sfchat.ui.SFChatProxyActivity_;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.app.web.protocol.SalesforceChatData;
import com.shopee.id.R;
import d.d.b.j;
import d.l;
import java.lang.ref.WeakReference;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f26507a = new b();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f26508b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static ChatUIClient f26509c;

    /* renamed from: d  reason: collision with root package name */
    private static SalesforceChatData f26510d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static WeakReference<a> f26511e = new WeakReference<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<androidx.fragment.app.c> f26512f = new WeakReference<>((Object) null);

    /* renamed from: g  reason: collision with root package name */
    private static final f f26513g = new f();

    private b() {
    }

    public final void a(Activity activity, SalesforceChatData salesforceChatData) {
        j.b(activity, "activity");
        SFChatProxyActivity_.a((Context) activity).a(com.shopee.web.sdk.bridge.internal.a.f30470a.b((Object) salesforceChatData)).a();
    }

    public final void a(androidx.fragment.app.c cVar, SalesforceChatData salesforceChatData, a aVar) {
        j.b(cVar, "activity");
        j.b(salesforceChatData, "chatData");
        j.b(aVar, "launchCallback");
        f26510d = salesforceChatData;
        f26511e = new WeakReference<>(aVar);
        f26512f = new WeakReference<>(cVar);
        ChatConfiguration.Builder a2 = com.shopee.app.util.sfchat.a.b.f26506a.a(h());
        if (a2 == null) {
            r.a().b((int) R.string.could_not_connect_error_message);
            a aVar2 = (a) f26511e.get();
            if (aVar2 != null) {
                aVar2.a();
                return;
            }
            return;
        }
        ChatCore.configureAgentAvailability(a2.build()).check().onResult(a.f26514a);
    }

    static final class a<T> implements Async.ResultHandler<AvailabilityState> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f26514a = new a();

        a() {
        }

        /* renamed from: a */
        public final void handleResult(Async<?> async, AvailabilityState availabilityState) {
            j.b(availabilityState, AbTestingModule.KEY_RESULT);
            com.garena.android.appkit.d.a.b("check status: " + availabilityState.getStatus(), new Object[0]);
            int i = c.f26521a[availabilityState.getStatus().ordinal()];
            if (i == 1) {
                b.f26507a.d();
            } else if (i != 2) {
                r.a().b((int) R.string.could_not_connect_error_message);
                a aVar = (a) b.f26511e.get();
                if (aVar != null) {
                    aVar.a();
                }
            } else {
                b.f26507a.e();
                a aVar2 = (a) b.f26511e.get();
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        ChatConfiguration.Builder a2 = com.shopee.app.util.sfchat.a.b.f26506a.a(h());
        androidx.fragment.app.c cVar = (androidx.fragment.app.c) f26512f.get();
        if (a2 == null || cVar == null) {
            r.a().b((int) R.string.could_not_connect_error_message);
            a aVar = (a) f26511e.get();
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        UserInfo loggedInUser = f2.e().loggedInUser();
        j.a((Object) loggedInUser, "ShopeeApplication.get().component.loggedInUser()");
        a2.visitorName(loggedInUser.getUsername());
        com.shopee.app.util.sfchat.a.b.f26506a.a(a2, i(), f26510d, k());
        ChatUIConfiguration build = new ChatUIConfiguration.Builder().chatConfiguration(a2.build()).disablePreChatView(true).defaultToMinimized(false).build();
        ChatUI.configure(build).createClient(cVar).onError(C0410b.f26515a).onResult(new c(build));
    }

    /* renamed from: com.shopee.app.util.sfchat.b$b  reason: collision with other inner class name */
    static final class C0410b implements Async.ErrorHandler {

        /* renamed from: a  reason: collision with root package name */
        public static final C0410b f26515a = new C0410b();

        C0410b() {
        }

        public final void handleError(Async<?> async, Throwable th) {
            j.b(th, "throwable");
            com.garena.android.appkit.d.a.a(th);
            a aVar = (a) b.f26511e.get();
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    static final class c<T> implements Async.ResultHandler<ChatUIClient> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatUIConfiguration f26516a;

        c(ChatUIConfiguration chatUIConfiguration) {
            this.f26516a = chatUIConfiguration;
        }

        /* renamed from: a */
        public final void handleResult(Async<?> async, ChatUIClient chatUIClient) {
            j.b(chatUIClient, "chatUIClient");
            b bVar = b.f26507a;
            ChatUIConfiguration chatUIConfiguration = this.f26516a;
            j.a((Object) chatUIConfiguration, "uiConfig");
            bVar.a(chatUIClient, com.shopee.app.util.sfchat.a.c.a(chatUIConfiguration));
        }
    }

    /* access modifiers changed from: private */
    public final void a(ChatUIClient chatUIClient, String str) {
        androidx.fragment.app.c cVar = (androidx.fragment.app.c) f26512f.get();
        if (cVar != null && !cVar.isFinishing()) {
            chatUIClient.addSessionStateListener(f26513g);
            chatUIClient.startChatSession(cVar).onComplete(new d(chatUIClient, str, cVar)).onError(e.f26520a);
        }
    }

    static final class d implements Async.CompletionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatUIClient f26517a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f26518b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.c f26519c;

        d(ChatUIClient chatUIClient, String str, androidx.fragment.app.c cVar) {
            this.f26517a = chatUIClient;
            this.f26518b = str;
            this.f26519c = cVar;
        }

        public final void handleComplete(Async<?> async) {
            b.f26509c = this.f26517a;
            b.f26508b = this.f26518b;
            com.shopee.app.util.sfchat.a.a aVar = com.shopee.app.util.sfchat.a.a.f26505a;
            Context applicationContext = this.f26519c.getApplicationContext();
            j.a((Object) applicationContext, "activity.applicationContext");
            aVar.a(applicationContext);
            a aVar2 = (a) b.f26511e.get();
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    static final class e implements Async.ErrorHandler {

        /* renamed from: a  reason: collision with root package name */
        public static final e f26520a = new e();

        e() {
        }

        public final void handleError(Async<?> async, Throwable th) {
            j.b(th, "throwable");
            com.garena.android.appkit.d.a.a(th);
            a aVar = (a) b.f26511e.get();
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void a() {
        ChatUIClient chatUIClient = f26509c;
        if (chatUIClient != null) {
            chatUIClient.endChatSession();
        }
        f();
    }

    public final void b() {
        Activity c2 = c();
        if (c2 != null) {
            ar a2 = ar.a((Context) c2);
            j.a((Object) a2, "ShopeeApplication.get(activity)");
            com.shopee.app.application.a.b appLifeCycleManager = a2.e().appLifeCycleManager();
            if (!(c2 instanceof ChatFeedActivity)) {
                j.a((Object) appLifeCycleManager, "appLifeCycleManager");
                if (appLifeCycleManager.a()) {
                    return;
                }
            }
            com.shopee.app.util.sfchat.a.b.f26506a.a(c2);
            Minimizer.addIgnoredActivity(ReactTransparentActivity_.class);
            k j = f26507a.j();
            if (j != null && j.c()) {
                new ak(c2).a("LIVE_CHAT_FEEDBACK_DIALOG", 3, ac.a(l.a("chatKey", f26508b)).toString(), "");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        Activity c2 = c();
        if (c2 != null) {
            SalesforceChatData salesforceChatData = f26510d;
            String str = null;
            CharSequence offlineFormUrl = salesforceChatData != null ? salesforceChatData.getOfflineFormUrl() : null;
            if (!(offlineFormUrl == null || offlineFormUrl.length() == 0)) {
                WebPageActivity_.a a2 = WebPageActivity_.a(c2);
                SalesforceChatData salesforceChatData2 = f26510d;
                if (salesforceChatData2 != null) {
                    str = salesforceChatData2.getOfflineFormUrl();
                }
                a2.b(str).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
            }
        }
    }

    public final void a(Context context) {
        j.b(context, "context");
        if (g()) {
            a();
        } else {
            com.shopee.app.util.sfchat.a.a.f26505a.b(context);
        }
    }

    public final Activity c() {
        androidx.fragment.app.c cVar = (androidx.fragment.app.c) f26512f.get();
        if (cVar == null || cVar.isFinishing()) {
            return com.shopee.app.util.sfchat.a.c.a(f26509c);
        }
        return (Activity) f26512f.get();
    }

    private final void f() {
        Minimizer.removeIgnoredActivity(ReactTransparentActivity_.class);
        try {
            ChatUIClient chatUIClient = f26509c;
            if (chatUIClient != null && (chatUIClient instanceof InternalChatUIClient)) {
                ((InternalChatUIClient) chatUIClient).closeMinimizedView();
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public static final class f implements SessionStateListener {
        f() {
        }

        public void onSessionEnded(ChatEndReason chatEndReason) {
            com.garena.android.appkit.d.a.b("onSessionEnded " + chatEndReason, new Object[0]);
            if (chatEndReason != null) {
                int i = c.f26522b[chatEndReason.ordinal()];
                if (i == 1) {
                    b.f26507a.e();
                } else if (i == 2) {
                    b.f26507a.b();
                }
            }
        }

        public void onSessionStateChange(ChatSessionState chatSessionState) {
            com.garena.android.appkit.d.a.b("onSessionStateChange " + chatSessionState, new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean g() {
        /*
            r2 = this;
            com.salesforce.android.chat.ui.ChatUIClient r0 = f26509c
            r1 = 0
            if (r0 == 0) goto L_0x0015
            if (r0 == 0) goto L_0x0012
            com.salesforce.android.chat.core.model.ChatSessionState r0 = r0.getCurrentSessionState()
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isPostSession()
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 == 0) goto L_0x0016
        L_0x0015:
            r1 = 1
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.sfchat.b.g():boolean");
    }

    private final SalesforceConfigs h() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        SettingConfigStore settingConfigStore = f2.e().settingConfigStore();
        j.a((Object) settingConfigStore, "ShopeeApplication.get().…nent.settingConfigStore()");
        return settingConfigStore.getSalesforceConfigs();
    }

    private final UserInfo i() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        return f2.e().loggedInUser();
    }

    private final k j() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        return f2.e().rnConfigProvider();
    }

    private final String k() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        WebDataStore webStore = f2.e().webStore();
        String str = webStore != null ? webStore.get("chatbotHistory") : null;
        if (str != null) {
            if (str.length() > 0) {
                webStore.put("chatbotHistory", "", true);
                webStore.put("chatbotHistory", "", false);
            }
        }
        return str;
    }
}
