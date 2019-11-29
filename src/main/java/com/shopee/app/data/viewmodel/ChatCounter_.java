package com.shopee.app.data.viewmodel;

import android.content.Context;
import com.shopee.app.data.viewmodel.ChatCounter;
import java.util.Map;
import org.a.a.a;

public final class ChatCounter_ extends ChatCounter {
    private Context context_;

    private void init_() {
    }

    private ChatCounter_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static ChatCounter_ getInstance_(Context context) {
        return new ChatCounter_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void saveInBg(Map<Integer, ChatCounter.ChatCount> map) {
        final Map<Integer, ChatCounter.ChatCount> map2 = map;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    ChatCounter_.super.saveInBg(map2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
