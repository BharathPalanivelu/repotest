package qalsdk;

public enum ag {
    msfBoot,
    appRegister,
    unknown,
    msfHeartTimeTooLong,
    msfByNetChange,
    serverPush,
    fillRegProxy,
    createDefaultRegInfo,
    setAppQuit;

    static {
        msfBoot = new ag("msfBoot", 0);
        appRegister = new ag("appRegister", 1);
        unknown = new ag("unknown", 2);
        msfHeartTimeTooLong = new ag("msfHeartTimeTooLong", 3);
        msfByNetChange = new ag("msfByNetChange", 4);
        serverPush = new ag("serverPush", 5);
        fillRegProxy = new ag("fillRegProxy", 6);
        createDefaultRegInfo = new ag("createDefaultRegInfo", 7);
        setAppQuit = new ag("setAppQuit", 8);
        ag[] agVarArr = {msfBoot, appRegister, unknown, msfHeartTimeTooLong, msfByNetChange, serverPush, fillRegProxy, createDefaultRegInfo, setAppQuit};
    }
}
