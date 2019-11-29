package com.shopee.livequiz.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.livequiz.c;

public class AnswerResultProgressView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f29949a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f29950b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f29951c;

    public AnswerResultProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnswerResultProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnswerResultProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = View.inflate(context, c.f.livesdk_shopee_layout_answer_result_progress_bar, this);
        this.f29949a = (ProgressBar) inflate.findViewById(c.d.progress_bar);
        this.f29950b = (TextView) inflate.findViewById(c.d.answer_text);
        this.f29951c = (TextView) inflate.findViewById(c.d.answer_number);
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= 100) {
            this.f29949a.setProgress(i);
        }
    }

    public void setAnswer(String str) {
        this.f29950b.setText(str);
    }

    public void setNum(String str) {
        this.f29951c.setText(str);
    }

    public void setProgressBarDrawable(int i) {
        this.f29949a.setProgressDrawable(b.f(i));
    }
}
