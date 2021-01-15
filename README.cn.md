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
   bean元数据的定义;存在RootBeanDefinition和GenericBeanDefinition等几种实体模型,但需要关注的是概念模型MergedBeanDefinition.
   只有该抽象模型才能被实例化为Bean,即其他BeanDefinition必须转化或合并为MergedBeanDefinition才能够表示完整的信息可以被实例化.
2. BeanDefinitionHolder
   BeanDefinition数据的持有者,保存了额外的信息,比如别名等.
3. FactoryBean和ObjectFactory
   FactoryBean在实例化(doGetBean)的时候有特殊调用(该类型的实例化结果返回的是getObject()类型而非其本身).
   ObjectFactory的作用是Bean工厂方法,强调的是Bean的实例化封装,是否返回新实例等.比如单例类型Bean会通过Scope来返回已经创建的对象,
   原型类型则每次都创建一个新的实例.
4. BeanFactory
   以区别ObjectFactory,此处翻译为'Bean容器'(强调保存而非生成)更适合。在web项目中,常见的应用上下文实现类都实现了该接口,但在功能
   实现上是内部持有一个BeanFactory子类来实现的(组合模式).因各个Bean的生命周期Scope不同,因此各Bean的存储位置也不同.
   单例模式(signle):保存在DefaultSingletonBeanRegistry(singletonObjects)中.单例有三级缓存,参考getSingleton()方法.
   原型模式(prototype): 每次都是创建新对象,因此无需保存.
   其他模式:包括request session等,该模式采用的是通过全局的不同类型的Scope(SessionScope,RequestScope)对象来保存实例.
