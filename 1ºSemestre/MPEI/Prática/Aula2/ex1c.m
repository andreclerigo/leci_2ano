N = 1e5;
n = 2;

a = rand(n, N) > 0.5

%1c
a1 = sum(a) == 2; % familias com 2 rapazes
a2 = sum(a) == 1; % familias com 1 rapaz
prob1c = sum(a1 & a2) / sum(a2)

%1d
a1 = sum(a) == 2
a2 = a(1, :)  % primeira linha de 'a' que corresponde ao primeiro filho das familias
prob1d = sum(a1 & a2)/sum(a2)