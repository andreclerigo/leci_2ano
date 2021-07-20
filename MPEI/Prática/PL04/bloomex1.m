clc;
clear all;

n = 8000;
m = 1000;
m2 = 10000;
k = 3;

fid = fopen('wordlist-preao-20201103.txt','r');
dicionario = textscan(fid,'%s');
fclose(fid);
dicionario = dicionario{1,1};
BF = inicializar(n);

for i = 1:m
    BF = inserir(dicionario{i}, BF, k);
end
contador = 0;
for i = 1:m
    check = verificar(dicionario{i}, BF, k);
    if ~check
        contador = contador + 1;
    end
end
fprintf('No. false negativos = %d\n', contador);


contador = 0;
for i = m+1:m+m2
    check = verificar(dicionario{i}, BF, k);
    if check
        contador = contador + 1;
    end
end
fprintf('Pec. falsos positivos = %.2f%%\n', 100*contador/m2);
fprintf('Pec. falsos positivos teórica = %.2f%%\n', 100*(1-exp(-k*m/n))^k);

function BF = inicializar(n)
    BF = false(1,n);
end

function BF = inserir(elemento, BF, k)
    n = length(BF);
    for i = 1:k
        elemento = [elemento num2str(i)];
        h = DJB31MA(elemento, 127);
        h = mod(h,n) + 1; %para dar valor entre 1 e n para por no BF
        BF(h) = true;
    end
end

function check = verificar(elemento, BF, k)
    n = length(BF);
    check = true;
    for i = 1:k
        elemento = [elemento num2str(i)];
        h = DJB31MA(elemento, 127);
        h = mod(h,n) + 1; %para dar valor entre 1 e n para por no BF
        if ~BF(h)
            check = false;
            break;
        end
    end
end