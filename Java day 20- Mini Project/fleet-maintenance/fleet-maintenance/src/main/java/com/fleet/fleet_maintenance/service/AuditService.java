package com.fleet.fleet_maintenance.service;

import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class AuditService {

    private static final Logger logger =
            Logger.getLogger(AuditService.class.getName());

    public void logActivity(String activity) {
        logger.info(activity);
    }
}