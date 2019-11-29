package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum NativeGatherer {
    INSTANCE;
    
    private final String TAG;
    private final NativeGathererHelper m_gatherer;

    private class NativeGathererHelper {

        /* renamed from: a  reason: collision with root package name */
        boolean f32515a;

        /* renamed from: b  reason: collision with root package name */
        int f32516b;

        /* renamed from: c  reason: collision with root package name */
        int f32517c;

        /* renamed from: d  reason: collision with root package name */
        int f32518d;

        /* renamed from: e  reason: collision with root package name */
        String f32519e;

        /* renamed from: g  reason: collision with root package name */
        private final String f32521g;

        /* access modifiers changed from: package-private */
        public native String[] checkURLs(String[] strArr);

        /* access modifiers changed from: package-private */
        public native int findPackages(int i, String str);

        /* access modifiers changed from: package-private */
        public native String[] findRunningProcs();

        /* access modifiers changed from: package-private */
        public native void finit();

        /* access modifiers changed from: package-private */
        public native String[] getFontList(String str);

        /* access modifiers changed from: package-private */
        public native String getRandomString(int i);

        /* access modifiers changed from: package-private */
        public native String hashFile(String str);

        /* access modifiers changed from: package-private */
        public native boolean init(int i);

        /* access modifiers changed from: package-private */
        public native String md5(String str);

        /* access modifiers changed from: package-private */
        public native String sha1(String str);

        /* access modifiers changed from: package-private */
        public native String urlEncode(String str);

        /* access modifiers changed from: package-private */
        public native String xor(String str, String str2);

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x004c, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x003f, code lost:
            r4 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:11:? A[ExcHandler: UnsatisfiedLinkError (unused java.lang.UnsatisfiedLinkError), SYNTHETIC, Splitter:B:1:0x001e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        NativeGathererHelper() {
            /*
                r3 = this;
                com.threatmetrix.TrustDefenderMobile.NativeGatherer.this = r4
                r3.<init>()
                java.lang.Class<com.threatmetrix.TrustDefenderMobile.NativeGatherer$NativeGathererHelper> r4 = com.threatmetrix.TrustDefenderMobile.NativeGatherer.NativeGathererHelper.class
                java.lang.String r4 = r4.getName()
                r3.f32521g = r4
                r4 = 0
                r3.f32516b = r4
                r0 = 200(0xc8, float:2.8E-43)
                r3.f32517c = r0
                int r0 = r3.f32517c
                r3.f32518d = r0
                java.lang.String r0 = "/system/app"
                r3.f32519e = r0
                java.lang.String r0 = "trustdefender-jni"
                java.lang.System.loadLibrary(r0)     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x0041 }
                java.lang.Integer r0 = com.threatmetrix.TrustDefenderMobile.ac.f32542a     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x0041 }
                int r0 = r0.intValue()     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x0041 }
                boolean r0 = r3.init(r0)     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x0041 }
                if (r0 == 0) goto L_0x004d
                java.lang.String r1 = r3.f32521g     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x003f }
                java.lang.String r2 = "Finding packages"
                android.util.Log.d(r1, r2)     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x003f }
                int r1 = r3.f32517c     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x003f }
                java.lang.String r2 = r3.f32519e     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x003f }
                int r1 = r3.findPackages(r1, r2)     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x003f }
                r3.f32516b = r1     // Catch:{ UnsatisfiedLinkError -> 0x004c, Throwable -> 0x003f }
                goto L_0x004d
            L_0x003f:
                r4 = move-exception
                goto L_0x0044
            L_0x0041:
                r0 = move-exception
                r4 = r0
                r0 = 0
            L_0x0044:
                java.lang.String r1 = r3.f32521g
                java.lang.String r2 = "Native code:"
                android.util.Log.e(r1, r2, r4)
                goto L_0x004d
            L_0x004c:
                r0 = 0
            L_0x004d:
                r3.f32515a = r0
                java.lang.String r4 = r3.f32521g
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "NativeGatherer() complete, found "
                r0.append(r1)
                int r1 = r3.f32516b
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.util.Log.d(r4, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.NativeGatherer.NativeGathererHelper.<init>(com.threatmetrix.TrustDefenderMobile.NativeGatherer):void");
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            super.finalize();
            finit();
        }
    }

    public boolean isAvailable() {
        return this.m_gatherer.f32515a;
    }

    public String[] checkURLs(String[] strArr) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(this.m_gatherer.f32515a ? " available " : "not available ");
        sb.append(" Found ");
        sb.append(this.m_gatherer.f32516b);
        sb.append(" out of ");
        sb.append(this.m_gatherer.f32518d);
        Log.d(str, sb.toString());
        if (!this.m_gatherer.f32515a) {
            return null;
        }
        if (this.m_gatherer.f32516b == this.m_gatherer.f32517c) {
            String str2 = this.TAG;
            Log.d(str2, "Finding more packages " + this.m_gatherer.f32516b + " / " + this.m_gatherer.f32518d);
            NativeGathererHelper nativeGathererHelper = this.m_gatherer;
            int i = nativeGathererHelper.f32518d;
            NativeGathererHelper nativeGathererHelper2 = this.m_gatherer;
            nativeGathererHelper.f32518d = i + nativeGathererHelper2.findPackages(nativeGathererHelper2.f32517c, this.m_gatherer.f32519e);
        }
        return this.m_gatherer.checkURLs(strArr);
    }

    public String hashFile(String str) {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.hashFile(str);
        }
        return null;
    }

    public String md5(String str) {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.md5(str);
        }
        return null;
    }

    public String sha1(String str) {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.sha1(str);
        }
        return null;
    }

    public String getRandomString(int i) {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.getRandomString(i);
        }
        return null;
    }

    public String urlEncode(String str) {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.urlEncode(str);
        }
        return null;
    }

    public List<String> getFontList(String str) {
        if (!this.m_gatherer.f32515a) {
            return null;
        }
        String[] fontList = this.m_gatherer.getFontList(str);
        if (fontList != null) {
            return Arrays.asList(fontList);
        }
        return new ArrayList();
    }

    public String[] findRunningProcs() {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.findRunningProcs();
        }
        return null;
    }

    public String xor(String str, String str2) {
        if (this.m_gatherer.f32515a) {
            return this.m_gatherer.xor(str, str2);
        }
        return null;
    }
}
