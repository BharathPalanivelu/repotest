package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.util.a.e;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;

public class TXLiveNetStatusLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f29166a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f29167b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f29168c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f29169d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f29170e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f29171f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f29172g;
    private String h;
    private ArrayList<String> i;

    public void a(int i2, String str) {
    }

    public TXLiveNetStatusLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TXLiveNetStatusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TXLiveNetStatusLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = new ArrayList<>();
        View inflate = LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_tx_live_status, this, true);
        this.f29166a = (TextView) inflate.findViewById(c.e.tv_status);
        this.f29167b = (TextView) inflate.findViewById(c.e.tv_bitrate_url);
        this.f29168c = (TextView) inflate.findViewById(c.e.tv_bitrate_list);
        this.f29169d = (TextView) inflate.findViewById(c.e.tv_bitrate_ip);
        this.f29170e = (TextView) inflate.findViewById(c.e.tv_bitrate_speed);
        this.f29171f = (TextView) inflate.findViewById(c.e.tv_bitrate_current);
        this.f29172g = (TextView) inflate.findViewById(c.e.tv_bitrate_queue);
    }

    public void a(Bundle bundle, int i2, String str) {
        this.f29166a.setText(e.a(bundle));
        a(i2, str);
    }

    public void a(String str) {
        TextView textView = this.f29167b;
        textView.setText("当前推流地址：" + str);
    }

    public void a(Bundle bundle) {
        this.h = bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
        TextView textView = this.f29169d;
        textView.setText("当前ip：" + this.h);
    }

    public void a() {
        this.f29169d.setText("当前ip：");
    }

    public void b(Bundle bundle) {
        int i2 = bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED);
        TextView textView = this.f29170e;
        textView.setText("当前上传码率速率：" + String.valueOf(i2));
    }

    public void a(int i2) {
        TextView textView = this.f29171f;
        textView.setText("当前测试的码率：" + String.valueOf(i2));
    }

    public void a(ArrayList<LiveStreamingSessionEntity.DefaultPushConfig> arrayList) {
        StringBuilder sb = new StringBuilder("当前需要测试的码率 ：\n");
        if (arrayList.size() > 0) {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                StringBuilder sb2 = new StringBuilder();
                i2++;
                sb2.append(String.valueOf(i2));
                sb2.append(" : ");
                sb2.append(arrayList.get(i2).getBitrate());
                sb2.append("\n");
                sb.append(sb2.toString());
            }
        }
        this.f29168c.setText(sb.toString());
    }

    public void a(int i2, int i3, int i4) {
        this.f29172g.setText(String.format("测速数据：队列个数：%1$d 不佳数：%2$d 连续数：%3$d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
    }
}
