1. Что такое исключения?  
**Ответ.**  
Исключение - это событие, возникающее во время выполнения программы, которое нарушает нормальный поток инструкций.
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
 
2. Какие действия производит система времени выполнения при возникновении исключения?  
**Ответ.**  
Когда в методе возникает ошибка, метод создает объект и передает его системе выполнения. Объект, называемый объектом исключения, содержит информацию об ошибке, включая ее тип и состояние программы на момент возникновения ошибки. Создание объекта исключения и передача его системе выполнения называется созданием исключения.
После того, как метод выдает исключение, система выполнения пытается найти что-то для его обработки. Набор возможных "что-то" для обработки исключения представляет собой упорядоченный список методов, которые были вызваны для перехода к методу, в котором произошла ошибка. Список методов известен как стек вызовов
Система выполнения выполняет поиск в стеке вызовов метода, содержащего блок кода, который может обрабатывать исключение. Этот блок кода называется обработчиком исключений. Поиск начинается с метода, в котором произошла ошибка, и продолжается через стек вызовов в обратном порядке, в котором были вызваны методы. Когда соответствующий обработчик найден, система выполнения передает исключение обработчику. Обработчик исключений считается подходящим, если тип создаваемого объекта исключения соответствует типу, который может быть обработан обработчиком.
Считается, что выбранный обработчик исключений перехватил исключение. Если система выполнения выполняет исчерпывающий поиск по всем методам в стеке вызовов, не находя соответствующего обработчика исключений, как показано на следующем рисунке, система выполнения (и, следовательно, программа) завершается.

**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html 

3. Как называется блок кода, который обрабатывает исключение?  
**Ответ.**  
Блок ``catch{}``  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java 

4. Как реализуется требование «Поймай или Укажи» (Catch or Specify)?  
 **Ответ.**  
A try statement that catches the exception. The try must provide a handler for the exception, as described in Catching and Handling Exceptions.
A method that specifies that it can throw the exception. The method must provide a throws clause that lists the exception, as described in Specifying the Exceptions Thrown by a Method.  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html 

5. Какая иерархия классов исключений?  
**Ответ.**  
Базовым классом для всех исключений является класс Throwable. От него уже наследуются два класса: Error и Exception. Все остальные классы являются производными от этих двух классов.  
Класс Error описывает внутренние ошибки в исполняющей среде Java. Программист имеет очень ограниченные возможности для обработки подобных ошибок.  
Собственно исключения наследуются от класса Exception. Среди этих исключений следует выделить класс RuntimeException. RuntimeException является базовым классом для так называемой группы непроверяемых исключений (unchecked exceptions) - компилятор не проверяет факт обработки таких исключений и их можно не указывать вместе с оператором throws в объявлении метода. Такие исключения являются следствием ошибок разработчика, например, неверное преобразование типов или выход за пределы массива.  
Некоторые из классов непроверяемых исключений:  
•	ArithmeticException: исключение, возникающее при делении на ноль  
•	IndexOutOfBoundException: индекс вне границ массива  
•	IllegalArgumentException: использование неверного аргумента при вызове метода  
•	NullPointerException: использование пустой ссылки  
•	NumberFormatException: ошибка преобразования строки в число  
Все остальные классы, образованные от класса Exception, называются проверяемыми исключениями (checked exceptions).  
Некоторые из классов проверяемых исключений:  
•	CloneNotSupportedException: класс, для объекта которого вызывается клонирование, не реализует интерфейс Cloneable  
•	InterruptedException: поток прерван другим потоком  
•	ClassNotFoundException: невозможно найти класс  
**Источник**  
https://metanit.com/java/tutorial/4.2.php 

6. Какие виды исключений относятся к непроверяемым?  
**Ответ.**  
Непроверяемые исключение в Java – это то, которое возникает во время выполнения. Они также называются исключениями времени выполнения (Runtime Exceptions). К ним относятся ошибки программирования, такие как логические ошибки или неправильное использование API.  
**Источник**  
https://hr-vector.com/java/proveryaemye-i-neproveryaemye-isklyucheniya 

