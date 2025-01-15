package com.thc.winterspr.service.impl;

import com.thc.winterspr.domain.Notice;
import com.thc.winterspr.domain.User;
import com.thc.winterspr.repository.NoticeRepository;
import com.thc.winterspr.repository.PostRepository;
import com.thc.winterspr.repository.UserRepository;
import com.thc.winterspr.service.NoticeService;
import com.thc.winterspr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Long create(Map<String, Object> params) {

        String username = (String) params.get("username");
        Notice tempUser = noticeRepository.findByUsername(username);
        if(tempUser != null){
            return (long) -200; //아이디가 중복일때
        }

        Notice notice = new Notice();
        notice.setUsername(username);
        notice.setPassword((String) params.get("password"));
        notice.setName((String) params.get("name"));
        notice.setNick((String) params.get("nick"));
        notice.setPhone((String) params.get("phone"));

       noticeRepository.save(notice);
        return notice.getId();
    }

    @Override
    public void update(Map<String, Object> params) {
        Long id = Long.parseLong((String) params.get("id"));
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        if(params.get("password") != null) { notice.setPassword((String) params.get("password")); }
        if(params.get("name") != null) { notice.setName((String) params.get("name")); }
        if(params.get("nick") != null) { notice.setNick((String) params.get("nick")); }
        if(params.get("phone") != null) { notice.setPhone((String) params.get("phone")); }
        noticeRepository.save(notice);
    }

    @Override
    public void delete(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        noticeRepository.delete(notice);
    }

    @Override
    public Notice detail(Long id) {
        return noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
    }

    @Override
    public List<Notice> list() {
        return noticeRepository.findAll();
    }
}
