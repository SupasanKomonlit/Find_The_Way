package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class EnemyCharacter {
	//type 1 start at number 2
	public int CountType1;
	public int CountType2;
	private GameRunning Game;
	private int[][] ArrayMap;
	public YellowCharacter[] EnemyType01;
	
	public EnemyCharacter(GameRunning Game) {
		this.Game = Game;
		this.ArrayMap = this.Game.DataMap.ArrayMap;
		CountType1 = CountEnemy(2);
		this.EnemyType01 = new YellowCharacter[CountType1];
		CreateEnemy(2);
		System.out.println("CountType1 : "+CountType1+" EnemyType01.Length : "+this.EnemyType01.length);
	}
	
	public void DrawPicture() {
		for(int Count = 0 ; Count < this.CountType1 ; Count++)
			this.EnemyType01[Count].DrawPicture();
	}
	
	private void CreateEnemy(int Type) {
		int Count = 0;
		for(int x = 0; x < this.Game.DataMap.AllX; x++) {
			for(int y = 0; y < this.Game.DataMap.AllY; y++) {
				if(this.ArrayMap[x][y] == Type & (Type == 2)) {
					this.EnemyType01[Count] =new YellowCharacter(x, y, this.Game.DataMap, this.Game);
					Count++;
				}
			}
		}
	}

	private int CountEnemy(int Type) {
		int Count = 0;
		for(int x = 0; x < this.Game.DataMap.AllX ; x++)
			for(int y = 0; y < this.Game.DataMap.AllY; y++)
				if(this.ArrayMap[x][y] == 2)
					Count++;
		return Count;
	}
}
