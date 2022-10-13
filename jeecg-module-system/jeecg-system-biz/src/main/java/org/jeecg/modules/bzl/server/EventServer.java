package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.Event;

import java.util.List;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月12日 13:32
 */

public interface EventServer {

    List<Event> selectEventById(int id);

    List<Event> changeAttention(int id);
}
