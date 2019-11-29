package com.shopee.livequiz.data.bean;

import com.shopee.sdk.b.a;
import java.util.ArrayList;
import java.util.List;

public class LiveParams extends a {
    public static final String CHATROOM_SPIM = "SPIM";
    public static final String CHATROOM_TXCIM = "TXCIM";
    public static final String SYNC_TYPE_APP = "app";
    public static final String SYNC_TYPE_TV = "tv";
    public String accountType = "";
    public int answerPostRetryTimes;
    public int answerPostTimeInterval;
    public int appId;
    public float bonus;
    public int ccuLock;
    public String chatGroup = "";
    public String chatroomType = "";
    public int coinsPool;
    public String deviceId = "";
    public boolean disableChat;
    public int eventId;
    public String eventName = "";
    public int extraLifeBalance;
    public int extraLifeLimit;
    public int extraLifeReviveCountdown;
    public int extraLifeUsed;
    public boolean ifPollingIM;
    public boolean ifTXCIM;
    public long intervalOfPollingIM;
    public int inviteeReward;
    public int inviterReward;
    public String issueGroup = "";
    public String landingPageUrl = "";
    public List<MetaBean> metas = new ArrayList();
    public String playUrl = "";
    public int pollingTimeInterval;
    public int questionNum;
    public int rewardExpire;
    public long sessionEndTime;
    public int sessionId;
    public String shareToken;
    public int showAnswerTime;
    public int showQuizTime;
    public int supportHorizontal;
    public String syncType = "";
    public long timeoutOfPollingIM;
    public String universalLink = "";
    public String userSig = "";

    public static class MetaBean extends a {
        public String meta_key;
        public String meta_type;
        public String meta_value;
    }
}
