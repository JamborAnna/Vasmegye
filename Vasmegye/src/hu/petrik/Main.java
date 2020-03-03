package hu.petrik;

public class Main {

    public static void main(String[] args) {
        SzemelyiSzamok Sz= new SzemelyiSzamok("vas.txt");
        Sz.ellenorzes();
        System.out.println(Sz.getCsecsemokSzama());
        System.out.println(Sz.getFiuCsecsemokSzama());
        System.out.println(String.format("%d-%d",Sz.getKezdoEv(),Sz.getBefejezoEv()));
        int ind= Sz.isSzuletettESzokonapon();
        if (ind!=-1){
            System.out.println("Született!");
        }else {
            System.out.println("Nem született!");
        }
       Sz.statisztika();
	/*SzemelyiSzam sz= new SzemelyiSzam("1-980227-1258");
	System.out.println(sz.getM());
        System.out.println(sz.getEv());
        System.out.println(sz.getHonap());
        System.out.println(sz.getNap());
        System.out.println(sz.getSorszam());
        System.out.println(sz.getK());*/

    }
}
