Дайте неформальное определение контейнера.  
**Ответ.**   
container — is simply an object that groups multiple elements into a single unit.
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/intro/index.html

Дайте определение коллекции в java. \
**Ответ.**   
Коллекциями/контейнерами в Java принято называть классы, основная цель которых – хранить набор других элементов.
**Источник.**   
https://javastudy.ru/interview/collections/

Какой имеется в java контейнер, отличный от коллекций?\
Дайте ему определение. \
**Ответ.**   
Массивы в Java — это структура данных, которая хранит упорядоченные коллекции фиксированного размера элементов нужного типа
**Источник.**   
http://proglang.su/java/arrays#:~:text=%D0%9C%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D1%8B%20%D0%B2%20Java%20%E2%80%94%20%D1%8D%D1%82%D0%BE%20%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%82%D1%83%D1%80%D0%B0,%D0%BE%20%D1%81%D0%BE%D0%B2%D0%BE%D0%BA%D1%83%D0%BF%D0%BD%D0%BE%D1%81%D1%82%D0%B8%20%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D1%8B%D1%85%20%D0%BE%D0%B4%D0%BD%D0%BE%D0%B3%D0%BE%20%D1%82%D0%B8%D0%BF%D0%B0.

Дайте определение Collections framework?\
**Ответ.**   
Java collections framework — это набор связанных классов и интерфейсов, реализующих широко используемые структуры данных — коллекции.
**Источник.**   
https://ru.wikipedia.org/wiki/Java_Collections_Framework#:~:text=Java%20collections%20framework%20%E2%80%94%20%D1%8D%D1%82%D0%BE%20%D0%BD%D0%B0%D0%B1%D0%BE%D1%80,%D0%B2%20%D0%BF%D0%B5%D1%80%D0%B2%D1%83%D1%8E%20%D0%BE%D1%87%D0%B5%D1%80%D0%B5%D0%B4%D1%8C%2C%20%D0%94%D0%B6%D0%BE%D1%88%D1%83%D0%B0%20%D0%91%D0%BB%D0%BE%D1%85%D0%BE%D0%BC.

Какие разделы содержит Collections framework?\
Определите их, и для чего они предназначены?\
**Ответ.**   
Интерфейс List  
В JCF списки реализуются через интерфейс java.util.List. Два конкретных класса имплементируют List. Первый, java.util.ArrayList, который реализует список на основе массива. Второй реализацией является java.util.LinkedList, который реализует java.util.List как двусвязный список.  

Интерфейс Set  
Интерфейс java.util.Set реализует концепцию множества. Множество не может содержать двух одинаковых элементов. К тому же множество не устанавливает порядок. Set имплементируется java.util.HashSet, java.util.LinkedHashSet и java.util.TreeSet.  
**Источник.**   
https://ru.wikipedia.org/wiki/Java_Collections_Framework#:~:text=Java%20collections%20framework%20%E2%80%94%20%D1%8D%D1%82%D0%BE%20%D0%BD%D0%B0%D0%B1%D0%BE%D1%80,%D0%B2%20%D0%BF%D0%B5%D1%80%D0%B2%D1%83%D1%8E%20%D0%BE%D1%87%D0%B5%D1%80%D0%B5%D0%B4%D1%8C%2C%20%D0%94%D0%B6%D0%BE%D1%88%D1%83%D0%B0%20%D0%91%D0%BB%D0%BE%D1%85%D0%BE%D0%BC.

В чем преимущества использования Collections Framework\
**Ответ.**   
- Требует меньше усилий. Фреймворк располагает множеством распространенных типов коллекций и полезных методов для манипуляции данными. Таким образом, мы можем сосредоточиться на бизнес-логике, а не разработке наших API.  
- Отличное качество — использование хорошо проверенных коллекций увеличивает качество нашей программы.  
- Повторное использование и совместимость  
**Источник.**   
https://javadevblog.com/obzor-kollektsiy-v-java-java-collections-framework.html

