package com.squareup.wire;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;

public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    private static final long serialVersionUID = 0;
    transient ExtensionMap<T> extensionMap;

    protected ExtendableMessage() {
    }

    /* access modifiers changed from: protected */
    public void setBuilder(ExtendableBuilder<T> extendableBuilder) {
        super.setBuilder(extendableBuilder);
        if (extendableBuilder.extensionMap != null) {
            this.extensionMap = new ExtensionMap<>(extendableBuilder.extensionMap);
        }
    }

    public List<Extension<T, ?>> getExtensions() {
        ExtensionMap<T> extensionMap2 = this.extensionMap;
        if (extensionMap2 == null) {
            return Collections.emptyList();
        }
        return extensionMap2.getExtensions();
    }

    public <E> E getExtension(Extension<T, E> extension) {
        ExtensionMap<T> extensionMap2 = this.extensionMap;
        if (extensionMap2 == null) {
            return null;
        }
        return extensionMap2.get(extension);
    }

    /* access modifiers changed from: protected */
    public boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        ExtensionMap<T> extensionMap2 = this.extensionMap;
        if (extensionMap2 == null) {
            return extendableMessage.extensionMap == null;
        }
        return extensionMap2.equals(extendableMessage.extensionMap);
    }

    /* access modifiers changed from: protected */
    public int extensionsHashCode() {
        ExtensionMap<T> extensionMap2 = this.extensionMap;
        if (extensionMap2 == null) {
            return 0;
        }
        return extensionMap2.hashCode();
    }

    /* access modifiers changed from: package-private */
    public String extensionsToString() {
        ExtensionMap<T> extensionMap2 = this.extensionMap;
        return extensionMap2 == null ? ServiceLogger.PLACEHOLDER : extensionMap2.toString();
    }

    public static abstract class ExtendableBuilder<T extends ExtendableMessage<?>> extends Message.Builder<T> {
        ExtensionMap<T> extensionMap;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(ExtendableMessage<T> extendableMessage) {
            super(extendableMessage);
            if (extendableMessage != null && extendableMessage.extensionMap != null) {
                this.extensionMap = new ExtensionMap<>(extendableMessage.extensionMap);
            }
        }

        public <E> E getExtension(Extension<T, E> extension) {
            ExtensionMap<T> extensionMap2 = this.extensionMap;
            if (extensionMap2 == null) {
                return null;
            }
            return extensionMap2.get(extension);
        }

        public <E> ExtendableBuilder<T> setExtension(Extension<T, E> extension, E e2) {
            ExtensionMap<T> extensionMap2 = this.extensionMap;
            if (extensionMap2 == null) {
                this.extensionMap = new ExtensionMap<>(extension, e2);
            } else {
                extensionMap2.put(extension, e2);
            }
            return this;
        }
    }
}
