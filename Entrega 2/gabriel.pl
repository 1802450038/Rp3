alocar_preferencia(X, Y) :-
    preferencia(X, Y, W),
    W=<3.

verificar_carga(X, Y) :-
    professor(X, Y),
    Y=<12.

incrementa(X, Xf, T) :-
    X>0,
    Xf>0,
    T is X+Xf.


alocar_carga3(X, Y) :-
    disciplina(Y, 1, Duracao),
    professor(X),
    Aux is 0,
    Total is 0,
    (   Total=<0
    ->  Total is Duracao
    ;   Total=<Duracao
    ->  Total is Duracao
    ;   Total=:=Duracao
    ->  Total is Duracao+Total
    ), Aux is Total,
    write(Total).



    
    