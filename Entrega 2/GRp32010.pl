% empty list
list_sum([], 0).



list_sum([Head | Tail], TotalSum) :-
list_sum(Tail, Sum1),
TotalSum is Head + Sum1,
(TotalSum  = 12 -> write('É igual a 12 \n');
TotalSum =< 12 -> write('Menor que 12 \n');
TotalSum >= 12 -> write('Soma igual a 12\n')).


