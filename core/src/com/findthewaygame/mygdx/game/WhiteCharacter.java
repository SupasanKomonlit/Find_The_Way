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
		this.RealX = StartX*this.Map.SizeBlock;
		this.RealY = StartY*this.Map.SizeBlock;
	}

	public void DrawPicture() {
		DrawPlayer.begin();
		DrawPlayer.draw(WhiteCircle,RealX,RealY);
		if(this.Game.CheckMap.ReadMap(this.RealX+(this.Map.SizeBlock/2), this.RealY+(this.Map.SizeBlock/2))==9) {
			this.Game.GameStatus = "YouWin";
			this.Game.Main.StateGame = "GameResult";
			this.Game.DataMap.dispose();
			this.Game.Main.create();
		}
		DrawPlayer.end();
	}
	
}
