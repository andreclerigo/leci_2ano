clear all
%% Codigo 2- calculo analıtico de probabilidade em series experiencias de Bernoulli
% Dados relativos ao problema 1
p = 0.5;
k = 6;
n = 15;
prob= nchoosek(n,k)*p^k*(1-p)^(n-k) % nchoosek(n,k)= n!/(n-k)!/k!