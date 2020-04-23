package com.example.commtestnode.ui.big;

import androidx.lifecycle.ViewModel;

import java.util.List;

class Moment{

    String Hablar;
    String Mover;
    String Carita;
}
class ActorMoments{
    String Name;
    List<Moment> Actions;
}

//perhaps this is nothing but a fragmented view. ..
//por ahora sup escena tiene actormoments, cada actorMoment tiene sus acciones de la escena
// en una escena cada actor tiene momentos que representan sus acciones.


public class BigTestViewModel extends ViewModel {
    // TODO: Implement the ViewModel


}
