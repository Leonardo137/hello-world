package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Logger {

    private static final String RESET = "\u001b[37m";
    private static final String RED = "\u001b[31m";
    private static final String GREEN = "\u001b[32m";
    private static final String YELLOW = "\u001b[33m";
    private static final String BLUE = "\u001b[34m";
    private static final String MAGENTA = "\u001b[35m";
    private static final String CYAN = "\u001b[36m";

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static void log (String message) {
        log(message, LogLevel.INFO);
    }

    public static void log(String message, LogLevel level) {
        String log = "";
        String date  = dateFormat.format(System.currentTimeMillis());
        String threadname = Thread.currentThread().getName();

        //[yyyy-mm-dd hh:mm:ss.SSS][threadname] message

        switch (level) {
            case INFO -> log = YELLOW + "[" + date + "][" + threadname + "]" + " " + level + " " +  RESET + message;
            case DEBUG -> log = CYAN + "[" + date + "][" + threadname + "]" + " " + level + " " + RESET + message;
            case WARN -> log = MAGENTA + "[" + date + "][" + threadname + "]" + " " + level + " " + RESET + message;
            case ERROR -> log = RED + "[" + date + "][" + threadname + "]" + " " + level + " " + RESET + message;
            case STATUS -> log = BLUE + "[" + date + "][" + threadname + "]" + " " + level + " " + RESET + message;
            case SUCCESS -> log = GREEN + "[" + date + "][" + threadname + "]" +  " " + level + " " +RESET + message;
        }
        System.out.println(log);
    }
}



