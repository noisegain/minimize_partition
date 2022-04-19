# Minimize Partition

_group partition by minimizing sum diff_

partition array by groups of k elements and trying to minimize diff of max and min sums of elements in groups

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
