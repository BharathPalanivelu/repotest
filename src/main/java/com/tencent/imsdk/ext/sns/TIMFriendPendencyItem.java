package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendPendencyItem;
import java.io.UnsupportedEncodingException;

public class TIMFriendPendencyItem {
    private String addSource;
    private long addTime;
    private String addWording;
    private String identifier;
    private String nickname;
    TIMPendencyGetType type;

    TIMFriendPendencyItem(FriendPendencyItem friendPendencyItem) {
        try {
            setAddTime(friendPendencyItem.getDdwAddTime());
            setIdentifier(friendPendencyItem.getSIdentifier());
            setType(friendPendencyItem.getIType());
            setAddSource(new String(friendPendencyItem.getSAddSource(), "utf-8"));
            setAddWording(new String(friendPendencyItem.getSAddWording(), "utf-8"));
            setNickname(new String(friendPendencyItem.getSNickname(), "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public String getAddSource() {
        return this.addSource;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getNickname() {
        return this.nickname;
    }

    public TIMPendencyGetType getType() {
        return this.type;
    }

    public void setAddSource(String str) {
        this.addSource = str;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public void setAddWording(String str) {
        this.addWording = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    /* access modifiers changed from: package-private */
    public void setType(int i) {
        TIMPendencyGetType tIMPendencyGetType;
        if (i != 1) {
            if (i == 2) {
                tIMPendencyGetType = TIMPendencyGetType.TIM_PENDENCY_GET_SEND_OUT;
            } else if (i == 3) {
                tIMPendencyGetType = TIMPendencyGetType.TIM_PENDENCY_GET_BOTH;
            }
            this.type = tIMPendencyGetType;
        }
        tIMPendencyGetType = TIMPendencyGetType.TIM_PENDENCY_GET_COME_IN;
        this.type = tIMPendencyGetType;
    }

    public void setType(TIMPendencyGetType tIMPendencyGetType) {
        this.type = tIMPendencyGetType;
    }
}
