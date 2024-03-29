package io.a.a.a.a.b;

public enum l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    public static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
    private final int id;

    private l(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return Integer.toString(this.id);
    }

    public static l determineFrom(String str) {
        if (BETA_APP_PACKAGE_NAME.equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
