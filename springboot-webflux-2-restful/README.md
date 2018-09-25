##  WebFlux-restflu

* ConcurrentHashMap   支持线程安全的并发容器 ConcurrentHashMap,原理和HashMap差不多，区别就是采用了CAS + synchronized 来保证并发安全性
* putVal 加了同步锁 synchronized

*   AtomicLong是作用是对长整形进行原子操作，显而易见，在java1.8中新加入了一个新的原子类LongAdder，该类也可以保证Long类型操作的原子性，相对于AtomicLong，LongAdder有着更高的性能和更好的表现，可以完全替代AtomicLong的来进行原子操作。
*  在32位操作系统中，64位的long 和 double 变量由于会被JVM当作两个分离的32位来进行操作，所以不具有原子性。而使用AtomicLong能让long的操作保持原子型。


Reactor有两种类型，Flux<T>和Mono<T>。Flux类似RaxJava的Observable，它可以触发零到多个事件，并根据实际情况结束处理或触发错误。

Mono最多只触发一个事件，它跟RxJava的Single和Maybe类似，所以可以把Mono<Void>用于在异步任务完成时发出通知。

优点
1）响应快，不必为单个同步时间所阻塞，虽然Reactor本身依然是同步的； 
2）编程相对简单，可以最大程度的避免复杂的多线程及同步问题，并且避免了多线程/进程的切换开销； 
3）可扩展性，可以方便的通过增加Reactor实例个数来充分利用CPU资源； 
4）可复用性，reactor框架本身与具体事件处理逻辑无关，具有很高的复用性；
缺点

1）相比传统的简单模型，Reactor增加了一定的复杂性，因而有一定的门槛，并且不易于调试。 
2）Reactor模式需要底层的Synchronous Event Demultiplexer支持，比如Java中的Selector支持，操作系统的select系统调用支持，如果要自己实现Synchronous Event Demultiplexer可能不会有那么高效。 
3） Reactor模式在IO读写数据时还是在同一个线程中实现的，即使使用多个Reactor机制的情况下，那些共享一个Reactor的Channel如果出现一个长时间的数据读写，会影响这个Reactor中其他Channel的相应时间，比如在大文件传输时，IO操作就会影响其他Client的相应时间，因而对这种操作，使用传统的Thread-Per-Connection或许是一个更好的选择，或则此时使用Proactor模式。