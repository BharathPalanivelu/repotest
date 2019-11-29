package beeshop.curatedsearch;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    SetActivity(1),
    GetActivity(2),
    CheckActivity(3),
    SetModule(4),
    BatchSetModule(5),
    BatchSetActivity(6),
    SetBlockPlatformInfo(7),
    KeepAlive(8);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
