package com.shopee.feeds.feedlibrary.editor.text;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.text.ColorPickerContainer;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.g;
import com.shopee.feeds.feedlibrary.util.w;

public class TextEditorDialogFragment extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28069a = "TextEditorDialogFragment";

    /* renamed from: b  reason: collision with root package name */
    g f28070b = new g();

    /* renamed from: c  reason: collision with root package name */
    private InputMethodManager f28071c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f28072d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f28073e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f28074f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f28075g;
    /* access modifiers changed from: private */
    public a h;
    @BindView
    ColorPickerContainer mColorPicker;
    @BindView
    TextView mDone;
    @BindView
    AutoSizeEditText mEditText;
    @BindView
    CheckBox mHighLightCheck;
    @BindView
    RelativeLayout rlEditContainer;
    @BindView
    RelativeLayout rlWindowView;

    public interface a {
        void a();

        void a(b bVar);

        void b();
    }

    public static TextEditorDialogFragment a(Activity activity, b bVar, a aVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_info", bVar);
        TextEditorDialogFragment textEditorDialogFragment = new TextEditorDialogFragment();
        textEditorDialogFragment.setArguments(bundle);
        textEditorDialogFragment.a(aVar);
        textEditorDialogFragment.f28072d = activity;
        textEditorDialogFragment.show(activity.getFragmentManager(), f28069a);
        return textEditorDialogFragment;
    }

    public static TextEditorDialogFragment a(Activity activity, a aVar) {
        return a(activity, new b("", ColorPickerContainer.f28038a[0], 0, false, 28), aVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 23) {
            setStyle(0, 16973937);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.f.feeds_layout_photo_editor_add_text_dialog, viewGroup, false);
        ButterKnife.a(this, inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final b bVar = (b) getArguments().getSerializable("extra_info");
        this.f28071c = (InputMethodManager) getActivity().getSystemService("input_method");
        this.mColorPicker.setColorChangeListener(new ColorPickerContainer.a() {
            public void a(int i) {
                int unused = TextEditorDialogFragment.this.f28073e = i;
                if (TextEditorDialogFragment.this.mHighLightCheck.isChecked()) {
                    TextEditorDialogFragment.this.a(i);
                } else {
                    TextEditorDialogFragment.this.b(i);
                }
            }
        });
        this.mEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextEditorDialogFragment.this.mHighLightCheck.isChecked() && editable != null) {
                    editable.setSpan(new BackgroundColorSpan(b.a(TextEditorDialogFragment.this.f28073e)), 0, editable.length(), 33);
                }
            }
        });
        this.mDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.r();
                TextEditorDialogFragment.this.a(false);
                String obj = TextEditorDialogFragment.this.mEditText.getText().toString();
                if (!TextUtils.isEmpty(obj) && TextEditorDialogFragment.this.h != null) {
                    bVar.b(obj);
                    bVar.a(TextEditorDialogFragment.this.mHighLightCheck.isChecked());
                    bVar.b(TextEditorDialogFragment.this.f28074f);
                    bVar.c(TextEditorDialogFragment.this.f28075g);
                    bVar.d(TextEditorDialogFragment.this.mEditText.getIntTextSize());
                    bVar.a(TextEditorDialogFragment.this.mEditText.getCharCountOfSize());
                    TextEditorDialogFragment.this.h.a(bVar);
                }
                TextEditorDialogFragment.this.dismiss();
            }
        });
        this.mHighLightCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    TextEditorDialogFragment textEditorDialogFragment = TextEditorDialogFragment.this;
                    textEditorDialogFragment.a(textEditorDialogFragment.f28073e);
                    return;
                }
                TextEditorDialogFragment textEditorDialogFragment2 = TextEditorDialogFragment.this;
                textEditorDialogFragment2.b(textEditorDialogFragment2.f28073e);
            }
        });
        if (bVar != null) {
            this.mEditText.setText(bVar.m());
            this.f28074f = bVar.n();
            this.f28075g = bVar.o();
            int i = bVar.p() ? this.f28075g : this.f28074f;
            if (i <= 0) {
                i = ColorPickerContainer.f28038a[0];
            }
            this.f28073e = i;
            this.mHighLightCheck.setChecked(bVar.p());
            if (this.mHighLightCheck.isChecked()) {
                a(this.f28073e);
            } else {
                b(this.f28073e);
            }
            this.mEditText.a(bVar.q());
            this.mEditText.setCharCountOfSize(bVar.r());
        }
        this.rlWindowView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (TextEditorDialogFragment.this.getActivity() != null) {
                    Rect rect = new Rect();
                    TextEditorDialogFragment.this.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int b2 = w.b((Context) TextEditorDialogFragment.this.getActivity());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TextEditorDialogFragment.this.rlEditContainer.getLayoutParams();
                    layoutParams.height = (((b2 - (b2 - rect.bottom)) - b.d(c.C0424c.feeds_text_sticker_edit_bottom_bar_height)) - b.d(c.C0424c.feeds_text_sticker_edit_top_bar_height)) - (b.d(c.C0424c.feeds_text_sticker_edit_text_margin) * 2);
                    TextEditorDialogFragment.this.rlEditContainer.setLayoutParams(layoutParams);
                    TextEditorDialogFragment.this.mEditText.setMaxHeight((float) (layoutParams.height - (b.d(c.C0424c.feeds_text_sticker_edit_text_margin) * 2)));
                }
            }
        });
        this.rlWindowView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextEditorDialogFragment.this.mDone.callOnClick();
            }
        });
        this.mDone.setText(b.e(c.g.feeds_button_done));
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
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
        a(true);
    }

    public void onStop() {
        super.onStop();
        a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
        a(false);
    }

    public void dismiss() {
        super.dismiss();
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        this.f28074f = i == ColorPickerContainer.f28038a[0] ? c.b.black : c.b.white;
        this.f28075g = i;
        String obj = this.mEditText.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        spannableStringBuilder.setSpan(new BackgroundColorSpan(b.a(this.f28075g)), 0, obj.length(), 33);
        this.mEditText.setText(spannableStringBuilder);
        this.mEditText.setTextColor(b.a(this.f28074f));
        this.mEditText.setSelection(spannableStringBuilder.length());
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        this.f28074f = i;
        this.f28075g = 0;
        String obj = this.mEditText.getText().toString();
        this.mEditText.setTextColor(b.a(this.f28074f));
        this.mEditText.setText(obj);
        if (!TextUtils.isEmpty(obj)) {
            this.mEditText.setSelection(obj.length());
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.mEditText.setFocusable(true);
            this.mEditText.setFocusableInTouchMode(true);
            this.mEditText.requestFocus();
            f.a().a(new Runnable() {
                public void run() {
                    d.c(TextEditorDialogFragment.this.f28072d, TextEditorDialogFragment.this.mEditText);
                }
            }, 100);
            return;
        }
        d.a(this.f28072d, (EditText) this.mEditText);
    }
}
