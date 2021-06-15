package com.study.springCloud.commons.bean;

import lombok.Data;

@Data
public class LogInfo {

    private long id;

    private String url;

    private String param;

    private String result;

    private String time;
}
