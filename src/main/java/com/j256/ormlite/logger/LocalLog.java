package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class LocalLog implements Log {
    private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
    public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
    public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
    public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
    private static final List<PatternLevel> classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream(LOCAL_LOG_PROPERTIES_FILE));
    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    };
    private static PrintStream printStream;
    private final String className;
    private final Log.Level level;

    static {
        openLogFile(System.getProperty(LOCAL_LOG_FILE_PROPERTY));
    }

    public LocalLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        List<PatternLevel> list = classLevels;
        Log.Level level2 = null;
        if (list != null) {
            for (PatternLevel next : list) {
                if (next.pattern.matcher(str).matches() && (level2 == null || next.level.ordinal() < level2.ordinal())) {
                    level2 = next.level;
                }
            }
        }
        if (level2 == null) {
            String property = System.getProperty(LOCAL_LOG_LEVEL_PROPERTY);
            if (property == null) {
                level2 = DEFAULT_LEVEL;
            } else {
                try {
                    level2 = Log.Level.valueOf(property.toUpperCase());
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("Level '" + property + "' was not found", e2);
                }
            }
        }
        this.level = level2;
    }

    public static void openLogFile(String str) {
        if (str == null) {
            printStream = System.out;
            return;
        }
        try {
            printStream = new PrintStream(new File(str));
        } catch (FileNotFoundException e2) {
            throw new IllegalArgumentException("Log file " + str + " was not found", e2);
        }
    }

    public boolean isLevelEnabled(Log.Level level2) {
        return this.level.isEnabled(level2);
    }

    public void log(Log.Level level2, String str) {
        printMessage(level2, str, (Throwable) null);
    }

    public void log(Log.Level level2, String str, Throwable th) {
        printMessage(level2, str, th);
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        printStream.flush();
    }

    static List<PatternLevel> readLevelResourceFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                List<PatternLevel> configureClassLevels = configureClassLevels(inputStream);
                try {
                    inputStream.close();
                    return configureClassLevels;
                } catch (IOException unused) {
                    return configureClassLevels;
                }
            } catch (IOException e2) {
                PrintStream printStream2 = System.err;
                printStream2.println("IO exception reading the log properties file '/ormliteLocalLog.properties': " + e2);
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
        return null;
    }

    private static List<PatternLevel> configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (!(readLine.length() == 0 || readLine.charAt(0) == '#')) {
                String[] split = readLine.split(SimpleComparison.EQUAL_TO_OPERATION);
                if (split.length != 2) {
                    PrintStream printStream2 = System.err;
                    printStream2.println("Line is not in the format of 'pattern = level': " + readLine);
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Log.Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException unused) {
                        PrintStream printStream3 = System.err;
                        printStream3.println("Level '" + split[1] + "' was not found");
                    }
                }
            }
        }
    }

    private void printMessage(Log.Level level2, String str, Throwable th) {
        if (isLevelEnabled(level2)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(dateFormatThreadLocal.get().format(new Date()));
            sb.append(" [");
            sb.append(level2.name());
            sb.append("] ");
            sb.append(this.className);
            sb.append(' ');
            sb.append(str);
            printStream.println(sb.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }

    private static class PatternLevel {
        Log.Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern2, Log.Level level2) {
            this.pattern = pattern2;
            this.level = level2;
        }
    }
}
