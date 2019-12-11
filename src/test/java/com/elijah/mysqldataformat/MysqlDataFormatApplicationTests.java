package com.elijah.mysqldataformat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MysqlDataFormatApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GenerateDataBaseDocService generateDataBaseDocService;


	@Test
	void contextLoads() {
	}

	@Test
	void testGenerateDatabaseDoc(){
		logger.info("文档：\n{}",generateDataBaseDocService.generateDataBaseDocByName("acme","relay_cache","第三方信息缓冲表","v2.5.5.191211"));
		logger.info("文档：\n{}",generateDataBaseDocService.generateDataBaseDocByName("acme","relay_config","第三方信息配置表","v2.5.5.191211"));
		logger.info("文档：\n{}",generateDataBaseDocService.generateDataBaseDocByName("acme","relay_push_task","第三方报告推送表","v2.5.5.191211"));
	}

}
