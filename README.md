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