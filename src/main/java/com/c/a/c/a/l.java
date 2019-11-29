package com.c.a.c.a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class l extends j<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f5675a = new UriMatcher(-1);

    static {
        f5675a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f5675a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f5675a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f5675a.addURI("com.android.contacts", "contacts/#", 3);
        f5675a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f5675a.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public l(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream c2 = c(uri, contentResolver);
        if (c2 != null) {
            return c2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private InputStream c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f5675a.match(uri);
        if (match != 1) {
            if (match == 3) {
                return a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return a(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    @TargetApi(14)
    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* access modifiers changed from: protected */
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> d() {
        return InputStream.class;
    }
}
