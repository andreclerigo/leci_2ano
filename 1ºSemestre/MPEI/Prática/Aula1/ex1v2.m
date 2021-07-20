clear all
%% Codigo 1 - segunda versa˜o
N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de cara
k = 2; %nu´mero de caras
n = 3; %nu´mero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao= sum(sucessos)/N