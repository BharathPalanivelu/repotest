package com.shopee.app.data.viewmodel;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.shopee.app.ui.common.e;
import java.util.List;

public class ItemCommentInfo {
    private boolean anonymous;
    private int cTime;
    private long cmtId;
    private String comment;
    private int commentListType;
    private int commentingUserShopId;
    private String content;
    private SpannableStringBuilder displayString;
    private int editable;
    private int editableDate;
    private List<String> images;
    private boolean isHidden;
    private boolean isOwnerComment;
    private long itemId;
    private List<e> mentioned;
    private long modelId;
    private String nickName;
    private long orderId;
    private int rating;
    private int ratingStar;
    private int shopId;
    private long snapshotId;
    private int status;
    private int userId;
    private String userName;
    private String userPortrait;
    private String variationName;

    public ItemCommentInfo(String str) {
        this.content = str;
    }

    public ItemCommentInfo() {
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setDisplayString(SpannableStringBuilder spannableStringBuilder) {
        this.displayString = spannableStringBuilder;
    }

    public SpannableStringBuilder getDisplayString() {
        return this.displayString;
    }

    public void setCmtId(long j) {
        this.cmtId = j;
    }

    public long getCmtId() {
        return this.cmtId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public long getModelId() {
        return this.modelId;
    }

    public void setRating(int i) {
        this.rating = i;
    }

    public int getRating() {
        return this.rating;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setCTime(int i) {
        this.cTime = i;
    }

    public int getCTime() {
        return this.cTime;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setMentioned(List<e> list) {
        this.mentioned = list;
    }

    public List<e> getMentioned() {
        return this.mentioned;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserName() {
        if (!isAnonymous()) {
            return this.userName;
        }
        if (TextUtils.isEmpty(this.userName)) {
            return "****";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.userName.charAt(0));
        sb.append("****");
        String str = this.userName;
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    public void setUserPortrait(String str) {
        this.userPortrait = str;
    }

    public String getUserPortrait() {
        return this.userPortrait;
    }

    public boolean isBuyerComment() {
        return this.orderId > 0;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setCommentListType(int i) {
        this.commentListType = i;
    }

    public int getCommentListType() {
        return this.commentListType;
    }

    public int getRatingStar() {
        return this.ratingStar;
    }

    public void setRatingStar(int i) {
        this.ratingStar = i;
    }

    public boolean isOwnerComment() {
        return this.isOwnerComment;
    }

    public void setIsOwnerComment(int i) {
        int i2 = this.commentingUserShopId;
        this.isOwnerComment = i2 != -1 && i2 == i;
    }

    public void setCommentingUserShopId(int i) {
        this.commentingUserShopId = i;
    }

    public void setEditable(int i) {
        this.editable = i;
    }

    public int getEditable() {
        return this.editable;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setAnonymous(boolean z) {
        this.anonymous = z;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public void setEditableDate(int i) {
        this.editableDate = i;
    }

    public int getEditableDate() {
        return this.editableDate;
    }

    public boolean isMyComment(int i) {
        return getUserId() == i;
    }

    public boolean canChangeRating() {
        return getEditable() == 1;
    }

    public boolean hasAlreadyRated() {
        return getEditable() == 2;
    }

    public boolean isNotSetOrExpired() {
        return getEditable() == 0;
    }

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public void setSnapshotId(long j) {
        this.snapshotId = j;
    }

    public void setVariationName(String str) {
        this.variationName = str;
    }

    public String getVariationName() {
        return this.variationName;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public void setHidden(boolean z) {
        this.isHidden = z;
    }

    public ItemCommentInfo getCopy() {
        ItemCommentInfo itemCommentInfo = new ItemCommentInfo();
        itemCommentInfo.content = this.content;
        itemCommentInfo.cmtId = this.cmtId;
        itemCommentInfo.userId = this.userId;
        itemCommentInfo.orderId = this.orderId;
        itemCommentInfo.shopId = this.shopId;
        itemCommentInfo.itemId = this.itemId;
        itemCommentInfo.modelId = this.modelId;
        itemCommentInfo.rating = this.rating;
        itemCommentInfo.comment = this.comment;
        itemCommentInfo.cTime = this.cTime;
        itemCommentInfo.status = this.status;
        itemCommentInfo.mentioned = this.mentioned;
        itemCommentInfo.userName = this.userName;
        itemCommentInfo.userPortrait = this.userPortrait;
        itemCommentInfo.nickName = this.nickName;
        itemCommentInfo.displayString = this.displayString;
        itemCommentInfo.commentListType = this.commentListType;
        itemCommentInfo.ratingStar = this.ratingStar;
        itemCommentInfo.isOwnerComment = this.isOwnerComment;
        itemCommentInfo.commentingUserShopId = this.commentingUserShopId;
        itemCommentInfo.editable = this.editable;
        itemCommentInfo.images = this.images;
        itemCommentInfo.anonymous = this.anonymous;
        itemCommentInfo.editableDate = this.editableDate;
        itemCommentInfo.snapshotId = this.snapshotId;
        itemCommentInfo.variationName = this.variationName;
        itemCommentInfo.isHidden = this.isHidden;
        return itemCommentInfo;
    }
}
