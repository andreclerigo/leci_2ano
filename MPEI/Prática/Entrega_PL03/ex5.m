fid = fopen('wordlist-preao-20201103.txt','r');
dicionario = textscan(fid,'%s');
fclose(fid);
dicionario = dicionario{1,1};

r = ["r"];
o = ["o", "ó", "ò", "ô"];
m = ["m"];
a = ["a", "à", "á", "â", "ã"];
letters = ["b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "p", "q", "s", "t", "u", "v", "w", "x", "y", "z", "ç", "í"];
filtrado={};
for i=1:length(dicionario)
    TF = contains(dicionario{i},r,'IgnoreCase',true) & contains(dicionario{i},o,'IgnoreCase',true) & contains(dicionario{i},m,'IgnoreCase',true) & contains(dicionario{i},a,'IgnoreCase',true) & not(contains(dicionario{i},letters,'IgnoreCase',true));
    if(TF==true)
        filtrado{end+1}=dicionario{i};
    end
end
filtrado = filtrado.';

Na=0;   %n palavras começadas por a
Nm=0;   %n palrvas começadas por m
No=0;   %n palavras começadas por o
Nr=0;   %n palavras começadas por r
for i=1:length(filtrado)
    chr=strcat(filtrado{i}(1)); %1 char da palavra 
    if(strcmp(chr,'A') | strcmp(chr,'a'))
        Na= Na+1;
    elseif(strcmp(chr,'M') | strcmp(chr,'m'))
        Nm= Nm+1;
    elseif(strcmp(chr,'O') | strcmp(chr,'o')  |strcmp(chr,'O') )
        No= No+1;
    elseif(strcmp(chr,'R') | strcmp(chr,'r'))
        Nr= Nr+1;
    else
        
    end
end
%probabilidades
Pa=Na/length(filtrado);
Pm=Nm/length(filtrado);
Po=No/length(filtrado);
Pr=Nr/length(filtrado);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%GERAR MATRIZ T%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %r   %o   %m   %a  %.
Tex=[0    0   0    0   0   %r
     0    0   0    0   0   %o
     0    0   0    0   0   %m
     0    0   0    0   0   %a
     0    0   0    0   0]; %.


for i=1:length(filtrado)
    chr1=strcat(filtrado{i}(end-1))
    chr2=strcat(filtrado{i}(end))
    if(strcmp(chr1,'r'))
        if(strcmp(chr2,'o') | strcmp(chr2,'ó') | strcmp(chr2,'ò') | strcmp(chr2,'ô') | strcmp(chr2,'õ'))
            Tex(2,1)= Tex(2,1)+1;
            Tex(5,2)= Tex(5,2)+1;
        elseif(strcmp(chr2,'m'))
            Tex(3,1)= Tex(3,1)+1;
            Tex(5,3)= Tex(5,3)+1;
        elseif(strcmp(chr2,'a') | strcmp(chr2,'á') | strcmp(chr2,'à') | strcmp(chr2,'ã') | strcmp(chr2,'â'))
            Tex(4,1)= Tex(4,1)+1;
            Tex(5,4)= Tex(5,4)+1;
        else
            fprintf("ERRO")
            break;
        end
    elseif(strcmp(chr1,'o') | strcmp(chr1,'ó') | strcmp(chr1,'ò') | strcmp(chr1,'ô') | strcmp(chr1,'õ'))
        if(strcmp(chr2,'r'))
            Tex(1,2)= Tex(1,2)+1;
            Tex(5,1)= Tex(5,1)+1;
        elseif(strcmp(chr2,'m'))
            Tex(3,2)= Tex(3,2)+1;
            Tex(5,3)= Tex(5,3)+1;
        elseif(strcmp(chr2,'a') | strcmp(chr2,'á') | strcmp(chr2,'à') | strcmp(chr2,'ã') | strcmp(chr2,'â'))
            Tex(4,2)= Tex(4,2)+1;
            Tex(5,4)= Tex(5,4)+1;
        end
    elseif(strcmp(chr1,'m'))
        if(strcmp(chr2,'r'))
            Tex(1,3)= Tex(1,3)+1;
            Tex(5,1)= Tex(5,1)+1;
        elseif(strcmp(chr2,'o') | strcmp(chr2,'ó') | strcmp(chr2,'ò') | strcmp(chr2,'ô') | strcmp(chr2,'õ'))
            Tex(2,3)= Tex(2,3)+1;
            Tex(5,2)= Tex(5,2)+1;
        elseif(strcmp(chr2,'a') | strcmp(chr2,'á') | strcmp(chr2,'à') | strcmp(chr2,'ã') | strcmp(chr2,'â'))
            Tex(4,3)= Tex(4,3)+1;
            Tex(5,4)= Tex(5,4)+1;
        end
    elseif(strcmp(chr1,'a') | strcmp(chr1,'á') | strcmp(chr1,'à') | strcmp(chr1,'ã') | strcmp(chr1,'â'))
        if(strcmp(chr2,'r'))
            Tex(1,4)= Tex(1,4)+1;
            Tex(5,1)= Tex(5,1)+1;
        elseif(strcmp(chr2,'o') | strcmp(chr2,'ó') | strcmp(chr2,'ò') | strcmp(chr2,'ô') | strcmp(chr2,'õ'))
            Tex(2,4)= Tex(2,4)+1;
            Tex(5,2)= Tex(5,2)+1;
        elseif(strcmp(chr2,'m'))
            Tex(3,4)= Tex(3,4)+1;
            Tex(5,3)= Tex(5,3)+1;
        end
    end
    
        
end
for i=1:4
    Tex(:,i)=Tex(:,i)./sum(Tex(:,i));
end
T=Tex

%%%%%%%%%%%%%%%%%%%%%%%%%%COMPARAÇAO%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
N=1e5;
%%%%%%%%%%%%%%%%%%%%%%INFINITO%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
fprintf("Para um size infinito.\n");
lista= {};
contadores = {1};
lista{1} = generateWord(T,generateState(Pa,Pm,Po,Pr));

%Preencher cell array da lista de palvras unicas e cell array de contadores
for i = 2 : N
    word = generateWord(T,generateState(Pa,Pm,Po,Pr));
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

%Transforma o cell array em matriz e ordena por ordem descendente
fprintf("Foram geradas %d palavras diferentes.\n",length(lista));
[p, idx] = sort(cell2mat(probabilidades), 'descend');
for i = 1 : 5
    fprintf("A %dª maior probabilidade é de %s = %.4f.\n", i, lista{idx(i)}, probabilidades{idx(i)});
end

%Le dicionario e verifica se as palavras geradas pertencem a esse
%dicionario, se sim adiciona a sua probabilidade
soma = 0;
for i = 1 : length(probabilidades)
        a = ismember(dicionario, lista{i}); %returns an array of booleans
        pos = find(a == true);              %return the position(s) of the true
        if(not(isempty(pos)))
            soma = soma + probabilidades{i};
        end
end
fprintf("A probabilidade de gerar um palavra válida é de %.4f.\n\n", soma);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%4,6,8%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
for j = 4 : 2 : 8
    lista= {};
    contadores = {1};
    lista{1} = generateWordSized(T, j, generateState(Pa,Pm,Po,Pr));
    fprintf("Para um size de %d.\n", j);
    
    %Preencher cell array da lista de palvras unicas e cell array de contadores
    for i = 2 : N
        word = generateWordSized(T, j, generateState(Pa,Pm,Po,Pr));
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
    
    %Transforma o cell array em matriz e ordena por ordem descendente
    fprintf("Foram geradas %d palavras diferentes.\n",length(lista));
    [p, idx] = sort(cell2mat(probabilidades), 'descend');
    for i = 1 : 5
        fprintf("A %dª maior probabilidade é de %s = %.4f.\n", i, lista{i}, probabilidades{idx(i)});
    end

    %Le dicionario e verifica se as palavras geradas pertencem a esse
    %dicionario, se sim adiciona a sua probabilidade
    soma=0;
    for i = 1 : length(probabilidades)
        a = ismember(dicionario, lista{i}); %returns an array of booleans
        pos = find(a == true);              %return the position(s) of the true
        if(not(isempty(pos)))
            soma = soma + probabilidades{i};
        end
    end
    fprintf("A probabilidade de gerar um palavra válida é de %.4f.\n\n", soma);
end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%funcoes%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [word] = generateWord(T,first)
    state = crawl(T, first, 5);
    state = state(1: length(state)-1);
    set_of_letters= 'roma';
    word = set_of_letters(state);  %Substituir estado por letra
end

function [word] = generateWordSized(T, size, first)
    state = crawlSized(T, first, 5, size);
    if (state(length(state)) == 5)
        state = state(1: length(state)-1);
    end
    
    set_of_letters= 'roma';
    word = set_of_letters(state);  %Substituir estado por letra
end

function [estadoInicial]=generateState(Pa,Pm,Po,Pr)
%gera um estado inicial com as novas prob
al=rand();
    if(al<=Pa)
        estadoInicial=4;
    elseif(al<=Pa+Pm)
        estadoInicial=3;
    elseif(al<=Pa+Pm+Pr)
        estadoInicial=1;
    else
        estadoInicial=2;
    end
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ANEXO%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Random walk on the Markov chain
% Inputs:
% t - state transition matrix
% first - initial state
% last - terminal or absorving state
% size - the maximum size that the walk should have
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