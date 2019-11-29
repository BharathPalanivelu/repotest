package com.tencent.imsdk;

public class IMCoreProtobufParser {
    private static final String tag = "IMCoreProtobufParser";

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0236  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.imsdk.TIMOfflinePushNotification offlinePush2PushNotification(java.lang.String r13, android.content.Context r14, byte[] r15) {
        /*
            java.lang.String r0 = "IMCoreProtobufParser"
            com.tencent.imsdk.TIMOfflinePushNotification r1 = new com.tencent.imsdk.TIMOfflinePushNotification
            r1.<init>()
            r1.setIdentifier(r13)
            com.tencent.imsdk.protocol.msg_push$ReqBody r2 = new com.tencent.imsdk.protocol.msg_push$ReqBody
            r2.<init>()
            r3 = 1
            r2.mergeFrom((byte[]) r15)     // Catch:{ Throwable -> 0x03e2 }
            com.tencent.imsdk.protocol.msg_common$Msg r4 = r2.msg_msg
            com.tencent.imsdk.protocol.head$MsgHead r4 = r4.msg_msg_head
            com.tencent.imsdk.protocol.head$ContentHead r4 = r4.msg_content_head
            com.tencent.imsdk.protocol.msg_common$Msg r5 = r2.msg_msg
            com.tencent.imsdk.protocol.head$MsgHead r5 = r5.msg_msg_head
            com.tencent.imsdk.protocol.head$RoutineHead r5 = r5.msg_routine_head
            com.tencent.mobileqq.pb.PBUInt32Field r6 = r4.uint32_type
            int r6 = r6.get()
            com.tencent.mobileqq.pb.PBUInt32Field r4 = r4.uint32_subtype
            int r4 = r4.get()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "offline push, msgtype: "
            r7.<init>(r8)
            java.lang.String r8 = java.lang.Integer.toHexString(r6)
            r7.append(r8)
            java.lang.String r8 = "|subtype: "
            r7.append(r8)
            java.lang.String r8 = java.lang.Integer.toHexString(r4)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.tencent.imsdk.log.QLog.d(r0, r3, r7)
            r7 = 6
            if (r4 == r7) goto L_0x0050
            return r1
        L_0x0050:
            com.tencent.imsdk.IMCoreWrapper r4 = com.tencent.imsdk.IMCoreWrapper.get()
            boolean r4 = r4.isIMCoreInited()
            if (r4 != 0) goto L_0x006f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "pushbuf: "
            r4.<init>(r7)
            java.lang.String r15 = com.tencent.imsdk.IMFunc.byte2hex(r15)
            r4.append(r15)
            java.lang.String r15 = r4.toString()
            com.tencent.imsdk.log.QLog.d(r0, r3, r15)
        L_0x006f:
            com.tencent.imsdk.protocol.msg_common$Msg r15 = r2.msg_msg
            com.tencent.imsdk.protocol.head$MsgHead r15 = r15.msg_msg_head
            com.tencent.imsdk.protocol.head$MsgExtraInfo r15 = r15.msg_extra_info
            boolean r0 = r15.has()
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x015b
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r15.uint32_msg_lifetime
            boolean r0 = r0.has()
            if (r0 == 0) goto L_0x008e
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r15.uint32_msg_lifetime
            int r0 = r0.get()
            if (r0 != 0) goto L_0x008e
            return r1
        L_0x008e:
            com.tencent.imsdk.protocol.head$OfflinePushInfo r0 = r15.msg_offline_push_info
            boolean r0 = r0.has()
            if (r0 == 0) goto L_0x0114
            com.tencent.imsdk.protocol.head$OfflinePushInfo r0 = r15.msg_offline_push_info
            com.tencent.mobileqq.pb.MessageMicro r0 = r0.get()
            com.tencent.imsdk.protocol.head$OfflinePushInfo r0 = (com.tencent.imsdk.protocol.head.OfflinePushInfo) r0
            com.tencent.mobileqq.pb.PBUInt32Field r7 = r0.uint32_push_flag
            int r7 = r7.get()
            if (r7 != r3) goto L_0x00a7
            return r1
        L_0x00a7:
            com.tencent.mobileqq.pb.PBBytesField r7 = r0.bytes_desc
            boolean r7 = r7.has()
            if (r7 == 0) goto L_0x00ba
            com.tencent.mobileqq.pb.PBBytesField r7 = r0.bytes_desc
            com.tencent.mobileqq.pb.ByteStringMicro r7 = r7.get()
            java.lang.String r7 = r7.toStringUtf8()
            goto L_0x00bb
        L_0x00ba:
            r7 = r4
        L_0x00bb:
            com.tencent.mobileqq.pb.PBBytesField r8 = r0.bytes_ext
            boolean r8 = r8.has()
            if (r8 == 0) goto L_0x00d0
            com.tencent.mobileqq.pb.PBBytesField r8 = r0.bytes_ext
            com.tencent.mobileqq.pb.ByteStringMicro r8 = r8.get()
            byte[] r8 = r8.toByteArray()
            r1.setExt(r8)
        L_0x00d0:
            com.tencent.imsdk.protocol.head$AndroidOfflineInfo r8 = r0.msg_android_info
            boolean r8 = r8.has()
            if (r8 == 0) goto L_0x00ff
            com.tencent.imsdk.protocol.head$AndroidOfflineInfo r8 = r0.msg_android_info
            com.tencent.mobileqq.pb.MessageMicro r8 = r8.get()
            com.tencent.imsdk.protocol.head$AndroidOfflineInfo r8 = (com.tencent.imsdk.protocol.head.AndroidOfflineInfo) r8
            com.tencent.mobileqq.pb.PBBytesField r9 = r8.bytes_sound
            boolean r9 = r9.has()
            if (r9 == 0) goto L_0x00ff
            com.tencent.mobileqq.pb.PBBytesField r8 = r8.bytes_sound
            com.tencent.mobileqq.pb.ByteStringMicro r8 = r8.get()
            java.lang.String r8 = r8.toStringUtf8()
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x00ff
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r1.setSound(r8)
        L_0x00ff:
            com.tencent.mobileqq.pb.PBBytesField r8 = r0.bytes_title
            boolean r8 = r8.has()
            if (r8 == 0) goto L_0x0112
            com.tencent.mobileqq.pb.PBBytesField r0 = r0.bytes_title
            com.tencent.mobileqq.pb.ByteStringMicro r0 = r0.get()
            java.lang.String r0 = r0.toStringUtf8()
            goto L_0x0116
        L_0x0112:
            r0 = r4
            goto L_0x0116
        L_0x0114:
            r0 = r4
            r7 = r0
        L_0x0116:
            com.tencent.mobileqq.pb.PBBytesField r8 = r15.bytes_identifier
            boolean r8 = r8.has()
            if (r8 == 0) goto L_0x0129
            com.tencent.mobileqq.pb.PBBytesField r8 = r15.bytes_identifier
            com.tencent.mobileqq.pb.ByteStringMicro r8 = r8.get()
            java.lang.String r8 = r8.toStringUtf8()
            goto L_0x012a
        L_0x0129:
            r8 = r4
        L_0x012a:
            com.tencent.mobileqq.pb.PBBytesField r9 = r15.bytes_from_uin_nick
            boolean r9 = r9.has()
            if (r9 == 0) goto L_0x013d
            com.tencent.mobileqq.pb.PBBytesField r9 = r15.bytes_from_uin_nick
            com.tencent.mobileqq.pb.ByteStringMicro r9 = r9.get()
            java.lang.String r9 = r9.toStringUtf8()
            goto L_0x013e
        L_0x013d:
            r9 = r4
        L_0x013e:
            com.tencent.imsdk.protocol.head$UinExtaInfo r10 = r15.msg_uin_extra_info
            boolean r10 = r10.has()
            if (r10 == 0) goto L_0x015f
            com.tencent.imsdk.protocol.head$UinExtaInfo r15 = r15.msg_uin_extra_info
            com.tencent.mobileqq.pb.PBUInt32Field r10 = r15.uint32_msg_flag
            boolean r10 = r10.has()
            if (r10 == 0) goto L_0x015f
            com.tencent.mobileqq.pb.PBUInt32Field r15 = r15.uint32_msg_flag
            int r15 = r15.get()
            long r10 = (long) r15
            r1.setGroupReceiveMsgOpt(r10)
            goto L_0x015f
        L_0x015b:
            r0 = r4
            r7 = r0
            r8 = r7
            r9 = r8
        L_0x015f:
            r15 = 561(0x231, float:7.86E-43)
            r10 = 564(0x234, float:7.9E-43)
            if (r6 != r15) goto L_0x019d
            com.tencent.imsdk.TIMConversationType r15 = com.tencent.imsdk.TIMConversationType.C2C
            r1.setConversationType(r15)
            r1.setConversationId(r8)
            com.tencent.imsdk.protocol.head$C2CInfo r15 = r5.msg_c2c_info
            boolean r5 = r15.has()
            if (r5 == 0) goto L_0x022f
            com.tencent.mobileqq.pb.PBBytesField r5 = r15.bytes_from_uin_nick
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x0188
            com.tencent.mobileqq.pb.PBBytesField r5 = r15.bytes_from_uin_nick
            com.tencent.mobileqq.pb.ByteStringMicro r5 = r5.get()
            java.lang.String r5 = r5.toStringUtf8()
            goto L_0x0189
        L_0x0188:
            r5 = r9
        L_0x0189:
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 == 0) goto L_0x0190
            r0 = r5
        L_0x0190:
            com.tencent.mobileqq.pb.PBUInt64Field r15 = r15.uint64_from_uin
            long r11 = r15.get()
            java.lang.String r15 = java.lang.String.valueOf(r11)
            r9 = r5
            goto L_0x0230
        L_0x019d:
            if (r6 != r10) goto L_0x022f
            com.tencent.imsdk.protocol.head$GroupInfo r15 = r5.msg_group_info
            boolean r5 = r15.has()
            if (r5 == 0) goto L_0x021b
            com.tencent.imsdk.protocol.head$UinExtaInfo r5 = r15.msg_from_uin_extra_info
            com.tencent.mobileqq.pb.MessageMicro r5 = r5.get()
            com.tencent.imsdk.protocol.head$UinExtaInfo r5 = (com.tencent.imsdk.protocol.head.UinExtaInfo) r5
            boolean r11 = r5.has()
            if (r11 == 0) goto L_0x01d9
            com.tencent.mobileqq.pb.PBBytesField r11 = r5.bytes_name_card
            boolean r11 = r11.has()
            if (r11 == 0) goto L_0x01c7
            com.tencent.mobileqq.pb.PBBytesField r9 = r5.bytes_name_card
            com.tencent.mobileqq.pb.ByteStringMicro r9 = r9.get()
            java.lang.String r9 = r9.toStringUtf8()
        L_0x01c7:
            com.tencent.mobileqq.pb.PBBytesField r11 = r5.bytes_user_id
            boolean r11 = r11.has()
            if (r11 == 0) goto L_0x01d9
            com.tencent.mobileqq.pb.PBBytesField r5 = r5.bytes_user_id
            com.tencent.mobileqq.pb.ByteStringMicro r5 = r5.get()
            java.lang.String r8 = r5.toStringUtf8()
        L_0x01d9:
            boolean r5 = android.text.TextUtils.isEmpty(r9)
            if (r5 == 0) goto L_0x01f1
            com.tencent.mobileqq.pb.PBBytesField r5 = r15.bytes_from_uin_nick
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x01f1
            com.tencent.mobileqq.pb.PBBytesField r5 = r15.bytes_from_uin_nick
            com.tencent.mobileqq.pb.ByteStringMicro r5 = r5.get()
            java.lang.String r9 = r5.toStringUtf8()
        L_0x01f1:
            com.tencent.mobileqq.pb.PBBytesField r5 = r15.bytes_group_name
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x0204
            com.tencent.mobileqq.pb.PBBytesField r5 = r15.bytes_group_name
            com.tencent.mobileqq.pb.ByteStringMicro r5 = r5.get()
            java.lang.String r5 = r5.toStringUtf8()
            goto L_0x0205
        L_0x0204:
            r5 = r4
        L_0x0205:
            com.tencent.mobileqq.pb.PBBytesField r11 = r15.bytes_group_id
            boolean r11 = r11.has()
            if (r11 == 0) goto L_0x0218
            com.tencent.mobileqq.pb.PBBytesField r15 = r15.bytes_group_id
            com.tencent.mobileqq.pb.ByteStringMicro r15 = r15.get()
            java.lang.String r15 = r15.toStringUtf8()
            goto L_0x0219
        L_0x0218:
            r15 = r4
        L_0x0219:
            r11 = r15
            goto L_0x021e
        L_0x021b:
            r15 = r4
            r5 = r15
            r11 = r5
        L_0x021e:
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            if (r12 == 0) goto L_0x0225
            r0 = r5
        L_0x0225:
            com.tencent.imsdk.TIMConversationType r5 = com.tencent.imsdk.TIMConversationType.Group
            r1.setConversationType(r5)
            r1.setConversationId(r15)
            r15 = r11
            goto L_0x0230
        L_0x022f:
            r15 = r4
        L_0x0230:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x023a
            java.lang.String r0 = r1.getConversationId()
        L_0x023a:
            com.tencent.imsdk.protocol.msg_common$Msg r2 = r2.msg_msg
            com.tencent.imsdk.protocol.msg$MsgBody r2 = r2.msg_msg_body
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x0246
            goto L_0x0391
        L_0x0246:
            if (r6 != r10) goto L_0x0265
            boolean r5 = android.text.TextUtils.isEmpty(r9)
            if (r5 == 0) goto L_0x0250
            r5 = r8
            goto L_0x0251
        L_0x0250:
            r5 = r9
        L_0x0251:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = ": "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
        L_0x0265:
            com.tencent.imsdk.protocol.msg$RichText r5 = r2.rich_text
            com.tencent.imsdk.protocol.msg$Ptt r5 = r5.ptt
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x0280
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "[语音]"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x0280:
            com.tencent.imsdk.protocol.msg$RichText r5 = r2.rich_text
            com.tencent.imsdk.protocol.msg$NotOnlineFile r5 = r5.not_online_file
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x029b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "[文件]"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x029b:
            com.tencent.imsdk.protocol.msg$RichText r2 = r2.rich_text
            com.tencent.mobileqq.pb.PBRepeatMessageField<com.tencent.imsdk.protocol.msg$Elem> r2 = r2.elems
            java.util.List r2 = r2.get()
            java.util.Iterator r2 = r2.iterator()
            r7 = r4
        L_0x02a8:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0391
            java.lang.Object r4 = r2.next()
            com.tencent.imsdk.protocol.msg$Elem r4 = (com.tencent.imsdk.protocol.msg.Elem) r4
            com.tencent.imsdk.protocol.msg$Text r5 = r4.text
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x02d8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            com.tencent.imsdk.protocol.msg$Text r4 = r4.text
            com.tencent.mobileqq.pb.PBBytesField r4 = r4.str
        L_0x02c8:
            com.tencent.mobileqq.pb.ByteStringMicro r4 = r4.get()
            java.lang.String r4 = r4.toStringUtf8()
            r5.append(r4)
            java.lang.String r7 = r5.toString()
            goto L_0x02a8
        L_0x02d8:
            com.tencent.imsdk.protocol.msg$NotOnlineImage r5 = r4.not_online_image
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x02f2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = "[图片]"
        L_0x02ea:
            r4.append(r5)
            java.lang.String r7 = r4.toString()
            goto L_0x02a8
        L_0x02f2:
            com.tencent.imsdk.protocol.msg$Face r5 = r4.face
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x0305
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = "[表情]"
            goto L_0x02ea
        L_0x0305:
            com.tencent.imsdk.protocol.msg$CustomElem r5 = r4.custom_elem
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x0362
            com.tencent.imsdk.protocol.msg$CustomElem r5 = r4.custom_elem
            com.tencent.mobileqq.pb.PBBytesField r5 = r5.bytes_desc
            com.tencent.mobileqq.pb.ByteStringMicro r5 = r5.get()
            java.lang.String r5 = r5.toStringUtf8()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0344
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            java.lang.String r6 = "["
            r5.append(r6)
            com.tencent.imsdk.protocol.msg$CustomElem r6 = r4.custom_elem
            com.tencent.mobileqq.pb.PBBytesField r6 = r6.bytes_desc
            com.tencent.mobileqq.pb.ByteStringMicro r6 = r6.get()
            java.lang.String r6 = r6.toStringUtf8()
            r5.append(r6)
            java.lang.String r6 = "]"
            r5.append(r6)
            java.lang.String r7 = r5.toString()
        L_0x0344:
            byte[] r5 = r1.getExt()
            if (r5 == 0) goto L_0x0351
            byte[] r5 = r1.getExt()
            int r5 = r5.length
            if (r5 != 0) goto L_0x02a8
        L_0x0351:
            com.tencent.imsdk.protocol.msg$CustomElem r4 = r4.custom_elem
            com.tencent.mobileqq.pb.PBBytesField r4 = r4.bytes_ext
            com.tencent.mobileqq.pb.ByteStringMicro r4 = r4.get()
            byte[] r4 = r4.toByteArray()
            r1.setExt(r4)
            goto L_0x02a8
        L_0x0362:
            com.tencent.imsdk.protocol.msg$LocationInfo r5 = r4.location_info
            boolean r5 = r5.has()
            if (r5 == 0) goto L_0x037d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            java.lang.String r6 = "[位置信息]"
            r5.append(r6)
            com.tencent.imsdk.protocol.msg$LocationInfo r4 = r4.location_info
            com.tencent.mobileqq.pb.PBBytesField r4 = r4.bytes_desc
            goto L_0x02c8
        L_0x037d:
            com.tencent.imsdk.protocol.msg$VideoFile r4 = r4.video_file
            boolean r4 = r4.has()
            if (r4 == 0) goto L_0x02a8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = "[视频]"
            goto L_0x02ea
        L_0x0391:
            r1.setTitle(r0)
            r1.setContent(r7)
            r1.setSenderIdentifier(r8)
            r1.setSenderNickName(r9)
            android.net.Uri r0 = r1.getSound()
            if (r0 != 0) goto L_0x03db
            com.tencent.imsdk.TIMOfflinePushSettings r0 = new com.tencent.imsdk.TIMOfflinePushSettings
            r0.<init>()
            com.tencent.imsdk.IMMsfCoreProxy r2 = com.tencent.imsdk.IMMsfCoreProxy.get()
            boolean r13 = r2.getOfflinePushSettingsFromLocal(r14, r13, r0)
            if (r13 == 0) goto L_0x03db
            com.tencent.imsdk.TIMConversationType r13 = r1.getConversationType()
            com.tencent.imsdk.TIMConversationType r14 = com.tencent.imsdk.TIMConversationType.C2C
            if (r13 != r14) goto L_0x03c8
            android.net.Uri r13 = r0.getC2cMsgRemindSound()
            if (r13 == 0) goto L_0x03c8
            android.net.Uri r13 = r0.getC2cMsgRemindSound()
        L_0x03c4:
            r1.setSound(r13)
            goto L_0x03db
        L_0x03c8:
            com.tencent.imsdk.TIMConversationType r13 = r1.getConversationType()
            com.tencent.imsdk.TIMConversationType r14 = com.tencent.imsdk.TIMConversationType.Group
            if (r13 != r14) goto L_0x03db
            android.net.Uri r13 = r0.getGroupMsgRemindSound()
            if (r13 == 0) goto L_0x03db
            android.net.Uri r13 = r0.getGroupMsgRemindSound()
            goto L_0x03c4
        L_0x03db:
            r1.setTag(r15)
            r1.setIsValid(r3)
            return r1
        L_0x03e2:
            r13 = move-exception
            java.lang.String r13 = com.tencent.imsdk.IMFunc.getExceptionInfo(r13)
            com.tencent.imsdk.log.QLog.e(r0, r3, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.IMCoreProtobufParser.offlinePush2PushNotification(java.lang.String, android.content.Context, byte[]):com.tencent.imsdk.TIMOfflinePushNotification");
    }
}
