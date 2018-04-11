domains
    disease,indication,medicene = symbol
    Patient,name = string
predicates
    assumption(string,disease)
	suggest(disease)
    sign(name,indication)
    answer(char)
    start
clauses
    start :-
        write("Name of the Patient:"),
        readln(Patient),
        assumption(Patient,Disease),
        write(Patient," might have ",Disease,"."),nl,
		suggest(Disease).
    start :-
        write("Disease not Diagnosable").
    sign(Patient,fever) :-
        write("Does ",Patient," have a fever (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,rash) :-
        write("Does ",Patient," have a rash (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,headache) :-
        write("Does ",Patient," have a headache (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,runny_nose) :-
        write("Does ",Patient," have a runny_nose (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,conjunctivitis) :-
        write("Does ",Patient," have conjunctivitis (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,cough) :-
        write("Does ",Patient," have a cough (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,body_ache) :-
        write("Does ",Patient," have body_aches (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,chills) :-
        write("Does ",Patient," have chills (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,sore_throat) :-
        write("Does ",Patient," have a sore_throat (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,sneezing) :-
        write("Does ",Patient," have sneezing (y/n) ?"),
        answer(Reply),
        Reply='y'.
    sign(Patient,swollen_glands) :-
        write("Does ",Patient," have swollen_glands (y/n) ?"),
        answer(Reply),
        Reply='y'.
	assumption(Patient,mumps) :-
        sign(Patient,fever),
        sign(Patient,swollen_glands).
	assumption(Patient,influenza) :-
        sign(Patient,fever),
        sign(Patient,headache),
        sign(Patient,runny_nose),
        sign(Patient,rash).
	assumption(Patient,chicken_pox) :-
        sign(Patient,fever),
        sign(Patient,chills),
        sign(Patient,body_ache),
        sign(Patient,rash).
    assumption(Patient,flu) :-
        sign(Patient,fever),
        sign(Patient,headache),
        sign(Patient,body_ache),
        sign(Patient,conjunctivitis),
        sign(Patient,chills),
        sign(Patient,sore_throat),
        sign(Patient,runny_nose),
        sign(Patient,cough).    
    assumption(Patient,measles) :-
        sign(Patient,fever),
        sign(Patient,cough),
        sign(Patient,conjunctivitis),
        sign(Patient,runny_nose),
        sign(Patient,rash).
    assumption(Patient,common_cold) :-
        sign(Patient,headache),
        sign(Patient,sneezing),
        sign(Patient,sore_throat),
        sign(Patient,runny_nose),
        sign(Patient,chills). 
	suggest(flu):-
		write("A dose of Paracetamol is suggested.").
	suggest(measles):-
		write("A MMR-vaccine is suggested.").
	suggest(influenza):-
		write("A dose of  oseltamivir is suggested.").
	suggest(common_cold):-
		write("A dose of Avil-25 is suggested.").
	suggest(mumps):-
		write("A dose of Azalthropine is suggested.").
	suggest(chicken_pox):-
		write("Vaccination is suggested.").
    answer(Reply) :-
        readchar(Reply),
        write(Reply),nl.