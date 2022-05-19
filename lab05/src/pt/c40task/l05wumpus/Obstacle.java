public class Obstacle extends Components{

    public void setSec(){
        Cave c = this.world;
        int dim = c.getNum();
        char name;

        if (this.id == 'W')
            name = 'f';
        else
            name = 'v';

        if (j - 1 > -1){
            Secondary s1 = new Secondary(i, j - 1, name);
            c.addComp(s1, i, j - 1);
        
        }if (j < dim){
            Secondary s2 = new Secondary(i, j + 1, name);
            c.addComp(s2, i, j - 1);
            
        }if (i - 1 > -1){
            Secondary s3 = new Secondary(i - 1, j, name);
            c.addComp(s3, i, j - 1);

        }if (i < dim){
            Secondary s4 = new Secondary(i + 1, j, name);
            c.addComp(s4, i, j - 1);
        } 

    }
}