7. Какие компоненты могут входить в обработчик исключений?  
**Ответ.**  
Блок try{}, catch{} и необязательный блок finaly{}  
**Источник**  
http://www.ccfit.nsu.ru/~deviv/courses/oop/tij2nd/Chapter10.html 

8. Для каких ситуаций используется оператор try-with-resources?  
**Ответ.**  
Конструкцию try-with-resources ввели в Java 7. Она дает возможность объявлять один или несколько ресурсов в блоке try, которые будут закрыты автоматически без использования finally блока.  
**Источник**  
https://www.examclouds.com/ru/java/java-core-russian/try-with-resources#:~:text=%D0%9A%D0%BE%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%86%D0%B8%D1%8E%20try%2Dwith%2Dresources%20%D0%B2%D0%B2%D0%B5%D0%BB%D0%B8,lang. 
 
9. Какой код заключается в блок try?  
**Ответ.**  
код, в котором может произойти исключение.  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java
 
10. Выполняется ли весь код блока try в случае возникновения исключения?  
**Ответ.**  
Нет, при возбуждении исключения в блоке try обработчик исключения ищется в следующем за ним блоке catch. Если в catch есть обработчик данного типа исключения – управление переходит к нему. Если нет, то JVM ищет обработчик этого типа исключения в цепочке вызовов методов до тех пор, пока не будет найден подходящий catch.  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java 
 
11. Может ли использоваться только один блок try (без catch или finally)?  
 **Ответ.**  
 нет, не может  
**Источник**  

12. Какое назначение блока catch?  
 **Ответ.**  
определяет блок кода, в котором происходит обработка исключения;  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java%D0%9C%D0%BE%D0%B6%D0%B5%D1%82%20%D0%BB%D0%B8%20%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C%D1%81%D1%8F%20%D1%82%D0%BE%D0%BB%D1%8C%D0%BA%D0%BE%20%D0%BE%D0%B4%D0%B8%D0%BD%20%D0%B1%D0%BB%D0%BE%D0%BA%20try%20(%D0%B1%D0%B5%D0%B7%20catch%20%D0%B8%D0%BB%D0%B8%20finally)? 

13. Сколько блоков catch может содержаться после try-оператора?  
**Ответ.**  
Любое количество.  
**Источник**  
http://www.linkex.ru/java/operators-catch.php
 
14. Если применяется несколько блоков catch, то в каком порядке в случае возникновения исключения они вызываются?  
**Ответ.**  
Когда возбуждается исключение, каждый оператор catch проверяется по порядку, и первый из них, чей тип соответствует исключению, выполняется. После того, как выполнится один из операторов catch, все остальные пропускаются, и выполнение программы продолжается с места, следующего за блоком try/catch.  
**Источник**  
http://www.linkex.ru/java/operators-catch.php
 
15. Какой код может быть между блоками try и catch?  
**Ответ.**  
Блок try не может существовать при отсутствии выражения catch либо выражения finally.  
Существование какого-либо кода в промежутке между блоками try, catch, finally является невозможным.  
**Источник**  
http://proglang.su/java/exceptions#:~:text=%D0%91%D0%BB%D0%BE%D0%BA%20try%20%D0%BD%D0%B5%20%D0%BC%D0%BE%D0%B6%D0%B5%D1%82%20%D1%81%D1%83%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%BE%D0%B2%D0%B0%D1%82%D1%8C,%2C%20catch%2C%20finally%20%D1%8F%D0%B2%D0%BB%D1%8F%D0%B5%D1%82%D1%81%D1%8F%20%D0%BD%D0%B5%D0%B2%D0%BE%D0%B7%D0%BC%D0%BE%D0%B6%D0%BD%D1%8B%D0%BC. 
 
