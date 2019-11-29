package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.core.ReferenceByIdMarshaller;

public class SequenceGenerator implements ReferenceByIdMarshaller.IDGenerator {
    private int counter;

    public SequenceGenerator(int i) {
        this.counter = i;
    }

    public String next(Object obj) {
        int i = this.counter;
        this.counter = i + 1;
        return String.valueOf(i);
    }
}
