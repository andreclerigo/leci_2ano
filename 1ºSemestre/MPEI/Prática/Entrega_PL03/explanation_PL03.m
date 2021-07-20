
%% import list of words to a cell array 'dicionario':
clc
fid= fopen('wordlist-preao-20201103.txt','r');
dicionario= textscan(fid,'%s');
fclose(fid);
dicionario= dicionario{1,1};
Nwords= length(dicionario)
dicionario{100}
dicionario{Nwords}

%% check if a word is in a cell array:
clc
word= 'útil';
ismember(word,dicionario) %returns true
word= 'util';
ismember(word,dicionario) %returns false ('util' does not exist)

%% determine the position of a word in a cell array:
clc
word= 'útil';
a= ismember(dicionario,word); %returns an array of booleans
pos= find(a==true)            %return the position(s) of the true
word= 'util';
a= ismember(dicionario,word);
pos= find(a==true)            %returns an empty array ('util' does not exist)

%% add words to a cell array
clc
lista= {}
word= 'mor';
lista{end+1}= word;
word= 'aro';
lista{end+1}= word;
lista{1}
lista{2}

%% determine each letter of a word
clc
word= 'ter';
for i=1:length(word)
    a= word(i)
end

%% determine if a word has only letters of a given set of letters
clc
set_of_letters= 'amor';
word= 'mor';
min(ismember(word,set_of_letters)) %returns true
word= 'morrer';
min(ismember(word,set_of_letters)) %returns false

%% determine word from a sequence of states
clc
set_of_letters= 'amor';
state= [1 2 3 4 1]
word= set_of_letters(state)
