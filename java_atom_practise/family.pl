male(Edward VII).
male(George V).
male(George VI).
male(Prince Charles).
male(Prince William).
male(Prince George).
female(Diana).
female(Kate).
female(Alexandra).
female(Elizabeth II).

Parent(Edward VII, George V).
parent(Victoria, Edward VII).
parent(Alexandra, George V).
parent(George VI, Elizabeth II).
parent(George V, George VI).
parent(Elizabeth II, Prince William).
parent(Prince Charles, Prince William).
parent(Diana, Prince William).
parent(Kate, Prince George).
parent(Prince William, Prince George).
parent(Kate, Princess Charlotte).
parent(Prince William, Princess Charlotte).

father(X,Y) :- male(X),parent(X,Y).
mother(X,Y) :- female(X),parent(X,Y).
son(X,Y) :- male(X),parent(Y,X).
daughter(X,Y) :- female(X),parent(Y,X).
grandfather(X,Y) :- male(X),parent(X,Somebody),parent(Somebody,Y).
