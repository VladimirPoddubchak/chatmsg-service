package com.poddubchak.myproject.chatmsgservice.controller;

import com.poddubchak.microservicies.model.chatmsg.ChatMsg;
import com.poddubchak.microservicies.model.user.MyUser;
import com.poddubchak.myproject.chatmsgservice.service.ChatMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by @author Vladimir Poddubchak @date 10.10.2019.
 */

@RestController
@RequestMapping("/messages")
public class ChatMsgController {

    @Autowired
    ChatMsgService chatMsgService;


    /**
     curl -X GET localhost:8091/messages
     */
    @GetMapping
    public List<ChatMsg> findAllMsgs() {
        return chatMsgService.findAllMsg();
    }
    /**
     curl -X GET localhost:8091/messages/{msgId}
     */
    @GetMapping("/{msgId}")
    public ChatMsg findUser(@PathVariable Long msgId) {
        return chatMsgService.findMsgById(msgId);
    }
    /**
     curl -X POST localhost:8091/messages -H "Content-type:application/json" -d "{\"fromUserId\":\"6\",\"toUserId\":\"7\",\"msg\":\"Hello\",\"private\":\"false\"}"
     */
    @PostMapping
    public ChatMsg createMsg(@RequestBody ChatMsg msg) {
        return chatMsgService.createMsg(msg);
    }
    /**
     curl -X DELETE localhost:8091/messages/{msgId}
     */
    @DeleteMapping("/{msgId}")
    public void deleteMsg(@PathVariable Long msgId) {
        chatMsgService.deleteMsg(msgId);
    }
    /**
     curl -X PUT localhost:8091/messages/{msgId} -H "Content-type:application/json" -d "{\"fromUserId\":\"6\",\"toUserId\":\"7\",\"msg\":\"Hello\",\"private\":\"false\"}"
     */
    @PutMapping("/{msgId}")
    public ChatMsg updateMsg(@RequestBody ChatMsg msg, @PathVariable Long msgId) {
        return chatMsgService.updateMsg(msg, msgId);
    }
    /**
     curl -X PUT localhost:8091/messages/{msgId} -H "Content-type:application/json" -d "{\"fromUserId\":\"6\",\"toUserId\":\"7\",\"msg\":\"Hello\",\"private\":\"false\"}"     */
    @PatchMapping("/{msgId}")
    public ChatMsg updateMsg(@RequestBody Map<String, String> updates, @PathVariable Long msgId) {
        return chatMsgService.updateMsg(updates, msgId);
    }
}
