package com.poddubchak.myproject.chatmsgservice.service;

import com.poddubchak.microservicies.model.chatmsg.ChatMsg;
import com.poddubchak.myproject.chatmsgservice.excption.MsgNotFoundException;
import com.poddubchak.myproject.chatmsgservice.repository.ChatMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by @author Vladimir Poddubchak @date 10.10.2019.
 */
@Service
public class ChatMsgServiceImpl implements ChatMsgService {
    @Autowired
    ChatMsgRepository chatMsgRepository;


    @Override
    public List<ChatMsg> findAllMsg() {
        return (List)chatMsgRepository.findAll();
    }

    @Override
    public ChatMsg findMsgById(long msgId) {
        return chatMsgRepository.findById(msgId)
                .orElseThrow(() -> new MsgNotFoundException("Message not found. ID: " + msgId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ChatMsg createMsg(ChatMsg msg) {
        final ChatMsg newMsg = ChatMsg.builder()
                .fromUserId(msg.getFromUserId())
                .toUserId(msg.getToUserId())
                .msg(msg.getMsg())
                .isPrivate(msg.isPrivate())
                .timeStamp(new Date())
                .build();
        return chatMsgRepository.save(newMsg);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMsg(long msgId) {
        if (chatMsgRepository.existsById(msgId)) {
            chatMsgRepository.deleteById(msgId);
        }else{
            throw new MsgNotFoundException("Message not found. ID: " + msgId);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ChatMsg updateMsg(Map<String, String> updates, long msgId) {
        final ChatMsg msg = findMsgById(msgId);
        updates.keySet()
                .forEach(key -> {
                    switch (key) {
                        case "fromUserId":
                            msg.setFromUserId(Long.getLong(updates.get(key)));
                            break;
                        case "toUserId":
                            msg.setToUserId(Long.getLong(updates.get(key)));
                            break;
                        case "msg":
                            msg.setMsg(updates.get(key));
                            break;
                        case "private":
                            msg.setPrivate(Boolean.getBoolean(updates.get(key)));
                            break;
                    }
                });
        return chatMsgRepository.save(msg);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ChatMsg updateMsg(ChatMsg newMsgr, long msgId) {
        final ChatMsg msg = findMsgById(msgId);
        msg.setFromUserId(newMsgr.getFromUserId());
        msg.setToUserId(newMsgr.getToUserId());
        msg.setMsg(newMsgr.getMsg());
        msg.setPrivate(newMsgr.isPrivate());
        return chatMsgRepository.save(msg);
    }

}
