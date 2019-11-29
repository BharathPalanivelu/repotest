package com.google.android.libraries.places.internal;

import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.libraries.places.internal.it;
import com.google.android.libraries.places.internal.iy;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.tencent.imsdk.TIMGroupManager;

public class ge {

    /* renamed from: a  reason: collision with root package name */
    public final ClearcutLogger f12616a;

    /* renamed from: b  reason: collision with root package name */
    public final dw f12617b;

    public void a(gc gcVar) {
        MessageType messagetype;
        MessageType messagetype2;
        it.b bVar = (it.b) it.p.f();
        boolean z = gcVar.f12612d;
        bVar.b();
        it itVar = (it) bVar.f12904a;
        itVar.f12756a |= 4;
        itVar.f12759d = z;
        boolean z2 = gcVar.f12613e;
        bVar.b();
        it itVar2 = (it) bVar.f12904a;
        itVar2.f12756a |= 8;
        itVar2.f12760e = z2;
        boolean z3 = gcVar.f12614f;
        bVar.b();
        it itVar3 = (it) bVar.f12904a;
        itVar3.f12756a |= 16;
        itVar3.f12761f = z3;
        int i = gcVar.f12615g;
        bVar.b();
        it itVar4 = (it) bVar.f12904a;
        itVar4.f12756a |= 32;
        itVar4.f12762g = i;
        int i2 = gcVar.h;
        bVar.b();
        it itVar5 = (it) bVar.f12904a;
        itVar5.f12756a |= 64;
        itVar5.h = i2;
        int i3 = gcVar.i;
        bVar.b();
        it itVar6 = (it) bVar.f12904a;
        itVar6.f12756a |= 128;
        itVar6.i = i3;
        int i4 = gcVar.j;
        bVar.b();
        it itVar7 = (it) bVar.f12904a;
        itVar7.f12756a |= 256;
        itVar7.j = i4;
        int length = gcVar.k.length();
        bVar.b();
        it itVar8 = (it) bVar.f12904a;
        itVar8.f12756a |= 512;
        itVar8.k = length;
        int i5 = gcVar.l;
        bVar.b();
        it itVar9 = (it) bVar.f12904a;
        itVar9.f12756a |= 1024;
        itVar9.l = i5;
        int i6 = gcVar.m;
        bVar.b();
        it itVar10 = (it) bVar.f12904a;
        itVar10.f12756a |= 2048;
        itVar10.m = i6;
        boolean z4 = gcVar.n;
        bVar.b();
        it itVar11 = (it) bVar.f12904a;
        itVar11.f12756a |= 4096;
        itVar11.n = z4;
        int i7 = gcVar.o;
        bVar.b();
        it itVar12 = (it) bVar.f12904a;
        itVar12.f12756a |= 8192;
        itVar12.o = i7;
        if (gcVar.f12609a == ee.FRAGMENT) {
            bVar.a(it.c.ANDROID_AUTOCOMPLETE_FRAGMENT);
        } else if (gcVar.f12609a == ee.INTENT) {
            bVar.a(it.c.ANDROID_AUTOCOMPLETE_MANUAL_LAUNCHER);
        } else {
            bVar.a(it.c.UNKNOWN_ORIGIN);
        }
        if (gcVar.f12610b == AutocompleteActivityMode.FULLSCREEN) {
            bVar.a(it.a.FULLSCREEN);
        } else if (gcVar.f12610b == AutocompleteActivityMode.OVERLAY) {
            bVar.a(it.a.OVERLAY);
        }
        if (bVar.f12905b) {
            messagetype = bVar.f12904a;
        } else {
            bVar.f12904a.e();
            bVar.f12905b = true;
            messagetype = bVar.f12904a;
        }
        kv kvVar = (kv) messagetype;
        if (kvVar.g()) {
            it itVar13 = (it) kvVar;
            iy.a a2 = dv.a(this.f12617b).a(iy.b.AUTOCOMPLETE_WIDGET_SESSION);
            a2.b();
            iy iyVar = (iy) a2.f12904a;
            if (itVar13 != null) {
                iyVar.i = itVar13;
                iyVar.f12776a |= TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE;
                if (a2.f12905b) {
                    messagetype2 = a2.f12904a;
                } else {
                    a2.f12904a.e();
                    a2.f12905b = true;
                    messagetype2 = a2.f12904a;
                }
                kv kvVar2 = (kv) messagetype2;
                if (kvVar2.g()) {
                    a((iy) kvVar2);
                    return;
                }
                throw new ne();
            }
            throw new NullPointerException();
        }
        throw new ne();
    }

    public ge(ClearcutLogger clearcutLogger, dw dwVar) {
        this.f12616a = clearcutLogger;
        this.f12617b = dwVar;
    }

    public void a(iy iyVar) {
        this.f12616a.newEvent(dv.a(iyVar).c()).log();
    }
}
