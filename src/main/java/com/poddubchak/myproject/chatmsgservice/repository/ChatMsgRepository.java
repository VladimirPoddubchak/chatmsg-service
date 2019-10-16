package com.poddubchak.myproject.chatmsgservice.repository;

import com.poddubchak.microservicies.model.chatmsg.ChatMsg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by @author Vladimir Poddubchak @date 10.10.2019.
 */
@CrossOrigin
@RepositoryRestResource
public interface ChatMsgRepository extends CrudRepository<ChatMsg,Long> {
}
