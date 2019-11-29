package com.shopee.app.web.bridge.modules;

import android.content.Context;
import android.content.Intent;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.util.i.a;
import com.shopee.app.util.i.b;
import com.shopee.app.util.i.c;
import com.shopee.app.util.i.e;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import d.d.b.j;

public final class NfcCommandSendingModule extends WebBridgeModule {
    public static final int CMD_EXECUTED_FAILED = 1;
    public static final Companion Companion = new Companion((g) null);
    public static final b FILTER = b.TECH_DISCOVERED;
    public static final String NAME = "sendNfcCommand";
    public static final e.a TECH = e.a.f26378a;
    private final NfcCommandSendingModule$nfcEventCallback$1 nfcEventCallback = new NfcCommandSendingModule$nfcEventCallback$1(this);
    private final c nfcHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return NAME;
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NfcCommandSendingModule(Context context, c cVar) {
        super(context);
        j.b(context, "context");
        j.b(cVar, "nfcHandler");
        this.nfcHandler = cVar;
    }

    /* access modifiers changed from: protected */
    public void onHideView() {
        this.nfcHandler.b();
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.nfcHandler.a(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (obj instanceof Params) {
            this.nfcHandler.a(new a.C0403a((b) null, (e) null, (String) null, (a.b) null, 15, (g) null).a((e) TECH).a(FILTER).a(((Params) obj).getCommand()).a((a.b) this.nfcEventCallback).a());
        }
    }

    public final void onCmdExecutedSuccessfully(String str, String str2, String str3) {
        j.b(str, "tagId");
        j.b(str2, "cmd");
        j.b(str3, "data");
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.success(new Response(str, str2, str3)).toJson());
        }
    }

    public final void onCmdExecutedFailed(String str, String str2, Exception exc) {
        j.b(str, "tagId");
        j.b(str2, "cmd");
        j.b(exc, "e");
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.fail(1, new Response(str, str2, ""), exc.getMessage()).toJson());
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Params {
        @com.google.a.a.c(a = "command")
        private final String command;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.command;
            }
            return params.copy(str);
        }

        public final String component1() {
            return this.command;
        }

        public final Params copy(String str) {
            j.b(str, "command");
            return new Params(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Params) && j.a((Object) this.command, (Object) ((Params) obj).command);
            }
            return true;
        }

        public int hashCode() {
            String str = this.command;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Params(command=" + this.command + SQLBuilder.PARENTHESES_RIGHT;
        }

        public Params(String str) {
            j.b(str, "command");
            this.command = str;
        }

        public final String getCommand() {
            return this.command;
        }
    }

    public static final class Response {
        @com.google.a.a.c(a = "command")
        private final String command;
        @com.google.a.a.c(a = "response")
        private final String response;
        @com.google.a.a.c(a = "tagId")
        private final String tagId;

        public static /* synthetic */ Response copy$default(Response response2, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response2.tagId;
            }
            if ((i & 2) != 0) {
                str2 = response2.command;
            }
            if ((i & 4) != 0) {
                str3 = response2.response;
            }
            return response2.copy(str, str2, str3);
        }

        public final String component1() {
            return this.tagId;
        }

        public final String component2() {
            return this.command;
        }

        public final String component3() {
            return this.response;
        }

        public final Response copy(String str, String str2, String str3) {
            j.b(str, "tagId");
            j.b(str2, "command");
            j.b(str3, "response");
            return new Response(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return false;
            }
            Response response2 = (Response) obj;
            return j.a((Object) this.tagId, (Object) response2.tagId) && j.a((Object) this.command, (Object) response2.command) && j.a((Object) this.response, (Object) response2.response);
        }

        public int hashCode() {
            String str = this.tagId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.command;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.response;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Response(tagId=" + this.tagId + ", command=" + this.command + ", response=" + this.response + SQLBuilder.PARENTHESES_RIGHT;
        }

        public Response(String str, String str2, String str3) {
            j.b(str, "tagId");
            j.b(str2, "command");
            j.b(str3, "response");
            this.tagId = str;
            this.command = str2;
            this.response = str3;
        }

        public final String getTagId() {
            return this.tagId;
        }

        public final String getCommand() {
            return this.command;
        }

        public final String getResponse() {
            return this.response;
        }
    }
}
