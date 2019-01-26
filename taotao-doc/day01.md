
练习一：
  1.技术特点：
    .分布式
    .高并发、集群、负载均衡、高可用
    .海量数据
    .安全性

  2.系统架构

  3.搭建工程
      taotao-doc: 练习笔记
      taotao-parent: 父工程，打包方式pom
      |--taotao-common: 通用工具类、pojo，打包方式jar
      |--taotao-manager: 服务层工程，聚合工程，打包方式pom
         |--taotao-manager-dao: 打包方式jar
         |--taotao-manager-pojo: 打包方式jar
         |--taotao-manager-interface: 打包方式jar
         |--taotao-manager-service: 打包方式war
      |--taotao-manager-web: 表现层工程，打包方式war

  4.上传github：
      1. git init
      2. git add .
      3. git commit -m "taotao工程初始化"
      4. git remote add origin git@github.com:abcparadise/taotao.git
      5. git pull origin master  
      6. git push -u origin master  

      git pull origin master

      git 强行pull并覆盖本地文件
        git fetch --all  
        git reset --hard origin/master
        git pull
