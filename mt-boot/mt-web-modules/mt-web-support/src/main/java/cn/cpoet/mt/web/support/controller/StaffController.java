package cn.cpoet.mt.web.support.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author CPoet
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
