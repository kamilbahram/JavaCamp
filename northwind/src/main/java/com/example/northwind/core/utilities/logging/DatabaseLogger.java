package com.example.northwind.core.utilities.logging;

import com.example.northwind.core.utilities.logging.dataAccess.LogDao;
import com.example.northwind.core.utilities.logging.entities.Logg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLogger  implements Loggers{
    @Autowired
    LogDao logDao;
    public DatabaseLogger(LogDao logDao) {
        this.logDao = logDao;
    }
    @Override
    public void add(String logMessage) {
        Logg logg =new Logg();
        logg.setDatabaseLogger("Database loglandı : " + logMessage );
        this.logDao.save(logg);
    }
    @Override
    public Logg log(String data) {
        return null;
    }
}
