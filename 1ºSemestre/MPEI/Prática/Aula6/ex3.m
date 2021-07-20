clear all;

%a)
T = zeros(20);
for i = 1:20
    A= rand(20,1);
    A=A/sum(A);
    T(:,i) = A;
end

%b)
x = zeros(1,20)';
x(1) = 1;

iteracoes = [2 5 10 100];
y = zeros(1,4);

for i = 1:length(iteracoes)
    z = T^iteracoes(i)*x;
    y(i) = z(20);
end

fprintf('Apos 2 iteracoes a prob de estar no estado 20 é %.5f \n', y(1)*100);
fprintf('Apos 5 iteracoes a prob de estar no estado 20 é %.5f \n', y(2)*100);
fprintf('Apos 10 iteracoes a prob de estar no estado 20 é %.5f \n', y(3)*100);
fprintf('Apos 100 iteracoes a prob de estar no estado 20 é %.5f \n', y(4)*100);

%Nao interessa qual a matriz random de transicao de estados, o valor para o
%estado 20 após n iteracoes são semelhantes uns aos outros
