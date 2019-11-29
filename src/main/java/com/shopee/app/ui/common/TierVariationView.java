package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.Variant;
import com.shopee.id.R;
import com.shopee.protocol.shop.TierVariation;
import d.d.b.j;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class TierVariationView extends RecyclerView {
    /* access modifiers changed from: private */
    public final ArrayList<TierVariation> M = new ArrayList<>();
    private final c N = new c();
    /* access modifiers changed from: private */
    public final SparseArray<ArrayList<a>> O = new SparseArray<>();
    /* access modifiers changed from: private */
    public AddCartMessage P;
    /* access modifiers changed from: private */
    public u Q;
    /* access modifiers changed from: private */
    public Variant R;
    /* access modifiers changed from: private */
    public VMOffer S;
    /* access modifiers changed from: private */
    public List<? extends Variant> T;
    /* access modifiers changed from: private */
    public al U;
    /* access modifiers changed from: private */
    public com.shopee.app.util.o.a V = new com.shopee.app.util.o.a(false, 1, (g) null);
    private final View.OnClickListener W;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TierVariationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.b(context, "context");
        setLayoutManager(new LinearLayoutManager(context));
        setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
        setAdapter(this.N);
        this.W = new d(this);
    }

    public final Variant getSelectedVariant() {
        return this.R;
    }

    public final void setOnVariantSelectedCallback(u uVar) {
        j.b(uVar, "onVariantSelected");
        this.Q = uVar;
    }

    public final void setData(AddCartMessage addCartMessage) {
        j.b(addCartMessage, "data");
        a(addCartMessage, (al) null);
    }

    public final void a(AddCartMessage addCartMessage, al alVar) {
        j.b(addCartMessage, "data");
        a(addCartMessage, (VMOffer) null, (Variant) null, alVar);
    }

    public final void a(AddCartMessage addCartMessage, VMOffer vMOffer, Variant variant, al alVar) {
        List<? extends Variant> list;
        j.b(addCartMessage, "data");
        this.P = addCartMessage;
        this.R = variant;
        this.S = vMOffer;
        AddCartMessage addCartMessage2 = this.P;
        if (addCartMessage2 != null) {
            List<Variant> list2 = addCartMessage2.variations;
            if (list2 != null) {
                Collection arrayList = new ArrayList();
                for (Object next : list2) {
                    if (((Variant) next).modelPrice > 0) {
                        arrayList.add(next);
                    }
                }
                list = (List) arrayList;
                this.T = list;
                this.U = alVar;
                this.V = new com.shopee.app.util.o.a(addCartMessage.isOfficialShop());
                this.M.clear();
                this.M.addAll(addCartMessage.getTierVariations());
                this.N.notifyDataSetChanged();
                post(new e(this));
            }
        }
        list = null;
        this.T = list;
        this.U = alVar;
        this.V = new com.shopee.app.util.o.a(addCartMessage.isOfficialShop());
        this.M.clear();
        this.M.addAll(addCartMessage.getTierVariations());
        this.N.notifyDataSetChanged();
        post(new e(this));
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TierVariationView f21046a;

        e(TierVariationView tierVariationView) {
            this.f21046a = tierVariationView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r9 = this;
                com.shopee.app.ui.common.TierVariationView r0 = r9.f21046a
                com.shopee.app.web.protocol.Variant r0 = r0.R
                r1 = 1
                if (r0 != 0) goto L_0x0028
                com.shopee.app.ui.common.TierVariationView r0 = r9.f21046a
                java.util.List r0 = r0.T
                if (r0 == 0) goto L_0x0028
                int r0 = r0.size()
                if (r0 != r1) goto L_0x0028
                com.shopee.app.ui.common.TierVariationView r0 = r9.f21046a
                java.util.List r0 = r0.T
                if (r0 == 0) goto L_0x0026
                java.lang.Object r0 = d.a.j.c(r0)
                com.shopee.app.web.protocol.Variant r0 = (com.shopee.app.web.protocol.Variant) r0
                goto L_0x002e
            L_0x0026:
                r0 = 0
                goto L_0x002e
            L_0x0028:
                com.shopee.app.ui.common.TierVariationView r0 = r9.f21046a
                com.shopee.app.web.protocol.Variant r0 = r0.R
            L_0x002e:
                if (r0 == 0) goto L_0x0086
                com.shopee.app.ui.common.TierVariationView r2 = r9.f21046a
                android.util.SparseArray r2 = r2.O
                int r3 = r2.size()
                r4 = 0
                int r5 = r3 + -1
                if (r5 < 0) goto L_0x0076
            L_0x003f:
                int r6 = r2.size()
                if (r3 != r6) goto L_0x006e
                int r6 = r2.keyAt(r4)
                java.lang.Object r7 = r2.valueAt(r4)
                java.util.ArrayList r7 = (java.util.ArrayList) r7
                java.util.List<java.lang.Integer> r8 = r0.tierIndexes
                java.lang.Object r6 = r8.get(r6)
                java.lang.Integer r6 = (java.lang.Integer) r6
                java.lang.String r8 = "selected"
                d.d.b.j.a((java.lang.Object) r6, (java.lang.String) r8)
                int r6 = r6.intValue()
                java.lang.Object r6 = r7.get(r6)
                com.shopee.app.ui.common.TierVariationView$a r6 = (com.shopee.app.ui.common.TierVariationView.a) r6
                r6.setActive(r1)
                if (r4 == r5) goto L_0x0076
                int r4 = r4 + 1
                goto L_0x003f
            L_0x006e:
                java.util.ConcurrentModificationException r0 = new java.util.ConcurrentModificationException
                r0.<init>()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x0076:
                com.shopee.app.ui.common.TierVariationView r1 = r9.f21046a
                r1.R = r0
                com.shopee.app.ui.common.TierVariationView r1 = r9.f21046a
                com.shopee.app.ui.common.u r1 = r1.Q
                if (r1 == 0) goto L_0x0086
                r1.a(r0)
            L_0x0086:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.common.TierVariationView.e.run():void");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TierVariationView f21045a;

        d(TierVariationView tierVariationView) {
            this.f21045a = tierVariationView;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.shopee.app.web.protocol.Variant} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r15) {
            /*
                r14 = this;
                boolean r0 = r15 instanceof com.shopee.app.ui.common.TierVariationView.a
                if (r0 == 0) goto L_0x0228
                com.shopee.app.ui.common.TierVariationView$a r15 = (com.shopee.app.ui.common.TierVariationView.a) r15
                boolean r0 = r15.getMAllowed()
                if (r0 != 0) goto L_0x000d
                return
            L_0x000d:
                boolean r0 = r15.getMActive()
                r1 = 0
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L_0x0094
                r15.setActive(r2)
                com.shopee.app.ui.common.TierVariationView r0 = r14.f21045a
                android.util.SparseArray r0 = r0.O
                int r4 = r0.size()
                int r5 = r4 + -1
                if (r5 < 0) goto L_0x0080
                r6 = 0
            L_0x0028:
                int r7 = r0.size()
                if (r4 != r7) goto L_0x0078
                int r7 = r0.keyAt(r6)
                java.lang.Object r8 = r0.valueAt(r6)
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                int r9 = r15.getTierIndex()
                if (r7 == r9) goto L_0x0073
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Iterator r7 = r8.iterator()
            L_0x0044:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x0073
                java.lang.Object r8 = r7.next()
                com.shopee.app.ui.common.TierVariationView$a r8 = (com.shopee.app.ui.common.TierVariationView.a) r8
                boolean r9 = r8.getMActive()
                if (r9 != 0) goto L_0x0044
                boolean r9 = r8.getMAllowed()
                if (r9 != 0) goto L_0x0044
                com.shopee.app.ui.common.TierVariationView r9 = r14.f21045a
                int r10 = r8.getTierIndex()
                int r11 = r8.getOptionIndex()
                int r9 = r9.k(r10, r11)
                if (r9 <= 0) goto L_0x006e
                r9 = 1
                goto L_0x006f
            L_0x006e:
                r9 = 0
            L_0x006f:
                r8.setAllowed(r9)
                goto L_0x0044
            L_0x0073:
                if (r6 == r5) goto L_0x0080
                int r6 = r6 + 1
                goto L_0x0028
            L_0x0078:
                java.util.ConcurrentModificationException r15 = new java.util.ConcurrentModificationException
                r15.<init>()
                java.lang.Throwable r15 = (java.lang.Throwable) r15
                throw r15
            L_0x0080:
                com.shopee.app.ui.common.TierVariationView r15 = r14.f21045a
                com.shopee.app.web.protocol.Variant r1 = (com.shopee.app.web.protocol.Variant) r1
                r15.R = r1
                com.shopee.app.ui.common.TierVariationView r15 = r14.f21045a
                com.shopee.app.ui.common.u r15 = r15.Q
                if (r15 == 0) goto L_0x0228
                r15.a()
                goto L_0x0228
            L_0x0094:
                int r0 = r15.getTierIndex()
                int r15 = r15.getOptionIndex()
                com.shopee.app.ui.common.TierVariationView r4 = r14.f21045a
                android.util.SparseArray r4 = r4.O
                int r5 = r4.size()
                int r6 = r5 + -1
                if (r6 < 0) goto L_0x0166
                r7 = 0
            L_0x00ab:
                int r8 = r4.size()
                if (r5 != r8) goto L_0x015e
                int r8 = r4.keyAt(r7)
                java.lang.Object r9 = r4.valueAt(r7)
                java.util.ArrayList r9 = (java.util.ArrayList) r9
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.Iterator r10 = r9.iterator()
            L_0x00c1:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x00d5
                java.lang.Object r11 = r10.next()
                r12 = r11
                com.shopee.app.ui.common.TierVariationView$a r12 = (com.shopee.app.ui.common.TierVariationView.a) r12
                boolean r12 = r12.getMActive()
                if (r12 == 0) goto L_0x00c1
                goto L_0x00d6
            L_0x00d5:
                r11 = r1
            L_0x00d6:
                com.shopee.app.ui.common.TierVariationView$a r11 = (com.shopee.app.ui.common.TierVariationView.a) r11
                com.shopee.app.ui.common.TierVariationView r10 = r14.f21045a
                if (r11 == 0) goto L_0x00e5
                int r12 = r11.getOptionIndex()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                goto L_0x00e6
            L_0x00e5:
                r12 = r1
            L_0x00e6:
                com.shopee.app.web.protocol.Variant r10 = r10.a(r0, r15, r12)
                if (r8 != r0) goto L_0x010f
                java.util.Iterator r8 = r9.iterator()
            L_0x00f0:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L_0x0158
                java.lang.Object r9 = r8.next()
                com.shopee.app.ui.common.TierVariationView$a r9 = (com.shopee.app.ui.common.TierVariationView.a) r9
                boolean r10 = r9.getMAllowed()
                if (r10 == 0) goto L_0x00f0
                int r10 = r9.getOptionIndex()
                if (r15 != r10) goto L_0x010a
                r10 = 1
                goto L_0x010b
            L_0x010a:
                r10 = 0
            L_0x010b:
                r9.setActive(r10)
                goto L_0x00f0
            L_0x010f:
                java.util.Iterator r8 = r9.iterator()
            L_0x0113:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L_0x0158
                java.lang.Object r9 = r8.next()
                com.shopee.app.ui.common.TierVariationView$a r9 = (com.shopee.app.ui.common.TierVariationView.a) r9
                com.shopee.app.ui.common.TierVariationView r12 = r14.f21045a
                int r13 = r9.getOptionIndex()
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                com.shopee.app.web.protocol.Variant r12 = r12.a(r0, r15, r13)
                if (r12 == 0) goto L_0x0135
                int r12 = r12.modelStock
                if (r12 <= 0) goto L_0x0135
                r12 = 1
                goto L_0x0136
            L_0x0135:
                r12 = 0
            L_0x0136:
                if (r10 == 0) goto L_0x013c
                int r13 = r10.modelStock
                if (r13 > 0) goto L_0x013f
            L_0x013c:
                r9.setActive(r2)
            L_0x013f:
                if (r10 != 0) goto L_0x0145
                r9.setAllowed(r12)
                goto L_0x0113
            L_0x0145:
                int r13 = r10.modelStock
                if (r13 > 0) goto L_0x014d
                r9.setAllowed(r12)
                goto L_0x0113
            L_0x014d:
                boolean r13 = d.d.b.j.a((java.lang.Object) r9, (java.lang.Object) r11)
                r13 = r13 ^ r3
                if (r13 == 0) goto L_0x0113
                r9.setAllowed(r12)
                goto L_0x0113
            L_0x0158:
                if (r7 == r6) goto L_0x0166
                int r7 = r7 + 1
                goto L_0x00ab
            L_0x015e:
                java.util.ConcurrentModificationException r15 = new java.util.ConcurrentModificationException
                r15.<init>()
                java.lang.Throwable r15 = (java.lang.Throwable) r15
                throw r15
            L_0x0166:
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                com.shopee.app.ui.common.TierVariationView r0 = r14.f21045a
                android.util.SparseArray r0 = r0.O
                int r3 = r0.size()
                int r4 = r3 + -1
                if (r4 < 0) goto L_0x01bf
            L_0x0179:
                int r5 = r0.size()
                if (r3 != r5) goto L_0x01b7
                r0.keyAt(r2)
                java.lang.Object r5 = r0.valueAt(r2)
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.Iterator r5 = r5.iterator()
            L_0x018e:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x01a2
                java.lang.Object r6 = r5.next()
                r7 = r6
                com.shopee.app.ui.common.TierVariationView$a r7 = (com.shopee.app.ui.common.TierVariationView.a) r7
                boolean r7 = r7.getMActive()
                if (r7 == 0) goto L_0x018e
                goto L_0x01a3
            L_0x01a2:
                r6 = r1
            L_0x01a3:
                com.shopee.app.ui.common.TierVariationView$a r6 = (com.shopee.app.ui.common.TierVariationView.a) r6
                if (r6 == 0) goto L_0x01b2
                int r5 = r6.getOptionIndex()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r15.add(r5)
            L_0x01b2:
                if (r2 == r4) goto L_0x01bf
                int r2 = r2 + 1
                goto L_0x0179
            L_0x01b7:
                java.util.ConcurrentModificationException r15 = new java.util.ConcurrentModificationException
                r15.<init>()
                java.lang.Throwable r15 = (java.lang.Throwable) r15
                throw r15
            L_0x01bf:
                com.shopee.app.ui.common.TierVariationView r0 = r14.f21045a
                java.util.List r0 = r0.T
                if (r0 == 0) goto L_0x01e5
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.Iterator r0 = r0.iterator()
            L_0x01cd:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x01e3
                java.lang.Object r2 = r0.next()
                r3 = r2
                com.shopee.app.web.protocol.Variant r3 = (com.shopee.app.web.protocol.Variant) r3
                java.util.List<java.lang.Integer> r3 = r3.tierIndexes
                boolean r3 = d.d.b.j.a((java.lang.Object) r3, (java.lang.Object) r15)
                if (r3 == 0) goto L_0x01cd
                r1 = r2
            L_0x01e3:
                com.shopee.app.web.protocol.Variant r1 = (com.shopee.app.web.protocol.Variant) r1
            L_0x01e5:
                if (r1 != 0) goto L_0x01f3
                com.shopee.app.ui.common.TierVariationView r15 = r14.f21045a
                com.shopee.app.ui.common.u r15 = r15.Q
                if (r15 == 0) goto L_0x0228
                r15.a()
                goto L_0x0228
            L_0x01f3:
                com.shopee.app.ui.common.TierVariationView r15 = r14.f21045a
                com.shopee.app.data.viewmodel.chatP2P.VMOffer r0 = r15.S
                if (r0 == 0) goto L_0x020f
                long r2 = r0.getModelid()
                long r4 = r1.modelID
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x020f
                com.shopee.app.ui.common.TierVariationView r0 = r14.f21045a
                com.shopee.app.data.viewmodel.chatP2P.VMOffer r0 = r0.S
                com.shopee.app.web.protocol.Variant r1 = r1.newFromVMOffer(r0)
            L_0x020f:
                r15.R = r1
                com.shopee.app.ui.common.TierVariationView r15 = r14.f21045a
                com.shopee.app.ui.common.u r15 = r15.Q
                if (r15 == 0) goto L_0x0228
                com.shopee.app.ui.common.TierVariationView r0 = r14.f21045a
                com.shopee.app.web.protocol.Variant r0 = r0.R
                if (r0 != 0) goto L_0x0225
                d.d.b.j.a()
            L_0x0225:
                r15.a(r0)
            L_0x0228:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.common.TierVariationView.d.onClick(android.view.View):void");
        }
    }

    public final View.OnClickListener getOnClick() {
        return this.W;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.shopee.app.web.protocol.Variant} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.shopee.app.web.protocol.Variant a(int r9, int r10, java.lang.Integer r11) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            r2 = 2
            r3 = 0
            if (r9 == 0) goto L_0x0037
            java.util.List<? extends com.shopee.app.web.protocol.Variant> r9 = r8.T
            if (r9 == 0) goto L_0x0067
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0010:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r9.next()
            r5 = r4
            com.shopee.app.web.protocol.Variant r5 = (com.shopee.app.web.protocol.Variant) r5
            java.util.List<java.lang.Integer> r5 = r5.tierIndexes
            java.lang.Integer[] r6 = new java.lang.Integer[r2]
            r6[r1] = r11
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r6[r0] = r7
            java.util.List r6 = java.util.Arrays.asList(r6)
            boolean r5 = d.d.b.j.a((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0010
            r3 = r4
        L_0x0034:
            com.shopee.app.web.protocol.Variant r3 = (com.shopee.app.web.protocol.Variant) r3
            goto L_0x0067
        L_0x0037:
            java.util.List<? extends com.shopee.app.web.protocol.Variant> r9 = r8.T
            if (r9 == 0) goto L_0x0067
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0041:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0065
            java.lang.Object r4 = r9.next()
            r5 = r4
            com.shopee.app.web.protocol.Variant r5 = (com.shopee.app.web.protocol.Variant) r5
            java.util.List<java.lang.Integer> r5 = r5.tierIndexes
            java.lang.Integer[] r6 = new java.lang.Integer[r2]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r6[r1] = r7
            r6[r0] = r11
            java.util.List r6 = java.util.Arrays.asList(r6)
            boolean r5 = d.d.b.j.a((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0041
            r3 = r4
        L_0x0065:
            com.shopee.app.web.protocol.Variant r3 = (com.shopee.app.web.protocol.Variant) r3
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.common.TierVariationView.a(int, int, java.lang.Integer):com.shopee.app.web.protocol.Variant");
    }

    public final int k(int i, int i2) {
        List<? extends Variant> list = this.T;
        int i3 = 0;
        if (list != null) {
            for (Variant variant : list) {
                Integer num = variant.tierIndexes.get(i);
                if (num != null && num.intValue() == i2) {
                    i3 += variant.modelStock;
                }
            }
        }
        return i3;
    }

    public final class b extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TierVariationView f21035a;

        /* renamed from: b  reason: collision with root package name */
        private int f21036b;

        /* renamed from: c  reason: collision with root package name */
        private final View f21037c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f21038d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f21039e;

        /* renamed from: f  reason: collision with root package name */
        private final GTagCloud f21040f;

        /* renamed from: g  reason: collision with root package name */
        private final ArrayList<String> f21041g;
        private final GTagCloud.a h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TierVariationView tierVariationView, View view) {
            super(view);
            j.b(view, "itemView");
            this.f21035a = tierVariationView;
            View findViewById = view.findViewById(R.id.variationDivider);
            if (findViewById != null) {
                this.f21037c = findViewById;
                View findViewById2 = view.findViewById(R.id.variationTitle);
                if (findViewById2 != null) {
                    this.f21038d = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.textSizeChart);
                    if (findViewById3 != null) {
                        this.f21039e = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.variationGrid);
                        if (findViewById4 != null) {
                            this.f21040f = (GTagCloud) findViewById4;
                            this.f21041g = new ArrayList<>();
                            this.h = new a(this);
                            this.f21040f.setChildPadding(b.a.f7696g);
                            this.f21040f.setLineMargin(b.a.f7696g);
                            this.f21040f.setAdapter(this.h);
                            TextView textView = this.f21039e;
                            textView.setPaintFlags(textView.getPaintFlags() | 8);
                            return;
                        }
                        throw new m("null cannot be cast to non-null type com.garena.android.uikit.fluid.tagcloud.GTagCloud");
                    }
                    throw new m("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new m("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new m("null cannot be cast to non-null type android.view.View");
        }

        public final int a() {
            return this.f21036b;
        }

        public static final class a implements GTagCloud.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f21042a;

            a(b bVar) {
                this.f21042a = bVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.shopee.app.ui.common.TierVariationView$a} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.view.View a(android.content.Context r3, int r4) {
                /*
                    r2 = this;
                    com.shopee.app.ui.common.TierVariationView$b r0 = r2.f21042a
                    com.shopee.app.ui.common.TierVariationView r0 = r0.f21035a
                    android.util.SparseArray r0 = r0.O
                    com.shopee.app.ui.common.TierVariationView$b r1 = r2.f21042a
                    int r1 = r1.a()
                    java.lang.Object r0 = r0.get(r1)
                    java.util.ArrayList r0 = (java.util.ArrayList) r0
                    r1 = 0
                    if (r0 == 0) goto L_0x0020
                    int r0 = r0.size()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    goto L_0x0021
                L_0x0020:
                    r0 = r1
                L_0x0021:
                    if (r0 != 0) goto L_0x0026
                    d.d.b.j.a()
                L_0x0026:
                    int r0 = r0.intValue()
                    if (r0 <= r4) goto L_0x004c
                    com.shopee.app.ui.common.TierVariationView$b r3 = r2.f21042a
                    com.shopee.app.ui.common.TierVariationView r3 = r3.f21035a
                    android.util.SparseArray r3 = r3.O
                    com.shopee.app.ui.common.TierVariationView$b r0 = r2.f21042a
                    int r0 = r0.a()
                    java.lang.Object r3 = r3.get(r0)
                    java.util.ArrayList r3 = (java.util.ArrayList) r3
                    if (r3 == 0) goto L_0x0049
                    java.lang.Object r3 = r3.get(r4)
                    r1 = r3
                    com.shopee.app.ui.common.TierVariationView$a r1 = (com.shopee.app.ui.common.TierVariationView.a) r1
                L_0x0049:
                    android.view.View r1 = (android.view.View) r1
                    goto L_0x00b7
                L_0x004c:
                    com.shopee.app.ui.common.TierVariationView$a r0 = new com.shopee.app.ui.common.TierVariationView$a
                    com.shopee.app.ui.common.TierVariationView$b r1 = r2.f21042a
                    int r1 = r1.a()
                    r0.<init>(r3, r1, r4)
                    com.shopee.app.ui.common.TierVariationView$b r3 = r2.f21042a
                    com.shopee.app.ui.common.TierVariationView r3 = r3.f21035a
                    com.shopee.app.ui.common.TierVariationView$b r1 = r2.f21042a
                    int r1 = r1.a()
                    int r3 = r3.k(r1, r4)
                    if (r3 <= 0) goto L_0x0069
                    r3 = 1
                    goto L_0x006a
                L_0x0069:
                    r3 = 0
                L_0x006a:
                    r0.setAllowed(r3)
                    com.shopee.app.ui.common.TierVariationView$b r3 = r2.f21042a
                    java.util.ArrayList r3 = r3.b()
                    java.lang.Object r3 = r3.get(r4)
                    java.lang.String r1 = "options[optionIndex]"
                    d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r1)
                    java.lang.String r3 = (java.lang.String) r3
                    r0.setOption(r3)
                    com.shopee.app.ui.common.TierVariationView$b r3 = r2.f21042a
                    com.shopee.app.ui.common.TierVariationView r3 = r3.f21035a
                    android.util.SparseArray r3 = r3.O
                    com.shopee.app.ui.common.TierVariationView$b r1 = r2.f21042a
                    int r1 = r1.a()
                    java.lang.Object r3 = r3.get(r1)
                    java.util.ArrayList r3 = (java.util.ArrayList) r3
                    if (r3 == 0) goto L_0x009a
                    r3.add(r4, r0)
                L_0x009a:
                    com.shopee.app.ui.common.TierVariationView$b r3 = r2.f21042a
                    com.shopee.app.ui.common.TierVariationView r3 = r3.f21035a
                    android.view.View$OnClickListener r3 = r3.getOnClick()
                    r0.setOnClickListener(r3)
                    com.shopee.app.ui.common.TierVariationView$b r3 = r2.f21042a
                    com.shopee.app.ui.common.TierVariationView r3 = r3.f21035a
                    com.shopee.app.util.o.a r3 = r3.V
                    int r3 = r3.b()
                    r0.setActiveBgRes(r3)
                    r1 = r0
                    android.view.View r1 = (android.view.View) r1
                L_0x00b7:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.common.TierVariationView.b.a.a(android.content.Context, int):android.view.View");
            }

            public int a() {
                return this.f21042a.b().size();
            }
        }

        public final ArrayList<String> b() {
            return this.f21041g;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
            if (r2 != null) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.shopee.protocol.shop.TierVariation r5, int r6) {
            /*
                r4 = this;
                java.lang.String r0 = "tierVariation"
                d.d.b.j.b(r5, r0)
                com.shopee.app.ui.common.TierVariationView r0 = r4.f21035a
                com.shopee.app.ui.common.al r0 = r0.U
                r1 = 0
                if (r0 == 0) goto L_0x003f
                com.shopee.app.ui.common.TierVariationView r2 = r4.f21035a
                com.shopee.app.web.protocol.AddCartMessage r2 = r2.P
                if (r2 == 0) goto L_0x001d
                java.lang.String r2 = r2.getSizeChartImage()
                if (r2 == 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                java.lang.String r2 = ""
            L_0x001f:
                if (r6 != 0) goto L_0x002b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x002b
                r2 = 1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                android.widget.TextView r3 = r4.f21039e
                r0.a(r3, r2)
                if (r2 == 0) goto L_0x003f
                android.widget.TextView r2 = r4.f21039e
                com.shopee.app.ui.common.TierVariationView$b$b r3 = new com.shopee.app.ui.common.TierVariationView$b$b
                r3.<init>(r0)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
            L_0x003f:
                android.view.View r0 = r4.f21037c
                if (r6 != 0) goto L_0x0045
                r1 = 8
            L_0x0045:
                r0.setVisibility(r1)
                android.widget.TextView r0 = r4.f21038d
                java.lang.String r1 = r5.name
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                r4.f21036b = r6
                com.shopee.app.ui.common.TierVariationView r6 = r4.f21035a
                android.util.SparseArray r6 = r6.O
                int r0 = r4.f21036b
                java.lang.Object r6 = r6.get(r0)
                if (r6 != 0) goto L_0x0071
                com.shopee.app.ui.common.TierVariationView r6 = r4.f21035a
                android.util.SparseArray r6 = r6.O
                int r0 = r4.f21036b
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                r6.append(r0, r1)
            L_0x0071:
                java.util.ArrayList<java.lang.String> r6 = r4.f21041g
                r6.clear()
                java.util.List<java.lang.String> r6 = r5.options
                if (r6 == 0) goto L_0x0083
                java.util.ArrayList<java.lang.String> r6 = r4.f21041g
                java.util.List<java.lang.String> r5 = r5.options
                java.util.Collection r5 = (java.util.Collection) r5
                r6.addAll(r5)
            L_0x0083:
                com.garena.android.uikit.fluid.tagcloud.GTagCloud r5 = r4.f21040f
                r5.a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.common.TierVariationView.b.a(com.shopee.protocol.shop.TierVariation, int):void");
        }

        /* renamed from: com.shopee.app.ui.common.TierVariationView$b$b  reason: collision with other inner class name */
        static final class C0311b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ al f21043a;

            C0311b(al alVar) {
                this.f21043a = alVar;
            }

            public final void onClick(View view) {
                this.f21043a.a();
            }
        }
    }

    public final class c extends RecyclerView.a<b> {
        public c() {
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            j.b(bVar, "holder");
            Object obj = TierVariationView.this.M.get(i);
            j.a(obj, "tierVariations[position]");
            bVar.a((TierVariation) obj, i);
        }

        /* renamed from: a */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            j.b(viewGroup, "parent");
            View inflate = LayoutInflater.from(TierVariationView.this.getContext()).inflate(R.layout.item_variantion, viewGroup, false);
            TierVariationView tierVariationView = TierVariationView.this;
            j.a((Object) inflate, "itemView");
            return new b(tierVariationView, inflate);
        }

        public int getItemCount() {
            return TierVariationView.this.M.size();
        }
    }

    public static final class a extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private boolean f21029a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f21030b = true;

        /* renamed from: c  reason: collision with root package name */
        private TextView f21031c;

        /* renamed from: d  reason: collision with root package name */
        private final int f21032d;

        /* renamed from: e  reason: collision with root package name */
        private final int f21033e;

        /* renamed from: f  reason: collision with root package name */
        private int f21034f;

        public a(Context context, int i, int i2) {
            super(context);
            this.f21032d = i;
            this.f21033e = i2;
            this.f21034f = R.drawable.btn_primary;
            View.inflate(context, R.layout.model_grid_item_view, this);
            View findViewById = findViewById(R.id.label);
            if (findViewById != null) {
                this.f21031c = (TextView) findViewById;
                return;
            }
            throw new m("null cannot be cast to non-null type android.widget.TextView");
        }

        public final boolean getMActive() {
            return this.f21029a;
        }

        public final void setMActive(boolean z) {
            this.f21029a = z;
        }

        public final boolean getMAllowed() {
            return this.f21030b;
        }

        public final void setMAllowed(boolean z) {
            this.f21030b = z;
        }

        public final TextView getLabel() {
            return this.f21031c;
        }

        public final void setLabel(TextView textView) {
            this.f21031c = textView;
        }

        public final int getTierIndex() {
            return this.f21032d;
        }

        public final int getOptionIndex() {
            return this.f21033e;
        }

        public final int getActiveBgRes() {
            return this.f21034f;
        }

        public final void setActiveBgRes(int i) {
            this.f21034f = i;
        }

        public final void setOption(String str) {
            j.b(str, "option");
            TextView textView = this.f21031c;
            if (textView != null) {
                textView.setText(str);
            }
        }

        public final void setActive(boolean z) {
            this.f21029a = z;
            if (this.f21029a) {
                TextView textView = this.f21031c;
                if (textView != null) {
                    textView.setBackgroundResource(this.f21034f);
                }
                TextView textView2 = this.f21031c;
                if (textView2 != null) {
                    textView2.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white87));
                    return;
                }
                return;
            }
            TextView textView3 = this.f21031c;
            if (textView3 != null) {
                textView3.setBackgroundResource(R.drawable.btn_secondary_grey);
            }
            TextView textView4 = this.f21031c;
            if (textView4 != null) {
                textView4.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            }
        }

        public final void setAllowed(boolean z) {
            this.f21030b = z;
            if (this.f21030b) {
                TextView textView = this.f21031c;
                if (textView != null) {
                    textView.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
                    return;
                }
                return;
            }
            TextView textView2 = this.f21031c;
            if (textView2 != null) {
                textView2.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
            }
        }
    }
}
