# Three Project Euler solutions
This repo contains solutions to three Project Euler problems.
https://projecteuler.net/ 

Solutions are provided with Java language (JDK 1.8 or greater).

### Problem #001 - Sum square difference
https://projecteuler.net/problem=6

Two solutions are provided:
1. Simple brute force loop
   (1 + 2 + ... + N)^2 - (1^2 + 2^2 + ... N^2)
2. Mathematical solution
   ((N * (N+1))/2)^2  - (N*(N+1)*(2*N+1))/6


    > java SumSquareDifference.java
    Simple brute force loop: 2501166841675000 took 10 ms
    Mathematical solution: 2501166841675000  took 0 ms

### Problem #002 - 10001st prime 
https://projecteuler.net/problem=7

A brute force solution is provided:
   dividing every number by a number from 2 till sqrt(N)

    > java Prime10001st.java
    Brute force solution: 104743 took 20 ms

### Problem #003 - Digit factorial chains
https://projecteuler.net/problem=74

A brute force solution with caching is provided

    > java DigitFactorialChains.java
    Result: 402  took 211 ms

