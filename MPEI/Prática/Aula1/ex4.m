clear all
p = 0.5; %probabilidade
l = 3 ; %numero de lancamentos
c = 2; %numero de caras pretendidas
N = 1e5; %numero de experiencias a realizar

probSimulacao= sum(sum(rand(l, N)>p)==c)/N