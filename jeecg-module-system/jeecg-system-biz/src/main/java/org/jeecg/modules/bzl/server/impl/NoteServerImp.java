package org.jeecg.modules.bzl.server.impl;

import org.jeecg.modules.bzl.entity.Note;
import org.jeecg.modules.bzl.mapper.NoteMapper;
import org.jeecg.modules.bzl.server.NoteServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月14日 16:37
 */
@Service
public class NoteServerImp implements NoteServer {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<Note> getNode(int userId, String date) {
        return noteMapper.selectNoteByDate(userId, date);
    }

    @Override
    public List<Note> addNode(String content, String date, int userId) {
        noteMapper.addNote(content, date, userId);
        return getNode(userId, date);
    }
}
