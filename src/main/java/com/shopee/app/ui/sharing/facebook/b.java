package com.shopee.app.ui.sharing.facebook;

import android.app.Activity;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.shopee.app.ui.sharing.base.a;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import com.shopee.app.ui.sharing.base.helper.c;
import d.d.b.j;

public final class b extends a<FacebookPhotoData> {
    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Activity activity, com.shopee.app.ui.sharing.base.b bVar) {
        super(FacebookPhotoData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    /* renamed from: a */
    public boolean b(FacebookPhotoData facebookPhotoData) {
        j.b(facebookPhotoData, "shareData");
        if (facebookPhotoData.getImage() != null) {
            CharSequence imageUrl = facebookPhotoData.getImage().getImageUrl();
            if (!(imageUrl == null || imageUrl.length() == 0)) {
                return true;
            }
            CharSequence imageBase64 = facebookPhotoData.getImage().getImageBase64();
            if (!(imageBase64 == null || imageBase64.length() == 0)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(FacebookPhotoData facebookPhotoData) {
        j.b(facebookPhotoData, "shareData");
        ShareImage image = facebookPhotoData.getImage();
        if (image != null) {
            a(image);
        }
    }

    public void b(String str) {
        j.b(str, "filePath");
        Activity b2 = b();
        if (b2 != null) {
            a(c.b(b2, str));
        }
    }

    private final void a(Uri uri) {
        Activity b2 = b();
        if (b2 != null) {
            if (uri == null) {
                a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
            }
            SharePhotoContent build = new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(MediaStore.Images.Media.getBitmap(b2.getContentResolver(), uri)).build()).build();
            ShareDialog shareDialog = new ShareDialog(b2);
            try {
                if (ShareDialog.canShow(SharePhotoContent.class)) {
                    shareDialog.show(build);
                    a(new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null));
                    return;
                }
                a(new com.shopee.app.ui.sharing.base.data.a(2, (String) null, 2, (g) null));
            } catch (Exception e2) {
                a(new com.shopee.app.ui.sharing.base.data.a(-1, e2.toString()));
            }
        }
    }
}
