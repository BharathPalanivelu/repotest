package com.shopee.app.d.c;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.view.View;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.h.j;
import com.shopee.app.ui.common.e;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.FeedComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ap extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f16496c;

    /* renamed from: d  reason: collision with root package name */
    private long f16497d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetFeedCommentListInteractor";
    }

    public ap(n nVar, bh bhVar) {
        super(nVar);
        this.f16496c = bhVar;
    }

    public void a(long j) {
        this.f16497d = j;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<FeedComment> a2 = j.a().a(this.f16497d);
        ArrayList arrayList = new ArrayList();
        if (!af.a(a2)) {
            for (FeedComment next : a2) {
                FeedCommentInfo feedCommentInfo = new FeedCommentInfo();
                b.a(next, this.f16496c.a(next.userid.intValue()), feedCommentInfo);
                feedCommentInfo.setDisplayString(a((Pair<String, List<e>>) new Pair(feedCommentInfo.getComment(), feedCommentInfo.getMentioned())));
                arrayList.add(feedCommentInfo);
            }
        }
        Collections.reverse(arrayList);
        this.f16402a.a().bv.a(arrayList).a();
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
        private View.OnClickListener f16500a;

        public a(View.OnClickListener onClickListener) {
            this.f16500a = onClickListener;
        }

        public void onClick(View view) {
            this.f16500a.onClick(view);
        }
    }
}
