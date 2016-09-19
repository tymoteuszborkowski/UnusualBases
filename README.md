# UnusualBases
reddit short exercise

Binary numbers (base 2) are written using 1s and 0s to represent which powers of 2 sum together to create the decimal number.

16	8	4	2	1
1	0	0	1	1

A 1 represents using that power of 2 and a 0 means not using it. In the above example there is a one in the 16s, 2s and the 1s so we do:
10011 = 16 + 2 + 1 = 19
meaning that 10011 is binary for 19
The Fibonacci Sequence has a similar property that any positive integer can be written in the form of Fibonacci numbers (with no repeats). For example:
25 = 21 + 3 + 1
If we use the same form as for writing binary, with the Fibonacci sequence instead of powers of 2, we can represent which Fibonacci numbers we use with a 1, and the ones we don't with a 0.
13	8	5	3	2	1	1
1	0	1	0	0	1	0
1010010 = 13 + 5 + 1 = 19
meaning that 101001 is 'Base Fib' for 19
The task is to create a converter to convert to and from decimal to 'Base Fib' Due to the nature of the Fibonacci Sequence, many numbers have multiple representations in 'Base Fib', for the moment these are to be ignored - any form is acceptable.
Input description

You will be given a line of input for each conversion, stating the base it is currently in, and the number to convert seperated by space
10 16
10 32
10 9024720
F 10
F 1
F 111111
F 100000
F 10110110100111001
Output description

The program should output the converted number, in it's expected base, e.g.
1001000
10101000
1010100101010100000010001000010010
1
1
20
8
