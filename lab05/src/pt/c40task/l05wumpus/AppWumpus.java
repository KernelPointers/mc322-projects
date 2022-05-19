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
      
      Cave world = new Cave(); // rever instanciacao da caverna
      
      String inputCave[][] = tk.retrieveCave(); // matriz inicial dado arquivo cave.csv
      
      Maker init = new Maker();
      init.mount(inputCave, world);
      
      System.out.println("=== Caverna");

    // for (){

        // world.displayCave();



        // world.updateCave();
    // }

      for (int l = 0; l < inputCave.length; l++) {
         for (int c = 0; c < inputCave[l].length; c++)
            System.out.print(inputCave[l][c] + ((c < inputCave[l].length-1) ? ", " : ""));
         System.out.println();
      }

      String movements = tk.retrieveMovements();

      Control controller = new Control(movements);

      controller.moveControl();

      tk.stop();
   }
}
