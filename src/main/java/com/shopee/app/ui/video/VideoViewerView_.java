package com.shopee.app.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.garena.videolib.player.PlayerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class VideoViewerView_ extends VideoViewerView implements a, b {
    private boolean j = false;
    private final c k = new c();

    public VideoViewerView_(Context context) {
        super(context);
        e();
    }

    public VideoViewerView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public VideoViewerView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }

    public VideoViewerView_(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        e();
    }

    public static VideoViewerView a(Context context) {
        VideoViewerView_ videoViewerView_ = new VideoViewerView_(context);
        videoViewerView_.onFinishInflate();
        return videoViewerView_;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.video_viewer_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.k);
        c.a((b) this);
        this.f25739g = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_bottom);
        this.h = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_bottom);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25733a = (PlayerView) aVar.internalFindViewById(R.id.player_view);
        this.f25734b = (SeekBar) aVar.internalFindViewById(R.id.video_seekbar);
        this.f25735c = (TextView) aVar.internalFindViewById(R.id.current_time);
        this.f25736d = (TextView) aVar.internalFindViewById(R.id.length);
        this.f25737e = (ImageView) aVar.internalFindViewById(R.id.control);
        this.f25738f = (ViewGroup) aVar.internalFindViewById(R.id.video_player_controls);
        this.i = (CheckBox) aVar.internalFindViewById(R.id.btn_mute);
    }
}
