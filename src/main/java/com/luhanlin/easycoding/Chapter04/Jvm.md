### 1. 类加载
- **BootStrap ClassLoader** 加载JDK中lib下的文件
- **Extension ClassLoader/PlatformClassLoader* 加载ext/**.jar中的文件
- **Application ClassLoader** 加载classpath下面用户创建的文件
- 可以集成ClassLoader进行自定义类加载器，一般常用于隔离加载类

### 2. JVM内存布局
- **Heap（堆区）**
> 堆区分为新声代和老年代，新生代分为1个Eden和两个Survivor区，通常我们设置参数进行内存动态调优：
-Xms 2G 
-Xmx 2G
-XX:+HeapDumpOnOutOfMemoryError # 此参数可以在系统内存溢出时生成错误监控文件

- **Metaspace（元数据区）**
> 堆区在Java8以后取消了*永久区*，更改为*元数据区*，可以进行水平的扩容，默认的MaxPermSize=2560m;

- **JVM Stack（虚拟机栈）**
    - 局部变量表
    - 操作栈
    - 动态连接  -- 在常量池中有一个对当前方法的引用，支持方法的动态连接
    - 方法返回地址 
    
- **Native Method Stacks(本地方法栈)**
> 主要用来进行native方法的调用

- **Program Counter Register(程序计数寄存器)**
> 堆区和元数据区为线程共享区域，而其他区域为线程私有。程序计数器主要用来记录执行指令的偏移量和行号指示器等。

### 3. 垃圾回收
- 标记清除算法
- 标记整理算法  --JDK11 已经默认G1为默认垃圾回收器，通过 jstat -gcutil 进行日志查看


