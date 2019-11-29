package androidx.core.g.a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f1735a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1736b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1737c;

    public a(int i, d dVar, int i2) {
        this.f1735a = i;
        this.f1736b = dVar;
        this.f1737c = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1735a);
        this.f1736b.a(this.f1737c, bundle);
    }
}
