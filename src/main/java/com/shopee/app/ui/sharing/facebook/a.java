package com.shopee.app.ui.sharing.facebook;

import android.app.Activity;
import android.net.Uri;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.shopee.app.ui.sharing.base.b;
import d.d.b.j;

public final class a extends com.shopee.app.ui.sharing.base.a<FacebookLinkData> {
    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(FacebookLinkData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    /* renamed from: a */
    public boolean b(FacebookLinkData facebookLinkData) {
        j.b(facebookLinkData, "shareLinkData");
        CharSequence contentUrl = facebookLinkData.getContentUrl();
        return !(contentUrl == null || contentUrl.length() == 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(FacebookLinkData facebookLinkData) {
        j.b(facebookLinkData, "shareLinkData");
        Activity b2 = b();
        if (b2 != null) {
            ShareLinkContent.Builder quote = ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(facebookLinkData.getContentUrl()))).setQuote(facebookLinkData.getQuote());
            CharSequence quote2 = facebookLinkData.getQuote();
            boolean z = true;
            if (!(quote2 == null || quote2.length() == 0)) {
                quote.setQuote(facebookLinkData.getQuote());
            }
            CharSequence hashTag = facebookLinkData.getHashTag();
            if (!(hashTag == null || hashTag.length() == 0)) {
                z = false;
            }
            if (!z) {
                quote.setShareHashtag(new ShareHashtag.Builder().setHashtag(facebookLinkData.getHashTag()).build());
            }
            ShareLinkContent build = quote.build();
            ShareDialog shareDialog = new ShareDialog(b2);
            if (ShareDialog.canShow(ShareLinkContent.class)) {
                shareDialog.show(build);
                a(new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null));
                return;
            }
            a(new com.shopee.app.ui.sharing.base.data.a(-1, (String) null, 2, (g) null));
        }
    }
}