Является ли антипаттерном следующее объявление ссылки на коллекцию?\
Collection collection;\
Если да, то как называется антипаттерн и исправьте объявление ссылки. \
**Ответ.**   
да, использование RawType является антипаттерном.
Collection<SomeType> collection;
**Источник.**   

К каким негативным последствиям может привести использование raw types?\
Приведите пример. \
**Ответ.**   
Во время добавления в коллекцию объектов разного типа, компилятор не сообщит об ошибке, но при выполнении операций над этими объектами, можем столкнуться с ошибкой приведения типов.	
	```java
List names = new ArrayList(); // warning: raw type!
names.add("John");
names.add("Mary");
names.add(Boolean.FALSE); // not a compilation error!
	
for (Object o : names) {
   String name = (String) o;
   System.out.println(name);
} // throws ClassCastException!
  //    java.lang.Boolean cannot be cast to java.lang.String
	```
**Источник.**   

Почему допускаются raw types с коллекциями?\
**Ответ.**   
дженерики появились только в версии языка Java 5. К моменту ее выхода программисты успели написать кучу кода с использованием Raw Types, и чтобы он не перестал работать, возможность создания и работы Raw Types в Java сохранилась.
**Источник.**
https://javarush.ru/groups/posts/2315-stiranie-tipov

Какое главное назначение раздела Интерфейсы?\
Другими словами, если известен интерфейс коллекции, то что это дает программисту?\
**Ответ.**   
Интерфейсы коллекции объявляют операции, которые могут выполняться для каждого типа коллекции.
**Источник.**  
http://proglang.su/java/collections

Какое главное назначение раздела Имплементации?\
Другими словами, если известна имплементация, то что это дает программисту?\
**Ответ.**   
Имплементация классом интерфейса — это гарантия реализации функционала. Если класс имплементирует некоторый интерфейс, то он обещает, что в нем есть объявленные в интерфейсе методы, они принимают объявленные параметры и возвращает объявленное значение.	
**Источник.**   
https://ru.stackoverflow.com/questions/136909/%D0%98%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81%D1%8B-%D0%B2-%D0%9E%D0%9E%D0%9F-java-%D0%BF%D0%BE-%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%BC%D1%83	

