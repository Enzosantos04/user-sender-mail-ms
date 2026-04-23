package dev.java10x.email.entity;

import dev.java10x.email.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "emails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String emailSubject;
    @Column(columnDefinition = "BODY")
    private String body;
    private LocalDateTime sendDateEmail;
    private EmailStatus emailStatus;

}

