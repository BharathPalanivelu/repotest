package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.garena.imageeditor.ImageEditView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {
    private boolean m = false;
    private final c n = new c();

    public f(Context context, String str) {
        super(context, str);
        j();
    }

    public static e a(Context context, String str) {
        f fVar = new f(context, str);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.image_editor_view_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void j() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22917a = (ImageEditView) aVar.internalFindViewById(R.id.editView);
        this.f22918b = (b) aVar.internalFindViewById(R.id.buttonPanel);
        this.f22919c = (AdjustView) aVar.internalFindViewById(R.id.adjustView);
        this.f22920d = (h) aVar.internalFindViewById(R.id.presetTool);
        this.f22921e = aVar.internalFindViewById(R.id.undo_container);
        this.f22922f = (ImageButton) aVar.internalFindViewById(R.id.undo_button);
        this.f22923g = (ImageButton) aVar.internalFindViewById(R.id.redo_button);
        this.h = (ImageButton) aVar.internalFindViewById(R.id.save_button);
        this.i = (ImageButton) aVar.internalFindViewById(R.id.back_button);
        this.j = (TextView) aVar.internalFindViewById(R.id.editor_title);
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.f();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.g();
                }
            });
        }
        if (this.f22922f != null) {
            this.f22922f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.h();
                }
            });
        }
        if (this.f22923g != null) {
            this.f22923g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.i();
                }
            });
        }
        d();
    }
}
