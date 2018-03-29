package com.xyzq.doit.zfq.example.activemq;

import java.io.Serializable;
import java.util.Date;

public class MessageBean implements Serializable {
    private String content;
    private Integer number;
    private Date proDate;

    @Override
    public String toString() {
        return "MessageBean{" +
               "content='" + content + '\'' +
               ", number=" + number +
               ", proDate=" + proDate +
               '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }
}
