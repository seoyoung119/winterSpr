package com.thc.winterspr.service;

import com.thc.winterspr.domain.Notice;
import com.thc.winterspr.domain.User;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    Long create(Map<String, Object> params);
    void update(Map<String, Object> params);
    void delete(Long id);
    Notice detail(Long id);
    List<Notice> list();
}
