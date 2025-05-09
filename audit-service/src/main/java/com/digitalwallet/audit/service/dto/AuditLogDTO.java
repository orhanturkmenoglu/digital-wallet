package com.digitalwallet.audit.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogDTO {
    private String serviceName;
    private String entity;
    private String entityId;
    private String action;
    private String performedBy;
    private String payload;
}
