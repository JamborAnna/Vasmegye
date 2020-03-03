package hu.petrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SzemelyiSzamok {

    private List<SzemelyiSzam>list;

    public SzemelyiSzamok(String fajlNev){
        this.list=new LinkedList<>();
        try {
            FileReader fr= new FileReader(fajlNev);
            BufferedReader br= new BufferedReader(fr);
            String sor=br.readLine();
            while (sor!=null){
                SzemelyiSzam s= new SzemelyiSzam(sor);
                this.list.add(s);
                sor= br.readLine();
            }
            br.close();
            fr.close();

        }catch (FileNotFoundException e){
            e.getMessage();
        }catch (IOException e){
            e.getMessage();
        }


    }
    public int getCsecsemokSzama(){
        return this.list.size();
    }

    public void ellenorzes(){
        List<Integer>hibasIndexLista= new ArrayList<>();
        for (int i=0; i<this.list.size();i++) {
            SzemelyiSzam szsz=( this.list.get(i));
            if (!szsz.CdvEll()){
                System.out.println(String.format("\t Hibás a %s szemelyik azonosítró!",szsz));
              hibasIndexLista.add(i);

            }

        }
        for (Integer ind: hibasIndexLista){
            this.list.remove(this.list.get(ind));
        }
    }

    public  int getFiuCsecsemokSzama(){
        int db=0;
        for (SzemelyiSzam sz:this.list){
            if (sz.isFiuE()){
                db++;
            }
        }
        return db;
    }

    public int getKezdoEv(){
        int min=0;
        for (int i = 1; i <this.list.size() ; i++) {
            if (this.list.get(min).getSzuletesiEv()>this.list.get(i).getSzuletesiEv()){
                min=i;
            }

        }
        return this.list.get(min).getSzuletesiEv();
    }
    public int getBefejezoEv(){
        int max=0;
        for (int i = 1; i <this.list.size() ; i++) {
            if (this.list.get(max).getSzuletesiEv()<this.list.get(i).getSzuletesiEv()){
                max=i;
            }

        }
        return this.list.get(max).getSzuletesiEv();
    }

    public  int isSzuletettESzokonapon(){
        int ind=0;
        while (ind<this.list.size()&&!this.list.get(ind).isSzokoEvE()){
            ind++;
        }
        return ind<this.list.size()? ind:-1;
    }

    public  void  statisztika(){
        SortedMap<Integer,Integer> map=new TreeMap<>(Comparator.reverseOrder());
        for (SzemelyiSzam sz:this.list) {
            if (!map.containsKey(sz.getSzuletesiEv())){
                map.put(sz.getSzuletesiEv(),1);
            }else {
                int db=map.get(sz.getSzuletesiEv());
                map.put(sz.getSzuletesiEv(),db+1);
            }
        }
        for (Integer ev: map.keySet()){
            System.out.println(String.format("%d-%d db",ev,map.get(ev)));
        }
    }



}
