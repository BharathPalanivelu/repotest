package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzr;
import com.google.android.gms.internal.vision.zzx;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzx[] zzdb;
    private List<Line> zzdc;
    private String zzdd;
    private Rect zzde;

    TextBlock(SparseArray<zzx> sparseArray) {
        this.zzdb = new zzx[sparseArray.size()];
        int i = 0;
        while (true) {
            zzx[] zzxArr = this.zzdb;
            if (i < zzxArr.length) {
                zzxArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    public Rect getBoundingBox() {
        if (this.zzde == null) {
            this.zzde = zzc.zza((Text) this);
        }
        return this.zzde;
    }

    public List<? extends Text> getComponents() {
        zzx[] zzxArr = this.zzdb;
        if (zzxArr.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzdc == null) {
            this.zzdc = new ArrayList(zzxArr.length);
            for (zzx line : this.zzdb) {
                this.zzdc.add(new Line(line));
            }
        }
        return this.zzdc;
    }

    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzx[] zzxArr;
        TextBlock textBlock2 = this;
        if (textBlock2.cornerPoints == null) {
            char c2 = 0;
            if (textBlock2.zzdb.length == 0) {
                textBlock2.cornerPoints = new Point[0];
            } else {
                int i = Integer.MAX_VALUE;
                int i2 = 0;
                int i3 = Integer.MAX_VALUE;
                int i4 = RNCartPanelDataEntity.NULL_VALUE;
                int i5 = RNCartPanelDataEntity.NULL_VALUE;
                while (true) {
                    zzxArr = textBlock2.zzdb;
                    if (i2 >= zzxArr.length) {
                        break;
                    }
                    zzr zzr = zzxArr[i2].zzdj;
                    zzr zzr2 = textBlock2.zzdb[c2].zzdj;
                    double sin = Math.sin(Math.toRadians((double) zzr2.zzdh));
                    double cos = Math.cos(Math.toRadians((double) zzr2.zzdh));
                    Point[] pointArr = new Point[4];
                    pointArr[c2] = new Point(zzr.left, zzr.top);
                    pointArr[c2].offset(-zzr2.left, -zzr2.top);
                    double d2 = (double) pointArr[c2].x;
                    Double.isNaN(d2);
                    int i6 = i;
                    double d3 = (double) pointArr[c2].y;
                    Double.isNaN(d3);
                    int i7 = (int) ((d2 * cos) + (d3 * sin));
                    double d4 = (double) (-pointArr[0].x);
                    Double.isNaN(d4);
                    double d5 = d4 * sin;
                    double d6 = (double) pointArr[0].y;
                    Double.isNaN(d6);
                    int i8 = (int) (d5 + (d6 * cos));
                    pointArr[0].x = i7;
                    pointArr[0].y = i8;
                    pointArr[1] = new Point(zzr.width + i7, i8);
                    pointArr[2] = new Point(zzr.width + i7, zzr.height + i8);
                    pointArr[3] = new Point(i7, i8 + zzr.height);
                    i = i6;
                    for (int i9 = 0; i9 < 4; i9++) {
                        Point point = pointArr[i9];
                        i = Math.min(i, point.x);
                        i4 = Math.max(i4, point.x);
                        i3 = Math.min(i3, point.y);
                        i5 = Math.max(i5, point.y);
                    }
                    i2++;
                    c2 = 0;
                    textBlock2 = this;
                }
                zzr zzr3 = zzxArr[0].zzdj;
                int i10 = zzr3.left;
                int i11 = zzr3.top;
                double sin2 = Math.sin(Math.toRadians((double) zzr3.zzdh));
                double cos2 = Math.cos(Math.toRadians((double) zzr3.zzdh));
                int i12 = i;
                Point[] pointArr2 = {new Point(i12, i3), new Point(i4, i3), new Point(i4, i5), new Point(i12, i5)};
                for (int i13 = 0; i13 < 4; i13++) {
                    double d7 = (double) pointArr2[i13].x;
                    Double.isNaN(d7);
                    double d8 = (double) pointArr2[i13].y;
                    Double.isNaN(d8);
                    double d9 = (double) pointArr2[i13].x;
                    Double.isNaN(d9);
                    double d10 = (double) pointArr2[i13].y;
                    Double.isNaN(d10);
                    pointArr2[i13].x = (int) ((d7 * cos2) - (d8 * sin2));
                    pointArr2[i13].y = (int) ((d9 * sin2) + (d10 * cos2));
                    pointArr2[i13].offset(i10, i11);
                }
                textBlock = this;
                textBlock.cornerPoints = pointArr2;
                return textBlock.cornerPoints;
            }
        }
        textBlock = textBlock2;
        return textBlock.cornerPoints;
    }

    public String getLanguage() {
        String str = this.zzdd;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzx zzx : this.zzdb) {
            hashMap.put(zzx.zzdd, Integer.valueOf((hashMap.containsKey(zzx.zzdd) ? ((Integer) hashMap.get(zzx.zzdd)).intValue() : 0) + 1));
        }
        this.zzdd = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        String str2 = this.zzdd;
        if (str2 == null || str2.isEmpty()) {
            this.zzdd = "und";
        }
        return this.zzdd;
    }

    public String getValue() {
        zzx[] zzxArr = this.zzdb;
        if (zzxArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzxArr[0].zzdm);
        for (int i = 1; i < this.zzdb.length; i++) {
            sb.append("\n");
            sb.append(this.zzdb[i].zzdm);
        }
        return sb.toString();
    }
}
