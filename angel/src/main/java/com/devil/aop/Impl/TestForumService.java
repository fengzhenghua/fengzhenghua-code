package com.devil.aop.Impl;

import com.devil.aop.service.ForumService;

public class TestForumService {
	public static void main(String[] args) {
		ForumService forumService = new ForumServiceImpl();
		forumService.removeForum(10);
		forumService.removeTopic(1012);
	}
}
