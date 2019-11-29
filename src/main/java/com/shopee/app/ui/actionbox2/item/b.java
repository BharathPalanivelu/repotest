package com.shopee.app.ui.actionbox2.item;

import android.content.Context;
import android.view.View;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f19435e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f19436f = new c();

    public b(Context context) {
        super(context);
        a();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f19435e) {
            this.f19435e = true;
            inflate(getContext(), R.layout.item_child_action, this);
            this.f19436f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f19436f);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19431a = (RobotoTextView) aVar.internalFindViewById(R.id.tvTitle);
        this.f19432b = (RobotoTextView) aVar.internalFindViewById(R.id.tvContent);
        this.f19433c = (RobotoTextView) aVar.internalFindViewById(R.id.tvTime);
        this.f19434d = aVar.internalFindViewById(R.id.divider);
    }
}
