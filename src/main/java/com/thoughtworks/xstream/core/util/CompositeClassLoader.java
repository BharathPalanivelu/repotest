package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.core.JVM;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompositeClassLoader extends ClassLoader {
    private final List classLoaders = new ArrayList();
    private final ReferenceQueue queue = new ReferenceQueue();

    static {
        if (JVM.is17()) {
            try {
                Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", (Class[]) null);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                declaredMethod.invoke((Object) null, (Object[]) null);
            } catch (Exception unused) {
            }
        }
    }

    public CompositeClassLoader() {
        addInternal(Object.class.getClassLoader());
        addInternal(getClass().getClassLoader());
    }

    public synchronized void add(ClassLoader classLoader) {
        cleanup();
        if (classLoader != null) {
            addInternal(classLoader);
        }
    }

    private void addInternal(ClassLoader classLoader) {
        Iterator it = this.classLoaders.iterator();
        WeakReference weakReference = null;
        while (it.hasNext()) {
            WeakReference weakReference2 = (WeakReference) it.next();
            ClassLoader classLoader2 = (ClassLoader) weakReference2.get();
            if (classLoader2 == null) {
                it.remove();
            } else if (classLoader2 == classLoader) {
                it.remove();
                weakReference = weakReference2;
            }
        }
        List list = this.classLoaders;
        if (weakReference == null) {
            weakReference = new WeakReference(classLoader, this.queue);
        }
        list.add(0, weakReference);
    }

    public Class loadClass(String str) throws ClassNotFoundException {
        AnonymousClass1<ClassLoader> r0 = new ArrayList(this.classLoaders.size()) {
            public boolean addAll(Collection collection) {
                boolean z = false;
                for (Object add : collection) {
                    z |= add(add);
                }
                return z;
            }

            public boolean add(Object obj) {
                Object obj2 = ((WeakReference) obj).get();
                if (obj2 != null) {
                    return super.add(obj2);
                }
                return false;
            }
        };
        synchronized (this) {
            cleanup();
            r0.addAll(this.classLoaders);
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        for (ClassLoader classLoader : r0) {
            if (classLoader == contextClassLoader) {
                contextClassLoader = null;
            }
            try {
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (contextClassLoader != null) {
            return contextClassLoader.loadClass(str);
        }
        throw new ClassNotFoundException(str);
    }

    private void cleanup() {
        while (true) {
            WeakReference weakReference = (WeakReference) this.queue.poll();
            if (weakReference != null) {
                this.classLoaders.remove(weakReference);
            } else {
                return;
            }
        }
    }
}
