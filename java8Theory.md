1. Что такое лямбда-выражение?\
**Ответ**  
 упрощённая запись анонимного класса, реализующего функциональный интерфейс.\
**Источник**  
https://alexkosarev.name/2019/03/11/lambdas-in-java/#:~:text=%D0%9B%D1%8F%D0%BC%D0%B1%D0%B4%D0%B0%2D%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%B8%D0%BB%D0%B8%20%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%BE%20%D0%BB%D1%8F%D0%BC%D0%B1%D0%B4%D0%B0,%D0%BE%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%20%D1%82%D0%BE%D0%BB%D1%8C%D0%BA%D0%BE%20%D0%BE%D0%B4%D0%B8%D0%BD%20%D0%B0%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D1%8B%D0%B9%20%D0%BC%D0%B5%D1%82%D0%BE%D0%B4. 

2. Из каких элементов состоит объявление лямбда-выражения?\
**Ответ**  
Основу лямбда-выражения составляет лямбда-оператор, который представляет стрелку ->. Этот оператор разделяет лямбда-выражение на две части: левая часть содержит список параметров выражения, а правая собственно представляет тело лямбда-выражения, где выполняются все действия.\
**Источник**  
https://metanit.com/java/tutorial/9.1.php 
3. При объявлении лямбда-выражения какие структуры можно опустить?\
**Ответ**  
Когда параметр один, если тип не указывается явно, скобки можно опустить. Пример: a -> return a*a\
**Источник**  
https://javarush.ru/groups/posts/845-lambda-vihrazhenija-na-primerakh 

4. Что такое поток и конвейер в контексте лямбда-выражения?\
**Ответ**  
Конвейер - это последовательность агрегатных операций.\
Поток - это последовательность элементов. В отличие от коллекции, это не структура данных, в которой хранятся элементы. Вместо этого поток передает значения из источника по конвейеру\
**Источник**  
https://docs.oracle.com/javase/tutorial/collections/streams/index.html 

5. Какие компоненты содержит конвейер?\
**Ответ**  
- Источник: Это может быть коллекция, массив, функция генератора или канал ввода-вывода. \
- Ноль или более промежуточных операций. Промежуточная операция, такая как фильтрация, создает новый поток.\
- Терминальная операция.\
**Источник**  
https://docs.oracle.com/javase/tutorial/collections/streams/index.html 

6. Что такое агрегатные операции? Приведите примеры агрегатных операций.\
**Ответ**  
Операции, которые обрабатывают элементы из потока, а не непосредственно из коллекции.\
Примеры: фильтрация, сопоставление, ограничение, уменьшение, поиск, сопоставление и так далее.\
**Источник**  
https://www.tutorialspoint.com/java8/java8_streams.htm#:~:text=Aggregate%20operations%20%E2%88%92%20Stream%20supports%20aggregate,their%20result%20can%20be%20pipelined. 

7. Какие различия между агрегатными операциями и итераторами?\
**Ответ**  
- Они используют внутреннюю итерацию: Агрегатные операции не содержат такого метода, как next, который указывал бы им обрабатывать следующий элемент коллекции. При внутреннем делегировании ваше приложение определяет, какую коллекцию оно повторяет, но JDK определяет, как выполнять итерацию коллекции. С помощью внешней итерации ваше приложение определяет как то, какую коллекцию оно повторяет, так и то, как оно ее повторяет. Однако внешняя итерация может выполнять итерацию только по элементам коллекции последовательно. Внутренняя итерация не имеет этого ограничения. Он может легче использовать преимущества параллельных вычислений, которые включают в себя разделение задачи на подзадачи, одновременное решение этих задач, а затем объединение результатов решений подзадач.\
- Они обрабатывают элементы из потока: Агрегатные операции обрабатывают элементы из потока, а не непосредственно из коллекции. Следовательно, они также называются потоковыми операциями.\
- Они поддерживают поведение в качестве параметров: Вы можете указать лямбда-выражения в качестве параметров для большинства агрегированных операций. Это позволяет настроить поведение конкретной агрегатной операции.\
**Источник** 
https://docs.oracle.com/javase/tutorial/collections/streams/index.html  

8. Какие имеются ограничения на локальные переменные, которые используются в лямбда-выражениях?\
**Ответ**  
лямбда-выражение может обращаться только к локальным переменным и параметрам заключающего блока, которые являются final или effectively final.\
**Источник**  
https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#accessing-local-variables

9. Что такое целевой тип лямбда-выражения и как компилятор определяет целевой тип?\
**Ответ**  
Тип данных, который ожидают методы, называется целевым типом.\
**Источник**  
https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#target-typing 

