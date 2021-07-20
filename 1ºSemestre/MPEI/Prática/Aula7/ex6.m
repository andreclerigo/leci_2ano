clear all;

%a)
T = [0.8 0   0 0.3 0
     0.2 0.6 0 0.2 0
     0   0.3 1 0   0
     0   0.1 0 0.4 0
     0   0   0 0.1 1]
sum(T);
 
%b)
v = [1 0 0 0 0]';
x = zeros(1,100);
x(1) = 0;
for i = 2:100
   v = T*v; 
   x(i) = v(2);
end
plot(1:100, x)
xlabel('Numero de transicoes')
ylabel('Probabilidade de estar no estado 2')
 
%c)
v = [1 0 0 0 0]';
x = zeros(1,100);
x(1) = 0;
for i = 2:100
   v = T*v; 
   x(i) = v(3);
end
v = [1 0 0 0 0]';
x2 = zeros(1,100);
x2(1) = 0;
for i = 2:100
   v = T*v; 
   x2(i) = v(5);
end

figure(2)
subplot(1,2,1)
plot(1:100,x)
title('Estado 3')
subplot(1,2,2)
plot(1:100,x2)
title('Estado 5')
%Como os estados sao absorventes, à medida que há passagem de estados a
%probabilidade de estar num estado absorvente tende para 1

%d)
% Matriz de estados canonica
%    1    2    4  3 5
C = [0.8 0   0.3  0 0
     0.2 0.6 0.2  0 0
     0   0.1 0.4  1 0
     0   0.3 0    0 0
     0   0   0.1  0 1]
sum(C);
Q = C(1:3, 1:3) %buscar a linha de 1-3 de C e coluna de 1-3 de C

%e)
F = (eye(3) - Q)^-1
sum(F)

%f)
t = F'*ones(3,1);
%ou sum(F)
fprintf('A probabilidade de absorção se partir do estado 1 é: %.4f\nDo estado 2 é: %.4f\nDo estado 3 é: %.4f\n', t);

%g)
R = C(4:5, 1:3);
B = R*F; %coluna comecar em estado transitorio e linha acabar no estado absovente
fprintf('Prob(estado 3) = %f, Prob(estado 5) = %f',B(1,1),B(2,1));