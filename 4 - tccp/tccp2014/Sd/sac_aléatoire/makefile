all: boiteAlea

boiteAlea : boiteAlea.c typesBase/typeBase.o
	gcc -o boiteAlea testBoiteAlea.c boiteAlea.c typesBase/typeBase.o -std=c99

typeBase.o: typesBase/typeBase.c
	gcc -c typesBase/typeBase.c

clean:
	rm *.o *~ boiteAlea
