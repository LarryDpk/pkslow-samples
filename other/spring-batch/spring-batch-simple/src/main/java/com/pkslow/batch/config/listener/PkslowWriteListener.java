package com.pkslow.batch.config.listener;

import com.pkslow.batch.entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;


public class PkslowWriteListener implements ItemWriteListener<Employee> {
    private static final Log logger = LogFactory.getLog(PkslowWriteListener.class);
    @Override
    public void beforeWrite(List<? extends Employee> list) {
        logger.info("beforeWrite: " + list);

    }

    @Override
    public void afterWrite(List<? extends Employee> list) {
        logger.info("afterWrite: " + list);

    }

    @Override
    public void onWriteError(Exception e, List<? extends Employee> list) {
        logger.info("onWriteError: " + list);
    }
}
