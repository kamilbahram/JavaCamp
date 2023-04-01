package com.example.northwind.core.utilities.logging;

import com.example.northwind.core.utilities.logging.entities.Logg;

public interface Loggers {
    void add(String logMessage);
    Logg log(String data);

}
