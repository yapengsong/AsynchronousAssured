# AsynchronousAssured
本Demo用springboot实现 集成了springcloud的注册中心、网关等。
本Demo主要实现的是 消息最终一致性的方案。通过rabbitMq处理消息。
projectDemo1(生产者)
创建一个用户，在创建用户的同时创建一个消息 如果都创建成功 把消息发送给消息队列
UserService.java
 
ScheduledTasks.java
每隔一段时间轮询一遍消息表，把待发送未死亡的消息进行重发。（每隔3分钟循环一次，过5次置为死亡状态）
http://127.0.0.1:8080/msg/  通过这个页面可能查看消息列表和重发。
 
projectDemo2（消费者）
监听消息队列，取出消息，过滤重复消息，对消息内容进行业务处理。删除被处理过的消息。
Receiver.java
