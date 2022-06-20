package cn.cpoet.mt.web.comm.controller;

import cn.cpoet.mt.api.comm.LongGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    public final LongGenerator longGenerator;

    @GetMapping("/testId")
    private Long testId() {
        return longGenerator.nextId();
    }
}
