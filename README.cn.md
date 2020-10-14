## BeanDefinition bean的抽象化定义 


Resource  Reader  BeanDefinition
# 使用 IoC 容器的过程
1. 创建 IoC 配置文件的抽象资源Resource,这个抽象资源包含了BeanDefinition的定义信息.
2. 创建一个IoC容器BeanFactory.
3. 创建一个载入BeanDefinition的读取器BeanDefinitionReader来载入各种形式的资源Resource并解析成BeanDefinition.
4. 将步骤3中的解析到的BeanDefinition注册到容器中.

# Spring 容器初始化过程
1. Resource的定位
2. BeanDefinition的载入或解析
3. BeanDefinition的注册


1.Resource定位
2.BeanDefinition的载入或解析载入



Spring + SpringMVC:

Step1:web.xml配置的Listener=ContextLoaderListener启动,initWebApplicationContext()方法初始化容器.
Step2:web.xml配置的DispatcherServlet启动,DispatcherServlet.init()方法实际执行的是HttpServletBean.init(),
    其间接调用了FrameworkServlet.initWebApplicationContext()初始化了容器.

Tips：
1. Spring 和 SpringMVC 的 ApplicationContext的逻辑实现都是XmlWebApplicationContext。
2. XmlWebApplicationContext本身是BeanFactory的实现类，但其真正的实现是其持有的DefaultListableBeanFactory实现的。
3. Spring的启动是在ContextLoaderListener中的initWebApplicationContext()。
4. SpringMVC的启动是在FrameworkServlet中的configureAndRefreshWebApplicationContext()。
5. Spring的容器是SpringMVC的父容器，当从子容器中获取不到Bean时，会从父容器中获取。


![Spring ](https://atts.w3cschool.cn/attachments/image/wk/wkspring/arch1.png)

## core->none
### asm
### cglib
### core
#### annotation
1. AliasFor
2. Order
3. AliasRegistry
#### codec 文档
#### env 环境
1. Profiles
2. Environment
#### IO log
1.Resource


## beans->(spring-core)
### annotation
1. Autowired
2. Qualifier
3. Lookup
4. Value
### factory
1. BeanDefinition
2. BeanDefinitionHolder
3. BeanPostProcessor
3. FactoryBean
4. BeanFactory
5. BeanPostProcessor
6. Scope
8. InitializingBean(与BeanPostProcessor的区别?)
### factory-support
1. BeanNameGenerator
### beans
1. BeanUtils
2. BeanWrapper



## context->(spring-core,spring-beans,spring-aop,spring-expression)
### ApplicationContext
### ApplicationEventPublisher


## WebApplicationContext拥有的角色 
1. BeanDefinitionRegistry 
2. BeanFactory
3. ServletContext
4. ResourceLoader

## 启动流程
1. Tomcat catalina.bat run tomcat容器启动.  
   1.1apache-tomcat-7.0.85\bin\catalina.bat run.  
   1.2配置(CATALINA_BASE、CATALINA_HOME、CATALINA_TMPDIR、JRE_HOME、CLASSPATH).  
   1.3Tomcat启动(空启动不包含war项目).
2. 调用Spring的启动入口.  
   Tomcat加载Servlet项目的web.xml文件,并读取其中的<listener>标签(通知所有ServletContextEvent的contextInitialized事件,即Servlet上下文启动完成,此步骤前均为web容器定义的流程,此后的流程为Spring或自定义的流程).
   ~~~xml
   <listener>
		<display-name>spring</display-name>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
   ~~~   
3.  检查Spring容器是否重复启动.  
    校验当前上下文ServletContext中是否已包含'org.springframework.web.context.WebApplicationContext.ROOT'的属性,包含代表Spring的Web容器已启动,则抛出异常.
4. 创建新的Spring容器,默认为XmlWebApplicationContext.
5. 查询当前Spring容器是否存在父容器,存在则设置父子容器关系.  
   ContextLoaderListener继承ContextLoader类,通过调用父类的loadParentContext()方法判断是否存在父容器,但该方法直接返回null.不知此步骤为何XXX
   ~~~shell script
    @Nullable
	protected ApplicationContext loadParentContext(ServletContext servletContext) {
		return null;
	}
   ~~~
6. 初始化并启动Spring容器  
   此步骤前的Spring容器虽然已被实例化,但并未进行初始化和启动(isActive()状态变更等).   
   步骤2-3中代码实现在ContextLoader类的initWebApplicationContext()方法中实现,详细代码如下.
   ~~~shell script
   public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		// 步骤3-检查Spring容器是否重复启动
		if (servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE) != null) {
			throw new IllegalStateException(
					"Cannot initialize context because there is already a root application context present - " +
					"check whether you have multiple ContextLoader* definitions in your web.xml!");
		}
		servletContext.log("Initializing Spring root WebApplicationContext");
		Log logger = LogFactory.getLog(ContextLoader.class);
		if (logger.isInfoEnabled()) {
			logger.info("Root WebApplicationContext: initialization started");
		}
		long startTime = System.currentTimeMillis();

		try {
			// Store context in local instance variable, to guarantee that
			// it is available on ServletContext shutdown.
			if (this.context == null) {
				// 步骤4-实例化一个新的Spring容器,默认为XmlWebApplicationContext
				this.context = createWebApplicationContext(servletContext);
			}
			if (this.context instanceof ConfigurableWebApplicationContext) {
				ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) this.context;
				if (!cwac.isActive()) {
					// The context has not yet been refreshed -> provide services such as
					// setting the parent context, setting the application context id, etc
					if (cwac.getParent() == null) {
						// The context instance was injected without an explicit parent ->
						// determine parent for root web application context, if any.
						ApplicationContext parent = loadParentContext(servletContext);
						// 步骤5-设置父子容器关系
						cwac.setParent(parent);
					}
					// 步骤6-初始化并启动Spring容器
					configureAndRefreshWebApplicationContext(cwac, servletContext);
				}
			}
			servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);

			ClassLoader ccl = Thread.currentThread().getContextClassLoader();
			if (ccl == ContextLoader.class.getClassLoader()) {
				currentContext = this.context;
			}
			else if (ccl != null) {
				currentContextPerThread.put(ccl, this.context);
			}

			if (logger.isInfoEnabled()) {
				long elapsedTime = System.currentTimeMillis() - startTime;
				logger.info("Root WebApplicationContext initialized in " + elapsedTime + " ms");
			}

			return this.context;
		}
		catch (RuntimeException | Error ex) {
			logger.error("Context initialization failed", ex);
			servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ex);
			throw ex;
		}
	}
   ~~~
