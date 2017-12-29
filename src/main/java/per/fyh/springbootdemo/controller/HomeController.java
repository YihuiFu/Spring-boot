package per.fyh.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class HomeController {
    Logger logger = LogManager.getLogger();

    @RequestMapping("/hello")
    public String Index() {
        logger.info("测试log");
        logger.error("错误啦，错误啦，错误啦--2017-12-28");
        return "Hello world 2222";
    }
}
