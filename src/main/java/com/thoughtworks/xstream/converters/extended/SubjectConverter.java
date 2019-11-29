package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.Subject;

public class SubjectConverter extends AbstractCollectionConverter {
    /* access modifiers changed from: protected */
    public void marshalPrivateCredentials(Set set, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
    }

    /* access modifiers changed from: protected */
    public void marshalPublicCredentials(Set set, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
    }

    public SubjectConverter(Mapper mapper) {
        super(mapper);
    }

    public boolean canConvert(Class cls) {
        return cls.equals(Subject.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Subject subject = (Subject) obj;
        marshalPrincipals(subject.getPrincipals(), hierarchicalStreamWriter, marshallingContext);
        marshalPublicCredentials(subject.getPublicCredentials(), hierarchicalStreamWriter, marshallingContext);
        marshalPrivateCredentials(subject.getPrivateCredentials(), hierarchicalStreamWriter, marshallingContext);
        marshalReadOnly(subject.isReadOnly(), hierarchicalStreamWriter);
    }

    /* access modifiers changed from: protected */
    public void marshalPrincipals(Set set, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.startNode("principals");
        for (Object writeItem : set) {
            writeItem(writeItem, marshallingContext, hierarchicalStreamWriter);
        }
        hierarchicalStreamWriter.endNode();
    }

    /* access modifiers changed from: protected */
    public void marshalReadOnly(boolean z, HierarchicalStreamWriter hierarchicalStreamWriter) {
        hierarchicalStreamWriter.startNode("readOnly");
        hierarchicalStreamWriter.setValue(String.valueOf(z));
        hierarchicalStreamWriter.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return new Subject(unmarshalReadOnly(hierarchicalStreamReader), unmarshalPrincipals(hierarchicalStreamReader, unmarshallingContext), unmarshalPublicCredentials(hierarchicalStreamReader, unmarshallingContext), unmarshalPrivateCredentials(hierarchicalStreamReader, unmarshallingContext));
    }

    /* access modifiers changed from: protected */
    public Set unmarshalPrincipals(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return populateSet(hierarchicalStreamReader, unmarshallingContext);
    }

    /* access modifiers changed from: protected */
    public Set unmarshalPublicCredentials(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return Collections.EMPTY_SET;
    }

    /* access modifiers changed from: protected */
    public Set unmarshalPrivateCredentials(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return Collections.EMPTY_SET;
    }

    /* access modifiers changed from: protected */
    public boolean unmarshalReadOnly(HierarchicalStreamReader hierarchicalStreamReader) {
        hierarchicalStreamReader.moveDown();
        boolean z = Boolean.getBoolean(hierarchicalStreamReader.getValue());
        hierarchicalStreamReader.moveUp();
        return z;
    }

    /* access modifiers changed from: protected */
    public Set populateSet(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        HashSet hashSet = new HashSet();
        hierarchicalStreamReader.moveDown();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, hashSet);
            hierarchicalStreamReader.moveUp();
            hashSet.add(readItem);
        }
        hierarchicalStreamReader.moveUp();
        return hashSet;
    }
}
