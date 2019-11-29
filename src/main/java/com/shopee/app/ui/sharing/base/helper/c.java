package com.shopee.app.ui.sharing.base.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.beetalk.sdk.e.a;
import com.shopee.app.h.f;
import d.d.b.j;
import d.h.m;
import java.io.File;
import java.io.FileOutputStream;

public final class c {
    public static final boolean a(Context context, String str) {
        j.b(context, "context");
        j.b(str, "appPackageName");
        try {
            Intent intent = new Intent();
            intent.setPackage(str);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            a.a(e2);
            return false;
        }
    }

    public static final com.shopee.app.ui.sharing.base.data.a a(Activity activity, String str, String str2) {
        j.b(activity, "activity");
        j.b(str, "sharePackage");
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            return new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null);
        }
        try {
            Intent intent = new Intent();
            intent.setType("text/*");
            intent.setPackage(str);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str2);
            activity.startActivity(intent);
            return new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null);
        } catch (Exception unused) {
            return new com.shopee.app.ui.sharing.base.data.a(-1, (String) null, 2, (g) null);
        }
    }

    public static final com.shopee.app.ui.sharing.base.data.a a(Activity activity, String str, String str2, String str3) {
        j.b(activity, "activity");
        j.b(str, "sharePackage");
        return a(activity, str, str2, b(activity, str3));
    }

    public static final com.shopee.app.ui.sharing.base.data.a b(Activity activity, String str, String str2, String str3) {
        j.b(activity, "activity");
        j.b(str, "sharePackage");
        if (str3 == null) {
            return new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null);
        }
        try {
            Intent intent = new Intent();
            intent.setType("video/*");
            intent.setPackage(str);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.putExtra("android.intent.extra.STREAM", b(activity, str3));
            activity.startActivity(intent);
            return new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null);
        } catch (Exception unused) {
            return new com.shopee.app.ui.sharing.base.data.a(-1, (String) null, 2, (g) null);
        }
    }

    public static final com.shopee.app.ui.sharing.base.data.a a(Activity activity, String str, String str2, Uri uri) {
        j.b(activity, "activity");
        j.b(str, "sharePackage");
        if (uri == null) {
            return new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null);
        }
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setPackage(str);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.putExtra("android.intent.extra.STREAM", uri);
            activity.startActivity(intent);
            return new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null);
        } catch (Exception unused) {
            return new com.shopee.app.ui.sharing.base.data.a(-1, (String) null, 2, (g) null);
        }
    }

    public static final com.shopee.app.ui.sharing.base.data.a a(Activity activity, String str) {
        j.b(activity, "activity");
        j.b(str, "text");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:"));
        intent.putExtra("sms_body", str);
        activity.startActivity(intent);
        return new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null);
    }

    public static final Uri b(Context context, String str) {
        j.b(context, "context");
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return null;
        }
        try {
            return FileProvider.a(context, "com.shopee.id.fileprovider", new File(m.a(str, "file:///", "", false, 4, (Object) null)));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public static final Uri a(String str) {
        j.b(str, "imageBase64");
        try {
            String substring = str.substring(m.a((CharSequence) str, ",", 0, false, 6, (Object) null) + 1);
            j.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            File file = new File(f.a().d(com.shopee.app.g.c.a(substring) + "_handle_sharing.jpg"));
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            new FileOutputStream(file).write(Base64.decode(substring, 0));
            return Uri.fromFile(file);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public static final Uri a(String str, Bitmap bitmap) {
        j.b(str, "imageId");
        j.b(bitmap, "bitmap");
        try {
            File file = new File(f.a().d(com.shopee.app.g.c.a(str) + "_handle_sharing.jpg"));
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
            return Uri.fromFile(file);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public static final Uri a(String str, byte[] bArr) {
        j.b(str, "fileId");
        j.b(bArr, "byteArray");
        try {
            File file = new File(f.a().c(str));
            if (file.exists()) {
                file.delete();
            }
            d.c.f.a(file, bArr);
            return Uri.fromFile(file);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }
}
