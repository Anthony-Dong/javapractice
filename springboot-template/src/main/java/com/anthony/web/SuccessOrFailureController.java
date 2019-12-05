package com.anthony.web;

import com.anthony.api.ApiLog;
import com.anthony.api.ApiResponse;
import com.anthony.core.BasicController;


import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 *  这个是我写的 一个  BasicController 模板类 可以记录日志 , 等操作  @ApiLog
 *
 * @date:2019/9/20 20:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


@RestController
public class SuccessOrFailureController extends BasicController {

    @ApiLog
    @GetMapping("/success/{id}")
    public ApiResponse<String> doSuccess(@PathVariable("id") String id) {

        return success(id);
    }


    @ApiLog
    @GetMapping("/success")
    public ApiResponse<String> doSuccessBy(@RequestParam("id") String id) {
        return success(id);
    }

    @ApiLog
    @PostMapping("/success")
    public ApiResponse<Person> doSuccessByPost(@RequestBody Person person) {
        return success(person);
    }



    @ApiLog
    @GetMapping("/failure")
    public ApiResponse<Integer> failure(){
        int x = 1 / 0;
        return success(66666);
    }



}
@Data
class Person{
    String name;
    Integer age;
}
