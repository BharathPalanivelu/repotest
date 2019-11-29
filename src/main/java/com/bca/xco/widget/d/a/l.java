package com.bca.xco.widget.d.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class l {
    public static final l A = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final l B = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final l C = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final l D = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final l E = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final l F = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final l G = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final l H = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final l I = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final l J = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final l K = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final l L = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final l M = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final l N = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final l O = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final l P = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final l Q = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final l R = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final l S = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final l T = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final l U = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final l V = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final l W = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final l X = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final l Y = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final l Z = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: a  reason: collision with root package name */
    public static final l f5075a = a("SSL_RSA_WITH_NULL_MD5", 1);
    public static final l aA = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final l aB = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final l aC = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final l aD = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final l aE = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final l aF = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final l aG = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final l aH = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final l aI = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final l aJ = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final l aK = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final l aL = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final l aM = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final l aN = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final l aO = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final l aP = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final l aQ = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final l aR = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final l aS = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final l aT = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final l aU = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final l aV = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final l aW = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final l aX = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final l aY = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final l aZ = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final l aa = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final l ab = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final l ac = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final l ad = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final l ae = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final l af = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final l ag = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final l ah = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final l ai = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final l aj = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final l ak = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final l al = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final l am = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final l an = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final l ao = a("TLS_FALLBACK_SCSV", 22016);
    public static final l ap = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final l aq = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final l ar = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final l as = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final l at = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final l au = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final l av = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final l aw = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final l ax = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final l ay = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final l az = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: b  reason: collision with root package name */
    public static final l f5076b = a("SSL_RSA_WITH_NULL_SHA", 2);
    public static final l ba = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final l bb = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final l bc = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final l bd = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final l be = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final l bf = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final l bg = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final l bh = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    private static final ConcurrentMap<String, l> bj = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final l f5077c = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: d  reason: collision with root package name */
    public static final l f5078d = a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: e  reason: collision with root package name */
    public static final l f5079e = a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: f  reason: collision with root package name */
    public static final l f5080f = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: g  reason: collision with root package name */
    public static final l f5081g = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final l h = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final l i = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final l j = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final l k = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final l l = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final l m = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final l n = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final l o = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final l p = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final l q = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final l r = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final l s = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final l t = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final l u = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final l v = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final l w = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final l x = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final l y = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final l z = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    final String bi;

    public static l a(String str) {
        l lVar = (l) bj.get(str);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(str);
        l putIfAbsent = bj.putIfAbsent(str, lVar2);
        return putIfAbsent == null ? lVar2 : putIfAbsent;
    }

    private l(String str) {
        if (str != null) {
            this.bi = str;
            return;
        }
        throw new NullPointerException();
    }

    private static l a(String str, int i2) {
        return a(str);
    }

    public String toString() {
        return this.bi;
    }
}
