package com.findthewaygame.mygdx.game;

public class CheckMap {
	private DrawMap Map;
	private GameRunning Game;
	private int[][] MapArray;
	
	public CheckMap(DrawMap Map, GameRunning GameRun) {
		this.Map = Map;
		this.Game = GameRun;
	}
	
	private void UpdateMap() {
		this.MapArray = this.Map.ArrayMap;
	}
	
	public int ReadMap(int PointX, int PointY) {
		this.UpdateMap();
		//System.out.println("PointX,PointY    "+PointX+"    "+PointY);
	//	System.out.println("Array01,Array02    "+((PointX/this.Map.SizeBlock))+"    "+((PointY/this.Map.SizeBlock)));
	//	System.out.println(this.MapArray[(PointX/this.Map.SizeBlock)][(PointY/this.Map.SizeBlock)]);
		return this.MapArray[(PointX/this.Map.SizeBlock)][(PointY/this.Map.SizeBlock)];
	}
}
