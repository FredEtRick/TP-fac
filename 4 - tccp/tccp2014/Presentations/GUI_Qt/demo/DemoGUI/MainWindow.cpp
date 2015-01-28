#include "MainWindow.h"


MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent)
{

    ///// Déclaration des éléments graphiques

    setWindowTitle("Demo GUI");
    this->setWindowIcon(QIcon("qt.png"));
    intro = new Intro();

    ///// Association des éléments fonctionnels et graphiques

    QObject::connect(intro->calculateButton,SIGNAL(clicked()),this,SLOT(openCalcul()));
    QObject::connect(intro->quitButton,SIGNAL(clicked()),this,SLOT(close()));

    ///// Initialisation de la fenêtre

    this->setCentralWidget(intro);
    this->show();
}

void MainWindow::openCalcul()
{
    Calcul* cal = new Calcul();
    cal->show();
}





