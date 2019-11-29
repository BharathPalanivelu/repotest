package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.Converter;

public class SelfStreamingInstanceChecker extends com.thoughtworks.xstream.core.util.SelfStreamingInstanceChecker {
    public SelfStreamingInstanceChecker(Converter converter, Object obj) {
        super(converter, obj);
    }
}
