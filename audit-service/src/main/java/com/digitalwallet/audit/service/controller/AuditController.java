package com.digitalwallet.audit.service.controller;

import com.digitalwallet.audit.service.model.AuditLog;
import com.digitalwallet.audit.service.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllAudits() {
        List<AuditLog> allAudits = auditService.getAllAudits();
        return ResponseEntity.ok(allAudits);
    }
}
