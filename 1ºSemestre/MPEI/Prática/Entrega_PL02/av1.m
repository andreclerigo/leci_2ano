p1 = 0.002;
p2 = 0.005;
pa = 0.01;
N  = 1e7;
n  = 8;

%A - uma  caixa  de  brinquedos  tem  pelo  menos  1 brinquedo com defeito

%a) Estime por simulação a probabilidade do evento A quandon= 8brinquedos

exp = [rand(n,N) < p1; rand(n,N) < p2; rand(n,N) < pa];
resultado = sum(exp) >=1;
pA = sum(resultado)/N

%b)numero medio de brinquedos defeituosos apenas devido ao processo demontagem quando so ocorre o evento A.
montagemDefeituosa = sum(exp(17:24,:)) ==1  & sum(exp(1:16,:)) == 0;
pB = sum(montagemDefeituosa)/sum(resultado)