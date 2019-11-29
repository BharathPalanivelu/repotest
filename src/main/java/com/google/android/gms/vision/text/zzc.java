package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzr;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

final class zzc {
    static Rect zza(Text text) {
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = RNCartPanelDataEntity.NULL_VALUE;
        int i4 = RNCartPanelDataEntity.NULL_VALUE;
        for (Point point : text.getCornerPoints()) {
            i = Math.min(i, point.x);
            i3 = Math.max(i3, point.x);
            i2 = Math.min(i2, point.y);
            i4 = Math.max(i4, point.y);
        }
        return new Rect(i, i2, i3, i4);
    }

    static Point[] zza(zzr zzr) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzr.zzdh));
        double cos = Math.cos(Math.toRadians((double) zzr.zzdh));
        pointArr[0] = new Point(zzr.left, zzr.top);
        double d2 = (double) zzr.left;
        double d3 = (double) zzr.width;
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d4 = (double) zzr.top;
        double d5 = (double) zzr.width;
        Double.isNaN(d5);
        Double.isNaN(d4);
        pointArr[1] = new Point((int) (d2 + (d3 * cos)), (int) (d4 + (d5 * sin)));
        double d6 = (double) pointArr[1].x;
        double d7 = (double) zzr.height;
        Double.isNaN(d7);
        Double.isNaN(d6);
        int i = (int) (d6 - (d7 * sin));
        double d8 = (double) pointArr[1].y;
        double d9 = (double) zzr.height;
        Double.isNaN(d9);
        Double.isNaN(d8);
        pointArr[2] = new Point(i, (int) (d8 + (d9 * cos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return pointArr;
    }
}