Приведите иерархию интерфейсов коллекций. \
**Ответ.**  
![colls-coreInterfaces](https://user-images.githubusercontent.com/79933495/164504695-e2719015-8ea0-4dc5-999e-94ef0a6105e3.gif)
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html	

Какие существуют способы прохода (traversing) по коллекции до версии java 8 (т.е. от версии 5 до версии 7 включительно)? \
Приведите идиомы для следующей коллекции:\
Collection<Entity> entities = …;\
Какой способ является более подходящим для прохода по коллекции до версии java 8?\
**Ответ.**   
Цикл for, for each;
	```java
	for ( i = 0; i < entities.size(); i++){
		System.out.println(entities.get(i));
	}
``` 
```java
	for (Entity entity : entities){
		System.out.println(entity);
	}	
```
цикл for each не требует ручного изменения переменной - шага для перебора. Цикл автоматически выполняет эту работу.  
**Источник.**   

Реализация какого интерфейса позволяет коллекциям использоваться в конструкции for-each?\
Какой метод этого интерфейса обеспечивает данную возможность?\
**Ответ.**    
интерфейс Iterable  
метод default void forEach(Consumer<? super T> action);  
**Источник.**   

Что такое итератор?\
**Ответ.**   
Итератор - интерфейс. Реализация интерфейса предполагает, что с помощью вызова метода next() можно получить следующий элемент. С помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли конец коллекции. И если элементы еще имеются, то hasNext() вернет значение true. Метод hasNext() следует вызывать перед методом next(), так как при достижении конца коллекции метод next() выбрасывает исключение NoSuchElementException. И метод remove() удаляет текущий элемент, который был получен последним вызовом next().
**Источник.**   
https://metanit.com/java/tutorial/5.10.php 

Дана коллекция из n элементов. \
Сколько в ней существует возможных позиций курсора итератора?\
**Ответ.**   
Текущее положение и следующее  
**Источник.**   
https://metanit.com/java/tutorial/5.10.php

Какие методы объявлены в интерфейсе Iterator<E>?\
Охарактеризуйте их. \
**Ответ.**   
E next();
boolean hasNext();
void remove();
с помощью вызова метода next() можно получить следующий элемент. С помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли конец коллекции. И если элементы еще имеются, то hasNext() вернет значение true. Метод hasNext() следует вызывать перед методом next(), так как при достижении конца коллекции метод next() выбрасывает исключение NoSuchElementException. И метод remove() удаляет текущий элемент, который был получен последним вызовом next().
**Источник.**   
https://metanit.com/java/tutorial/5.10.php

В каких случаях следует явно использовать итератор вместо for-each?\
**Ответ.**   
В случаях, когда необходимо удалить элементы при переборе коллекции.
**Источник.**   

Пусть условие удаления элемента из коллекции Collection<Entity> entities задается методом isRemoved() класса Entity. \
Приведите идиому удаления элементов этой коллекции. \
**Ответ.**   
	```java
Iterator<Entity> iterator = entities.iterator();//создаем итератор
while(iterator.hasNext()) {//до тех пор, пока в списке есть элементы
   Entity nextEntity = iterator.next();//получаем следующий элемент
   if (isRemoved()) {
       iterator.remove();//удаляем элемент
   }
}
	```
**Источник.**   

Какие группы методов (или операций) объявлены в интерфейсе Collection \
(до java 8)?\
Какие методы входят в каждую группу?\
**Ответ.** 
	
- basic
int size (): возвращает число элементов в коллекции
boolean contains (Object item): возвращает true, если объект item содержится в коллекции, иначе возвращает false
boolean isEmpty (): возвращает true, если коллекция пуста, иначе возвращает false
boolean add (E item): добавляет в коллекцию объект item. При удачном добавлении возвращает true, при неудачном - false
boolean remove (Object item): возвращает true, если объект item удачно удален из коллекции, иначе возвращается false
Iterator<E> iterator (): возвращает объект Iterator для обхода элементов коллекции
	
- bulk
boolean addAll (Collection<? extends E> col): добавляет в коллекцию все элементы из коллекции col. При удачном добавлении возвращает true, при неудачном - false
boolean removeAll (Collection<?> col): удаляет все объекты коллекции col из текущей коллекции. Если текущая коллекция изменилась, возвращает true, иначе возвращается false
boolean containsAll (Collection<?> col): возвращает true, если коллекция col содержится в коллекции, иначе возвращает false
boolean retainAll (Collection<?> col): удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в коллекции col. Если текущая коллекция после удаления изменилась, возвращает true, иначе возвращается false
void clear (): удаляет все элементы из коллекции
	
- array
Object[] toArray (): возвращает массив, содержащий все элементы коллекции
 <T> T[] toArray(T[] a)	
**Источник.**   

В чем разница методов Object[] toArray(), <T> T[] toArray(T[] a) интерфейса Collection?\
**Ответ.**   
Object[] toArray() - возвращает только Object;
<T> T[] toArray(T[] a) - возвращает конкретный тип	 
**Источник.**   

В описании методов интерфейсов коллекций в JavaDoc есть методы, помеченные фразой “optional operation”. \

Modifier and Type	Method and Description\
boolean	add(E e)\
Ensures that this collection contains the specified element (optional operation).\
boolean	addAll(Collection<? extends E> c)\
Adds all of the elements in the specified collection to this collection (optional operation).\
void	clear()\
Removes all of the elements from this collection (optional operation).\

Как это понимать?\
**Ответ.**   
эти необязательные операции возвращаются к общему интерфейсу Collection, где операции становятся необязательными, что не имеет смысла для некоторых видов коллекций. Например. add - операция, которая не очень полезна для какой-либо коллекции только для чтения. Это четко изложено в Javadoc, поэтому оно становится частью того, что предлагают все классы коллекций, но кто-то, кто его использует, знает, что, учитывая некоторую коллекцию, они точно не знают, может быть, что метод просто бросает UnsupportedOperationException.
**Источник.**   
https://overcoder.net/q/455077/%D1%87%D1%82%D0%BE-%D0%BE%D0%B7%D0%BD%D0%B0%D1%87%D0%B0%D0%B5%D1%82-%D0%BD%D0%B5%D0%BE%D0%B1%D1%8F%D0%B7%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%B0%D1%8F-%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D0%B2-javadoc-%D0%BD%D0%B0%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80-set-add-e

Какую математическую сущность моделирует интерфейс Set?\
**Ответ.**   
Он моделирует математическое представление множество.
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html

Какое основное свойство всех имплементаций интерфейса Set, т.е. что их объединяет независимо от имплементации?\
**Ответ.**   
это Collection, который не может содержать повторяющиеся элементы
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html

Может ли множество содержать null элемент?\
**Ответ.**   
Null values in a Set object
As per the definition a set object does not allow duplicate values but it does allow at most one null value.

Null values in HashSet − The HashSet object allows null values but, you can add only one null element to it. Though you add more null values if you try to print its contents, it displays only one null.

Null values in LinkedHashSet: Just like the HashSet object, this also allows null values but, you can add only one null element to it. Though you add more null values if you try to print its contents, it displays only one null.

Null values in TreeSet − The TreeSet object doesn’t allows null values but, If you try to add them, a runtime exception will be generated at.
**Источник.**   
https://www.tutorialspoint.com/can-we-add-null-elements-to-a-set-in-java

Есть ли отношение следования (предыдущий, текущий, следующий элемент) в множестве?\
Если нет, то есть ли у множества итератор? \
**Ответ.**   
Отношения следования нету. Итератор есть.
**Источник.**   

Как получить элемент множества по индексу?\
**Ответ.**   
никак. Это связано с тем, что порядок элементов во множестве не определён.
**Источник.**   

Как реализован метод add() во множестве?\
**Ответ.**   

**Источник.**   

Какая группа методов увеличилась в интерфейсе Set по сравнению с интерфейсом Collection?\
Какие методы добавились?\
**Ответ.**   
 The Set interface contains only methods inherited from Collection
**Источник.**
https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html

Зависит ли множество, как структура данных, от имплементации?\
Обоснуйте ответ. \
**Ответ.**   
 В множествах Set каждый элемент хранится только в одном экземпляре, а разные реализации Set используют разный порядок хранения элементов. В HashSet порядок элементов определяется по сложному алгоритму. Если порядок хранения для вас важен, используйте контейнер TreeSet, в котором объекты хранятся отсортированными по возрастанию в порядке сравнения или LinkedHashSet с хранением элементов в порядке добавления.
**Источник.**   
http://developer.alexanderklimov.ru/android/java/set.php

Какие методы должны быть переопределены в классе, которым параметризовано множество, чтобы гарантировать правильную работу HashSet имплементации?\
**Ответ.**   
hashCode() и equals();
**Источник.**   

Какие соглашения установлены для переопределения метода hashCode()?\
**Ответ.**   
1) Если два объекта равны (т. е. метод equals() возвращает true), у них должен быть одинаковый хэш-код.
2) Если метод hashCode() вызывается несколько раз на одном и том же объекте, каждый раз он должен возвращать одно и то же число.
3) Одинаковый хэш-код может быть у двух разных объектов. 
**Источник.**   
https://training.by/#!/News/339?lang=ru

