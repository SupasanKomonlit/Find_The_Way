package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AfterGameInterface {
	private SpriteBatch TextSprite = new SpriteBatch();
	// 1cm = 28.4 pi
	//width 10.8
	private Texture GameLose = new Texture("Text_YouLose_Size48.png");
	private Texture Type01 = new Texture("Text_Type01_Size36.png");
	private Texture Type02 = new Texture("Text_Type02_Size36.png");
	private Texture Type03 = new Texture("Text_Type03_Size36.png");
	private Texture Type04 = new Texture("Text_Type04_Size36.png");
	private Texture GameWin = new Texture("Text_YouWin_Size48.png");
	private float Distance10;
	//widht 9.8
	private Texture PlayAgain = new Texture("Text_PlayAgain_Size40.png");
	private Texture NextMap = new Texture("Text_NextMap_Size40.png");
	private Texture NextMap2 = new Texture("Text_NextMap_Size40_2.png");
	private Texture MainMenu = new Texture("Text_MainMenu_Size40.png");
	private float Distance9;
	//widht 15.2
	private Texture PressRight = new Texture("Text_PressRight_Size32.png");
	private float Distance15;
	
	private Texture GreenCircle = new Texture("GreenCircle.png");
	private int Point = 0;
	
	private MainGame Main;
	private GameRunning Game;

	public AfterGameInterface(MainGame Main, GameRunning Game) {
		this.Main = Main;
		this.Game = Game;
		this.Distance9 = (float)(this.Main.width/2-(10*14.2));
		this.Distance10 = (float)(this.Main.width/2-(11*14.2));
		this.Distance15 = (float)(this.Main.width-(15.4*28.4));
	}
	
	public void Draw() {
		this.Check();
		this.TextSprite.begin();
		if(this.Game.GameStatus == "YouLose") {
			this.TextSprite.draw(this.GameLose, this.Distance10, 520);
			if(this.Game.Type == 1)
				this.TextSprite.draw(Type01, Distance10, 440);
			else if(this.Game.Type == 2)
				this.TextSprite.draw(Type02, Distance10, 440);
			else if(this.Game.Type == 3)
				this.TextSprite.draw(Type03, Distance10, 440);
			else if(this.Game.Type == 4)
				this.TextSprite.draw(Type04, Distance10, 440);
			else {}
			//this.TextSprite.draw(NextMap, Distance9, 400);
			this.TextSprite.draw(PlayAgain, this.Distance9, 300);
			this.TextSprite.draw(MainMenu, Distance9, 220);
			if(this.Point == 0)
				this.TextSprite.draw(GreenCircle, Distance9 - 40, 315);
			else if(this.Point == 1)
				this.TextSprite.draw(this.GreenCircle, this.Distance9 - 40, 235);
		}
		else if(this.Game.GameStatus == "YouWin") {
			this.TextSprite.draw(this.GameWin, this.Distance10, 520);
			if(this.Game.Main.NumMap<this.Game.DataMap.SetArrayMap.MaxMap)
				this.TextSprite.draw(NextMap, Distance9, 380);
			else
				this.TextSprite.draw(NextMap2, Distance9, 380);
			this.TextSprite.draw(PlayAgain, this.Distance9, 300);
			this.TextSprite.draw(MainMenu, Distance9, 220);
			if(this.Point == 0)
				this.TextSprite.draw(GreenCircle, Distance9 - 20, 395);
			else if(this.Point == 1)
				this.TextSprite.draw(GreenCircle, Distance9 - 30, 315);
			else if(this.Point == 2)
				this.TextSprite.draw(this.GreenCircle, this.Distance9 - 30, 235);
		}
		this.TextSprite.draw(PressRight, Distance15, 10);
		this.TextSprite.end();
	}
	
	private void Check() {
		if(this.Game.GameStatus == "YouWin") {
			if(Gdx.input.isKeyJustPressed(Keys.UP)) { 
				this.Point = (this.Point - 1)%3;
			}
			else if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
				this.Point = (this.Point + 1)%3;
			}
			else if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
				System.out.println(this.Point);
				if(this.Point == 0) {
					if(this.Game.Main.NumMap<this.Game.DataMap.SetArrayMap.MaxMap) {
						this.Game.Main.NumMap ++;
						this.Game.Main.StateGame = "GameRunning";
						this.Game.Main.create();
					}
				}
				else if(this.Point == 1) {
					this.Game.Main.StateGame = "GameRunning";
//					this.Game.Main.StateGame = "NowLoading";
					this.Game.Main.create();
//					this.dispose();
				}
				else if(this.Point == 2) {
					this.Game.Main.NumMap = 1;
					this.Game.Main.StateGame = "MainInterface";
					this.Game.Main.create();
//					this.dispose();
					System.out.println("Line 101 AfterGameInterface");
				} 
			}
		}
		else if(this.Game.GameStatus == "YouLose") {
			if(Gdx.input.isKeyJustPressed(Keys.UP)) 
				this.Point = (this.Point - 1)%2;
		
			else if(Gdx.input.isKeyJustPressed(Keys.DOWN))
				this.Point = (this.Point + 1)%2;
		
			else if(Gdx.input.isKeyJustPressed(Keys.RIGHT))
				if(this.Point == 0) {
					this.Game.Main.StateGame = "GameRunning";
					this.Game.Main.create();
					//this.dispose();
				}
				else if(this.Point == 1) {
					this.Game.Main.NumMap = 1;
					this.Game.Main.StateGame = "MainInterface";
					this.Game.Main.create();
					//this.dispose();
				} 	
		}
	}
	
	public void dispose() {
		this.TextSprite.dispose();
		this.GameLose.dispose();
		this.GameWin.dispose();
		this.GreenCircle.dispose();
		this.PlayAgain.dispose();
		this.MainMenu.dispose();
		this.PressRight.dispose();
		this.Type01.dispose();
		this.Type02.dispose();
		this.Type03.dispose();
		this.Type04.dispose();
		this.NextMap.dispose();
	}

}
