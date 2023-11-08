package org.example;

public class LogLine {
    String logLine;
    public LogLine(String logLine){
        this.logLine = logLine;
    }
    public enum LogLevel {
//        TRC(1),
//        DBG(2),
//        INF(4),
//        WRN(5),
//        ERR(6),
//        FTL(42);
        TRACE(1),
        DEBUG(2),
        INFO(4),
        WARNING(5),
        ERROR(6),
        FATAL(42);

        private final int numberOfLog;

        LogLevel(int numberOfLog) {
            this.numberOfLog = numberOfLog;
        }
    }

    public String getFrom(String logLine) {
        int indexOfFirstBracket = logLine.indexOf("[");
        int indexOfSecondBracket = logLine.indexOf("]");
        switch (logLine.substring(indexOfFirstBracket+1, indexOfSecondBracket)){
            case "TRC":
                return "1";
            case "DBG":
                return "2";
            case "INF":
                return "4";
            case "WRN":
                return "5";
            case "ERR":
                return "6";
            case "FTL":
                return "42";
            default:
                return "0";
        }
//        try{
//             return LogLevel.valueOf(logLine.substring(indexOfFirstBracket+1, indexOfSecondBracket)).numberOfLog;
//        }catch(IllegalArgumentException e){
//            return 0;
//        }
    }

    private LogLevel getLogLevel() {
       return LogLevel.valueOf(getFrom(this.logLine));
    }
//   private String getLogLevel() {
//        switch (getFrom(this.logLine)) {
//            case 0:
//                return "LogLine.Unknown";
//            case 1:
//                return "LogLine.TRACE";
//            case 2:
//                return "LogLine.DEBUG";
//            case 4:
//                return "LogLine.INFO";
//            case 5:
//                return "LogLine.WARNING";
//            case 6:
//                return "LogLine.ERROR";
//            case 42:
//                return "LogLine.FATAL";
//        }
//        return "";
//    }

    public String getOutputForShortLog(){
        return (getFrom(this.logLine));
    }

    public static void main(String[] args) {

        var logLine = new LogLine("[DBG]: ; expected");
        System.out.println(logLine.getLogLevel());
        System.out.println(LogLevel.valueOf("DEBUG"));

    }
}
