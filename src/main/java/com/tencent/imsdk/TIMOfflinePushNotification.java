package com.tencent.imsdk;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.i;
import com.tencent.imsdk.protocol.im_common;

public class TIMOfflinePushNotification {
    private String content;
    private String conversationId;
    private TIMConversationType conversationType;
    private byte[] ext;
    private String groupName;
    private String identifier;
    private boolean isValid;
    private long opt;
    private String senderIdentifier;
    private String senderNickName;
    private Uri sound;
    private String tag;
    private String title;

    protected TIMOfflinePushNotification() {
        this.opt = 0;
        this.isValid = false;
        this.identifier = "";
    }

    protected TIMOfflinePushNotification(Context context, TIMMessage tIMMessage) {
        String str;
        String str2;
        Uri groupMsgRemindSound;
        StringBuilder sb;
        String str3;
        StringBuilder sb2;
        String desc;
        String sb3;
        this.opt = 0;
        this.isValid = false;
        String str4 = "";
        this.identifier = str4;
        TIMConversationType type = tIMMessage.getConversation().getType();
        if (type != TIMConversationType.C2C && type != TIMConversationType.Group) {
            this.isValid = false;
        } else if (tIMMessage.getMsg().lifetime() == 0) {
            this.isValid = false;
        } else {
            TIMMessageOfflinePushSettings offlinePushSettings = tIMMessage.getOfflinePushSettings();
            if (offlinePushSettings == null) {
                str = str4;
            } else if (!offlinePushSettings.isEnabled()) {
                this.isValid = false;
                return;
            } else {
                setSound(offlinePushSettings.getAndroidSettings().getSound());
                setExt(offlinePushSettings.getExt());
                str = offlinePushSettings.getDescr();
                this.title = offlinePushSettings.getAndroidSettings().getTitle();
            }
            this.opt = tIMMessage.getRecvFlag().getValue();
            setTag(tIMMessage.getConversation().getPeer());
            setConversationType(tIMMessage.getConversation().getType());
            setConversationId(tIMMessage.getConversation().getPeer());
            if (tIMMessage.getSenderProfile() != null) {
                String identifier2 = tIMMessage.getSenderProfile().getIdentifier();
                if (!TextUtils.isEmpty(identifier2)) {
                    setSenderIdentifier(identifier2);
                }
                String nickName = tIMMessage.getSenderProfile().getNickName();
                if (!TextUtils.isEmpty(nickName)) {
                    setSenderNickName(nickName);
                }
            }
            if (tIMMessage.getSenderGroupMemberProfile() != null) {
                String nameCard = tIMMessage.getSenderGroupMemberProfile().getNameCard();
                if (!TextUtils.isEmpty(nameCard)) {
                    setSenderNickName(nameCard);
                }
            }
            setGroupName(tIMMessage.getGroupName());
            if (this.conversationType != TIMConversationType.C2C) {
                if (TextUtils.isEmpty(this.title)) {
                    setTitle(this.groupName);
                }
                String str5 = this.senderNickName;
                str4 = str4 + (TextUtils.isEmpty(str5) ? this.senderIdentifier : str5) + ": ";
            } else if (TextUtils.isEmpty(this.title)) {
                setTitle(this.senderNickName);
            }
            if (TextUtils.isEmpty(this.title)) {
                setTitle(this.conversationId);
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = str4 + str;
            } else {
                for (int i = 0; ((long) i) < tIMMessage.getElementCount(); i++) {
                    TIMElem element = tIMMessage.getElement(i);
                    if (element.getType() == TIMElemType.Sound) {
                        sb = new StringBuilder();
                        sb.append(str4);
                        str3 = "[语音]";
                    } else if (element.getType() == TIMElemType.File) {
                        sb = new StringBuilder();
                        sb.append(str4);
                        str3 = "[文件]";
                    } else {
                        if (element.getType() == TIMElemType.Text) {
                            sb2 = new StringBuilder();
                            sb2.append(str4);
                            desc = ((TIMTextElem) element).getText();
                        } else if (element.getType() == TIMElemType.Image) {
                            sb = new StringBuilder();
                            sb.append(str4);
                            str3 = "[图片]";
                        } else if (element.getType() == TIMElemType.Face) {
                            sb = new StringBuilder();
                            sb.append(str4);
                            str3 = "[表情]";
                        } else {
                            if (element.getType() == TIMElemType.Custom) {
                                TIMCustomElem tIMCustomElem = (TIMCustomElem) element;
                                if (!TextUtils.isEmpty(tIMCustomElem.getDesc())) {
                                    str4 = str4 + "[" + tIMCustomElem.getDesc() + "]";
                                }
                                if (this.ext == null) {
                                    setExt(tIMCustomElem.getExt());
                                }
                            } else if (element.getType() == TIMElemType.Location) {
                                sb2 = new StringBuilder();
                                sb2.append(str4);
                                sb2.append("[位置信息]");
                                desc = ((TIMLocationElem) element).getDesc();
                            } else if (element.getType() == TIMElemType.Video) {
                                sb = new StringBuilder();
                                sb.append(str4);
                                str3 = "[视频]";
                            }
                        }
                        sb2.append(desc);
                        sb3 = sb2.toString();
                        str4 = sb3;
                    }
                    sb.append(str3);
                    sb3 = sb.toString();
                    str4 = sb3;
                }
                str2 = str4;
            }
            setContent(str2);
            if (getSound() == null) {
                TIMOfflinePushSettings tIMOfflinePushSettings = new TIMOfflinePushSettings();
                if (IMMsfCoreProxy.get().getOfflinePushSettingsFromLocal(context, this.identifier, tIMOfflinePushSettings)) {
                    if (this.conversationType != TIMConversationType.C2C || tIMOfflinePushSettings.getC2cMsgRemindSound() == null) {
                        groupMsgRemindSound = (this.conversationType == TIMConversationType.Group && tIMOfflinePushSettings.getGroupMsgRemindSound() != null) ? tIMOfflinePushSettings.getGroupMsgRemindSound() : tIMOfflinePushSettings.getGroupMsgRemindSound();
                    } else {
                        groupMsgRemindSound = tIMOfflinePushSettings.getC2cMsgRemindSound();
                    }
                    setSound(groupMsgRemindSound);
                }
            }
            setIsValid(true);
        }
    }

