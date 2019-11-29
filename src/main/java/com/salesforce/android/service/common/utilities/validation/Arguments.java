package com.salesforce.android.service.common.utilities.validation;

import java.util.Locale;
import java.util.regex.Pattern;

public class Arguments {
    private static final Pattern FQDN = Pattern.compile("^((?!-)[-a-zA-Z0-9]*[a-zA-Z0-9]+\\.?)+(:[0-9]+)?$");
    private static final Pattern SFDC_UUID = Pattern.compile(".{15}");

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void check(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkValidSalesforceId(String str, String str2) {
        check(SFDC_UUID.matcher(str).matches(), String.format(Locale.getDefault(), "Invalid Salesforce %s ID. Must be 15 characters long.", new Object[]{str2}));
    }

    public static void checkValidLiveAgentPod(String str) {
        boolean matches = FQDN.matcher(str).matches();
        check(matches, "Invalid LiveAgent Pod: " + str + "\nPlease confirm that you are using the FQDN of the pod and not the entire HTTP URL. Example: mypod.salesforceliveagent.com");
    }
}
