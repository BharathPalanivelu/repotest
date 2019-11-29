package com.salesforce.android.chat.core.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

public interface SensitiveDataRule {
    public static final String ACTION_REMOVE = "Remove";
    public static final String ACTION_REPLACE = "Replace";

    @Retention(RetentionPolicy.CLASS)
    public @interface Action {
    }

    @Action
    String getAction();

    String getId();

    String getName();

    Pattern[] getPatterns();

    String getReplacement();
}
