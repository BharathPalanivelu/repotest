package com.shopee.app.data.viewmodel;

import com.shopee.protocol.shop.ItemFlags;
import d.d.b.j;

public final class ItemExtData {
    public static final Companion Companion = new Companion((g) null);
    private final String bannedReason;
    private final int flag;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final boolean isDeList(int i) {
            Companion companion = this;
            return companion.isDeListBySystem(i) || companion.isDeListByUser(i);
        }

        public final boolean isDeListByUser(int i) {
            return (i & ItemFlags.IS_USER_UNLIST.getValue()) == ItemFlags.IS_USER_UNLIST.getValue();
        }

        public final boolean isDeListBySystem(int i) {
            return (i & ItemFlags.IS_SYSTEM_UNLIST.getValue()) == ItemFlags.IS_SYSTEM_UNLIST.getValue();
        }
    }

    public ItemExtData(String str, int i) {
        j.b(str, "bannedReason");
        this.bannedReason = str;
        this.flag = i;
    }

    public final String getBannedReason() {
        return this.bannedReason;
    }

    public final int getFlag() {
        return this.flag;
    }
}
