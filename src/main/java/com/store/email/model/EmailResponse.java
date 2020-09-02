package com.store.email.model;

public class EmailResponse {

    String emailId;
    Boolean delivered;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }


    @Override
    public String toString() {
        return "Emailresponsemodel{" +
                "emailid='" + emailId + '\'' +
                ", delivered=" + delivered +
                '}';
    }


}
