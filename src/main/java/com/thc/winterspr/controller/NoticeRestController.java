//package com.thc.winterspr.controller;
//
//import com.thc.winterspr.domain.Post;
//import com.thc.winterspr.service.NoticeService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RequestMapping("/api/notice")
//@RestController
//public class NoticeRestController {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private final NoticeService noticeService;
//    public NoticeRestController(
//            NoticeService noticeService
//    ){
//        this.noticeService = noticeService;
//    }
//    @GetMapping("/create")
//    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
//        logger.info("create : " + params);
//
//        int[] arrayResultCode = noticeService.create(params);
//
//        Map<String, Object> returnValue = new HashMap<String, Object>();
//        returnValue.put("resultCode", arrayResultCode[0]);
//        returnValue.put("id", arrayResultCode[1]);
//
//        return returnValue;
//    }
//
//    @GetMapping("/update")
//    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
//        logger.info("update : " + params);
//
//        int resultCode = noticeService.update(params);
//
//        Map<String, Object> returnValue = new HashMap<String, Object>();
//        returnValue.put("resultCode", resultCode);
//
//        return returnValue;
//    }
//
//    @GetMapping("/delete")
//    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
//        logger.info("delete : " + params);
//
//        Long id = Long.parseLong(params.get("id").toString());
//        int resultCode = noticeService.delete(id);
//
//        Map<String, Object> returnValue = new HashMap<String, Object>();
//        returnValue.put("resultCode", resultCode);
//
//        return returnValue;
//    }
//    @GetMapping("/detail")
//    public Post detail(@RequestParam Long id) {
//        logger.info("detail id : " + id);
//        return noticeService.detail(id);
//    }
//
//    @GetMapping("/list")
//    public List<Post> list() {
//        logger.info("list");
//        return noticeService.list();
//    }
//}
