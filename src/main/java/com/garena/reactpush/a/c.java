package com.garena.reactpush.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.garena.reactpush.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f8313a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f8314b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f8315c;

    /* renamed from: d  reason: collision with root package name */
    private ListView f8316d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f8317e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8318f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Dialog f8319g;
    private TextView h;

    public c(Context context, int i, String str, Throwable th) {
        super(context);
        this.f8315c = str;
        this.f8313a = i;
        this.f8314b = th;
        a(context);
    }

    public void setDialog(Dialog dialog) {
        this.f8319g = dialog;
    }

    private void a(final Context context) {
        inflate(context, a.c.dev_support_layout, this);
        this.h = (TextView) findViewById(a.b.title);
        this.h.setText(this.f8314b.getMessage());
        this.f8317e = (TextView) findViewById(a.b.dismiss_btn);
        this.f8317e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f8319g.dismiss();
            }
        });
        this.f8318f = (TextView) findViewById(a.b.copy_btn);
        this.f8318f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.f8333a.add(c.this.f8315c);
                e.a(context);
                c.this.f8319g.dismiss();
            }
        });
        this.f8316d = (ListView) findViewById(a.b.trace_list);
        a aVar = new a();
        aVar.a((List<StackTraceElement>) Arrays.asList(this.f8314b.getStackTrace()));
        this.f8316d.setAdapter(aVar);
        int i = this.f8313a;
        if (i == 0) {
            setBackgroundColor(Color.parseColor("#E80000"));
        } else if (i == 1) {
            setBackgroundColor(Color.parseColor("#E6B300"));
        }
    }

    public static class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private List<StackTraceElement> f8323a = new ArrayList();

        public long getItemId(int i) {
            return 0;
        }

        public void a(List<StackTraceElement> list) {
            this.f8323a = list;
        }

        public int getCount() {
            return this.f8323a.size();
        }

        /* renamed from: a */
        public StackTraceElement getItem(int i) {
            return this.f8323a.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), a.c.trace_list_item, (ViewGroup) null);
            }
            StackTraceElement a2 = getItem(i);
            ((TextView) view.findViewById(a.b.title)).setText(a2.getMethodName());
            ((TextView) view.findViewById(a.b.sub_title)).setText(a2.getFileName() + ":" + a2.getLineNumber());
            return view;
        }
    }
}
