

01.day02清单：
   1.1、ssm整合
   1.2、服务中间件dubbo
   1.3、整合测试
   1.4、商品列表查询实现

02.mybatis逆向工程
  JAVA8
  数据库mysql 5.7
  mysql驱动mysql-connector-java-6.0.6.jar
  Mybatis Generator 1.3.5
  pojo类和mapper.xml文件的生成

03.ssm整合-dao层
  2.1、SqlMapConfig.xml
  2.2、db.properties
  2.3、applicationContext-dao.xml
       .加载db.properties文件
       .配置数据库连接池
       .SqlSessionFactory
       .Mapper映射文件的包扫描器

04.ssm整合-service层
  3.1、applicationContext-service.xml
  3.2、applicationContext-trans.xml
  3.3、web.xml中初始化spring容器

05.spring容器的父子关系
   Service层-spring父容器（ContextLoaderListener初始化）
   service、dao

   Controller层-spring子容器(DispatcherServlet初始化)
   controller(action)

   访问规则：子容器可以访问父容器的对象，父容器不可以访问子容器的对象

06.ssm整合-springmvc的配置
   6.1.web工程中新增springmvc.xml
       .配置注解驱动
       .视图解析器
       .配置包扫描器，扫描带@Controller注解的类
   6.2.web.xml
       .post乱码过滤器
       .前端控制器

07.dubbo的概念

08.dubbo框架讲解

09.zookeeper的安装

10.发布dubbo服务

11.引用dubbo服务

12.服务调用测试

13.dubbo的监控中心

14.展示后台管理页面

15.商品列表展示-功能分析

16.PageHelper的使用方法

17.商品列表查询-实现

18.商品列表查询-测试

碰到的问题：
  5.1、maven聚合项目导入project无法正常显示子模块
       导入maven就OK了
  5.2、MyBatis Generator踩坑,数据库版本不一致导致的一系列问题
      比较快捷、无脑的方法，选择好匹配的版本
