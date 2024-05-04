package com.example.qiqijava.qiqiweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Mov {

    /**
     * id
     */
    private Integer id;

    /**
     * 上架时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 电影类型
     */
    private String types;

    /**
     * 电影名
     */
    private String movName;

    /**
     * 当前状态
     */
    private String stu;

    /**
     * 地区
     */
    private String region;

    /**
     * 电影时长
     */
    private String times;

    /**
     * 电影图片地址
     */
    private String img;

    /**
     * 电影视频地址
     */
    private String mvs;
}
