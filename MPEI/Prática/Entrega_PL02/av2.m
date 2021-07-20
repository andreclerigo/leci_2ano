p1 = 0.002;
p2 = 0.005;
pa = 0.01;
N  = 1e6;
n  = 8;

%B - uma caixa de brinquedos nao tem brinquedos comdefeito

%a) Estime por simulaçao a probabilidade do evento B quandon= 8brinquedos
exp = [rand(n,N) < p1; rand(n,N) < p2; rand(n,N) < pa];
resultado = sum(exp) == 0;
pB = sum(resultado)/N

%b) valor teorico da probabilidade do evento B e compare-o com o valor estimado por simulaçao 
%   na questao 2(a). O que conclui?



%c) simulacoes necessarias para desenhar um grafico de probabilidade do evento B em funcao 
%da capacidade da caixa. Considere todos os valores dende 2 a 20
fX = zeros(1,19);
X = 2:20;
for i = X
    sim = [rand(i,N) < p1; rand(i,N) < p2; rand(i,N) < pa];
    ;sucess = sum(sim) == 0;
    fX(i-1) = sum(sucess)/N;
end
plot(X,fX)
axis([1 21 0.7 1]);
grid on
title('pB em função da capacidade da caixa');
xlabel('Numero de Brinquedos');
ylabel('Probabilidade de não haver brinquedos defeituosos na caixa');

%d) Analisando o grafico da questao anterior, 2(c), qual deve ser a capacidade maxima da caixas
% se a empresa quiser garantir que a probabilidade de cada caixa nao ter brinquedos com defeito sejade pelo menos 90%?

%Observando o grafico da questão 2c) se a empresa quiser garantir uma
%probabilidade de pelo menos 90% que a caixa não tenha brinquedos defeituosos 
%a capacidade maxima da caixa de brinquedos devera ser 6. 