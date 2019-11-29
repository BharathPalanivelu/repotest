package com.thoughtworks.xstream.persistence;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.mapper.Mapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractFilePersistenceStrategy implements PersistenceStrategy {
    /* access modifiers changed from: private */
    public final File baseDirectory;
    private final String encoding;
    /* access modifiers changed from: private */
    public final FilenameFilter filter = new ValidFilenameFilter();
    private final transient XStream xstream;

    /* access modifiers changed from: protected */
    public abstract Object extractKey(String str);

    /* access modifiers changed from: protected */
    public abstract String getName(Object obj);

    public AbstractFilePersistenceStrategy(File file, XStream xStream, String str) {
        this.baseDirectory = file;
        this.xstream = xStream;
        this.encoding = str;
    }

    /* access modifiers changed from: protected */
    public ConverterLookup getConverterLookup() {
        return this.xstream.getConverterLookup();
    }

    /* access modifiers changed from: protected */
    public Mapper getMapper() {
        return this.xstream.getMapper();
    }

    /* access modifiers changed from: protected */
    public boolean isValid(File file, String str) {
        return str.endsWith(".xml");
    }

    protected class ValidFilenameFilter implements FilenameFilter {
        protected ValidFilenameFilter() {
        }

        public boolean accept(File file, String str) {
            return new File(file, str).isFile() && AbstractFilePersistenceStrategy.this.isValid(file, str);
        }
    }

    protected class XmlMapEntriesIterator implements Iterator {
        /* access modifiers changed from: private */
        public File current = null;
        /* access modifiers changed from: private */
        public final File[] files = AbstractFilePersistenceStrategy.this.baseDirectory.listFiles(AbstractFilePersistenceStrategy.this.filter);
        private int position = -1;

        protected XmlMapEntriesIterator() {
        }

        static /* synthetic */ int access$404(XmlMapEntriesIterator xmlMapEntriesIterator) {
            int i = xmlMapEntriesIterator.position + 1;
            xmlMapEntriesIterator.position = i;
            return i;
        }

        public boolean hasNext() {
            return this.position + 1 < this.files.length;
        }

        public void remove() {
            File file = this.current;
            if (file != null) {
                file.delete();
                return;
            }
            throw new IllegalStateException();
        }

        public Object next() {
            return new Map.Entry() {
                private final File file;
                private final Object key = AbstractFilePersistenceStrategy.this.extractKey(this.file.getName());

                {
                    XmlMapEntriesIterator xmlMapEntriesIterator = XmlMapEntriesIterator.this;
                    this.file = xmlMapEntriesIterator.current = xmlMapEntriesIterator.files[XmlMapEntriesIterator.access$404(XmlMapEntriesIterator.this)];
                }

                public Object getKey() {
                    return this.key;
                }

                public Object getValue() {
                    return AbstractFilePersistenceStrategy.this.readFile(this.file);
                }

                public Object setValue(Object obj) {
                    return AbstractFilePersistenceStrategy.this.put(this.key, obj);
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean equals(java.lang.Object r6) {
                    /*
                        r5 = this;
                        boolean r0 = r6 instanceof java.util.Map.Entry
                        r1 = 0
                        if (r0 != 0) goto L_0x0006
                        return r1
                    L_0x0006:
                        java.lang.Object r0 = r5.getValue()
                        java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                        java.lang.Object r2 = r6.getKey()
                        java.lang.Object r3 = r6.getValue()
                        java.lang.Object r4 = r5.key
                        if (r4 != 0) goto L_0x001b
                        if (r2 != 0) goto L_0x0035
                        goto L_0x0021
                    L_0x001b:
                        boolean r2 = r4.equals(r2)
                        if (r2 == 0) goto L_0x0035
                    L_0x0021:
                        if (r0 != 0) goto L_0x0026
                        if (r3 != 0) goto L_0x0035
                        goto L_0x0034
                    L_0x0026:
                        java.lang.Object r0 = r5.getValue()
                        java.lang.Object r6 = r6.getValue()
                        boolean r6 = r0.equals(r6)
                        if (r6 == 0) goto L_0x0035
                    L_0x0034:
                        r1 = 1
                    L_0x0035:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.persistence.AbstractFilePersistenceStrategy.XmlMapEntriesIterator.AnonymousClass1.equals(java.lang.Object):boolean");
                }
            };
        }
    }

    private void writeFile(File file, Object obj) {
        OutputStreamWriter outputStreamWriter;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = this.encoding != null ? new OutputStreamWriter(fileOutputStream, this.encoding) : new OutputStreamWriter(fileOutputStream);
            this.xstream.toXML(obj, (Writer) outputStreamWriter);
            outputStreamWriter.close();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        } catch (Throwable th) {
            outputStreamWriter.close();
            throw th;
        }
    }

    private File getFile(String str) {
        return new File(this.baseDirectory, str);
    }

    /* access modifiers changed from: private */
    public Object readFile(File file) {
        InputStreamReader inputStreamReader;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            inputStreamReader = this.encoding != null ? new InputStreamReader(fileInputStream, this.encoding) : new InputStreamReader(fileInputStream);
            Object fromXML = this.xstream.fromXML((Reader) inputStreamReader);
            inputStreamReader.close();
            return fromXML;
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        } catch (Throwable th) {
            inputStreamReader.close();
            throw th;
        }
    }

    public Object put(Object obj, Object obj2) {
        Object obj3 = get(obj);
        writeFile(new File(this.baseDirectory, getName(obj)), obj2);
        return obj3;
    }

    public Iterator iterator() {
        return new XmlMapEntriesIterator();
    }

    public int size() {
        return this.baseDirectory.list(this.filter).length;
    }

    public boolean containsKey(Object obj) {
        return getFile(getName(obj)).isFile();
    }

    public Object get(Object obj) {
        return readFile(getFile(getName(obj)));
    }

    public Object remove(Object obj) {
        File file = getFile(getName(obj));
        if (!file.isFile()) {
            return null;
        }
        Object readFile = readFile(file);
        file.delete();
        return readFile;
    }
}
