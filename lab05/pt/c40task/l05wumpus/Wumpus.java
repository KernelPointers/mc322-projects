public class Wumpus {

    public Wumpus(int i, int j){
        this.i = i;
        this.j = j;

    }

    public void setSmell(){
        int dim = this.world.num;
        int pos[][] = {{i, j - 1}, {i, j + 1}, {i - 1, j}, {i + 1, j}}
        if (j - 1 > -1){
            Smell s1 = new Smell(i, j - 1);
            this.world.addComp(s1, i, j - 1);
        
        }if (j < dim){
            Smell s2 = new Smell(i, j + 1);
            this.world.addComp(s2, i, j - 1);
            
        }if (i - 1 > -1){
            Smell s3 = new Smell(i - 1, j);
            this.world.addComp(s3, i, j - 1);

        }if (i < dim){
            Smell s4 = new Smell(i + 1, j);
            this.world.addComp(s4, i, j - 1);
        } 

    }









}
