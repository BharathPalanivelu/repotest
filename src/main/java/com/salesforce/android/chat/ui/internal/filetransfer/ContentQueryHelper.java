package com.salesforce.android.chat.ui.internal.filetransfer;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.j256.ormlite.field.FieldType;
import java.io.File;
import java.io.FileNotFoundException;

class ContentQueryHelper {
    ContentQueryHelper() {
    }

    /* access modifiers changed from: package-private */
    public Cursor queryImagesSortedByDateTakenDesc(ContentResolver contentResolver) throws FileNotFoundException {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "_data", "datetaken"}, (String) null, (String[]) null, "datetaken DESC");
        if (query != null && query.getCount() != 0) {
            return query;
        }
        throw new FileNotFoundException();
    }

    /* access modifiers changed from: package-private */
    public Uri findPhotoLastTaken(Cursor cursor) throws FileNotFoundException {
        Uri parseUri;
        File parseFile;
        cursor.moveToFirst();
        do {
            parseUri = parseUri(cursor);
            parseFile = parseFile(cursor);
            if (parseFile.canRead()) {
                break;
            }
        } while (cursor.moveToNext());
        cursor.close();
        if (parseFile.exists() && parseFile.canRead()) {
            return parseUri;
        }
        throw new FileNotFoundException();
    }

    private File parseFile(Cursor cursor) {
        return new File(cursor.getString(cursor.getColumnIndex("_data")));
    }

    private Uri parseUri(Cursor cursor) {
        return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (long) cursor.getInt(cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX)));
    }
}
