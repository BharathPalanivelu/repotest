package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost {
    private ArrayList<a> _sessionInfoList = new ArrayList<>();
    private ReentrantLock mLock = new ReentrantLock();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32465a;

        /* renamed from: b  reason: collision with root package name */
        public TraeAudioSession f32466b;

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
            if (aVar.f32465a == j) {
                break;
            }
            i++;
        }
        this.mLock.unlock();
        return aVar;
    }

    public void add(TraeAudioSession traeAudioSession, long j, Context context) {
        if (find(j) == null) {
            a aVar = new a();
            aVar.f32465a = j;
            aVar.f32466b = traeAudioSession;
            this.mLock.lock();
            this._sessionInfoList.add(aVar);
            this.mLock.unlock();
        }
    }

    public void remove(long j) {
        this.mLock.lock();
        int i = 0;
        while (true) {
            if (i >= this._sessionInfoList.size()) {
                break;
            } else if (this._sessionInfoList.get(i).f32465a == j) {
                this._sessionInfoList.remove(i);
                break;
            } else {
                i++;
            }
        }
        this.mLock.unlock();
    }

    public void sendToAudioSessionMessage(Intent intent) {
        this.mLock.lock();
        for (int i = 0; i < this._sessionInfoList.size(); i++) {
            this._sessionInfoList.get(i).f32466b.onReceiveCallback(intent);
        }
        this.mLock.unlock();
    }
}
