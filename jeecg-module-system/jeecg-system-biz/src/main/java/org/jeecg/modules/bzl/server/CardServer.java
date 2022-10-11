package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.Card;

import java.util.List;

public interface CardServer {
    public List<Card> selectAll();
}
