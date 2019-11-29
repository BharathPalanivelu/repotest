package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import androidx.core.d.b;
import androidx.core.d.c;

public final class a {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, b bVar) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 16) {
            if (bVar != null) {
                try {
                    obj = bVar.d();
                } catch (Exception e2) {
                    if (e2 instanceof OperationCanceledException) {
                        throw new c();
                    }
                    throw e2;
                }
            } else {
                obj = null;
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
        if (bVar != null) {
            bVar.b();
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }
}
