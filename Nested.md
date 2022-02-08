1. На какие две группы разделяются классы, объявленные внутри другого класса?
Как они называются на инглише?  
**Ответ.**  
1)	Non-static nested classes — нестатические вложенные классы. По-другому их еще называют inner classes — внутренние классы.
2)	Static nested classes — статические вложенные классы.  
**Источник.**  
https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih 

2. Для каких целей они используются?  
**Ответ.**  
Non-static nested classes (Внутренние классы) — это классы для выделения в программе некой сущности, которая неразрывно связана с другой сущностью. (например Велосипед и сиденье от велосипеда).
Static nested classes. Объект статического вложенного класса вполне может существовать сам по себе. В этом плане статические классы более «независимы», чем нестатические. Используются для выделения сущности, которая относится к определенной сущности, но может использоваться и другими сущностями (например Самолет и чертеж от самолета, который может быть использован конструкторами).  
**Источник.**  
https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih 


3. Какие уровни доступа применяются к таким классам?  
**Ответ.**  
Внутренний класс можно обозначить стандартными модификаторами доступа — public, private, protected и package private.  
**Источник.**  
https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih 

4. Какие существуют варианты внутренних классов?  
**Ответ.**  
В Java существуют 4 типа внутренних (inner) классов:  
Внутренние (нестатические) классы  
Статические вложенные классы  
Локальные классы  
Анонимные (безымянные) классы  
**Источник.**  
https://ru.wikipedia.org/wiki/%D0%92%D0%BD%D1%83%D1%82%D1%80%D0%B5%D0%BD%D0%BD%D0%B8%D0%B9_%D0%BA%D0%BB%D0%B0%D1%81%D1%81 

5. Пусть объявлен класс Outer, а внутри него публичный вложенный класс NestedPublic и публичный внутренний класс InnerPublic. Создайте экземпляры каждого класса:  
а) внутри класса Outer,  
б) извне класса Outer?  
**Ответ.**  
a)  
```java
    public class Outer {
    Outer outer = new Outer();
    NestedPublic nestedPublic = new NestedPublic();
    InnerPublic innerPublic = new InnerPublic();
    
    public static class NestedPublic{
    }

    public class InnerPublic{
    }
}
```  
б)  
```java
public class CallClasses {
    Outer outer = new Outer();
    Outer.NestedPublic nestedPublic = new Outer.NestedPublic();
    Outer.InnerPublic innerPublic = outer.innerPublic;
}
```  
**Источник.** - 

6. Пусть объявлен класс Outer, а внутри него приватный вложенный класс NestedPrivate и приватный внутренний класс InnerPrivate. Создайте экземпляры каждого класса:  
а) внутри класса Outer,  
б) извне класса Outer?  
**Ответ.**  
a)  
```java  
public class Outer {
    Outer outer = new Outer();
    NestedPrivate nestedPublic = new NestedPrivate();
    InnerPrivate innerPublic = new InnerPrivate();

    private static class NestedPrivate{
    }

    private class InnerPrivate{
    }
}
```  
б)  
К внутренним и вложенным классам, объявленным как private можно получить доступ только во внешнем для них классе.  
**Источник.**  Брюс Эккель, «Философия Java», стр. 295

7. Пусть объявлен класс Outer, а внутри него внутренний класс Inner. Как обратиться внутри класса Inner:   
а) к экземпляру класса Inner,   
б) к объемлющему экземпляру класса Outer?  
**Ответ.**  
а)  
б)  
**Источник.**  

8. Пусть объявлен класс Outer, а внутри него вложенный класс Nested. Как обратиться внутри класса Nested:   
а) к экземпляру класса Nested,   
б) к объемлющему экземпляру класса Outer?  
**Ответ.**  
**Источник.**  

9. Можно ли из вложенного класса обратиться к членам внешнего класса?  
Если да, то приведите пример.  
**Ответ.**  
Вложенный класс имеет доступ к статическим полям и методам своего внешнего класса, в том числе и к закрытым.  
```java
    public class Plane {
    private String name;
    private static int maxPassangerCount;

    public static class Drawing{
        public static int getMaxPassangerCOunt(){
            return maxPassangerCount;
        }
    }
}
```  
**Источник.** https://javarush.ru/groups/posts/2183-staticheskie-vlozhennihe-klassih 

