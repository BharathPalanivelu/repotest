package com.shopee.livequiz.data.bean;

import com.shopee.sdk.b.a;

public class GameDataRecord extends a implements Cloneable {
    public GameData answer;
    public GameData question;
    public int selectAnswerId;
    public boolean useExtraLife;
    public boolean useExtraLifeFailed;

    public GameDataRecord clone() {
        try {
            return (GameDataRecord) super.clone();
        } catch (Exception unused) {
            return null;
        }
    }
}
