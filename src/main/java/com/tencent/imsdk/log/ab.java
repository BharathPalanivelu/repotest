package com.tencent.imsdk.log;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

final class ab extends Thread {
    ab() {
    }

    public final void run() {
        File file = new File(QLogImpl.getLogPath());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new ac(this));
                Calendar instance = Calendar.getInstance();
                instance.add(6, -7);
                long timeInMillis = instance.getTimeInMillis();
                for (File file2 : listFiles) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogManager.tag, 2, "found log file " + file2.getName());
                    }
                    if (timeInMillis > file2.lastModified()) {
                        file2.delete();
                        if (QLog.isColorLevel()) {
                            QLog.d(LogManager.tag, 2, "del expires log " + file2.getName());
                        }
                    }
                }
            } else {
                return;
            }
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.set(6, instance2.get(6) - 7);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        instance2.getTimeInMillis();
    }
}
