package com.shopee.livequiz.data;

import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameDataRecord;
import com.shopee.livequiz.data.bean.GameModel;
import java.util.HashMap;

public class a {
    public static void a(GameModel gameModel, GameData gameData) {
        if (gameModel != null && gameData != null) {
            if (GameData.TYPE_QUEATION.equals(gameData.msg_type)) {
                if (gameModel.gameRecords.get(Integer.valueOf(gameData.msg_body.sn)) == null) {
                    gameModel.gameRecords.put(Integer.valueOf(gameData.msg_body.sn), new GameDataRecord());
                }
                gameModel.gameRecords.get(Integer.valueOf(gameData.msg_body.sn)).question = gameData;
            } else if (GameData.TYPE_ANSWER.equals(gameData.msg_type)) {
                if (gameModel.gameRecords.get(Integer.valueOf(gameData.msg_body.sn)) == null) {
                    gameModel.gameRecords.put(Integer.valueOf(gameData.msg_body.sn), new GameDataRecord());
                }
                gameModel.gameRecords.get(Integer.valueOf(gameData.msg_body.sn)).answer = gameData;
            }
        }
    }

    public static void a(GameModel gameModel, int i, int i2) {
        if (gameModel != null && gameModel.gameRecords.get(Integer.valueOf(i)) != null) {
            gameModel.gameRecords.get(Integer.valueOf(i)).selectAnswerId = i2;
        }
    }

    public static void a(GameModel gameModel, int i) {
        if (gameModel != null && gameModel.gameRecords.get(Integer.valueOf(i)) != null) {
            gameModel.gameRecords.get(Integer.valueOf(i)).useExtraLife = true;
        }
    }

    public static void b(GameModel gameModel, int i) {
        if (gameModel != null && gameModel.gameRecords.get(Integer.valueOf(i)) != null && gameModel.gameRecords.get(Integer.valueOf(i)).useExtraLife) {
            gameModel.gameRecords.get(Integer.valueOf(i)).useExtraLifeFailed = true;
        }
    }

    public static GameData a(GameModel gameModel) {
        GameDataRecord gameDataRecord;
        if (gameModel == null) {
            return null;
        }
        HashMap<Integer, GameDataRecord> hashMap = gameModel.gameRecords;
        int i = -1;
        for (Integer intValue : gameModel.gameRecords.keySet()) {
            int intValue2 = intValue.intValue();
            if (intValue2 > i) {
                i = intValue2;
            }
        }
        if (i == -1) {
            gameDataRecord = null;
        } else {
            gameDataRecord = hashMap.get(Integer.valueOf(i));
        }
        if (gameDataRecord == null) {
            return null;
        }
        return gameDataRecord.question;
    }

    public static GameData b(GameModel gameModel) {
        GameDataRecord gameDataRecord;
        if (gameModel == null) {
            return null;
        }
        HashMap<Integer, GameDataRecord> hashMap = gameModel.gameRecords;
        int i = -1;
        for (Integer intValue : gameModel.gameRecords.keySet()) {
            int intValue2 = intValue.intValue();
            if (intValue2 > i) {
                i = intValue2;
            }
        }
        if (i == -1) {
            gameDataRecord = null;
        } else {
            gameDataRecord = hashMap.get(Integer.valueOf(i));
        }
        if (gameDataRecord == null) {
            return null;
        }
        return gameDataRecord.answer;
    }

    public static GameData c(GameModel gameModel, int i) {
        if (gameModel == null) {
            return null;
        }
        GameDataRecord gameDataRecord = gameModel.gameRecords.get(Integer.valueOf(i));
        if (gameDataRecord == null) {
            return null;
        }
        return gameDataRecord.question;
    }

    public static GameData d(GameModel gameModel, int i) {
        if (gameModel == null) {
            return null;
        }
        GameDataRecord gameDataRecord = gameModel.gameRecords.get(Integer.valueOf(i));
        if (gameDataRecord == null) {
            return null;
        }
        return gameDataRecord.answer;
    }

    public static int e(GameModel gameModel, int i) {
        if (gameModel == null || gameModel.gameRecords.get(Integer.valueOf(i)) == null) {
            return 0;
        }
        return gameModel.gameRecords.get(Integer.valueOf(i)).selectAnswerId;
    }

    public static int c(GameModel gameModel) {
        int i = 0;
        if (gameModel == null) {
            return 0;
        }
        for (Integer intValue : gameModel.gameRecords.keySet()) {
            GameDataRecord gameDataRecord = gameModel.gameRecords.get(Integer.valueOf(intValue.intValue()));
            if (gameDataRecord != null && gameDataRecord.useExtraLife) {
                i++;
            }
        }
        return i;
    }

    public static int d(GameModel gameModel) {
        if (gameModel == null) {
            return 0;
        }
        int c2 = gameModel.extraLifeLimit - c(gameModel);
        int c3 = gameModel.extraLifeBalance - c(gameModel);
        if (Math.min(c3, c2) > 0) {
            return Math.min(c3, c2);
        }
        return 0;
    }

    public static boolean f(GameModel gameModel, int i) {
        if (gameModel == null) {
            return false;
        }
        int i2 = i - 1;
        if (gameModel.gameRecords.get(Integer.valueOf(i2)) != null) {
            return gameModel.gameRecords.get(Integer.valueOf(i2)).useExtraLife;
        }
        return false;
    }

    public static boolean e(GameModel gameModel) {
        if (gameModel == null) {
            return false;
        }
        for (Integer intValue : gameModel.gameRecords.keySet()) {
            GameDataRecord gameDataRecord = gameModel.gameRecords.get(Integer.valueOf(intValue.intValue()));
            if (gameDataRecord != null && gameDataRecord.useExtraLife && gameDataRecord.useExtraLifeFailed) {
                return true;
            }
        }
        return false;
    }

    public static int f(GameModel gameModel) {
        int i = 0;
        if (gameModel == null) {
            return 0;
        }
        for (Integer intValue : gameModel.gameRecords.keySet()) {
            GameDataRecord gameDataRecord = gameModel.gameRecords.get(Integer.valueOf(intValue.intValue()));
            if (!(gameDataRecord == null || gameDataRecord.answer == null || gameDataRecord.answer.msg_body.correct_answer_id != gameDataRecord.selectAnswerId)) {
                i++;
            }
        }
        return i;
    }
}
