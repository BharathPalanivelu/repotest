package com.shopee.app.util.l;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.EditProductMessage;
import com.shopee.app.web.protocol.FeedCommentData;
import com.shopee.app.web.protocol.ImageSearchData;
import com.shopee.app.web.protocol.OpenChatMessage;
import com.shopee.app.web.protocol.PhotoRatingPageData;
import com.shopee.app.web.protocol.SalesforceChatData;
import com.shopee.app.web.protocol.SearchUserData;
import com.shopee.app.web.protocol.ShowCommentMessage;
import com.shopee.app.web.protocol.ShowMapMessage;
import com.shopee.navigator.NavigationPath;
import java.util.HashMap;
import java.util.List;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ak f26414a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, a> f26415b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private UserInfo f26416c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public UploadManager f26417d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.navigator.e f26418e;

    public b(ak akVar, com.shopee.navigator.e eVar, UserInfo userInfo, UploadManager uploadManager) {
        this.f26414a = akVar;
        this.f26418e = eVar;
        this.f26416c = userInfo;
        this.f26417d = uploadManager;
        a();
    }

    private void a() {
        this.f26415b.put("facebookContacts", new i());
        this.f26415b.put("addressBookContacts", new c());
        this.f26415b.put("privacySettings", new r());
        this.f26415b.put("feedComment", new j());
        this.f26415b.put("feedComment2", new k());
        this.f26415b.put("map", new n());
        this.f26415b.put(BaseEvent.SDK_CHAT, new f());
        this.f26415b.put("emailComposer", new f());
        this.f26415b.put("blacklistSettings", new d());
        this.f26415b.put("income", new o());
        this.f26415b.put("pendingRelease", new p());
        this.f26415b.put("chatList", new e());
        this.f26415b.put("chatSetting", new g());
        this.f26415b.put("commentList", new h());
        this.f26415b.put("editProduct", new a());
        this.f26415b.put("searchOrder", new u());
        this.f26415b.put("searchUser", new v());
        this.f26415b.put("salesforceChat", new t());
        this.f26415b.put("imageSearch", new l());
        this.f26415b.put("imageSearchEdit", new m());
        this.f26415b.put("photoRatingPage", new q());
        this.f26415b.put("sellingPage", new s());
        this.f26415b.put("addFriends", new C0406b());
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.shopee.navigator.a.f30104c;
        }
        try {
            if (new com.shopee.navigator.c.a(str).e()) {
                com.google.a.o m2 = com.shopee.navigator.a.f30103b.a(str2).m();
                this.f26418e.a((Activity) this.f26414a.a(), NavigationPath.a(str), m2, com.shopee.app.b.a.a.a(m2));
                return true;
            }
            String a2 = com.shopee.app.b.a.a.a(str);
            if (a2 != null) {
                this.f26418e.a((Activity) this.f26414a.a(), NavigationPath.a(a2), com.shopee.navigator.a.f30103b.a(str2).m());
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                String str3 = str.split("\\?")[0];
                if (this.f26415b.containsKey(str3)) {
                    a aVar = this.f26415b.get(str3);
                    if (!aVar.a()) {
                        aVar.a(str, null);
                    } else if (!TextUtils.isEmpty(str2)) {
                        try {
                            aVar.a(str, WebRegister.GSON.a(str2, aVar.b()));
                        } catch (Exception e2) {
                            com.garena.android.appkit.d.a.a(e2);
                        }
                    }
                    return true;
                }
            }
            List<com.shopee.sdk.d.c> b2 = com.shopee.sdk.b.b();
            if (!af.a(b2)) {
                for (com.shopee.sdk.d.c a3 : b2) {
                    if (a3.a((Activity) this.f26414a.a(), str, (com.google.a.o) WebRegister.GSON.a(str2, com.google.a.o.class))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.garena.android.appkit.d.a.a(e3);
            com.garena.b.a.a.b("NavigateAppPath", (Throwable) e3);
        }
    }

    private class i extends e {
        private i() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.a(2, 0);
        }
    }

    private class c extends e {
        private c() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.a(4, 0);
        }
    }

    private class r extends e {
        private r() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.U();
        }
    }

    private class j extends e {
        private j() {
        }

        public void a(String str, Void voidR) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("feedID");
            String queryParameter2 = parse.getQueryParameter("shopID");
            if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
                try {
                    b.this.f26414a.c(Long.parseLong(queryParameter), Integer.parseInt(queryParameter2));
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    private class k extends d<FeedCommentData> {
        private k() {
        }

        public void a(String str, FeedCommentData feedCommentData) {
            b.this.f26414a.c(feedCommentData.getFeedID(), feedCommentData.getShopID());
        }

        public Class<FeedCommentData> b() {
            return FeedCommentData.class;
        }
    }

    private class n extends d<ShowMapMessage> {
        private n() {
        }

        public void a(String str, ShowMapMessage showMapMessage) {
            String str2;
            if (showMapMessage.getShopname().startsWith("@")) {
                str2 = showMapMessage.getShopname().substring(1);
            } else {
                str2 = showMapMessage.getShopname();
            }
            b.this.f26414a.a((float) showMapMessage.getLatitude(), (float) showMapMessage.getLongitude(), showMapMessage.getTitle(), str2);
        }

        public Class<ShowMapMessage> b() {
            return ShowMapMessage.class;
        }
    }

    private class f extends d<OpenChatMessage> {
        private f() {
        }

        public void a(String str, OpenChatMessage openChatMessage) {
            b.this.f26414a.a(new ChatIntention(openChatMessage.getItemID(), openChatMessage.getShopID(), openChatMessage.getOrderID(), openChatMessage.getMessage()), openChatMessage.getUserID());
        }

        public Class<OpenChatMessage> b() {
            return OpenChatMessage.class;
        }
    }

    private class d extends e {
        private d() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.E();
        }
    }

    private class o extends e {
        private o() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.F();
        }
    }

    private class p extends e {
        private p() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.G();
        }
    }

    private class e extends e {
        private e() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.e();
        }
    }

    private class g extends e {
        private g() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.X();
        }
    }

    private class h extends d<ShowCommentMessage> {
        public boolean a() {
            return true;
        }

        private h() {
        }

        public void a(String str, ShowCommentMessage showCommentMessage) {
            b.this.f26414a.a(showCommentMessage.getItemId(), showCommentMessage.getShopId(), showCommentMessage.ratings);
        }

        public Class<ShowCommentMessage> b() {
            return ShowCommentMessage.class;
        }
    }

    private class a extends d<EditProductMessage> {
        private a() {
        }

        public void a(String str, EditProductMessage editProductMessage) {
            b.this.f26414a.a(editProductMessage.getItemId(), b.this.f26417d);
        }

        public Class<EditProductMessage> b() {
            return EditProductMessage.class;
        }
    }

    private class u extends e {
        private u() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.am();
        }
    }

    private class v extends d<SearchUserData> {
        private v() {
        }

        public void a(String str, SearchUserData searchUserData) {
            b.this.f26414a.b(searchUserData.getKeyword(), searchUserData.isOfficialShopOnly());
        }

        public Class<SearchUserData> b() {
            return SearchUserData.class;
        }
    }

    private class t extends d<SalesforceChatData> {
        private t() {
        }

        public void a(String str, SalesforceChatData salesforceChatData) {
            b.this.f26414a.a(salesforceChatData);
        }

        public Class<SalesforceChatData> b() {
            return SalesforceChatData.class;
        }
    }

    private class l extends e {
        private l() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.as();
        }
    }

    private class m extends d<ImageSearchData> {
        public boolean a() {
            return true;
        }

        private m() {
        }

        public void a(String str, ImageSearchData imageSearchData) {
            b.this.f26414a.a(imageSearchData);
        }

        public Class<ImageSearchData> b() {
            return ImageSearchData.class;
        }
    }

    private class q extends d<PhotoRatingPageData> {
        private q() {
        }

        public void a(String str, PhotoRatingPageData photoRatingPageData) {
            b.this.f26414a.a(photoRatingPageData);
        }

        public Class<PhotoRatingPageData> b() {
            return PhotoRatingPageData.class;
        }
    }

    private class s extends e {
        private s() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.W();
        }
    }

    /* renamed from: com.shopee.app.util.l.b$b  reason: collision with other inner class name */
    private class C0406b extends e {
        private C0406b() {
        }

        public void a(String str, Void voidR) {
            b.this.f26414a.av();
        }
    }
}
