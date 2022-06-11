package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Builder.Maker;




/* 
 *ARQUIVO CSV TEM ESPACOS ADICONAIS NO FINAL DE CADA LINHA
 *REVER  !!!!! 
 */

public class AppGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img_player, img_cell, img_box;
	Maker maker;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img_player = new Texture("player_temp.jpg");
        img_cell = new Texture("cell_temp.jpg");
        img_box = new Texture("box_temp.jpg");
		this.maker = new Maker();
		this.maker.make(0);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		  
		this.maker.input = this.maker.input.replaceAll("\\s","");
		int n = 15;

		for (int i = 0; i < n * n; i++){
				int y = (i / 15) * 45;
				int x = (i % 15) * 45;

				char c = this.maker.input.charAt(i);
				if (c == '-'){
					batch.draw(img_cell, x, y, 25, 25);

				} else if (c == '0') {
					batch.draw(img_box, x, y, 25, 25);

				} else if (c == '1'){
					batch.draw(img_player, x, y, 25, 25);

				}
			
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img_player.dispose();
        img_cell.dispose();
	}
}