10. Можно ли из внутреннего класса обратиться к экземпляру внешнего класса?  
Если да, то приведите пример.   
**Ответ.**  
Нельзя.  
**Источник.**  http://pr0java.blogspot.com/2015/08/3-inner-classes.html#:~:text=%D0%9E%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%20%D0%B2%D0%BD%D1%83%D1%82%D1%80%D0%B5%D0%BD%D0%BD%D0%B5%D0%B3%D0%BE%20%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0%20%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B0%D0%B5%D1%82%20%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D1%83,%D0%B2%D0%BD%D0%B5%D1%88%D0%BD%D0%B5%D0%B3%D0%BE%20%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%D0%B0%20%D0%B1%D0%B5%D0%B7%20%D0%B4%D0%BE%D0%BF%D0%BE%D0%BB%D0%BD%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D1%83%D1%82%D0%BE%D1%87%D0%BD%D0%B5%D0%BD%D0%B8%D0%B9. 

11. Можно ли определить экземпляр вложенного класса, не определяя экземпляры внешнего класса?  
Если да, то приведите пример.  
**Ответ.**  
Нет. При создании такого объекта нужно указывать название внешнего класса.  
**Источник.**  https://javarush.ru/groups/posts/2183-staticheskie-vlozhennihe-klassih 

12. Есть ли ограничения на объявление локальных переменных в локальных внутренних классах?  
Есть ли да, то какие?  
**Ответ.**  
В локальных внутренних классах нельзя объявлять статические переменные.  
**Источник.** https://ru.stackoverflow.com/questions/515940/%D0%9B%D0%BE%D0%BA%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D0%B8-%D0%B2%D0%BD%D1%83%D1%82%D1%80%D0%B5%D0%BD%D0%BD%D0%B8%D0%B5-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D1%8B 

13. Можно ли наследовать вложенные классы?  
Если да, то приведите пример.  
**Ответ.**  
Может быть унаследован от:  
1) Обычного класса  
2) Статического вложенного класса, который объявлен во внешнем классе или его предках  
От него может наследоваться:  
a) Любой класс
```java
    public class Outer {

    private int cost;

    static class Nested{
    }
    
    static class One extends Nested{
    }
    
    public class Two extends Nested{
    }
}
```
**Источник.**  https://javarush.ru/groups/posts/2199-primerih-nasledovanija-vnutrennikh-klassov 

14. Можно ли из подкласса обратиться к методу вложенного суперкласса?  
Если да, то приведите пример.   
**Ответ.**  
**Источник.**  

15. Какие существуют варианты внутренних интерфейсов?  
**Ответ.**  
Он может быть объявлен как public, private или protected. Этим он от¬личается от интерфейса верхнего уровня, который должен бьrгь объявлен как pub¬lic или использовать уровень доступа по умолчанию.  
**Источник.**  http://pr0java.blogspot.com/2015/07/5.html 

16. Можно ли объявить класс внутри интерфейса?  
Если да, то есть ли ограничения? Приведите пример.  
**Ответ.**  
Да, вы можете создать как вложенный класс, так и внутренний класс внутри интерфейса Java  
```java
    public interface A {
    class B {
    }
}
```  
НЕЛЬЗЯ объявлять нестатические классы внутри интерфейса Java  
**Источник.**  https://qastack.ru/programming/2400828/inner-class-within-interface 

17. Можно ли создать экземпляр анонимного класса на основе:  
а) абстрактного класса?  
б) интерфейса?  
в) неабстрактного класса?  
г) финального класса? 
Если да, то приведите пример.  
**Ответ.**  
А) можно  
```java
public class Foo {
    // Анонимный класс, который реализует интерфейс SayHello
    static SayHello h = new SayHello() {
        @Override
        public void say() {
            System.out.println("Метод внутреннего анонимного класса");
        }
    };

    public static void main(String[] args) {
        h.say();
    }
}
// somewhere
abstract class SayHello {
    abstract void say();
}
```
б) можно  
```java  
public class Foo {
    // Анонимный класс, который реализует интерфейс SayHello
    static SayHello h = new SayHello() {
        @Override
        public void say() {
            System.out.println("Метод внутреннего анонимного класса");
        }
    };

    public static void main(String[] args) {
        h.say();
    }
}
// somewhere
interface SayHello {
    void say();
}
```
в) можно  
```java
public class Foo {
    // Анонимный класс, который реализует интерфейс SayHello
    static SayHello h = new SayHello() {

    };

    public static void main(String[] args) {
        h.say();
    }
}

// somewhere
class SayHello {
    void say() {
        System.out.println("Метод внутреннего анонимного класса");
    }
}
```
г) нельзя  
**Источник.**  

