coins = 40;
repeat = 1e5;

for nrHeads = 0:coins
    nrHeads
    resultado(nrHeads+1) = simulador(0.5, coins, nrHeads, repeat);
end 

stem(0:coins, resultado)

