1. На какие две группы разделяются классы, объявленные внутри другого класса?
Как они называются на инглише?  
**Ответ.**  
1)	Non-static nested classes — нестатические вложенные классы. По-другому их еще называют inner classes — внутренние классы.
2)	Static nested classes — статические вложенные классы.  
**Источник.**  
https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih 

2. Для каких целей они используются?  
**Ответ.**  
- Это способ логической группировки классов, которые используются только в одном месте : если класс полезен только для одного другого класса, то логично встроить его в этот класс и хранить их вместе. Вложение таких «вспомогательных классов» делает их хранение более упорядоченным.  
- Это увеличивает инкапсуляцию : рассмотрим два класса верхнего уровня, A и B, где B требуется доступ к членам A, которые в противном случае были бы объявлены private. Скрывая класс B внутри класса A, члены A могут быть объявлены закрытыми, и B может получить к ним доступ. Кроме того, сам B может быть скрыт от внешнего мира.  
- Это приводит к более читабельному и поддерживаемому коду: вложение небольших классов в классы верхнего уровня помещает код ближе к тому месту, где он используется.  
**Источник.**  
https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html


3. Какие уровни доступа применяются к таким классам?  
**Ответ.**  
Внутренний класс можно обозначить стандартными модификаторами доступа — public, private, protected и package private.  
Внутренний класс связан с экземпляром окружающего его класса и имеет прямой доступ к методам и полям этого объекта.  
Внутренний класс не может сам определять какие-либо статические члены.  
Чтобы создать экземпляр внутреннего класса, необходими сначала создать экземпляр внешнего класса. Затем создать внутренний объект внутри внешнего объекта.
Статический вложенный класс связан со своим внешним классом. И подобно статическим методам класса, статический вложенный класс не может напрямую ссылаться на переменные экземпляра или методы, определенные в охватывающем его классе: он может использовать их только через ссылку на объект.
Статический вложенный класс взаимодействует с членами экземпляра своего внешнего класса точно так же, как и любой другой класс верхнего уровня. 
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
public class Runner {
    public static void main(String[] args) {
        Outer.InnerPublic innerPublic = new Outer().new InnerPublic();
        Outer.NestedPublic nestedPublic = new Outer.NestedPublic();
    }
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
а) к экземпляру класса Inner    
```java  
public class Outer {
    Inner inner = new Inner();

    public class Inner {
        void print() {
            System.out.println(inner);
            System.out.println(this);
        }
    }
}
```
б) к объемлющему экземпляру класса Outer   
```java
public class Outer {
    public class Inner {
        void print() {
            System.out.println(Outer.this);
        }
    }
}
```
**Источник.**  

8. Пусть объявлен класс Outer, а внутри него вложенный класс Nested. Как обратиться внутри класса Nested:   
а) к экземпляру класса Nested,   
б) к объемлющему экземпляру класса Outer?  
**Ответ.**  
a)  
```java
public class Outer {
    Outer outer = new Outer();

    static class Nested {
        Nested nested = new Nested();
        public void print() {
            System.out.println(nested);
        }
    }
}
```
б)  
```java
public class Outer {
    Outer outer = new Outer();

    static class Nested {
        Nested nested = new Nested();
        public static void print(Outer outer) {
            System.out.println(outer);
        }
    }
}
```
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
Но для доступа к нестатическим членам объемлющего класса обращаться необходимо через объект внешнего класса.  
```java
public class Plane  {
    private String name;
    private static int maxPassangerCount;

    public static class Drawing{
        Plane plane = new Plane();
        public String getName(){
            return plane.name;
        }
    }
}
```  
**Источник.** https://javarush.ru/groups/posts/2183-staticheskie-vlozhennihe-klassih 

10. Можно ли из внутреннего класса обратиться к экземпляру внешнего класса?  
Если да, то приведите пример.   
**Ответ.**  
Методы внутреннего класса имеют прямой доступ ко всем полям и методам внешнего класса.  
```java 
public class Outer {
    Outer outer = new Outer();
    
    class Inner{
        public void print(){
            System.out.println(outer);
        }
    }
}  
```
**Источник.**  И.Н. Блинов, В. С. Романчик, Java. Методы программирования, стр. 133  

