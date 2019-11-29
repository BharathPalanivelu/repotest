package com.shopee.feeds.feedlibrary.picture;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.fragment.app.c;
import androidx.g.a.a;
import com.facebook.common.time.Clock;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.feeds.feedlibrary.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f28224b = MediaStore.Files.getContentUri("external");
    /* access modifiers changed from: private */
    public static final String[] h = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "_data", "mime_type", "width", "height", "duration"};
    /* access modifiers changed from: private */
    public static final String[] i = {String.valueOf(1), String.valueOf(3)};

    /* renamed from: a  reason: collision with root package name */
    MediaPlayer f28225a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f28226c = 1;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f28227d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f28228e;

    /* renamed from: f  reason: collision with root package name */
    private long f28229f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f28230g = 0;

    /* renamed from: com.shopee.feeds.feedlibrary.picture.a$a  reason: collision with other inner class name */
    public interface C0434a {
        void a(List<LocalMedia> list);
    }

    public interface b {
        void a(List<LocalMediaFolder> list);
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        return "media_type=? AND _size>0 AND " + str;
    }

    /* access modifiers changed from: private */
    public static String b(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("(media_type=?");
        sb.append(z ? "" : " AND mime_type!='image/gif'");
        sb.append(" OR ");
        sb.append("media_type=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append("_size");
        sb.append(">0");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String[] b(int i2) {
        return new String[]{String.valueOf(i2)};
    }

    public a(c cVar, int i2, boolean z, long j, long j2) {
        this.f28227d = cVar;
        this.f28226c = i2;
        this.f28228e = z;
        this.f28229f = j;
        this.f28230g = j2;
        this.f28225a = new MediaPlayer();
    }

    public void a(final b bVar) {
        a(1, (C0434a) new C0434a() {
            public void a(final List<LocalMedia> list) {
                a.this.a(2, (C0434a) new C0434a() {
                    public void a(final List<LocalMedia> list) {
                        a.this.b((b) new b() {
                            public void a(List<LocalMediaFolder> list) {
                                if (list.size() > 0) {
                                    LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                                    localMediaFolder.c(((LocalMedia) list.get(0)).b());
                                    localMediaFolder.a(com.garena.android.appkit.tools.b.e(c.g.feeds_album_title_photos));
                                    localMediaFolder.a((List<LocalMedia>) list);
                                    list.add(1, localMediaFolder);
                                }
                                if (list.size() > 0) {
                                    LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
                                    localMediaFolder2.c(((LocalMedia) list.get(0)).b());
                                    localMediaFolder2.a(com.garena.android.appkit.tools.b.e(c.g.feeds_album_title_videos));
                                    localMediaFolder2.a((List<LocalMedia>) list);
                                    list.add(2, localMediaFolder2);
                                }
                                bVar.a(list);
                            }
                        });
                    }
                });
            }
        });
    }

    public void b(final b bVar) {
        this.f28227d.getSupportLoaderManager().a(this.f28226c, (Bundle) null, new a.C0049a<Cursor>() {
            public void a(androidx.g.b.c<Cursor> cVar) {
            }

            public androidx.g.b.c<Cursor> a(int i, Bundle bundle) {
                int i2 = i;
                if (i2 == 0) {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.b(a.this.a(0, 0), a.this.f28228e), a.i, "_id DESC");
                } else if (i2 == 1) {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.this.f28228e ? "media_type=? AND _size>0" : "media_type=? AND _size>0 AND mime_type!='image/gif'", a.b(1), "_id DESC");
                } else if (i2 == 2) {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.b(a.this.a(0, 0)), a.b(3), "_id DESC");
                } else if (i2 != 3) {
                    return null;
                } else {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.b(a.this.a(0, 500)), a.b(2), "_id DESC");
                }
            }

            public void a(androidx.g.b.c<Cursor> cVar, Cursor cursor) {
                String str;
                try {
                    ArrayList arrayList = new ArrayList();
                    LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                    ArrayList arrayList2 = new ArrayList();
                    if (cursor == null) {
                        return;
                    }
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        do {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow(a.h[1]));
                            String str2 = string;
                            LocalMedia localMedia = new LocalMedia(str2, (long) cursor.getInt(cursor.getColumnIndexOrThrow(a.h[5])), a.this.f28226c, cursor.getString(cursor.getColumnIndexOrThrow(a.h[2])), cursor.getInt(cursor.getColumnIndexOrThrow(a.h[3])), cursor.getInt(cursor.getColumnIndexOrThrow(a.h[4])));
                            LocalMediaFolder a2 = a.this.a(string, (List<LocalMediaFolder>) arrayList);
                            a2.c().add(localMedia);
                            a2.a(a2.b() + 1);
                            arrayList2.add(localMedia);
                            localMediaFolder.a(localMediaFolder.b() + 1);
                        } while (cursor.moveToNext());
                        if (arrayList2.size() > 0) {
                            arrayList.add(0, localMediaFolder);
                            localMediaFolder.c(((LocalMedia) arrayList2.get(0)).b());
                            if (a.this.f28226c == c.b()) {
                                str = com.garena.android.appkit.tools.b.e(c.g.feeds_picture_all_audio);
                            } else {
                                str = com.garena.android.appkit.tools.b.e(c.g.feeds_album_title_gallery);
                            }
                            localMediaFolder.a(str);
                            localMediaFolder.a((List<LocalMedia>) arrayList2);
                        }
                        bVar.a(arrayList);
                        return;
                    }
                    bVar.a(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void a(final int i2, final C0434a aVar) {
        this.f28227d.getSupportLoaderManager().a(i2, (Bundle) null, new a.C0049a<Cursor>() {
            public void a(androidx.g.b.c<Cursor> cVar) {
            }

            public androidx.g.b.c<Cursor> a(int i, Bundle bundle) {
                int i2 = i;
                if (i2 == 0) {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.b(a.this.a(0, 0), a.this.f28228e), a.i, "_id DESC");
                } else if (i2 == 1) {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.this.f28228e ? "media_type=? AND _size>0" : "media_type=? AND _size>0 AND mime_type!='image/gif'", a.b(1), "_id DESC");
                } else if (i2 == 2) {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.b(a.this.a(0, 0)), a.b(3), "_id DESC");
                } else if (i2 != 3) {
                    return null;
                } else {
                    return new androidx.g.b.b(a.this.f28227d, a.f28224b, a.h, a.b(a.this.a(0, 500)), a.b(2), "_id DESC");
                }
            }

            public void a(androidx.g.b.c<Cursor> cVar, Cursor cursor) {
                try {
                    ArrayList arrayList = new ArrayList();
                    if (cursor == null) {
                        return;
                    }
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        do {
                            arrayList.add(new LocalMedia(cursor.getString(cursor.getColumnIndexOrThrow(a.h[1])), (long) cursor.getInt(cursor.getColumnIndexOrThrow(a.h[5])), i2, cursor.getString(cursor.getColumnIndexOrThrow(a.h[2])), cursor.getInt(cursor.getColumnIndexOrThrow(a.h[3])), cursor.getInt(cursor.getColumnIndexOrThrow(a.h[4]))));
                        } while (cursor.moveToNext());
                        aVar.a(arrayList);
                        return;
                    }
                    aVar.a(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public LocalMediaFolder a(String str, List<LocalMediaFolder> list) {
        File parentFile = new File(str).getParentFile();
        for (LocalMediaFolder next : list) {
            if (next.a().equals(parentFile.getName())) {
                return next;
            }
        }
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.a(parentFile.getName());
        localMediaFolder.b(parentFile.getAbsolutePath());
        localMediaFolder.c(str);
        list.add(localMediaFolder);
        return localMediaFolder;
    }

    /* access modifiers changed from: private */
    public String a(long j, long j2) {
        long j3 = this.f28229f;
        if (j3 == 0) {
            j3 = Clock.MAX_TIME;
        }
        if (j != 0) {
            j3 = Math.min(j3, j);
        }
        Locale locale = Locale.CHINA;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Math.max(j2, this.f28230g));
        objArr[1] = Math.max(j2, this.f28230g) == 0 ? "" : SimpleComparison.EQUAL_TO_OPERATION;
        objArr[2] = Long.valueOf(j3);
        return String.format(locale, "%d <%s duration and duration <= %d", objArr);
    }
}
