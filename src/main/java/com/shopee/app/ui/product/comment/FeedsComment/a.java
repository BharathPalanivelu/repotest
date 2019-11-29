package com.shopee.app.ui.product.comment.FeedsComment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.bi;
import com.shopee.app.util.bk;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends RelativeLayout implements n<FeedCommentInfo> {
    /* access modifiers changed from: private */
    public static CharSequence[] m = new CharSequence[2];
    /* access modifiers changed from: private */
    public static CharSequence[] n = new CharSequence[3];

    /* renamed from: a  reason: collision with root package name */
    AvatarView f24410a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24411b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f24412c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f24413d;

    /* renamed from: e  reason: collision with root package name */
    TextView f24414e;

    /* renamed from: f  reason: collision with root package name */
    TextView f24415f;

    /* renamed from: g  reason: collision with root package name */
    TextView f24416g;
    bi h;
    UserInfo i;
    int j;
    int k;
    /* access modifiers changed from: private */
    public FeedCommentInfo l;
    /* access modifiers changed from: private */
    public a.c o = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                a.this.f24410a.performClick();
            } else if (i == 1 && !TextUtils.isEmpty(a.this.f24416g.getText())) {
                ((ClipboardManager) ar.a().getSystemService("clipboard")).setText(a.this.f24416g.getText());
                r.a().b((int) R.string.sp_label_copy_text_done);
            }
            fVar.dismiss();
        }
    };
    /* access modifiers changed from: private */
    public a.c p = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                a.this.h.a("ITEM_COMMENT_REPLY", new com.garena.android.appkit.b.a(new Pair(a.this.l.getUserName(), Integer.valueOf(a.this.l.getUserId()))));
            } else if (i == 1) {
                a.this.f24410a.performClick();
            } else if (i == 2 && !TextUtils.isEmpty(a.this.f24416g.getText())) {
                ((ClipboardManager) ar.a().getSystemService("clipboard")).setText(a.this.f24416g.getText());
                r.a().b((int) R.string.sp_label_copy_text_done);
            }
            fVar.dismiss();
        }
    };

    public a(Context context) {
        super(context);
        ((com.shopee.app.ui.product.comment.a) ((x) context).b()).a(this);
    }

    static {
        m[0] = b.e(R.string.sp_label_view_profile);
        m[1] = b.e(R.string.sp_label_copy_text);
        n[0] = b.e(R.string.sp_label_reply);
        n[1] = b.e(R.string.sp_label_view_profile);
        n[2] = b.e(R.string.sp_label_copy_text);
    }

    private void a(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void a(final FeedCommentInfo feedCommentInfo) {
        this.l = feedCommentInfo;
        this.f24410a.a(feedCommentInfo.getUserId(), feedCommentInfo.getUserPortrait());
        if (feedCommentInfo.isOwnerComment()) {
            this.f24411b.setCompoundDrawablePadding(this.k * 2);
            this.f24411b.setCompoundDrawablesWithIntrinsicBounds(b.f(R.drawable.ic_comments_seller), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.f24411b.setCompoundDrawablePadding(0);
            this.f24411b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.a.a.f a2 = com.a.a.f.a(getContext());
        a2.a().a((Object) feedCommentInfo.getUserName()).a().b(b.a(R.color.black87)).c().a((com.a.a.a) new com.a.a.a() {
            public SpannedString format(Object obj) {
                SpannableString spannableString = new SpannableString((CharSequence) obj);
                spannableString.setSpan(new bk() {
                    public void onClick(View view) {
                        a.this.f24410a.onClick(view);
                    }
                }, 0, spannableString.length(), 33);
                return new SpannedString(spannableString);
            }
        }).b();
        a2.a((Object) "  ").b();
        a2.a(this.f24411b);
        this.f24415f.setText(com.garena.android.appkit.tools.a.a.c((int) (feedCommentInfo.getcTime() / 1000000000)));
        if (TextUtils.isEmpty(feedCommentInfo.getDisplayString())) {
            this.f24416g.setVisibility(8);
        } else {
            this.f24416g.setVisibility(0);
            this.f24416g.setText(feedCommentInfo.getDisplayString());
        }
        a(this.f24416g);
        c();
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (feedCommentInfo.getUserId() != a.this.i.getUserId()) {
                    a.this.h.a("ITEM_COMMENT_REPLY", new com.garena.android.appkit.b.a(new Pair(feedCommentInfo.getUserName(), Integer.valueOf(feedCommentInfo.getUserId()))));
                }
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (feedCommentInfo.getUserId() != a.this.i.getUserId()) {
                    com.shopee.app.ui.dialog.a.a(a.this.getContext(), a.n, a.this.p);
                    return false;
                }
                com.shopee.app.ui.dialog.a.a(a.this.getContext(), a.m, a.this.o);
                return false;
            }
        });
    }

    private void c() {
        this.f24414e.setVisibility(8);
        this.f24412c.setVisibility(8);
    }
}
