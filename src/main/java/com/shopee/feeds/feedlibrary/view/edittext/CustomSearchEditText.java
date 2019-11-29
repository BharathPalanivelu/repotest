package com.shopee.feeds.feedlibrary.view.edittext;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.CaptionTagEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSearchEditText extends a {

    /* renamed from: b  reason: collision with root package name */
    ArrayList<Integer> f28574b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f28575c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f28576d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private int f28577e;

    /* renamed from: f  reason: collision with root package name */
    private int f28578f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f28579g = -1;
    private int h;
    private int i;
    /* access modifiers changed from: private */
    public String j = "";
    /* access modifiers changed from: private */
    public String k = "";
    /* access modifiers changed from: private */
    public String l = "";
    /* access modifiers changed from: private */
    public int m = 400;
    /* access modifiers changed from: private */
    public List<?> n;
    /* access modifiers changed from: private */
    public com.shopee.feeds.feedlibrary.adapter.a o;
    /* access modifiers changed from: private */
    public Handler p = new Handler();
    /* access modifiers changed from: private */
    public Runnable q = new Runnable() {
        public void run() {
            if (!CustomSearchEditText.this.l.equals(CustomSearchEditText.this.k)) {
                CustomSearchEditText customSearchEditText = CustomSearchEditText.this;
                String unused = customSearchEditText.l = customSearchEditText.k;
                if (CustomSearchEditText.this.t != null && !d.a(CustomSearchEditText.this.l)) {
                    CustomSearchEditText.this.t.a(CustomSearchEditText.this.l.toLowerCase(), CustomSearchEditText.this.f28579g);
                }
            }
        }
    };
    private InputFilter[] r = {new InputFilter() {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (!CustomSearchEditText.this.c(charSequence.toString())) {
                u.a(CustomSearchEditText.this.getContext(), String.format(b.e(c.g.feeds_hashtag_limit_tips), new Object[]{30}));
                return "";
            }
            CustomSearchEditText customSearchEditText = CustomSearchEditText.this;
            customSearchEditText.setFilters(customSearchEditText.s);
            return null;
        }
    }};
    /* access modifiers changed from: private */
    public InputFilter[] s = {new InputFilter() {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            return null;
        }
    }};
    /* access modifiers changed from: private */
    public a t;

    public static abstract class a {
        public void a() {
        }

        public void a(Editable editable) {
        }

        public void a(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void a(String str, int i) {
        }

        public void b(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public CustomSearchEditText(Context context) {
        super(context);
        a();
    }

    public CustomSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CustomSearchEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (CustomSearchEditText.this.t != null) {
                    CustomSearchEditText.this.t.a(charSequence, i, i2, i3);
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!charSequence.toString().equals(CustomSearchEditText.this.j)) {
                    String unused = CustomSearchEditText.this.j = charSequence.toString();
                    CustomSearchEditText customSearchEditText = CustomSearchEditText.this;
                    String unused2 = customSearchEditText.k = customSearchEditText.a(charSequence.toString());
                    CustomSearchEditText.this.p.removeCallbacks(CustomSearchEditText.this.q);
                    if (CustomSearchEditText.this.k == null || CustomSearchEditText.this.k.length() <= 0) {
                        String unused3 = CustomSearchEditText.this.l = "";
                        if (CustomSearchEditText.this.n != null) {
                            CustomSearchEditText.this.n.clear();
                            if (CustomSearchEditText.this.o != null) {
                                CustomSearchEditText.this.o.notifyDataSetChanged();
                            }
                            if (CustomSearchEditText.this.t != null) {
                                CustomSearchEditText.this.t.a();
                            }
                        }
                    } else {
                        com.garena.android.appkit.d.a.e("CustomSearchEditText", "word=" + CustomSearchEditText.this.k);
                        CustomSearchEditText.this.p.postDelayed(CustomSearchEditText.this.q, (long) CustomSearchEditText.this.m);
                    }
                    CustomSearchEditText.this.getUerIdFromMap();
                    CustomSearchEditText.this.getHashTagFromContent();
                    if (CustomSearchEditText.this.t != null) {
                        CustomSearchEditText.this.t.b(charSequence, i, i2, i3);
                    }
                }
            }

            public void afterTextChanged(Editable editable) {
                if (CustomSearchEditText.this.t != null) {
                    CustomSearchEditText.this.t.a(editable);
                }
            }
        });
    }

    public void setSearchType(int i2) {
        this.f28578f = i2;
    }

    public void a(CaptionTagEntity captionTagEntity) {
        String str;
        String obj = getText().toString();
        String str2 = "";
        if (this.h <= this.f28577e) {
            a aVar = this.t;
            if (aVar != null) {
                aVar.a();
            }
            String substring = obj.substring(0, this.h);
            if (captionTagEntity.getType() == 2) {
                str2 = "@" + captionTagEntity.getName() + SQLBuilder.BLANK;
                this.f28575c.put(str2, captionTagEntity.getId());
            } else if (captionTagEntity.getType() == 1) {
                str2 = "#" + captionTagEntity.getName() + SQLBuilder.BLANK;
            }
            String substring2 = obj.substring(this.i, obj.length());
            str = substring + str2;
            setText(substring + str2 + substring2);
            getUserIdList();
        } else {
            str = str2;
        }
        getUerIdFromMap();
        getHashTagFromContent();
        int i2 = 500;
        if (str.length() < 500) {
            i2 = str.length();
        }
        setSelection(i2);
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        int i2 = this.f28578f;
        if (i2 == 17) {
            return str;
        }
        if (i2 == 34) {
            a aVar = this.t;
            if (aVar != null) {
                aVar.a();
            }
            this.f28577e = getSelectionStart();
            int i3 = this.f28577e;
            if (i3 > 0) {
                String substring = str.substring(0, i3);
                int lastIndexOf = substring.lastIndexOf("#");
                int lastIndexOf2 = substring.lastIndexOf("@");
                if (a(lastIndexOf, lastIndexOf2, substring.lastIndexOf(SQLBuilder.BLANK), d(substring))) {
                    if (lastIndexOf > lastIndexOf2 && this.f28576d.size() < 30000) {
                        this.f28579g = 1;
                        this.h = lastIndexOf;
                        String substring2 = str.substring(lastIndexOf + 1, substring.length());
                        this.i = this.h + substring2.length() + 1;
                        return substring2;
                    } else if (lastIndexOf2 > lastIndexOf) {
                        this.h = lastIndexOf2;
                        this.f28579g = 2;
                        String substring3 = str.substring(lastIndexOf2 + 1, substring.length());
                        this.i = this.h + substring3.length() + 1;
                        return substring3;
                    }
                }
            }
        }
        return "";
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        if (i2 == -1 && i3 == -1 && i4 == -1) {
            this.f28579g = 0;
        } else if (i2 < i3 && i4 < i3) {
            return true;
        } else {
            if (i2 > i3 && i2 > i5) {
                return true;
            }
            this.f28579g = 0;
        }
        return false;
    }

    public void getUerIdFromMap() {
        this.f28574b.clear();
        String obj = getEditableText().toString();
        if (this.f28575c.size() > 0 && !d.a(obj)) {
            for (Map.Entry next : this.f28575c.entrySet()) {
                com.garena.android.appkit.d.a.e("CustomSearchEditText", "key=" + ((String) next.getKey()));
                if (obj.indexOf((String) next.getKey()) != -1 && !d.a((String) next.getValue())) {
                    com.garena.android.appkit.d.a.e("CustomSearchEditText", "value=" + ((String) next.getValue()));
                    this.f28574b.add(Integer.valueOf((String) next.getValue()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void getHashTagFromContent() {
        this.f28576d.clear();
        String obj = getEditableText().toString();
        if (!d.a(obj)) {
            int indexOf = obj.indexOf("#");
            while (indexOf != -1) {
                com.garena.android.appkit.d.a.e("CustomSearchEditText", "index=" + indexOf);
                obj = obj.substring(indexOf + 1, obj.length());
                com.garena.android.appkit.d.a.e("CustomSearchEditText", "content=" + obj);
                int b2 = b(obj);
                if (b2 > 0) {
                    String substring = obj.substring(0, b2);
                    com.garena.android.appkit.d.a.e("CustomSearchEditText", "topic=" + substring);
                    if (a(substring, true)) {
                        this.f28576d.add(substring);
                    }
                    obj = obj.substring(b2, obj.length());
                } else if (b2 != 0) {
                    if (a(obj, false)) {
                        this.f28576d.add(obj);
                        return;
                    }
                    return;
                }
                indexOf = obj.indexOf("#");
            }
        }
    }

    private boolean a(String str, boolean z) {
        if (!d.a(str) && this.f28576d.size() < 30000 && str.length() <= 30) {
            return true;
        }
        return false;
    }

    private int b(String str) {
        if (!d.a(str)) {
            setFilters(this.s);
            char[] charArray = str.toCharArray();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                if (c(String.valueOf(charArray[i2]))) {
                    return i2;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        if (d.a(str)) {
            return false;
        }
        String replaceAll = str.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×\n]", SQLBuilder.BLANK);
        return replaceAll != null && replaceAll.equals(SQLBuilder.BLANK);
    }

    private int d(String str) {
        if (!d.a(str)) {
            char[] charArray = str.toCharArray();
            for (int length = charArray.length - 1; length >= 0; length--) {
                String valueOf = String.valueOf(charArray[length]);
                if (!valueOf.equals("@") && !valueOf.equals("#") && c(String.valueOf(charArray[length]))) {
                    return length;
                }
            }
        }
        return -1;
    }

    public void a(List<?> list, com.shopee.feeds.feedlibrary.adapter.a aVar) {
        a(list, aVar, this.m);
    }

    public void a(List<?> list, com.shopee.feeds.feedlibrary.adapter.a aVar, int i2) {
        this.n = list;
        this.o = aVar;
        this.m = i2;
    }

    public void setRequestDelay(int i2) {
        this.m = i2;
    }

    public String getCurKeywords() {
        return this.k;
    }

    public void setOnSearchListener(a aVar) {
        this.t = aVar;
    }

    public ArrayList<Integer> getUserIdList() {
        ArrayList<Integer> arrayList = this.f28574b;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getHashTagList() {
        ArrayList<String> arrayList = this.f28576d;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getCurModde() {
        return this.f28579g;
    }
}
