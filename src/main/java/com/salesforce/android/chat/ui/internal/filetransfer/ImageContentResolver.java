package com.salesforce.android.chat.ui.internal.filetransfer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.salesforce.android.chat.ui.internal.filetransfer.ExifReader;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageMeta;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.internal.android.ContentFactory;
import com.salesforce.android.service.common.utilities.internal.android.CursorFactory;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

class ImageContentResolver {
    private static final String NEW_IMAGE_FILE_EXTENSION = "jpg";
    private static final String NEW_IMAGE_MIME_TYPE = "image/jpeg";
    private static final ServiceLogger log = ServiceLogging.getLogger(ImageContentResolver.class);
    private final ContentFactory mContentFactory;
    private final ContentQueryHelper mContentQueryHelper;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final CursorFactory mCursorFactory;
    private final ExifReader mExifReader;
    private final Optional<String> mPhotoDirectoryName;

    private ImageContentResolver(Builder builder) {
        this.mContext = builder.mContext;
        this.mExifReader = builder.mExifReader;
        this.mContentResolver = builder.mContentResolver;
        this.mContentFactory = builder.mContentFactory;
        this.mCursorFactory = builder.mCursorFactory;
        this.mContentQueryHelper = builder.mContentQueryHelper;
        this.mPhotoDirectoryName = builder.mPhotoDirectoryName;
    }

    /* access modifiers changed from: package-private */
    public Uri createNewImage() {
        log.trace("Creating a new image in the MediaStore.");
        final String format = String.format(Locale.US, "%s.%s", new Object[]{UUID.randomUUID().toString(), NEW_IMAGE_FILE_EXTENSION});
        long time = new Date().getTime();
        final ContentValues newContentValues = this.mContentFactory.newContentValues();
        newContentValues.put("title", format);
        newContentValues.put("mime_type", NEW_IMAGE_MIME_TYPE);
        newContentValues.put("datetaken", Long.valueOf(time));
        newContentValues.put("date_added", Long.valueOf(time));
        this.mPhotoDirectoryName.ifPresent(new Consumer<String>() {
            public void consume(String str) {
                String format = String.format(Locale.US, "%s/%s", new Object[]{Environment.getExternalStorageDirectory(), str});
                if (ImageContentResolver.this.createDirectoryIfNotExists(format)) {
                    newContentValues.put("_data", String.format(Locale.US, "%s/%s", new Object[]{format, format}));
                }
            }
        });
        return this.mContentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, newContentValues);
    }

    /* access modifiers changed from: package-private */
    public ImageMeta createImageMeta(Uri uri) {
        log.trace("Composing meta information for {}", uri);
        return new ImageMeta(uri, getMimeType(uri), this.mExifReader.getImageOrientation(getFilePathFromUri(uri)));
    }

    /* access modifiers changed from: package-private */
    public String getFilePathFromUri(Uri uri) {
        log.trace("Retrieving file path for {}", uri);
        if (uri.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME)) {
            return getFilePathFromContent(uri);
        }
        return uri.getPath();
    }

    /* access modifiers changed from: package-private */
    public Uri getLastPhotoTaken() throws FileNotFoundException {
        Uri findPhotoLastTaken = this.mContentQueryHelper.findPhotoLastTaken(this.mContentQueryHelper.queryImagesSortedByDateTakenDesc(this.mContentResolver));
        log.info("Found the last photo taken: {}", findPhotoLastTaken);
        return findPhotoLastTaken;
    }

    /* access modifiers changed from: package-private */
    public String getMimeType(Uri uri) {
        log.trace("Reading MimeType for {}", uri);
        if (uri.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME)) {
            return this.mContentResolver.getType(uri);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
    }

    /* access modifiers changed from: private */
    public boolean createDirectoryIfNotExists(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    private String getFilePathFromContent(Uri uri) {
        Cursor h = this.mCursorFactory.newCursorLoader(this.mContext, uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null).d();
        h.moveToFirst();
        String string = h.getString(h.getColumnIndex("_data"));
        h.close();
        return string == null ? createNewImage().toString() : string;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ContentFactory mContentFactory;
        /* access modifiers changed from: private */
        public ContentQueryHelper mContentQueryHelper;
        /* access modifiers changed from: private */
        public ContentResolver mContentResolver;
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public CursorFactory mCursorFactory;
        /* access modifiers changed from: private */
        public ExifReader mExifReader;
        /* access modifiers changed from: private */
        public Optional<String> mPhotoDirectoryName = Optional.empty();

        /* access modifiers changed from: package-private */
        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder photoDirectoryName(String str) {
            this.mPhotoDirectoryName = Optional.of(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder exifReader(ExifReader exifReader) {
            this.mExifReader = exifReader;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder contentResolver(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder contentFactory(ContentFactory contentFactory) {
            this.mContentFactory = contentFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder cursorFactory(CursorFactory cursorFactory) {
            this.mCursorFactory = cursorFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder contentQueryHelper(ContentQueryHelper contentQueryHelper) {
            this.mContentQueryHelper = contentQueryHelper;
            return this;
        }

        public ImageContentResolver build() {
            Arguments.checkNotNull(this.mContext);
            if (this.mExifReader == null) {
                this.mExifReader = new ExifReader.Builder().build();
            }
            if (this.mContentResolver == null) {
                this.mContentResolver = this.mContext.getContentResolver();
            }
            if (this.mContentFactory == null) {
                this.mContentFactory = new ContentFactory();
            }
            if (this.mCursorFactory == null) {
                this.mCursorFactory = new CursorFactory();
            }
            if (this.mContentQueryHelper == null) {
                this.mContentQueryHelper = new ContentQueryHelper();
            }
            return new ImageContentResolver(this);
        }
    }
}
