all : testlogiciel

testlogiciel :
	pdflatex testlogiciel.tex
	
clean : testlogiciel
	rm -f *~
	rm -f *.aux
	rm -f *.lof
	rm -f *.log
	rm -f *.out
	rm -f *.toc
	rm -f *.nav
	rm -f *.snm

mrproper : clean
	rm -f *.pdf
	