#include <QApplication>
#include <QWidget>
#include "MyQWidget.h"
#include <QPushButton> // Spécialisation de QWigdet
#include <QHBoxLayout>
#include <QVBoxLayout>
#include <iostream>

using namespace std;

int main(int argc, char **argv){
  QApplication app(argc,argv);
  MyQWidget fenetre;

  QPushButton *lfermer = new QPushButton("Fermer");
  QPushButton *lhello = new QPushButton("Hello");

  QPushButton *rfermer = new QPushButton("Fermer");
  QPushButton *rhello = new QPushButton("Hello");

  QHBoxLayout *block = new QHBoxLayout;
  QHBoxLayout *right = new QHBoxLayout;
  QVBoxLayout *left = new QVBoxLayout;

  left->addWidget(lfermer);
  left->addWidget(lhello);
 
  right->addWidget(rfermer);
  right->addWidget(rhello);
 
  block->addLayout(left);
  block->addLayout(right);
  
  fenetre.setLayout(block);
  
  QObject::connect(lfermer, SIGNAL(clicked()), &app, SLOT(quit()));
  QObject::connect(rfermer, SIGNAL(clicked()), &app, SLOT(quit()));
  QObject::connect(lhello, SIGNAL(clicked()), &fenetre, SLOT(hello()) );
  QObject::connect(rhello, SIGNAL(clicked()), &fenetre, SLOT(hello()) );

  fenetre.show();

  return app.exec();
}
