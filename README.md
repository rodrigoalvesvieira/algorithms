## Algorithms & Data Structures

Implementations of data structures, sorting and search algorithms in vanilla Java for the
Algorithms and Data Structures (IF672) discipline at CIn/UFPE

| Data Structure                                                | Status           |
| ------------------------------------------------------------- |:----------------:|
| Singly Linked List                                            | Implemented      |
| Doubly Linked List                                            | Implemented      |
| Dynamic Array                                                 | Implemented      |
| Queue                                                         | Implemented      |
| Stack                                                         | Implemented      |
| Min Heap (binary)                                             | Implemented      |
| Max Heap (binary)                                             | Implemented      |
| Binary Search Tree                                            | Implemented      |
| Adelson-Velskii and Landis' (AVL) Tree                        | Implemented      |
| Disjoint Set (union-find)                                     | Implemented      |
| Hash Table                                                    | Implemented      |
| Bloom Filter                                                  | Implemented      |
| Segment Tree                                                  | Implemented      |
| Fenwick Tree (BIT)                                            | Pending          |
| Suffix Array                                                  | Pending          |
| Suffix Tree                                                   | Pending          |

## Sorting

| Algorithm                | Stability          | Status           | Remarks                                |
| ------------------------ |:------------------ | ----------------:| :-------------------------------------:|
| Insertion sort           | Stable             | Implemented      | Use for small N or partially ordered   |
| Bubble sort              | Stable             | Implemented      |                                        |
| Selection sort           | Not stable         | Implemented      | N exchanges                            |
| Shellsort                | Not stable         | Implemented      |                                        |
| Quicksort                | Not stable         | Implemented      | Fastest in practice. Mostly N log N    |
| Mergesort                | Stable             | Implemented      | N log N guarantee. Big constant factor |
| Heapsort (w/ Min Heap)   | Not stable         | Implemented      |                                        |

## Searching

| Algorithm                            | Status           |
| ------------------------------------ |:----------------:|
| Binary Search                        | Implemented      |

## Graph

| Algorithm                           | Status           |
| ----------------------------------- |:----------------:|
| Breadth-First Search                | Implemented      |
| Depth-First Search                  | Pending          |
| Dijkstra's algorithm                | Pending          |
| Kruskal MSP                         | Pending          |
| Prim MSP                            | Pending          |
| Bellman–Ford algorithm              | Pending          |
| Floyd–Warshall algorithm            | Pending          |
| Knuth–Morris–Pratt algorithm        | Pending          |

## Other Important Algorithms


| Algorithm                                     | Status           |
| ----------------------------------------------|:----------------:|
| Infix Expressions Evaluator                   | Pending          |
| Convex Hull (Graham scan)                     | Pending          |
| Strassen algorithm for Matrix multiplication  | Pending          |

## Compiling

For compiling directly via command-line (No Eclipse or other IDE), do:

```
$ cd src/shared`

$ javac -sourcepath .. Rodrigosort.java`

$ java -cp .. Rodrigosort.Program
```

## Timing Programs

If you're running from the command-line just do:

`$ time java Program`

If you're running Java within an IDE or something like that, just do:

```java

final long startTime = System.currentTimeMillis();
// your awesome code comes here...
final long endTime = System.currentTimeMillis();

System.out.println("Total execution time: " + (endTime - startTime));
```

Within your `main` method.

## Algorithms

* Algorithms Implementations at Princeton University http://algs4.cs.princeton.edu/code/
* Algorithms at Princeton University http://algs4.cs.princeton.edu/home/
* IME/USP Análise de Algoritmos http://www.ime.usp.br/~pf/analise_de_algoritmos/index.html
* Algoritmos para Grafos http://www.ime.usp.br/~pf/algoritmos_para_grafos/index.html
* Algorithms Course Materials http://compgeom.cs.uiuc.edu/~jeffe/teaching/algorithms/
* Big-O cheat sheet http://bigocheatsheet.com/
* Computer Science animated http://www.csanimated.com
* AlgoList http://www.algolist.net/
* GeeksForGeeks http://www.geeksforgeeks.org/

## Visualizations

* Data Structure Visualizations http://www.cs.usfca.edu/~galles/visualization/Algorithms.html
* Visualizations by Steven Halim http://www.comp.nus.edu.sg/~stevenha/visualization/
* Sorting Algorithms http://www.sorting-algorithms.com/
* Algomations http://www.algomation.com/

## Books

* Introduction to Algorithms, 3rd edition. CORMEN, Thomas H. MIT Press and McGraw-Hill
* Competitive Programming 3. HALIM, Steven. lulu

## Competitive Programming

I am very interested in solving problems from Programming Contests, specially the ones found on the [UVa] website. If you're interested in my solutions to some of their problems, check out this [repo] of mine.

## Acknowledgements

Thanks to,

* Professor Paulo G.S da Fonseca
* Professor Katia S. Guimarães. Ph.D

Without these people, instead of little, I would know nothing about Algorithms. Also, thanks to the whole Internet, for all the infinite amount of knowledge on the field provided for free.

## Copyright

© 2013-2017 Rodrigo Alves

[UVa]: http://uva.onlinejudge.org/
[repo]: https://github.com/rodrigoalvesvieira/UVa
