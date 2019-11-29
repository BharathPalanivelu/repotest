package com.shopee.app.ui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.shopee.app.a;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.r;
import d.m;
import java.util.ArrayList;
import java.util.Arrays;

public final class n extends FrameLayout implements TimePicker.OnTimeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private int f21594a;

    /* renamed from: b  reason: collision with root package name */
    private TimePicker.OnTimeChangedListener f21595b;

    /* renamed from: c  reason: collision with root package name */
    private final TimePicker f21596c;

    public n(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f21594a = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.TimePickerView, 0, 0);
        this.f21594a = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
        View inflate = View.inflate(context, R.layout.layout_time_picker, (ViewGroup) null);
        if (inflate != null) {
            this.f21596c = (TimePicker) inflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            setLayoutParams(layoutParams);
            addView(this.f21596c, getLayoutParams());
            this.f21596c.setOnTimeChangedListener(this);
            return;
        }
        throw new m("null cannot be cast to non-null type android.widget.TimePicker");
    }

    public final TimePicker getTimePicker() {
        return this.f21596c;
    }

    public final void setIs24HourView(boolean z) {
        this.f21596c.setIs24HourView(Boolean.valueOf(z));
    }

    public final void setCurrentHour(int i) {
        this.f21596c.setCurrentHour(Integer.valueOf(i));
    }

    public final void setCurrentMinute(int i) {
        this.f21596c.setCurrentMinute(Integer.valueOf(i));
    }

    public final int getCurrentHour() {
        Integer currentHour = this.f21596c.getCurrentHour();
        j.a((Object) currentHour, "timePicker.currentHour");
        return currentHour.intValue();
    }

    public final int getCurrentMinute() {
        Integer currentMinute = this.f21596c.getCurrentMinute();
        j.a((Object) currentMinute, "timePicker.currentMinute");
        return a(currentMinute.intValue());
    }

    public final void setOnTimeChangedListener(TimePicker.OnTimeChangedListener onTimeChangedListener) {
        j.b(onTimeChangedListener, "onTimeChangedListener");
        this.f21595b = onTimeChangedListener;
    }

    private final int a(int i) {
        int i2 = this.f21594a;
        if (i2 == -1) {
            return i;
        }
        int i3 = i2 * i;
        if (i3 >= 60) {
            return 0;
        }
        return i3;
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        if (this.f21594a > 0) {
            int a2 = a(i2);
            com.garena.android.appkit.d.a.b("mytimepicker original minute : %d , new minute : %d", Integer.valueOf(i2), Integer.valueOf(a2));
            TimePicker.OnTimeChangedListener onTimeChangedListener = this.f21595b;
            if (onTimeChangedListener != null) {
                onTimeChangedListener.onTimeChanged(timePicker, i, a2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f21594a == -1) {
            this.f21594a = 1;
        }
        try {
            NumberPicker numberPicker = (NumberPicker) this.f21596c.findViewById(Class.forName("com.android.internal.R$id").getField("minute").getInt((Object) null));
            j.a((Object) numberPicker, "minuteSpinner");
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue((60 / this.f21594a) - 1);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < 60) {
                r rVar = r.f32672a;
                Object[] objArr = {Integer.valueOf(i)};
                String format = String.format("%02d", Arrays.copyOf(objArr, objArr.length));
                j.a((Object) format, "java.lang.String.format(format, *args)");
                arrayList.add(format);
                i += this.f21594a;
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                numberPicker.setDisplayedValues((String[]) array);
                return;
            }
            throw new m("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void setInterval(int i) {
        if (i % 5 == 0 && i > 0 && i <= 30) {
            this.f21594a = i;
        }
    }
}
