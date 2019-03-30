#### S:知识小普及

invokestatic 调用类方法（静态绑定，速度快）

invokevirtual 调用实例方法（动态绑定）

invokespecial 调用实例方法（静态绑定，速度快）

invokeinterface 调用引用类型为interface的实例方法（动态绑定）

invokedynamicJDK 7引入的，主要是为了支持动态语言的方法调用

先简要的分析一下这个流程把，

ldc 将常量池中的String入栈
astore_1 将栈顶ref对象保存至局部变量1
aload_1 将局部变量1入栈
invokedynamic动态调用
astore 保存最终的值到一个位置
return