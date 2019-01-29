

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
    •	单一应用架构:
          当网站流量很小时，只需一个应用，将所有功能都部署在一起，以减少部署节点和成本;
          用于简化增删改查工作量的 数据访问框架(ORM) 是关键。
    •	垂直应用架构:
          当访问量逐渐增大，单一应用增加机器带来的加速度越来越小，将应用拆成互不相干的几个应用，以提升效率;
          用于加速前端页面开发的 Web框架(MVC) 是关键。
    •	分布式服务架构:  
          当垂直应用越来越多，应用之间交互不可避免，将核心业务抽取出来，作为独立的服务，逐渐形成稳定的服务中心，使前端应用能更快速的响应多变的市场需求;
          用于提高业务复用及整合的 分布式服务框架(RPC) 是关键。
    •	流动计算架构:
          当服务越来越多，容量的评估，小服务资源的浪费等问题逐渐显现，此时需增加一个调度中心基于访问压力实时管理集群容量，提高集群利用率。
          用于提高机器利用率的 资源调度和治理中心(SOA) 是关键。

      Dubbo 使用java开发,只能用于java项目之间的通信,是资源调度和治理中心的管理工具
      使用rpc协议进行远程调用,直接使用socket通信.传输效率高,并且可以统计出系统之间的调用关系和调用次数.

      系统间常用的远程通信方式：
         1、Webservice：效率不高基于soap协议。项目中不推荐使用。
         2、使用restful形式的服务：http+json。很多项目中应用。如果服务太多，服务之间调用关系混乱，需要治疗服务。
         3、使用dubbo。使用rpc协议进行远程调用，直接使用socket通信。传输效率高，并且可以统计出系统之间的调用关系、调用次数。

08.dubbo框架讲解
        Provider: 暴露服务的服务提供方。
        Consumer: 调用远程服务的服务消费方。
        Registry: 服务注册与发现的注册中心。
        Monitor: 统计服务的调用次调和调用时间的监控中心。
        Container: 服务运行容器。

09.zookeeper的安装步骤：
        1、安装jdk
        2、下载zookeeper http://mirror.bit.edu.cn/apache/zookeeper/
        3、上载压缩文件并解压
           tar zxf zookeeper-3.4.12.tar.gz
        4、将conf文件夹下zoo_sample.cfg重命名为zoo.cfg
           cd zookeeper-3.4.12/conf/
           mv zoo_sample.cfg zoo.cfg
        5、zookeeper-3.4.12目录下新建data目录
        6、修改配置文件zoo.cfg的dataDir属性，指定一个真实目录
           /root/zookeeper-3.4.12/data
        7、启动zookeeper
           bin/zkServer.sh start    // 启动zookeeper
           bin/zkServer.sh status   // 查看zookeeper状态
           // bin/zkServer.sh stop  // 关闭zookeeper
        8、关闭linux的防火墙/或者阿里云添加安全组规则（开放2181端口）
           systemctl status firewalld  // 查看firewalld状态 dead
           // systemctl stop firewalld // 关闭
           // systemctl start firewalld // 开启防火墙

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
  1、maven聚合项目导入project无法正常显示子模块
       导入maven项目就OK了
  2、MyBatis Generator踩坑,数据库版本不一致导致的一系列问题
      比较快捷、无脑的方法，选择好匹配的版本
  3、zookeeper安装成功后，但是无法正常使用
      开放2181端口

  4、 Invalid bound statement (not found): com.dj.taotao.mapper.TbItemMapper.selectByPrimaryKey
