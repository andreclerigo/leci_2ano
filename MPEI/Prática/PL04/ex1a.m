clear all;
clc

N = 1e5;
alpha = ['a':'z' 'A':'Z'];

tic
keys = generateKeys(N, 6, 20, alpha);
fprintf('1a) No. Keys: %d\n', length(keys));
fprintf('    No. unique: %d\n', length(unique(keys)));
fprintf('    Running time: %f seconds\n', toc);

save 'keys' 'keys'

function keys = generateKeys(N, imin, imax, alpha, probs)
    keys = {};
    n = 0;
    Nalpha = length(alpha);
    if nargin == 5
        cs = cumsum(probs);
    end
    
    while n < N
        tam = randi([imin imax]);
        if nargin == 4
            aux = randi(Nalpha, 1, tam);
        else
            aux = zeros(1, tam);
            rn = rand(1, tam);
            for i = 1 : tam
                aux(i) = 1 + sum(rn(i) > cs);
            end
        end
        
        key = alpha(aux);
        if ~ismember(key, keys)
            n = n+1;
            keys{n} = key;
        end
    end
end