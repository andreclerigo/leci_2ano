clear all

% p = 0.5;
% k = 1;
% n = 5;
% prob= nchoosek(n,k)*p^k*(1-p)^(n-k) % nchoosek(n,k)= n!/(n-k)!/k!

p = 0.5; %probabilidade
l = 5 ; %numero de perguntas
c = 5; %numero de perguntas certas
N = 1e5; %numero de experiencias a realizar

probSimulacao= sum(sum(rand(l, N)>p)==c)/N