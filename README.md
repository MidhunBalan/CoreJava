# CoreJava


### Table of Contents

| No. | Topic  |
| --- | ------ |
|>|Java 8 Features|
| 1   | [Java Util Streams: Introduction]() |
| 2   | [Methods of Stream: filter and map]() |
| 3   | [Difference between filter and map]()|
| 4   | [Various methods of Streams]() |
| 4   | [Date and Time API(Joda-time API)]() |

## Java Util Streams: Introduction

There are two types of streams are available in Java. One is from java.ip package and another one is from java.util package. The java.util stream came from 1.8 version. But the java.io streams are available from the legacy version itself. 

Here we will look into the java.util stream which came from 1.8 version. 

`java.io streams` - related to files and 
`java.util streams` - related to collections

What is the difference between collection and Streams?

| Collections | Streams  |
| --- | -------------------- |
| If you want to represent a group of individual objects as a single entity,  then we can go for collections| If you want to process objects from the collections, then we can go for streams concept. |

### Methods of Streams

1. filter method
2. map method

#### filter method
Example: 
We have an array list with few values. The problem is to find the even number from the list. 

```  
ArrayList<Integer> list = new ArrayList<>();
list.add(0);
list.add(10);
list.add(20);
list.add(5);
list.add(15);
list.add(25);
System.out.println(list); 
```

Output: 
It will print the values in insertion order. 
```
[0, 10, 20, 5, 15, 25] 
```

So we used to solve this problem like this before 1.8 version of streams. 

```
List<Integer> list1 = new ArrayList<>();
for(Integer value: list){
    if(value % 2 == 0){
        list1.add(value);
    }
}
System.out.println("Even number from the list without streams"+list1);
```

Output:
```
Even number from the list without streams[0, 10, 20]
```

Using stream filter method

```
List<Integer> list2 = list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
System.out.println("Even number from the list with streams"+list2);
```
Output:
```
Even number from the list with streams[0, 10, 20]
```

#### map method

Example:
We have an array list with few values. The problem is to double(multiply by 2) every element and print.

```  
ArrayList<Integer> list = new ArrayList<>();
list.add(0);
list.add(10);
list.add(20);
list.add(5);
list.add(15);
list.add(25);
```

So we used to solve this problem like this before 1.8 version of streams. 

```
        List<Integer> list1= new ArrayList<>();
        for(Integer value: list){
            list1.add(value* 2);
        }
        System.out.println("Output without stream map method"+list1);
```
Output:

```
Output without stream map method[0, 20, 40, 10, 30, 50]
```

Solution with map method

```
 List<Integer> list2 = list.stream().map(value -> value*2).collect(Collectors.toList());
        System.out.println("Output with stream map method"+list2);
```
Output:
```
Output with stream map method[0, 20, 40, 10, 30, 50]
```

### How to create a stream object

On any collection object, you have to call the stream method. For example:

```
Stream s = c.stream();
```

Explanation on the above one:
`Stream` - It is an interface present in java.util.stream package
`c` - In the above example, `c` can be any collection object. 
`stream()` - This method present inside the collection interface as default method.

### When you are using stream, There are two parts available. 

1. Configuration 
2. Processing

#### 1. Configuration contains two parts

- Filter mechanism
- Map mechanism

#### Filtering 

- If we want to filter elements from the collection based on some boolean conditions, then we should go for filtering. 
- We can configure filter by using filter() method of Stream interface. 

```
public Stream filter(Predicate<T> t)
```
Note: `Predicate<T> t can be boolean valued function or lambda expression`

Example: `Stream s1 = c.stream().filter(value -> value%2 == 0);`

#### Mapping

- If we want to create separate new object for every object present in the collection based on some function, then we should go for mapping mechanism.
- We can implement mapping by using map() method of Stream interface.

```
public Stream map(Function<T, R> f)
```

example:
```
Stream s1 = c.stream.map(value -> value*2);
```

### Difference between filter and map

