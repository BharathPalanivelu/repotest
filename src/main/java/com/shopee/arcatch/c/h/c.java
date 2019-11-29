package com.shopee.arcatch.c.h;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.LargestFaceFocusingProcessor;
import com.shopee.arcatch.c.f.b;
import com.shopee.arcatch.page.cameraview.a.a;

public abstract class c extends a<Face> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26924a = "c";

    /* renamed from: b  reason: collision with root package name */
    private FaceDetector f26925b = new FaceDetector.Builder(b.b().a()).setClassificationType(0).setLandmarkType(0).setMinFaceSize(0.2f).setMode(0).setProminentFaceOnly(true).build();

    public c() {
        FaceDetector faceDetector = this.f26925b;
        faceDetector.setProcessor(new LargestFaceFocusingProcessor.Builder(faceDetector, this).build());
    }

    public void a() {
        FaceDetector faceDetector = this.f26925b;
        if (faceDetector != null) {
            faceDetector.release();
            this.f26925b = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Frame frame) {
        FaceDetector faceDetector = this.f26925b;
        if (faceDetector != null) {
            faceDetector.receiveFrame(frame);
        }
    }
}
