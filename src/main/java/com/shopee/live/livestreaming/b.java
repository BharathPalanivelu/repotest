package com.shopee.live.livestreaming;

import android.content.Context;
import android.os.Build;
import androidx.emoji.b.a;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.FontRequestEmojiCompatConfig;

import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.util.ac;
import com.shopee.live.livestreaming.util.classX;
import com.shopee.sdk.d.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static livestreamingA f28765a;

    public static synchronized livestreamingA a(Context context) {
        livestreamingA aVar;
        synchronized (b.class) {
            if (f28765a == null) {
                f28765a = new livestreamingA(context);
            }
            if (!c()) {
                ac.a(context);
                SZTrackingReporter.getInstance().init(context);
                com.shopee.e.a.a.a(context);
                try {
//                    androidx.emoji.b.a.a((a.c) new androidx.emoji.a.a(context));
                    EmojiCompat.init(new BundledEmojiCompatConfig(context));
                } catch (NoClassDefFoundError e2) {
                    com.shopee.e.a.a.a(e2, "Emoji load failed, maybe you pkg is wrong with androidx", new Object[0]);
                }
                classX.h();
            }
            aVar = f28765a;
        }
        return aVar;
    }

    public static c a() {
        c cVar = new c("LiveStreamingRouter");
        cVar.a(new com.shopee.live.livestreaming.c.a());
        cVar.a(new com.shopee.live.livestreaming.c.b());
        cVar.a(new com.shopee.live.livestreaming.c.c());
        return cVar;
    }

    public static livestreamingA b() {
        return f28765a;
    }

    /**
     * tentukan apakah cpu abi `x86` atau `x86_64`
     * @return
     */
    private static boolean c() {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return "x86".equals(Build.CPU_ABI);
            }
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null) {
                String str = strArr[0];
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -806050265) {
                    if (hashCode == 117110) {
                        if (str.equals("x86")) {
                            c2 = 1;
                        }
                    }
                } else if (str.equals("x86_64")) {
                    c2 = 0;
                }
                if (c2 == 0 || c2 == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            com.shopee.e.a.a.a(e2, "isX86Device error.", new Object[0]);
        }
        return false;
    }
}
