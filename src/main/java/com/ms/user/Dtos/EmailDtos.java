package com.ms.user.Dtos;

import lombok.Data;

import java.util.UUID;


@Data
public class EmailDtos {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
