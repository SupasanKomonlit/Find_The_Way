package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainInterface {
	public MainGame Main;
	public String Status;
	public SpriteBatch TextSprite = new SpriteBatch();
	//public Texture TestSize36 = new Texture("Text_Test_Size36.png");
	//public Texture TestSize40 = new Texture("Text_Test_Size40.png");
	// Screen Width = 1200 Height = 700
	// 1 cm = 28.4 pi
	// width = 13.8 cm 
	private Texture StartGame = new Texture("Text_StartGame_Size40.png");
	private Texture ChooseMap = new Texture("Text_ChooseMap_Size40.png");
	private Texture GreenCircle = new Texture("GreenCircle.png");
	// width = 15.2
	private Texture PressRight = new Texture("Text_PressRight_Size32.png");
	private int Point = 0;
	
	private float MiddleScreen;
	
	public MainInterface(MainGame Main) {
		this.Main = Main;
		this.Status = "MainInterface";
		this.MiddleScreen = this.Main.width/2;
	}
	
	public void Draw() {
		this.Checkkey();
		if(this.Status == "MainInterface") {
			System.out.println("This is in draw MainInterface");
			this.TextSprite.begin();
			//this.TextSprite.draw(this.TestSize36,200,200);
			//this.TextSprite.draw(this.TestSize40,200,160);
			this.TextSprite.draw(this.StartGame, (float)(this.MiddleScreen - (13.8*14.2)), (float)(450));
			this.TextSprite.draw(this.ChooseMap, (float)(this.MiddleScreen - (13.8*14.2)), (float)(250));
			if(this.Point == 0)
				this.TextSprite.draw(this.GreenCircle, (float)(this.MiddleScreen -(13*14.2)), (float)(465));
			else
				this.TextSprite.draw(this.GreenCircle, (float)(this.MiddleScreen - (13.7*14.2)), (float)(330));
			this.TextSprite.draw(PressRight, (float)(this.Main.width-(15.5*28.4)), (float)10);
			this.TextSprite.end();
		}
	}
	
	private void Checkkey() {
		if(this.Status == "MainInterface")
			if(Gdx.input.isKeyJustPressed(Keys.UP)) 
				this.Point = (this.Point - 1)%2;
		
			else if(Gdx.input.isKeyJustPressed(Keys.DOWN))
				this.Point = (this.Point + 1)%2;
		
			else if(Gdx.input.isKeyJustPressed(Keys.RIGHT))
				if(this.Point == 0) {
					//this.Main.NumMap = 0;
					this.Main.StateGame = "GameRunning";
					this.Main.create();
					this.dispose();
				}
	}
	
	private void dispose() {
		this.PressRight.dispose();
		this.StartGame.dispose();
		this.ChooseMap.dispose();
		this.GreenCircle.dispose();
	}
}
