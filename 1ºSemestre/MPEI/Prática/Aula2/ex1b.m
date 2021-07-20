clear all

p = 0.5;
k = 1;
n = 2;
prob = 0;

for k = 1:2
    prob= prob + nchoosek(n,k)*p^k*(1-p)^(n-k); % nchoosek(n,k)= n!/(n-k)!/k!
end

prob