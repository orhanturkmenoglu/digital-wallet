package com.digitalwallet.audit.service.service;

import com.digitalwallet.audit.service.model.AuditLog;

import java.util.List;

public interface AuditService {

    void logAudit(AuditLog auditLog);

    List<AuditLog> getAllAudits();
}
