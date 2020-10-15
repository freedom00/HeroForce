package com.ys.backend.entity;

import java.util.Date;

public class Mail {
    private String from;
    private String fromPersonal;
    private String to;
    private String toPersonal;
    private String cc;
    private String ccPersonal;
    private String bcc;
    private String bccPersonal;
    private String subject;
    private String content;
    private String contentType;
    private Date sentDate;
    private String charset;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromPersonal() {
        return fromPersonal;
    }

    public void setFromPersonal(String fromPersonal) {
        this.fromPersonal = fromPersonal;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToPersonal() {
        return toPersonal;
    }

    public void setToPersonal(String toPersonal) {
        this.toPersonal = toPersonal;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCcPersonal() {
        return ccPersonal;
    }

    public void setCcPersonal(String ccPersonal) {
        this.ccPersonal = ccPersonal;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getBccPersonal() {
        return bccPersonal;
    }

    public void setBccPersonal(String bccPersonal) {
        this.bccPersonal = bccPersonal;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
