#ifndef INTRO_H
#define INTRO_H

#include <QObject>
#include <QPushButton>
#include <QHBoxLayout>
#include <QVBoxLayout>
#include <QLabel>

class Intro: public QWidget
{

    Q_OBJECT;

public:

    QLabel* intro;
    QVBoxLayout* mainLayout;
    QHBoxLayout* buttonLayout;
    QPushButton* quitButton;
    QPushButton* calculateButton;

    Intro();
};

#endif // INTRO_H
