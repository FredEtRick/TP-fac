#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QObject>
//#include <QtWidgets>
#include <QMainWindow>
#include <QDialog>
#include <QIcon>
#include "Calcul.h"
#include "Intro.h"


class MainWindow : public QMainWindow
{
    Q_OBJECT

private:

    Intro* intro;
    QAction* quit;
    QAction* calculate;

public:

    explicit MainWindow(QWidget *parent = 0);

public slots:

    void openCalcul();
};

#endif // MAINWINDOW_H
