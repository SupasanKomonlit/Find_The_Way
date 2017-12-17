package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WhiteCharacter {
	public int RealX;
	public int RealY;
	public int Speed;
	
	private Texture WhiteCircle = new Texture("WhiteCircle.png");
	public DrawMap Map;
	private GameRunning Game;
	private SpriteBatch DrawPlayer = new SpriteBatch();
	
	public WhiteCharacter(int StartX, int StartY, DrawMap Map, GameRunning Game) {
		this.Map = Map;
		this.Game = Game;
		this.Speed = this.Game.NormalSpeed;
		RealX = StartX*this.Map.SizeBlock;
		RealY = StartY*this.Map.SizeBlock;
	}
	
	public void DrawPicture() {
		DrawPlayer.begin();
		DrawPlayer.draw(WhiteCircle,RealX,RealY);
		DrawPlayer.end();
	}
	
}
