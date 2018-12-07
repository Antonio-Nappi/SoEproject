package pyroduck;

import java.io.*;
import java.util.*;

/**
 *
 * @author Bini, Petruzzello
 */
@SuppressWarnings("unchecked")
public class ListPointsSerialize {
    List<PointsSerialize> list;

    public ListPointsSerialize() {
        list = new ArrayList<>();
    }
    
    public ListPointsSerialize charge() throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File("punteggi.dat");
        ObjectInputStream in;
        in = new ObjectInputStream(new FileInputStream(f));
        this.list = (List<PointsSerialize>) in.readObject();
        in.close();
        return (ListPointsSerialize) list;
    }
    
    public void save (List<PointsSerialize> list) throws FileNotFoundException, IOException{
        File f = new File("punteggi.dat");
        this.order(list);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(list);
        out.close();
    }
    
    private void order(List<PointsSerialize> list){
        for(int i = 0; i < list.size(); i++) {
            boolean s = false;
            for(int j = 0; j < list.size()-1; j++) {
                if((list.get(j).getPoints()<list.get(j+1).getPoints()) ||((list.get(j).getPoints() == list.get(j+1).getPoints()) && list.get(j).getLives()>list.get(j+1).getLives()) ) {
                    PointsSerialize k = list.get(j);
                    list.add(j, list.get(j+1));
                    list.add(j+1, k);
                    s = true;
                }
            }
            if(!s) break;
        }
    }
}