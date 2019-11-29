package com.modiface.mfemakeupkit.widgets;

public enum MFEMakeupZoomArea {
    None,
    LeftEye,
    RightEye,
    LeftCheek,
    RightCheek,
    Lips,
    LeftBrow,
    RightBrow;

    public static String[] getEnumNames() {
        MFEMakeupZoomArea[] values = values();
        String[] strArr = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strArr[i] = values[i].name();
        }
        return strArr;
    }
}
