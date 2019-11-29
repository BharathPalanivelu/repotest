package com.shopee.app.data.viewmodel;

import android.text.SpannableStringBuilder;
import com.shopee.app.ui.common.e;
import java.util.ArrayList;
import java.util.List;

public class FeedCommentInfo {
    private long cTime;
    private String comment;
    private int commentingUserShopId;
    private String content;
    private SpannableStringBuilder displayString;
    private boolean isOwnerComment;
    private List<e> mentioned = new ArrayList();
    private String nickName;
    private int userId;
    private String userName;
    private String userPortrait;

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

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setcTime(long j) {
        this.cTime = j;
    }

    public long getcTime() {
        return this.cTime;
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
        return this.userName;
    }

    public void setUserPortrait(String str) {
        this.userPortrait = str;
    }

    public String getUserPortrait() {
        return this.userPortrait;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getNickName() {
        return this.nickName;
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
}