16. Может ли использоваться блок catch без блока try?  
**Ответ.**  
Выражение catch не может существовать без оператора try.  
**Источник**  http://proglang.su/java/exceptions#:~:text=%D0%91%D0%BB%D0%BE%D0%BA%20try%20%D0%BD%D0%B5%20%D0%BC%D0%BE%D0%B6%D0%B5%D1%82%20%D1%81%D1%83%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%BE%D0%B2%D0%B0%D1%82%D1%8C,%2C%20catch%2C%20finally%20%D1%8F%D0%B2%D0%BB%D1%8F%D0%B5%D1%82%D1%81%D1%8F%20%D0%BD%D0%B5%D0%B2%D0%BE%D0%B7%D0%BC%D0%BE%D0%B6%D0%BD%D1%8B%D0%BC. 
 
17. Сколько типов исключений может обрабатывать один блок catch?  
**Ответ.**  
Начиная с Java 7,  для того, чтобы поймать несколько исключений, можно использовать множественный catch блок, который не только снизит количество дублированного кода, но и улучшит его читабельность.  
```java
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}
```
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html 
 
18. В случае отсутствия исключения в блоке try выполняется ли блок catch?  
**Ответ.**  
нет  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java
 
19. Для чего используется блок finally?  
**Ответ.**  
определяет блок кода, который является необязательным, но при его наличии выполняется в любом случае независимо от результатов выполнения блока try  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java 
 
20. В случае отсутствия исключения в блоке try выполняется ли блок finally (при его наличии)?  
**Ответ.**  
да  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html 
 
21. Могут ли использоваться блоки try-finally без блока catch?  
**Ответ.**  
могут  
**Источник**  
 
22. Приведите пример кода, в котором используется оператор try-with-resources.  
**Ответ.**  
```java
public void writeList() throws IOException {
    try (FileWriter f = new FileWriter("OutFile.txt");
         PrintWriter out = new PrintWriter(f)) {
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
    }
}
```
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html 
 
23. Какой оператор может использоваться вместо try-with-resources?  
**Ответ.**  
Finally{}  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html 
 
24. Может ли применяться оператор try-with-resources совместно с блоком finally?  
**Ответ.**  
Может.  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html 
 
25. Какое ключевое слово используется в сигнатуре метода, чтобы указать на возможность выбрасывания им исключения?  
**Ответ.**  
throws  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java 
 
26. Сколько исключений может выбрасывать метод?  
**Ответ.**  
Любое количество  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html 
 
27. Какое ключевое слово используется для гарантированного выбрасывания исключения?  
**Ответ.**  
throw  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java 
 
28 Можно ли создавать свои собственные классы исключений?  
**Ответ.**  
When faced with choosing the type of exception to throw, you can either use one written by someone else — the Java platform provides a lot of exception classes you can use — or you can write one of your own.  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html 
 
29. Приведите примеры наиболее известных подклассов класса Exception.  
**Ответ.**  RuntimeException, SQLException, IOException  
**Источник**  
https://javastudy.ru/interview/exceptions/ 
 
30. Приведите примеры наиболее известных подклассов класса RuntimeException.  
**Ответ.**  
NoSuchElementException, IndexOutOfBoundException, ArithmeticException, ClassCastException.  
**Источник**  
https://javastudy.ru/interview/exceptions/ 
  
31. Что такое сцепление исключений?  
**Ответ.**  
В тех случаях, когда исключение нижнего уровня может быть полезно при анализе ситуации, вызвавшей исключение, лучше использовать особый вид трансляции исключений, называемый сцеплением исключении (exception chaining). При этом исключение нижнего уровня передается с исключением верхнего уровня; в последнем создается открытый метод доступа, позволяющий извлечь исключение нижнего уровня:   
**Источник**  
Джошуа Блох. Эффективное программирование стр. 168  
 
32. Приведите пример кода со сцеплением исключений.  
**Ответ.**  
```java
// Сцепление исключений try {
//Использование абстракции нижнего уровня
//для выполнения наших указаний
}catch(LowerLevelException е) {
throw new HigherLevelException(e); }
```
**Источник**  
Джошуа Блох. Эффективное программирование стр. 168
 
