package com.shopee.app.util.i;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import com.shopee.app.application.ar;
import com.shopee.app.util.i.a;
import d.a.d;
import d.d.a.b;
import d.d.b.j;
import d.d.b.k;
import d.h.m;
import d.p;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26371a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private NfcAdapter f26372b;

    /* renamed from: c  reason: collision with root package name */
    private Tag f26373c;

    /* renamed from: d  reason: collision with root package name */
    private a f26374d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f26375e;

    /* renamed from: f  reason: collision with root package name */
    private final Activity f26376f;

    public c(Activity activity) {
        j.b(activity, "activity");
        this.f26376f = activity;
    }

    public final d a() {
        if (this.f26372b == null) {
            this.f26372b = NfcAdapter.getDefaultAdapter(ar.f());
        }
        NfcAdapter nfcAdapter = this.f26372b;
        if (nfcAdapter == null) {
            return d.NFC_NOT_SUPPORTED;
        }
        if (nfcAdapter == null || !nfcAdapter.isEnabled()) {
            return d.NFC_SUPPORTED_BUT_OFF;
        }
        return d.NFC_SUPPORTED_AND_ON;
    }

    public final void a(a aVar) {
        j.b(aVar, "action");
        if (a() != d.NFC_SUPPORTED_AND_ON) {
            a.b d2 = aVar.d();
            if (d2 != null) {
                d2.onError("", aVar.c(), new IllegalAccessException("NFC is not ready yet"));
                return;
            }
            return;
        }
        synchronized (Boolean.valueOf(this.f26375e)) {
            if (this.f26373c != null) {
                Tag tag = this.f26373c;
                if (tag == null) {
                    j.a();
                }
                a(aVar, tag);
                return;
            }
            this.f26374d = aVar;
            c();
            p pVar = p.f32714a;
        }
    }

    public final void b() {
        NfcAdapter nfcAdapter = this.f26372b;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this.f26376f);
        }
        synchronized (Boolean.valueOf(this.f26375e)) {
            this.f26373c = null;
            p pVar = p.f32714a;
        }
    }

    public final void a(Intent intent) {
        j.b(intent, "intent");
        synchronized (Boolean.valueOf(this.f26375e)) {
            this.f26373c = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (!(this.f26373c == null || this.f26374d == null)) {
                a aVar = this.f26374d;
                if (aVar == null) {
                    j.a();
                }
                Tag tag = this.f26373c;
                if (tag == null) {
                    j.a();
                }
                a(aVar, tag);
                this.f26374d = null;
            }
            p pVar = p.f32714a;
        }
    }

    private final void c() {
        a aVar = this.f26374d;
        if (aVar == null) {
            j.a();
        }
        IntentFilter intentFilter = new IntentFilter(aVar.a().getFilterName());
        try {
            intentFilter.addDataType("*/*");
            IntentFilter[] intentFilterArr = {intentFilter};
            String[][] strArr = new String[1][];
            a aVar2 = this.f26374d;
            if (aVar2 == null) {
                j.a();
            }
            strArr[0] = aVar2.b().a();
            String[][] strArr2 = strArr;
            Activity activity = this.f26376f;
            PendingIntent activity2 = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()).addFlags(536870912), 0);
            NfcAdapter nfcAdapter = this.f26372b;
            if (nfcAdapter == null) {
                j.a();
            }
            nfcAdapter.enableForegroundDispatch(this.f26376f, activity2, intentFilterArr, strArr2);
        } catch (IntentFilter.MalformedMimeTypeException e2) {
            com.garena.b.a.a.b("IntentFilter.MalformedMimeTypeException", (Throwable) e2);
        }
    }

    private final void a(a aVar, Tag tag) {
        e b2 = aVar.b();
        String c2 = aVar.c();
        a.b d2 = aVar.d();
        String str = "";
        if (d2 != null) {
            try {
                str = f26371a.a(tag.getId());
                d2.onResponse(str, c2, f26371a.a(b2.a(f26371a.a(c2), tag)));
            } catch (Exception e2) {
                d2.onError(str, c2, e2);
                this.f26373c = null;
            }
        }
    }

    public static final class a {

        /* renamed from: com.shopee.app.util.i.c$a$a  reason: collision with other inner class name */
        static final class C0404a extends k implements b<Byte, String> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0404a f26377a = new C0404a();

            C0404a() {
                super(1);
            }

            public /* synthetic */ Object a(Object obj) {
                return a(((Number) obj).byteValue());
            }

            public final String a(byte b2) {
                String num = Integer.toString(b2 & 255, d.h.a.a(16));
                j.a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                return m.a(num, 2, '0');
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final byte[] a(String str) throws IllegalStateException {
            j.b(str, "hexString");
            String upperCase = str.toUpperCase();
            j.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            if (!new d.h.k("[0-9,A-F]+").a(upperCase) || str.length() % 2 != 0) {
                throw new IllegalStateException("Wrong HEX string format: " + this);
            }
            byte[] bArr = new byte[(str.length() / 2)];
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                String substring = str.substring(i2, i2 + 2);
                j.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                bArr[i] = (byte) Integer.parseInt(substring, d.h.a.a(16));
            }
            return bArr;
        }

        public final String a(byte[] bArr) {
            if (bArr == null) {
                return "";
            }
            if (bArr.length == 0) {
                return "";
            }
            String a2 = d.a(bArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C0404a.f26377a, 30, (Object) null);
            if (a2 != null) {
                String upperCase = a2.toUpperCase();
                j.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                return upperCase;
            }
            throw new d.m("null cannot be cast to non-null type java.lang.String");
        }
    }
}
