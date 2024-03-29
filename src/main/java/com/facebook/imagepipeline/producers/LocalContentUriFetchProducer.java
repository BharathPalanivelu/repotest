package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.j256.ormlite.field.FieldType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private static final String[] PROJECTION = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "_data"};
    private final ContentResolver mContentResolver;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        InputStream inputStream;
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalContactUri(sourceUri)) {
            if (sourceUri.toString().endsWith("/photo")) {
                inputStream = this.mContentResolver.openInputStream(sourceUri);
            } else if (sourceUri.toString().endsWith("/display_photo")) {
                try {
                    inputStream = this.mContentResolver.openAssetFileDescriptor(sourceUri, "r").createInputStream();
                } catch (IOException unused) {
                    throw new IOException("Contact photo does not exist: " + sourceUri);
                }
            } else {
                InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, sourceUri);
                if (openContactPhotoInputStream != null) {
                    inputStream = openContactPhotoInputStream;
                } else {
                    throw new IOException("Contact photo does not exist: " + sourceUri);
                }
            }
            return getEncodedImage(inputStream, -1);
        }
        if (UriUtil.isLocalCameraUri(sourceUri)) {
            EncodedImage cameraImage = getCameraImage(sourceUri);
            if (cameraImage != null) {
                return cameraImage;
            }
        }
        return getEncodedImage(this.mContentResolver.openInputStream(sourceUri), -1);
    }

    private EncodedImage getCameraImage(Uri uri) throws IOException {
        Cursor query = this.mContentResolver.query(uri, PROJECTION, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (string != null) {
                EncodedImage encodedImage = getEncodedImage(new FileInputStream(string), getLength(string));
                query.close();
                return encodedImage;
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }
}
