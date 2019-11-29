package com.shopee.livequiz.data.bean;

import com.shopee.sdk.b.a;
import java.util.HashMap;

public class GameModel extends a implements Cloneable {
    public int correctNum;
    public int eventId;
    public int extraLifeBalance;
    public int extraLifeLimit;
    public HashMap<Integer, GameDataRecord> gameRecords = new HashMap<>(20);
    public boolean isLogin;
    public int issueIndex;
    public int sessionId;
    public int sn;
    public int state;
    public String userName;

    public GameModel clone() {
        try {
            GameModel gameModel = (GameModel) super.clone();
            try {
                gameModel.gameRecords = cloneGameRecords();
                return gameModel;
            } catch (Exception unused) {
                return gameModel;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private HashMap<Integer, GameDataRecord> cloneGameRecords() {
        HashMap<Integer, GameDataRecord> hashMap = new HashMap<>(20);
        for (Integer intValue : this.gameRecords.keySet()) {
            int intValue2 = intValue.intValue();
            hashMap.put(Integer.valueOf(intValue2), this.gameRecords.get(Integer.valueOf(intValue2)).clone());
        }
        return hashMap;
    }
}
