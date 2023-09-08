package com.kusitms.hdmedi.service;

import com.kusitms.hdmedi.domain.dto.request.ContactMailRequestDto;
import com.kusitms.hdmedi.exception.utilException.MailException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UtilService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    private final String HDMEDI_MAIL_RECEIVER = "eckrin.dev@gmail.com";

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMail(ContactMailRequestDto dto) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setSubject("홈페이지 컨택 메일입니다.");
            helper.setTo(HDMEDI_MAIL_RECEIVER);

            HashMap<String, String> inMailValueMap = new HashMap<>();

            Context context = new Context();
            inMailValueMap.put("name", dto.getName());
            inMailValueMap.put("email", dto.getEmail());
            inMailValueMap.put("phone", dto.getPhoneNumber());
            inMailValueMap.put("subject", dto.getSubject());
            inMailValueMap.put("content", dto.getContent());

            inMailValueMap.forEach(context::setVariable);

            String html = templateEngine.process("mailform", context);
            helper.setText(html, true);
            helper.addInline("letter-image", new ClassPathResource("static/images/letter.png"));

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new MailException(e.getMessage());
        }
    }

    private MimeMessage createMimeMessage(ContactMailRequestDto dto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
//        message.setFrom(dto.getName()+" <"+dto.getEmail()+">");
        message.setSentDate(new Date());
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(HDMEDI_MAIL_RECEIVER));
        message.setSubject(dto.getSubject());
        message.setContent(dto.getContent(), "text/html;charset=UTF-8");
        return message;
    }
}
