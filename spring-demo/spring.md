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




