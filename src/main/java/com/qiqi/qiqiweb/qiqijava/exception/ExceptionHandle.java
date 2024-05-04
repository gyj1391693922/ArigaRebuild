package com.qiqi.qiqiweb.qiqijava.movieManager.exception;

import com.qiqi.qiqiweb.qiqijava.Common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = ServiceException.class)
    public Result serviceexceptionError(ServiceException e){
        log.error("业务异常",e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误",e);
        return Result.error("系统错误");
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result DeleteExceptionError(Exception e){
        log.error("该剧下还有剧集存在，请删除剧集后再对该剧进行操作",e);
        return Result.error("该剧下还有剧集存在，请点击详细删除剧集后再对该剧进行操作");
    }

}
