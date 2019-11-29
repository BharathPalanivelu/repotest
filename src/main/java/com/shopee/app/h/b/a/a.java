package com.shopee.app.h.b.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f17628a = {"bucket_id", "bucket_display_name", "_data", "width", "height", "date_added"};

    /* renamed from: b  reason: collision with root package name */
    private List<GalleryAlbumInfo> f17629b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<String> f17630c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Context f17631d;

    public a(ar arVar) {
        this.f17631d = arVar;
    }

    public void a() {
        if (this.f17629b.isEmpty()) {
            this.f17629b = a(".gif,.png,.jpg,.jpeg".split(","));
        }
    }

    public List<GalleryAlbumInfo> b() {
        return this.f17629b;
    }

    private List<GalleryAlbumInfo> a(String[] strArr) {
        String[] strArr2 = strArr;
        Cursor query = this.f17631d.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, f17628a, (String) null, (String[]) null, "datetaken DESC");
        HashMap hashMap = new HashMap();
        GalleryAlbumInfo galleryAlbumInfo = new GalleryAlbumInfo();
        galleryAlbumInfo.setName(b.e(R.string.sp_label_all_images));
        galleryAlbumInfo.setId(-1);
        hashMap.put(-1L, galleryAlbumInfo);
        if (query != null) {
            while (query.moveToNext()) {
                long j = query.getLong(query.getColumnIndex("bucket_id"));
                String string = query.getString(query.getColumnIndex("_data"));
                if (strArr2 != null && strArr2.length > 0 && !TextUtils.isEmpty(string)) {
                    int length = strArr2.length;
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (string.toLowerCase().endsWith(strArr2[i])) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (!z) {
                    }
                }
                int i2 = query.getInt(query.getColumnIndex("width"));
                int i3 = query.getInt(query.getColumnIndex("height"));
                long j2 = query.getLong(query.getColumnIndex("date_added"));
                String string2 = query.getString(query.getColumnIndex("bucket_display_name"));
                if (a(string) && !"Instagram".equals(string2)) {
                    if (!hashMap.containsKey(Long.valueOf(j))) {
                        GalleryAlbumInfo galleryAlbumInfo2 = new GalleryAlbumInfo();
                        galleryAlbumInfo2.setName(string2);
                        GalleryAlbumInfo galleryAlbumInfo3 = galleryAlbumInfo2;
                        galleryAlbumInfo2.addPhoto(string, i2, i3, j2);
                        galleryAlbumInfo3.setId(j);
                        hashMap.put(Long.valueOf(j), galleryAlbumInfo3);
                    } else {
                        ((GalleryAlbumInfo) hashMap.get(Long.valueOf(j))).addPhoto(string, i2, i3, j2);
                    }
                    galleryAlbumInfo.addPhoto(string, i2, i3, j2);
                }
            }
            query.close();
        }
        return a((List<GalleryAlbumInfo>) new ArrayList(hashMap.values()));
    }

    private static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".png") || lowerCase.endsWith(".bmp")) {
            return true;
        }
        return false;
    }

    private static List<GalleryAlbumInfo> a(List<GalleryAlbumInfo> list) {
        if (list.isEmpty()) {
            return list;
        }
        Collections.sort(list, new Comparator<GalleryAlbumInfo>() {
            /* renamed from: a */
            public int compare(GalleryAlbumInfo galleryAlbumInfo, GalleryAlbumInfo galleryAlbumInfo2) {
                return galleryAlbumInfo.getName().compareTo(galleryAlbumInfo2.getName());
            }
        });
        String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/Camera/";
        int i = -1;
        int i2 = 0;
        for (GalleryAlbumInfo imagePath : list) {
            if (imagePath.getImagePath().startsWith(str)) {
                i = i2;
            }
            i2++;
        }
        if (i != -1) {
            list.add(1, list.remove(i));
        }
        return list;
    }
}