Почему недостаточно переопределить один только метод hashCode()?\
**Ответ.**   
Мы должны переопределить hashCode() в каждом классе, который переопределяет equals(). Несоблюдение этого требования приведет к нарушению общего договора для Object.hashCode(), что предотвратит правильное функционирование  класса в сочетании со всеми коллекциями на основе хешей, включая HashMap, HashSet и Hashtable.  
Если мы только переопределяем hashCode, то при вызове метода .put(first,someValue) он берет сначала, вычисляет его hashCode и сохраняет его в таблице. Затем, когда мы вызываем .put(second,someOtherValue), он должен сначала заменить второй на Map Documentation, потому что они равны (согласно бизнес-требованиям).
**Источник.** 
  https://overcoder.net/q/22728/%D0%BF%D0%BE%D1%87%D0%B5%D0%BC%D1%83-%D0%BC%D0%BD%D0%B5-%D0%BD%D1%83%D0%B6%D0%BD%D0%BE-%D0%BF%D0%B5%D1%80%D0%B5%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D1%8B-equals-%D0%B8-hashcode-%D0%B2-java

Являются ли приведенная реализация hashCode() допустимой (в смысле будут ли правильно выполняться все операции над множеством)?\
```java
@Override 
public int hashCode() {
return 22;
}
```
**Ответ.**   
нет.
**Источник.**   

