package com.example.buysell.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// специальный класс, куда можно добавлять любые статичные методы для вывода логов

public class MyLogger {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void debugMethodName(String text) {
        System.out.println();
        System.out.println();
        logger.info(text); // аналогичная запись, но более короткая
    }

}
