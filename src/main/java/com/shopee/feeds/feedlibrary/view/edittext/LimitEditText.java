package com.shopee.feeds.feedlibrary.view.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.CaptionTagEntity;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.edittext.CustomSearchEditText;
import java.util.ArrayList;

public class LimitEditText extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    a f28584a;

    /* renamed from: b  reason: collision with root package name */
    private CustomSearchEditText f28585b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f28586c;

    /* renamed from: d  reason: collision with root package name */
    private b[] f28587d;

    /* renamed from: e  reason: collision with root package name */
    private int f28588e;

    public interface a {
        void a();

        void a(CharSequence charSequence);

        void a(String str, int i);
    }

    public LimitEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public LimitEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LimitEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28588e = -1;
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_limit_edit_text, this, false);
        this.f28585b = (CustomSearchEditText) inflate.findViewById(c.e.et);
        this.f28586c = (TextView) inflate.findViewById(c.e.tv_tips);
        addView(inflate);
        a();
    }

    private void a() {
        this.f28585b.setOnSearchListener(new CustomSearchEditText.a() {
            public void a(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void b(CharSequence charSequence, int i, int i2, int i3) {
                if (LimitEditText.this.f28584a != null) {
                    LimitEditText.this.f28584a.a(charSequence);
                }
            }

            public void a(Editable editable) {
                LimitEditText.this.a(editable.length());
            }

            public void a(String str, int i) {
                if (LimitEditText.this.f28584a != null) {
                    LimitEditText.this.f28584a.a(str, i);
                }
            }

            public void a() {
                if (LimitEditText.this.f28584a != null) {
                    LimitEditText.this.f28584a.a();
                }
            }
        });
    }

    public void setSearchType(int i) {
        this.f28585b.setSearchType(i);
    }

    public void a(int i) {
        b[] bVarArr = this.f28587d;
        if (bVarArr == null) {
            this.f28586c.setText("");
            return;
        }
        int length = bVarArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            b bVar = bVarArr[i2];
            int i3 = bVar.f28590a;
            int i4 = bVar.f28591b;
            int i5 = bVar.f28593d;
            if (i5 == 0) {
                i4--;
            } else if (i5 == 1) {
                i3++;
            }
            if (i >= i4) {
                u.b(getContext(), String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_caption_length_limit_tips), new Object[]{Integer.valueOf(i4)}));
            }
            if (i < i3 || i > i4) {
                i2++;
            } else {
                if (bVar.f28592c == null) {
                    this.f28586c.setText(i + Constants.URL_PATH_DELIMITER + bVar.f28591b);
                } else {
                    this.f28586c.setText(Html.fromHtml(String.format(bVar.f28592c, new Object[]{Integer.valueOf(bVar.f28591b - i)})));
                }
                z = true;
            }
        }
        if (!z) {
            this.f28586c.setText("");
        }
    }

    public void a(CaptionTagEntity captionTagEntity) {
        this.f28585b.a(captionTagEntity);
    }

    public ArrayList<Integer> getUserIdList() {
        return this.f28585b.getUserIdList();
    }

    public ArrayList<String> getHashTagList() {
        return this.f28585b.getHashTagList();
    }

    public LimitEditText a(String str) {
        this.f28585b.setHint(str);
        return this;
    }

    public LimitEditText b(int i) {
        this.f28585b.setHintTextColor(i);
        return this;
    }

    public LimitEditText c(int i) {
        this.f28585b.setTextColor(i);
        return this;
    }

    public LimitEditText d(int i) {
        CustomSearchEditText customSearchEditText = this.f28585b;
        customSearchEditText.setFilters(new InputFilter[]{customSearchEditText.getInputFilter(), new InputFilter.LengthFilter(i)});
        return this;
    }

    public EditText getEditText() {
        return this.f28585b;
    }

    public String getTextString() {
        return this.f28585b.getText().toString();
    }

    public TextView getTipsText() {
        return this.f28586c;
    }

    public LimitEditText a(b... bVarArr) {
        if (bVarArr == null || bVarArr.length == 0) {
            this.f28587d = null;
            return this;
        }
        this.f28587d = bVarArr;
        return this;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f28590a;

        /* renamed from: b  reason: collision with root package name */
        public int f28591b;

        /* renamed from: c  reason: collision with root package name */
        public String f28592c;

        /* renamed from: d  reason: collision with root package name */
        public int f28593d;

        public b(int i, int i2, String str, int i3) {
            i = i < 0 ? 0 : i;
            i2 = i2 < i ? i : i2;
            this.f28590a = i;
            this.f28591b = i2;
            this.f28592c = str;
            this.f28593d = i3;
        }
    }

    public LimitEditText a(a aVar) {
        this.f28584a = aVar;
        return this;
    }

    public int getMode() {
        return this.f28585b.getCurModde();
    }
}
