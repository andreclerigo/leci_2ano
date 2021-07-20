p1 = 0.002;
p2 = 0.005;
pa = 0.01;
N  = 1e5;
n  = 8;

exp = [rand(n,N) < p1; rand(n,N) < p2; rand(n,N) < pa];
resultado = sum(exp);

%a) funcao massa de probabilidade pX(x) de X quando n = 8 brinquedos e desenhe-a num grafico stem.
%Descreva os resultados obtidos e verifique a sua consistencia com o resultado obtido na questao 2(a).

X = 0:8;
fX = zeros(1,9);
for i = X
    fX(i+1) = sum(resultado==i)/N;
end
stem(X,fX)
axis([-0.5 8.5 -0.05 0.95]);
grid on
title('Funcão massa de pX(x) de X');
xlabel('Brinquedos Defeituosos');
ylabel('Probabilidade haver Brinquedos defeituosos na caixa');

%O resultado obtido na questão 2a)(probabilidade de não haver brinquedos defeituosos) é bastante 
%proximo ao resultado observado quando x=0.
%Ao ver o grafico gerado podemos observar que conforme o numero de
%brinquedos defeituosos vai aumentando, o sua probabilidade de acontecer
%vai diminuindo.

%b)  Com base em pX(x), calcule a probabilidade deX >= 2. O que conclui?
pX2n8 = 0;
for i = 2:8
    pX2n8 = pX2n8 + fX(i+1);
end
pX2n8
%Para um valor de 0,0081 para pX2n8 podemos concluir que ter 2 ou mais brinquedos 
%defeituosos numa caixa com 8 brinquedos é um acontecimento raro (probabilidade muito baixa). 


%%try out
%c)  Com base em pX(x), estime o valor esperado, a variancia e o desvio padrao de X.
valorEsperado8 = sum(fX.*X);

%VARIANCIA VAR(X) = E(x^2)-(E(x))^2
variancia8 = sum(fX.*(X.^2)) - valorEsperado8.^2
desvioPadrao8 = sqrt(variancia8)


%%d) n=16
n = 16;

exp=[rand(n,N)<p1; rand(n,N)<p2; rand(n,N)<pa];
resultado= sum(exp);

%funcao massa de probabilidade pX(x)deX quando n= 16
Y=0:16;
fY=zeros(1,17);
for i=Y
    fY(i+1)= sum(resultado==i)/N;
end
figure(2);
stem(Y,fY);
axis([-0.5 17.5 -0.05 0.95]);
grid on
title('Funcão massa de pX(x) de X');
xlabel('Brinquedos Defeituosos');
ylabel('Probabilidade haver Brinquedos defeituosos na caixa');

%Com base em pY(y), calcule a probabilidade de Y >= 2.
pX2n16 = 0;
for i = 2:8
    pX2n16 = pX2n16 + fY(i+1);
end
pX2n16

%%try out
%c)  Com base em pY(y), estime o valor esperado, a variancia e o desvio padrao de Y.
valorEsperado16 = sum(fY.*Y)

%VARIANCIA VAR(Y) = E(y^2)-(E(y))^2
variancia16 = sum(fY.*(Y.^2)) - valorEsperado16.^2

desvioPadrao16 = sqrt(variancia16)



