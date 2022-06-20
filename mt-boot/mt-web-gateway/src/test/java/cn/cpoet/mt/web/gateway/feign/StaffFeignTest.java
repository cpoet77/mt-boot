package cn.cpoet.mt.web.gateway.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StaffFeignTest {
    @Autowired
    private StaffFeign staffFeign;

    @Test
    void hello() {
        System.out.println(staffFeign.hello());
    }
}