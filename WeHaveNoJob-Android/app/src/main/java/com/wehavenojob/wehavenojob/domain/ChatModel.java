package com.wehavenojob.wehavenojob.domain;

import lombok.Data;
import lombok.Getter;

/**
 * Created by judepark on 2017. 2. 17..
 */

public class ChatModel {
    private String text;
    private String senderId;
    private String senderName;

    public ChatModel() {
    }

    public ChatModel(String text, String senderId, String senderName) {
        this.text = text;
        this.senderId = senderId;
        this.senderName = senderName;
    }

    public String getText() {
        return text;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getSenderName() {
        return senderName;
    }
}
