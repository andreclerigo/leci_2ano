clear all;

Perro = 0.01*20/100 + 0.05*30/100 + 0.001*50/100;
p_Carlos_erro = 0.001*50/100/Perro
p_Bruno_erro = 0.05*30/100/Perro
p_Andre_erro = 0.01*20/100/Perro

tic
N = 1e7;
experiencias = [rand(20,N)<.01; rand(30,N)<0.05; rand(50,N)<0.001];

contAB = 0;
contB = 0;

for i = 1:N
    aux = randi(100);
    if experiencias(aux,i)==true
        contB = contB + 1;
        if aux > 50
            contAB = contAB + 1;
        end
    end
end
P_Carlos_erro_sim = contAB/contB
toc

tic
contAB = 0;
contB = 0;
for i = 1:N
    aux = randi(100);
    if aux > 50
        a = rand() < 0.001;
    elseif aux <= 20
        a = rand() < 0.01;
    else
        a = rand() < 0.05;
    end
    if a==true
        contB = contB + 1;
        if aux > 50
            contAB = contAB + 1;
        end
    end
end
P_Carlos_erro_sim = contAB/contB

toc