33. Какая информация приводится при трассировке стека во время исключения?  
**Ответ.**  
Имя исключеия, а также список методов, которые были вызваны до момента, когда в приложении произошло исключение.  
**Источник**  
https://ru.stackoverflow.com/questions/510755/%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-stack-trace-%D0%B8-%D0%BA%D0%B0%D0%BA-%D1%81-%D0%B5%D0%B3%D0%BE-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-%D0%BD%D0%B0%D1%85%D0%BE%D0%B4%D0%B8%D1%82%D1%8C-%D0%BE%D1%88%D0%B8%D0%B1%D0%BA%D0%B8-%D0%BF%D1%80%D0%B8-%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%BA%D0%B5-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6 
 
34. В каких случаях целесообразно создавать собственный класс исключения?  
**Ответ.**  
You should write your own exception classes if you answer yes to any of the following questions; otherwise, you can probably use someone else's.  
•	Do you need an exception type that isn't represented by those in the Java platform?  
•	Would it help users if they could differentiate your exceptions from those thrown by classes written by other vendors?  
•	Does your code throw more than one related exception?  
•	If you use someone else's exceptions, will users have access to those exceptions? A similar question is, should your package be independent and self-contained?  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html 
 
35. Какой класс исключений может использоваться в качестве суперкласса для собственного исключения?  
**Ответ.**  
Желательно использовать класс Exceptions  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html 
 
36. Какие исключения целесообразно делать проверяемыми, а какие – непроверяемыми?  
**Ответ.**  
Исключительные ситуации, возникающие в программе, можно разделить на две группы:  
1.	Ситуации, при которых восстановление дальнейшей нормальной работы программы невозможно  
2.	Восстановление возможно.  
К первой группе относят ситуации, когда возникают исключения, унаследованные из класса Error. Это ошибки, возникающие при выполнении программы в результате сбоя работы JVM, переполнения памяти или сбоя системы. Обычно они свидетельствуют о серьезных проблемах, устранить которые программными средствами невозможно. Такой вид исключений в Java относится к неконтролируемым (unchecked) на стадии компиляции. К этой группе также относят RuntimeException – исключения, наследники класса Exception, генерируемые JVM во время выполнения программы. Часто причиной возникновения их являются ошибки программирования. Эти исключения также являются неконтролируемыми (unchecked) на стадии компиляции, поэтому написание кода по их обработке не является обязательным. Ко второй группе относят исключительные ситуации, предвидимые еще на стадии написания программы, и для которых должен быть написан код обработки. Такие исключения являются контролируемыми (checked). Основная часть работы разработчика на Java при работе с исключениями – обработка таких ситуаций.  
**Источник**  
https://javarush.ru/groups/posts/isklyucheniya-java 
 
37. Какие преимущества в механизме выбрасывания и обработки исключений?  
**Ответ.**  
Advantage 1: Separating Error-Handling Code from "Regular" Code  
Advantage 2: Propagating Errors Up the Call Stack  
Advantage 3: Grouping and Differentiating Error Types  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html 
 
38. Можно ли выбрасывать исключения в конструкторах?  
**Ответ.**  
Можно  
**Источник**  
 
39. Может ли произойти потеря исключения? Если да – приведите пример.  
**Ответ.**  	
Да, может.  
```java
public class ExceptionLossTest{

    public static void main(String[] args){
        try {
            try {
                throw new Exception("a");
            } finally {
                if (true) {
                    throw new IOException("b");
                }
                System.err.println("c");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println("d");
            System.err.println(ex.getMessage());
        }
    }
}
```
**Источник**  
http://www.skipy.ru/technics/exceptions.html#no_trans 
 
40. Обладают ли исключения свойством транзакционности?  
**Ответ.**  
Cвойством транзакционности исключения не обладают – действия, произведенные в блоке try до возникновения исключения, не отменяются поcле его возникновения.  
**Источник**  
http://www.skipy.ru/technics/exceptions.html#no_trans 


