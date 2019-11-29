package com.garena.android.uikit.a.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public abstract class b extends LinearLayout implements View.OnClickListener {
    public void a() {
    }

    public void b() {
    }

    public void onClick(View view) {
    }

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setClickable(true);
        setOnClickListener(this);
    }
}
