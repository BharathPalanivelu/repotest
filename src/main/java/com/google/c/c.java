package com.google.c;

import com.google.c.ad;
import java.io.InputStream;

public abstract class c<MessageType extends ad> implements aj<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final p f13705a = p.e();

    private as a(MessageType messagetype) {
        if (messagetype instanceof b) {
            return ((b) messagetype).c();
        }
        return new as((ad) messagetype);
    }

    private MessageType b(MessageType messagetype) throws v {
        if (messagetype == null || messagetype.a()) {
            return messagetype;
        }
        throw a(messagetype).a().a(messagetype);
    }

    public MessageType a(f fVar, p pVar) throws v {
        MessageType messagetype;
        try {
            g f2 = fVar.f();
            messagetype = (ad) b(f2, pVar);
            f2.a(0);
            return messagetype;
        } catch (v e2) {
            throw e2.a(messagetype);
        } catch (v e3) {
            throw e3;
        }
    }

    /* renamed from: b */
    public MessageType c(f fVar, p pVar) throws v {
        return b(a(fVar, pVar));
    }

    public MessageType a(byte[] bArr, int i, int i2, p pVar) throws v {
        MessageType messagetype;
        try {
            g a2 = g.a(bArr, i, i2);
            messagetype = (ad) b(a2, pVar);
            a2.a(0);
            return messagetype;
        } catch (v e2) {
            throw e2.a(messagetype);
        } catch (v e3) {
            throw e3;
        }
    }

    public MessageType b(byte[] bArr, int i, int i2, p pVar) throws v {
        return b(a(bArr, i, i2, pVar));
    }

    /* renamed from: a */
    public MessageType b(byte[] bArr, p pVar) throws v {
        return b(bArr, 0, bArr.length, pVar);
    }

    /* renamed from: a */
    public MessageType b(byte[] bArr) throws v {
        return b(bArr, f13705a);
    }

    public MessageType a(InputStream inputStream, p pVar) throws v {
        g a2 = g.a(inputStream);
        MessageType messagetype = (ad) b(a2, pVar);
        try {
            a2.a(0);
            return messagetype;
        } catch (v e2) {
            throw e2.a(messagetype);
        }
    }

    /* renamed from: b */
    public MessageType c(InputStream inputStream, p pVar) throws v {
        return b(a(inputStream, pVar));
    }
}
