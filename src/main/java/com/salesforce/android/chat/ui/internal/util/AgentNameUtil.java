package com.salesforce.android.chat.ui.internal.util;

import com.litesuits.orm.db.assit.SQLBuilder;

public class AgentNameUtil {
    public static String getAgentFirstName(String str) {
        int indexOf = str.indexOf(SQLBuilder.BLANK);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public static String getAgentInitial(String str) {
        return str.substring(0, 1).toUpperCase();
    }
}
