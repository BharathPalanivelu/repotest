package com.tencent.rtmp.sharp.jni;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioCodecList {
    private ArrayList<a> _sessionInfoList = new ArrayList<>();
    private ReentrantLock mLock = new ReentrantLock();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32403a;

        /* renamed from: b  reason: collision with root package name */
        public AudioDecoder f32404b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f32405c;

        public a() {
        }
    }

    public a find(long j) {
        a aVar;
        this.mLock.lock();
        int i = 0;
        while (true) {
            if (i >= this._sessionInfoList.size()) {
                aVar = null;
                break;
            }
            aVar = this._sessionInfoList.get(i);
            if (aVar.f32403a == j) {
                break;
            }
            i++;
        }
        this.mLock.unlock();
        return aVar;
    }

    public a add(long j) {
        a find = find(j);
        if (find != null) {
            return find;
        }
        a aVar = new a();
        aVar.f32403a = j;
        aVar.f32404b = new AudioDecoder();
        aVar.f32405c = new byte[3840];
        this.mLock.lock();
        this._sessionInfoList.add(aVar);
        this.mLock.unlock();
        return find(j);
    }

    public void remove(long j) {
        this.mLock.lock();
        int i = 0;
        while (true) {
            if (i >= this._sessionInfoList.size()) {
                break;
            } else if (this._sessionInfoList.get(i).f32403a == j) {
                this._sessionInfoList.remove(i);
                break;
            } else {
                i++;
            }
        }
        this.mLock.unlock();
    }
}
