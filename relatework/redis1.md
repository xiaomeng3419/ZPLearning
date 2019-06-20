redis 中使用hset 可以作为一个集群的心跳监测。减少了服务之间依赖性和交互性
 HSET KEY_NAME FIELD VALUE  
 Hdel可以删除心跳机制
 
 setnx尝试设置锁 
 只在键 key 不存在的情况下， 将键 key 的值设置为 value 。
 
 若键 key 已经存在， 则 SETNX 命令不做任何动作。
 
 SETNX 是『SET if Not eXists』(如果不存在，则 SET)的简写。
 
 