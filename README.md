# Minimize Partition

_group partition by minimizing sum diff_

partition array by groups of k elements and trying to minimize diff of max and min sums of elements in groups


### Requirements
* kotlin compiler 1.6+
* JRE 17+

### How to run it?
1. compile with ```kotlinc .```
2. run with ```kotlin MainKt <args>```

### Args
* ```-i <file_name>``` input file name
* ```-o <file_name>``` output file name
* ```-c <number>``` number of algorithm iterations
* ```-a <number>``` number of attempts to calculate
* ```-p``` flag for parallel computing

### Defaults
* ```-i = stdin```
* ```-o = stdout```
* ```-c = 100000```
* ```-a = 50```
* ```-p = off```

### Input
```<integer> <double...>```
* Fist number - count of elements in group
* Others - values
* Separator - any whitespaces

### Example
__in.txt__
```
7
1,16 1,39 47 37 29 34 31 34 42 38 61 39 63 55 53 62 30 68 45 68 26 42 40 41 77 51 27 32
```
__out.txt__
```
0.839999999999975
([39.0, 37.0, 32.0, 55.0, 61.0, 41.0, 29.0], 294.0)
([68.0, 38.0, 30.0, 26.0, 53.0, 77.0, 1.16], 293.16)
([42.0, 68.0, 27.0, 1.39, 51.0, 62.0, 42.0], 293.39)
([31.0, 45.0, 34.0, 47.0, 34.0, 40.0, 63.0], 294.0)
```
