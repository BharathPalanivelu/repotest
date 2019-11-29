package beeshop.curatedsearch;

import com.squareup.wire.ProtoEnum;

public enum ModuleType implements ProtoEnum {
    Prefill(1),
    Top(2),
    Middle(3),
    Bottom(4),
    ItemCard(5);
    
    private final int value;

    private ModuleType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
