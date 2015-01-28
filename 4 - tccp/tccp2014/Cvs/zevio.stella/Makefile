all : lettre

cv : cv.tex
	pdflatex cv.tex

lettre : cv.tex lettre.tex
	pdflatex cv.tex
	pdflatex lettre.tex
	
clean :
	rm -f *~
	rm -f *.aux
	rm -f *.lof
	rm -f *.log
	rm -f *.out
	rm -f *.toc

mrproper : clean
	rm -f *.pdf
	