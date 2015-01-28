#include "Intro.h"

Intro::Intro() : QWidget()
{
    ///// Déclaration des éléments graphiques

    intro = new QLabel("Bienvenue sur la DemoGUI", this);
    intro->setAlignment(Qt::AlignHCenter);

    mainLayout = new QVBoxLayout;
    mainLayout->setSizeConstraint(QLayout::SetFixedSize);
    mainLayout->setContentsMargins(40,15,30,40);
    mainLayout->setSpacing(15);
    buttonLayout = new QHBoxLayout;

    quitButton = new QPushButton("Quitter", this);
    quitButton->setCursor(Qt::PointingHandCursor);
    calculateButton = new QPushButton("Calculer", this);
    calculateButton->setCursor(Qt::PointingHandCursor);

    ///// Déclaration des élémtents fonctionnels

    QFont fontIntro("Georgia", 15);

    ///// Association des éléments fonctionnels et graphiques

    intro->setFont(fontIntro);

    buttonLayout->addWidget(calculateButton);
    buttonLayout->addWidget(quitButton);

    mainLayout->addWidget(intro);
    mainLayout->addLayout(buttonLayout);

    ///// Initialisation de la fenêtre

    this->setFixedSize(this->size());
    this->setLayout(mainLayout);
}
