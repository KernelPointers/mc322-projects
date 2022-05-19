package pt.c40task.l05wumpus;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      Cave world = new World(); // rever instanciacao da caverna
      
      String cave[][] = tk.retrieveCave(); // matriz inicial dado arquivo cave.csv
      
      Maker init = new Maker();
      init.mount(cave, world);
      
      System.out.println("=== Caverna");
      for (int l = 0; l < cave.length; l++) {
         for (int c = 0; c < cave[l].length; c++)
            System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
         System.out.println();
      }

      movements = tk.retrieveMovements()
        
      Control controller = new Control(movements);

      controller.move();

      if (arquivoMovimentos == null) { //rever
         Control.Move();

      }
      else {
         String movements = tk.retrieveMovements();  
      
      }

      tk.writeBoard(finalCave, score, status);
      
      tk.stop();
   }
}
