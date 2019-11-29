package com.squareup.a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.facebook.common.util.UriUtil;
import com.squareup.a.ab;
import com.squareup.a.w;
import java.io.IOException;
import java.io.InputStream;

class f extends ab {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f30547a = new UriMatcher(-1);

    /* renamed from: b  reason: collision with root package name */
    private final Context f30548b;

    static {
        f30547a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f30547a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f30547a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f30547a.addURI("com.android.contacts", "contacts/#", 3);
        f30547a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    f(Context context) {
        this.f30548b = context;
    }

    public boolean a(z zVar) {
        Uri uri = zVar.f30601d;
        return UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f30547a.match(zVar.f30601d) != -1;
    }

    public ab.a a(z zVar, int i) throws IOException {
        InputStream b2 = b(zVar);
        if (b2 != null) {
            return new ab.a(b2, w.d.DISK);
        }
        return null;
    }

    private InputStream b(z zVar) throws IOException {
        ContentResolver contentResolver = this.f30548b.getContentResolver();
        Uri uri = zVar.f30601d;
        int match = f30547a.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return a.a(contentResolver, uri);
    }

    @TargetApi(14)
    private static class a {
        static InputStream a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }
}