| filter method| map method |
|-------| ----|
|If we want to filter elements from the collection based on some boolean conditions, then we should go for filtering.| If we want to create separate new object for every object present in the collection based on some function, then we should go for mapping mechanism.|


#### 2. Processing 

#### 2.1 Processing by collect method

This method collects the elements from the stream and adding to the specified collection. 

Consider we have a list(ArrayList<String> list) with string 
```
ArrayList<String> list= new ArrayList();
list.add("MidhunBalan");
list.add("Sree");
list.add("Nithin");

List<String> list1 = list.stream().filter(stringVal -> stringVal.length >= 9).collect(Collectors.toList());

```

```
List<String> list2 = list.stream().map(stringVal -> stringVal.toUpperCase()).collect(Collectors.toList());
```

#### 2.2 Processing by count method

The count method returns the number of elements present in the stream. 
```
public long count()
```

for example:
```
long count = list.stream.filter(s->s.length()> 9 ).count();
System.out.println("number of elements present in the list which length > 9 is"+count);
```

#### 2.3 Processing by sorted method

- we can use sorted() method to sort elements inside stream. 
- we can sort either based on default natural sorting order or based on our own customized sorting order specified by comparator object.

`sorted() : for default natural order`
`sorted(Comparator c) : For customized sorting order`


For example: natural sorting

```
 ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

List<Integer> list1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("List according to the default natural sorting"+list1);
```

Output:
`List according to the default natural sorting[0, 5, 10, 15, 20, 25]`

For example : customized sorting

```
 ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        List<Integer> list1 = list.stream().sorted((value1, value2)->value2.compareTo(value1)).collect(Collectors.toList());
        System.out.println("List according to the customized sorting"+list1);
```

Output:
`List according to the customized sorting[25, 20, 15, 10, 5, 0]`

Note : 
value1.compareTo(value2) means natural sorting
or
-value1.compareTo(value2) means reverse order
or
value2.compareTo(value1) means reverse order

#### 2.4 Processing by min() and max() method

##### 2.4.1 min(Comparator c)
Returns minimum value according to specified Comparator.

##### 2.4.2 max(Comparator c)
Returns maximum value according to specified comparator. 

Examples
2.4.1: min(Comparator c)
```
 ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        Integer min = list.stream().min((value1, value2)-> value1.compareTo(value2)).get();
        System.out.println("Minimum value"+min);
```
Output :
`Minimum value 0`

2.4.1: max(Comparator c)

``` 
 ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);
         Integer max = list.stream().max((value1, value2)-> value1.compareTo(value2)).get();
        System.out.println("Maximum value "+max);
```

Output :
`Maximum value 25`

#### 2.5 Processing by  using forEach() method

- This method won't return anything
- This method can take Lambda expression as argument and apply that lambda expression for each element present in stream. 

For example:

``` 
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("BB");
        list.add("CCC");

        list.stream().forEach(value-> System.out.println(value));
```

Output:
``` 
A
BB
CCC
```

Note: where ever lambda expression is there, we can replace it with method reference.

For example:
``` 
 list.stream().forEach(System.out::println);
```
Output:
``` 
A
BB
CCC
```

#### 2.6 Processing by  using toArray() method

- we can use toArray() methods to copy elements present in the Stream into specified array. 

Example:

``` 
 ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        Integer[] array2 = list.stream().toArray(value -> new Integer[value]);
        System.out.println(Arrays.toString(array2));
        
        Integer[] array = list.stream().toArray(Integer[] :: new);
        System.out.println(Arrays.toString(array));
```

Output:

``` 
[0, 10, 20, 5, 15, 25]
[0, 10, 20, 5, 15, 25]
```

#### 2.7 Processing by using Stream.of() method 

- we can also apply stream for group of values and for arrays.

7.1 for group of values:

example: 
``` 
 Stream<Integer> s = Stream.of(9, 99, 999, 9999, 99999);
        s.forEach(System.out::println);  // or s.forEach(value-> System.out.println(value));
```

Output:
``` 
9
99
999
9999
99999
```

7.1 for arrays

