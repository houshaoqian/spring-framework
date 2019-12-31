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


