package com.digitalwallet.audit.service.controller;

import com.digitalwallet.audit.service.model.AuditLog;
import com.digitalwallet.audit.service.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @PostMapping
    public ResponseEntity<String> createAudit(@RequestBody AuditLog auditLog) {
        auditService.logAudit(auditLog);
        return ResponseEntity.ok("Audit log saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllAudits() {
        List<AuditLog> allAudits = auditService.getAllAudits();
        return ResponseEntity.ok(allAudits);
    }
}
