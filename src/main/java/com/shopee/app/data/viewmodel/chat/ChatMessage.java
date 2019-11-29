package com.shopee.app.data.viewmodel.chat;

import android.text.TextUtils;
import com.facebook.common.internal.Objects;
import com.garena.android.appkit.tools.b;
import com.shopee.app.h.m;
import com.shopee.id.R;
import com.shopee.protocol.shop.ChatMsgOpt;

public class ChatMessage {
    private long chatId;
    private Object data;
    private boolean disallowNegotiate = false;
    private String fromUserAvatar;
    private int fromUserId;
    private String generatedId;
    private String hintText;
    private boolean isOfferAndBuyEnabled = true;
    private boolean isRemote;
    private boolean isTranslationViewExpanded = false;
    private long itemId;
    private String linkUrl;
    private long messageId;
    private long modelId;
    private int opt;
    private long orderId;
    private long pchatId;
    private int position;
    private String requestId;
    private int scamOption;
    private int sendStatus = 3;
    private int shopId;
    private boolean systemMessage;
    private String text;
    private String textContent;
    private int time;
    private int toUserId;
    private ChatMessageTranslationInfo translationInfo;
    private int type;

    public boolean isTW() {
        return true;
    }

    public String getHintText() {
        return TextUtils.isEmpty(this.hintText) ? this.text : this.hintText;
    }

    public void setHintText(String str) {
        this.hintText = str;
    }

    public String getText() {
        return isBlacklistCensored() ? b.e(R.string.sp_label_message_censored) : this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public ChatMessageTranslationInfo getTranslationInfo() {
        return this.translationInfo;
    }

    public void setTranslationInfo(ChatMessageTranslationInfo chatMessageTranslationInfo) {
        this.translationInfo = chatMessageTranslationInfo;
    }

    public boolean isTranslationAvailable() {
        ChatMessageTranslationInfo chatMessageTranslationInfo = this.translationInfo;
        return chatMessageTranslationInfo != null && chatMessageTranslationInfo.isTranslationAvailable();
    }

    public boolean isRemote() {
        return this.isRemote;
    }

    public void setRemote(boolean z) {
        this.isRemote = z;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(int i) {
        this.sendStatus = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(int i) {
        this.toUserId = i;
    }

    public long getChatId() {
        return this.chatId;
    }

    public void setChatId(long j) {
        this.chatId = j;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(long j) {
        this.messageId = j;
    }

    public int getFromUserId() {
        return this.fromUserId;
    }

    public void setFromUserId(int i) {
        this.fromUserId = i;
    }

    public String getFromUserAvatar() {
        return this.fromUserAvatar;
    }

    public void setFromUserAvatar(String str) {
        this.fromUserAvatar = str;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public long getItemId() {
        return this.itemId;
    }

    public boolean isSystemMessage() {
        return this.systemMessage;
    }

    public void setSystemMessage(boolean z) {
        this.systemMessage = z;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public boolean isMyShop() {
        return m.a(this.shopId);
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public long getModelId() {
        return this.modelId;
    }

    public final long getPchatId() {
        return this.pchatId;
    }

    public void setPchatId(long j) {
        this.pchatId = j;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public void setTextContent(String str) {
        this.textContent = str;
    }

    public String getGeneratedId() {
        return this.generatedId;
    }

    public void setGeneratedId(String str) {
        this.generatedId = str;
    }

    public boolean isDisallowNegotiate() {
        return this.disallowNegotiate;
    }

    public void setDisallowNegotiate(boolean z) {
        this.disallowNegotiate = z;
    }

    public void setOfferAndBuyEnabled(boolean z) {
        this.isOfferAndBuyEnabled = z;
    }

    public boolean isOfferAndBuyEnabled() {
        return this.isOfferAndBuyEnabled;
    }

    public boolean hasSameIntention(ChatMessage chatMessage) {
        long j = this.orderId;
        if (j <= 0 || j != chatMessage.getOrderId()) {
            long j2 = this.itemId;
            if (j2 > 0 && j2 == chatMessage.getItemId() && this.shopId == chatMessage.getShopId()) {
                return true;
            }
            return false;
        } else if (this.shopId == chatMessage.getShopId()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isItemIntention() {
        return this.itemId > 0 && this.shopId > 0;
    }

    public boolean isOrderIntention() {
        return this.orderId > 0 && this.shopId > 0;
    }

    public boolean isFromOldClient() {
        return (this.opt & 4) != 4;
    }

    public void setOpt(int i) {
        this.opt = i;
    }

    public boolean isWhitelistCensored() {
        int i = this.opt;
        return i >= 0 && (i & ChatMsgOpt.MSG_OPT_CENSORED_WHITELIST.getValue()) != 0;
    }

    public boolean isBlacklistCensored() {
        int i = this.opt;
        return i >= 0 && (i & ChatMsgOpt.MSG_OPT_CENSORED_BLACKLIST.getValue()) != 0;
    }

    public boolean isForThisChat(int i) {
        return this.fromUserId == i || this.toUserId == i;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public boolean hasServerError() {
        return getSendStatus() == 4;
    }

    public void setScamOption(int i) {
        this.scamOption = i;
    }

    public boolean isScamScanDone() {
        return (this.scamOption & 1) == 1;
    }

    public boolean isScamContent() {
        return ((this.scamOption >> 1) & 1) == 1;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public boolean isTranslationViewExpanded() {
        return this.isTranslationViewExpanded;
    }

    public void setTranslationViewExpanded(boolean z) {
        this.isTranslationViewExpanded = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) obj;
        if (this.isRemote == chatMessage.isRemote && this.type == chatMessage.type && this.sendStatus == chatMessage.sendStatus && this.time == chatMessage.time && this.toUserId == chatMessage.toUserId && this.chatId == chatMessage.chatId && this.messageId == chatMessage.messageId && this.fromUserId == chatMessage.fromUserId && this.orderId == chatMessage.orderId && this.itemId == chatMessage.itemId && this.systemMessage == chatMessage.systemMessage && this.shopId == chatMessage.shopId && this.modelId == chatMessage.modelId && this.pchatId == chatMessage.pchatId && this.disallowNegotiate == chatMessage.disallowNegotiate && this.opt == chatMessage.opt && this.scamOption == chatMessage.scamOption && this.isTranslationViewExpanded == chatMessage.isTranslationViewExpanded && Objects.equal(this.translationInfo, chatMessage.translationInfo) && Objects.equal(this.text, chatMessage.text) && Objects.equal(this.fromUserAvatar, chatMessage.fromUserAvatar) && Objects.equal(this.generatedId, chatMessage.generatedId)) {
            return true;
        }
        return false;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }
}
