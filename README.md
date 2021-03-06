# 设计模式

**23个设计模式示例，学习时所敲的代码任务都被保存在这里，以备以后复习之用！**

# 面向对象的八大设计原则（简记）

1. ***依赖倒置原则***：
    
    依赖抽象不依赖具体！

2. ***开放封闭原则***：

    对扩展开放，对修改封闭！

3. ***单一职责原则***：

   一个类只能有一个引起它变化的原因！

4. ***liskov替换原则***：

   子类能够替换它的父类（IS-A）

5. ***接口隔离原则***：

   不应该强迫用户依赖他们不需要的方法，接口应该小而完备！

6. ***优先使用组合而不是继承***：

   即书上所说多用has-a，少用is-a，因为继承在某种程度上破坏了封装，子类父类具有较高的耦合，采用组合只需要组合对象具有良好定义的接口，耦合度低。

7. ***封装变化点***：

   使用封装来创建对象的分阶层，让设计者在分界层的一侧修改不会影响到另一侧，从而实现层次间的松耦合

8. ***面向接口编程而不是面向实现***：
- 不将变量声明为某个具体类，而是申明为某个接口。
- 客户程序无需货值对象的具体类型，只需知道对象所具有的接口。
- 减少系统中各部分的依赖关系，从而实现高聚合、低耦合的设计方案！

# 23种设计模式的简单备注

> 按代码添加顺序（代码中都有多个类在一个文件中，这样是为了方便阅读）排列，按封装变化角度对模式进行分类！


## 组件协作
1. 模板方法模式（Template Method Pattern）

2. 观察者/事件模式（Observer/event Pattern）
    定义：定义对象间一对一对多的关系，以便在一个对象状态发生改变时，所有依赖于它的对象都能得到通知并自动进行更新！
       [教学视频](https://www.bilibili.com/video/av24176315/?p=5)
       > 这里我注意到观察者模式和策略模式有些类似，于是搜索两者区别，得此答案：**策略模式**更注重于一个“策略”是一个 整体的(完整的) 算法，算法是可以被整体替换的。而**模板方法模式**只能被替换其中的特定点，算法流程是固定不可变的。

3. 策略模式（Strategy Pattern）
    
    看到if-else就应该嗅到代码中的bad-smile，这时候就应该在脑海中想一想有没有别的可能，别的可以扩展的东西。保留if-else如果以后有扩展的话就可能得修改源码。
    这时就可以考虑策略模式。[教学视频](https://www.bilibili.com/video/av24176315/?p=4)

## 单一职责

4. 装饰者模式（Decorator Pattern)

5. 桥接模式(Bridge Pattern)

## 对象创建

6. 工厂方法模式（Factory Method Pattern)

7. 抽象工厂模式（Abstract Factory Pattern)

8. 原型模式（Prototype Pattern）

9. 构造器模式（Builder Pattern）

## 对象性能

10. 单例模式（Singleton Pattern）

11. 享元模式（Flyweight Pattern）

## 状态变化

12. 备忘录模式（Memento Pattern）

13. 状态模式（State Pattern）

## 接口隔离

14. 门面模式（Facade Pattern）

15. 代理模式（Proxy Pattern）

16. 中介者模式（Mediator Pattern）

17. 适配器模式（Adapter Pattern）

## 数据结构

18. 组合模式（Composite Pattern）

19. 迭代器模式（Iterator Pattern）

20. 职责链模式（Chain of responsibility Pattern）

## 行为变化

21. 命令模式（Commend Pattern）

22. 访问者模式（Visitor Pattern）

## 领域问题

23. 解释器模式（Interpreter Pattern）