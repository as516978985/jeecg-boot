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
}
