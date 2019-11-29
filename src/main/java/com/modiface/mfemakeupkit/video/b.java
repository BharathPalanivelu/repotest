package com.modiface.mfemakeupkit.video;

import android.media.AudioRecord;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private AudioRecord f15412a = null;

    /* renamed from: b  reason: collision with root package name */
    private final l f15413b;

    b(l lVar) {
        this.f15413b = lVar;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f15412a != null) {
            return false;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(this.f15413b.v, 16, 2);
        l lVar = this.f15413b;
        int i = lVar.x;
        int i2 = lVar.y * i;
        if (i2 < minBufferSize) {
            i2 = ((minBufferSize / i) + 1) * i * 2;
        }
        for (int audioRecord : this.f15413b.B) {
            try {
                this.f15412a = new AudioRecord(audioRecord, this.f15413b.v, 16, 2, i2);
                if (this.f15412a.getState() != 1) {
                    this.f15412a = null;
                }
            } catch (Exception unused) {
                this.f15412a = null;
            }
            AudioRecord audioRecord2 = this.f15412a;
            if (audioRecord2 != null) {
                try {
                    audioRecord2.startRecording();
                } catch (IllegalStateException unused2) {
                    this.f15412a = null;
                }
            }
            if (this.f15412a != null) {
                break;
            }
        }
        if (this.f15412a != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        AudioRecord audioRecord = this.f15412a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f15412a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int a(d dVar) {
        if (dVar == null || !dVar.a()) {
            return -2;
        }
        AudioRecord audioRecord = this.f15412a;
        if (audioRecord != null) {
            int read = audioRecord.read(dVar.f15424b, this.f15413b.x);
            if (read > 0) {
                dVar.f15424b.position(read);
                dVar.f15424b.flip();
            }
            return read;
        }
        dVar.f15424b.put(new byte[this.f15413b.x]);
        dVar.f15424b.flip();
        return this.f15413b.x;
    }
}
