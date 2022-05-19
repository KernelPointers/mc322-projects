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

      world.connectOut(tk);
      
      String inputCave[][] = tk.retrieveCave(); // matriz inicial dado arquivo cave.csv
      
      String movements = tk.retrieveMovements();

      Control controller = new Control(movements);

      Maker init = new Maker();
      init.mount(inputCave, world, controller);

      controller.moveControl();

      tk.stop();
   }
}
