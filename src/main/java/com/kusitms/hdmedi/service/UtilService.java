package com.kusitms.hdmedi.service;

import com.kusitms.hdmedi.domain.dto.request.ContactMailRequestDto;
import com.kusitms.hdmedi.exception.utilException.MailException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UtilService {

    private final JavaMailSender mailSender;

    private final String MAIL_RECEIVER = "eckrin.dev@gmail.com";

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMail(ContactMailRequestDto dto) {
        try {
            MimeMessage message = createMimeMessage(dto);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new MailException(e.getMessage());
        }
    }

    private MimeMessage createMimeMessage(ContactMailRequestDto dto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
//        message.setFrom(dto.getName()+" <"+dto.getEmail()+">");
        message.setSentDate(new Date());
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(MAIL_RECEIVER));
        message.setSubject(dto.getSubject());
        message.setContent(dto.getContent(), "text/html;charset=UTF-8");
        return message;
    }
}
