package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.util.Locale;

public class LocaleConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Locale.class);
    }

    public Object fromString(String str) {
        String str2;
        String str3;
        int[] underscorePositions = underscorePositions(str);
        String str4 = "";
        if (underscorePositions[0] == -1) {
            str3 = str;
            str2 = str4;
        } else if (underscorePositions[1] == -1) {
            str3 = str.substring(0, underscorePositions[0]);
            String str5 = str4;
            str4 = str.substring(underscorePositions[0] + 1);
            str2 = str5;
        } else {
            str3 = str.substring(0, underscorePositions[0]);
            str4 = str.substring(underscorePositions[0] + 1, underscorePositions[1]);
            str2 = str.substring(underscorePositions[1] + 1);
        }
        return new Locale(str3, str4, str2);
    }

    private int[] underscorePositions(String str) {
        int i;
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 == 0) {
                i = 0;
            } else {
                i = iArr[i2 - 1];
            }
            iArr[i2] = str.indexOf(95, i + 1);
        }
        return iArr;
    }
}