Являются ли приведенная реализация hashCode() допустимой (в смысле будут ли правильно выполняться все операции над множеством HashSet<Entity>)?\
```java
class Entity {
	private int value;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
@Override
public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;
        return value == entity.value;
}
@Override
public int hashCode() {
        int result = 1;
        result = result * 31 + value;
        return result;
}
}
```
**Ответ.**   
Да.
**Источник.**   

Какие методы должны быть переопределены в классе, которым параметризовано множество, чтобы гарантировать правильную работу TreeSet имплементации?\
**Ответ.**   
equals(), hashCode(), compareTo()
**Источник.**   

В чем заключается актуальность внешнего компаратора?\
**Ответ.**   
Нет необходимости переопределять методы equals() и hashCode()
**Источник.**   

Дана следующая коллекция:\
Collection<Entity> entities = …;\
Приведите идиому, позволяющую оставить только уникальные элементы в коллекции при условии правильной реализации класса Entity. \
**Ответ.**   
Set<Entity> ent = new HashSet<>(entitis); 
**Источник.**   

Какую математическую сущность моделирует интерфейс List?\
**Ответ.**   
Последовательность
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html

Какое основное свойство всех имплементаций интерфейса List, т.е. что их объединяет независимо от имплементации?\
**Ответ.**   
Объекты находятся в последовательности, определенной программистом.
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html

Может ли имплементация интерфейса List содержать одинаковые элементы? \
Обоснуйте ответ. \
**Ответ.**   
да. Т.к. ключевое в данной коллекции не уникальность, а то, что элементы расположены один за одним
**Источник.**   

Какие группы методов увеличились в интерфейсе List по сравнению с интерфейсом Collection?\
Какие методы добавились?\
**Ответ.**   
basic  
-position access;  
get, set, add, remove, indexOf, lastIndexOf, addAll  
-search;  
-iteration;  
hasNext, next, remove;  
bulk  
-range-view  
sublist();  
array  
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html

Влияют ли изменения внесенные в последовательность, возвращаемый методом subList(), на исходную последовательность?\
**Ответ.**   
да.
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html

Дана следующая последовательность:\
List<Entity> entities = …;\
Приведите идиому, позволяющую удалить все элементы с номерами из полусегмента [fromIndex; toIndex). \
**Ответ.**   
list.subList(fromIndex, toIndex).clear();
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html

Дана следующая неупорядоченная последовательность и некоторый элемент для сравнения:\
List<Entity> entities = …;\
Entity cmpEntity = …;\
Приведите идиому для выполнения метода void doAction() класса Entity со всеми элементами последовательности entities, которые совпадают с элементом cmpEntity.\
Запрещается упорядочивать последовательность и явно проверять на равенство каждый элемент последовательности. \
**Ответ.**   
int i = list.subList(fromIndex, toIndex).indexOf(o);
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html

Какую математическую сущность моделирует интерфейс Queue?\
**Ответ.**   
Очередь
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html

