clear all
N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de cara
k = 6; %nu´mero de caras
n = 15; %nu´mero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos = sum(lancamentos)== k;
probSimulacao= sum(sucessos)/N