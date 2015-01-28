#include "Calcul.h"

Calcul::Calcul() : QWidget()
{
    ///// Déclaration des éléments graphiques

    question = new QLabel("Entrez deux nombres a additionner:", this);
    question->setAlignment(Qt::AlignHCenter);
    answer = new QLabel("", this);
    answer->setAlignment(Qt::AlignHCenter);
    edit1 = new QLineEdit();
    edit2 = new QLineEdit();
    answerButton = new QPushButton("Calculer", this);
    mainLayout = new QVBoxLayout();
    mainLayout->setSpacing(15);
    editLayout = new QHBoxLayout();

    ///// Déclaration des élémtents fonctionnels

    QFont fontIntro("Georgia", 15);

    ///// Association des éléments fonctionnels et graphiques

    editLayout->addWidget(edit1);
    editLayout->addWidget(edit2);
    mainLayout->addWidget(question);
    mainLayout->addLayout(editLayout);
    mainLayout->addWidget(answer);
    mainLayout->addWidget(answerButton);

    QObject::connect(answerButton,SIGNAL(clicked()), this, SLOT(calculation()));

    ///// Initialisation de la fenêtre

    this->setLayout(mainLayout);
}

void Calcul::result(int x, int y)
{
    int r = x+y;
    QString a = QString::number(r,10);
    QString* s = new QString("Le resultat est: ");
    s->append(a);
    answer->setText(*s);
}

void Calcul::calculation()
{
    int a, b;
    bool ok = true;

    QString* x = new QString(edit1->text());
    QString* y = new QString(edit2->text());

    a = x->toInt(&ok, 10); //ok pour le retour de fonction, 10 pour base 10
    b = y->toInt(&ok, 10);
    result(a,b);
}
