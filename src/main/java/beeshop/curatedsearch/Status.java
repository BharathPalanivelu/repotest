package beeshop.curatedsearch;

import com.squareup.wire.ProtoEnum;

public enum Status implements ProtoEnum {
    Unknown(0),
    Normal(1),
    Disable(2),
    Deleted(3),
    Draft(4);
    
    private final int value;

    private Status(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
