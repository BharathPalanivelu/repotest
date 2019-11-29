package com.shopee.app.data.viewmodel;

import com.garena.android.appkit.tools.b;
import com.google.a.o;
import com.shopee.app.h.t;
import com.shopee.app.tracking.impression.a;
import com.shopee.id.R;
import java.util.List;

public class ActivityItemInfo implements a {
    public static final int ACTIVITY_ITEM_FOLLOWING_STATUS_FOLLOWED = 2;
    public static final int ACTIVITY_ITEM_FOLLOWING_STATUS_NOT_FOLLOW = 1;
    public static final int ACTIVITY_ITEM_FOLLOWING_STATUS_UNKNOWN = 0;
    public static final int ACTIVITY_ITEM_TYPE_ACTION_BOX = 2;
    public static final int ACTIVITY_ITEM_TYPE_ACTIVITY = 1;
    public static final int ACTIVITY_ITEM_TYPE_BANNER = 0;
    private int accType;
    private int activityId;
    private int activityItemType;
    private List<BannerData> banners;
    private String comment;
    private long commentId;
    private String contactName;
    private String content;
    private int createTime;
    private long feedId;
    private int followingStatus = 0;
    private int fromUserId;
    private String fromUserName;
    private boolean isBanner;
    private boolean isUnread;
    private long itemId;
    private String itemImage;
    private String itemName;
    private String redirectUrl;
    private int shopId;
    private int type;
    private int updateType;
    private String userAvatar;

    public String wrapMsg() {
        switch (getType()) {
            case 0:
                return b.a(R.string.sp_user_follow_you2, getFromUserName());
            case 1:
                return b.a(R.string.sp_user_like_your_item2, getFromUserName(), getItemName());
            case 2:
                return bindLikedItemUpdate();
            case 3:
                return b.a(R.string.sp_user_mention_you_in_comment2, getFromUserName(), getComment());
            case 4:
                return b.a(R.string.sp_user_comment_on_your_item2, getFromUserName(), getComment());
            case 5:
                return bindFriendJoining();
            case 6:
                return b.a(R.string.sp_user_rate_your_item2, getFromUserName(), getItemName());
            case 7:
                return getContent();
            case 8:
                return b.a(R.string.sp_user_mention_you_in_comment2, getFromUserName(), getComment());
            case 9:
                return b.a(R.string.sp_user_comment_on_your_feed2, getFromUserName(), getComment());
            default:
                return b.e(R.string.sp_activity_item_unsupported);
        }
    }

    private String bindFriendJoining() {
        String fromUserName2 = getFromUserName();
        String contactName2 = getContactName();
        if (getAccType() == 2) {
            return b.a(R.string.sp_facebook_friend_join2, contactName2, fromUserName2);
        }
        return b.a(R.string.sp_contact_friend_join2, contactName2, fromUserName2);
    }

    private String bindLikedItemUpdate() {
        int updateType2 = getUpdateType();
        if (updateType2 == 0) {
            return b.a(R.string.sp_a_has_deleted_b2, getFromUserName(), getItemName());
        } else if (updateType2 == 1) {
            return b.a(R.string.sp_out_of_stock2, getItemName());
        } else if (updateType2 != 2) {
            return b.a(R.string.sp_a_has_updated_b2, getFromUserName(), getItemName());
        } else {
            return b.a(R.string.sp_a_has_updated_b2, getFromUserName(), getItemName());
        }
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setAccType(int i) {
        this.accType = i;
    }

    public int getAccType() {
        return this.accType;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int i) {
        this.createTime = i;
    }

    public int getFromUserId() {
        return this.fromUserId;
    }

    public void setFromUserId(int i) {
        this.fromUserId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public void setCommentId(long j) {
        this.commentId = j;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public String getFromUserName() {
        return this.fromUserName;
    }

    public void setFromUserName(String str) {
        this.fromUserName = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getItemImage() {
        return this.itemImage;
    }

    public void setItemImage(String str) {
        this.itemImage = str;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setBanner(boolean z) {
        this.isBanner = z;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getComment() {
        return this.comment;
    }

    public boolean isUnread() {
        return this.isUnread;
    }

    public List<BannerData> getBanners() {
        return this.banners;
    }

    public void setBanners(List<BannerData> list) {
        this.banners = list;
    }

    public void setUnread(boolean z) {
        this.isUnread = z;
    }

    public int getActivityItemType() {
        return this.activityItemType;
    }

    public void setActivityItemType(int i) {
        this.activityItemType = i;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isUnknown() {
        return this.followingStatus == 0;
    }

    public void setFollowingStatus(int i) {
        this.followingStatus = i;
    }

    public void onUserChangeFollowingStatus(int i) {
        this.followingStatus = i;
        UserBriefInfo a2 = t.a().a(this.fromUserId);
        if (a2 != null) {
            a2.setFollowed(i == 2);
        }
    }

    public boolean isFollowed() {
        return this.followingStatus == 2;
    }

    public long getFeedId() {
        return this.feedId;
    }

    public void setFeedId(long j) {
        this.feedId = j;
    }

    public String getTrackingImpressionId() {
        return String.valueOf(this.activityId);
    }

    public o getTrackingImpressionData() {
        o oVar = new o();
        oVar.a("activity_id", (Number) Integer.valueOf(getActivityId()));
        oVar.a("activity_type", (Number) Integer.valueOf(getType()));
        return oVar;
    }
}
