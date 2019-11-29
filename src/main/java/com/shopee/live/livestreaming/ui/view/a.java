package com.shopee.live.livestreaming.ui.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class a extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    Context f29175a;

    /* renamed from: b  reason: collision with root package name */
    TextView f29176b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f29177c;

    /* renamed from: d  reason: collision with root package name */
    SeekBar f29178d;

    /* renamed from: e  reason: collision with root package name */
    TextView f29179e;

    /* renamed from: f  reason: collision with root package name */
    C0441a f29180f;

    /* renamed from: g  reason: collision with root package name */
    private int f29181g;

    /* renamed from: com.shopee.live.livestreaming.ui.view.a$a  reason: collision with other inner class name */
    public interface C0441a {
        void a();

        void a(View view, int i);
    }

    public static a a(int i) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("progress", i);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29181g = getArguments().getInt("progress");
        setStyle(c.h.bottom_sheet_dialog, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.b.transparent)));
            window.requestFeature(1);
        }
        final View inflate = layoutInflater.inflate(c.f.live_streaming_fragment_beauty_progress, viewGroup, false);
        this.f29176b = (TextView) inflate.findViewById(c.e.tv_progress);
        this.f29177c = (LinearLayout) inflate.findViewById(c.e.ll_beauty_progress);
        this.f29178d = (SeekBar) inflate.findViewById(c.e.progress_bar);
        this.f29179e = (TextView) inflate.findViewById(c.e.tv_filter_text);
        this.f29178d.setProgress(this.f29181g);
        b(this.f29181g);
        this.f29178d.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (a.this.f29180f != null) {
                    a.this.f29180f.a(inflate, i);
                    a.this.b(i);
                }
            }
        });
        this.f29179e.setText(b.e(c.g.live_streaming_host_preview_video_filter_title));
        return inflate;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.dimAmount = BitmapDescriptorFactory.HUE_RED;
            attributes.width = getResources().getDisplayMetrics().widthPixels;
            attributes.windowAnimations = c.h.bottom_sheet_dialog_animation;
            window.setAttributes(attributes);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f29175a = activity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        C0441a aVar = this.f29180f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        if (i >= 0) {
            TextView textView = this.f29176b;
            textView.setText(i + "%");
        }
    }

    public void a(C0441a aVar) {
        this.f29180f = aVar;
    }
}
