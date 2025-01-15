package com.thc.winterspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/*
* /를 어떤 때에 붙여야하는건지
* PostController를 보면 page1 함수에서 +id는 return 해주지 않았는데 왜 그런지
* 왜 page, page1의 함수를 따로 만든건지 -> page1 함수로 모두 사용할 수 있는거 아닌지
* ***(GetMapping - @PathVariable)***
* */

@RequestMapping("/notice")
@Controller
public class NoticeController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "notice/" + page;
    }
    @GetMapping("/{page}/{id}")
    public String page1(@PathVariable String page,@PathVariable String id){
        return "notice/" + page + id;
    }

}
