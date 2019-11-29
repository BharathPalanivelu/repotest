package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.core.util.ObjectIdDictionary;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.path.Path;
import com.thoughtworks.xstream.io.path.PathTracker;
import com.thoughtworks.xstream.io.path.PathTrackingWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Iterator;

public abstract class AbstractReferenceMarshaller extends TreeMarshaller implements MarshallingContext {
    /* access modifiers changed from: private */
    public ObjectIdDictionary implicitElements = new ObjectIdDictionary();
    private Path lastPath;
    /* access modifiers changed from: private */
    public PathTracker pathTracker = new PathTracker();
    /* access modifiers changed from: private */
    public ObjectIdDictionary references = new ObjectIdDictionary();

    /* access modifiers changed from: protected */
    public abstract String createReference(Path path, Object obj);

    /* access modifiers changed from: protected */
    public abstract Object createReferenceKey(Path path, Object obj);

    /* access modifiers changed from: protected */
    public abstract void fireValidReference(Object obj);

    public AbstractReferenceMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        super(hierarchicalStreamWriter, converterLookup, mapper);
        this.writer = new PathTrackingWriter(hierarchicalStreamWriter, this.pathTracker);
    }

    public void convert(Object obj, Converter converter) {
        final Object obj2;
        if (getMapper().isImmutableValueType(obj.getClass())) {
            converter.marshal(obj, this.writer, this);
            return;
        }
        final Path path = this.pathTracker.getPath();
        Id id = (Id) this.references.lookupId(obj);
        if (id == null || id.getPath() == path) {
            if (id == null) {
                obj2 = createReferenceKey(path, obj);
            } else {
                obj2 = id.getItem();
            }
            Path path2 = this.lastPath;
            if (path2 == null || !path.isAncestor(path2)) {
                fireValidReference(obj2);
                this.lastPath = path;
                this.references.associateId(obj, new Id(obj2, path));
            }
            converter.marshal(obj, this.writer, new ReferencingMarshallingContext() {
                public void put(Object obj, Object obj2) {
                    AbstractReferenceMarshaller.this.put(obj, obj2);
                }

                public Iterator keys() {
                    return AbstractReferenceMarshaller.this.keys();
                }

                public Object get(Object obj) {
                    return AbstractReferenceMarshaller.this.get(obj);
                }

                public void convertAnother(Object obj, Converter converter) {
                    AbstractReferenceMarshaller.this.convertAnother(obj, converter);
                }

                public void convertAnother(Object obj) {
                    AbstractReferenceMarshaller.this.convertAnother(obj);
                }

                public void replace(Object obj, Object obj2) {
                    AbstractReferenceMarshaller.this.references.associateId(obj2, new Id(obj2, path));
                }

                public Object lookupReference(Object obj) {
                    return ((Id) AbstractReferenceMarshaller.this.references.lookupId(obj)).getItem();
                }

                public Path currentPath() {
                    return AbstractReferenceMarshaller.this.pathTracker.getPath();
                }

                public void registerImplicit(Object obj) {
                    if (!AbstractReferenceMarshaller.this.implicitElements.containsId(obj)) {
                        AbstractReferenceMarshaller.this.implicitElements.associateId(obj, obj2);
                        return;
                    }
                    throw new ReferencedImplicitElementException(obj, path);
                }
            });
            return;
        }
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("reference");
        if (aliasForSystemAttribute != null) {
            this.writer.addAttribute(aliasForSystemAttribute, createReference(path, id.getItem()));
        }
    }

    private static class Id {
        private Object item;
        private Path path;

        public Id(Object obj, Path path2) {
            this.item = obj;
            this.path = path2;
        }

        /* access modifiers changed from: protected */
        public Object getItem() {
            return this.item;
        }

        /* access modifiers changed from: protected */
        public Path getPath() {
            return this.path;
        }
    }

    public static class ReferencedImplicitElementException extends ConversionException {
        public ReferencedImplicitElementException(Object obj, Path path) {
            super("Cannot reference implicit element");
            add("implicit-element", obj.toString());
            add("referencing-element", path.toString());
        }
    }
}
