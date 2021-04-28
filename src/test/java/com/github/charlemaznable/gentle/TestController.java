package com.github.charlemaznable.gentle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/index")
    public String index() {
        return "If you wish to be the king of the jungle,\n" +
                "it's not enough to act like a king.\n" +
                "You must be the king.";
    }
}
