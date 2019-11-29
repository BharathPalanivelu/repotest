package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import com.shopee.app.h.l;
import com.shopee.app.h.r;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.PickImageMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class ar extends a {

    /* renamed from: c  reason: collision with root package name */
    private List<String> f16502c;

    /* renamed from: d  reason: collision with root package name */
    private PickImageMessage f16503d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetImageDataInteracter";
    }

    public ar(n nVar) {
        super(nVar);
    }

    public void a(List<String> list, PickImageMessage pickImageMessage) {
        this.f16502c = list;
        this.f16503d = pickImageMessage;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        Iterator<String> it;
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] strArr = new String[this.f16502c.size()];
        String[] strArr2 = new String[this.f16502c.size()];
        Iterator<String> it2 = this.f16502c.iterator();
        String str = null;
        String str2 = null;
        int i5 = 0;
        while (it2.hasNext()) {
            Uri parse = Uri.parse(it2.next());
            PickImageMessage pickImageMessage = this.f16503d;
            int i6 = 200;
            int i7 = 640;
            if (pickImageMessage != null) {
                if (pickImageMessage.getWidth() <= 0 || this.f16503d.getHeight() <= 0) {
                    i4 = 640;
                } else {
                    i7 = this.f16503d.getWidth();
                    i4 = this.f16503d.getHeight();
                }
                i2 = this.f16503d.getQuality() > 0 ? this.f16503d.getQuality() : 80;
                if (this.f16503d.getTnWidth() <= 0 || this.f16503d.getTnHeight() <= 0) {
                    i = 200;
                } else {
                    i6 = this.f16503d.getTnWidth();
                    i = this.f16503d.getTnHeight();
                }
                if (this.f16503d.getTnQuality() > 0) {
                    i3 = this.f16503d.getTnQuality();
                    it = it2;
                } else {
                    it = it2;
                    i3 = 80;
                }
            } else {
                it = it2;
                i4 = 640;
                i3 = 80;
                i2 = 80;
                i = 200;
            }
            Bitmap a2 = l.a().a(parse, i7, i4);
            if (a2 == null) {
                r.a().b((int) R.string.sp_unable_to_load_image);
                return;
            }
            byte[] a3 = l.a().a(a2, i2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("data:image/jpeg;base64,");
            stringBuffer.append(Base64.encodeToString(a3, 2));
            String stringBuffer2 = stringBuffer.toString();
            byte[] a4 = l.a().a(l.b(a2, i6, i), i3);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("data:image/jpeg;base64,");
            stringBuffer3.append(Base64.encodeToString(a4, 2));
            String stringBuffer4 = stringBuffer3.toString();
            if (!a2.isRecycled()) {
                a2.recycle();
            }
            if (i5 == 0) {
                str = stringBuffer2;
                str2 = stringBuffer4;
            }
            strArr[i5] = stringBuffer2;
            strArr2[i5] = stringBuffer4;
            arrayList.add(stringBuffer2);
            arrayList2.add(stringBuffer4);
            i5++;
            it2 = it;
        }
        this.f16402a.a("PICK_IMAGE_DATA", new com.garena.android.appkit.b.a(new a(str, str2, new JSONArray(arrayList), new JSONArray(arrayList2))));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f16504a;

        /* renamed from: b  reason: collision with root package name */
        public final String f16505b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONArray f16506c;

        /* renamed from: d  reason: collision with root package name */
        public final JSONArray f16507d;

        public a(String str, String str2, JSONArray jSONArray, JSONArray jSONArray2) {
            this.f16504a = str;
            this.f16505b = str2;
            this.f16506c = jSONArray2;
            this.f16507d = jSONArray;
        }
    }
}
