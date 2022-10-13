package org.jeecg.modules.bzl.server.impl;

import org.jeecg.modules.bzl.entity.Event;
import org.jeecg.modules.bzl.mapper.EventMapper;
import org.jeecg.modules.bzl.server.EventServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月12日 13:32
 */
@Service
public class EventServerImp implements EventServer {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Event> selectEventById(int id) {
        return eventMapper.selectEventByUserId(id);
    }

    @Override
    public List<Event> changeAttention(int id) {
        Event event = eventMapper.selectById(id);
        if (event == null) {
            return null;
        } else if ("1".equals(event.getAttentionFlag())) {
            eventMapper.changeAttention("0", id);
        } else {
            eventMapper.changeAttention("1", id);
        }
        return selectEventById(event.getUserId());
    }
}
