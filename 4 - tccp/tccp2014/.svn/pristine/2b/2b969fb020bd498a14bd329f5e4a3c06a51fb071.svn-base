#ifndef CALCUL_H
#define CALCUL_H

#include <QObject>
#include <QVBoxLayout>
#include <QHBoxLayout>
#include <QPushButton>
#include <QLineEdit>
#include <QLabel>

class Calcul: public QWidget
{
    Q_OBJECT;

   private:

    QLabel* question;
    QLabel* answer;
    QVBoxLayout* mainLayout;
    QHBoxLayout* editLayout;
    QLineEdit* edit1;
    QLineEdit* edit2;
    QPushButton* answerButton;


   public:

    Calcul();
    void result(int, int);

    public slots:

    void calculation();

};

#endif // CALCUL_H
