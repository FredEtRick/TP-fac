CC = gcc
CFLAGS = -std=c99 -pedantic-errors -Werror
PROGNAME = linkedlist

all: LinkedList.o main.o
	$(CC) LinkedList.o main.o -o $(PROGNAME)

main.o: main.c
	$(CC) $(CFLAGS) -c main.c -o main.o

LinkedList.o: LinkedList.c
	$(CC) $(CFLAGS) -c LinkedList.c -o LinkedList.o

clean:
	rm -rf *.o
	rm $(PROGNAME)

