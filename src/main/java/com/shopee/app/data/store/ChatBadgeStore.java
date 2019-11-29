package com.shopee.app.data.store;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.a.c.a;
import com.shopee.app.util.j.b;
import com.shopee.app.util.j.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatBadgeStore extends ay {
    private c<Integer, ChatCount> mCounter = new c<>(this.mPref, "unread_chat3", new a<Map<Integer, ChatCount>>() {
    });
    private c.a.a.a.c mMaxLastReceived = new c.a.a.a.c(this.mPref, "max_last_received_msg", 0);
    private b<Integer> mUnreadChatList = new b<>(this.mPref, "user_chat_users", new a<List<Integer>>() {
    });
    private b<Integer> mUnreadSyncList = new b<>(this.mPref, "unread_sync_list", new a<List<Integer>>() {
    });

    public static class ChatCount {
        public long localLastSeen = 0;
        public Set<Long> messageList = new HashSet();
        public boolean needClear = false;
        public long serverLastSeen = 0;
    }

    public ChatBadgeStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public int getTotalCount() {
        int i = 0;
        for (Integer next : getUnreadChats()) {
            if (next.intValue() >= 0) {
                i += getChatCount(next.intValue());
            }
        }
        return i;
    }

    public int getChatCount(int i) {
        ChatCount b2 = this.mCounter.b(Integer.valueOf(i));
        if (b2 == null) {
            List list = (List) this.mUnreadChatList.a();
            if (list == null || !list.contains(Integer.valueOf(i))) {
                return 0;
            }
            return 1;
        }
        if (b2.messageList.isEmpty()) {
            List list2 = (List) this.mUnreadChatList.a();
            if (list2 != null && list2.contains(Integer.valueOf(i))) {
                return 1;
            }
        }
        return b2.messageList.size();
    }

    public void incrementChatCount(int i, long j) {
        ChatCount b2 = this.mCounter.b(Integer.valueOf(i));
        if (b2 == null) {
            b2 = new ChatCount();
        }
        if (j > b2.serverLastSeen && j > b2.localLastSeen && j > 0 && !b2.messageList.contains(Long.valueOf(j))) {
            b2.messageList.add(Long.valueOf(j));
        }
        this.mCounter.a(Integer.valueOf(i), b2);
        if (j > this.mMaxLastReceived.a()) {
            this.mMaxLastReceived.a(j);
        }
    }

    public void setServerSeen(int i, long j) {
        ChatCount b2 = this.mCounter.b(Integer.valueOf(i));
        if (b2 == null) {
            b2 = new ChatCount();
        }
        HashSet hashSet = new HashSet();
        for (Long next : b2.messageList) {
            if (next.longValue() > j) {
                hashSet.add(next);
            }
        }
        b2.messageList = hashSet;
        b2.serverLastSeen = j;
        this.mCounter.a(Integer.valueOf(i), b2);
        this.mUnreadChatList.c(Integer.valueOf(i));
        this.mUnreadSyncList.c(Integer.valueOf(i));
    }

    public void setLocalSeen(int i, long j) {
        ChatCount b2 = this.mCounter.b(Integer.valueOf(i));
        if (b2 == null) {
            b2 = new ChatCount();
        }
        b2.messageList = new HashSet();
        b2.localLastSeen = j;
        b2.needClear = true;
        this.mCounter.a(Integer.valueOf(i), b2);
        this.mUnreadChatList.c(Integer.valueOf(i));
        this.mUnreadSyncList.c(Integer.valueOf(i));
    }

    public void syncComplete(int i, long j) {
        ChatCount b2 = this.mCounter.b(Integer.valueOf(i));
        if (b2 == null) {
            b2 = new ChatCount();
        }
        if (b2.localLastSeen == j) {
            b2.needClear = false;
            this.mCounter.a(Integer.valueOf(i), b2);
        }
    }

    public long getMaxLastReceived() {
        return this.mMaxLastReceived.a();
    }

    public List<Pair<Integer, Long>> getChatsNeedClear() {
        ArrayList arrayList = new ArrayList();
        Map map = (Map) this.mCounter.a();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (((ChatCount) entry.getValue()).needClear) {
                    arrayList.add(new Pair(entry.getKey(), Long.valueOf(((ChatCount) entry.getValue()).localLastSeen)));
                }
            }
        }
        return arrayList;
    }

    public List<Integer> getUnreadChats() {
        HashSet hashSet = new HashSet();
        Map map = (Map) this.mCounter.a();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (((ChatCount) entry.getValue()).messageList.size() > 0) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        List list = (List) this.mUnreadChatList.a();
        if (list != null) {
            hashSet.addAll(list);
        }
        return new ArrayList(hashSet);
    }

    public void setChatUnreadLocal(int i) {
        this.mUnreadChatList.b(Collections.singletonList(Integer.valueOf(i)));
        this.mUnreadSyncList.b(Collections.singletonList(Integer.valueOf(i)));
    }

    public void setChatUnreadServer(int i) {
        this.mUnreadChatList.b(Collections.singletonList(Integer.valueOf(i)));
        this.mUnreadSyncList.c(Integer.valueOf(i));
    }

    public List<Integer> getUnreadNotSynced() {
        return (List) this.mUnreadSyncList.a();
    }
}
