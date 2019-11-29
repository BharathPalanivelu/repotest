package org.d.f;

import com.google.a.f;
import com.google.a.g;
import com.google.a.q;
import org.slf4j.Logger;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static f f33975a = new g().b().d();

    public static void a(Logger logger, String str, String str2) {
        logger.debug(String.format("Entering method %s.\n\tMethod arguments: [%s].", new Object[]{str, str2}));
    }

    public static void a(Logger logger, String str) {
        if (logger.isDebugEnabled()) {
            try {
                str = new g().b().d().a(new q().a(str));
            } catch (Exception unused) {
            }
            logger.debug("Received JSON response from Instagram - " + str);
        }
    }
}
