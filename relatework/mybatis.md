# mybatis中mapper注意事项
 mapper中接口无法实现重载
 mapper.xml中的sql选项是根据 接口的`全限定名字` + `方法名字`来进行解析的
 
 源码待验证