package com.tencent.qcloud.core.auth;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SignerFactory {
    private static final String COS_XML_SIGNER = "CosXmlSigner";
    private static final Map<String, Class<? extends QCloudSigner>> SIGNERS = new ConcurrentHashMap();

    static {
        SIGNERS.put(COS_XML_SIGNER, COSXmlSigner.class);
    }

    private SignerFactory() {
    }

    public static void registerSigner(String str, Class<? extends QCloudSigner> cls) {
        if (str == null) {
            throw new IllegalArgumentException("signerType cannot be null");
        } else if (cls != null) {
            SIGNERS.put(str, cls);
        } else {
            throw new IllegalArgumentException("signerClass cannot be null");
        }
    }

    public static QCloudSigner getSigner(String str) {
        return lookupAndCreateSigner(str);
    }

    private static QCloudSigner lookupAndCreateSigner(String str) {
        return createSigner(str);
    }

    private static QCloudSigner createSigner(String str) {
        Class cls = SIGNERS.get(str);
        if (cls == null) {
            return null;
        }
        try {
            return (QCloudSigner) cls.newInstance();
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e3);
        }
    }
}
