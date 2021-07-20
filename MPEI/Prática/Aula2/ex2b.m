clear all

N = 1e5;

a = randi(100, 20, N); % Matriz em que as linhas sao so dardos, o valor é o nº do alvo, repetido 10x

for i = 1:N
    res(i) = length(unique(a(:, i))) < 20;
end
res;
sum(res)/N