package com.example.northwind.core.utilities.logging;
import com.example.northwind.core.utilities.logging.entities.Logg;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class FileLogger implements Loggers{
    private static final Logger logger = LoggerFactory.getLogger(FileLogger.class);
    @Override
    public Logg log(String data) {
        return  null;
    }
    @Override
    public void add(String logMessage) {
        logger.info(String.format("Dosyaya Loglandı : " + logMessage), FileLogger.class.getSimpleName());
    }
}
