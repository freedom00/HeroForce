package com.ys.backend.utilities;

import com.ys.backend.entity.Mail;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailHelper {
    private final static String PROTOCOL = "mail.transport.protocol";
    private final static String HOST = "mail.smtp.host";
    private final static String AUTH = "mail.smtp.auth";

    private final String myEmailAccount;
    private final String myEmailPassword;
    private final String myEmailSmtpHost;

    public MailHelper(String myEmailAccount, String myEmailPassword, String myEmailSmtpHost) {
        this.myEmailAccount = myEmailAccount;
        this.myEmailPassword = myEmailPassword;
        this.myEmailSmtpHost = myEmailSmtpHost;
    }

    /**
     * Send an email.
     *
     * @param mail Mail
     * @throws Exception MessageException
     */
    public void sendMail(Mail mail) throws Exception {
        Session session = getSession();
        MimeMessage mimeMessage = getMimeMessage(session, mail);

        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

    /**
     * create an session.
     *
     * @return an session.
     */
    private Session getSession() {
        Properties properties = new Properties();
        properties.setProperty(PROTOCOL, "smtp");
        properties.setProperty(HOST, myEmailSmtpHost);
        properties.setProperty(AUTH, "true");

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        return session;
    }

    /**
     * create a message.
     *
     * @param session Session
     * @param mail    Mail
     * @return a MimeMessage type message.
     * @throws Exception MessageException
     */
    private MimeMessage getMimeMessage(Session session, Mail mail) throws Exception {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(myEmailAccount, mail.getFromPersonal(), mail.getCharset()));
        if (null != mail.getTo()) {
            mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail.getTo(), mail.getToPersonal(), mail.getCharset()));
        }
        if (null != mail.getCc()) {
            mimeMessage.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(mail.getCc(), mail.getCcPersonal(), mail.getCharset()));
        }
        if (null != mail.getBcc()) {
            mimeMessage.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(mail.getBcc(), mail.getBccPersonal(), mail.getCharset()));
        }
        if (null != mail.getSubject()) {
            mimeMessage.setSubject(mail.getSubject(), mail.getCharset());
        }
        if (null != mail.getContent() && null != mail.getContentType()) {
            mimeMessage.setContent(mail.getContent(), mail.getContentType());
        } else if (null != mail.getContent()) {
            mimeMessage.setContent(mail.getContent(), "text/html;charset=UTF-8");
        }
        if (null != mail.getSentDate()) {
            mimeMessage.setSentDate(mail.getSentDate());
        } else {
            mimeMessage.setSentDate(new Date());
        }
        mimeMessage.saveChanges();

        return mimeMessage;
    }
}