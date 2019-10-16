package com.poddubchak.myproject.chatmsgservice.service;


import com.poddubchak.microservicies.model.chatmsg.ChatMsg;

import java.util.List;
import java.util.Map;

/**
 * Created by @author Vladimir Poddubchak @date 10.10.2019.
 */

public interface ChatMsgService {

    List<ChatMsg> findAllMsg();
    ChatMsg findMsgById(long msgId);
    ChatMsg createMsg(ChatMsg msg);
    ChatMsg updateMsg(ChatMsg msg, long msgId);
    ChatMsg updateMsg(Map<String, String> updates, long msgId);
    void deleteMsg(long msgId);
}
