package com.shopee.app.ui.common;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.id.R;
import com.tencent.qcloud.core.util.IOUtils;
import java.lang.ref.WeakReference;

public class TagEditText extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private String f21004a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f21005b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f21006c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21007d = true;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<a> f21008e;

    /* renamed from: f  reason: collision with root package name */
    private e f21009f;

    /* renamed from: g  reason: collision with root package name */
    private TextWatcher f21010g = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            boolean z = true;
            if (TagEditText.this.f21006c == 1 && i3 == 0 && i2 == 1) {
                if (i >= charSequence.length() || charSequence.charAt(i) != '@') {
                    z = false;
                }
                if (z) {
                    int unused = TagEditText.this.f21006c = 2;
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            boolean z = false;
            if (TagEditText.this.f21006c == 0) {
                if (i < charSequence.length() && charSequence.charAt(i) == '@') {
                    z = true;
                }
                if (z && i3 == 1) {
                    int unused = TagEditText.this.f21006c = 1;
                    int unused2 = TagEditText.this.f21005b = i;
                    TagEditText.this.a(i, i3);
                } else if (i3 == 0) {
                    int unused3 = TagEditText.this.f21006c = 3;
                }
            } else if (TagEditText.this.f21006c == 1) {
                if ((i < charSequence.length() ? charSequence.charAt(i) : IOUtils.DIR_SEPARATOR_WINDOWS) == ' ') {
                    int unused4 = TagEditText.this.f21006c = 0;
                    TagEditText.this.b();
                    return;
                }
                try {
                    String charSequence2 = charSequence.subSequence(TagEditText.this.f21005b, TagEditText.this.getSelectionEnd()).toString();
                    if (charSequence2.charAt(0) == '@') {
                        charSequence2 = charSequence2.substring(1);
                    }
                    TagEditText.this.a(charSequence2.toLowerCase().trim());
                } catch (Exception unused5) {
                }
            } else if (TagEditText.this.f21006c == 2) {
                int unused6 = TagEditText.this.f21006c = 0;
                TagEditText.this.b();
            }
        }

        public void afterTextChanged(Editable editable) {
            if (TagEditText.this.f21006c == 3) {
                b d2 = TagEditText.this.getDeletableSpan();
                if (d2 != null) {
                    Editable editableText = TagEditText.this.getEditableText();
                    editableText.replace(editableText.getSpanStart(d2), editableText.getSpanEnd(d2), "");
                }
                int unused = TagEditText.this.f21006c = 0;
            }
        }
    };

    public interface a {
        void a(int i);

        void a(String str);
    }

    public TagEditText(Context context) {
        super(context);
        a();
    }

    public TagEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TagEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        addTextChangedListener(this.f21010g);
    }

    public void a(int i, int i2) {
        this.f21009f = new e();
        this.f21009f.c(i);
        this.f21009f.b(i2);
        c();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.f21004a = str;
        this.f21009f.b(str.length() + 1);
        d();
    }

    /* access modifiers changed from: private */
    public void b() {
        c();
    }

    private void a(b bVar) {
        this.f21007d = false;
        setSelection(getEditableText().getSpanEnd(bVar) + 1);
        this.f21006c = 0;
        this.f21007d = true;
    }

    private void c() {
        WeakReference<a> weakReference = this.f21008e;
        if (weakReference != null && weakReference.get() != null) {
            ((a) this.f21008e.get()).a(this.f21006c);
        }
    }

    private void d() {
        WeakReference<a> weakReference = this.f21008e;
        if (weakReference != null && weakReference.get() != null) {
            ((a) this.f21008e.get()).a(this.f21004a);
        }
    }

    public void a(String str, int i) {
        String trim = str.trim();
        this.f21007d = false;
        Editable editableText = getEditableText();
        this.f21009f.a(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(b(trim));
        spannableStringBuilder.append(SQLBuilder.BLANK);
        int min = Math.min(editableText.length(), this.f21009f.c() + this.f21009f.b());
        this.f21009f.b(trim.length() + 1);
        editableText.replace(this.f21009f.c(), min, spannableStringBuilder);
        setSelection(this.f21009f.c() + spannableStringBuilder.length());
        clearFocus();
        this.f21006c = 0;
        c();
        this.f21007d = true;
    }

    private Spannable b(String str) {
        String str2 = "@" + str;
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new b(this.f21009f), 0, str2.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.garena.android.appkit.tools.b.a(R.color.primary)), 0, str2.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, str2.length(), 33);
        return spannableString;
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.f21006c == 0 && this.f21007d && this.f21009f != null) {
            b spanSelected = getSpanSelected();
            if (spanSelected != null) {
                a(spanSelected);
            }
        }
    }

    private b getSpanSelected() {
        Editable editableText = getEditableText();
        b[] bVarArr = (b[]) editableText.getSpans(0, editableText.length(), b.class);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        for (b bVar : bVarArr) {
            if ((selectionStart > editableText.getSpanStart(bVar) && selectionStart < editableText.getSpanEnd(bVar)) || (selectionEnd > editableText.getSpanStart(bVar) && selectionEnd < editableText.getSpanEnd(bVar))) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public b getDeletableSpan() {
        Editable editableText = getEditableText();
        b[] bVarArr = (b[]) editableText.getSpans(0, editableText.length(), b.class);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        for (b bVar : bVarArr) {
            if ((selectionStart > editableText.getSpanStart(bVar) && selectionStart <= editableText.getSpanEnd(bVar)) || (selectionEnd > editableText.getSpanStart(bVar) && selectionEnd <= editableText.getSpanEnd(bVar))) {
                return bVar;
            }
        }
        return null;
    }

    public void setTagModeChangeListener(a aVar) {
        this.f21008e = new WeakReference<>(aVar);
    }

    public e[] getUserTags() {
        Editable editableText = getEditableText();
        b[] bVarArr = (b[]) editableText.getSpans(0, editableText.length(), b.class);
        e[] eVarArr = new e[bVarArr.length];
        int i = 0;
        for (b bVar : bVarArr) {
            bVar.f21013b.c(editableText.getSpanStart(bVar));
            eVarArr[i] = bVar.f21013b;
            i++;
        }
        return eVarArr;
    }

    class b extends ClickableSpan {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public e f21013b;

        public void onClick(View view) {
        }

        public b(e eVar) {
            this.f21013b = eVar;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }
}
