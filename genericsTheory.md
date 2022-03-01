1. В какой версии Java появились параметризованные типы?  
**Ответ.**   
JDK 5.0  
**Источник.**  
https://docs.oracle.com/javase/tutorial/java/generics/rawTypes.html

2. Приведите 2 примера кода: первый без параметризованного типа; второй - этот же код с параметризованным типом, иллюстрирующий преимущество данного варианта.   
**Ответ.**   
Следующий фрагмент кода без дженериков требует приведения:  
```java  
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```  
При переписывании для использования дженериков код не требует приведения:  
```java  
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);    // нет приведения
``` 
**Источник.**  
https://docs.oracle.com/javase/tutorial/java/generics/why.html   

3. Какие типы данных запрещены в качестве параметров классов?  
**Ответ.**   
Переменная типа может быть любым указанным вами не примитивным типом: любым типом класса, любым типом интерфейса, любым типом массива или даже переменной другого типа.  
**Источник.**  
https://docs.oracle.com/javase/tutorial/java/generics/types.html 

4. Дан код:  
```java
class Gen <T1, T2 extends Number, T3 extends Object> { … }
```
Какие типы можно использовать в качестве аргументов T1, T2, T3?  
**Ответ.**   
Т1 – Любой не примитивный тип;  
Т2 – Наследники класса Number, включая класс Number;  
Т3 – Класс наследник Оbject (любой класс).  
**Источник.**   
https://docs.oracle.com/javase/tutorial/java/generics/bounded.html  

5. Дан код:  
```java
class Gen1 <T> { … }
class Gen2 <T extends Object> { … }
class Runner {
	private final static Gen1<Object> g11 = new Gen1<>();
	private final static Gen1 g12 = new Gen1();
	private final static Gen2<Object> g21 = new Gen2<>();
	private final static Gen2 g22 = new Gen2();
	...
}
```
В чем различие объявления классов Gen1 и Gen2?  
Есть ли преимущество в объявлении g11 по сравнению с g12? Обоснуйте ответ.   
Есть ли преимущество в объявлении g21 по сравнению с  g12? Обоснуйте ответ.   
В каком случае используется второй способ (g12, g22)?  
**Ответ.**  
А) Объявления классов Gen1 и Gen2 являются идентичными.  
Б) Если рассматривать данный пример именно с Gen1, то никаких преимуществ нет, но если вместо Object поставить, к примеру, тип Integer, то разница будет:  
```java
class Gen1<T> {
    T t;
    public Gen1(T t) {
        this.t = t;
    }
    public void print() {
        System.out.println((Integer) t + (Integer) t);
    }
}
class Gen2<T extends Object> {
}
class Runner {
    private final static Gen1<Integer> g11 = new Gen1<Integer>("1"); // ошибка компиляции 
    private final static Gen1 g12 = new Gen1("1"); // ошибки компиляции нет, но возникает исключение во время выполнения программы
    private final static Gen2<Object> g21 = new Gen2<>();
    private final static Gen2 g22 = new Gen2();
    public static void main(String[] args) {
        g11.print();
        g12.print();
    }
}
```  
Использование "сырых" типов приводит к возникновению небезопасного кода.  
В)Да, аналогично. Преимущества есть, g21 типабезопасен и не приводит к возникновению небезопасного кода.  
Г)Такая реализация необходима для обеспечения совместимости с кодом, созданным в предыдущих версиях языка.  
**Источник.**  

6. Дан код:  
```java
class SubInfo extends Info { … }  
class Gen1 <T> { … }  
class Gen2 <T extends Info> { … }  
```
1)Является ли декларация Gen1<Info> подклассом Gen2<Info>?  
2)Является ли декларация Gen1<SubInfo> подклассом Gen1<Info>?  
3)Является ли декларация Gen2<SubInfo> подклассом Gen2<Info>?  
**Ответ.**    
Во всех случаях декларация является подклассом ``Object``, т.е. везде соответственно нет  
**Источник.**  
https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html 

7. Почему нельзя вызвать конструктор generic-типа?  
**Ответ.**  
Т.к. Компилятор не знает, какой конструктор может быть вызван и какой объем памяти должен быть выделен при создании объекта.   
**Источник.**   
И. Блинов. Методы программирования, стр. 72  

8. Почему нельзя создать generic-поле?  
Почему статический метод не может иметь generic-параметр?  
**Ответ.**  
А) Т.к. Компилятор не знает, какого типа поле и какой объем памяти должен быть выделен.  
Б) Это вызвано тем, что параметр типа привязывается к конкретному объекту при его создании, а статический метод не привязан к конкретному объекту, он привязан к классу в целом.  В случае статического метода параметр типа нужно указывать непосредственно перед объявлением метода.  
**Источник.**   
И. Блинов. Методы программирования, стр. 72  
https://ru.stackoverflow.com/questions/415002/%d0%92%d0%be%d0%bf%d1%80%d0%be%d1%81-%d0%bf%d0%be-%d0%b4%d0%b6%d0%b5%d0%bd%d0%b5%d1%80%d0%b8%d0%ba%d0%b0%d0%bc-%d0%bc%d0%b5%d1%82%d0%be%d0%b4%d0%b0-%d0%b8-%d0%be%d0%b3%d1%80%d0%b0%d0%bd%d0%b8%d1%87%d0%b5%d0%bd%d0%b8%d1%8e-%d0%bf%d0%b5%d1%80%d0%b5%d0%bc%d0%b5%d0%bd%d0%bd%d1%8b%d1%85-%d1%82%d0%b8%d0%bf%d0%be%d0%b2   

9. Предложите более эффективную запись данного кода:  
``<T> void make1(Gen <T extends Object> gen) { … }``    
``<T, S extends T> void make2(Info<T> info1, Info<S> info2) { … }``  
**Ответ.**
```java
<T> void make1(Gen <?> gen) {...}
<T> void make2(Info<T> info1, Info<? extends T> info2) { … }
```
**Источник.**  

10. Дан код:  
```java
class Info { 
	public <T1> Info() { … }
	public <T2> Info(T2 t2) { … }
	public <T1> void make1(T1 t1) { … }
	public <T3> void make2() { … }
}
```
Создайте какой-либо экземпляр класса Info  
1	конструктором без аргументов,  
2	конструктором с аргументом.  
Синтаксически правильно вызовите методы ``make1()`` и ``make2()``.  
**Ответ.**   
```java  
public class Runner {
    public static void main(String[] args) {
        Info i1 = new <Integer>Info();
        Info i2 = new Info(new Integer(2));
        i2.make1(new Integer(2));
        i1.make2();
    }
}
```  
**Источник.**  -  

11. Поясните данный код:  
``static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)``  
**Ответ.**  
Статический универсальный метод, параметризованный ``<T extends Object & Comparable<? super T>>`` - фиктивным типом ``Т``, определяемым классами расширяющими ``Object`` и реализующими ``Comparable``, параметризованный объектом любого класса выше ``T`` в иерархии. Возвращаемое значение данного метода - объект класса ``T``.
В качестве аргумента ``max()`` принимает коллекцию, инициализируемую объектами классов-наследников ``Т``.  
**Источник.** -


