m = 1000;
N = 1e5;
nValues = 1:10;
prob = zeros(1,10);

for n = 1 : length(nValues)
    n
    experience = randi(m, 10*n, N);                % Columns have the number of the target the darts hit
    successes  = 0;

    for j = 1:  N                                   % For each experience
        if (length (unique(experience(:,j))) ~= 10*n)     % if at least 1 number is different, ie at least 1 target were hit at least twice
            successes =  successes + 1;                % it's a success
        end
    end
    
    prob(n) = successes / N;
end

figure
subplot(1,2,1)
plot(nValues*10, prob)

xlabel('n')
ylabel('P(n)')
title('Probabilities for m = 1000')
drawnow
pause()
m = 100000;
N = 1e5;
nValues = 1:10;
prob = zeros(1,10);
i = 1;

for n = 1 : length(nValues)
    experience = ceil(m * rand (n, N));                % Columns have the number of the target the darts hit
    successes  = 0;

    parfor j = 1:  N                                   % For each experience
        if (length (unique(experience(:,j))) ~= n)     % if at least 1 number is different, ie at least 1 target were hit at least twice
            successes =  successes + 1;                % it's a success
        end
    end
    
    prob(i) = successes / N;
    
    n = n + 10;
    i = i + 1;
end

subplot(2,2,2)
plot(nValues, prob)  
xlabel('n')
ylabel('P(n)')
title('Probabilities for m = 100000')