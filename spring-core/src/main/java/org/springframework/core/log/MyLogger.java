package org.springframework.core.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日志类
 * 
 * @author sheart7
 * @date 2020-09-25
 */
public class MyLogger {

	private static final Log logger = LogFactory.getLog(MyLogger.class);
	
	public static void log(Object msg){
	    logger.info(msg);
	}
}
