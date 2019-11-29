package com.shopee.app.data.viewmodel;

import android.text.Spanned;
import com.b.a.a.b;
import com.google.a.o;
import com.shopee.app.tracking.impression.a;
import com.shopee.app.util.bm;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ActionContentInfo implements b<ActionContentInfo>, a {
    private static Pattern PLACEHOLDER = Pattern.compile("--\\{(.*?)\\}--");
    private String actionAppPath;
    private int actionCategory;
    private String actionReactNativePath;
    private int actionRedirectType;
    private String actionRedirectUrl;
    private int actionType;
    private String apprl;
    private String avatarImage;
    private int buyerId;
    private long checkoutId;
    private List<ActionContentInfo> childActions = new ArrayList();
    private String content;
    private int createTime;
    private long id;
    List<String> images;
    private long itemId;
    private boolean mExpanded;
    private long mGroupId;
    private int mGroupedCount;
    private boolean mHasChild;
    private boolean mHasParent;
    private long orderId;
    private long refundId;
    private long returnId;
    private int shopId;
    private int showRatingStatus;
    private int taskId;
    private String title;
    private boolean unread;
    private long withdrawalId;

    public int getActionCategory() {
        return this.actionCategory;
    }

    public void setActionCategory(int i) {
        this.actionCategory = i;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public Spanned getContent() {
        return bm.d(this.content);
    }

    public void setContent(String str) {
        this.content = str;
    }

    public int getActionRedirectType() {
        return this.actionRedirectType;
    }

    public void setActionRedirectType(int i) {
        this.actionRedirectType = i;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int i) {
        this.createTime = i;
    }

    public Spanned getTitle() {
        return bm.d(this.title);
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getActionType() {
        return this.actionType;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public long getCheckoutId() {
        return this.checkoutId;
    }

    public void setCheckoutId(long j) {
        this.checkoutId = j;
    }

    public long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(long j) {
        this.refundId = j;
    }

    public long getReturnId() {
        return this.returnId;
    }

    public void setReturnId(long j) {
        this.returnId = j;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public boolean isUnread() {
        return this.unread;
    }

    public void setUnread(boolean z) {
        this.unread = z;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public int getBuyerId() {
        return this.buyerId;
    }

    public void setBuyerId(int i) {
        this.buyerId = i;
    }

    public String getActionRedirectUrl() {
        return this.actionRedirectUrl;
    }

    public void setActionRedirectUrl(String str) {
        this.actionRedirectUrl = str;
    }

    public int getShowRatingStatus() {
        return this.showRatingStatus;
    }

    public void setShowRating(int i) {
        this.showRatingStatus = i;
    }

    public boolean ratingIsNotDefaultOrShown() {
        return (getShowRatingStatus() == -1 || getShowRatingStatus() == 3) ? false : true;
    }

    public String getActionAppPath() {
        return this.actionAppPath;
    }

    public void setActionAppPath(String str) {
        this.actionAppPath = str;
    }

    public String getActionReactNativePath() {
        return this.actionReactNativePath;
    }

    public void setActionReactNativePath(String str) {
        this.actionReactNativePath = str;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public List<ActionContentInfo> getChildList() {
        return this.childActions;
    }

    public void setChildActions(List<ActionContentInfo> list) {
        this.mHasChild = true;
        this.mHasParent = false;
        this.childActions = list;
    }

    public boolean isInitiallyExpanded() {
        return this.mExpanded;
    }

    public void setExpanded(boolean z) {
        this.mExpanded = z;
    }

    public int getGroupedCount() {
        return this.mGroupedCount;
    }

    public void setGroupedCount(int i) {
        this.mGroupedCount = i;
    }

    public long getUnreadId() {
        long j = this.mGroupId;
        return j > 0 ? j : this.id;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ActionContentInfo) && ((ActionContentInfo) obj).getId() == getId();
    }

    public void setAvatarImage(String str) {
        this.avatarImage = str;
    }

    public String getAvatarImage() {
        return this.avatarImage;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public long getWithdrawalId() {
        return this.withdrawalId;
    }

    public void setWithdrawalId(long j) {
        this.withdrawalId = j;
    }

    public void setHasChild(boolean z) {
        this.mHasChild = z;
    }

    public boolean hasChild() {
        return this.mHasChild;
    }

    public void setHasParent(boolean z) {
        this.mHasParent = z;
    }

    public boolean hasParent() {
        return this.mHasParent;
    }

    public String getApprl() {
        return this.apprl;
    }

    public void setApprl(String str) {
        this.apprl = str;
    }

    public String getTrackingImpressionId() {
        return String.valueOf(this.id);
    }

    public o getTrackingImpressionData() {
        o oVar = new o();
        oVar.a("action_id", (Number) Long.valueOf(getId()));
        oVar.a("orderid", (Number) Long.valueOf(getOrderId()));
        oVar.a("is_read", Boolean.valueOf(!isUnread()));
        oVar.a("has_child", Boolean.valueOf(hasChild()));
        oVar.a("has_parent", Boolean.valueOf(hasParent()));
        oVar.a("task_id", (Number) Integer.valueOf(getTaskId()));
        oVar.a("noticode", (Number) Integer.valueOf(getActionType()));
        oVar.a("withdrawal_id", (Number) Long.valueOf(getWithdrawalId()));
        return oVar;
    }
}
