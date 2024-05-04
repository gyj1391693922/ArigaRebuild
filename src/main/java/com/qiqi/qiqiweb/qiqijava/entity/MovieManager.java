package com.qiqi.qiqiweb.qiqijava.movieManager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MovieManager {

    private Integer id;

    private Integer pNum;

    private String video;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date upTime;

    private Integer pid;

}
