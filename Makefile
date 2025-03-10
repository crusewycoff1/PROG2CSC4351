JFLAGS=-g

Parse/*.class: Parse/*.java Parse/Grm.java
	javac ${JFLAGS} Parse/*.java

Parse/Grm.java: Parse/Grm.cup
	cd Parse; java java_cup.Main -parser Grm -expect 3 -nonterms -dump_grammar -dump_states -compact_red <Grm.cup >Grm.out 2>Grm.err

clean:
	cp Parse/Yylex* ./.
	rm -f */*.class Parse/Grm.java Parse/Grm.err Parse/Grm.out
	mv Yylex* ./Parse/
