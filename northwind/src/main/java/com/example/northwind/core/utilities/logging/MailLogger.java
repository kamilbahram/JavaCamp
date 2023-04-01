package com.example.northwind.core.utilities.logging;

import com.example.northwind.core.utilities.logging.dataAccess.LogDao;
import com.example.northwind.core.utilities.logging.entities.Logg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class MailLogger implements Loggers {
    private static final Logger logger = LoggerFactory.getLogger(MailLogger.class);
    LogDao logDao;
    @Autowired
    public MailLogger(LogDao logDao) {
        this.logDao = logDao;
    }
    @Override
    public void add(String logMessage) {
        Logg logg = new Logg();
        logg.setMailLogger("Mail loglandı : " + logMessage);
        this.logDao.save(logg);
    }
    @Override
    public Logg log(String data) {
        logger.info(String.format("Mail loger : "), MailLogger.class.getSimpleName());
        return null;
    }
}
