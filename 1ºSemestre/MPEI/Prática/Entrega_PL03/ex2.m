clear all;
clc;

    %r   %o   %m   %a  %.
T = [0   0.3  0    0.3  0
     .3  0    0.3  0.1  0
     0   0.2  0    0.2  0
     .7  0    0.7  0    0
     0   0.5  0    0.4  0];

N = 1e5;
fprintf("Para um size infinito.\n");
lista= {};
contadores = {1};
lista{1} = generateWord(T);

%Preencher cell array da lista de palvras unicas e cell array de contadores
for i = 2 : N
    word = generateWord(T);
    a = ismember(lista, word); %returns an array of booleans
    pos = find(a == true);     %return the position(s) of the true
    if (isempty(pos))          %Se pos = [] significa que não pertence à lista
        lista{end+1} = word;
        contadores{end+1} = 1;
    else
        contadores{pos} = contadores{pos} + 1;
    end
end

%Preencher cell array com probabilidades
probabilidades = {1, length(contadores)};
for i = 1 : length(contadores)
    probabilidades{i} = contadores{i} / N;  %Contem as probabilidades de cada palavra gerada
end

fprintf("Foram geradas %d palavras diferentes.\n",length(lista));
[p, idx] = sort(cell2mat(probabilidades), 'descend');
for i = 1 : 5
    fprintf("A %dª maior probabilidade é de %s = %.4f.\n", i, lista{i}, probabilidades{idx(i)});
end

fid = fopen('wordlist-preao-20201103.txt','r');
dicionario = textscan(fid,'%s');
fclose(fid);
dicionario = dicionario{1,1};
soma = 0;

for i = 1 : length(probabilidades)
    a = ismember(lista{i}, dicionario); %returns an array of booleans
    pos = find(a == true);              %return the position(s) of the true
    if(not(isempty(pos)))
        soma = soma + probabilidades{i};
    end
end
fprintf("A probabilidade de gerar um palavra válida é de %.4f.\n\n", soma);


for j = 4 : 2 : 8
    n = j;
    lista= {};
    contadores = {1};
    lista{1} = generateWordSized(T, j);
    fprintf("Para um size de %d.\n", j);
    %Preencher cell array da lista de palvras unicas e cell array de contadores
    for i = 2 : N
        word = generateWordSized(T, j);
        a = ismember(lista, word); %returns an array of booleans
        pos = find(a == true);     %return the position(s) of the true
        if (isempty(pos))          %Se pos = [] significa que não pertence à lista
            lista{end+1} = word;
            contadores{end+1} = 1;
        else
            contadores{pos} = contadores{pos} + 1;
        end
    end
    %Preencher cell array com probabilidades
    probabilidades = {1, length(contadores)};
    for i = 1 : length(contadores)
        probabilidades{i} = contadores{i} / N;  %Contem as probabilidades de cada palavra gerada
    end
    
    fprintf("Foram geradas %d palavras diferentes.\n",length(lista));
    [p, idx] = sort(cell2mat(probabilidades), 'descend');
    for i = 1 : 5
        fprintf("A %dª maior probabilidade é de %s = %.4f.\n", i, lista{idx(i)}, probabilidades{idx(i)});
    end
    
    fid = fopen('wordlist-preao-20201103.txt','r');
    dicionario = textscan(fid,'%s');
    fclose(fid);
    dicionario = dicionario{1,1};
    soma = 0;

    for i = 1 : length(probabilidades)
        a = ismember(lista{i}, dicionario); %returns an array of booleans
        pos = find(a == true);              %return the position(s) of the true
        if(not(isempty(pos)))
            soma = soma + probabilidades{i};
        end
    end
    fprintf("A probabilidade de gerar uma palavra válida é de %.4f.\n\n", soma);
end

%Analisar

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%My Functions
function [word] = generateWord(T)
    first = randi(4);  %Probabilidade de primeira letra é igual para todas
    state = crawl(T, first, 5);
    state = state(1: length(state)-1);
    set_of_letters= 'roma';
    word = set_of_letters(state);  %Substituir estado por letra
end

function [word] = generateWordSized(T, size)
    first = randi(4);  %Probabilidade de primeira letra é igual para todas
    state = crawlSized(T, first, 5, size);
    if (state(length(state)) == 5)
        state = state(1: length(state)-1);
    end
    
    set_of_letters= 'roma';
    word = set_of_letters(state);  %Substituir estado por letra
end

%Anexo
% Random walk on the Markov chain
% Inputs:
% t - state transition matrix
% first - initial state
% last - terminal or absorving state
function state = crawl(T, first, last)
    % the sequence of states will be saved in the vector "state"
    % initially, the vector contains only the initial state:
    state = [first];
    % keep moving from state to state until state "last" is reached:
    while (1)
        state(end+1) = nextState(T, state(end));
        if (state(end) == last)
            break;
        end
    end
end

% Random walk on the Markov chain
% Inputs:
% t - state transition matrix
% first - initial state
% last - terminal or absorving state
% size - the maximum size that the walk should have
function state = crawlSized(T, first, last, size)
    % the sequence of states will be saved in the vector "state"
    % initially, the vector contains only the initial state:
    state = [first];
    % keep moving from state to state until state "last" is reached:
    while (1)
        state(end+1) = nextState(T, state(end));
        if (state(end) == last || length(state) == size)
            break;
        end
    end
end

% Returning the next state
% Inputs:
% T - state transition matrix
% currentState - current state
function state = nextState(T, currentState)
% find the probabilities of reaching all states starting at the current one:
    probVector = T(:,currentState)'; % probVector is a row vector
    n = length(probVector); %n is the number of states
% generate the next state randomly according to probabilities probVector:
    state = discrete_rnd(1:n, probVector);
end

% Generate randomly the next state.
% Inputs:
% states = vector with state values
% probVector = probability vector
function state = discrete_rnd(states, probVector)
    U=rand();
    i = 1 + sum(U > cumsum(probVector));
    state= states(i);
end