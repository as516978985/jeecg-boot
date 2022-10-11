package org.jeecg.modules.bzl.server.impl;

import org.jeecg.modules.bzl.entity.Card;
import org.jeecg.modules.bzl.mapper.CardMapper;
import org.jeecg.modules.bzl.server.CardServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月11日 9:52
 */
@Service
public class CardServerImp implements CardServer {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public List<Card> selectAll() {
        return cardMapper.selectList(null);
    }
}
