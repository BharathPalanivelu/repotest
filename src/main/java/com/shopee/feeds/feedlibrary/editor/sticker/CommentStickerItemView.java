package com.shopee.feeds.feedlibrary.editor.sticker;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.UserDataStore;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.util.h;

public class CommentStickerItemView extends c {
    private TextView i;
    private TextView j;
    private EditText k;
    private TextView l;
    private LinearLayout m;
    private ImageView n;
    private TextView o;
    private boolean p;

    public CommentStickerItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommentStickerItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentStickerItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_sticker_comment_item_view, this, true);
        this.i = (TextView) inflate.findViewById(c.e.tv_title_edit_hint);
        this.j = (TextView) inflate.findViewById(c.e.tv_question_title);
        this.k = (EditText) inflate.findViewById(c.e.et_question_title);
        this.l = (TextView) inflate.findViewById(c.e.tv_answer_notify_text);
        this.m = (LinearLayout) inflate.findViewById(c.e.ll_attach_voucher);
        this.m.setVisibility(8);
        this.n = (ImageView) inflate.findViewById(c.e.iv_voucher_add);
        this.o = (TextView) inflate.findViewById(c.e.tv_voucher_add);
        this.k.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(2.0f);
        }
        this.l.setText(b.e(c.g.feeds_comment_sticker_viewers_respond_here));
        this.i.setText(b.e(c.g.feeds_comment_sticker_title_ask_questions));
        this.l.setText(b.e(c.g.feeds_comment_sticker_viewers_respond_here));
        this.o.setText(b.e(c.g.feeds_comment_sticker_attach_voucher));
    }

    public void setInfo(com.shopee.feeds.feedlibrary.editor.b.b bVar) {
        super.setInfo(bVar);
        String simpleName = CommentStickerItemView.class.getSimpleName();
        h.b(simpleName, "item " + bVar.h() + "," + bVar.a());
        com.shopee.feeds.feedlibrary.editor.sticker.a.b bVar2 = (com.shopee.feeds.feedlibrary.editor.sticker.a.b) bVar;
        this.j.setText(bVar2.x());
        this.k.setText(bVar2.x());
        String m2 = bVar2.m();
        if (TextUtils.isEmpty(m2)) {
            this.n.setImageDrawable(b.f(c.d.feeds_ic_photo_editor_sticker_comment_attach_voucher));
            this.o.setText(b.e(c.g.feeds_comment_sticker_attach_voucher));
            this.o.setTextColor(b.a(c.b.feeds_color_comment_no_voucher));
            return;
        }
        this.n.setImageDrawable(b.f(c.d.feeds_ic_photo_editor_sticker_comment_attach_voucher_orange));
        this.o.setText(b.a(c.g.feeds_comment_sticker_edit_voucher_label, m2));
        this.o.setTextColor(b.a(c.b.main_color));
    }

    public com.shopee.feeds.feedlibrary.editor.sticker.a.b getInfo() {
        if (this.f27923g != null) {
            return (com.shopee.feeds.feedlibrary.editor.sticker.a.b) this.f27923g;
        }
        return null;
    }

    public void setEditMode(boolean z) {
        int i2 = 0;
        this.k.setVisibility(z ? 0 : 8);
        TextView textView = this.j;
        if (z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        this.p = z;
        setClickable(true);
        setFocusable(true);
    }

    public void b() {
        setEditMode(true);
        this.k.setText("");
        this.j.setText("");
        this.i.setVisibility(0);
    }

    public void setTouchDisable(boolean z) {
        this.h = z;
    }

    public void c() {
        h.b(UserDataStore.DATE_OF_BIRTH, "CommentStickerItemView x " + getX() + ",y" + getY() + ",tx" + getTranslationX() + ",h" + getMeasuredHeight() + ",w" + getMeasuredWidth() + ",ra " + getRotation() + "sc," + getScaleX());
    }

    public EditText getEtQuestionTitle() {
        return this.k;
    }

    public View getAttachVoucherView() {
        return this.m;
    }

    public TextView getTvTitleEditHint() {
        return this.i;
    }
}
