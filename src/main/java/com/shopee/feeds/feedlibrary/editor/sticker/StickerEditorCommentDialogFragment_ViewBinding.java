package com.shopee.feeds.feedlibrary.editor.sticker;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;

public class StickerEditorCommentDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private StickerEditorCommentDialogFragment f27995b;

    public StickerEditorCommentDialogFragment_ViewBinding(StickerEditorCommentDialogFragment stickerEditorCommentDialogFragment, View view) {
        this.f27995b = stickerEditorCommentDialogFragment;
        stickerEditorCommentDialogFragment.doneBtn = (TextView) b.a(view, c.e.tv_add_done, "field 'doneBtn'", TextView.class);
        stickerEditorCommentDialogFragment.tvAnswerNotifyText = (TextView) b.a(view, c.e.tv_answer_notify_text, "field 'tvAnswerNotifyText'", TextView.class);
        stickerEditorCommentDialogFragment.tvQuestionTitle = (TextView) b.a(view, c.e.tv_question_title, "field 'tvQuestionTitle'", TextView.class);
        stickerEditorCommentDialogFragment.tvTitleEditHint = (TextView) b.a(view, c.e.tv_title_edit_hint, "field 'tvTitleEditHint'", TextView.class);
        stickerEditorCommentDialogFragment.etQuestionTitle = (EditText) b.a(view, c.e.et_question_title, "field 'etQuestionTitle'", EditText.class);
        stickerEditorCommentDialogFragment.ivVoucherAdd = (ImageView) b.a(view, c.e.iv_voucher_add, "field 'ivVoucherAdd'", ImageView.class);
        stickerEditorCommentDialogFragment.tvVoucherAdd = (TextView) b.a(view, c.e.tv_voucher_add, "field 'tvVoucherAdd'", TextView.class);
        stickerEditorCommentDialogFragment.llAttachVoucher = (LinearLayout) b.a(view, c.e.ll_attach_voucher, "field 'llAttachVoucher'", LinearLayout.class);
        stickerEditorCommentDialogFragment.tvNotify = (TextView) b.a(view, c.e.tv_notify, "field 'tvNotify'", TextView.class);
    }
}
