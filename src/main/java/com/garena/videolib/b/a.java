package com.garena.videolib.b;

import android.content.Context;
import com.garena.videolib.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f8702b = {"bucket_id", "bucket_display_name", "_data", "duration"};

    /* renamed from: a  reason: collision with root package name */
    private final Context f8703a;

    public a(Context context) {
        this.f8703a = context;
    }

    public List<b> a() {
        return a(".mp4,.mov,.3gp".split(","));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.garena.videolib.a.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.garena.videolib.a.b> a(java.lang.String[] r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f8703a
            android.content.ContentResolver r1 = r0.getContentResolver()
            android.net.Uri r2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            java.lang.String[] r3 = f8702b
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            if (r0 == 0) goto L_0x009b
        L_0x0018:
            boolean r2 = r0.moveToNext()
            if (r2 == 0) goto L_0x0098
            java.lang.String r2 = "bucket_id"
            int r2 = r0.getColumnIndex(r2)
            long r2 = r0.getLong(r2)
            java.lang.String r4 = "_data"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r4 = r0.getString(r4)
            if (r11 == 0) goto L_0x0056
            int r5 = r11.length
            if (r5 <= 0) goto L_0x0056
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0056
            int r5 = r11.length
            r6 = 0
            r7 = 0
        L_0x0040:
            if (r7 >= r5) goto L_0x0053
            r8 = r11[r7]
            java.lang.String r9 = r4.toLowerCase()
            boolean r8 = r9.endsWith(r8)
            if (r8 == 0) goto L_0x0050
            r6 = 1
            goto L_0x0053
        L_0x0050:
            int r7 = r7 + 1
            goto L_0x0040
        L_0x0053:
            if (r6 != 0) goto L_0x0056
            goto L_0x0018
        L_0x0056:
            com.garena.videolib.a.c r5 = new com.garena.videolib.a.c
            r5.<init>(r4)
            java.lang.String r4 = "duration"
            int r4 = r0.getColumnIndex(r4)
            long r6 = r0.getLong(r4)
            r5.a(r6)
            java.lang.Long r4 = java.lang.Long.valueOf(r2)
            boolean r4 = r1.containsKey(r4)
            if (r4 != 0) goto L_0x0089
            java.lang.String r4 = "bucket_display_name"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r4 = r0.getString(r4)
            com.garena.videolib.a.b r6 = new com.garena.videolib.a.b
            r6.<init>(r2, r4)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.put(r2, r6)
            goto L_0x0094
        L_0x0089:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r2 = r1.get(r2)
            r6 = r2
            com.garena.videolib.a.b r6 = (com.garena.videolib.a.b) r6
        L_0x0094:
            r6.a(r5)
            goto L_0x0018
        L_0x0098:
            r0.close()
        L_0x009b:
            java.util.List r11 = r10.a((java.util.HashMap<java.lang.Long, com.garena.videolib.a.b>) r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.videolib.b.a.a(java.lang.String[]):java.util.List");
    }

    private List<b> a(HashMap<Long, b> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (b add : hashMap.values()) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
