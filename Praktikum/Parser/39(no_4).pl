noun([N], katabenda(N)):-
	member(N,[pensil, televisi, kipas, adik, kakak]).

verb([V], katakerja(V)):-
	member(V,[meminjam, menyalakan]).

determiner([D], determinan(D)):-
	member(D, [seorang, seekor]).

keterangan([I], keterangan(I)):-
	member(I, [kemarin, semalam]).

noun_phrase(NP, subyek(DTree, NTree)):-
	determiner(D, DTree),
	noun(N, NTree), append(D,N,NP).

verb_phrase(VP, predikat(VTree)):-
	verb(VP, VTree).

verb_phrase(VP, frasa_kerja(VTree, NTree)):-
	verb(V, VTree),
	noun(N, NTree), 
	append(V,N,VP).

sentence(S, kalimat(NPTree,VPTree,KTree)):-
	noun_phrase(NP, NPTree),
	keterangan(K, KTree),
	append(NP,VP,NPVP),
	append(NPVP, K, S).

sentence(S, kalimat(NPTree,VPTree)):-
	noun_phrase(NP, NPTree),
	verb_phrase(VP, VPTree), 
	append(NP, VP, S).