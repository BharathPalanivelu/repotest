package com.tencent.imsdk.log;

import java.io.PrintStream;

final class ag extends Thread {
    ag() {
    }

    public final void run() {
        while (true) {
            try {
                String take = QLogImpl.logDeque.take();
                if (take != null) {
                    QLogImpl.writeLogToFile(take);
                }
            } catch (InterruptedException e2) {
                PrintStream printStream = System.out;
                printStream.println("write log file error." + e2);
            }
        }
    }
}
