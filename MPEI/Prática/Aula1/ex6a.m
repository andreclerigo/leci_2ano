clear all
p = 0.3;
k = 3;
n = 5;
prob= nchoosek(n,k)*p^k*(1-p)^(n-k) % nchoosek(n,k)= n!/(n-k)!/k!