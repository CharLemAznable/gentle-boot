package com.github.charlemaznable.gentle.spring.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/index")
    public String index() {
        return """
                If you wish to be the king of the jungle,
                it's not enough to act like a king.
                You must be the king.""";
    }
}
