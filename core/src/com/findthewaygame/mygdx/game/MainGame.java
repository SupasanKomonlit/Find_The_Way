package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends ApplicationAdapter {
	public SpriteBatch MainBatch;
	public String StateGame;
	public Texture NowLoading;
	public int NumMap;
	public int width;
	public int height;
	private GameRunning ManageGameRunning;
	private MainInterface ManageInterface;
	private AfterGameInterface GameResult;

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
			this.StateGame = "DrawGameRunning";
		}
		else if(this.StateGame == "MainInterface") {
			System.out.println("Hello in create in MainInterface");
			this.ManageInterface = new MainInterface(this);
			this.StateGame = "DrawMainInterface";
		}
		else if(this.StateGame == "GameResult") {
			System.out.println("Hello in create in GameResult");
			this.GameResult = new AfterGameInterface(this, this.ManageGameRunning);
			this.StateGame = "DrawGameResult";
		}
		else if(this.StateGame == "NowLoading") {
			System.out.println("Hello in create in NowLoading");
			this.NowLoading = new Texture("Text_NowLoading_Size44.png");
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//System.out.println("Before check case");
		if(this.StateGame == "DrawGameRunning")
			this.ManageGameRunning.Draw();
		else if(this.StateGame == "DrawMainInterface")
			this.ManageInterface.Draw();
		else if(this.StateGame == "DrawGameResult")
			this.GameResult.Draw();
	}
//		DataMap.DrawBlock();
//		System.out.println("Test int : "+this.Result);

	
	
	@Override
	public void dispose () {

	}
}