41. Является ли данный код антипаттерном?  
Обоснуйте ответ.  
```java
void methodCatchesSomeException() {
        	...
        	try {
                    	...
        	} catch (SomeException ex) {
                    	...
        	}
        	...
}
```
**Ответ.**  
Нет. В данном примере, в случае генерации исключения в блоке try{}, оно будет обработано в блоке catch{}.  
**Источник**  

42. Является ли данный код антипаттерном?   
Обоснуйте ответ.   
```java
void methodThrowsSomeCheckedException() {
        	...
        	throw new SomeCheckedException();
        	...
}
```
**Ответ.**  
Да. В случае генерации проверяемого исключения, компилятор будет требовать обработки объекта данного исключения в методе или передачу его с помощью конструкции throws. Ни одного из вариантов в данном коде не применено.  
**Источник**  
И.Блинов, Java. Методы программирования, стр. 211  
 
43. Является ли данный код верным? Укажите почему.  
 ```java
void methodThrowsSomeCheckedException() throws SomeCheckedException {
        	...
        	throw new SomeCheckedException();
        	...
}
```
**Ответ.**  
**Источник**  
 
44. Приведите примеры кода с выбросом RuntimeException явным образом и в случае программной ошибки.  
**Ответ.**  
**Источник**  
 
45. Можно ли отрефакторить данный код? Если да, то выполните.  
```java  
void methodThrowsSomeRuntimeException() {
        	...
        	throw new SomeRuntimeException();
        	...
}
```
**Ответ.**  
**Источник**  
 
46. Является ли данный код антипаттерном?   
Обоснуйте ответ. 
```java
void methodThrowsSomeRuntimeException() throws SomeRuntimeException {
        	...
        	throw new SomeRuntimeException();
        	...
}
```
**Ответ.**  
**Источник**  
 
47. В какой версии Java появился оператор try-with-resources? Приведите пример кода с использованием указанного оператора.  
**Ответ.**  
Появился в Java 7  
```java
static String readFirstLineFromFile(String path) throws IOException {
	    try (FileReader fr = new FileReader(path);
	         BufferedReader br = new BufferedReader(fr)) {
	        return br.readLine();
	    }
	}	
```
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html 
 
48. Является ли данный код антипаттерном?   
Обоснуйте ответ.  
```java
void methodWithAutocloseableInstance() {
        	...
        	try(SomeResource res = new SomeResource(...)) {
                    	...
        	}
        	...
}
```
**Ответ.**  
Да, т.к. не происходит отлов исключения, в случае выброса проверяемого исключения в блоке try, оно не будет обработано нигде и метод завершится с ошибкой.  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html 
 
49. Является ли данный код антипаттерном?   
Обоснуйте ответ. 
```java
void methodWithAutocloseableInstance() {
        	...
        	try(SomeResource res = new SomeResource(...)) {
                    	...
        	} catch (CorrectCheckedException ex) {
                    	…
        	}
        	...
}
```
**Ответ.**  
Нет, т.к. экземпляры SomeResource объявляются в конструкции try-with-resource, они будут закрыты независимо от того, завершается ли блок try нормально или с исключением. А также в случае исключения, оно будет обработано в блоке catch.  
**Источник**  
https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html 

50. Является ли данный код антипаттерном?   
Обоснуйте ответ.  
```java
try {
           …
}  catch (SomeException е) {
        	//no code
}
```
**Ответ.**  
Да. В данном примере исключение игнорируется, следовательно никто не узнает о том, что что-то в программе идет не по плану.  
**Источник**  
 
51. Является ли данный код антипаттерном?  
Обоснуйте ответ.   
```java
try {
        	…
}  catch (SomeException е) {
    		System.out.println(“Something went wrong!”);
}
```
**Ответ.**  
Да. В данном примере слишком мало информации об исключении. По данному сообщению не понятно из-за чего оно возникло.  
**Источник**  
 
