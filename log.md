D:\file\apache-tomcat-7.0.85\bin\catalina.bat run
[2020-10-12 02:18:14,675] Artifact Gradle : org.springframework : spring-demo-5.2.3.BUILD-SNAPSHOT.war: Waiting for server connection to start artifact deployment...
Active code page: 65001
Using CATALINA_BASE:   "C:\Users\houshaoqian\.IntelliJIdea2019.3\system\tomcat\Unnamed_spring_4"
Using CATALINA_HOME:   "D:\file\apache-tomcat-7.0.85"
Using CATALINA_TMPDIR: "D:\file\apache-tomcat-7.0.85\temp"
Using JRE_HOME:        "C:\Program Files (x86)\Java\jdk1.8.0_131"
Using CLASSPATH:       "D:\file\apache-tomcat-7.0.85\bin\bootstrap.jar;D:\file\apache-tomcat-7.0.85\bin\tomcat-juli.jar"
十月 12, 2020 2:18:15 下午 org.apache.catalina.core.AprLifecycleListener init
警告: The APR based Apache Tomcat Native library failed to load. The error reported was [D:\file\apache-tomcat-7.0.85\bin\tcnative-1.dll: Can't load AMD 64-bit .dll on a IA 32-bit platform]
java.lang.UnsatisfiedLinkError: D:\file\apache-tomcat-7.0.85\bin\tcnative-1.dll: Can't load AMD 64-bit .dll on a IA 32-bit platform
	at java.lang.ClassLoader$NativeLibrary.load(Native Method)
	at java.lang.ClassLoader.loadLibrary0(ClassLoader.java:1941)
	at java.lang.ClassLoader.loadLibrary(ClassLoader.java:1857)
	at java.lang.Runtime.loadLibrary0(Runtime.java:870)
	at java.lang.System.loadLibrary(System.java:1122)
	at org.apache.tomcat.jni.Library.<init>(Library.java:42)
	at org.apache.tomcat.jni.Library.initialize(Library.java:178)
	at org.apache.catalina.core.AprLifecycleListener.init(AprLifecycleListener.java:200)
	at org.apache.catalina.core.AprLifecycleListener.isAprAvailable(AprLifecycleListener.java:108)
	at org.apache.catalina.connector.Connector.setProtocol(Connector.java:592)
	at org.apache.catalina.connector.Connector.<init>(Connector.java:66)
	at org.apache.catalina.startup.ConnectorCreateRule.begin(ConnectorCreateRule.java:62)
	at org.apache.tomcat.util.digester.Digester.startElement(Digester.java:1303)
	at com.sun.org.apache.xerces.internal.parsers.AbstractSAXParser.startElement(AbstractSAXParser.java:509)
	at com.sun.org.apache.xerces.internal.parsers.AbstractXMLDocumentParser.emptyElement(AbstractXMLDocumentParser.java:182)
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanStartElement(XMLDocumentFragmentScannerImpl.java:1339)
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl$FragmentContentDriver.next(XMLDocumentFragmentScannerImpl.java:2784)
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentScannerImpl.next(XMLDocumentScannerImpl.java:602)
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanDocument(XMLDocumentFragmentScannerImpl.java:505)
	at com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:841)
	at com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:770)
	at com.sun.org.apache.xerces.internal.parsers.XMLParser.parse(XMLParser.java:141)
	at com.sun.org.apache.xerces.internal.parsers.AbstractSAXParser.parse(AbstractSAXParser.java:1213)
	at com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl$JAXPSAXParser.parse(SAXParserImpl.java:643)
	at org.apache.tomcat.util.digester.Digester.parse(Digester.java:1576)
	at org.apache.catalina.startup.Catalina.load(Catalina.java:628)
	at org.apache.catalina.startup.Catalina.load(Catalina.java:679)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.catalina.startup.Bootstrap.load(Bootstrap.java:253)
	at org.apache.catalina.startup.Bootstrap.main(Bootstrap.java:427)

