package com.qiqi.qiqiweb.qiqijava.controller.request;
import lombok.Data;

@Data
public class MovieManagerRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}