52. Является ли данный код антипаттерном, если блок catch находится не в конце раннер-метода main()?   
Обоснуйте ответ.  
```java
try {
    		…
}  catch (Exception е) {
    		…
}
…
```
 ```java
или другой вариант
 
try {
        	…
}  catch (Throwable е) {
        	…
}
…
```
**Ответ.**  
Да. Данный код является антипаттерном. Так как происходит обработка объектов исключения классов Exception и Throwable – классов, находящихся в вершине наследования. При возникновения исключений, являющихся подклассами данных классов, не будет никакой информации о типе исключения, что могло бы помочь разобраться с местом и причиной исключения.  
**Источник**  

53. Является ли данный код антипаттерном?  
Обоснуйте ответ.  
```java
try {
    	int i = 0;
  	  while(true) {
        	а[i++].f();
        }
} catch(ArraylndexOutOfBoundsException е) {
    	…
}
```
**Ответ.**  
В данном примере происходит отлов непроверяемого исключения ArraylndexOutOfBoundsException. Выброс данного исключения говорит об ошибке программиста. Необходимо не допускать выброс таких исключений, путем корректировки логики.  
**Источник**  
 
54. Есть ли недостатки у API  написанного только с использованием обрабатываемых исключений?  
**Ответ.**  
**Источник**  
 
55. Даны два варианта сеттера.  
Какой является более предпочтительным в использовании?  
Обоснуйте ответ.   
Вариант 1.  
```java
void setPositiveValue(int value) {
        	if(value <= 0) {
                    	throw new IllegalArgumentException(...);
        	}
        	this.value = value;
}
```
Вариант 2.  
```java
void setPositiveValue(int value) throws SomeCheckedException {
        	if(value <= 0) {
                    	throw new SomeCheckedException(...);
        	}
        	this.value = value;
}
```
**Ответ.**  
Вариант 2 является более предпочтительным. Так как в нем выбрасывается проверяемое исключение, в отличие от первого варианта – непроверяемого исключения.  
**Источник**  

 
56. Приведите пример наиболее распространенных из повторно используемых исключений и причины их применения.  
**Ответ.**  
**Источник**  
 
57. Если недостаточно информации для принятия решения и...  
1)     исключительная ситуация должна быть исправлена на ближайшем уровне;  
2)     исключительная ситуация маловероятна  
Экземпляры подклассов каких типов исключений целесообразно сгенерировать в каждом случае?  
**Ответ.**  
**Источник**  
 
58. Выделите в блоке try-catch основной и альтернативный сценарии.   
Обоснуйте ответ.   
```java
try {
        	...
        	User user = source.getUser(login, password);
        	if(GUEST_USER.equals(user) {
                    	…
        	} else {
                    	…
        	}
        	...
}  catch (SourceException е) {
    		…
}
class Source {
        	public User getUser(String login, String password) throws SourceException {
                    	...
                    	throw new SourceException(...);
                    	...
                    	return GUEST_USER;	//wrong login or password
                    	...
                    	return new User(...);
        	}
        	...
}
             ```
**Ответ.**  
Основной сценарий – ввод неправильного логина и пароля.  
Альтернативный сценарий – ввод верных логина и пароля.  
**Источник**  
 
59. Перепишите код предыдущего задания с условием, что ввод неправильных логина или пароля является альтернативным сценарием.  
**Ответ.**  
**Источник**  
 
60. Что такое трансляция исключения, когда ее используют и какие правила ее использования? Приведите пример трансляции исключения.  
**Ответ.**  	
Трансляция исключения - верхние уровни приложения перехватывают исключения нижних уровней и, в свою очередь, инициируют исключения, которые можно объяснить в терминах абстракции верхнего уровня.  
```java
try {
//Использование абстракции нижнего уровня
//для выполнения наших указаний
}catch(LowerLevelException е) {
throw new HigherLevelException( ... ); }
```

Пример:  
```java
/**
*Возвращает элемент, находящийся в указанной позиции  
*в заданном списке.
*@throws IndexOutOfBoundsException, если индекс находится
*за пределами диапазона (index < 0II index >=size()).
*/
public Object get(int index) { ListIterator i = listItеrаtor(index); try {
return i. next();
catch (NoSuchElementException е) {
throw new IndexOutOfBoundsException("Index: " + index); }
}
```
**Источник**  
 
