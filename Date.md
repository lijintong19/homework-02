###java中的日期类

1.java.util.Date类  <br/>
    a.实现的接口有Serializable,Cloneable,Comparable<Date>  <br/>
    b.直接已知子类有：Date,Time,Timestamp
    c.date的构造器
        Date()：分配Date对象并初始化此对象，以表示分配它的时间
        Date(long date):分配Date对象并初始化此对象，以表示自标准基准时间以来的指定毫秒数。
    d.常用的方法
        after(Date when) :测试此日期是否在指定日期之后
        before(Date when):测试此日期是否在指定日期之前
        clone():返回此对象的副本
        compareTo(Date anotherDate):比较两个日期的顺序
        equals(Object obj):比较两个日期的相等性
        getTime():返回自1970年1月1日00:00:00GMT以来此Date对象表示的毫秒数
        hashCode():返回此对象的哈希码值
        setTime(long time):设置此Date对象，以表示1970年1月1日00:00:00GMT以后time毫秒的时间点
        toString():把此Date对象转换为以下形式的String：dow mon dd hh:mm:ss zzz yyyy 其中 ：
        dow是一周中的某一天。（Sun,Mon,Tue,Wed,Thu,Fri,Sat）。

2.Calendar

    a.实现的接口有：Serializable,Cloneable,Comparable<Calendar>
    b.已知直接子类：GregorianCalendar

###日期的格式化

类 java.test.SimpleDateFormat
    a.实现的接口有：Serializable,Cloneable
    
    b.构造方法：
        SimpleDateFormat() 用默认的模式和默认语言环境的日期格式化符号构造SimpleDateFormat
        SimpleDateFormat(String pattern) :用给定的模式和默认的语言环境的日期格式符号构造SimpleDateFormat
        SimpleDateFormat(String pattern,DateFormatSymbols formatSymbols) :用给定的模式和日期符号构造SimpleDateFormat.
        SimpleDateFormat(String pattern,Locale locale):用给定的模式和给定的语言环境的默认日期格式符号构造SimpleDateFormat

###java8中的日期

java处理日期，日历和时间的方式一直为社区所诟病，将java.util.Date设定为可变类型，以及SimpleDateFormat的非线程安全
使其应用非常受限。
所以java出了全新的API，java.time包下的所有类都是不可变类型而且线程安全的。

java.time的关键类如下：
1.Instant:瞬时实例。
2.LocalDate：本地日期，不包含具体时间
3.LocalTime:本地时间，不包含日期
4.LocalDateTime:组合了日期和时间，但不包含时差和时区信息。
5.ZonedDateTime:最完整的日期时间，包含时区和相对UTC或格林威治的时差。

新API还引入了ZoneOffSet和ZoneId，使得解决时区问题更为简便。解析，格式化时间的
DateTimeFormatter类也全部设计了。