10. В каких ситуациях может использоваться лямбда-выражение?\
**Ответ**  
Лямбда-выражения могут использоваться только в том случае, если вам нужно переопределить не более одного метода.\
**Источник**  
https://habr.com/ru/post/419395/ 

11. Могут ли лямбда-выражения ссылаться на другие существующие методы? Если да - приведите пример.\
**Ответ**  
Да, могут. Ссылки на методы позволяют нам это сделать;\
```java
Arrays.sort(rosterAsArray,
    (Person a, Person b) -> {
        return a.getBirthday().compareTo(b.getBirthday());
    }
);
```
**Источник**  
https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html 
12. Укажите виды ссылок на методы в контексте лямбда-выражений и приведите соответствующие пример.\
**Ответ**  
 
```java
import java.util.function.BiFunction;

public class MethodReferencesExamples {
    
    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }
    
    public static String appendStrings(String a, String b) {
        return a + b;
    }
    
    public String appendStrings2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        
        MethodReferencesExamples myApp = new MethodReferencesExamples();

        // Calling the method mergeThings with a lambda expression
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", (a, b) -> a + b));
        
        // Reference to a static method
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", MethodReferencesExamples::appendStrings));

        // Reference to an instance method of a particular object        
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", myApp::appendStrings2));
        
        // Reference to an instance method of an arbitrary object of a
        // particular type
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", String::concat));
    }
}
```
**Источник**  
https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html \

13. Что такое операции сокращения в контексте лямбда-выражений?\
**Ответ**  
JDK содержит множество терминальных операций (таких как average, sum, min, max и count), которые возвращают одно значение путем объединения содержимого потока. Эти операции называются операциями сокращения.\
**Источник**  
https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html 

14. Чем метод reduce отличается от метода collect в контексте лямбда-выражений?\
**Ответ**  
Операция reduce всегда возвращает новое значение. Однако функция накопителя также возвращает новое значение каждый раз, когда она обрабатывает элемент потока. Предположим, что мы хотим свести элементы потока к более сложному объекту, такому как коллекция. Это может снизить производительность нашего приложения. Если наша операция сокращения включает добавление элементов в коллекцию, то каждый раз, когда функция накопления обрабатывает элемент, она создает новую коллекцию, включающую этот элемент, что неэффективно. Вместо этого было бы более эффективно обновить существующую коллекцию. Мы можем сделать это с помощью метода Stream.collect.\
**Источник**  
https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html 

15. Укажите, какие преимущества дает использование класса Optional?\
**Ответ**  
В этом классе описаны методы для проверки объекта или проверки каких-то дальнейших действий с объектом на null. \
Optional помогает придать большую информативность коду, повысить его читабельность.\
**Источник**  
https://habr.com/ru/post/225641/ 

16. Выполните вывод каждого элемента коллекции collect с помощью метода forEach (), применяя:\
1.	итератор\
2.	поток\
**Ответ**  
1) ```java
Collection<Integer> collect = new ArrayList<>();
for(Integer el : collect){
    System.out.println(el);
}
```
2) 
```java
collect.forEach(col -> System.out.println(col));
```

**Источник**  
-  
17. Выполните вывод каждого элемента Map collect с помощью java 8.\
**Ответ**  
```java
collect.forEach((k, v) -> System.out.println("Key" + k + " Value" + v));
```
**Источник**  
-	 

18. Допишите сортировку коллекции users по имени с помощью метода getName() и вывод всех элементов коллекции в консоль (класс User приводить не обязательно).\
java```
public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
            users.add(new User("Nick", "Boll"));
            users.add(new User("Jan", "Nicky"));
            users.add(new User("Bot", "Smart"));
...
    }
}
```
**Ответ**  
```java
public static void main(String[] args) {
    List<User> users = new ArrayList<>();
    users.add(new User("Nick", "Boll"));
    users.add(new User("Jan", "Nicky"));
    users.add(new User("Bot", "Smart"));
    users.sort((user1, user2) -> user1.getName() - user2.getName());
    users.forEach(user -> System.out.println(user));
}
```
**Источник**  
-	 

19. Допишите код, чтобы вывести только четные элементы коллекции, используя метод filter().\
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
…
    }
}
**Ответ**  
```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers.stream()
            .filter(i -> i % 2 == 0)
            .forEach(System.out::println);
}
```
**Источник**  \
-	 

