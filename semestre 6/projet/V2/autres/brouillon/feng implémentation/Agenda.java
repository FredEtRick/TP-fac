import java.util.*;

public class Agenda {
    private ArrayList<Taches> list_tache;
    


    public Agenda(){
	list_tache = new ArrayList();
    }

    public void setList(ArrayList<Taches> l){
	this.list_tache = l;
    }
    public ArrayList<Taches> getList(){
	return list_tache;
    }
	

    public void AjoutTache(Taches t) {
	this.add(t);

    }

    public void SupprimeTaches(Taches t){

    };