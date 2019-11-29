package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum SuggestionAlgorithms implements ProtoEnum {
    SPELL_CHECK(1),
    DROP_WORD(2),
    ENTITY_SPELL(3);
    
    private final int value;

    private SuggestionAlgorithms(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