20. Допишите код, чтобы вывести количество элементов коллекции, длина которых больше 4, используя методы filter() и count().\
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas");
…
    }
}
**Ответ**  
```java
public static void main(String[] args) {
    List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas");
    long count = names.stream()
            .filter(i -> i.length() > 4)
            .count();
    System.out.println(count);
    }
```
**Источник**  \
-

21. Допишите код, чтобы вывести каждый элемент коллекции, умножив его на 2, используя метод map().\
public class Main {\
    public static void main(String[] args) {\
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);\
 …
    }
}
**Ответ**  
```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
    numbers.stream()
            .map(i -> i * 2)
            .forEach(System.out::println);
}
```
**Источник**  
-
22. Создайте новую коллекцию ArrayList и выведите в консоль список четных чисел из коллекции numbers с использованием методов filter() и collect().\
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = ...
 …
    }
}
**Ответ**  
```java
public static void main(String[] args) {\
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);\
List<Integer> evenNumbers = numbers.stream()\
        .filter(i -> i % 2 == 0)\
        .toList();\
evenNumbers.forEach(System.out::println);\
}
```
**Источник**  
-

23. Создайте новую коллекцию LinkedList (имплементация Queue) и выведите в консоль НЕ пустые строки из коллекции ArrayList names с использованием методов filter() и collect().\
```java
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");
        Queue<String> queue = ….
 …
    }
}
  ```
**Ответ**  
```java
public static void main(String[] args) {
    List<String> names = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");
    Queue<String> queue = names.stream().filter(s -> s.length() > 0)
            .collect(
                    () -> new LinkedList<String>(),
                    (list, item) -> list.add(item),
                    (list1, list2) -> list1.addAll(list2));
    queue.forEach(System.out::println);
}
```
**Источник**  
-

24. Выведите имена домашних животных, объединив их в новую коллекцию List<String> petNames из коллекции их хозяев humans, у которых имена домашних животных являются полями класса (в виде отдельных коллекций), используя метод flatMap().\
```java
public class Main {
    public static void main(String[] args) {
        List<Human> humans = asList(
            new Human("Sam", asList("Buddy", "Lucy")),
            new Human("Bob", asList("Frankie", "Rosie")),
            new Human("Marta", asList("Simba", "Tilly")));
        List<String> petNames = ...
 …
    }
}
  ```
**Ответ**  
```java
public static void main(String[] args) {
    List<Human> humans = asList(
            new Human("Sam", asList("Buddy", "Lucy")),
            new Human("Bob", asList("Frankie", "Rosie")),
            new Human("Marta", asList("Simba", "Tilly")));
    List<String> petNames = humans.stream()
            .flatMap(human -> human.getPets().stream())
            .collect(Collectors.toList());
    System.out.println(petNames);
}
```
**Источник**  \
https://vertex-academy.com/tutorials/ru/java-8-stream-flatmap/ \

25. Найдите и выведите первое по счету число, которое больше 10, используя методы filter() и findFirst().\
```java
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 10, 12, 15);
        Optional<Integer> first = ...
 …
    }
}
  ```
**Ответ**  
```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 5, 8, 10, 12, 15);
    Optional<Integer> first = numbers.stream()
            .filter(number -> number > 10)
            .findFirst();
    System.out.println(first);
}
```
**Источник**  \
https://vertex-academy.com/tutorials/ru/java-8-stream-find/ \

26. Найдите и выведите первую попавшуюся фразу (с учетом возможного многопоточного процесса), которая содержит фрагмент "Java", используя методы filter() и findAny().\
```java
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java is the best", "Java 8", "Java 9", "Jacoco");
        Optional<String> java = …
...
     }
}
  ```
**Ответ**  
```java
public static void main(String[] args) {
    List<String> strings = Arrays.asList("Java is the best", "Java 8", "Java 9", "Jacoco");
    Optional<String> java =strings.parallelStream()
            .filter(string -> string.contains("Java"))
            .findAny();
    System.out.println(java);
}
```
**Источник**  \
https://vertex-academy.com/tutorials/ru/java-8-stream-find/ \

27. Выведите boolean, имеется ли в коллекции хотя бы одно четное значение, используя метод anyMatch().\
  ```java
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 7);
        boolean match = ...
 ...
     }
}
  ```
**Ответ**
```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 4, 5, 7);
    boolean match = numbers.stream()
            .anyMatch(el -> el % 2 == 0);
    System.out.println(match);
}
```
**Источник**
https://vertex-academy.com/tutorials/ru/java-8-stream-match/ 

28. Выведите boolean, являются ли все числа коллекции положительным, используя метод allMatch().\
  ```java
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean match = ...
 ...
     }
}
  ```
