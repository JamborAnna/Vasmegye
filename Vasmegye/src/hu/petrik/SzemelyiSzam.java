package hu.petrik;

public class SzemelyiSzam {
    private String szam;
    public SzemelyiSzam(String szam){
        this.szam=szam;
    }
    private String getEgyszerusitettSzemelyiSzam(){
        return this.szam.replaceAll("-","");
    }

    public int getM(){
        return  Integer.parseInt(this.szam.charAt(0)+"");
    }
    public int getEv(){
        return  Integer.parseInt(this.getEgyszerusitettSzemelyiSzam().charAt(1)+""+this.getEgyszerusitettSzemelyiSzam().charAt(2));
    }
    public int getSzuletesiEv(){
        int ev= this.getEv();
        if (ev>=97 && ev<=99){
            ev+=1990;

        }else {
            ev+=2000;
        }
        return ev;
    }





    public int getHonap(){
        return  Integer.parseInt(this.getEgyszerusitettSzemelyiSzam().charAt(3)+""+this.getEgyszerusitettSzemelyiSzam().charAt(4));
    }
    public int getNap(){
        return  Integer.parseInt(this.getEgyszerusitettSzemelyiSzam().charAt(5)+""+this.getEgyszerusitettSzemelyiSzam().charAt(6));
    }
    public int getSorszam(){
        return  Integer.parseInt(this.getEgyszerusitettSzemelyiSzam().substring(7,10));
    }
    public int getK(){
        return  Integer.parseInt(this.getEgyszerusitettSzemelyiSzam().charAt(10)+"");
    }

    public boolean CdvEll(){
        int s=0;
        for (int i=0; i<10;i++){
            int szamjegy=Integer.parseInt(this.getEgyszerusitettSzemelyiSzam().charAt(i)+"");
            s+= szamjegy*(10-i);
        }
        return s%11==this.getK();
    }
    public boolean isFiuE(){
        return  (this.getM()==1 || this.getM()==3);
    }
    public boolean isSzokoEvE(){
        return this.getSzuletesiEv()%4==0;
    }

    @Override
    public String toString() {
        return this.szam;
    }
}