十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Server version:        Apache Tomcat/7.0.85
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Server built:          Feb 7 2018 18:52:33 UTC
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Server number:         7.0.85.0
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: OS Name:               Windows 7
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: OS Version:            6.1
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Architecture:          x86
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Java Home:             C:\Program Files (x86)\Java\jdk1.8.0_131\jre
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: JVM Version:           1.8.0_131-b11
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: JVM Vendor:            Oracle Corporation
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: CATALINA_BASE:         C:\Users\houshaoqian\.IntelliJIdea2019.3\system\tomcat\Unnamed_spring_4
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: CATALINA_HOME:         D:\file\apache-tomcat-7.0.85
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Djava.util.logging.config.file=C:\Users\houshaoqian\.IntelliJIdea2019.3\system\tomcat\Unnamed_spring_4\conf\logging.properties
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcom.sun.management.jmxremote=
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcom.sun.management.jmxremote.port=1099
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcom.sun.management.jmxremote.ssl=false
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcom.sun.management.jmxremote.password.file=C:\Users\houshaoqian\.IntelliJIdea2019.3\system\tomcat\Unnamed_spring_4\jmxremote.password
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcom.sun.management.jmxremote.access.file=C:\Users\houshaoqian\.IntelliJIdea2019.3\system\tomcat\Unnamed_spring_4\jmxremote.access
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Djava.rmi.server.hostname=127.0.0.1
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Djdk.tls.ephemeralDHKeySize=2048
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dignore.endorsed.dirs=
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcatalina.base=C:\Users\houshaoqian\.IntelliJIdea2019.3\system\tomcat\Unnamed_spring_4
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Dcatalina.home=D:\file\apache-tomcat-7.0.85
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.VersionLoggerListener log
信息: Command line argument: -Djava.io.tmpdir=D:\file\apache-tomcat-7.0.85\temp
十月 12, 2020 2:18:15 下午 org.apache.coyote.AbstractProtocol init
信息: Initializing ProtocolHandler ["http-bio-80"]
十月 12, 2020 2:18:15 下午 org.apache.coyote.AbstractProtocol init
信息: Initializing ProtocolHandler ["ajp-bio-8009"]
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.Catalina load
信息: Initialization processed in 340 ms
十月 12, 2020 2:18:15 下午 org.apache.catalina.core.StandardService startInternal
信息: Starting service Catalina
十月 12, 2020 2:18:15 下午 org.apache.catalina.core.StandardEngine startInternal
信息: Starting Servlet Engine: Apache Tomcat/7.0.85
十月 12, 2020 2:18:15 下午 org.apache.coyote.AbstractProtocol start
信息: Starting ProtocolHandler ["http-bio-80"]
十月 12, 2020 2:18:15 下午 org.apache.coyote.AbstractProtocol start
信息: Starting ProtocolHandler ["ajp-bio-8009"]
十月 12, 2020 2:18:15 下午 org.apache.catalina.startup.Catalina start
信息: Server startup in 57 ms
Connected to server
[2020-10-12 02:18:15,712] Artifact Gradle : org.springframework : spring-demo-5.2.3.BUILD-SNAPSHOT.war: Artifact is being deployed, please wait...
十月 12, 2020 2:18:16 下午 org.apache.catalina.startup.TldConfig execute
信息: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 1. ContextLoaderListener监听ServletContextEvent事件(ContextLoaderListener.contextInitialized()),spring容器开始启动
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 2.校验上下文Context中是否已包含'org.springframework.web.context.WebApplicationContext.ROOT'属性,包含代表Spring的Web容器已启动
十月 12, 2020 2:18:16 下午 org.springframework.web.context.ContextLoader initWebApplicationContext
信息: Root WebApplicationContext: initialization started
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 3.new一个全新WebApplicationContext
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 4.加载当前WebApplicationContext是否存在父容器(存在则设置父子关系),parent=null
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.配置并启动当前WebApplicationContext
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.1当前WebApplicationContext设置id
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.2当前WebApplicationContext和ServletContext进行相互引用(ServletContext中属性('org.springframework.web.context.WebApplicationContext.ROOT'))
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.3设置WebApplicationContext的Spring配置文件configLocationParam的路径(读取web.xml的contextConfigLocation值)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.4实例化Environment对象
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.5初始化Environment中的propertySources
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.6定制WebapplicationContext(实例化所有配置的ApplicationContextInitializer,默认为空)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.8从配置(globalInitializerClasses)中解析需要加载的ApplicationContextInitializer子类
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.9从配置(contextInitializerClasses)中解析需要加载的ApplicationContextInitializer子类
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 对需要加载ApplicationContextInitializer进行排序(排序规则:org.springframework.core.Ordered),并依次进行循环初始化(调用自身initialize())
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.11正式启动WebApplicationContext,即调用refresh()方法
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.12WebApplicationContxt启动准备工作(设置启动时间,状态,替换配置文件中占位符等)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 替换spring文件配置文件中的占位符
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.5初始化Environment中的propertySources
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.13WebApplicationContext创建BeanFactory,并解析配置文件以加载所有的BeanDefinition
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14配置BeanFactory(BeanPostProcessor,environment等核心组件)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.1BenFactory指定ClassLoader
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.2BenFactory指定BeanExpressionResolver
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.3BenFactory添加PropertyEditorRegistrar
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.4BenFactory添加BeanPostProcessor(ApplicationContextAwareProcessor)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(EnvironmentAware.class)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(EmbeddedValueResolverAware)
十月 12, 2020 2:18:16 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(ResourceLoaderAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(ApplicationEventPublisherAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(MessageSourceAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(ApplicationContextAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.6BenFactory给指定类型注入指定值(BeanFactory.class->beanFactory)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.6BenFactory给指定类型注入指定值(ResourceLoader.class->XmlWebApplicationContext(当前上下文AppplicationContext))
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.6BenFactory添加BeanPostProcessor(ApplicationListenerDetector)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.15postProcessBeanFactory(开闭原则,当前类为AbstractApplicationContext对子类扩展提供入口),此方法结束,表示BeanFactory初始化结束
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16AbstractRefreshableWebApplicationContext对AbstractApplicationContext的扩展
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16.1扩展-BeanPostProcessor(对ServletContextAware的子类赋值当前上下文)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16.1扩展-忽略(ServletContextAware.class和ServletConfigAware.class的自动注入
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17注册常用的Bean
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17.1注册Scope的几种实例(RequestScope,SessionScope,ServletContextScope)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17.2注册Scope的几种实例(EnvironmentBeans(servletConfig,servletContext))
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16调用BeanFactoryPostProcessors
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.event.internalEventListenerProcessor]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerFactory]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17注册BeanPostProcessors(BeanDefinition被初始化时通过回调调用)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalAutowiredAnnotationProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalCommonAnnotationProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.18初始化MessageSource()
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.19初始化ApplicationEventMulticaster(事件多路广播)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.20初始化ThemeSource
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.21注册监听器Listeners
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.22初始化所有非lazy-init的单例模式的Bean
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[userDao]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[userService]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23容器启动完成,处理其他后续事件
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.1容器启动完成,处理其他后续事件(清除ResourceCaches)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.1容器启动完成,处理其他后续事件(实例化DefaultLifecycleProcessor,负责管理容器的生命周期)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.2容器启动完成,处理其他后续事件(调用DefaultLifecycleProcessor的启动事件回调方法)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.3发布ContextRefreshedEvent事件
十月 12, 2020 2:18:17 下午 org.springframework.web.context.ContextLoader initWebApplicationContext
信息: Root WebApplicationContext initialized in 332 ms
[2020-10-12 02:18:17,137] Artifact Gradle : org.springframework : spring-demo-5.2.3.BUILD-SNAPSHOT.war: Artifact is deployed successfully
[2020-10-12 02:18:17,137] Artifact Gradle : org.springframework : spring-demo-5.2.3.BUILD-SNAPSHOT.war: Deploy took 1,425 milliseconds
十月 12, 2020 2:18:17 下午 org.springframework.web.servlet.FrameworkServlet initServletBean
信息: Initializing Servlet 'springmvc'
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.5初始化Environment中的propertySources
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.12WebApplicationContxt启动准备工作(设置启动时间,状态,替换配置文件中占位符等)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 替换spring文件配置文件中的占位符
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.5初始化Environment中的propertySources
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.13WebApplicationContext创建BeanFactory,并解析配置文件以加载所有的BeanDefinition
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14配置BeanFactory(BeanPostProcessor,environment等核心组件)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.1BenFactory指定ClassLoader
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.2BenFactory指定BeanExpressionResolver
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.3BenFactory添加PropertyEditorRegistrar
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.4BenFactory添加BeanPostProcessor(ApplicationContextAwareProcessor)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(EnvironmentAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(EmbeddedValueResolverAware)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(ResourceLoaderAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(ApplicationEventPublisherAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(MessageSourceAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.5BenFactory添加自动注入忽略列表(ApplicationContextAware.class)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.6BenFactory给指定类型注入指定值(BeanFactory.class->beanFactory)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.6BenFactory给指定类型注入指定值(ResourceLoader.class->XmlWebApplicationContext(当前上下文AppplicationContext))
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.14.6BenFactory添加BeanPostProcessor(ApplicationListenerDetector)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.15postProcessBeanFactory(开闭原则,当前类为AbstractApplicationContext对子类扩展提供入口),此方法结束,表示BeanFactory初始化结束
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16AbstractRefreshableWebApplicationContext对AbstractApplicationContext的扩展
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16.1扩展-BeanPostProcessor(对ServletContextAware的子类赋值当前上下文)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16.1扩展-忽略(ServletContextAware.class和ServletConfigAware.class的自动注入
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17注册常用的Bean
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17.1注册Scope的几种实例(RequestScope,SessionScope,ServletContextScope)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17.2注册Scope的几种实例(EnvironmentBeans(servletConfig,servletContext))
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.16调用BeanFactoryPostProcessors
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.event.internalEventListenerProcessor]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerFactory]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.17注册BeanPostProcessors(BeanDefinition被初始化时通过回调调用)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalAutowiredAnnotationProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalCommonAnnotationProcessor]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.18初始化MessageSource()
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.19初始化ApplicationEventMulticaster(事件多路广播)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.20初始化ThemeSource
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.21注册监听器Listeners
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.22初始化所有非lazy-init的单例模式的Bean
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[ttController]琚垵濮嬪寲鍚?-after
TtController构造函数
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[userController]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23容器启动完成,处理其他后续事件
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.1容器启动完成,处理其他后续事件(清除ResourceCaches)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.1容器启动完成,处理其他后续事件(实例化DefaultLifecycleProcessor,负责管理容器的生命周期)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.2容器启动完成,处理其他后续事件(调用DefaultLifecycleProcessor的启动事件回调方法)
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 5.23.3发布ContextRefreshedEvent事件
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.theme.FixedThemeResolver]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.function.support.RouterFunctionMapping]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.function.support.RouterFunctionMapping]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.function.support.HandlerFunctionAdapter]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.view.InternalResourceViewResolver]被初始化前
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.view.InternalResourceViewResolver]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.core.log.MyLogger log
信息: 2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.support.SessionFlashMapManager]琚垵濮嬪寲鍚?-after
十月 12, 2020 2:18:17 下午 org.springframework.web.servlet.FrameworkServlet initServletBean
信息: Completed initialization in 178 ms
十月 12, 2020 2:18:17 下午 org.springframework.web.servlet.DispatcherServlet noHandlerFound
警告: No mapping for GET /demo/
十月 12, 2020 2:18:18 下午 org.springframework.web.servlet.DispatcherServlet noHandlerFound
警告: No mapping for GET /demo/
