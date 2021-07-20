p1 = 0.002;
p2 = 0.005;
pa = 0.001;
N  = 1e6;
n  = 20;
m  = 1;

exp = [rand(n,N) < p1; rand(n,N) < p2; rand(n,N) < pa];

%simulacao a probabilidade de uma caixa ser comercializada quando o processo de garantia de qualidade
%é implementado com m= 1
m = 1;
chosen = randperm(n,m);
caixaComercial = 0;

for i = 1:N
   if exp(chosen,i) == 0 && exp(n+chosen,i) == 0 && exp(2*n+chosen,i) == 0
       caixaComercial = caixaComercial + 1;
   end
end

pComercial = caixaComercial/N

%simulacao o menor valor de m necessario para atingir o objectivo desejado
pDesejado = 0.9;
m = 19;

for i = m:-1:1  %vai de 1 a 19 (m)
    escolhidos = randperm(n,i); %randperm(n,k) returns a row vector containing k unique integers selected randomly from 1 to n.
    caixaDefeito = 0;
    for coluna = 1:N %percorre todas as caixas 
        for k = escolhidos %percorre linha de cada brinquedo escolhido
            if exp(k,coluna) == 1 || exp(n+k,coluna) == 1 || exp(2*n+k,coluna) == 1 %verifica se brinquedo é defeituoso
                caixaDefeito = caixaDefeito + 1;
            end
        end
    end
    pTeste = 1 - caixaDefeito/N;
    if(pTeste >= pDesejado)
        fprintf('Menor valor de m para p >= 90 é %d\n', i);
        break;
    end
end
