clc;
clear all;

load database; %'dic' 'Nu' 'users' 'Set' 'MinHashValue' 'MinHashSig'
users
user = 0;
option = 0;

menu(user, option, Nu, Set, dic, MinHashValue, MinHashSig);

function menu(user, option, Nu, Set, dic, MinHashValue, MinHashSig)
    while(isempty(option) | option < 4 | user == 0)
        clc
        if (user == 0)
            user = str2num(input(['Insert User ID (1 to ' num2str(Nu) '): '], 's'));
        elseif (isempty(user) || user< 1 || user>Nu)
            fprintf(2, 'User ID not valid.');
            fprintf(2, '\nPress any key to continue. ');
            pause; clc;  % Manter a informação disponível até ao utilizador pressionar em qualquer tecla
            user = 0;
        else
            fprintf('\nUser ID: %d\nMenu', user);
            fprintf('\n1 - Your Movies\n2 - Get Suggestions\n3 - Search Title\n4 - Exit\nSelect choice: ');
            option = str2num(input('', 's'));
            if isempty(option)
                continue;
            end
            
            switch option
                case 1
                    yourMovies(user, Set, dic);
                case 2
                    getSuggestions(Nu, MinHashValue, user, Set, dic);
                case 3
                    searchTitle(dic, MinHashSig)
                case 4
                    clc
                    break;
                otherwise
                    option = 0;
                    clc
            end
        end
    end
end

function yourMovies(user, Set, dic)
    fprintf('\nYour movies watched:\n');
    for i = 1:length(Set{user})
        fprintf('%d - %s\n', i, dic{Set{user}(i)});
    end
    fprintf(2, 'Press key to continue. ');
    pause; clc;  % Manter a informação disponível até ao utilizador pressionar em qualquer tecla
end

function getSuggestions(Nu, MinHashValue, user, Set, dic)
    while true
        fprintf('\nSelect the type of Movie\n1- Action, 2- Adventure, 3- Animation, 4- Children’s, 5- Comedy, 6- Crime, 7- Documentary, 8- Drama, 9- Fantasy\n10- Film-Noir, 11- Horror, 12- Musical, 13- Mystery, 14- Romance, 15- Sci-Fi, 16- Thriller, 17- War, 18- Western\nSelect choice: ');
        type = str2num(input('', 's'));
        if(type >= 1 && type <= 18)
            type = type + 2;
            break;
        end
        fprintf(2, 'Invalid number! ');
        pause; clc; % Manter a informação disponível até ao utilizador pressionar em qualquer tecla
    end
                    
    K = 100;  % Usamos o mesmo número de funcoes de dispersão usados para a MinHash na database
    J = ones(1, Nu); % array para guardar distâncias
    h = waitbar(0, 'Calculating');
    for n = 1:Nu
        waitbar(n/Nu, h);
        if n ~= user
            J(n) = sum(MinHashValue(n,:) ~= MinHashValue(user,:))/K;  % Calculamos a distancia de Jaccard para todos os pares possiveis desse user
        end
    end
    delete(h);
    [val, SimilarUserId] = min(J);
    
    suggestions = [];
    for n = 1:length(Set{SimilarUserId})
        % Se o similarUser tiver algum filme vistos que o user nao viu, e
        % for da categoria escolhida, esse é um filme que vai ser sugerido
        if (~ismember(Set{SimilarUserId}(n), Set{user}) && dic{Set{SimilarUserId}(n), type} == 1)
            suggestions = [suggestions string(dic{Set{SimilarUserId}(n), 1})];
        end
    end
    
    if isempty(suggestions)  % Se nao houver sugestoes
        fprintf('\nThere is no film suggestions.\n');
    else
       fprintf('\nFilm Suggestions:\n');
       for i = 1:length(suggestions)  % Display dos filmes sugeridos
           fprintf(suggestions(i) + '\n');
       end
    end
    fprintf(2, 'Press any key to continue. ');
    pause;clc;  % Manter a informação disponível até ao utilizador pressionar em qualquer tecla
end

function searchTitle(dic, MinHashSig)
    str = lower(input('\nWrite a String: ', 's'));
    shingle_size = 3;  % Utilizar o mesmo numero de shingles que na database
    K = size(MinHashSig, 2);  % Usar o K igual ao K utilizado na base de dados para os shingles dos titulos
    threshold = 0.99;  % Definir um threshold que nos é dado

    % Cell array com os shingles da string introduzida
    shinglesAns = {};
    for i = 1:length(str) - shingle_size+1
        shingle = str(i:i+shingle_size-1);
        shinglesAns{i} = shingle;
    end

    % Fazer a MinHash dos shingles da string introduzida
    MinHashString = inf(1,K);
    for j = 1:length(shinglesAns)
        chave = char(shinglesAns{j});
        hash = zeros(1,K);
        for kk = 1:K
            chave = [chave num2str(kk)];
            hash(kk) = DJB31MA(chave, 127);
        end
        MinHashString(1,:) = min([MinHashString(1,:); hash]);
    end

    % Distancia de Jaccard entre a string e cada filme
    distJ = ones(1, size(dic,1));  % array para guardar distancias
    h = waitbar(0,'Calculating');
    for i=1:size(dic, 1)  % cada hashcode da string
        waitbar(i/K, h);
        distJ(i) = sum(MinHashSig(i,:) ~= MinHashString)/K;
    end
    delete(h);
    
    flag = false;  % Fazemos uma flag para saber se houve algum filme encontrado com uma distancia menor ou igual a threshold
    for i = 1:5
        [val, pos] = min(distJ);  % Calcular o valor minimo (mais similaridade)
        if (val <= threshold)  % Se o valor minimo já nao pretencer ao threshold não dá print
            flag = true;
            fprintf('%s   (%f)\n', dic{pos, 1}, val);
        end
        distJ(pos) = 1;  % Retirar esse filme dando uma distancia igual a 1
    end
    
    if (~flag)
        fprintf('No movies found.\n');
    end
    fprintf(2, 'Press any key to continue. ');
    pause;clc;  % Manter a informação disponível até ao utilizador pressionar em qualquer tecla  
end
