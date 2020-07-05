package com.keduw.service;

import com.keduw.model.NoteDTO;

/**
 * 笔记数据处理接口
 *
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
public interface NoteService {

    NoteDTO info(String uuid) throws Exception;
}