Какое основное свойство всех имплементаций интерфейса Queue, т.е. что их объединяет независимо от имплементации?\
**Ответ.**   
поведение очередей, которые представляют собой список с дисциплиной "первый вошел, первый вышел" (FIFO).
**Источник.**  
 https://www.examclouds.com/ru/java/java-core-russian/interface-queue

Какие группы методов увеличились в интерфейсе Queue по сравнению с интерфейсом Collection?\
Какие методы добавились?\
**Ответ.**   
basic
offer(), poll(), peek(), element();
**Источник.** 
  https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html

Какую математическую сущность моделирует интерфейс Deque?\
**Ответ.**   
Очередь
**Источник.** 
  https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html

Какое основное свойство всех имплементаций интерфейса Deque, т.е. что их объединяет независимо от имплементации?\
**Ответ.**   
поведение очередей, которые представляют собой список с дисциплиной "двусторонняя очередь".
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html

Какие методы определяет Deque в добавок к методам унаследованным от Queue?\
**Ответ.**   
![image](https://user-images.githubusercontent.com/79933495/164761618-3f8fb520-c714-4834-b2d2-71c0b75b6a2c.png)  
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html  

Верно ли утверждение, что Queue всегда обрабатывает элемента в порядке FIFO?\
**Ответ.**   
нет.  
Note that the Deque interface can be used both as last-in-first-out stacks and first-in-first-out queues. The methods given in the Deque interface are divided into three parts:
**Источник.**  
https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html 

Какой элемент независимо от упорядочения Queue будет удален методами remove и poll?\
**Ответ.**   
удалят верхний элемент очереди (первый элемент) "голову".
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html

Зачем в интерфейсе Queue метод poll, когда есть remove?\
**Ответ.**   
Если операция по удалению методом remove() пройдет неудачно, то будет выброшено исклюение, метод poll() при "провале" операции, возвращает специальное значени (null или false, в зависимости от операции).
**Источник.**   
https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html

Какую математическую сущность моделирует интерфейс Map?\
**Ответ.**   
**Источник.**   

Какое основное свойство всех имплементаций интерфейса Map, т.е. что их объединяет независимо от имплементации?\
**Ответ.**   
**Источник.**   

Реализует ли Map интерфейс Collection?\
**Ответ.**   
**Источник.**   

Какую структуру данных представляет собой совокупность \
•	ключей; \
•	значений;\
•	пар ключ-значение\
любой имплементации Map?\
**Ответ.**   
**Источник.**   

Какие группы операций определены в интерфейсе Map?\
**Ответ.**   
**Источник.**   

Какой интерфейс представляет мультикарту (multimap) в Collections Framework?\
**Ответ.**   
**Источник.**   

Дана карта:\
Map<K, V> map = …;\
Приведите идиому для выполнения метода void doAction(K key, V value) со всеми элементами карты.\
**Ответ.**   
**Источник.**   

Дана карта:\
Map<K, V> map = …;\
в которой нет элементов со значением null.\
Приведите идиому для выполнения метода void doAction(V value) с элементом map, заданным ключом K key.\
**Ответ.**   
**Источник.**   

Дана карта:\
Map<K, V> map = …;\
в которой есть элементы со значением null.\
Приведите идиому для выполнения метода void doAction(V value) с элементом map, заданным ключом K key.\
**Ответ.**   
**Источник.**   

Можно ли отрефакторить следующий код? \
Если да, то сделайте это.\
```java
       Purchase purchase = new Purchase("meat", new Byn(100), 10);
       for (Map.Entry<Purchase, WeekDay> entry: purchaseWeekDayMap.entrySet()) {
            if (entry.getKey().equals(purchase)) {
                System.out.println(entry.getKey());
                break;
            }
        }
```
**Ответ.**   
**Источник.**   

Что возвращает метод put интерфейса Map?\
**Ответ.**   
**Источник.**   

Почему интерфейс Map не расширяет интерфейс Collection в Java Collections Framework?\
**Ответ.**   
**Источник.**   

Дайте определение понятию имплементация (Implementation) в контексте Collections Framework.\
**Ответ.**   
**Источник.**   

Какие виды имплементаций можно выделить?\
**Ответ.**   
**Источник.**   

На что влияет выбор имплементации?\
**Ответ.**   
**Источник.**   

Идиома создания пустой коллекции имеет следующий вид: \
SomeInterface<Entity> entities = new SuitableImplementation<>();\
**Ответ.**   
**Источник.**   

Почему в левой части идиомы используется ссылка на интерфейс, а не на имплементацию?\
**Ответ.**   
**Источник.**   

Укажите наиболее часто используемые имплементации для интерфейсов Collections Framework, а также структуру данных, которая поддерживается данной имплементацией. \
Результат представьте в виде таблицы:\
Interface	Implementation	Abstract Data Type\
-----------------------------------------------------------------------\
**Ответ.**   
**Источник.**   

Приведите идиому создания очереди. \
Xxx<Integer> queue = ...;\
Xxx - это подходящий интерфейс.\
Добавьте 3 элемента и удалите 1, выведя содержимое на консоль. \
**Ответ.**   
**Источник.**   

Приведите идиому создания стека. \
Xxx<Integer> stack = ...;\
Xxx - это подходящий интерфейс.\
Добавьте 3 элемента и удалите 1, выведя содержимое на консоль. \
**Ответ.**   
**Источник.**   

Когда целесообразно использовать реализацию TreeSet вместо HashSet?\
**Ответ.**   
**Источник.**   

Опишите неупорядоченные реализации Map.\
**Ответ.**   
**Источник.**   

Опишите упорядоченные реализации Map.\
**Ответ.**   
**Источник.**   

Чем отличается ArrayList и LinkedList?\
**Ответ.**   
**Источник.**   

Что такое вычислительная сложность операции (алгоритма)?\
**Ответ.**   
**Источник.**   

Укажите вычислительную сложность для операций получения элемента по индексу, поиска, вставки и удаления, для основных коллекций.\
**Ответ.**   
**Источник.**   
 
В чем разница между интерфейсами Comparable и Comparator?\
**Ответ.**   
**Источник.**   

В чем разница между Iterator и ListIterator?\
**Ответ.**   
**Источник.**   

Почему в классе Iterator нет метода для получения следующего элемента без передвижения курсора?\
**Ответ.**   
**Источник.**   

Назовите высокопроизводительные реализации Set для перечислимых типов (enum)?\
**Ответ.**   
**Источник.**   

Как происходит удаление элементов из ArrayList? Как меняется в этом случае размер ArrayList?\
**Ответ.**   
**Источник.**   

Можно ли использовать массив в качестве ключа для HashMap? \
Если да, то какие есть особенности.\
**Ответ.**   
**Источник.**   

Где определены полиморфные алгоритмы для работы с коллекциями? Опишите основные группы.\
**Ответ.**   
**Источник.**   

В чем заключается назначение метода \
Collections.unmodifiableCollection(Collection<? extends T> c)?\
**Ответ.**   
**Источник.**   

Перечислите различия между массивами и коллекциями?\
**Ответ.**   
**Источник.**   

Массивы и коллекции являются ковариантными или инвариантными?\
Поясните ответ. \
**Ответ.**   
**Источник.**   

Дано:
SortedSet<Entity> set = ...;\
Найдите в jdk 
1.	тип 1, для которого SortedSet<Entity> является подтипом. \
2.	подтип 2 для SortedSet<Entity>.\
Создайте множество set1 типа 1 и множество set2 подтипа 2. Проверьте правильность, сделав присваивания:\
set1 = set;\
set = set2;\
**Ответ.**   
**Источник.**   

Массивы и коллекции являются reified (овеществленные) или non-reified типами?\
Поясните ответ. \
**Ответ.**   
**Источник.**   

