package com.modiface.mfemakeupkit.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MFEDebugInfo {
    private static final String TAG = "MFEDebugInfo";
    public ConcurrentSkipListMap<String, String> detailedDebugInfoMap = new ConcurrentSkipListMap<>();
    public final String name;
    public ConcurrentSkipListMap<String, String> simpleDebugInfoMap = new ConcurrentSkipListMap<>();
    public ConcurrentSkipListMap<String, MFEDebugInfo> subDebugInfos = new ConcurrentSkipListMap<>();

    public MFEDebugInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("cannot have empty name for MFEDebugInfo");
    }

    private static int getMinimumNumberOfDecimalPlaces(double d2) {
        double abs = Math.abs(d2);
        int i = 0;
        while (abs < 1.0d) {
            abs *= 10.0d;
            i++;
            if (i > 5) {
                return 0;
            }
        }
        return i;
    }

    private boolean hasSubDebugInfo(MFEDebugInfo mFEDebugInfo) {
        for (MFEDebugInfo next : this.subDebugInfos.values()) {
            if (next == mFEDebugInfo) {
                return true;
            }
            if (next != null && next.hasSubDebugInfo(mFEDebugInfo)) {
                return true;
            }
        }
        return false;
    }

    public void addDetailedDebugInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.detailedDebugInfoMap.put(str, str2);
        }
    }

    public void addSimpleDebugInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.simpleDebugInfoMap.put(str, str2);
            this.detailedDebugInfoMap.put(str, str2);
        }
    }

    public void addSubDebugInfo(MFEDebugInfo mFEDebugInfo) {
        if (mFEDebugInfo != null && mFEDebugInfo != this && !mFEDebugInfo.hasSubDebugInfo(this)) {
            this.subDebugInfos.put(mFEDebugInfo.name, mFEDebugInfo);
        }
    }

    public JSONObject getDetailedJson() {
        JSONObject jSONObject = new JSONObject();
        getDetailedJson(jSONObject);
        return jSONObject;
    }

    public String getDetailedStr() {
        return getDetailedStr(0);
    }

    public MFEDebugInfo getNewCopy() {
        return getNewCopy(this.name);
    }

    public JSONObject getSimpleJson() {
        JSONObject jSONObject = new JSONObject();
        getSimpleJson(jSONObject);
        return jSONObject;
    }

    public String getSimpleStr() {
        return getSimpleStr(0);
    }

    private String getDetailedStr(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("    ");
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(this.name);
        sb3.append(":");
        for (Map.Entry next : this.detailedDebugInfoMap.entrySet()) {
            if (next != null) {
                sb3.append(10);
                sb3.append(sb2);
                sb3.append("    ");
                sb3.append((String) next.getKey());
                sb3.append(":  ");
                sb3.append((String) next.getValue());
            }
        }
        for (Map.Entry next2 : this.subDebugInfos.entrySet()) {
            if (next2 != null) {
                MFEDebugInfo mFEDebugInfo = (MFEDebugInfo) next2.getValue();
                if (mFEDebugInfo != null) {
                    sb3.append(10);
                    sb3.append(mFEDebugInfo.getDetailedStr(i + 1));
                }
            }
        }
        return sb3.toString();
    }

    private static int getMinimumNumberOfDecimalPlaces(float f2) {
        float abs = Math.abs(f2);
        int i = 0;
        while (abs < 1.0f) {
            abs *= 10.0f;
            i++;
            if (i > 5) {
                return 0;
            }
        }
        return i;
    }

    private String getSimpleStr(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("    ");
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(this.name);
        sb3.append(":");
        for (Map.Entry next : this.simpleDebugInfoMap.entrySet()) {
            if (next != null) {
                sb3.append(10);
                sb3.append(sb2);
                sb3.append("    ");
                sb3.append((String) next.getKey());
                sb3.append(":  ");
                sb3.append((String) next.getValue());
            }
        }
        for (Map.Entry next2 : this.subDebugInfos.entrySet()) {
            if (next2 != null) {
                MFEDebugInfo mFEDebugInfo = (MFEDebugInfo) next2.getValue();
                if (mFEDebugInfo != null) {
                    sb3.append(10);
                    sb3.append(mFEDebugInfo.getSimpleStr(i + 1));
                }
            }
        }
        return sb3.toString();
    }

    public MFEDebugInfo getNewCopy(String str) {
        MFEDebugInfo mFEDebugInfo = new MFEDebugInfo(str);
        mFEDebugInfo.simpleDebugInfoMap.putAll(this.simpleDebugInfoMap);
        mFEDebugInfo.detailedDebugInfoMap.putAll(this.detailedDebugInfoMap);
        mFEDebugInfo.subDebugInfos.putAll(this.subDebugInfos);
        return mFEDebugInfo;
    }

    private void getDetailedJson(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry next : this.detailedDebugInfoMap.entrySet()) {
                if (next != null) {
                    jSONObject2.putOpt((String) next.getKey(), next.getValue());
                }
            }
            for (Map.Entry next2 : this.subDebugInfos.entrySet()) {
                if (next2 != null) {
                    MFEDebugInfo mFEDebugInfo = (MFEDebugInfo) next2.getValue();
                    if (mFEDebugInfo != null) {
                        mFEDebugInfo.getDetailedJson(jSONObject2);
                    }
                }
            }
            jSONObject.put(this.name, jSONObject2);
        } catch (JSONException e2) {
            Log.e(TAG, "error constructing json for detailed debug info with exception", e2);
        }
    }

    private void getSimpleJson(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry next : this.simpleDebugInfoMap.entrySet()) {
                if (next != null) {
                    jSONObject2.putOpt((String) next.getKey(), next.getValue());
                }
            }
            for (Map.Entry next2 : this.subDebugInfos.entrySet()) {
                if (next2 != null) {
                    MFEDebugInfo mFEDebugInfo = (MFEDebugInfo) next2.getValue();
                    if (mFEDebugInfo != null) {
                        mFEDebugInfo.getSimpleJson(jSONObject2);
                    }
                }
            }
            jSONObject.put(this.name, jSONObject2);
        } catch (JSONException e2) {
            Log.e(TAG, "error constructing json for detailed debug info with exception", e2);
        }
    }

    public void addDetailedDebugInfo(String str, boolean z) {
        addDetailedDebugInfo(str, z ? "yes" : "no");
    }

    public void addDetailedDebugInfo(String str, double d2) {
        Locale locale = Locale.CANADA;
        addDetailedDebugInfo(str, String.format(locale, "%." + (getMinimumNumberOfDecimalPlaces(d2) + 2) + "f", new Object[]{Double.valueOf(d2)}));
    }

    public void addSimpleDebugInfo(String str, boolean z) {
        addSimpleDebugInfo(str, z ? "yes" : "no");
    }

    public void addSimpleDebugInfo(String str, double d2) {
        Locale locale = Locale.CANADA;
        addSimpleDebugInfo(str, String.format(locale, "%." + (getMinimumNumberOfDecimalPlaces(d2) + 2) + "f", new Object[]{Double.valueOf(d2)}));
    }

    public void addDetailedDebugInfo(String str, float f2) {
        Locale locale = Locale.CANADA;
        addDetailedDebugInfo(str, String.format(locale, "%." + (getMinimumNumberOfDecimalPlaces(f2) + 2) + "f", new Object[]{Float.valueOf(f2)}));
    }

    public void addSimpleDebugInfo(String str, float f2) {
        Locale locale = Locale.CANADA;
        addSimpleDebugInfo(str, String.format(locale, "%." + (getMinimumNumberOfDecimalPlaces(f2) + 2) + "f", new Object[]{Float.valueOf(f2)}));
    }

    public void addDetailedDebugInfo(String str, int i) {
        addDetailedDebugInfo(str, String.valueOf(i));
    }

    public void addDetailedDebugInfo(String str, long j) {
        addDetailedDebugInfo(str, String.valueOf(j));
    }

    public void addSimpleDebugInfo(String str, int i) {
        addSimpleDebugInfo(str, String.valueOf(i));
    }

    public void addSimpleDebugInfo(String str, long j) {
        addSimpleDebugInfo(str, String.valueOf(j));
    }
}
