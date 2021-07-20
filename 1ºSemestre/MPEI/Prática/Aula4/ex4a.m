clear all;
N = 1e6;

%%%%%%%%a) i)
partes = rand(5,N) < 0.3;
num = sum(partes); %numero de pecas defeituosas
X = 0:5;
fX = zeros(1,6);

for i = X
    fX(i+1) = sum(num==i) / N;
end

stem(X, fX)
axis([-1 6 0 0.4])
grid on

%%%%%%%a)ii)
Px = cumsum(fX)
stairs([-1 X], [0 Px])
axis([-1 6 0 1.1])

%%%%%%%% a) iii)
% Penso que seja a definicao da soma cumulativa de 2

aux = cumsum(fX);
Pmax2 = aux(3)

