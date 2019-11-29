package twitter4j.conf;

public final class ConfigurationContext {
    private static final String CONFIGURATION_IMPL = "twitter4j.configurationFactory";
    private static final String DEFAULT_CONFIGURATION_FACTORY = "twitter4j.conf.PropertyConfigurationFactory";
    private static final ConfigurationFactory factory;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        throw new java.lang.AssertionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        throw new java.lang.AssertionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        throw new java.lang.AssertionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    static {
        /*
            java.lang.String r0 = "twitter4j.conf.PropertyConfigurationFactory"
            java.lang.String r1 = "twitter4j.configurationFactory"
            java.lang.String r0 = java.lang.System.getProperty(r1, r0)     // Catch:{ SecurityException -> 0x0008 }
        L_0x0008:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0023, InstantiationException -> 0x001c, IllegalAccessException -> 0x0015 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x0023, InstantiationException -> 0x001c, IllegalAccessException -> 0x0015 }
            twitter4j.conf.ConfigurationFactory r0 = (twitter4j.conf.ConfigurationFactory) r0     // Catch:{ ClassNotFoundException -> 0x0023, InstantiationException -> 0x001c, IllegalAccessException -> 0x0015 }
            factory = r0     // Catch:{ ClassNotFoundException -> 0x0023, InstantiationException -> 0x001c, IllegalAccessException -> 0x0015 }
            return
        L_0x0015:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x001c:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x0023:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.conf.ConfigurationContext.<clinit>():void");
    }

    public static Configuration getInstance() {
        return factory.getInstance();
    }

    public static Configuration getInstance(String str) {
        return factory.getInstance(str);
    }
}
