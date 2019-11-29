package com.modiface.mfemakeupkit.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.io.IOException;

class n extends c {

    /* renamed from: f  reason: collision with root package name */
    private final l f15457f;

    /* renamed from: g  reason: collision with root package name */
    MediaCodecInfo.CodecCapabilities f15458g = null;

    n(l lVar) {
        this.f15457f = lVar;
    }

    private static MediaCodecInfo.CodecCapabilities b(String str) {
        if (str == null) {
            return null;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt != null && codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                if (supportedTypes == null) {
                    continue;
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= supportedTypes.length) {
                            continue;
                            break;
                        } else if (supportedTypes[i2].equalsIgnoreCase(str)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                            if (capabilitiesForType != null) {
                                int i3 = 0;
                                while (true) {
                                    int[] iArr = capabilitiesForType.colorFormats;
                                    if (i3 >= iArr.length) {
                                        continue;
                                        break;
                                    } else if (iArr[i3] == 2130708361) {
                                        return capabilitiesForType;
                                    } else {
                                        i3++;
                                    }
                                }
                            } else {
                                continue;
                            }
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2) throws IllegalStateException, MediaCodec.CryptoException {
        super.a(this.f15457f.a(i, i2), true);
    }

    /* access modifiers changed from: package-private */
    public d h() throws IllegalStateException {
        return super.a((long) this.f15457f.t);
    }

    /* access modifiers changed from: package-private */
    public void i() throws IOException {
        this.f15458g = b(this.f15457f.o);
        if (this.f15458g != null) {
            super.a(this.f15457f.o);
        }
    }
}
