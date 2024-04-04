package cn.xlw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by xlw on 2024/4/4 12:52
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    public String test(){
        return "testing";
    }

}
