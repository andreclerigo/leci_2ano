clear all;
%5
%a)
T = [0.7 0.2 0.1
     0.2 0.3 0.5
     0.3 0.3 0.4]'
%ou T= [0.7 .2 .3
      % .2  .3 .3
      % .1  .3 .4]
sum(T);
 
%b)
%p(sol)*p(sol->sol)*p(sol->sol)
x = [1 0 0]';
x1 = T*x;
x2 = T^2*x;

fprintf('Quando no Primeiro dia é sol\n');
%feito pelo prof
res_b = 1*T(1,1)*T(1,1)
%ou v=[1 0 0]' v2=T*v | v3=T*v | res_a = v(1)*v2(1)*v3(1)

%c)
%P(Sol)*p(sol->sol)* + p(sol->nuvens)*p(sol->sol)
x = [1 0 0]';
v2 = T*x;
w = v2/(v2(1) + v2(2)); %no segundo dia so pode estar sol ou nuvens
v3 = T*w;
fprintf('Quando no Primeiro dia é sol\n');
res_c = x(1)*(v2(1)+v2(2)) * (v3(1)+v3(2))

%d)
x = [1 0 0]';
fprintf('Quando no Primeiro dia é sol no fim de Janeiro houve:\n');
somaSol = x(1);        %o primeiro dia ja foi sol
somaNuvens = x(2);
somaChuva = x(3);
for i = 2:31
    %ou y = T^(i-1)*x; depois usar y
    x = T*x;
    somaSol = somaSol + x(1);
    somaNuvens = somaNuvens + x(2);
    somaChuva = somaChuva + x(3);
end

fprintf('%.2f dias de Sol\n %.2f dias de Nuvens\n %.2f dias de Chuva\n', somaSol,somaNuvens, somaChuva);
%f)
fprintf('A pessoa vai ter dores durante %.1f dias\n\n',somaSol * 0.1 + somaNuvens*0.3 + somaChuva*0.5);

%e)
x = [0 0 1]';
fprintf('Quando no Primeiro dia é Chuva no fim de Janeiro houve:\n');
somaSol = x(1);        
somaNuvens = x(2);
somaChuva = x(3);          %o primeiro dia ja foi chuva
for i = 2:31
    x = T*x;
    somaSol = somaSol + x(1);
    somaNuvens = somaNuvens + x(2);
    somaChuva = somaChuva + x(3);
end

fprintf('%.2f dias de Sol\n %.2f dias de Nuvens\n %.2f dias de Chuva\n\n', somaSol,somaNuvens, somaChuva);
%Concluo que em média so altera o primeiro dia

%f)
fprintf('A pessoa vai ter dores durante %.1f dias\n\n',somaSol * 0.1 + somaNuvens*0.3 + somaChuva*0.5);
