package com.prueba.cache;

import com.prueba.cache.model.Message;
import com.prueba.cache.storage.MessageStorage;
import com.prueba.cache.web.controllers.MessageController;
import net.sf.ehcache.CacheManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-context-test.xml" })
public class CachingTest {

	@Autowired
	ApplicationContext context;
	CacheManager cacheManager;
	MessageStorage storage;
	MessageStorage storageDelegate;
	MessageController controller;

	@Before
	public void before() throws Exception {
		this.storageDelegate = ((MessageStorage) Mockito
				.mock(MessageStorage.class));
		this.storage = ((MessageStorage) this.context.getBean("messageStorage"));
		this.storage.setDelegate(this.storageDelegate);
		this.controller = new MessageController(this.storage);

		this.cacheManager = ((CacheManager) this.context
				.getBean("cacheManager"));

		this.cacheManager.clearAll();
	}

	@Test
	public void testCaching_MessagesCache() {
		this.controller.getAllMessages();
		this.controller.getAllMessages();
		((MessageStorage) Mockito
				.verify(this.storageDelegate, Mockito.times(1)))
				.findAllMessages();
	}

	@Test
	public void testCaching_MessagesCacheRemove() {
		this.controller.getAllMessages();
		this.controller.getAllMessages();
		this.controller.addMessage(new Message());
		this.controller.getAllMessages();

		((MessageStorage) Mockito
				.verify(this.storageDelegate, Mockito.times(2)))
				.findAllMessages();
		((MessageStorage) Mockito
				.verify(this.storageDelegate, Mockito.times(1)))
				.addMessage((Message) Matchers.any(Message.class));
	}

	@Test
	public void testCaching_MessageCache() {
		this.controller.getMessageById(1L);
		this.controller.getMessageById(1L);
		this.controller.addMessage(new Message());
		this.controller.getMessageById(1L);

		((MessageStorage) Mockito
				.verify(this.storageDelegate, Mockito.times(1)))
				.findMessage(1L);
		((MessageStorage) Mockito
				.verify(this.storageDelegate, Mockito.times(1)))
				.addMessage((Message) Matchers.any(Message.class));
	}
}