61. Как можно избежать использования трансляций и зачем нужно это предпринимать?  
**Ответ.**  
Самый хороший способ обработки исключений нижнего уровня - полностью исключить их возможность. Для этого перед выбором метода нижнего уровня необходимо убедиться в том, что он будет выполнен успешно, иногда добиться этого можно путем явной проверки аргументов метода верхнего уровня перед их передачей на нижний уровень.  
Если предупредить появление исключений на нижних уровнях невозможно, то лучшее решение состоит в том, чтобы верхний уровень молча обрабатывал эти искл ючения, изолируя клиента от проблем нижнего уровня. В таких условиях чаще всего достаточно протоколировать исключения, используя какой-либо механизм регистрации, например java,util,logging, появившийся в версии 1.4.Это дает возможность администратору исследовать возникшую проблему и в то же время изолирует от нее программный код клиента и конечного пользователя.  
**Источник**  
Дж. Блох Java: эффективное программирование  
 
62. В каких случаях  надо предпочесть сцепление трансляции?  
**Ответ.**  
В тех случаях, когда исключение нижнего уровня может быть полезно при анализе ситуации, вызвавшей исключение, лучше использовать особый вид трансляции исключений, называемый сцеплением исключении (exception chaining). При этом исключение нижнего уровня передается с исключением верхнего уровня; в последнем создается открытый метод доступа, позволяющий извлечь исключение нижнего уровня:  
**Источник**  
Дж. Блох Java: эффективное программирование  

63. Можно ли для исключительной ситуации определить, класс, который не является подклассом Exception, RuntimeException, Error.  
Если да, то как он будет себя проявлять (как checked-exception или как unchecked-exception)?  
**Ответ.**  
**Источник**  
 
64. Обязательно ли информацию об исключительное ситуации представлять строковым полем?  
Если нет, то какой альтернативный способ создания строкового представления исключения?  
**Ответ.**   
**Источник**  
 
65. Если метод завершается сбоем, что нужно сделать с объектом, на котором был вызван этот метод?  
**Ответ.**  
**Источник**  
 
66. Приведите способы достижения атомарности по отношению к сбоям.  
**Ответ.**  
**Источник**  
 
67. Приведите пример, когда отсутствие транзакционности в исключениях, приводит к сохранению ссылки на объект в неверном состоянии.  
**Ответ.**  
```java
public class PartialInitTest{

    static PartialInitTest self;

    private int field1 = 0;
    private int field2 = 0;

    public PartialInitTest(boolean fail) throws Exception{
        self = this;
        field1 = 1;
        if (fail) {
            throw new Exception();
        }
        field2 = 1;
    }

    public boolean isConsistent(){
        return field1 == field2;
    }

    public static void main(String[] args){
        PartialInitTest pit = null;
        try {
            pit = new PartialInitTest(true);
        } catch (Exception ex){
            // do nothing
        }
        System.out.println("pit: "+pit);
        System.out.println("PartialInitTest.self reference: "+PartialInitTest.self);
        System.out.println("PartialInitTest.self.isConsistent(): "+PartialInitTest.self.isConsistent());
    }
}
```
**Источник**  
http://www.skipy.ru/technics/exceptions.html#no_trans 
 
68. Необходимо создать коллекцию из результатов тестов, находящихся в валидном файле src/in.csv.  
Пример файла  
cool;75;90  
clever;68;95  
looser;30;48  
Является ли код, реализующий задание, антипаттерном?   
Обоснуйте ответ.   
 ```java
public class Runner {
        	public static void main(String[] args) {
                    	List<Trial> trials = new ArrayList<Trial>();
                    	try(Scanner sc = new Scanner(new FileReader("src/in.csv"))) {
                               	while(sc.hasNext()) {
                                           	Trial trial = getTrial(sc);
                                           	trials.add(trial);
                               	}
                               	printTrials(trials);
                    	} catch (FileNotFoundException e) {
                               	System.out.println(Constants.ERROR_FILE_FOUND);
                    	}
        	}
        	private static Trial getTrial(Scanner sc) {
                    	String csvLine = sc.nextLine();
                    	String[] values = csvLine.split(Constants.DELIMETER);   	
                    	try {
                               	String name = values[Constants.NAME_INDEX];
                               	int mark1 = Integer.parseInt(values[Constants.MARK1_INDEX]);
                               	int mark2 = Integer.parseInt(values[Constants.MARK2_INDEX]);
                   		return new Trial(name, mark1, mark2);
                    	} catch (CsvLineException e) {
                               	System.out.println(Constants.ERROR_WRONG_DATA);
                    	}
        	}
  ```
