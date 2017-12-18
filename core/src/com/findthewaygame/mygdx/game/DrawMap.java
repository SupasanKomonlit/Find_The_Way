package com.findthewaygame.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DrawMap {
	public int[][] ArrayMap;
	public int AllX;
	public int AllY;
	public int SizeBlock;
	public SetMap SetArrayMap = new SetMap();
	private Texture WhiteBlock = new Texture("WhiteBlock.png");
	private Texture GreenBlock = new Texture("GreenBlock.png");
	private Texture BlackBlock = new Texture("BlackBlock.png");
	private Texture WallBlock = new Texture("WallBlock.png");
	public SpriteBatch BlockSprite = new SpriteBatch();
	
	public DrawMap(int SizeBlock, int AllX, int AllY, int NumMap) {
		this.ArrayMap = new int[AllX][AllY];
		System.out.println("SizeBlock " + SizeBlock);
		System.out.println("AllX " +AllX);
		System.out.println("AllY " +AllY);
		this.AllX = AllX;
		this.AllY = AllY;
		this.SizeBlock = SizeBlock;	
		this.ArrayMap = SetArrayMap.SetUpMap(NumMap, this.AllX, this.AllY);
/*		for(int x = 0; x < AllX; x++) {
			for(int y = 0; y < AllY; y++) {
				ArrayMap[x][y] = 0;
			}
		}*/
	}
	
	public void DrawBlock(){
		BlockSprite.begin();
		//System.out.println("In Draw Block");
		for(int x = 0; x < AllX; x++) {
			for(int y = 0; y< AllY; y++) {
				if(ArrayMap[x][y] == 0 | ArrayMap[x][y] == 2)
					BlockSprite.draw(BlackBlock, (x*SizeBlock), (y*SizeBlock));
				else if(ArrayMap[x][y] == 1)
					BlockSprite.draw(WallBlock, (x*SizeBlock), (y*SizeBlock));
				else if(ArrayMap[x][y] == 8)
					//BlockSprite.draw(GreenBlock, (x*SizeBlock), (y*SizeBlock));
					BlockSprite.draw(BlackBlock, (x*SizeBlock), (y*SizeBlock));
			}
		}
		BlockSprite.end();
	}
	
	public void dispose() {
		this.WallBlock.dispose();
		this.BlackBlock.dispose();
		this.GreenBlock.dispose();
		this.WhiteBlock.dispose();
		this.BlockSprite.dispose();
	}
}
