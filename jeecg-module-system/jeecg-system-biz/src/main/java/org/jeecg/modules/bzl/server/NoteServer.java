package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.Note;

import java.util.List;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月14日 16:37
 */
public interface NoteServer {


    List<Note> getNode(int userId, String date);

    List<Note> addNode(String content, String date,int userId);
}
