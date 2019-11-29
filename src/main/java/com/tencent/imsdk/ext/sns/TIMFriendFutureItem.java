package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendFutureItem;
import com.tencent.imcore.FutureType;
import com.tencent.imcore.MapParserBB;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMUserProfile;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TIMFriendFutureItem {
    private String addSource = "";
    private long addTime;
    private String addWording = "";
    private String identifier = "";
    private TIMUserProfile profile;
    private Map<String, String> recommendTags = new HashMap();
    private TIMFutureFriendType type;

    TIMFriendFutureItem(FriendFutureItem friendFutureItem) {
        TIMFutureFriendType tIMFutureFriendType;
        if (friendFutureItem.getEType() == FutureType.FutureTypeRecommend) {
            this.type = TIMFutureFriendType.TIM_FUTURE_FRIEND_RECOMMEND_TYPE;
            int size = (int) friendFutureItem.getMpRecommendTags().size();
            MapParserBB mapParserBB = new MapParserBB();
            mapParserBB.fetchMapKeys(friendFutureItem.getMpRecommendTags());
            this.recommendTags.clear();
            for (int i = 0; i < size; i++) {
                byte[] key = mapParserBB.getKey(i);
                byte[] value = mapParserBB.getValue(friendFutureItem.getMpRecommendTags(), i);
                try {
                    this.recommendTags.put(new String(key, "utf-8"), new String(value, "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            if (friendFutureItem.getEType() == FutureType.FutureTypePendencyComeIn) {
                tIMFutureFriendType = TIMFutureFriendType.TIM_FUTURE_FRIEND_PENDENCY_IN_TYPE;
            } else if (friendFutureItem.getEType() == FutureType.FutureTypePendencySendOut) {
                tIMFutureFriendType = TIMFutureFriendType.TIM_FUTURE_FRIEND_PENDENCY_OUT_TYPE;
            } else {
                if (friendFutureItem.getEType() == FutureType.FutureTypeDecide) {
                    tIMFutureFriendType = TIMFutureFriendType.TIM_FUTURE_FRIEND_DECIDE_TYPE;
                }
                this.addSource = new String(friendFutureItem.getSAddSource(), "utf-8");
                this.addWording = new String(friendFutureItem.getSAddWording(), "utf-8");
            }
            this.type = tIMFutureFriendType;
            try {
                this.addSource = new String(friendFutureItem.getSAddSource(), "utf-8");
                this.addWording = new String(friendFutureItem.getSAddWording(), "utf-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        setIdentifier(friendFutureItem.getSIdentifier());
        setAddTime(friendFutureItem.getDdwAddTime());
        setProfile(IMLiteBridge.userProfileFromInternal(friendFutureItem.getStProfile()));
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

    public TIMUserProfile getProfile() {
        return this.profile;
    }

    public Map<String, String> getRecommendTags() {
        return this.recommendTags;
    }

    public TIMFutureFriendType getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public void setAddSource(String str) {
        this.addSource = str;
    }

    /* access modifiers changed from: package-private */
    public void setAddTime(long j) {
        this.addTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setAddWording(String str) {
        this.addWording = str;
    }

    /* access modifiers changed from: package-private */
    public void setIdentifier(String str) {
        this.identifier = str;
    }

    /* access modifiers changed from: package-private */
    public void setProfile(TIMUserProfile tIMUserProfile) {
        this.profile = tIMUserProfile;
    }

    /* access modifiers changed from: package-private */
    public void setType(TIMFutureFriendType tIMFutureFriendType) {
        this.type = tIMFutureFriendType;
    }
}
