package com.shopee.app.ui.setting.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.a.b;
import com.google.a.f;
import com.google.a.g;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.a;
import com.shopee.id.R;
import d.d.b.j;
import java.util.HashMap;

public final class i extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final f f25138a;

    /* renamed from: b  reason: collision with root package name */
    private long f25139b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f25140c;

    public i(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i) {
        if (this.f25140c == null) {
            this.f25140c = new HashMap();
        }
        View view = (View) this.f25140c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f25140c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f25138a = new g().b().d();
        View.inflate(context, R.layout.theme_preview_text_view_layout, this);
        a();
    }

    private final void a() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
        int i = b.a.k;
        setPadding(i, i, i, i);
    }

    public final void setTitleViewText(o oVar) {
        j.b(oVar, "json");
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.titleTheme);
        j.a((Object) robotoTextView, "titleTheme");
        StringBuilder sb = new StringBuilder();
        l c2 = oVar.c("start_time");
        j.a((Object) c2, "json.get(\"start_time\")");
        sb.append(com.garena.android.appkit.tools.a.a.a(c2.g(), "ID"));
        sb.append(" to ");
        l c3 = oVar.c("end_time");
        j.a((Object) c3, "json.get(\"end_time\")");
        sb.append(com.garena.android.appkit.tools.a.a.a(c3.g(), "ID"));
        robotoTextView.setText(sb.toString());
    }

    public final void setContentViewText(o oVar) {
        j.b(oVar, "json");
        TextView textView = (TextView) a(a.C0250a.tvContent);
        j.a((Object) textView, "tvContent");
        textView.setText(this.f25138a.a(oVar.c("text")));
    }

    public final void setStartTime(o oVar) {
        j.b(oVar, "json");
        l c2 = oVar.c("start_time");
        j.a((Object) c2, "json.get(\"start_time\")");
        this.f25139b = c2.f();
    }

    public final long getStartTime() {
        return this.f25139b;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        a(z);
    }

    private final void a(boolean z) {
        TextView textView = (TextView) a(a.C0250a.tvContent);
        j.a((Object) textView, "tvContent");
        int i = 0;
        textView.setVisibility(z ? 0 : 8);
        ImageView imageView = (ImageView) a(a.C0250a.selected);
        j.a((Object) imageView, "selected");
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }
}