7. 配置当前Spring容器id  
    容器id,容器唯一标识,对Spring功能作用不大,仅做打印时使用.可通过Servlet的通用配置自定义(contextId),默认值为WebApplicationContext的全类名+":"+ContextPath  
   例如:org.springframework.web.context.WebApplicationContext:/demo.  
   自定义的容器id需要在web.xml配置参数
   ~~~xml 
   <context-param>
       <param-name>contextId</param-name>
       <param-value>spring-demo-contextId</param-value>
   </context-param>
   ~~~
8. Spring容器和Servlet上下文相互引用  
   Spring容器和ServletContext相互引用的目的是更方便的进行获取各种ServletContext和Spring配置的参数.  
   互相引用的过程其实是先将ServletContext关联到Spring容器上(设置Spring容器的ServletContext属性()),等Spring容器完全初始化和启动后再将当前Spring容器关联到ServletContext上(添加到attributes中去的,其key值为"org.springframework.web.context.WebApplicationContext.ROOT")
9. 设置Spring配置文件路径  
   Spring默认的配置文件路径为"/WEB-INF/applicationContext.xml",但可以通过Servlet配置修改. 
   ~~~xml
   <context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring.xml</param-value>
	</context-param>
   ~~~
10. 实例化Environment对象  
    Environment对象是对Spring的多个Profile配置的封装,方便的进行多个配置间的切换。
11. 初始化Environment对象中的PropertySources  
    此处的PropertySources中的配置主要是系统相关的属性servletContextInitParams和servletConfigInitParams。整个PropertySources中包含的属性包含Servlet相关的环境变量和初始化参数、JDK相关的环境变量。
12. 定制Spring容器  
    在Spring容器启动前进行定制.定制是通过ApplicationContextInitializer类的回调方法实现的,定制内容包含注册配置,上下文等非BeanFactory配置.其实现类需要预先配置(Servlet配置globalInitializerClasses和contextInitializerClasses).注意此处还不能执行BeanFactory的相关方法(还未执行refresh方法).
