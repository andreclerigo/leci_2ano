clear all;

%a)
T = [1/3 1/4 0
     1/3 11/20 1/2
     1/3 1/5 1/2];
sum(T);             %Se for vetor de '1's é matriz estocástica

%b)
%Grupo A tem 60 alunos, grupo B tem 15 e C tem 15
x = [0.5 0.25 0.25]';

%c)
y = T^29*x;
y = y.*90;
y = round(y,0);
fprintf('O grupo A contem %d alunos\nO grupo B contem %d alunos\nO grupo C contem %d alunos\n\n', y);
sum(y);             %Verifica se ainda sao 90 alunos

%d)
x = [1/3 1/3 1/3]';
y2 = T^29*x;
y2 = y2.*90;
y2 = round(y2,0);
fprintf('O grupo A contem %d alunos\nO grupo B contem %d alunos\nO grupo C contem %d alunos\n', y2);