package com.tencent.cos.xml.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.internal.NativeProtocol;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.imsdk.TIMGroupManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class DigestUtils {
    public static String getMD5(String str) throws CosXmlClientException {
        FileInputStream fileInputStream;
        NoSuchAlgorithmException e2;
        FileNotFoundException e3;
        IOException e4;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read != -1) {
                                instance.update(bArr, 0, read);
                            } else {
                                String hexString = StringUtils.toHexString(instance.digest());
                                CloseUtil.closeQuietly(fileInputStream);
                                return hexString;
                            }
                        }
                    } catch (NoSuchAlgorithmException e5) {
                        e2 = e5;
                        throw new CosXmlClientException((Throwable) e2);
                    } catch (FileNotFoundException e6) {
                        e3 = e6;
                        throw new CosXmlClientException((Throwable) e3);
                    } catch (IOException e7) {
                        e4 = e7;
                        throw new CosXmlClientException((Throwable) e4);
                    }
                } catch (NoSuchAlgorithmException e8) {
                    e2 = e8;
                    throw new CosXmlClientException((Throwable) e2);
                } catch (FileNotFoundException e9) {
                    e3 = e9;
                    throw new CosXmlClientException((Throwable) e3);
                } catch (IOException e10) {
                    fileInputStream = null;
                    e4 = e10;
                    throw new CosXmlClientException((Throwable) e4);
                } catch (Throwable th) {
                    th = th;
                    CloseUtil.closeQuietly(fileInputStream);
                    throw th;
                }
            } else {
                throw new CosXmlClientException("file Path is not exist");
            }
        } else {
            throw new CosXmlClientException("file Path is null");
        }
    }

    public static String getSha1(String str) throws CosXmlClientException {
        try {
            return StringUtils.toHexString(MessageDigest.getInstance(Hash.ALGORITHM_SHA1).digest(str.getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e2) {
            throw new CosXmlClientException((Throwable) e2);
        }
    }

    public static String getSHA1FromPath(String str) throws CosXmlClientException {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA1);
                byte[] bArr = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
                while (true) {
                    int read = fileInputStream2.read(bArr, 0, bArr.length);
                    if (read != -1) {
                        instance.update(bArr, 0, read);
                    } else {
                        String hexString = StringUtils.toHexString(instance.digest());
                        CloseUtil.closeQuietly(fileInputStream2);
                        return hexString;
                    }
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                FileInputStream fileInputStream3 = fileInputStream2;
                throw new CosXmlClientException((Throwable) e);
            } catch (IOException e3) {
                e = e3;
                FileInputStream fileInputStream4 = fileInputStream2;
                throw new CosXmlClientException((Throwable) e);
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                fileInputStream = fileInputStream2;
                throw new CosXmlClientException((Throwable) e);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CloseUtil.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            throw new CosXmlClientException((Throwable) e);
        } catch (IOException e6) {
            e = e6;
            throw new CosXmlClientException((Throwable) e);
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            throw new CosXmlClientException((Throwable) e);
        } catch (Throwable th2) {
            th = th2;
            CloseUtil.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static String getSHA1FromBytes(byte[] bArr, int i, int i2) throws CosXmlClientException {
        if (bArr == null || i2 <= 0 || i < 0) {
            throw new CosXmlClientException("data == null | len <= 0 |offset < 0 |offset >= len");
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA1);
            instance.update(bArr, i, i2);
            return StringUtils.toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (OutOfMemoryError e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public static String getHmacSha1(String str, String str2) throws CosXmlClientException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return StringUtils.toHexString(instance.doFinal(str.getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (InvalidKeyException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public static String getBase64(String str) throws CosXmlClientException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("utf-8"), 2);
        } catch (UnsupportedEncodingException e2) {
            throw new CosXmlClientException((Throwable) e2);
        }
    }
}
