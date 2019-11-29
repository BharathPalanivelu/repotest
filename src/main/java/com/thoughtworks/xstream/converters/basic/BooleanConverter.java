package com.thoughtworks.xstream.converters.basic;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;

public class BooleanConverter extends AbstractSingleValueConverter {
    public static final BooleanConverter BINARY = new BooleanConverter("1", AppEventsConstants.EVENT_PARAM_VALUE_NO, true);
    public static final BooleanConverter TRUE_FALSE = new BooleanConverter(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, "false", false);
    public static final BooleanConverter YES_NO = new BooleanConverter("yes", "no", false);
    private final boolean caseSensitive;
    private final String negative;
    private final String positive;

    public boolean shouldConvert(Class cls, Object obj) {
        return true;
    }

    public BooleanConverter(String str, String str2, boolean z) {
        this.positive = str;
        this.negative = str2;
        this.caseSensitive = z;
    }

    public BooleanConverter() {
        this(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, "false", false);
    }

    public boolean canConvert(Class cls) {
        return cls.equals(Boolean.TYPE) || cls.equals(Boolean.class);
    }

    public Object fromString(String str) {
        return this.caseSensitive ? this.positive.equals(str) ? Boolean.TRUE : Boolean.FALSE : this.positive.equalsIgnoreCase(str) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String toString(Object obj) {
        Boolean bool = (Boolean) obj;
        if (obj == null) {
            return null;
        }
        return bool.booleanValue() ? this.positive : this.negative;
    }
}
