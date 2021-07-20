clear all
p = 0.3;
k = 2;
n = 5;
N = 10e5;

lancamentos = rand(5, N) > p;
sucessos= sum(lancamentos)>= k;
prob= sum(sucessos)/N;

probSimulacao = sum(sum(rand(5, N) > p) >= k)/N