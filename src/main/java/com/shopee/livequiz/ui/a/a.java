package com.shopee.livequiz.ui.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.data.bean.DanmaKuMessage;
import java.util.ArrayList;
import java.util.List;

public class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f29876a;

    /* renamed from: b  reason: collision with root package name */
    private List<DanmaKuMessage> f29877b = new ArrayList();

    /* renamed from: com.shopee.livequiz.ui.a.a$a  reason: collision with other inner class name */
    public interface C0459a {
        void a();
    }

    public a(Context context) {
        this.f29876a = context;
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.f29876a).inflate(c.f.livesdk_shopee_layout_danmaku_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        DanmaKuMessage danmaKuMessage = this.f29877b.get(i);
        if (danmaKuMessage != null) {
            String nickName = danmaKuMessage.getNickName();
            if (nickName.length() > 10) {
                nickName = nickName.substring(0, 9) + "...";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(nickName + "   " + danmaKuMessage.getContent());
            if (nickName != null) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.garena.android.appkit.tools.b.a(c.a.livequiz_text_color_yellow)), 0, nickName.length(), 33);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(com.garena.android.appkit.tools.b.d(c.b.livequiz_danmaku_text_size)), 0, nickName.length(), 33);
                spannableStringBuilder.setSpan(new StyleSpan(2), 0, nickName.length(), 33);
            }
            bVar.f29878a.setText(spannableStringBuilder);
            if (danmaKuMessage.getImageUrl() == null || "".equals(danmaKuMessage.getImageUrl())) {
                com.shopee.livequiz.g.b.a(c.g.livequiz_ic_user_header, c.b.livequiz_danmaku_header_size, c.b.livequiz_danmaku_header_size, bVar.f29879b);
            } else {
                com.shopee.livequiz.g.b.b(danmaKuMessage.getImageUrl(), bVar.f29879b, c.b.livequiz_danmaku_header_size, c.b.livequiz_danmaku_header_size, c.g.livequiz_ic_user_header);
            }
        }
    }

    public int getItemCount() {
        return this.f29877b.size();
    }

    public void a(DanmaKuMessage danmaKuMessage, C0459a aVar) {
        if (danmaKuMessage != null) {
            if (20 == this.f29877b.size()) {
                this.f29877b.remove(0);
                notifyItemRemoved(0);
            }
            int itemCount = getItemCount();
            if (itemCount != -1) {
                this.f29877b.add(itemCount, danmaKuMessage);
                notifyItemInserted(itemCount);
                notifyItemRangeChanged(itemCount, this.f29877b.size() - itemCount);
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    class b extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        TextView f29878a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f29879b;

        b(View view) {
            super(view);
            this.f29878a = (TextView) view.findViewById(c.d.content);
            this.f29879b = (ImageView) view.findViewById(c.d.person_header_image);
        }
    }
}
