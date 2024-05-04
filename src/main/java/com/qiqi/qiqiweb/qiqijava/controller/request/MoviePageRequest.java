package com.qiqi.qiqiweb.qiqijava.controller.request;

import lombok.Data;

@Data
public class LimitPageRequest extends LimitRequest {
    private String tcont;
    private String pNum;

}