**Ответ.**  
**Источник**  
 
69. Приведите пример кода собственного исключения (реализация в одном классе всего нижеперечисленного). Класс исключения содержит:  
-         поле, которым является неправильная строка, считанная из файла (имя csvLine);  
-         конструктор по умолчанию, вызывающий конструктор суперкласса;  
-         параметризованный конструктор, принимающий экземпляр исключения и неправильную строку, считанную из файла;  
-         параметризованный конструктор, принимающий строку с указанием причины исключения и  неправильную строку, считанную из файла;  
-         геттер с возвратом неправильной строки;  
-         переопределенного метода toString с указанием неправильной строки и метода вывода сообщения об ошибки.  
**Ответ.**  
**Источник**  
 
70. Необходимо создать метод для экспорта csv-файла в коллекцию.  
При наличии хотя бы одной ошибки в исходных данных “отменить” создание   
коллекции.  
Какие антипаттерны содержит следующий код?   
Предложите варианты по избавлению от них.  
```java
private static List<Trial> getTrials(Scanner sc) {
List<Trial> trials = new ArrayList<Trial>();
try {
while(sc.hasNext()) {
Trial trial = getTrial(sc);
trials.add(trial);
}
} catch (CsvLineException e) {
System.err.println(e);
}
return trials;
}
```
**Ответ.**  
**Источник**  
 
72. Создать метод для экспорта данных в коллекцию из последовательного источника экземпляров Trial.  
См. код ниже.  
Его необходимо дополнить, чтобы происходила обработка следующих исключительных ситуаций:  
1. 	Файл не найден.  
2. 	Ошибка в csv строке.  
Примечание: код не должен нарушать принцип “верхние уровни приложения должны перехватывать исключения нижних уровней и, в свою очередь, генерировать исключения, которые можно пояснить в терминах абстракции верхнего уровня” 
См. Блох, Д. Java эффективное программирование. 3-е издание. Глава 10 Исключения. Стр 370.  
Считается, что классы для исключений созданы и имеют необходимый функционал.  
Подсказка:
---
Надо использовать два исключения. Одно из которых будет нижнего уровня, другое верхнего уровня.
---
Еще одна подсказка:
---
Одно из исключений обрабатываемое, другое нет.
---

//начало кода, реализующего задание
//---
interface TrialProvidable {
boolean hasTrial();
Trial getTrial();
}
 
public class TrialCsvImpl implements TrialProvidable {
private Scanner sc;
public CsvImpl(String csvName) {            	
sc = new Scanner(new FileReader(csvName));
}
public boolean hasTrial() {             	
return sc.hasNextLine();
}
public Trial getTrial() {
// get Trial instance from csv line
return trial;
}
}
 
public class Runner {
private static List<Trial> getTrials(TrialProvidable trialProvider) {
List<Trial> trials = new ArrayList<Trial>();
while(trialProvider.hasTrial()) {
Trial trial = trialProvider.getTrial();
trials.add(trial);
}
return trials;
}
 
public static void main(String[] args) {
TrialProvidable trialProvider = null;
try {
if("csv".equals(args[0])) {
trialProvider = new TrialCsvImpl("src/in.csv");
} else {
trialProvider = new TrialDBImpl();
}
List<Trial> trials = getTrials(trialProvider);
…
} finally {
if (trialProvider != null) {
trialProvider.close();
}
}
}
}
//---
//конец кода, реализующего задание

