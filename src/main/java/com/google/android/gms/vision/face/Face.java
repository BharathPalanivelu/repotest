package com.google.android.gms.vision.face;

import android.graphics.PointF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private float height;
    private int id;
    private float width;
    private PointF zzbo;
    private float zzbp;
    private float zzbq;
    private List<Landmark> zzbr;
    private float zzbs;
    private float zzbt;
    private float zzbu;

    public Face(int i, PointF pointF, float f2, float f3, float f4, float f5, Landmark[] landmarkArr, float f6, float f7, float f8) {
        this.id = i;
        this.zzbo = pointF;
        this.width = f2;
        this.height = f3;
        this.zzbp = f4;
        this.zzbq = f5;
        this.zzbr = Arrays.asList(landmarkArr);
        if (f6 < BitmapDescriptorFactory.HUE_RED || f6 > 1.0f) {
            this.zzbs = -1.0f;
        } else {
            this.zzbs = f6;
        }
        if (f7 < BitmapDescriptorFactory.HUE_RED || f7 > 1.0f) {
            this.zzbt = -1.0f;
        } else {
            this.zzbt = f7;
        }
        if (f8 < BitmapDescriptorFactory.HUE_RED || f8 > 1.0f) {
            this.zzbu = -1.0f;
        } else {
            this.zzbu = f8;
        }
    }

    public float getEulerY() {
        return this.zzbp;
    }

    public float getEulerZ() {
        return this.zzbq;
    }

    public float getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzbs;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzbt;
    }

    public float getIsSmilingProbability() {
        return this.zzbu;
    }

    public List<Landmark> getLandmarks() {
        return this.zzbr;
    }

    public PointF getPosition() {
        return new PointF(this.zzbo.x - (this.width / 2.0f), this.zzbo.y - (this.height / 2.0f));
    }

    public float getWidth() {
        return this.width;
    }
}
