package com.shopee.arcatch.c.h;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.LargestFaceFocusingProcessor;
import com.shopee.arcatch.c.f.b;
import com.shopee.arcatch.c.g.c;
import com.shopee.arcatch.c.g.i;
import com.shopee.arcatch.page.cameraview.common.GraphicOverlay;

public class a extends com.shopee.arcatch.page.cameraview.a.a<Face> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26910a = "a";

    /* renamed from: b  reason: collision with root package name */
    private FaceDetector f26911b = new FaceDetector.Builder(b.b().a()).setClassificationType(c.d()).setLandmarkType(c.b()).setMinFaceSize(c.a()).setMode(c.c()).setProminentFaceOnly(true).build();

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.arcatch.page.view.b f26912c;

    /* renamed from: d  reason: collision with root package name */
    private GraphicOverlay f26913d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26914e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f26915f;

    /* renamed from: g  reason: collision with root package name */
    private i f26916g;
    private long h;

    public a(com.shopee.arcatch.page.view.b bVar, GraphicOverlay graphicOverlay) {
        FaceDetector faceDetector = this.f26911b;
        faceDetector.setProcessor(new LargestFaceFocusingProcessor.Builder(faceDetector, this).build());
        this.f26912c = bVar;
        this.f26913d = graphicOverlay;
        this.f26916g = new i("detection");
        if (!this.f26911b.isOperational()) {
            com.shopee.arcatch.c.b.c.a("FaceDection is not operational", 2);
        }
    }

    public void a(String str) {
        this.f26914e = true;
        this.f26915f = str;
    }

    public void a() {
        this.f26911b.release();
        this.f26911b = null;
    }

    /* access modifiers changed from: protected */
    public void a(Frame frame) {
        if (this.f26911b != null) {
            this.h = System.currentTimeMillis();
            this.f26911b.receiveFrame(frame);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Face face) {
        if (this.f26912c != null && face != null) {
            int i = com.shopee.arcatch.c.d.a.a().k;
            int i2 = com.shopee.arcatch.c.d.a.a().l;
            float f2 = com.shopee.arcatch.c.d.a.a().n;
            float a2 = this.f26913d.a(face.getPosition().x + (face.getWidth() / 2.0f));
            float b2 = this.f26913d.b(face.getPosition().y + (face.getHeight() / 2.0f)) * f2;
            float c2 = this.f26913d.c(face.getWidth() / 2.0f);
            float d2 = this.f26913d.d(face.getHeight() / 2.0f) * f2;
            float f3 = (b2 - d2) + ((float) i) + ((float) i2);
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            this.f26916g.a((float) currentTimeMillis);
            this.f26912c.a(((a2 - c2) + (a2 + c2)) / 2.0f, f3, currentTimeMillis);
            b bVar = (b) this.f26913d.a("CryEye");
            this.f26913d.a();
            if (this.f26914e) {
                this.f26914e = false;
                if (bVar == null) {
                    bVar = new b(this.f26913d, face);
                } else {
                    bVar.a(face);
                }
                bVar.a(this.f26915f);
                this.f26913d.a((GraphicOverlay.a) bVar);
            } else if (bVar != null && bVar.a()) {
                bVar.b(face);
                this.f26913d.a((GraphicOverlay.a) bVar);
            }
            this.f26913d.postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f26912c.e();
    }

    public i c() {
        return this.f26916g;
    }
}
