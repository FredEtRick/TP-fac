#ifndef MY_QWIDGET_H
#define MY_QWIDGET_H

#include <QWidget>

class MyQWidget : public QWidget{
  Q_OBJECT // Macro indiquant que l'on va utiliser le mécanisme Signaux/Slots
    public:
  MyQWidget();
  public slots:
  void hello();
};

#endif