18. Дан следующий java-файл.  
//-------------- begin --------------
```java 
class Runner {
public static void main(String[] args){
Something something = new Something();
something.doSomething(...);		//1
}
}
interface Smthable {
void doSmth(); 
}
class Something {
	void doSomething(...) {			//2
		smth.doSmth();
}
}
```
//--------------- end ---------------
1) Замените многоточия в строках 1 и 2 на такой код, чтобы приложение после запуска с помощью экземпляра анонимного класса, порожденного от интерфейса Smthable, вывело на консоль текст Hello, World.  
2) Получите тот же результат, переместив:  
а) интерфейс Smthable внутрь класса Something,  
б) класс Something внутрь интерфейса Smthable.   
**Ответ.**   
```java
class Runner {
    public static void main(String[] args){
        Something something = new Something();
        something.doSomething(new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello, World");
            }
        });       //1
    }
}
interface Smthable {
    void doSmth();
}
class Something {
    void doSomething(Smthable smth) {        //2
        smth.doSmth();
    }
}
```
2)  
А)  
```java  
class Runner {
    public static void main(String[] args){
        Something something = new Something();
        something.doSomething(new Something.Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello, World");
            }
        });       //1
    }
}

class Something {
    void doSomething(Smthable smth) {        //2
        smth.doSmth();
    }
    interface Smthable {
        void doSmth();
    }
}
```
б)  
```java  
class Runner {
    public static void main(String[] args){
        Smthable.Something something = new Smthable.Something();
        something.doSomething(new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello, World");
            }
        });       //1
    }
}
interface Smthable {
    void doSmth();
    class Something {
        void doSomething(Smthable smth) {        //2
            smth.doSmth();
        }
    }
}
```  
**Источник.**  

19. Дан следующий java-файл.    
//-------------- begin --------------  
```java 
abstract class AbstractRunner {
abstract int getYear();
abstract class AbstarctInner {
	abstract int getYear();
}
public static void main(String[] args) {
	... //1
	... //2
	... //3
}
}
```
//--------------- end ---------------
Создайте в строке 1 ссылку runner на экземпляр подкласса класса AbstractRunner.  
Создайте в строке 2 ссылку inner на экземпляр подкласса класса AbstractInner.  
Выведите на консоль в строке 3 текст 2010;2015, используя данные ссылки.  
**Ответ.**  
```java
abstract class AbstractRunner {
    abstract int getYear();

    abstract class AbstarctInner {
        abstract int getYear();
    }

    public static void main(String[] args) {
        AbstractRunner runner = new AbstractRunner() {
            @Override
            int getYear() {
                return 2010;
            }
        }; //1
        AbstarctInner inner = runner.new AbstarctInner() {
            @Override
            int getYear() {
                return 2015;
            }
        };//2
        System.out.println(runner.getYear() + ";" + inner.getYear());//3
    }
}
```
**Источник.**  

20. Дан следующий java-файл.  
//-------------- begin --------------  
```java  
class Runner {
	public static void main(String[] args) {
		... 	//1
	}
}
class Outer {
	class Inner {
		void go() {
			System.out.println("Gone!");
		}
	}
}	
```
//--------------- end ---------------  
1) С помощью функционала классов Outer и Inner выведите на консоль в строке 1 текст Gone!.  
2) Переместив класс Outer внутрь класса Runner, получите тот же результат:  
а) не изменяя строку 1.  
б) изменяя строку 1,   
**Ответ.**  
1    
```java
    class Runner {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();//1
        inner.go();
    }
}
class Outer {
    class Inner {
        void go() {
            System.out.println("Gone!");
        }
    }
}
```
2  
a)  
```java 
    class Runner {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();//1
        inner.go();
    }
    static class Outer {
        class Inner {
            void go() {
                System.out.println("Gone!");
            }
        }
    }
}
```
б)  
```java 
    class Runner {
    public static void main(String[] args) {
        Outer.Inner inner = new Runner().new Outer().new Inner();//1
        inner.go();
    }
    class Outer {
        class Inner {
            void go() {
                System.out.println("Gone!");
            }
        }
    }
}
```  
**Источник.**  

21. Что представляют собой элементы перечисления?  
Подсказка. Откомпилируйте фабричный класс из задачи inheritance1 и посмотрите, какие получились .class-файлы  
**Ответ.**  
каждая константа - это константный вложенный класс.  
**Источник.**  

22. Как образуются имена вложенных и внутренних .class-файлов после компиляции?  
Приведите примеры.  
**Ответ.**  
вложенный класс Nested создется с уточняющим именем внешнего класса Outer через знак $.  
Например  
```java
public class Outer {
    static class Nested{
        
    }
}
```
При компиляции создается класс с именем Outer$Nested.class  
**Источник.**  http://pr0java.blogspot.com/2015/08/2.html 

23. Может ли вложенный класс быть раннер-классом?  
Если да, то приведите пример, иначе поясните, почему нет.   
**Ответ.**  
**Источник.**  

24. Может ли внутренний класс быть раннер-классом?  
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.**  
**Источник.**

25. Может ли интерфейс иметь раннер-класс?  
Если да, то приведите пример, иначе поясните, почему нет.   
**Ответ.**   
**Источник.**  

