package com.kusitms.hdmedi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MailForm extends DateEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Lob
    private String template;
}
