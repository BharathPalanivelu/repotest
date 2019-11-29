package com.shopee.app.ui.chat2.send;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.id.R;
import java.util.List;

public class ChatShortcutView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f20912a;

    public interface a {
        void F();

        void c(String str);
    }

    public ChatShortcutView(Context context) {
        super(context);
        a(context);
    }

    public ChatShortcutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChatShortcutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public ChatShortcutView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a(Context context) {
        setOrientation(0);
    }

    public void setShortcutList(List<String> list) {
        removeAllViews();
        for (final String next : list) {
            TextView a2 = a();
            a2.setText(next);
            a2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ChatShortcutView.this.f20912a != null) {
                        ChatShortcutView.this.f20912a.c(next);
                    }
                }
            });
        }
        TextView a3 = a();
        a3.setText(b.e(R.string.sp_edit));
        a3.setBackground(b.f(R.drawable.chat_shortcut_edit_tag_background));
        a3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ChatShortcutView.this.f20912a != null) {
                    ChatShortcutView.this.f20912a.F();
                }
            }
        });
    }

    public void setShortcutListener(a aVar) {
        this.f20912a = aVar;
    }

    private TextView a() {
        TextView textView = (TextView) View.inflate(getContext(), R.layout.chat_shortcut_tag, (ViewGroup) null);
        textView.setMaxWidth((int) (((float) b.b()) * 0.8f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = b.a.f7693d;
        layoutParams.rightMargin = b.a.f7693d;
        layoutParams.topMargin = b.a.f7693d;
        layoutParams.bottomMargin = b.a.f7693d;
        addView(textView, layoutParams);
        return textView;
    }
}
