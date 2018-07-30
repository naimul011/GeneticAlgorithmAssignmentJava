#Genetic Algorithm

1 Problem Statement
You will have a 8 × 8 chessboard. You will be given 5 pieces of Queens and 3 pieces of Rooks.You
have to place them in such a way that those pieces do not attack each other. Two things for sure:
neither you can put any two of them in same column nor in same row.

2 Moves
2.1 Queen
The queen can be moved any number of unoccupied squares in a straight line vertically, horizon-
tally, or diagonally, thus combining the moves of the rook and bishop (see Figure 1). The queen
captures by occupying the square on which an enemy piece sits.

2.2 Solution strings
As per the codes shown in reading materials, you can think of a solution string as string consisting
of 1-8, 5 q’s and 3 r’s. So it will be a 16 character string. From a permutation of this string,
extract the digits 1-8 and characters (r and q’s) separately. Then the first character and the first
digit will denote the first piece in first row, and so on. Say , a string is "56qrq124qq7r8rq3". So,
the digits extracted in order are "56124783" and characters extracted in order are "qrqqqrrq". it
means, the placement of pieces in different rows are - (row 1, column 5 , queen), (row 2, column
6 , rook), (row 3, column 1 , queen), (row 4, column 2 , queen), (row 5, column 4 , queen), (row
5, column 7 , rook), (row 6, column 8 , rook), (row 8, column 4 , queen).

2.3 fitness
How good a combination string is.

How to apply it in this problem

You can find the number of attacking pairs as the "unfit"-ness function. There are 8 C2 = 28
possible pairs. The ideal placement has no attacking pair in it. So you can calculate fitness
function as(28−number of attacking pairs). You can design your own fitness function too. But
remember, the ideal placement will always have the highest fitness and the more ideal a placement
is near to, the more fitness it will have. For example,if there are two attacking pairs, then fitness
will be 28 −2 = 26.

3 Genetic Algorithm

A genetic algorithm is a search heuristic that is inspired by Charles Darwin’s theory of natural evolution. This algorithm reflects the process of natural selection where the fittest individuals are selected for reproduction in order to produce offspring of the next generation.


3.1 Notion of Natural Selection
The process of natural selection starts with the selection of fittest individuals from a population. They produce offspring which inherit the characteristics of the parents and will be added to the next generation. If parents have better fitness, their offspring will be better than parents and have a better chance at surviving. This process keeps on iterating and at the end, a generation with the fittest individuals will be found.

This notion can be applied for a search problem. We consider a set of solutions for a problem and select the set of best ones out of them.

3.2 Five phases are considered in a genetic algorithm.

Initial population
Fitness function
Selection
Crossover
Mutation
3.2.1 Initial Population
The process begins with a set of individuals which is called a Population. Each individual is a solution to the problem you want to solve.

An individual is characterized by a set of parameters (variables) known as Genes. Genes are joined into a string to form a Chromosome (solution).

In a genetic algorithm, the set of genes of an individual is represented using a string, in terms of an alphabet. Usually, binary values are used (string of 1s and 0s). We say that we encode the genes in a chromosome.

3.2.2 Fitness Function
The fitness function determines how fit an individual is (the ability of an individual to compete with other individuals). It gives a fitness score to each individual. The probability that an individual will be selected for reproduction is based on its fitness score.

3.2.3 Selection
The idea of selection phase is to select the fittest individuals and let them pass their genes to the next generation.

Two pairs of individuals (parents) are selected based on their fitness scores. Individuals with high fitness have more chance to be selected for reproduction.

3.2.3 Crossover
Crossover is the most significant phase in a genetic algorithm. For each pair of parents to be mated, a crossover point is chosen at random from within the genes.

For example, consider the crossover point to be 3 as shown below.


Crossover point
Offspring are created by exchanging the genes of parents among themselves until the crossover point is reached.


Exchanging genes among parents
The new offspring are added to the population.


New offspring
3.2.4 Mutation
In certain new offspring formed, some of their genes can be subjected to a mutation with a low random probability. This implies that some of the bits in the bit string can be flipped.


Mutation: Before and After
Mutation occurs to maintain diversity within the population and prevent premature convergence.

3.3 Termination
The algorithm terminates if the population has converged (does not produce offspring which are significantly different from the previous generation). Then it is said that the genetic algorithm has provided a set of solutions to our problem.

Comments
The population has a fixed size. As new generations are formed, individuals with least fitness die, providing space for new offspring.

The sequence of phases is repeated to produce individuals in each new generation which are better than the previous generation.

3.4 Psuedocode
START
Generate the initial population
Compute fitness
REPEAT
    Selection
    Crossover
    Mutation
    Compute fitness
UNTIL population has converged
STOP
