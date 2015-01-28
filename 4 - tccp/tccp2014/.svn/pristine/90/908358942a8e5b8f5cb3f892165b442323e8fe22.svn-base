C=gcc

CFLAGS=-std=c99 -Wall -ansi

SRCDIR=Src
HEADDIR=Include
LIBDIR=Objet
BINDIR=Bin

SRC= $(wildcard $(SRCDIR)/*.c)
OBJ= $(SRC:$(SRCDIR)/%.c=$(LIBDIR)/%.o)

all: $(BIN)

#Création de l'exécutable
jeu: $(OBJ) $(OBJ)
	$(C) -o $(BINDIR)/$@ $^ $(CFLAGS)

# Création des différents *.o à partir des *.c
$(LIBDIR)/%.o: $(SRCDIR)/%.c 
	$(C) -o $@ -c $< $(CFLAGS)

# Nettoyage des objets => Tout sera recompileé !
clean:
	rm $(LIBDIR)/*.o

# Nettoyage complet => clean + effacement du l'exécutable
mrproper: clean
	rm $(BINDIR)/$(BIN)
