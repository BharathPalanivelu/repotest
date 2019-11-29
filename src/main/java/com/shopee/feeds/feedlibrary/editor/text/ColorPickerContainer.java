package com.shopee.feeds.feedlibrary.editor.text;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.text.a;
import java.util.ArrayList;
import java.util.Iterator;

public class ColorPickerContainer extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f28038a = {c.b.photo_edit_color_picker_1, c.b.photo_edit_color_picker_2, c.b.photo_edit_color_picker_3, c.b.photo_edit_color_picker_4, c.b.photo_edit_color_picker_5, c.b.photo_edit_color_picker_6, c.b.photo_edit_color_picker_7, c.b.photo_edit_color_picker_8, c.b.photo_edit_color_picker_9};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f28039b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f28040c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f28041d;

    public interface a {
        void a(int i);
    }

    public ColorPickerContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorPickerContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28039b = new ArrayList<>();
        this.f28041d = 0;
        setGravity(17);
        for (int i2 : f28038a) {
            final a aVar = new a(getContext());
            aVar.setColorId(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            aVar.setColorPickListener(new a.C0432a() {
                public void a(int i) {
                    if (ColorPickerContainer.this.f28041d != i) {
                        int unused = ColorPickerContainer.this.f28041d = i;
                        if (ColorPickerContainer.this.f28040c != null) {
                            ColorPickerContainer.this.f28040c.a(i);
                        }
                    }
                    aVar.setScaleX(1.2f);
                    aVar.setScaleY(1.2f);
                    Iterator it = ColorPickerContainer.this.f28039b.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        try {
                            if (((Integer) aVar.getTag()).intValue() == i) {
                                aVar.setScaleX(1.2f);
                                aVar.setScaleY(1.2f);
                            } else {
                                aVar.setScaleX(1.0f);
                                aVar.setScaleY(1.0f);
                            }
                        } catch (Exception e2) {
                            com.garena.android.appkit.d.a.a(e2);
                        }
                    }
                }
            });
            addView(aVar, layoutParams);
            aVar.setTag(Integer.valueOf(i2));
            this.f28039b.add(aVar);
            if (i2 == f28038a[0]) {
                aVar.setScaleX(1.2f);
                aVar.setScaleY(1.2f);
            }
        }
    }

    public int getChoseColorId() {
        return this.f28041d;
    }

    public void setColorChangeListener(a aVar) {
        this.f28040c = aVar;
    }
}
