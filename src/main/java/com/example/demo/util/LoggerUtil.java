package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LoggerUtil {

  private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  private LoggerUtil() {
  }

  public static void logInfo(String className, String message) {
    log("INFO", className, message);
  }

  public static void logWarn(String className, String message) {
    log("WARN", className, message);
  }

  public static void logError(String className, String message) {
    log("ERROR", className, message);
  }

  private static void log(String level, String className, String message) {
    String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
    System.out.println("[" + level + "] [" + timestamp + "] [" + className + "] - " + message);
  }
}