5. BeanPostProcessor
   扩展点.Bean的后置处理器,提供在Bean实例化前和实例化后进行功能上的扩展;
   注册时机:BeanFactory初始化之后,非惰性加载单例Bean实例化之前注册自定义的BeanPostProcessor(AbstractApplicationContext#registerBeanPostProcessors).
   一些特殊的Spring内置的处理器(ApplicationContextAwareProcessor)会提前(AbstractApplicationContext#prepareBeanFactory)注册;
   回调时机:#getBean->#doGetBean->#createBean时进行回调.
6. BeanFactoryPostProcessor
   扩展点.BeanFactory的后置处理器.相较与Bean的后置处理器而言,该扩展点主要用于Spring内部不同BeanFactory实现的特殊处理;
   注册时机:BeanFactory初始化之后,非惰性单例初始化之前(AbstractApplicationContext#invokeBeanFactoryPostProcessors);
   回调时机:在注册后立即进行回调.
6. Scope
   参考BeanFactory
8. InitializingBean(与BeanPostProcessor的区别)
   子类在完成实例化后,BeanFactory会回调#afterPropertiesSet方法进行通知;
   与BeanPostProcessor的区别是:
    1.InitializingBean处理的对象是自身,而BeanPostProcessor处理的是所有Bean;
    2.执行顺序为BeanPostProcessor#postProcessBeforeInitialization > InitializingBean#afterPropertiesSet > BeanPostProcessor#postProcessAfterInitialization;
    3.执行入口都是#doGetBen->#initializeBean->#invokeInitMethods/#applyBeanPostProcessorsAfterInitialization;
__
### factory-support
1. BeanNameGenerator
### beans
1. BeanUtils
2. BeanWrapper



## context->(spring-core,spring-beans,spring-aop,spring-expression)
### ApplicationContext
1. ApplicationEventPublisher & ApplicationEventMulticaster
   扩展点.事件广播器.针对应用上下文事件进行广播. 真正进行广播动作的是ApplicationEventMulticaster#multicastEvent.
   注册时机:在#refresh过程中,进行初始化的(initApplicationEventMulticaster).
   若要实现自定义的广播通知,需要先获取到应用上下文,根据应用上下文拿到广播器ApplicationEventMulticaster进行广播.
2. ApplicationListener
   与广播器配合使用,监听应用上下文事件.
   

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
    代码片段(ContextLoader.configureAndRefreshWebApplicationContext())
    ~~~shell script
    protected void configureAndRefreshWebApplicationContext(ConfigurableWebApplicationContext wac, ServletContext sc) {
		if (ObjectUtils.identityToString(wac).equals(wac.getId())) {
			// The application context id is still set to its original default value
			// -> assign a more useful id based on available information
			String idParam = sc.getInitParameter(CONTEXT_ID_PARAM);
			if (idParam != null) {
				wac.setId(idParam);
			}
			else {
				// Generate default id...
				wac.setId(ConfigurableWebApplicationContext.APPLICATION_CONTEXT_ID_PREFIX +
						ObjectUtils.getDisplayString(sc.getContextPath()));
			}
			MyLogger.log("5.1当前WebApplicationContext设置id");
		}
		MyLogger.log("5.2当前WebApplicationContext和ServletContext进行相互引用(ServletContext中属性('org.springframework.web.context.WebApplicationContext.ROOT'))");
		wac.setServletContext(sc);
		String configLocationParam = sc.getInitParameter(CONFIG_LOCATION_PARAM);
		MyLogger.log("5.3设置WebApplicationContext的Spring配置文件configLocationParam的路径(读取web.xml的contextConfigLocation值)");
		if (configLocationParam != null) {
			wac.setConfigLocation(configLocationParam);
		}

		// The wac environment's #initPropertySources will be called in any case when the context
		// is refreshed; do it eagerly here to ensure servlet property sources are in place for
		// use in any post-processing or initialization that occurs below prior to #refresh
		ConfigurableEnvironment env = wac.getEnvironment();
		MyLogger.log("5.4实例化Environment对象");
		if (env instanceof ConfigurableWebEnvironment) {
			((ConfigurableWebEnvironment) env).initPropertySources(sc, null);
		}
		MyLogger.log("5.6定制WebapplicationContext(实例化所有配置的ApplicationContextInitializer,默认为空)");
		customizeContext(sc, wac);
		MyLogger.log("5.11正式启动WebApplicationContext,即调用refresh()方法");
		wac.refresh();
	}
    ~~~
13. Spring容器启动(调用refresh()方法)  
    前边所涉及到的Spring容器(即XmlWebApplicationContext)充当多个角色,包括ServletContext(组合方式),BeanFactory,ResourceResolver等.  
    在调用refresh()方法前,仅充当了ServletContext上下文的功能。该步骤之后才真正的进行BeanFactory的初始化.
14. 准备工作prepareRefresh()  
    设置启动时间,修改状态(closed=false,active=true)
15. 创建BeanFactory(obtainFreshBeanFactory())  
    先创建BeanFactory(DefaultListableBeanFactory的实例),让Spring容器真正拥有BeanFactory容器的功能,将Spring容器的id设置给新创建的BeanFactory  
    定制化BeanFactory,默认无定制内容  
    加载loadBeanDefinitions,加载Spring配置文件或者注解指定的Bean的定义文件(此时,Spring容器又充当了ResourceResolver的角色).
16. 初始化BeanFactory(prepareBeanFactory())  
    指定Bean的ClassLoader  
    指定Spel表达式的解析类SpelExpressionParser(此时的配置文件已被加载,但BeanDefinitions等可以用spel表达的内容还是表达式未被解析)  
    添加BeanPostProcessor处理器(对被初始化过的Bean进行后置处理)  
    将不需要自动注册入Bean添加到忽略列表中(这些Bean往往是BeanFactory自身所需的Bean,需通过自身特殊逻辑进行注入,例如:EnvironmentAware,EmbeddedValueResolverAware等)  
    给指定类型输入指定的值,被注入的值一般是容器启动后就唯一确定的(比如当前的BeanFactory,ApplicationEventPublisher,ApplicationContext,ResourceLoader等,也可以通过该方式将所需的值注入我们自定义的Bean中)  
    BeanFactory注入几个特殊的Bean(environment,systemProperties,systemEnvironment)
17. 注册几张常见的实例(postProcessBeanFactory-BeanFactory后置处理器,placeHolder占位符替换等)
    该方法是AbstractRefreshableWebApplicationContext对AbstractApplicationContext的扩展(开闭原则)  
    注册Scope的几种实例(RequestScope,SessionScope,ServletContextScope)  
    忽略ServletContextAware和ServletConfigAware的实例,不向BeanFactory注册  
    注册servletContext和servletConfig,忽略和注册这两步是为了保证上下文环境内该类型Bean的唯一性
18.