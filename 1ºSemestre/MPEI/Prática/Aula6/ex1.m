clear all;
%1
%a)
%Todas as semanas tem 2 aulas TPs da UCx às 9h00 quarta e sexta
%1 - nao ir a aula
%2 - ir a aula
Tij = [0.2 0.3
       0.8 0.7];
   
sum(Tij); % se der vetor de 1 temos matriz estocastica

x0 = [0 1]';

%x2 = Tijx1 = Tij(Tijx0) = Tij2x0
x1 = Tij*x0;   % probabilidades da aula seguinte
x2 = Tij^2*x0;
fprintf('1a) reposta = %f\n', x2(2));

%b
x0 = [1 0]'; %nao estar presente na 1ª e esta na 2ª

%x2 = Tijx1 = Tij(Tijx0) = Tij2x0
x2 = Tij^2*x0;
fprintf('1b) reposta = %f\n', x2(2));


%c
x0 = [0 1]'; %nao estar presente na 1ª e esta na 2ª
x2 = Tij^29*x0;
fprintf('1c) reposta = %f\n', x2(2));

%d
v = [0.15 0.85]'
res = zeros(1, 30);
res(1) = 0.15;
for i = 2:30
    v = Tij * v;
    %v2 = Tij^2 * v;
    res(i) = v(1);
end
plot(res, '*-');