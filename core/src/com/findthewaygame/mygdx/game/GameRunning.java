package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class GameRunning {
	public DrawMap DataMap;
	public MainGame Main;
	public WhiteCharacter Player;
	public EnemyCharacter Enemy;
	public int NormalSpeed = 5;
	public int FastSpeed = 10;
	public Wall Wall;
	public CheckMap CheckMap;
	public String GameStatus = "GamePlay";
	public int Type = 0;
	public CheckHero CheckCharacter;
	
	public GameRunning(MainGame Main) {
		this.DataMap = new DrawMap(Main.SizeBlock, Main.width/Main.SizeBlock, Main.height/Main.SizeBlock, Main.NumMap);
		this.Main = Main;
		this.Wall = new Wall(this.DataMap, this);
		this.CheckMap = new CheckMap(this.DataMap, this);
		this.Player = new WhiteCharacter(1,1,this.DataMap , this);
		this.Enemy = new EnemyCharacter(this);
		this.CheckCharacter = new CheckHero(this.DataMap);
	}
	
	public void Draw() {
		CheckKey();
		this.DataMap.DrawBlock();
		this.Player.DrawPicture();
		this.Enemy.DrawPicture();
	}
	
	public void CheckKey() {
//		System.out.println("In Check Key GameRunning");
        if(Gdx.input.isKeyPressed(Keys.LEFT))
        	//if (Wall.Check(this.Player, "Left"))
        		//this.Player.RealX -= this.Player.Speed;
        	this.Player.RealX -= Wall.Check(this.Player, "Left");
        
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) 
        	//if (Wall.Check(this.Player, "Right")) 
        		//this.Player.RealX += this.Player.Speed;
        	this.Player.RealX += Wall.Check(this.Player, "Right");
        
        if(Gdx.input.isKeyPressed(Keys.UP)) 
        	//if (Wall.Check(this.Player, "Up")) 
        		//this.Player.RealY += this.Player.Speed;
        	this.Player.RealY += Wall.Check(this.Player, "Up");
        
        if(Gdx.input.isKeyPressed(Keys.DOWN)) 
        	//if (Wall.Check(this.Player, "Down"))
        		//this.Player.RealY -= this.Player.Speed;
        	this.Player.RealY -= Wall.Check(this.Player, "Down");
	}
}
