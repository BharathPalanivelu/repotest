package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.grid.GGridView;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.l;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.bk;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class c extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener, n<ItemCommentInfo> {

    /* renamed from: a  reason: collision with root package name */
    AvatarView f24469a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24470b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f24471c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f24472d;

    /* renamed from: e  reason: collision with root package name */
    TextView f24473e;

    /* renamed from: f  reason: collision with root package name */
    TextView f24474f;

    /* renamed from: g  reason: collision with root package name */
    TextView f24475g;
    GGridView h;
    ImageView i;
    View j;
    ImageView k;
    View l;
    bi m;
    ak n;
    UserInfo o;
    int p;
    int q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public long t;
    private ItemCommentInfo u;
    private a v;

    public c(Context context) {
        super(context);
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.h.setColumnCount(3);
        this.h.setItemMargin(b.a.f7691b);
        this.v = new a();
        this.h.setAdapter(this.v);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.performLongClick();
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.performLongClick();
            }
        });
    }

    private void a(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void a(final ItemCommentInfo itemCommentInfo) {
        this.u = itemCommentInfo;
        setTag(itemCommentInfo);
        this.r = itemCommentInfo.getShopId();
        this.t = itemCommentInfo.getCmtId();
        this.s = itemCommentInfo.getItemId();
        this.f24469a.a(itemCommentInfo.getUserId(), itemCommentInfo.getUserPortrait());
        this.f24469a.setClickable(!itemCommentInfo.isAnonymous());
        if (itemCommentInfo.isOwnerComment()) {
            this.f24470b.setCompoundDrawablePadding(this.q * 2);
            this.f24470b.setCompoundDrawablesWithIntrinsicBounds(com.garena.android.appkit.tools.b.f(R.drawable.ic_comments_seller), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.f24470b.setCompoundDrawablePadding(0);
            this.f24470b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        f a2 = f.a(getContext());
        a2.a().a((Object) itemCommentInfo.getUserName()).a().b(com.garena.android.appkit.tools.b.a(R.color.black87)).c().a((com.a.a.a) new com.a.a.a() {
            public SpannedString format(Object obj) {
                SpannableString spannableString = new SpannableString((CharSequence) obj);
                spannableString.setSpan(new bk() {
                    public void onClick(View view) {
                        c.this.f24469a.onClick(view);
                    }
                }, 0, spannableString.length(), 33);
                return new SpannedString(spannableString);
            }
        }).b();
        a2.a((Object) "  ").b();
        a2.a(this.f24470b);
        this.f24474f.setText(com.garena.android.appkit.tools.a.a.c(itemCommentInfo.getCTime()));
        if (!TextUtils.isEmpty(itemCommentInfo.getVariationName())) {
            TextView textView = this.f24474f;
            textView.append("   |   " + com.garena.android.appkit.tools.b.a(R.string.sp_label_variation_placeholder, itemCommentInfo.getVariationName()));
        }
        if (TextUtils.isEmpty(itemCommentInfo.getDisplayString())) {
            this.f24475g.setVisibility(8);
        } else {
            this.f24475g.setVisibility(0);
            this.f24475g.setText(itemCommentInfo.getDisplayString());
        }
        a(this.f24475g);
        if (itemCommentInfo.isBuyerComment()) {
            b(itemCommentInfo);
        } else {
            b();
        }
        if (af.a(itemCommentInfo.getImages())) {
            this.j.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        } else if (itemCommentInfo.getImages().size() == 1) {
            this.j.setVisibility(0);
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(itemCommentInfo.getImages(), 0);
                }
            });
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            w a3 = w.a(getContext());
            a3.a("http://cf.shopee.co.id/file/" + itemCommentInfo.getImages().get(0)).a((int) R.drawable.com_garena_shopee_ic_product_default).b(b.a.v, b.a.v).d().a(this.i);
        } else {
            this.j.setVisibility(0);
            this.i.setVisibility(8);
            this.h.setVisibility(0);
            this.v.a(itemCommentInfo.getImages());
            this.h.setOnItemClickListener(new GGridView.b() {
                public void a(View view, int i, int i2, int i3) {
                    c.this.a(itemCommentInfo.getImages(), i3);
                }
            });
            this.h.a();
        }
    }

    /* access modifiers changed from: private */
    public void a(List<String> list, int i2) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(MediaData.newImageData("http://cf.shopee.co.id/file/" + str));
        }
        ImageBrowserActivity_.a(getContext()).b(i2).a((ArrayList<MediaData>) arrayList).a();
    }

    private void b(ItemCommentInfo itemCommentInfo) {
        this.f24473e.setVisibility(0);
        this.f24471c.setVisibility(0);
        this.f24472d.removeAllViews();
        int i2 = 1;
        while (i2 <= 5) {
            ImageView imageView = new ImageView(getContext());
            int i3 = this.p;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            if (i2 == 1) {
                layoutParams.setMargins(this.p, 0, 0, 0);
            } else {
                layoutParams.setMargins(this.q * 2, 0, 0, 0);
            }
            imageView.setImageResource(i2 > itemCommentInfo.getRatingStar() ? R.drawable.ic_rating_score_hollow : R.drawable.ic_rating_score_solid);
            this.f24472d.addView(imageView, layoutParams);
            i2++;
        }
    }

    private void b() {
        this.f24473e.setVisibility(8);
        this.f24471c.setVisibility(8);
    }

    public void onClick(View view) {
        ItemCommentInfo itemCommentInfo = (ItemCommentInfo) view.getTag();
        if (itemCommentInfo != null && itemCommentInfo.getUserId() != this.o.getUserId() && !itemCommentInfo.isAnonymous()) {
            this.m.a().W.a(new Pair(itemCommentInfo.getUserName(), Integer.valueOf(itemCommentInfo.getUserId()))).a();
        }
    }

    public boolean onLongClick(View view) {
        final ItemCommentInfo itemCommentInfo = (ItemCommentInfo) view.getTag();
        ArrayList arrayList = new ArrayList();
        if (itemCommentInfo != null) {
            if (itemCommentInfo.isMyComment(this.o.getUserId())) {
                if (itemCommentInfo.isBuyerComment()) {
                    l.a aVar = new l.a();
                    aVar.f21294b = com.garena.android.appkit.tools.b.e(R.string.sp_label_change_rating);
                    aVar.f21295c = com.garena.android.appkit.tools.b.a(R.string.sp_change_rating_info_message, com.garena.android.appkit.tools.a.a.e(itemCommentInfo.getEditableDate(), "ID"));
                    aVar.f21296d = "app://ic_popup_write";
                    aVar.f21298f = 0;
                    if (!itemCommentInfo.canChangeRating()) {
                        aVar.f21297e = 1;
                        aVar.f21295c = com.garena.android.appkit.tools.b.e(R.string.sp_change_rating_just_once);
                    }
                    arrayList.add(aVar);
                } else {
                    l.a aVar2 = new l.a();
                    aVar2.f21294b = com.garena.android.appkit.tools.b.e(R.string.sp_label_delete);
                    aVar2.f21296d = "app://ic_popup_delete";
                    aVar2.f21298f = 2;
                    arrayList.add(aVar2);
                }
            } else if (itemCommentInfo.isBuyerComment()) {
                if (!itemCommentInfo.isAnonymous()) {
                    l.a aVar3 = new l.a();
                    aVar3.f21294b = com.garena.android.appkit.tools.b.e(R.string.sp_label_reply);
                    aVar3.f21296d = "app://ic_popup_reply";
                    aVar3.f21298f = 1;
                    arrayList.add(aVar3);
                }
            } else if (!itemCommentInfo.isAnonymous()) {
                l.a aVar4 = new l.a();
                aVar4.f21294b = com.garena.android.appkit.tools.b.e(R.string.sp_label_reply);
                aVar4.f21296d = "app://ic_popup_reply";
                aVar4.f21298f = 1;
                arrayList.add(aVar4);
            }
            l lVar = new l(getContext());
            lVar.a((List<l.a>) arrayList);
            lVar.a((View) this.k);
            lVar.a((l.b) new l.b() {
                public void a(l.a aVar) {
                    int i = aVar.f21298f;
                    if (i != 0) {
                        if (i == 1) {
                            c.this.m.a().W.a(new Pair(itemCommentInfo.getUserName(), Integer.valueOf(itemCommentInfo.getUserId()))).a();
                        } else if (i == 2) {
                            c.this.m.a("ITEM_COMMENT_DELETE", (com.garena.android.appkit.b.a) new b(c.this.r, c.this.s, c.this.t));
                        } else if (i == 3) {
                            c.this.n.h(c.this.t);
                        }
                    } else if (itemCommentInfo.canChangeRating()) {
                        c.this.n.g(itemCommentInfo.getCmtId());
                    } else if (itemCommentInfo.hasAlreadyRated()) {
                        com.shopee.app.ui.dialog.a.a(c.this.getContext(), 0, (int) R.string.sp_change_rating_error_already_rated, 0, (int) R.string.sp_label_ok);
                    } else {
                        com.shopee.app.ui.dialog.a.a(c.this.getContext(), 0, (int) R.string.sp_change_rating_error_expired, 0, (int) R.string.sp_label_ok);
                    }
                }
            });
        }
        return true;
    }

    private static class a implements GGridView.a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f24486a;

        private a() {
        }

        /* access modifiers changed from: private */
        public void a(List<String> list) {
            this.f24486a = list;
        }

        public int a() {
            return this.f24486a.size();
        }

        public View a(Context context, int i, int i2, int i3) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setBackgroundResource(R.drawable.border_all_sides);
            String str = this.f24486a.get(i3);
            if (!str.endsWith("_tn")) {
                str = str + "_tn";
            }
            w.a(context).a("http://cf.shopee.co.id/file/" + str).a((int) R.drawable.com_garena_shopee_ic_product_default).b(b.a.u, b.a.u).d().a(imageView);
            return imageView;
        }
    }
}
