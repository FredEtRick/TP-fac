
CC=gcc
CFLAGS= -Wall -Werror
LDFLAGS=
EXEC=testArbreBinaire
EXEC1=ArbreBin

all: $(EXEC)

$(EXEC): $(EXEC).o $(EXEC1).o
	$(CC) -o $@ $^ $(LDFLAGS)

$(EXEC).o: $(EXEC).c
	$(CC) -o $@ -c $< $(CFLAGS)

$(EXEC1).o: $(EXEC1).c
	$(CC) -o $@ -c $< $(CFLAGS)

clean:
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
	rm -rf $(EXEC1)
