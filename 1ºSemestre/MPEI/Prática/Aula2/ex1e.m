clear all

n = 5;
N = 1e5;

a = rand(n, N) > 0.5;

a1 = sum(a) >= 1; %pelo menos 1 dos filhos é rapaz
a2 = sum(a) == 2; % ter 2 rapazes apenas

prob = sum(a2 & a1) / sum(a1)