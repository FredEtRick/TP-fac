/**
 * @file analex.h
 * @author Michel Meynard
 * @brief Définition de la fon analex() qui retourne un entier positif si OK, 
 * 0 si fin de fichier. Le filtrage est permis gâce aux jetons négatifs.
 */
#include <string.h>
char lexeme[1024];		/* lexème courant de taille maxi 1024 */
int DEBUG=0;			/* débogage */
/** 
 * lit dans l'entrée standard le mot le plus long se terminant en un état final 
 * de l'automate défini par TRANS, puis retourne le JETON correspondant.
 * @returns le JETON entier correspondant à l'état final de l'AFD
 */
int analex(){			/* reconnaît un mot sur l'entrée standard */
  int etat=EINIT;		/* unique état initial */
  int efinal=-1;		/* pas d'état final déjà vu */
  int lfinal=0;			/* longueur du lexème final */
  int c;char sc[2];int i;	/* caractère courant */
  lexeme[0]='\0';		/* lexeme en var globale (pour le main)*/
  while ((c=getchar())!=EOF && TRANS[etat][c]!=-1){ /* Tq on peut avancer */
    sprintf(sc,"%c",c);		/* transforme le char c en chaine sc. sprintf écrit dans un "string" */
    strcat(lexeme,sc);		/* concaténation */
    if (DEBUG) printf("%i -- %c --> %i ;",etat,c,TRANS[etat][c]); // debug : change jamais ?
    etat=TRANS[etat][c];	/* Avancer */
    if (JETON[etat]){		/* si état final */ // ou état poubelle ? continue quand même si autre chose après
      efinal=etat;		/* s'en souvenir */
      lfinal=strlen(lexeme);	/* longueur du lexeme egalement */
    } /* fin si */     
  } /* fin while */
  if (JETON[etat]){		/* état final */
    ungetc(c,stdin);		/* rejeter le car non utilisé */
    return (JETON[etat]<0 ? analex() : JETON[etat]);/* ret le jeton ou boucle*/ // char lus ne seront pas relus
  }
  else if (efinal>-1){		/* on en avait vu 1 */ // mais pas bon et on a eu EOF
    ungetc(c,stdin);		/* rejeter le car non utilisé */
    for(i=strlen(lexeme)-1;i>=lfinal;i--)
      ungetc(lexeme[i],stdin);	/* rejeter les car en trop jusqu'à celui (compris) qui a renvoyé l'état poubelle */
    lexeme[lfinal]='\0';	/* voici le lexeme reconnu */
    return (JETON[efinal]<0 ? analex() : JETON[efinal]);/* ret jeton ou boucle*/ // pourquoi vérifier si <0 ? si c'était supérieur on se serait arrêté avec JETON[ETAT] = 1
  }
  else if (strlen(lexeme)==0 && c==EOF) // on a commencé en fin de fichier direct ? (donc on a lu tous les jetons)
    return 0;			/* cas particulier */
  else if (strlen(lexeme)==0){ // ?? lexeme vide sans EOF ?? Rien compris a cette partie
    lexeme[0]=c;lexeme[1]='\0';	/* retourner (c,c) */
    return c;
  }
  else { // Autres cas ?
    ungetc(c,stdin);		/* rejeter le car non utilisé */
    for(i=strlen(lexeme)-1;i>=1;i--)
      ungetc(lexeme[i],stdin);	/* rejeter les car en trop */
    return lexeme[0];
  }
}
