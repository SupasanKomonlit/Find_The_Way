package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends ApplicationAdapter {
	public SpriteBatch Test;
	public String StateGame = "GameRunning";
	public int NumMap = 1;
	private int width;
	private int height;
	private DrawMap DataMap;
	public int SizeBlock = 25;
	public MainGame(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void create () {
		if(this.StateGame == "GameRunning") {
			System.out.println("Hello in create");
			Test = new SpriteBatch();
			DataMap = new DrawMap(SizeBlock, width/SizeBlock, height/SizeBlock, this.NumMap);
//		System.out.println("test " + data_map.array_map[0][10]);
//		data_map.Draw_Rectangle();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		DataMap.DrawBlock();

	}
	
	@Override
	public void dispose () {
		Test.dispose();

	}
}
