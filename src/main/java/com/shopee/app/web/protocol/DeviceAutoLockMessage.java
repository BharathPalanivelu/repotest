package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;

public final class DeviceAutoLockMessage {
    private final boolean isEnabled;

    public DeviceAutoLockMessage() {
        this(false, 1, (g) null);
    }

    public static /* synthetic */ DeviceAutoLockMessage copy$default(DeviceAutoLockMessage deviceAutoLockMessage, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deviceAutoLockMessage.isEnabled;
        }
        return deviceAutoLockMessage.copy(z);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    public final DeviceAutoLockMessage copy(boolean z) {
        return new DeviceAutoLockMessage(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DeviceAutoLockMessage) {
                if (this.isEnabled == ((DeviceAutoLockMessage) obj).isEnabled) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isEnabled;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "DeviceAutoLockMessage(isEnabled=" + this.isEnabled + SQLBuilder.PARENTHESES_RIGHT;
    }

    public DeviceAutoLockMessage(boolean z) {
        this.isEnabled = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceAutoLockMessage(boolean z, int i, g gVar) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }
}
