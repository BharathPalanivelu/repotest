package com.shopee.live.livestreaming.ui.view;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.ui.audience.activity.LiveStreamingAudienceActivity;

// renamed from: com.shopee.live.livestreaming.ui.view.b;
//public class b extends androidx.fragment.app.b {
public class classB extends androidx.fragment.app.b {

    /* renamed from: a  reason: collision with root package name */
    private RobotoTextView f29226a;

    /* renamed from: b  reason: collision with root package name */
    private RobotoTextView f29227b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f29228c;

    public static b a(String str, int i) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("mPerCoin", str);
        bundle.putInt("mClaimCount", i);
        bVar.setArguments(bundle);
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.b.transparent)));
            window.requestFeature(1);
        }
        getDialog().setCanceledOnTouchOutside(false);
        View inflate = layoutInflater.inflate(c.f.live_streaming_dialog_claim_coin_success, viewGroup, false);
        this.f29226a = (RobotoTextView) inflate.findViewById(c.e.tv_coin_num);
        this.f29227b = (RobotoTextView) inflate.findViewById(c.e.tv_claim_count);
        this.f29228c = (ImageView) inflate.findViewById(c.e.img_close);
        a();
        this.f29228c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.b();
                b.this.dismiss();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (getActivity() instanceof LiveStreamingAudienceActivity) {
            ((LiveStreamingAudienceActivity) getActivity()).o();
        }
    }

    public void a() {
        if (this.f29227b != null) {
            RobotoTextView robotoTextView = this.f29226a;
            if (robotoTextView != null) {
                robotoTextView.setText(com.garena.android.appkit.tools.b.a(c.g.live_streaming_viewer_cic_claim_success_1, getArguments().getString("mPerCoin", "")));
                this.f29227b.setText(com.garena.android.appkit.tools.b.a(c.g.live_streaming_viewer_cic_claim_success_2, String.valueOf(getArguments().getInt("mClaimCount", 0))));
            }
        }
    }
}
