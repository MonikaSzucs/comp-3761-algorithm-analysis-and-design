# Notes

`Algorithm`: is a sequence of unambiguous instructions for solving a problem, i.e., for obtaining a required output for any legitimate input in a finite amount of time.

- The nonambiguity requirement for each step of an algorithm cannot be compromised.
- The range of inputs for which an algorithm works has to be specified carefully.
- The same algorithm can be represented in several different ways.
- There may exist several algorithms for solving the same problem.
- Algorithms for the same problem can be based on very different ideas and
can solve the problem with dramatically different speeds.

`Euclid’s algorithm` is based on applying repeatedly the equality
gcd(m, n) = gcd(n, m mod n),

 let us introduce a simple algorithm for generating consecutive primes not
exceeding any given integer n > 1. It was probably invented in ancient Greece
and is known as the `sieve of Eratosthenes`

Obviously, p . p should not be greater than n, and therefore p cannot exceed
√n rounded down (denoted √n

using the so-called `floor function`)