**Ответ**  
```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    boolean match = numbers.stream()
            .allMatch(el -> el % 2 == 0);
    System.out.println(match);
}
```
**Источник**  \
https://vertex-academy.com/tutorials/ru/java-8-stream-match/ \

29. Выведите boolean, НЕ являются ли все числа коллекции четными, используя метод noneMatch().\
  ```java
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        boolean match = ...
  ...
     }
}
  ```
**Ответ**  
```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
    boolean match = numbers.stream()
            .noneMatch(el -> el % 2 != 0);
    System.out.println(match);
}
```
**Источник**  \
https://vertex-academy.com/tutorials/ru/java-8-stream-match/ \

30. Какие из ниже приведенных ламбда-выражений не скомпилируется и почему?\
1) (int x, int y) -> x+y \ 
2) (x, y) -> x+y        \  
3) (x, int y) -> x+y   \
4) (x, final y) -> x+y \
5) int x -> x;\
6) x -> y -> x + y;\
7) x -> (final int y) -> y + x;\
8) x -> x -> 5;\
**Ответ**  
1) (int x, int y) -> x+y   - скомпилируется\
2) (x, y) -> x+y          - скомпилируется\
3) (x, int y) -> x+y   - не скомпилируется. Необходимо либо указывать тип у всех аргументов, или нет.\
4) (x, final y) -> x+y - скомпилируется\
5) int x -> x; - при явном указании типа, необходимы скобки.\
6) x -> y -> x + y; - не скомпилируется\
7) x -> (final int y) -> y + x; \
8) x -> x -> 5; - TargetType не является интерфейсом\
**Источник**  \
https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#target-typing \

31. Скомпилируется ли следующий код и почему?\
  ```java
for (byte b : "Java".getBytes()) {
            foo(() -> b);
 }
  ```
**Ответ**  \
Нет. Целевой тип не является интерфейсом\
**Источник**  \

32. Дана матрица 3х3 используя Java 8 преобразуйте ее в одномерный массив.\
```java
int[][] matrix = {   {1, 2, 3}
                           , {4, 5, 6}
                           , {7, 8, 9}};
int[] array = ….
```
**Ответ** \ 
```java
int[] array = Arrays.stream(matrix)
        .flatMapToInt(IntStream::of)
        .toArray();
```
**Источник**  

33. Даны классы:\
  ```java
class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes; 
}
enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}
List<BlogPost> posts = Arrays.asList( ... );
```
Определите:\
1.	Все уникальные статьи относящиеся к каждому типу статей.\
2.	Для каждого типа статьи определите статью с максимальным количеством лайков.\
3.	Все статьи относящиеся к каждому типу статей, список статей должен представлять собой строку формата: “Post titles: [title1, title2, …..] “\
**Ответ**  \
**Источник**  \

34. Приведите два способа получения последнего элемента в потоке, в чем особенности вычисления этого значения в потоках.\
**Ответ**  
1) ```java
Stream stream = valueList.stream();
stream.reduce((first, second) -> second)
  .orElse(null);
```
Здесь поток сводится к уровню, где он остается только с последним элементом. Если поток пуст, он вернет нулевой ценность.\
2) Другой способ получить последний элемент потока – это пропуская все элементы, перед ним\
 ```java
long count = valueList.stream().count();
Stream stream = valueList.stream();
   
stream.skip(count - 1).findFirst().get();
```
Особенность мы никогда не знаем, является ли оцениваемый в настоящее время элемент последним.\
**Источник**  
https://javascopes.com/java-stream-last-element-a89718c7/ \
35. Дан код, можно ли его как-то отрефакторить? Если да, то сделайте это.\
Подсказка:\
Добавьте в список элемент с автором, которые уже есть в списке и проверьте приложение \
  ```java
books.add(new Book("Java: A Beginner's Guide", "Herbert Schildt"));
class Book {
private String name;
private String author;

// getters and setters
…
}

List<Book> books = new ArrayList<>();

books.add(new Book("Effective Java", "Joshua Bloch"));
books.add(new Book("Thinking in Java", "Bruce Eckel"));
books.add(new Book("Java: The Complete Reference", "Herbert Schildt"));

Map<String, String> bookMap = books.stream().collect(
Collectors.toMap(Book::getAuthor, Book::getName));
bookMap.forEach((author, book) -> 
System.out.println("Author: " + author + " Books: " + book));
  ```
**Ответ**  
**Источник**  

36. Дан код\
  ```java
class Employee {
    Integer employeeId;
    String employeeName;
 
    // getters and setters
}
 
class Department {
    Integer employeeId;
    String department;
 
    // getters and setters
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        populate(employees, departments);

       List<Employee> salesEmpoyees = ...
    }
}
```
Замените многоточие, чтобы определить сотрудников находящихся в отделе “sales”\
**Ответ**  
**Источник**  

