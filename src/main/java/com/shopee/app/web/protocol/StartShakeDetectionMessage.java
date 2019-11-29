package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class StartShakeDetectionMessage {
    private final Integer sensitivity;

    public static /* synthetic */ StartShakeDetectionMessage copy$default(StartShakeDetectionMessage startShakeDetectionMessage, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = startShakeDetectionMessage.sensitivity;
        }
        return startShakeDetectionMessage.copy(num);
    }

    public final Integer component1() {
        return this.sensitivity;
    }

    public final StartShakeDetectionMessage copy(Integer num) {
        return new StartShakeDetectionMessage(num);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StartShakeDetectionMessage) && j.a((Object) this.sensitivity, (Object) ((StartShakeDetectionMessage) obj).sensitivity);
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.sensitivity;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "StartShakeDetectionMessage(sensitivity=" + this.sensitivity + SQLBuilder.PARENTHESES_RIGHT;
    }

    public StartShakeDetectionMessage(Integer num) {
        this.sensitivity = num;
    }

    public final Integer getSensitivity() {
        return this.sensitivity;
    }
}
