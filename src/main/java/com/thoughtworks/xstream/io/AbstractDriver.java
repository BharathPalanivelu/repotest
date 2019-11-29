package com.thoughtworks.xstream.io;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public abstract class AbstractDriver implements HierarchicalStreamDriver {
    private NameCoder replacer;

    public AbstractDriver() {
        this(new NoNameCoder());
    }

    public AbstractDriver(NameCoder nameCoder) {
        this.replacer = nameCoder;
    }

    /* access modifiers changed from: protected */
    public NameCoder getNameCoder() {
        return this.replacer;
    }

    public HierarchicalStreamReader createReader(URL url) {
        try {
            return createReader(FirebasePerfUrlConnection.openStream(url));
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(File file) {
        try {
            return createReader((InputStream) new FileInputStream(file));
        } catch (FileNotFoundException e2) {
            throw new StreamException((Throwable) e2);
        }
    }
}
