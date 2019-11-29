package com.shopee.app.ui.setting.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class SettingTwoLineItemView_ extends a implements a, b {
    private boolean i = false;
    private final c j = new c();

    public SettingTwoLineItemView_(Context context) {
        super(context);
        e();
    }

    public SettingTwoLineItemView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public SettingTwoLineItemView_(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.settings_two_line_item_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.j);
        c.a((b) this);
        this.f25198e = androidx.core.content.b.c(getContext(), R.color.black87);
        this.f25199f = androidx.core.content.b.c(getContext(), R.color.black65);
        this.f25200g = androidx.core.content.b.c(getContext(), R.color.black26);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f25194a = (TextView) aVar.internalFindViewById(R.id.primary_text);
        this.f25195b = (TextView) aVar.internalFindViewById(R.id.secondary_text);
        this.f25196c = (CompoundButton) aVar.internalFindViewById(R.id.checkbox);
        this.f25197d = (TextView) aVar.internalFindViewById(R.id.action_text);
        this.h = aVar.internalFindViewById(R.id.bottom_divider);
        if (this.f25196c != null) {
            this.f25196c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SettingTwoLineItemView_.this.d();
                }
            });
        }
        a();
    }
}
