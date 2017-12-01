package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends ApplicationAdapter {
	public SpriteBatch batch;
	private int width;
	private int height;
	private DrawMap DataMap;
	private int size_block = 25;
	public MainGame(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void create () {
		System.out.println("Hello in create");
		batch = new SpriteBatch();
		DataMap = new DrawMap(size_block, width/size_block, height/size_block);
//		System.out.println("test " + data_map.array_map[0][10]);
//		data_map.Draw_Rectangle();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		DataMap.DrawBlock();

	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
