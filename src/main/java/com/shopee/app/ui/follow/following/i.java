package com.shopee.app.ui.follow.following;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.j256.ormlite.field.FieldType;
import com.shopee.app.application.ar;
import com.shopee.app.d.c.a;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.aj;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.database.orm.bean.DBContactLocalInfo;
import com.shopee.app.network.c.d.b;
import com.shopee.app.network.d.b.h;
import com.shopee.app.util.as;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ContactMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

public class i extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f21646c;

    /* renamed from: d  reason: collision with root package name */
    private final aa f21647d;

    /* renamed from: e  reason: collision with root package name */
    private List<ContactMeta> f21648e;

    /* renamed from: f  reason: collision with root package name */
    private List<ContactMeta> f21649f;

    /* renamed from: g  reason: collision with root package name */
    private final be f21650g;
    private final aj h;
    private final al i;

    /* access modifiers changed from: protected */
    public String b() {
        return "readContact";
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "GetContactInteractor";
    }

    public i(n nVar, aa aaVar, be beVar, aj ajVar, al alVar) {
        super(nVar);
        this.f21646c = nVar;
        this.f21647d = aaVar;
        this.h = ajVar;
        this.f21650g = beVar;
        this.i = alVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (Build.VERSION.SDK_INT < 23) {
            if (!this.i.r()) {
                this.f16402a.a().cZ.a(new b(1, "No Contact Permission", 0)).a();
                return;
            }
        } else if (androidx.core.content.b.b(ar.a(), "android.permission.READ_CONTACTS") != 0) {
            this.f16402a.a().cZ.a(new b(1, "No Contact Permission", 0)).a();
            return;
        }
        e();
    }

    private void e() {
        String str;
        String str2;
        String str3;
        com.garena.android.appkit.d.a.e("Import Phone Contacts", new Object[0]);
        this.f21648e = new ArrayList();
        this.f21649f = new ArrayList();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String b2 = as.b(((TelephonyManager) ar.a().getSystemService("phone")).getSimCountryIso(), String.valueOf(62));
        String[] strArr = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "display_name", "has_phone_number"};
        ContentResolver contentResolver = ar.a().getContentResolver();
        try {
            Cursor query = contentResolver.query(uri, strArr, "has_phone_number='1'", (String[]) null, (String) null);
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                    String string2 = query.getString(query.getColumnIndex("display_name"));
                    if (!TextUtils.isEmpty(string2)) {
                        Cursor query2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, (String[]) null, "contact_id = " + string, (String[]) null, (String) null);
                        if (query2 != null) {
                            while (query2.moveToNext()) {
                                String string3 = query2.getString(query2.getColumnIndex("data1"));
                                if (!TextUtils.isEmpty(string3)) {
                                    String replaceAll = string3.replaceAll("[^\\d]", "");
                                    if (!string3.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                        if (!string3.startsWith("(+")) {
                                            str2 = b2 + replaceAll;
                                            if (as.b(str2) || hashMap.containsKey(str2)) {
                                                str3 = b2;
                                            } else {
                                                hashMap.put(str2, string2);
                                                DBContactLocalInfo dBContactLocalInfo = new DBContactLocalInfo();
                                                dBContactLocalInfo.a(string2);
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(str2);
                                                str3 = b2;
                                                sb.append("PHONE");
                                                dBContactLocalInfo.b(sb.toString());
                                                if (!this.h.a(dBContactLocalInfo)) {
                                                    arrayList2.add(dBContactLocalInfo);
                                                    ContactMeta.Builder builder = new ContactMeta.Builder();
                                                    builder.key(str2).name(string2);
                                                    arrayList.add(builder.build());
                                                }
                                            }
                                            b2 = str3;
                                        }
                                    }
                                    str2 = as.a(replaceAll);
                                    if (as.b(str2)) {
                                    }
                                    str3 = b2;
                                    b2 = str3;
                                }
                            }
                            str = b2;
                            query2.close();
                        } else {
                            str = b2;
                        }
                        b2 = str;
                    }
                }
                query.close();
                this.h.a((List<DBContactLocalInfo>) arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            Cursor query3 = ar.a().getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "display_name", "photo_id", "data1", "contact_id"}, "data1 NOT LIKE ''", (String[]) null, "CASE WHEN display_name NOT LIKE '%@%' THEN 1 ELSE 2 END, display_name, data1 COLLATE NOCASE");
            if (query3 != null) {
                if (query3.moveToFirst()) {
                    do {
                        String string4 = query3.getString(1);
                        if (string4 == null) {
                            string4 = "";
                        }
                        String lowerCase = query3.getString(3).toLowerCase();
                        if (lowerCase == null) {
                            lowerCase = "";
                        }
                        if (!hashMap2.containsKey(lowerCase) && as.a((CharSequence) lowerCase)) {
                            hashMap2.put(lowerCase, string4);
                            DBContactLocalInfo dBContactLocalInfo2 = new DBContactLocalInfo();
                            dBContactLocalInfo2.a(string4);
                            dBContactLocalInfo2.b(lowerCase + "EMAIL");
                            if (!this.h.a(dBContactLocalInfo2)) {
                                arrayList4.add(dBContactLocalInfo2);
                                ContactMeta.Builder builder2 = new ContactMeta.Builder();
                                builder2.key(lowerCase).name(string4);
                                arrayList3.add(builder2.build());
                            }
                        }
                    } while (query3.moveToNext());
                }
                query3.close();
                this.h.a((List<DBContactLocalInfo>) arrayList4);
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                arrayList5.add((ContactMeta) it.next());
                if (arrayList5.size() == 200) {
                    h hVar = new h();
                    hVar.a((List<ContactMeta>) arrayList5);
                    hVar.a(this.f21647d.d());
                    hVar.a(this.f21647d.e());
                    hVar.g();
                    arrayList5.clear();
                }
                i2++;
                if (i2 == arrayList.size() && arrayList5.size() != 0) {
                    h hVar2 = new h();
                    hVar2.a((List<ContactMeta>) arrayList5);
                    hVar2.a(this.f21647d.d());
                    hVar2.a(this.f21647d.e());
                    hVar2.g();
                }
            }
            ArrayList arrayList6 = new ArrayList();
            Iterator it2 = arrayList3.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                arrayList6.add((ContactMeta) it2.next());
                if (arrayList6.size() == 100) {
                    h hVar3 = new h();
                    hVar3.c(arrayList6);
                    hVar3.a(this.f21647d.d());
                    hVar3.a(this.f21647d.e());
                    hVar3.g();
                    arrayList6.clear();
                }
                i3++;
                if (i3 == arrayList3.size() && arrayList6.size() != 0) {
                    h hVar4 = new h();
                    hVar4.c(arrayList6);
                    hVar4.a(this.f21647d.d());
                    hVar4.a(this.f21647d.e());
                    hVar4.g();
                }
            }
            if (arrayList.size() == 0 && arrayList3.size() == 0) {
                this.f16402a.a().aY.a(0).a();
            }
        } catch (SQLiteException e2) {
            this.f16402a.a().cZ.a(new b(1, e2.toString(), 0)).a();
            com.garena.android.appkit.d.a.a(e2);
        } catch (SecurityException e3) {
            this.f16402a.a().cZ.a(new b(1, e3.toString(), 0)).a();
            com.garena.android.appkit.d.a.e("no contact permission", new Object[0]);
        }
    }
}
