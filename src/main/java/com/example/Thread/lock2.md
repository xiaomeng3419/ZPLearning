锁头的一些信息

|
---|---|---|---

biased_lock：对象是否启用偏向锁标记，只占1个二进制位。为1时表示对象启用偏向锁，为0时表示对象没有偏向锁。lock和biased_lock共同表示对象处于什么锁状态。

age：4位的Java对象年龄。在GC中，如果对象在Survivor区复制一次，年龄增加1。当对象达到设定的阈值时，将会晋升到老年代。默认情况下，并行GC的年龄阈值为15，并发GC的年龄阈值为6。由于age只有4位，所以最大值为15，这就是-XX:MaxTenuringThreshold选项最大值为15的原因。

identity_hashcode：31位的对象标识hashCode，采用延迟加载技术。调用方法System.identityHashCode()计算，并会将结果写到该对象头中。当对象加锁后（偏向、轻量级、重量级），MarkWord的字节没有足够的空间保存hashCode，因此该值会移动到管程Monitor中。

thread：持有偏向锁的线程ID。

epoch：偏向锁的时间戳。

ptr_to_lock_record：轻量级锁状态下，指向栈中锁记录的指针。

ptr_to_heavyweight_monitor：重量级锁状态下，指向对象监视器Monitor的指针。

锁只能升级成重量级锁，而不能降级
偏，轻，重锁，分别解决三个问题，只有一个线程进入临界区，多个线程交替进入临界区，多线程同时进入临界区。！

https://www.zhihu.com/question/39009953?sort=created 第二条评论