package com.findthewaygame.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class DrawMap {
	public int[][] ArrayMap;
	private int AllX;
	private int AllY;
	private int SizeBlock;
	private Texture WhiteBlock = new Texture("WhiteBlock.png");
	private Texture BlackBlock = new Texture("BlackBlock.png");
	private Texture WallBlock = new Texture("WallBlock.png");
	public SpriteBatch BlockSprite = new SpriteBatch();
	
	public DrawMap(int SizeBlock, int AllX, int AllY) {
		this.ArrayMap = new int[AllX][AllY];
		System.out.println("SizeBlock " +SizeBlock);
		System.out.println("AllX " +AllX);
		System.out.println("AllY " +AllY);
		this.AllX = AllX;
		this.AllY = AllY;
		this.SizeBlock = SizeBlock;
		for(int x = 0; x < AllX; x++) {
			for(int y = 0; y < AllY; y++) {
				ArrayMap[x][y] = 0;
			}
		}
	}
	
	public void DrawBlock(){
		BlockSprite.begin();
		System.out.println("In Draw Block");
		for(int x = 0; x < AllX; x++) {
			for(int y = 0; y< AllY; y++) {
				BlockSprite.draw(BlackBlock, (x*SizeBlock), (y*SizeBlock));
			}
		}
		BlockSprite.end();
	}
}