11. Можно ли определить экземпляр вложенного класса, не определяя экземпляры внешнего класса?  
Если да, то приведите пример.  
**Ответ.**  
Можно.
```java
public class Outer {
    public static class Nested {
    }
}

public class Runner {
    public static void main(String[] args) {
        Outer.Nested nested = new Outer.Nested();
    }
}
```
**Источник.**  https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

12. Есть ли ограничения на объявление локальных переменных в локальных внутренних классах?  
Есть ли да, то какие?  
**Ответ.**  
Локальный класс может обращаться только к локальным переменным, которые объявлены как final.  
Начиная с Java SE 8, если мы объявляем локальный класс в методе, он может получить доступ к параметрам метода.
Если объявление типа (например, переменной-члена или имени параметра) в определенной области (например, во внутреннем классе или определении метода) имеет то же имя, что и другое объявление в охватывающей области, то объявление затеняет объявление. объемлющей области. Вы не можете ссылаться на затененное объявление только по его имени.
например:  
```java
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}  
```  
Результат:
```java
x = 23  
this.x = 1  
ShadowTest.this.x = 0  
```
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html 

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
Наследники вложенного класса не имеют доступа к членам внешнего класса(в то же время родитель доступ имеет)  
**Источник.**  https://javarush.ru/groups/posts/2199-primerih-nasledovanija-vnutrennikh-klassov 

14. Можно ли из подкласса обратиться к методу вложенного суперкласса?  
Если да, то приведите пример.   
**Ответ.**  
Да, возможно.  
**Источник.**  https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html 

15. Какие существуют варианты внутренних интерфейсов?  
**Ответ.**  
1)интерфейс, вложенный в класс;  
2)интерфейс, вложенный в интерфейс.  
**Источник.** 

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
    interface Smthable {
        void doSmth();
    }
    void doSomething(Smthable smth) {        //2
        smth.doSmth();
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
        class Something {
        void doSomething(Smthable smth) {        //2
            smth.doSmth();
        }
    }
    void doSmth();
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
Да, может. Нужно только запускать на выполнение сразу вложенный класс. Например, для кода ниже нужна
команда java A$B.  
```java
public class A {
    static class B {
        public static void main(String[] args) {
            System.out.println("Hello");
        }
    }
}
```
**Источник.**   

24. Может ли внутренний класс быть раннер-классом?  
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.**  
Внутренний класс не может быть раннер-классом.  
Cтатические методы и переменные могут существовать и вызваться даже при отсутствии объекта.  
Но без объекта «внешнего» класса доступа к внутреннему классу у нас не будет. Поэтому наличие статических переменных и методов во внутренних классах запрещено.  
**Источник.**  https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

25. Может ли интерфейс иметь раннер-класс?  
Если да, то приведите пример, иначе поясните, почему нет.   
**Ответ.**  
Учитывая, что интерфейсы могут содержать вложенные классы(статичные по умолчанию), а вложенные классы в свою очередь могут содержать точку входа в программу, можно смело делать вывод - да, интерфейс может содержать раннер-класс.  
**Источник.**  https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html  
https://ru.stackoverflow.com/questions/1143619/%D0%9C%D0%BE%D0%B6%D0%B5%D1%82-%D0%BB%D0%B8-%D0%B2%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9-%D0%B2%D0%BD%D1%83%D1%82%D1%80%D0%B5%D0%BD%D0%BD%D0%B8%D0%B9-%D0%BA%D0%BB%D0%B0%D1%81%D1%81-%D0%B8%D0%BB%D0%B8-%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81-%D0%B1%D1%8B%D1%82%D1%8C-%D1%80%D0%B0%D0%BD%D0%BD%D0%B5%D1%80-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%BE%D0%BC  