    public void doNotify(Context context, int i) {
        i.d dVar = new i.d(context.getApplicationContext());
        dVar.a((CharSequence) getTitle());
        dVar.b((CharSequence) getContent());
        dVar.a(i);
        dVar.e((CharSequence) "收到一条新消息");
        dVar.e(true);
        dVar.c(-1);
        if (this.sound != null) {
            dVar.c(6);
            dVar.a(this.sound);
        }
        dVar.a(PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 134217728));
        ((NotificationManager) context.getApplicationContext().getSystemService("notification")).notify(this.tag, im_common.BU_FRIEND, dVar.b());
    }

    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public TIMConversationType getConversationType() {
        return this.conversationType;
    }

    public byte[] getExt() {
        byte[] bArr = this.ext;
        return bArr == null ? "".getBytes() : bArr;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public TIMGroupReceiveMessageOpt getGroupReceiveMsgOpt() {
        for (TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt : TIMGroupReceiveMessageOpt.values()) {
            if (tIMGroupReceiveMessageOpt.getValue() == this.opt) {
                return tIMGroupReceiveMessageOpt;
            }
        }
        return TIMGroupReceiveMessageOpt.ReceiveAndNotify;
    }

    public String getSenderIdentifier() {
        return this.senderIdentifier;
    }

    public String getSenderNickName() {
        return this.senderNickName;
    }

    public Uri getSound() {
        return this.sound;
    }

    public String getTitle() {
        String str = this.title;
        return str == null ? "" : str;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setContent(String str) {
        this.content = str;
    }

    /* access modifiers changed from: package-private */
    public void setConversationId(String str) {
        this.conversationId = str;
    }

    /* access modifiers changed from: package-private */
    public void setConversationType(TIMConversationType tIMConversationType) {
        this.conversationType = tIMConversationType;
    }

    public void setExt(byte[] bArr) {
        if (bArr != null) {
            this.ext = bArr;
        }
    }

    /* access modifiers changed from: package-private */
    public void setGroupName(String str) {
        this.groupName = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupReceiveMsgOpt(long j) {
        this.opt = j;
    }

    /* access modifiers changed from: protected */
    public void setIdentifier(String str) {
        if (str != null) {
            this.identifier = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void setIsValid(boolean z) {
        this.isValid = z;
    }

    /* access modifiers changed from: package-private */
    public void setSenderIdentifier(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.senderIdentifier = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void setSenderNickName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.senderNickName = str;
        }
    }

    public void setSound(Uri uri) {
        if (uri != null) {
            this.sound = uri;
        }
    }

    /* access modifiers changed from: package-private */
    public void setTag(String str) {
        this.tag = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
