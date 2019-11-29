package com.shopee.app.d.c;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.view.View;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.s;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.database.orm.bean.DBItemComment;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.ax;
import com.shopee.app.network.f;
import com.shopee.app.ui.common.e;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.shop.ItemExtInfo;
import com.shopee.protocol.shop.ItemRating;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class aj extends com.shopee.app.d.c.a.a<c> {

    /* renamed from: d  reason: collision with root package name */
    private final s f16463d;

    /* renamed from: e  reason: collision with root package name */
    private final ah f16464e;

    /* renamed from: f  reason: collision with root package name */
    private final bh f16465f;

    /* renamed from: g  reason: collision with root package name */
    private final ao f16466g;

    public aj(n nVar, s sVar, ah ahVar, ao aoVar, bh bhVar) {
        super(nVar);
        this.f16463d = sVar;
        this.f16464e = ahVar;
        this.f16465f = bhVar;
        this.f16466g = aoVar;
    }

    public void a(int i, long j, boolean z, int i2, int i3) {
        b(new c(i, j, z, i2, i3));
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        List<DBItemComment> list;
        if (cVar.f16479c) {
            list = this.f16463d.b(cVar.f16478b);
        } else {
            list = this.f16463d.a(cVar.f16478b);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Pair> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        for (DBItemComment next : list) {
            if (cVar.f16480d == 10 || cVar.i == 0 || next.a() == cVar.i) {
                ItemCommentInfo itemCommentInfo = new ItemCommentInfo();
                DBUserInfo a2 = this.f16465f.a(next.d());
                if (a2 == null) {
                    arrayList.add(Integer.valueOf(next.d()));
                }
                com.shopee.app.d.b.b.a(next, a2, cVar.f16480d, itemCommentInfo);
                itemCommentInfo.setDisplayString(a((Pair<String, List<e>>) new Pair(itemCommentInfo.getComment(), itemCommentInfo.getMentioned())));
                if (itemCommentInfo.getModelId() > 0 && itemCommentInfo.getSnapshotId() > 0) {
                    DBModelSnapshot d2 = this.f16466g.d(itemCommentInfo.getModelId());
                    if (d2 == null) {
                        arrayList2.add(new Pair(Integer.valueOf(itemCommentInfo.getShopId()), Long.valueOf(itemCommentInfo.getSnapshotId())));
                    } else {
                        itemCommentInfo.setVariationName(d2.h());
                    }
                }
                arrayList3.add(itemCommentInfo);
            }
        }
        if (arrayList.size() > 0) {
            new au().a((List<Integer>) arrayList);
        }
        if (arrayList2.size() > 0) {
            for (Pair pair : arrayList2) {
                new aq().a(((Integer) pair.first).intValue(), ((Long) pair.second).longValue());
            }
        }
        b bVar = new b(cVar.f16480d);
        bVar.f16471b = arrayList3;
        DBItemDetail a3 = this.f16464e.a(cVar.f16478b);
        if (a3 != null) {
            bVar.f16472c = a3.r();
            if (a3.s() != null) {
                try {
                    ItemExtInfo itemExtInfo = (ItemExtInfo) f.f18486a.parseFrom(a3.s(), 0, a3.s().length, ItemExtInfo.class);
                    if (itemExtInfo.item_rating != null) {
                        ItemRating itemRating = (ItemRating) f.f18486a.parseFrom(itemExtInfo.item_rating.toByteArray(), ItemRating.class);
                        if (itemRating != null) {
                            int intValue = itemRating.rating_count.get(1).intValue();
                            int intValue2 = itemRating.rating_count.get(2).intValue();
                            int intValue3 = itemRating.rating_count.get(3).intValue();
                            int intValue4 = itemRating.rating_count.get(4).intValue();
                            int intValue5 = itemRating.rating_count.get(5).intValue();
                            bVar.f16473d = intValue + intValue2 + intValue3 + intValue4 + intValue5;
                            bVar.f16474e = intValue;
                            bVar.f16475f = intValue2;
                            bVar.f16476g = intValue3;
                            bVar.h = intValue4;
                            bVar.i = intValue5;
                        }
                    }
                } catch (IOException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        } else {
            new ax(cVar.f16477a, cVar.f16478b).g();
        }
        this.f16405a.a().f7295e.a(bVar).a();
    }

    private SpannableStringBuilder a(Pair<String, List<e>> pair) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence) pair.first);
        for (final e eVar : (List) pair.second) {
            try {
                String charSequence = spannableStringBuilder.subSequence(eVar.c(), eVar.c() + eVar.b()).toString();
                SpannableString spannableString = new SpannableString(charSequence);
                spannableString.setSpan(new a(new View.OnClickListener() {
                    public void onClick(View view) {
                        com.garena.android.appkit.b.b.a("MENTION_CLICKED", new com.garena.android.appkit.b.a(Integer.valueOf(eVar.a())), b.a.UI_BUS);
                    }
                }), 0, charSequence.length(), 33);
                spannableString.setSpan(new StyleSpan(1), 0, charSequence.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(com.garena.android.appkit.tools.b.a(R.color.primary)), 0, charSequence.length(), 33);
                spannableStringBuilder.replace(eVar.c(), eVar.c() + eVar.b(), spannableString);
            } catch (IndexOutOfBoundsException e2) {
                com.garena.android.appkit.d.a.a(e2);
                com.shopee.app.h.b.a(e2.getMessage());
            }
        }
        return spannableStringBuilder;
    }

    private static class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        private View.OnClickListener f16469a;

        public a(View.OnClickListener onClickListener) {
            this.f16469a = onClickListener;
        }

        public void onClick(View view) {
            this.f16469a.onClick(view);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f16470a;

        /* renamed from: b  reason: collision with root package name */
        public List<ItemCommentInfo> f16471b;

        /* renamed from: c  reason: collision with root package name */
        public int f16472c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f16473d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f16474e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f16475f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f16476g = 0;
        public int h = 0;
        public int i = 0;

        public String toString() {
            return "CommentListData{commentType=" + this.f16470a + ", commentList=" + this.f16471b + ", allCount=" + this.f16472c + ", reviewCount=" + this.f16473d + ", star1=" + this.f16474e + ", star2=" + this.f16475f + ", star3=" + this.f16476g + ", star4=" + this.h + ", star5=" + this.i + '}';
        }

        b(int i2) {
            this.f16470a = i2;
        }
    }

    public static class c extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public int f16477a;

        /* renamed from: b  reason: collision with root package name */
        public long f16478b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16479c;

        /* renamed from: d  reason: collision with root package name */
        public int f16480d;
        /* access modifiers changed from: private */
        public int i;

        public c(int i2, long j, boolean z, int i3, int i4) {
            super("GetCommentListInteractor" + i2 + j, "use_case2", 0, false);
            this.f16477a = i2;
            this.f16478b = j;
            this.f16479c = z;
            this.f16480d = i3;
            this.i = i4;
        }
    }
}
