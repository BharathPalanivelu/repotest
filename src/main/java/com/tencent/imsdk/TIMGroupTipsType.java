package com.tencent.imsdk;

public enum TIMGroupTipsType {
    Join(1),
    Quit(2),
    Kick(3),
    SetAdmin(4),
    CancelAdmin(5),
    ModifyGroupInfo(6),
    ModifyMemberInfo(7);
    
    private int type;

    private TIMGroupTipsType(int i) {
        this.type = 1;
        this.type = i;
    }

    /* access modifiers changed from: package-private */
    public final int getType() {
        return this.type;
    }
}