37. Дан код\
  ```java
class Tuple<T1, T2> {
	private T1 item1;
	private T2 item2;
	// getters and setters
}
List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Dennis")); 
List<Integer> ages = new ArrayList<>(Arrays.asList(24, 25, 27));
List<Tuple<String, Integer>> namesAndAges = … 
```
Выполните операцию ‘zip’ для коллекций ages и names.\
Zip: операция «zip» немного отличается от стандартной «concat» или «merge». В то время как операции «concat» или «merge» просто добавят новую коллекцию в конец существующей коллекции, операция «zip» возьмет элемент из каждой коллекции и объединит их.\
Например, в результате выполнения этого задания должна получиться коллекция:\
[John;24, Jane;25, Jack;27]\
**Ответ**  
```java
List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Dennis"));
List<Integer> ages = new ArrayList<>(Arrays.asList(24, 25, 27));
List<Tuple<String, Integer>> namesAndAges = IntStream
        .range(0, Math.min(names.size(), ages.size()))
        .mapToObj(i -> {
            Tuple<String, Integer> tuple = new Tuple<>();
            tuple.setItem1(names.get(i));
            tuple.setItem2(ages.get(i));
            return tuple;
        }).toList();
```
**Источник**  \
https://www.baeldung.com/java-collections-zip \

38. Дан код, замените  {code} и {type} так, чтобы получить нужные результаты\
  ```java
Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
1.	// Удалить все дубликаты
List<String> unique= strings.stream().{code}
// напечатает unique= [a1, b2, c3]
System.out.println("unique = " + unique); 
2.	// Объединить все элементы в одну строку через разделитель : и обернуть тегами <b> ... </b>
String join = strings.stream().collect({code});
// напечатает <b> a1 : b2 : c3 : a1 </b>
System.out.println("join = " + join); 
3.	// Преобразовать в map, сгруппировав по первому символу строки
Map<String, List<String>> groups = strings.stream().collect({code});
// напечатает groups = {a=[a1, a1], b=[b2], c=[c3]}
System.out.println("groups = " + groups); 
4.	// Преобразовать в map, сгруппировав по первому символу строки и в качестве значения взять второй символ, если ключ повторяется, то значения объединить через “:” 
Map<String, String> groupJoin = strings.stream()
     .collect(Collectors.groupingBy({code}));
// напечатает groupJoin = groupJoin = {a=1:1, b=2, c=3}
System.out.println("groupJoin = " + groupJoin);

Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);
1.	// Получить сумму нечетных чисел
{type} sumOdd = numbers.stream().collect({code});
// напечатает sumEven = 4
System.out.println("sumOdd = " + sumOdd); 
2.	 // Вычесть из каждого элемента 1 и получить среднее
 double average = numbers.stream().collect({code});
 // напечатает average = 1.5
System.out.println("average = " + average); 
3.	// Прибавить к числам 3 и получить статистику: количество элементов, их сумму, макс и мин. значения, а также их среднее.
{type} statistics = numbers.stream().collect({code});
// напечатает statistics = … {count=4, sum=22, min=4, average=5.500000, max=7}
System.out.println("statistics = " + statistics);
4.	// Разделить числа на четные и нечетные
Map<Boolean, List<Integer>> parts = numbers.stream().collect({code});
// напечатает parts = {false=[1, 3], true=[2, 4]}
System.out.println("parts = " + parts); 
  ```
**Ответ**  

**Источник**  


39. Дан поток, определите количество вхождений каждого из символов, составляющих поток.\
  ```java
Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");
  ```
**Ответ**  
**Источник**  

40. Дан код, как он будет выглядеть если modem обернуть в Optional?\
  ```java
   boolean isInRange = false;
    if (modem != null && modem.getPrice() != null
      && (modem.getPrice() >= 10
        && modem.getPrice() <= 15)) { 
        isInRange = true;
    }
    return isInRange;
                                  ```
**Ответ**  
**Источник**  

41. Дан код, замените {code}, чтобы получить первый объект, которые не null, если такого нет вернуть “default’\
                                  ```java
private Optional<String> getEmpty() {
    return Optional.empty();
}
 
private Optional<String> getHello() {
    return Optional.of("hello");
}
 
private Optional<String> getBye() {
    return Optional.of("bye");
}
String firstNonNull = Stream.of(getEmpty(), getHello(), getBye()).{code};
  ```
**Ответ**  
**Источник**  


