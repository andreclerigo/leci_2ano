dic = readcell('u_item.txt');

udata = load('u.data');
u = udata(1:end,1:2);
clear udata;

users = unique(u(:,1)); % Extrai os IDs dos utilizadores
Nu = length(users); % Numero de utilizadores

Set = cell(Nu,1); % Usa celulas
for n = 1:Nu % Para cada utilizador
    % Obtem os filmes de cada um
    ind = find(u(:,1) == users(n));
    % E guarda num array. Usa celulas porque utilizador tem um numero
    % diferente de filmes. Se fossem iguais podia ser um array
    Set{n} = [Set{n} u(ind,2)];
end

K = 100;  % Número de funções de dispersão
MinHashValue = inf(Nu,K);
for i = 1:Nu
    conjunto = Set{i}; 
    for j = 1:length(conjunto)
        chave = char(conjunto(j));
        hash = zeros(1,K);
        for kk = 1:K
            chave = [chave num2str(kk)];
            hash(kk) = DJB31MA(chave,127);
        end
        MinHashValue(i,:) = min([MinHashValue(i,:); hash]);  % Valor minimo da hash para este título
    end
end

shingle_size=3;
K = 150;  % Número de funções de dispersão
MinHashSig = inf(length(dic),K);
for i = 1:length(dic)
    conjunto = lower(dic{i,1});
    shingles = {};
    for j= 1 : length(conjunto) - shingle_size+1  % Criacao dos shingles para cada filme
        shingle = conjunto(j:j+shingle_size-1);
        shingles{j} = shingle;
    end
    
    for j = 1:length(shingles)
        chave = char(shingles(j));
        hash = zeros(1,K);
        for kk = 1:K
            chave = [chave num2str(kk)];
            hash(kk) = DJB31MA(chave,127);
        end
        MinHashSig(i,:) = min([MinHashSig(i,:);hash]);  % Valor minimo da hash para este shingle
    end
end

save 'database' 'dic' 'Nu' 'users' 'Set' 'MinHashValue' 'MinHashSig'