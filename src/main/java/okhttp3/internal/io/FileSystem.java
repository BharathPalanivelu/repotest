package okhttp3.internal.io;

import e.n;
import e.u;
import e.v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        public v source(File file) throws FileNotFoundException {
            return n.a(file);
        }

        public u sink(File file) throws FileNotFoundException {
            try {
                return n.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return n.b(file);
            }
        }

        public u appendingSink(File file) throws FileNotFoundException {
            try {
                return n.c(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return n.c(file);
            }
        }

        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long size(File file) {
            return file.length();
        }

        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }
    };

    u appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    u sink(File file) throws FileNotFoundException;

    long size(File file);

    v source(File file) throws FileNotFoundException;
}
