package com.digitalwallet.audit.service.model;

import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;
import org.springframework.data.mongodb.core.mapping.Document;


@Prefix("audit-log")
@Document(collection = "audit_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog extends BaseEntity {
    private String serviceName;
    private String entity;
    private String entityId;
    private String action; // CREATE, UPDATE, DELETE
    private String performedBy; // USERID VEYA USERNAME
    private String payload;
}
