clear all;
clc

load keys;
%%%%%%%%%%%%%%%%%%%%%%%%%%string2hash%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
tamanhos = [5e5, 1e6, 2e6];
for j = 1 : length(tamanhos)
    cont = 0;
    vectorTableS = zeros(1, tamanhos(j));
    hashCodes = zeros(1, length(keys));
    tic
    for i = 1 : length(keys)
        hashCodes(i) = mod(string2hash(keys{i}), length(vectorTableS)) + 1;
        if vectorTableS(hashCodes(i)) > 0 
            cont = cont + 1;
        end

        vectorTableS(hashCodes(i)) = vectorTableS(hashCodes(i)) + 1;
    end
    fprintf('Chaining HashTable %d djb2\n', tamanhos(j));
    fprintf('Number of Collisions: %d\n', cont);
    fprintf('Number of atributions: %d\n', max(vectorTableS));
    fprintf('Running time: %f seconds\n', toc);
    h = hashCodes/length(vectorTableS);
    %histogram(hashCodes, 100)
    fprintf('Momento 2: medio  - %f teorico - %f\n', mean(h.^2),1/(2+1));
    fprintf('Momento 5: medio  - %f teorico - %f\n', mean(h.^5),1/(5+1));
    fprintf('Momento 10: medio - %f teorico - %f\n\n', mean(h.^10),1/(10+1));
end


for j = 1 : length(tamanhos)
    cont = 0;
    vectorTableS = zeros(1, tamanhos(j));
    hashCodes = zeros(1, length(keys));
    tic
    for i = 1 : length(keys)
        hashCodes(i) = mod(string2hash(keys{i}, "sdbm"), length(vectorTableS)) + 1;
        if vectorTableS(hashCodes(i)) > 0 
            cont = cont + 1;
        end

        vectorTableS(hashCodes(i)) = vectorTableS(hashCodes(i)) + 1;
    end
    fprintf('Chaining HashTable %d sdbm\n', tamanhos(j));
    fprintf('Number of Collisions: %d\n', cont);
    fprintf('Number of atributions: %d\n', max(vectorTableS));
    fprintf('Running time: %f seconds\n', toc);
    h = hashCodes/length(vectorTableS);
    %histogram(hashCodes, 100)
    fprintf('Momento 2: medio  - %f teorico - %f\n', mean(h.^2),1/(2+1));
    fprintf('Momento 5: medio  - %f teorico - %f\n', mean(h.^5),1/(5+1));
    fprintf('Momento 10: medio - %f teorico - %f\n\n', mean(h.^10),1/(10+1));
end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%string2hash%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%DJB31MA%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
for j = 1 : length(tamanhos)
    cont = 0;
    vectorTableS = zeros(1, tamanhos(j));
    hashCodes = zeros(1, length(keys));
    tic
    for i = 1 : length(keys)
        hashCodes(i) = mod(DJB31MA(keys{i}, 127), length(vectorTableS)) + 1;
        if vectorTableS(hashCodes(i)) > 0 
            cont = cont + 1;
        end

        vectorTableS(hashCodes(i)) = vectorTableS(hashCodes(i)) + 1;
    end
    fprintf('Chaining HashTable %d DJB21MA\n', tamanhos(j));
    fprintf('Number of Collisions: %d\n', cont);
    fprintf('Number of atributions: %d\n', max(vectorTableS));
    fprintf('Running time: %f seconds\n', toc);
    h = hashCodes/length(vectorTableS);
    %histogram(hashCodes, 100)
    fprintf('Momento 2: medio  - %f teorico - %f\n', mean(h.^2),1/(2+1));
    fprintf('Momento 5: medio  - %f teorico - %f\n', mean(h.^5),1/(5+1));
    fprintf('Momento 10: medio - %f teorico - %f\n\n', mean(h.^10),1/(10+1));
end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%DJB31MA%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%hashstring%%%%%%%%%%%%%%%%%%%%%%%%%%%
for j = 1 : length(tamanhos)
    cont = 0;
    vectorTableS = zeros(1, tamanhos(j));
    hashCodes = zeros(1, length(keys));
    tic
    for i = 1 : length(keys)
        hashCodes(i) = mod(hashstring(keys{i}, length(vectorTableS)), length(vectorTableS)) + 1;
        if vectorTableS(hashCodes(i)) > 0 
            cont = cont + 1;
        end

        vectorTableS(hashCodes(i)) = vectorTableS(hashCodes(i)) + 1;
    end
    fprintf('Chaining HashTable %d hashstring\n', tamanhos(j));
    fprintf('Number of Collisions: %d\n', cont);
    fprintf('Number of atributions: %d\n', max(vectorTableS));
    fprintf('Running time: %f seconds\n', toc);
    h = hashCodes/length(vectorTableS);
    %histogram(hashCodes, 100)
    fprintf('Momento 2: medio  - %f teorico - %f\n', mean(h.^2),1/(2+1));
    fprintf('Momento 5: medio  - %f teorico - %f\n', mean(h.^5),1/(5+1));
    fprintf('Momento 10: medio - %f teorico - %f\n\n', mean(h.^10),1/(10+1));
end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%hashstring%%%%%%%%%%%%%%%%%%%%%%%%%%%