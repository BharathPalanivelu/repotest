package beeshop.curatedsearch;

import com.squareup.wire.ProtoEnum;

public enum ErrCode implements ProtoEnum {
    Success(0),
    InternalError(1),
    DuplicatedKeyword(2),
    InvalidParam(3),
    CacheNotContainKeyword(4),
    PublishEmptyModuleActivity(5),
    DuplicatedKeywordInTheSameActivity(6),
    PartialUpdateSuccess(7);
    
    private final int value;

    private ErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
