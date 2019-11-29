package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;

public final class OpenICCamera3Message {
    private final int type;

    public static /* synthetic */ OpenICCamera3Message copy$default(OpenICCamera3Message openICCamera3Message, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = openICCamera3Message.type;
        }
        return openICCamera3Message.copy(i);
    }

    public final int component1() {
        return this.type;
    }

    public final OpenICCamera3Message copy(int i) {
        return new OpenICCamera3Message(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OpenICCamera3Message) {
                if (this.type == ((OpenICCamera3Message) obj).type) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Integer.valueOf(this.type).hashCode();
    }

    public String toString() {
        return "OpenICCamera3Message(type=" + this.type + SQLBuilder.PARENTHESES_RIGHT;
    }

    public OpenICCamera3Message(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
