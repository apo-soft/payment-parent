1. wechat-demo 的构建目的是用于简单的展示wechat-payment所使用的接口
2. 在项目中,我们使用了spring-mvc技术作为项目的整体构建基础
3. 项目中使用了二维码生成工具,用于作为生成二维码的demo,供初学者使用.
4. 为了简便起见,项目使用redis 3.0 作为持久化存储,并使用了spring-data-redis组件来封装部分操作
       初始化项目时,需要在redis中执行如下命令:  set "wechat_order_no:next_seq" 10000000
       在测试机上需要配置redis服务器的host为 redis.server.aposoft.cn