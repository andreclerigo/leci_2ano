clear all

N = 1e4;
p = 0.9;

for pessoas = 1 : 366 %com 366 pessoas é grantido ter duas pessoas a ter a mesma data de nascimento
    a = randi(365, pessoas, N);
    for i = 1:N
        res(i) = length(unique(a(:, i))) < pessoas;
    end
    prob = sum(res)/N;
    if (prob > p)
        pessoas
        break
    end
end