clear all

p = 0.5;
f = 2;
rapazes = 1;
N = 1e5;

filhos = rand(f, N) > p;
sucessos = sum(filhos) >= rapazes;
prob = sum(sucessos)/N

