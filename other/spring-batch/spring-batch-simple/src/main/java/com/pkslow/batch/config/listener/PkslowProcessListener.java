package com.pkslow.batch.config.listener;

import com.pkslow.batch.entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ItemProcessListener;

public class PkslowProcessListener implements ItemProcessListener<Employee, Employee> {
    private static final Log logger = LogFactory.getLog(PkslowProcessListener.class);

    @Override
    public void beforeProcess(Employee o) {
        logger.info("beforeProcess: " + o);

    }

    @Override
    public void afterProcess(Employee o, Employee o2) {
        logger.info("afterProcess o: " + o);
        logger.info("afterProcess o2: " + o2);

    }

    @Override
    public void onProcessError(Employee o, Exception e) {
        logger.info("onProcessError: " + o);

    }
}