example:
``` 
Double[] doubleArray = {100.00, 101.00, 102.00, 103.00, 104.00};
Stream<Double> s1 = Stream.of(doubleArray);
s1.forEach(System.out::println);// or s1.forEach(value-> System.out.println(value));
```


Output:

``` 
100.0
101.0
102.0
103.0
104.0

```

## Date and Time API(Joda-time API)

Until 1.7,  these are all the classes available for the date and time. 
- Date
- Calendar
- Timestamp etc...

But these are not recommendable to use and most of the methods are deprecated. Bcz it is not recommended to use in terms of performance. 
New API came in the 1.8 version. That is Date and Time API, also known as Joda-Time API(developed by joda.org).

1. LocalDate
2. LocalTime
3. LocalDateTime


Note: The above available from java.time package

To find Local date:
``` 
LocalDate date = LocalDate.now();
System.out.println(date);
```
`2022-11-01`

To find local time
``` 
LocalTime time = LocalTime.now();
System.out.println(time);
```
`12:09:55.253`


Question: How to get year, date and month from LocalDate

``` 
 LocalDate date = LocalDate.now();
        System.out.println(date);

        int dd= date.getDayOfMonth();
        int mm= date.getMonthValue();
        int yyyy = date.getYear();

        System.out.println(dd+"/"+mm+"/"+yyyy);
        System.out.printf("%d-%d-%d",dd,mm, yyyy);
        
```
Output :
``` 
2022-11-01
1/11/2022
1-11-2022
```

Question: How to get hour, minute, second and nano from LocalTime

``` 
 LocalTime time = LocalTime.now();
        int h= time.getHour();
        int m= time.getMinute();
        int s= time.getSecond();
        int n= time.getNano();
        System.out.printf("%d:%d:%d:%d", h, m, s, n);
```

Output:
`12:20:1:638000000`

To handle both date and time in a single class, we can go with LocalDateTime class. 

Example:
```
 LocalDateTime dateTime= LocalDateTime.now();
        System.out.println(dateTime);

        int dd = dateTime.getDayOfMonth();
        int mm = dateTime.getMonthValue();
        int yyyy = dateTime.getYear();
        System.out.printf("%d-%d-%d",dd,mm, yyyy);

        int h = dateTime.getHour();
        int m = dateTime.getMinute();
        int s = dateTime.getSecond();
        int n= dateTime.getNano();
        System.out.printf("\n%d-%d-%d-%d",h,m,s,n);
```

Output:
``` 
2022-11-01T12:37:25.478
1-11-2022
12-37-25-478000000
```

##### LocalDatetime.of

- To go for a particular time, then we can go for LocalDateTime.of 

Example :

``` 
LocalDateTime dt = LocalDateTime.of(1995, Month.MAY, 28, 12, 45);
        System.out.println("\n"+dt);
```
Output: 
`1995-05-28T12:45`

To find after 6 months

`dt.plusMonths(6)`

To find before 6 months

`dt.minusMonths(6)`


##### Period

To find period between two date range, we can go for this.

``` 
LocalDate birthday= LocalDate.of(1992, 8, 4);
        LocalDate today= LocalDate.now();
        Period period= Period.between(birthday, today);
        System.out.println(period.getYears()+"-"+ period.getMonths()+"-"+ period.getDays());
```

Output:
`30-2-29`

##### Year Class

Example :

``` 
public static void main(String[] args) {
        int y = 1996;
        Year year = Year.of(y);
        if(year.isLeap()){
            System.out.println("It is a leap year");
        }else{
            System.out.println("It is not a leap year");
        }
    }
```

Output:
`It is a leap year`

##### ZoneId 

Example:
``` 
 ZoneId zone= ZoneId.systemDefault();
        System.out.println(zone);
```
Output:
`Asia/Kolkata`

#### ZonedDateTime class

Example: 
``` 
ZoneId zI = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zt = ZonedDateTime.now(zI);
        System.out.println(zt);

```

Output:
`2022-11-01T18:26:36.198-07:00[America/Los_Angeles]`
