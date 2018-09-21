## wechat-public

* 单元测试添加mock部分，同时，完成有参构造函数的初始化操作。
* mock测试官网demo地址：  
 [https://github.com/powermock](https://github.com/powermock)  
 [https://github.com/powermock/powermock-examples-maven](https://github.com/powermock/powermock-examples-maven)

* mock测试完整依赖包如下(亲测可用，高版本尚未找到兼容关系)：

 ```xml
 <!--power mockito依赖部分 start-->
        <dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-api-mockito</artifactId>
            <version>1.6.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-module-junit4</artifactId>
            <version>1.6.1</version>
            <scope>test</scope>
        </dependency>
      <!--easymock  两个jar包必填，用于有参构造函数的初始化操作-->
        <dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-api-easymock</artifactId>
            <version>1.6.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.easymock</groupId>
            <artifactId>easymock</artifactId>
            <version>3.3</version>
            <scope>test</scope>
        </dependency>
        <!--mockito依赖,如果不用power-mockito，此部分可以单独使用-->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-all</artifactId>
            <version>1.9.5</version>
            <scope>test</scope>
        </dependency>
        <!--power mockito依赖部分 end-->
 ```

* `easymock`和`powermockito`版本对应关系

 PowerMock extends EasyMock with static mocking and setting expectations on constructors.

 |   EasyMock  |   PowerMock   |
 |---|---|
 | 3.4	     |     1.6.3+|
 | 3.3   |     Supported in 1.6.0 if you depend on cglib-nodep 2.2.2 |
 | 3.0 - 3.2    |    1.3.9 - 1.6.0 |
 | 2.5.x    |    1.3.7 & 1.3.8 |
 | 2.4.x or older  |     1.3.6  |
 
 其他更详细的的mock以及Junit测试参考地址：[https://github.com/os-technology/books/blob/dev/JunitMockTest/doc/JunitMockTest.md](https://github.com/os-technology/books/blob/dev/JunitMockTest/doc/JunitMockTest.md)
