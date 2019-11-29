package com.salesforce.android.service.common.ui.internal.utils;

import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class AvatarBranding {
    private ArrayList<Integer> convertToRGB(String str) {
        int i;
        int i2;
        int i3;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (str.length() == 4) {
            i3 = Integer.parseInt(str.substring(1, 2) + str.substring(1, 2), 16);
            i2 = Integer.parseInt(str.substring(2, 3) + str.substring(2, 3), 16);
            i = Integer.parseInt(str.substring(3, 4) + str.substring(3, 4), 16);
        } else {
            if (str.length() != 7) {
                str = str + "00";
            }
            i3 = Integer.parseInt(str.substring(1, 3), 16);
            int parseInt = Integer.parseInt(str.substring(3, 5), 16);
            i = Integer.parseInt(str.substring(5, 7), 16);
            i2 = parseInt;
        }
        arrayList.add(Integer.valueOf(i3));
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i));
        return arrayList;
    }

    private String getColorShade(ArrayList<Integer> arrayList, double d2) {
        String hexString = Integer.toHexString(blend(arrayList.get(0).intValue(), d2));
        String hexString2 = Integer.toHexString(blend(arrayList.get(1).intValue(), d2));
        String hexString3 = Integer.toHexString(blend(arrayList.get(2).intValue(), d2));
        if (hexString.length() == 1) {
            hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString3;
        }
        return "#" + hexString + hexString2 + hexString3;
    }

    private String getAccessibleShade(String str, String str2) {
        ArrayList<Integer> convertToRGB = convertToRGB(str);
        Double calculateLuminance = calculateLuminance(str2);
        Double calculateContrastRatio = calculateContrastRatio(calculateLuminance, calculateLuminance(str));
        while (calculateContrastRatio.doubleValue() < 4.5d) {
            str = getColorShade(convertToRGB, -0.1d);
            convertToRGB = convertToRGB(str);
            calculateContrastRatio = calculateContrastRatio(calculateLuminance, calculateLuminance(str));
        }
        return str;
    }

    private Double calculateLuminance(String str) {
        Double d2;
        ArrayList<Integer> convertToRGB = convertToRGB(str);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = convertToRGB.iterator();
        while (it.hasNext()) {
            Double valueOf = Double.valueOf(Double.valueOf(it.next().doubleValue()).doubleValue() / 255.0d);
            if (valueOf.doubleValue() <= 0.03938d) {
                d2 = Double.valueOf(valueOf.doubleValue() / 12.92d);
            } else {
                d2 = Double.valueOf(Math.pow((valueOf.doubleValue() + 0.055d) / 1.055d, 2.4d));
            }
            arrayList.add(d2);
        }
        return Double.valueOf((((Double) arrayList.get(0)).doubleValue() * 0.2126d) + (((Double) arrayList.get(1)).doubleValue() * 0.7152d) + (((Double) arrayList.get(2)).doubleValue() * 0.0722d));
    }

    private Double calculateContrastRatio(Double d2, Double d3) {
        return Double.valueOf((d2.doubleValue() + 0.05d) / (d3.doubleValue() + 0.05d));
    }

    private int blend(int i, double d2) {
        int i2 = d2 > 0.0d ? 255 : 0;
        double d3 = (double) i;
        Double.isNaN(d3);
        double abs = d3 * (1.0d - Math.abs(d2));
        double d4 = (double) i2;
        double abs2 = Math.abs(d2);
        Double.isNaN(d4);
        return (int) Math.round(abs + (d4 * abs2));
    }

    public ArrayList<String> getAccessibleShades(int i, int i2) {
        String str = "#" + Integer.toHexString(i).substring(2);
        String str2 = "#" + Integer.toHexString(i2).substring(2);
        Double calculateLuminance = calculateLuminance(str);
        ArrayList<String> arrayList = new ArrayList<>();
        Double valueOf = Double.valueOf(0.183d);
        if (calculateLuminance.doubleValue() > valueOf.doubleValue()) {
            str = getAccessibleShade(str, str2);
        }
        arrayList.add(str);
        String colorShade = getColorShade(convertToRGB(str), -0.1d);
        String colorShade2 = getColorShade(convertToRGB(str), 0.1d);
        Double calculateLuminance2 = calculateLuminance(colorShade);
        Double calculateLuminance3 = calculateLuminance(colorShade2);
        while (arrayList.size() < 7) {
            if (calculateLuminance2.doubleValue() > 0.0d || calculateLuminance3.doubleValue() < valueOf.doubleValue()) {
                if (calculateLuminance2.doubleValue() > 0.0d) {
                    arrayList.add(colorShade);
                    colorShade = getColorShade(convertToRGB(colorShade), -0.1d);
                    calculateLuminance2 = calculateLuminance(colorShade);
                }
                if (calculateLuminance3.doubleValue() < valueOf.doubleValue() && arrayList.size() <= 6) {
                    arrayList.add(1, colorShade2);
                    colorShade2 = getColorShade(convertToRGB(colorShade2), 0.1d);
                    calculateLuminance3 = calculateLuminance(colorShade2);
                }
            } else {
                arrayList.add(colorShade);
            }
        }
        sortShades(arrayList);
        return arrayList;
    }

    private void sortShades(ArrayList<String> arrayList) {
        Collections.swap(arrayList, 1, 6);
        Collections.swap(arrayList, 3, 5);
    }
}
