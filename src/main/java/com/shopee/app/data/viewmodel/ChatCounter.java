package com.shopee.app.data.viewmodel;

import android.content.Context;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bf;
import java.util.HashMap;
import java.util.Map;

public class ChatCounter {
    private Map<Integer, ChatCount> chatCount;
    bf mStore;

    public ChatCounter(Context context) {
        ((ar) context).e().inject(this);
        init();
    }

    private void init() {
        this.chatCount = new HashMap(this.mStore.a());
    }

    public synchronized int getCount(int i) {
        int i2;
        ChatCount chatCount2 = this.chatCount.get(Integer.valueOf(i));
        if (chatCount2 == null) {
            i2 = 0;
        } else {
            i2 = chatCount2.count;
        }
        return i2;
    }

    public synchronized int getCount() {
        int i;
        i = 0;
        for (Map.Entry<Integer, ChatCount> value : this.chatCount.entrySet()) {
            i += ((ChatCount) value.getValue()).count;
        }
        return i;
    }

    public synchronized Map<Integer, ChatCount> getCounter() {
        return new HashMap(this.chatCount);
    }

    private void save() {
        saveInBg(new HashMap(this.chatCount));
    }

    public void saveInBg(Map<Integer, ChatCount> map) {
        this.mStore.a(map);
    }

    public static class ChatCount {
        public int count;
        public long rootId;
        public boolean unread;

        public ChatCount() {
            this.rootId = -1;
            this.unread = true;
            this.count = 0;
        }

        public ChatCount(long j) {
            this.rootId = j;
            this.unread = true;
            this.count = 0;
        }
    }
}
