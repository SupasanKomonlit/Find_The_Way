package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends ApplicationAdapter {
	public SpriteBatch MainBatch;
	public String StateGame = "GameRunning";
	public int NumMap = 1;
	public int width;
	public int height;
	private GameRunning ManageGameRunning;

//for testing int
//	private int Result = 26/25;
	
// About Map	
	public int SizeBlock = 25;
	
	public MainGame(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void create () {
		if(this.StateGame == "GameRunning") {
			System.out.println("Hello in create");
			ManageGameRunning = new GameRunning(this);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(this.StateGame == "GameRunning")
			ManageGameRunning.Draw();
//		DataMap.DrawBlock();
//		System.out.println("Test int : "+this.Result);

	}
	
	@Override
	public void dispose () {

	}
}
