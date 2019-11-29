package com.shopee.feeds.feedlibrary.editor.sticker;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.PosVoucherEntity;
import com.shopee.feeds.feedlibrary.data.entity.VoucherEntity;
import com.shopee.feeds.feedlibrary.editor.sticker.a.b;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.g;
import com.shopee.feeds.feedlibrary.util.s;
import com.shopee.feeds.feedlibrary.util.v;

public class CommentStickerEditorPanel extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f27970a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f27971b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CommentStickerItemView f27972c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27973d;

    /* renamed from: e  reason: collision with root package name */
    private View f27974e;

    /* renamed from: f  reason: collision with root package name */
    private float f27975f;

    /* renamed from: g  reason: collision with root package name */
    private b f27976g;
    private String h;
    /* access modifiers changed from: private */
    public String i;
    private g j;
    /* access modifiers changed from: private */
    public a k;
    /* access modifiers changed from: private */
    public float l;
    /* access modifiers changed from: private */
    public float m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public float o;
    /* access modifiers changed from: private */
    public int p;

    public interface a {
        void a();

        void a(b bVar);

        void b();
    }

    public CommentStickerEditorPanel(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommentStickerEditorPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentStickerEditorPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_sticker_comment_edit_panel, this, true);
        this.f27970a = (TextView) inflate.findViewById(c.e.tv_add_done);
        this.f27973d = (TextView) inflate.findViewById(c.e.tv_notify);
        this.f27972c = (CommentStickerItemView) inflate.findViewById(c.e.view_comment_sticker_item);
        this.f27971b = (RelativeLayout) inflate.findViewById(c.e.rl_edit_content);
        this.f27974e = inflate.findViewById(c.e.v_bg);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f27971b.getLayoutParams();
        layoutParams.height = s.a(context);
        layoutParams.width = s.a(context);
        this.f27975f = (float) layoutParams.width;
        this.f27971b.setLayoutParams(layoutParams);
        this.f27970a.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_done));
        this.f27972c.setEditMode(true);
        this.f27974e.setAlpha(BitmapDescriptorFactory.HUE_RED);
        this.f27970a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommentStickerEditorPanel.this.c();
            }
        });
        this.f27974e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommentStickerEditorPanel.this.c();
            }
        });
        this.f27976g = new b();
        this.j = new g();
        this.k = new a() {
            public void a() {
            }

            public void a(b bVar) {
            }

            public void b() {
            }
        };
        final EditText etQuestionTitle = this.f27972c.getEtQuestionTitle();
        etQuestionTitle.setFilters(new InputFilter[]{this.j});
        etQuestionTitle.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CommentStickerEditorPanel.this.f27972c.getTvTitleEditHint().setVisibility(charSequence.length() > 0 ? 8 : 0);
            }

            public void afterTextChanged(Editable editable) {
                if (etQuestionTitle.getLineCount() == editable.length() || etQuestionTitle.getLineCount() <= etQuestionTitle.getMaxLines()) {
                    String unused = CommentStickerEditorPanel.this.i = etQuestionTitle.getText().toString();
                    return;
                }
                int lineStart = etQuestionTitle.getLayout().getLineStart(etQuestionTitle.getMaxLines()) - 1;
                if (TextUtils.isEmpty(CommentStickerEditorPanel.this.i) || lineStart >= CommentStickerEditorPanel.this.i.length()) {
                    String substring = etQuestionTitle.getText().toString().substring(0, lineStart);
                    etQuestionTitle.setText(substring);
                    EditText editText = etQuestionTitle;
                    editText.setSelection(editText.getText().length());
                    String unused2 = CommentStickerEditorPanel.this.i = substring;
                    return;
                }
                etQuestionTitle.setText(CommentStickerEditorPanel.this.i);
                EditText editText2 = etQuestionTitle;
                editText2.setSelection(editText2.getText().length());
            }
        });
        etQuestionTitle.setInputType(131072);
        etQuestionTitle.setGravity(49);
        etQuestionTitle.setSingleLine(false);
        etQuestionTitle.setHorizontallyScrolling(false);
        etQuestionTitle.setMaxLines(3);
        this.f27972c.setTouchDisable(true);
    }

    public CommentStickerEditorPanel a(b bVar) {
        this.f27972c.setRotation((float) bVar.l());
        this.f27972c.setScaleX(bVar.j());
        this.f27972c.setScaleY(bVar.j());
        CommentStickerItemView commentStickerItemView = this.f27972c;
        float h2 = bVar.h();
        float f2 = this.f27975f;
        commentStickerItemView.setTranslationX((h2 * f2) - (f2 / 2.0f));
        CommentStickerItemView commentStickerItemView2 = this.f27972c;
        float i2 = bVar.i();
        float f3 = this.f27975f;
        commentStickerItemView2.setTranslationY((i2 * f3) - (f3 / 2.0f));
        this.f27976g = bVar;
        this.f27972c.setEditMode(true);
        this.f27972c.setInfo(bVar);
        return this;
    }

    public CommentStickerEditorPanel a(a aVar) {
        this.k = aVar;
        return this;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.p = 2;
            a(bVar);
        } else {
            this.f27976g = new b();
            this.f27972c.setScaleX(1.0f);
            this.f27972c.setScaleY(1.0f);
            this.f27972c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            this.f27972c.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            this.f27972c.setRotation(BitmapDescriptorFactory.HUE_RED);
            this.f27972c.b();
            this.p = 1;
        }
        this.k.a();
        a();
    }

    public void a() {
        setVisibility(0);
        this.f27974e.setAlpha(BitmapDescriptorFactory.HUE_RED);
        setAlpha(1.0f);
        this.f27972c.setVisibility(0);
        this.l = this.f27972c.getScaleX();
        this.m = this.f27972c.getTranslationX();
        this.n = this.f27972c.getTranslationY();
        this.o = this.f27972c.getRotation();
        View view = this.f27974e;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{view.getAlpha(), 1.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                CommentStickerEditorPanel.this.f27972c.setScaleX(CommentStickerEditorPanel.this.l + ((1.0f - CommentStickerEditorPanel.this.l) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setScaleY(CommentStickerEditorPanel.this.l + ((1.0f - CommentStickerEditorPanel.this.l) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setTranslationX(CommentStickerEditorPanel.this.m + ((BitmapDescriptorFactory.HUE_RED - CommentStickerEditorPanel.this.m) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setTranslationY(CommentStickerEditorPanel.this.n + ((BitmapDescriptorFactory.HUE_RED - CommentStickerEditorPanel.this.n) * animatedFraction));
                if (Math.abs(CommentStickerEditorPanel.this.o) <= 180.0f) {
                    CommentStickerEditorPanel.this.f27972c.setRotation(CommentStickerEditorPanel.this.o + ((BitmapDescriptorFactory.HUE_RED - Math.abs(CommentStickerEditorPanel.this.o)) * animatedFraction));
                } else {
                    CommentStickerEditorPanel.this.f27972c.setRotation(CommentStickerEditorPanel.this.o + ((360.0f - Math.abs(CommentStickerEditorPanel.this.o)) * animatedFraction));
                }
                if (animatedFraction >= 1.0f) {
                    CommentStickerEditorPanel.this.e();
                }
            }
        });
        ofFloat.start();
    }

    public void b() {
        if (this.p == 1) {
            a(false);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{this.f27974e.getAlpha(), 0.0f});
            ofFloat.setDuration(300);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                        CommentStickerEditorPanel.this.setVisibility(8);
                        CommentStickerEditorPanel.this.setAlpha(1.0f);
                        CommentStickerEditorPanel.this.k.b();
                    }
                }
            });
            ofFloat.start();
            return;
        }
        c();
    }

    public void c() {
        if (this.f27972c.getEtQuestionTitle().getText().length() <= 0) {
            this.f27976g.i(com.garena.android.appkit.tools.b.e(c.g.feeds_comment_sticker_title_ask_questions));
        } else {
            this.f27976g.i(this.f27972c.getEtQuestionTitle().getText().toString());
        }
        this.f27976g.b(this.h);
        a(false);
        View view = this.f27974e;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{view.getAlpha(), 0.0f});
        ofFloat.setDuration(300);
        this.f27972c.setEditMode(false);
        this.f27972c.setInfo(this.f27976g);
        final float scaleX = this.f27972c.getScaleX();
        final float translationX = this.f27972c.getTranslationX();
        final float translationY = this.f27972c.getTranslationY();
        final float rotation = this.f27972c.getRotation();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                CommentStickerEditorPanel.this.f27972c.setScaleX(scaleX + ((CommentStickerEditorPanel.this.l - scaleX) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setScaleY(scaleX + ((CommentStickerEditorPanel.this.l - scaleX) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setTranslationX(translationX + ((CommentStickerEditorPanel.this.m - translationX) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setTranslationY(translationY + ((CommentStickerEditorPanel.this.n - translationY) * animatedFraction));
                CommentStickerEditorPanel.this.f27972c.setRotation(rotation + ((CommentStickerEditorPanel.this.o - rotation) * animatedFraction));
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    CommentStickerEditorPanel.this.f();
                    if (CommentStickerEditorPanel.this.p == 2) {
                        CommentStickerEditorPanel.this.setVisibility(8);
                    }
                }
            }
        });
        ofFloat.start();
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    public void a(PosVoucherEntity posVoucherEntity) {
        if (posVoucherEntity.getType() == 2) {
            VoucherEntity voucherEntity = posVoucherEntity.getVoucherEntity();
            int reward_type = voucherEntity.getReward_type();
            this.f27976g.f(voucherEntity.getPromotion_id());
            this.f27976g.g(voucherEntity.getSignature());
            this.f27976g.h(voucherEntity.getVoucher_code());
            if (reward_type != 0) {
                if (reward_type == 1) {
                    this.h = String.valueOf(voucherEntity.getCoin_percentage_real() + "%");
                }
            } else if (d.a(voucherEntity.getDiscount_value()) || voucherEntity.getDiscount_value().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.h = String.valueOf(voucherEntity.getDiscount_percent()) + "%";
            } else {
                this.h = v.a() + v.b(voucherEntity.getDiscount_value(), 1);
            }
            this.f27976g.b(this.h);
            this.f27972c.setInfo(this.f27976g);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        a(true);
        this.f27972c.getEtQuestionTitle().setSelection(this.f27972c.getEtQuestionTitle().getText().length());
        this.f27972c.getAttachVoucherView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommentStickerEditorPanel.this.a(false);
                com.shopee.feeds.feedlibrary.util.a.a(CommentStickerEditorPanel.this.getContext(), 2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        this.k.a(this.f27976g);
        this.k.b();
        a(false);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f27972c.getEtQuestionTitle().requestFocus();
            d.c((Activity) getContext(), this.f27972c.getEtQuestionTitle());
            return;
        }
        d.a((Activity) getContext(), this.f27972c.getEtQuestionTitle());
    }
}
