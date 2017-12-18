package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends ApplicationAdapter {
	public SpriteBatch MainBatch;
	public String StateGame;
	public int NumMap;
	public int width;
	public int height;
	private GameRunning ManageGameRunning;
	private MainInterface ManageInterface;

//for testing int
//	private int Result = 26/25;
	
// About Map	
	public int SizeBlock = 25;	
	
	public MainGame(int width, int height) {
		//width = 1200
		//height = 700
		this.width = width;
		this.height = height;
		this.StateGame = "MainInterface";
		this.NumMap = 1;
	}
	@Override
	public void create () {
		if(this.StateGame == "GameRunning") {
			System.out.println("Hello in create in GameRunning");
			this.ManageGameRunning = new GameRunning(this);
		}
		else if(this.StateGame == "MainInterface") {
			System.out.println("Hello in create in Interface01");
			this.ManageInterface = new MainInterface(this);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(this.StateGame == "GameRunning")
			this.ManageGameRunning.Draw();
		else if(this.StateGame == "MainInterface")
			this.ManageInterface.Draw();
//		DataMap.DrawBlock();
//		System.out.println("Test int : "+this.Result);

	}
	
	@Override
	public void dispose () {

	}
}
