public class Hole extends Enemy {

    public Hole(int i, int j){
        this.i = i;
        this.j = j;

    }
    

    public void setWind(){
        int dim = this.world.num;

        if (j - 1 > -1){
            Wind w1 = new Wind(i, j - 1);
            this.world.addComp(s1, i, j - 1);
        
        }if (j < dim){
            Wind w2 = new Wind(i, j + 1);
            this.world.addComp(s2, i, j - 1);
            
        }if (i - 1 > -1){
            Wind w3 = new Wind(i - 1, j);
            this.world.addComp(s3, i, j - 1);

        }if (i < dim){
            Wind w4 = new Wind(i + 1, j);
            this.world.addComp(s4, i, j - 1);
        } 

    }

}
