package com.wehavenojob.wehavenojob.domain;

import lombok.Data;
import lombok.Getter;

/**
 * Created by judepark on 2017. 2. 17..
 */

public class ChatModel {
    private String content;

    public ChatModel() {
    }

    public ChatModel(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
