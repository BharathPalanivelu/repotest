package com.shopee.app.ui.tutorial;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.shopee.id.R;
import java.util.ArrayList;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean l = false;
    private final c m = new c();

    public d(Context context) {
        super(context);
        c();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.language_init_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.m);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f25705a = resources.getDimensionPixelSize(R.dimen.dp48);
        this.f25706b = androidx.core.content.b.c(getContext(), R.color.black54);
        this.f25707c = androidx.core.content.b.c(getContext(), R.color.black12);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25708d = (RadioGroup) aVar.internalFindViewById(R.id.radio_group);
        this.f25710f = (Button) aVar.internalFindViewById(R.id.ok);
        this.f25711g = (ImageView) aVar.internalFindViewById(R.id.background);
        ArrayList arrayList = new ArrayList();
        RadioButton radioButton = (RadioButton) aVar.internalFindViewById(R.id.radio_english);
        RadioButton radioButton2 = (RadioButton) aVar.internalFindViewById(R.id.radio_malay);
        RadioButton radioButton3 = (RadioButton) aVar.internalFindViewById(R.id.radio_chinese);
        if (radioButton != null) {
            arrayList.add(radioButton);
        }
        if (radioButton2 != null) {
            arrayList.add(radioButton2);
        }
        if (radioButton3 != null) {
            arrayList.add(radioButton3);
        }
        if (this.f25710f != null) {
            this.f25710f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.b();
                }
            });
        }
        this.f25709e = arrayList;
        a();
    }
}
