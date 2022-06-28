package game.body;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpikeEvent implements ActionListener {
    private Spike s;

    public SpikeEvent(Spike s){
        this.s = s;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        s.toogleArmed();
    }
}
