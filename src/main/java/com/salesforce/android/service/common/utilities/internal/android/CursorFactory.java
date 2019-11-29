package com.salesforce.android.service.common.utilities.internal.android;

import android.content.Context;
import android.net.Uri;
import androidx.g.b.b;

public class CursorFactory {
    public b newCursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return new b(context, uri, strArr, str, strArr2, str2);
    }
}
