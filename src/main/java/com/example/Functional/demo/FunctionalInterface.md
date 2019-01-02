# functionalInterface 使用

1、java8 `::` 代表的是访问函数的取代服，例如 String:: equals()

2、` ->` 作用是给遍历的，相当于for循环get（） ，Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
         详细请看`listToMap` 函数
         
3、Predicate<T> 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。可以用于接口请求参数校验、
    判断新老数据是否有变化需要进行更新操作。add--与、or--或、negate--非