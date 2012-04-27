package com.prueba.cache.storage;

import java.util.Collection;

import com.prueba.cache.model.Message;

public interface MessageStorage {

	Message findMessage(long id);

	Collection<Message> findAllMessages();

	void addMessage(Message message);

	void setDelegate(MessageStorage storageDelegate);
}
