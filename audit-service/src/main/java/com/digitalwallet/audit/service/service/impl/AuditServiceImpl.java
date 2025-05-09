package com.digitalwallet.audit.service.service.impl;

import com.digitalwallet.audit.service.model.AuditLog;
import com.digitalwallet.audit.service.repository.AuditLogRepository;
import com.digitalwallet.audit.service.service.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuditServiceImpl implements AuditService {

    private final AuditLogRepository auditLogRepository;

    @Override
    public void logAudit(AuditLog auditLog) {
        auditLogRepository.save(auditLog);
    }

    @Override
    public List<AuditLog> getAllAudits() {
        return auditLogRepository.findAll();
    }
}
