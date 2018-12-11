package pyroduck;

import java.io.*;
import java.util.*;

/**
 *
 * @author Bini, Petruzzello
 */
@SuppressWarnings("unchecked")
public class ListPointsSerialize {
    protected List<PointsSerialize> list;

    public ListPointsSerialize() {
        list = new LinkedList<>();
    }
    
    public void charge() {
        File f = new File("punteggi.dat");
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream(f));
            this.list = (List<PointsSerialize>) in.readObject();
            in.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void save() {
        try {
            File f = new File("punteggi.dat");
            order(list);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(list);
            out.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void order(List<PointsSerialize> list){
        for(int i = 0; i < list.size(); i++) {
            boolean s = false;
            for(int j = 0; j < list.size()-1; j++) {
                if((list.get(j).getPoints() < list.get(j+1).getPoints()) || ((list.get(j).getPoints() == list.get(j+1).getPoints()) && list.get(j).getLives() < list.get(j+1).getLives()) ) {
                    PointsSerialize k = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, k);
                    s = true;
                }
            }
            if(!s) break;
        }
    }
    
    public void addScore(PointsSerialize p){
        list.add(p);
        save();
    }
    
    public String printScores(){
        charge();
        String s = "Name\t|Scores\t|Lives\n________________________|_____\n";
        for(PointsSerialize p : list){
            s += p.getName()+"\t|" + p.getPoints() + "\t|" + p.getLives() + "\n";
        }
        return s;
    }
    
    public int size(){
        return list.size();
    }
}