13. Spring容器启动(调用refresh()方法)  
    前边所涉及到的Spring容器(即XmlWebApplicationContext)充当多个角色,包括ServletContext(组合方式),BeanFactory,ResourceResolver等.  
    在调用refresh()方法前,仅充当了ServletContext上下文的功能。
   
   
   
   5.4实例化Environment对象 十月 12, 2020 2:18:16 下午
   5.5初始化Environment中的propertySources 十月 12, 2020 2:18:16 下午
   5.6定制WebapplicationContext(实例化所有配置的ApplicationContextInitializer,默认为空)
   5.8从配置(globalInitializerClasses)中解析需要加载的ApplicationContextInitializer子类
   5.9从配置(contextInitializerClasses)中解析需要加载的ApplicationContextInitializer子类
   对需要加载ApplicationContextInitializer进行排序(排序规则:org.springframework.core.Ordered),并依次进行循环初始化(调用自身initialize())
   5.11正式启动WebApplicationContext,即调用refresh()方法 十月 12, 2020 2:18:16 下午
   5.12WebApplicationContxt启动准备工作(设置启动时间,状态,替换配置文件中占位符等) 十月 12, 2020
   替换spring文件配置文件中的占位符 5.5初始化Environment中的propertySources 十月 12, 2020
   2:18:16 下午
   5.13WebApplicationContext创建BeanFactory,并解析配置文件以加载所有的BeanDefinition 十月
   5.14配置BeanFactory(BeanPostProcessor,environment等核心组件) 十月 12, 2020
   5.14.1BenFactory指定ClassLoader 十月 12, 2020 2:18:16 下午
   5.14.2BenFactory指定BeanExpressionResolver 十月 12, 2020 2:18:16 下午
   5.14.3BenFactory添加PropertyEditorRegistrar 十月 12, 2020 2:18:16 下午
   5.14.4BenFactory添加BeanPostProcessor(ApplicationContextAwareProcessor)
   5.14.5BenFactory添加自动注入忽略列表(EnvironmentAware.class) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(EmbeddedValueResolverAware) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(ResourceLoaderAware.class) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(ApplicationEventPublisherAware.class) 十月
   5.14.5BenFactory添加自动注入忽略列表(MessageSourceAware.class) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(ApplicationContextAware.class) 十月 12, 2020
   5.14.6BenFactory给指定类型注入指定值(BeanFactory.class->beanFactory) 十月 12,
   5.14.6BenFactory给指定类型注入指定值(ResourceLoader.class->XmlWebApplicationContext(当前上下文AppplicationContext))
   5.14.6BenFactory添加BeanPostProcessor(ApplicationListenerDetector) 十月
   5.15postProcessBeanFactory(开闭原则,当前类为AbstractApplicationContext对子类扩展提供入口),此方法结束,表示BeanFactory初始化结束
   5.16AbstractRefreshableWebApplicationContext对AbstractApplicationContext的扩展
   5.16.1扩展-BeanPostProcessor(对ServletContextAware的子类赋值当前上下文) 十月 12,
   5.16.1扩展-忽略(ServletContextAware.class和ServletConfigAware.class的自动注入
   5.17注册常用的Bean 十月 12, 2020 2:18:17 下午
   5.17.1注册Scope的几种实例(RequestScope,SessionScope,ServletContextScope) 十月
   5.17.2注册Scope的几种实例(EnvironmentBeans(servletConfig,servletContext)) 十月
   5.16调用BeanFactoryPostProcessors 十月 12, 2020 2:18:17 下午
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.event.internalEventListenerProcessor]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerProcessor]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerFactory]琚垵濮嬪寲鍚?-after
   5.17注册BeanPostProcessors(BeanDefinition被初始化时通过回调调用) 十月 12, 2020
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalAutowiredAnnotationProcessor]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalCommonAnnotationProcessor]琚垵濮嬪寲鍚?-after
   5.18初始化MessageSource() 十月 12, 2020 2:18:17 下午
   5.19初始化ApplicationEventMulticaster(事件多路广播) 十月 12, 2020 2:18:17 下午 12,
   2020 2:18:17 下午 org.springframework.core.log.MyLogger log 信息:
   5.21注册监听器Listeners 十月 12, 2020 2:18:17 下午
   5.22初始化所有非lazy-init的单例模式的Bean 十月 12, 2020 2:18:17 下午
   2BeanPostProcessor澶勭悊鍣?-Bean[userDao]琚垵濮嬪寲鍚?-after 十月 12, 2020
   2BeanPostProcessor澶勭悊鍣?-Bean[userService]琚垵濮嬪寲鍚?-after 十月 12, 2020
   5.23容器启动完成,处理其他后续事件 十月 12, 2020 2:18:17 下午
   5.23.1容器启动完成,处理其他后续事件(清除ResourceCaches) 十月 12, 2020 2:18:17 下午
   5.23.1容器启动完成,处理其他后续事件(实例化DefaultLifecycleProcessor,负责管理容器的生命周期) 十月
   5.23.2容器启动完成,处理其他后续事件(调用DefaultLifecycleProcessor的启动事件回调方法) 十月 12,
   5.23.3发布ContextRefreshedEvent事件 十月 12, 2020 2:18:17 下午
   initWebApplicationContext 信息: Root WebApplicationContext initialized
   Initializing Servlet 'springmvc' 十月 12, 2020 2:18:17 下午
   5.5初始化Environment中的propertySources 十月 12, 2020 2:18:17 下午
   5.12WebApplicationContxt启动准备工作(设置启动时间,状态,替换配置文件中占位符等) 十月 12, 2020
   替换spring文件配置文件中的占位符 十月 12, 2020 2:18:17 下午
   5.5初始化Environment中的propertySources 十月 12, 2020 2:18:17 下午
   5.13WebApplicationContext创建BeanFactory,并解析配置文件以加载所有的BeanDefinition 十月
   5.14配置BeanFactory(BeanPostProcessor,environment等核心组件) 十月 12, 2020
   5.14.1BenFactory指定ClassLoader 十月 12, 2020 2:18:17 下午
   5.14.2BenFactory指定BeanExpressionResolver 十月 12, 2020 2:18:17 下午
   5.14.3BenFactory添加PropertyEditorRegistrar 十月 12, 2020 2:18:17 下午
   5.14.4BenFactory添加BeanPostProcessor(ApplicationContextAwareProcessor)
   5.14.5BenFactory添加自动注入忽略列表(EnvironmentAware.class) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(EmbeddedValueResolverAware) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(ResourceLoaderAware.class) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(ApplicationEventPublisherAware.class) 十月
   5.14.5BenFactory添加自动注入忽略列表(MessageSourceAware.class) 十月 12, 2020
   5.14.5BenFactory添加自动注入忽略列表(ApplicationContextAware.class) 十月 12, 2020
   5.14.6BenFactory给指定类型注入指定值(BeanFactory.class->beanFactory) 十月 12,
   5.14.6BenFactory给指定类型注入指定值(ResourceLoader.class->XmlWebApplicationContext(当前上下文AppplicationContext))
   5.14.6BenFactory添加BeanPostProcessor(ApplicationListenerDetector) 十月
   5.15postProcessBeanFactory(开闭原则,当前类为AbstractApplicationContext对子类扩展提供入口),此方法结束,表示BeanFactory初始化结束
   5.16AbstractRefreshableWebApplicationContext对AbstractApplicationContext的扩展
   5.16.1扩展-BeanPostProcessor(对ServletContextAware的子类赋值当前上下文) 十月 12,
   5.16.1扩展-忽略(ServletContextAware.class和ServletConfigAware.class的自动注入
   5.17注册常用的Bean 十月 12, 2020 2:18:17 下午
   5.17.1注册Scope的几种实例(RequestScope,SessionScope,ServletContextScope) 十月
   5.17.2注册Scope的几种实例(EnvironmentBeans(servletConfig,servletContext)) 十月
   5.16调用BeanFactoryPostProcessors 十月 12, 2020 2:18:17 下午
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.context.event.internalEventListenerProcessor]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerProcessor]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.event.internalEventListenerFactory]琚垵濮嬪寲鍚?-after
   5.17注册BeanPostProcessors(BeanDefinition被初始化时通过回调调用) 十月 12, 2020
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalAutowiredAnnotationProcessor]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.context.annotation.internalCommonAnnotationProcessor]琚垵濮嬪寲鍚?-after
   5.18初始化MessageSource() 十月 12, 2020 2:18:17 下午
   5.19初始化ApplicationEventMulticaster(事件多路广播) 十月 12, 2020 2:18:17 下午
   org.springframework.core.log.MyLogger log 信息: 5.20初始化ThemeSource 十月
   5.21注册监听器Listeners 十月 12, 2020 2:18:17 下午
   5.22初始化所有非lazy-init的单例模式的Bean 十月 12, 2020 2:18:17 下午
   2BeanPostProcessor澶勭悊鍣?-Bean[ttController]琚垵濮嬪寲鍚?-after
   TtController构造函数 十月 12, 2020 2:18:17 下午
   2BeanPostProcessor澶勭悊鍣?-Bean[userController]琚垵濮嬪寲鍚?-after 十月 12,
   5.23容器启动完成,处理其他后续事件 十月 12, 2020 2:18:17 下午
   5.23.1容器启动完成,处理其他后续事件(清除ResourceCaches) 十月 12, 2020 2:18:17 下午
   5.23.1容器启动完成,处理其他后续事件(实例化DefaultLifecycleProcessor,负责管理容器的生命周期) 十月
   5.23.2容器启动完成,处理其他后续事件(调用DefaultLifecycleProcessor的启动事件回调方法) 十月 12,
   5.23.3发布ContextRefreshedEvent事件 十月 12, 2020 2:18:17 下午
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.theme.FixedThemeResolver]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.function.support.RouterFunctionMapping]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.function.support.RouterFunctionMapping]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.function.support.HandlerFunctionAdapter]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator]琚垵濮嬪寲鍚?-after
   ApplicationContextAwareProcessor处理器-Bean[org.springframework.web.servlet.view.InternalResourceViewResolver]被初始化前
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.view.InternalResourceViewResolver]琚垵濮嬪寲鍚?-after
   2BeanPostProcessor澶勭悊鍣?-Bean[org.springframework.web.servlet.support.SessionFlashMapManager]琚垵濮嬪寲鍚?-after
   Completed initialization in 178 ms 十月 12, 2020 2:18:17 下午
