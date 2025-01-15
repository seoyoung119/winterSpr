package com.thc.winterspr.controller;

import com.thc.winterspr.domain.Notice;
import com.thc.winterspr.domain.User;
import com.thc.winterspr.service.NoticeService;
import com.thc.winterspr.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {

    private final NoticeService noticeService;
    public NoticeRestController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("")
    public Long create(@RequestBody Map<String, Object> params) {
        return noticeService.create(params);
    }
    @PutMapping("")
    public int update(@RequestBody Map<String, Object> params) {
        noticeService.update(params);
        return 200;
    }
    @DeleteMapping("")
    public int delete(@RequestBody Long id) {
        noticeService.delete(id);
        return 200;
    }
    @GetMapping("")
    public Notice detail(@RequestParam Long id) {
        return noticeService.detail(id);
    }
    @GetMapping("/list")
    public List<Notice> list() {
        return noticeService.list();
    }
}
