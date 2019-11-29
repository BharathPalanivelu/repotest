package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.path.Path;
import com.thoughtworks.xstream.mapper.Mapper;

public class ReferenceByIdMarshaller extends AbstractReferenceMarshaller {
    private final IDGenerator idGenerator;

    public interface IDGenerator {
        String next(Object obj);
    }

    public ReferenceByIdMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper, IDGenerator iDGenerator) {
        super(hierarchicalStreamWriter, converterLookup, mapper);
        this.idGenerator = iDGenerator;
    }

    public ReferenceByIdMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        this(hierarchicalStreamWriter, converterLookup, mapper, new SequenceGenerator(1));
    }

    /* access modifiers changed from: protected */
    public String createReference(Path path, Object obj) {
        return obj.toString();
    }

    /* access modifiers changed from: protected */
    public Object createReferenceKey(Path path, Object obj) {
        return this.idGenerator.next(obj);
    }

    /* access modifiers changed from: protected */
    public void fireValidReference(Object obj) {
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("id");
        if (aliasForSystemAttribute != null) {
            this.writer.addAttribute(aliasForSystemAttribute, obj.toString());
        }
    }
}
