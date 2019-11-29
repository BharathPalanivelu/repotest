package com.shopee.feeds.feedlibrary.editor.sticker;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.f.f;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.PosVoucherEntity;
import com.shopee.feeds.feedlibrary.data.entity.VoucherEntity;
import com.shopee.feeds.feedlibrary.editor.sticker.a.b;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.g;
import com.shopee.feeds.feedlibrary.util.v;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class StickerEditorCommentDialogFragment extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7095a = "StickerEditorCommentDialogFragment";

    /* renamed from: b  reason: collision with root package name */
    g f7096b = new g();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Activity f7097c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f7098d;
    @BindView
    TextView doneBtn;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f7099e;
    @BindView
    EditText etQuestionTitle;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f7100f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f7101g;
    @BindView
    ImageView ivVoucherAdd;
    @BindView
    LinearLayout llAttachVoucher;
    @BindView
    TextView tvAnswerNotifyText;
    @BindView
    TextView tvNotify;
    @BindView
    TextView tvQuestionTitle;
    @BindView
    TextView tvTitleEditHint;
    @BindView
    TextView tvVoucherAdd;

    public interface a {
        void a();

        void a(b bVar);

        void b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setStyle(0, 16974382);
        } else {
            setStyle(0, 16974064);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.f.feeds_layout_photo_editor_sticker_comment_edit_dialog, viewGroup, false);
        ButterKnife.a(this, inflate);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f7099e = new b();
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tvTitleEditHint.setVisibility(0);
        this.doneBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StickerEditorCommentDialogFragment.this.a(false);
                StickerEditorCommentDialogFragment.this.dismiss();
                if (StickerEditorCommentDialogFragment.this.etQuestionTitle.getText().length() <= 0) {
                    StickerEditorCommentDialogFragment.this.f7099e.i(com.garena.android.appkit.tools.b.e(c.g.feeds_comment_sticker_title_ask_questions));
                } else {
                    StickerEditorCommentDialogFragment.this.f7099e.i(StickerEditorCommentDialogFragment.this.etQuestionTitle.getText().toString());
                }
                StickerEditorCommentDialogFragment.this.f7099e.b(StickerEditorCommentDialogFragment.this.f7100f);
                StickerEditorCommentDialogFragment.this.f7098d.a(StickerEditorCommentDialogFragment.this.f7099e);
            }
        });
        this.llAttachVoucher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StickerEditorCommentDialogFragment.this.a(false);
                com.shopee.feeds.feedlibrary.util.a.a(StickerEditorCommentDialogFragment.this.getActivity(), 2);
            }
        });
        this.tvTitleEditHint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StickerEditorCommentDialogFragment.this.a(true);
            }
        });
        this.etQuestionTitle.setFilters(new InputFilter[]{this.f7096b});
        this.etQuestionTitle.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                StickerEditorCommentDialogFragment.this.tvTitleEditHint.setVisibility(charSequence.length() > 0 ? 8 : 0);
            }

            public void afterTextChanged(Editable editable) {
                if (StickerEditorCommentDialogFragment.this.etQuestionTitle.getLineCount() > StickerEditorCommentDialogFragment.this.etQuestionTitle.getMaxLines()) {
                    int lineStart = StickerEditorCommentDialogFragment.this.etQuestionTitle.getLayout().getLineStart(StickerEditorCommentDialogFragment.this.etQuestionTitle.getMaxLines()) - 1;
                    if (TextUtils.isEmpty(StickerEditorCommentDialogFragment.this.f7101g) || lineStart >= StickerEditorCommentDialogFragment.this.f7101g.length()) {
                        String substring = StickerEditorCommentDialogFragment.this.etQuestionTitle.getText().toString().substring(0, lineStart);
                        StickerEditorCommentDialogFragment.this.etQuestionTitle.setText(substring);
                        StickerEditorCommentDialogFragment.this.etQuestionTitle.setSelection(StickerEditorCommentDialogFragment.this.etQuestionTitle.getText().length());
                        String unused = StickerEditorCommentDialogFragment.this.f7101g = substring;
                        return;
                    }
                    StickerEditorCommentDialogFragment.this.etQuestionTitle.setText(StickerEditorCommentDialogFragment.this.f7101g);
                    StickerEditorCommentDialogFragment.this.etQuestionTitle.setSelection(StickerEditorCommentDialogFragment.this.etQuestionTitle.getText().length());
                    return;
                }
                StickerEditorCommentDialogFragment stickerEditorCommentDialogFragment = StickerEditorCommentDialogFragment.this;
                String unused2 = stickerEditorCommentDialogFragment.f7101g = stickerEditorCommentDialogFragment.etQuestionTitle.getText().toString();
            }
        });
        this.etQuestionTitle.setInputType(131072);
        this.etQuestionTitle.setGravity(49);
        this.etQuestionTitle.setSingleLine(false);
        this.etQuestionTitle.setHorizontallyScrolling(false);
        this.etQuestionTitle.setMaxLines(3);
        try {
            b bVar = (b) getArguments().getSerializable("extra_info");
            if (bVar != null) {
                this.f7099e = bVar;
                this.f7100f = bVar.m();
                this.etQuestionTitle.setText(bVar.x());
                this.etQuestionTitle.setSelection(bVar.x().length());
                if (!TextUtils.isEmpty(this.f7100f)) {
                    this.ivVoucherAdd.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.feeds_ic_photo_editor_sticker_comment_attach_voucher_orange));
                    this.tvVoucherAdd.setTextColor(com.garena.android.appkit.tools.b.a(c.b.main_color));
                    this.tvVoucherAdd.setText(com.garena.android.appkit.tools.b.a(c.g.feeds_comment_sticker_edit_voucher_label, this.f7100f));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.doneBtn.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_done));
        this.tvTitleEditHint.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_comment_sticker_title_ask_questions));
        this.tvNotify.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_comment_sticker_tips), new Object[]{5}));
        this.tvAnswerNotifyText.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_comment_sticker_viewers_respond_here));
        this.tvVoucherAdd.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_comment_sticker_attach_voucher));
    }

    public void onResume() {
        super.onResume();
        a(true);
    }

    public void onPause() {
        super.onPause();
        a(false);
    }

    public void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Dialog dialog = getDialog();
        if (!(dialog == null || dialog.getWindow() == null)) {
            dialog.getWindow().setLayout(displayMetrics.widthPixels, -1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        a aVar = this.f7098d;
        if (aVar != null) {
            aVar.a();
        }
        a(true);
    }

    public void onStop() {
        super.onStop();
        a aVar = this.f7098d;
        if (aVar != null) {
            aVar.b();
        }
        a(false);
    }

    public void dismiss() {
        super.dismiss();
    }

    public void onDestroyView() {
        super.onDestroyView();
        org.greenrobot.eventbus.c.a().b(this);
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(PosVoucherEntity posVoucherEntity) {
        if (posVoucherEntity.getType() == 2) {
            VoucherEntity voucherEntity = posVoucherEntity.getVoucherEntity();
            int reward_type = voucherEntity.getReward_type();
            this.f7099e.f(voucherEntity.getPromotion_id());
            this.f7099e.g(voucherEntity.getSignature());
            this.f7099e.h(voucherEntity.getVoucher_code());
            if (reward_type != 0) {
                if (reward_type == 1) {
                    this.f7100f = String.valueOf(voucherEntity.getCoin_percentage_real() + "%");
                }
            } else if (d.a(voucherEntity.getDiscount_value()) || voucherEntity.getDiscount_value().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.f7100f = String.valueOf(voucherEntity.getDiscount_percent()) + "%";
            } else {
                this.f7100f = v.a() + v.b(voucherEntity.getDiscount_value(), 1);
            }
            this.f7099e.b(this.f7100f);
            this.ivVoucherAdd.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.feeds_ic_photo_editor_sticker_comment_attach_voucher_orange));
            this.tvVoucherAdd.setTextColor(com.garena.android.appkit.tools.b.a(c.b.main_color));
            TextView textView = this.tvVoucherAdd;
            textView.setText(this.f7100f + com.garena.android.appkit.tools.b.a(c.g.feeds_comment_sticker_edit_voucher_label, ""));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            f.a().a(new Runnable() {
                public void run() {
                    d.c(StickerEditorCommentDialogFragment.this.f7097c, StickerEditorCommentDialogFragment.this.etQuestionTitle);
                }
            }, 100);
        } else {
            d.a(this.f7097c, this.etQuestionTitle);
        }
    }
}
