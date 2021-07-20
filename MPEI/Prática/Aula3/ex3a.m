clear all;

N = 1e6;
lancamentos = 4;

xi = 0:4;
px = 0:4;
a = randi(0:1, lancamentos, N);

coroas = sum(a);

soma0 = 0;
soma1 = 0;
soma2 = 0;
soma3 = 0;
soma4 = 0;
for i = 1 : N
    if (coroas(i) == 0)
        soma0 = soma0 + 1;
    end
    if (coroas(i) == 1)
        soma1 = soma1 + 1;
    end
    if (coroas(i) == 2)
        soma2 = soma2 + 1;
    end
    if (coroas(i) == 3)
        soma3 = soma3 + 1;
    end
    if (coroas(i) == 4)
        soma4 = soma4 + 1;
    end
end

px(1) = soma0 / N;
px(2) = soma1 / N;
px(3) = soma2 / N;
px(4) = soma3 / N;
px(5) = soma4 / N;

px;

stem(xi,px),xlabel('xi'),ylabel('px')