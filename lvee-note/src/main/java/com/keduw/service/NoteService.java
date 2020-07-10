package com.keduw.service;

import com.keduw.model.Note;

/**
 * 笔记数据处理接口
 *
 * @author hongshengfeng
 * @date 2020/07/03
 */
public interface NoteService {

    Note info(String uuid);
}
