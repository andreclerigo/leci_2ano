clear all;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%a
N = 1e5;

experiencias = rand(4,N) <= 0.5;
num = sum(experiencias);
num

X = 0:4;
fX = zeros(1,5);

for i = X
    fX(i+1) = sum(num==i)/N;
end

stem(X, fX)
axis([-1 5 0 0.4])
grid on

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%b
media = sum(fX.*X)
variancia = sum(fX.*(X.^2)) - media^2
desvioPadrao = sqrt(variancia)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%c
X = 0:4;
fX = zeros(1,5);

for i = X
    fX(i+1) = nchoosek(4,i)*0.5^(4-i)*0.5^(i);
    %fX(i+1) = nchoosek(4,i)*0.5^4;
end

figure(2)
stem(X, fX)
axis([-1 5 0 0.4])
grid on


%%%%%%%%%%%%%%%%%%%%f
media = sum(fX.*X)
variancia = sum(fX.*(X.^2)) - media^2

fprintf('Probabilidade de obter pelo menos 2 coroaas = %f\n', sum(fX(3:5)));
fprintf('Probabilidade de obter pelo ate 1 coroa = %f\n', sum(fX(1:2)));
fprintf('Probabilidade de obter pelo entre 1 e 3 coroas = %f\n', sum(fX(2:4)));