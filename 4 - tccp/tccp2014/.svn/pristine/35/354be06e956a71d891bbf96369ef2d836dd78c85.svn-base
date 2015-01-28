all:lettrecv

lettrecv: CV.tex LettreMotivation.tex
	pdflatex LettreMotivation.tex	
	pdflatex CV.tex

CV : CV.tex
	pdflatex CV.tex

LettreMotivation : LettreMotivation.tex
	pdflatex LettreMotivation.tex


clean :
	rm -f *.aux
	rm -f *.lof
	rm -f *.log
	rm -f *.out
	rm -f *.toc
