package com.example.qiqijava.qiqiweb.controller;

import com.example.qiqijava.qiqiweb.common.ResponseResult;
import com.example.qiqijava.qiqiweb.common.Result;
import com.example.qiqijava.qiqiweb.controller.request.MovPageRequest;
import com.example.qiqijava.qiqiweb.entity.Mov;
import com.example.qiqijava.qiqiweb.service.IMovService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/mov")
public class MovController {

    @PostMapping("/upload")
    public ResponseResult uploadFile(@RequestParam(value = "file",required = false) MultipartFile file){
        // 判断文件是否为空
        if (file == null || file.isEmpty()) {
            return ResponseResult.fail();
        }

        if(file.isEmpty()){
            return ResponseResult.fail();
        }
        // 获取传过来的文件名字
        String OriginalFilename=file.getOriginalFilename();
        // 为了防止重名覆盖，获取系统时间戳+原始文件的后缀名
        String fileName=System.currentTimeMillis()+"."+OriginalFilename.substring(OriginalFilename.lastIndexOf(".")+1);
        // 设置保存地址（这里是转义字符）
        //1.后台保存位置
        String path = "D:\\projectDemo\\Qiqivideo\\Qiqi\\Qiqi-font\\qiqi\\src\\assets\\images\\";
        File dest=new File(path+fileName);
        // 判断文件是否存在
        if(!dest.getParentFile().exists()){
            // 不存在就创建一个
            dest.getParentFile().mkdirs();
        }
        try {
            // 后台上传
            file.transferTo(dest);
            return new ResponseResult(200, "文件上传成功", fileName);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.fail();
        }


    }

    @Autowired
    IMovService movService;

    //总查询
    @GetMapping("/page")
    public Result page(MovPageRequest movPageRequest){
        return Result.success(movService.page(movPageRequest
        ));
    }

    @GetMapping("/movlistId/{id}")
    public Result akaslistById(@PathVariable Integer id){
        Mov mov =movService.getBysIdMov(id);
        return Result.success(mov);
    }

    //修改查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Mov medicinal = movService.getById(id);
        return Result.success(medicinal);
    }
        //增加
    @PostMapping("/save")
    public Result save(@RequestBody Mov obj){

        movService.save(obj);
        return Result.success();
    }
        //修改
    @PostMapping("/update")
    public Result update(@RequestBody Mov obj){
        movService.update(obj);
        return Result.success();
    }
        //删除
    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Integer id){
        movService.deleteById(id);
        return Result.success();
    }
        //

}
