# CoreJava


### Table of Contents

| No. | Topic  |
| --- | -------------------- |
| 1   | [Java Util Streams: Introduction]() |
| 2   | [Methods of Stream: filter and map]() |
| 3   | [Difference between filter and map]()|
| 4   | [Various methods of Streams]() |

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


For example:

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
