package com.findthewaygame.mygdx.game;

public class Wall {
	public DrawMap Map;
	public GameRunning Game;
	public int[][] MapArray;
	private int CheckX;
	private int CheckY;
	public BlinkToGap BlinkIt = new BlinkToGap();
	
	
// [0] is X and [1] is Y
	public int[] LeftBottomCorner = new int[2];
	public int[] RightBottomCorner = new int[2];
	public int[] LeftTopCorner = new int[2];
	public int[] RightTopCorner = new int[2];
	
	public Wall(DrawMap Map, GameRunning GameRun) {
		this.Map = Map;
		this.Game = GameRun;
	}
	
	private void UpdateMap() {
		this.MapArray = this.Map.ArrayMap;
	}
//return boolean
/*
	public boolean Check(WhiteCharacter Character, String Direction) {
		this.UpdateMap();
// Get Value for Check Movement
		int PointX = Character.RealX;
		int PointY = Character.RealY;
		int Speed = Character.Speed;
		this.LeftBottomCorner[0] = this.LeftTopCorner[0] = PointX;
		this.LeftBottomCorner[1] = this.RightBottomCorner[1] = PointY;
		this.RightBottomCorner[0] = this.RightTopCorner[0] = PointX + this.Map.SizeBlock;
		this.LeftTopCorner[1] = this.RightTopCorner[1] = PointY + this.Map.SizeBlock;
		if(Direction == "Right") {
			 CheckX = (this.RightBottomCorner[0] + Speed)/this.Map.SizeBlock;
			 CheckY = (this.RightBottomCorner[1] + 1)/this.Map.SizeBlock;
			 System.out.println("Line 39 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			 if(this.Map.ArrayMap[CheckX][CheckY]==1)
				 return false;
			 CheckX = (this.RightTopCorner[0] + Speed)/this.Map.SizeBlock;
			 CheckY = (this.RightTopCorner[1] - 1)/this.Map.SizeBlock;
			 System.out.println("Line 44 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			 if(this.Map.ArrayMap[CheckX][CheckY]==1)
				 return false;
			 return true;
		}
		else if(Direction == "Left") {
			CheckX = (this.LeftBottomCorner[0] - Speed)/this.Map.SizeBlock;
			CheckY = (this.LeftBottomCorner[1] + 1 )/this.Map.SizeBlock;
			System.out.println("Line 52 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			if(this.Map.ArrayMap[CheckX][CheckY]==1)
				return false;
			CheckX = (this.LeftTopCorner[0] - Speed)/this.Map.SizeBlock;
			CheckY = (this.LeftTopCorner[1] - 1)/this.Map.SizeBlock;
			System.out.println("Line 57 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			if(this.Map.ArrayMap[CheckX][CheckY]==1)
				return false;
			return true;
		}
		else if(Direction == "Up") {
			CheckX = (this.RightTopCorner[0] - 1)/this.Map.SizeBlock;
			CheckY = (this.RightTopCorner[1] + Speed)/this.Map.SizeBlock;
			System.out.println("Line 65 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			if(this.Map.ArrayMap[CheckX][CheckY]==1)
				return false;
			CheckX = (this.LeftTopCorner[0] + 1)/this.Map.SizeBlock;
			CheckY = (this.LeftTopCorner[1] + Speed)/this.Map.SizeBlock;
			System.out.println("Line 70 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			if(this.Map.ArrayMap[CheckX][CheckY]==1)
				return false;
			return true;
		}
		else {
			CheckX = (this.RightBottomCorner[0] - 1)/this.Map.SizeBlock;
			CheckY = (this.RightBottomCorner[1] - Speed)/this.Map.SizeBlock;
			System.out.println("Line 76 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			if(this.Map.ArrayMap[CheckX][CheckY]==1)
				return false;
			CheckX = (this.LeftBottomCorner[0] + 1)/this.Map.SizeBlock;
			CheckY = (this.LeftBottomCorner[1] - Speed)/this.Map.SizeBlock;
			System.out.println("Line 83 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
			if(this.Map.ArrayMap[CheckX][CheckY]==1)
				return false;
			return true;
		}
	}
	
	public boolean Check(YellowCharacter Character, String Direction) {
		this.UpdateMap();
// Get Value for Check Movement
		int PointX = Character.RealX;
		int PointY = Character.RealY;
		int Speed = Character.Speed;
		this.LeftBottomCorner[0] = this.LeftTopCorner[0] = PointX;
		this.LeftBottomCorner[1] = this.RightBottomCorner[1] = PointY;
		this.RightBottomCorner[0] = this.RightTopCorner[0] = PointX + this.Map.SizeBlock;
		this.LeftTopCorner[1] = this.RightTopCorner[1] = PointY + this.Map.SizeBlock;
		for(Speed = Character.Speed ; Speed > 0; Speed -= 1) {
			if(Direction == "Right") {
				CheckX = (this.RightBottomCorner[0] + Speed)/this.Map.SizeBlock;
				CheckY = (this.RightBottomCorner[1] + 1)/this.Map.SizeBlock;
				System.out.println("Line 39 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				CheckX = (this.RightTopCorner[0] + Speed)/this.Map.SizeBlock;
				CheckY = (this.RightTopCorner[1] - 1)/this.Map.SizeBlock;
				System.out.println("Line 44 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				return true;
			}
			else if(Direction == "Left") {
				CheckX = (this.LeftBottomCorner[0] - Speed)/this.Map.SizeBlock;
				CheckY = (this.LeftBottomCorner[1] + 1 )/this.Map.SizeBlock;
				System.out.println("Line 52 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				CheckX = (this.LeftTopCorner[0] - Speed)/this.Map.SizeBlock;
				CheckY = (this.LeftTopCorner[1] - 1)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				return true;
			}
			else if(Direction == "Up") {
				CheckX = (this.RightTopCorner[0] - 1)/this.Map.SizeBlock;
				CheckY = (this.RightTopCorner[1] + Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				CheckX = (this.LeftTopCorner[0] + 1)/this.Map.SizeBlock;
				CheckY = (this.LeftTopCorner[1] + Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				return true;
			}
			else {
				CheckX = (this.RightBottomCorner[0] - 1)/this.Map.SizeBlock;
				CheckY = (this.RightBottomCorner[1] - Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				CheckX = (this.LeftBottomCorner[0] + 1)/this.Map.SizeBlock;
				CheckY = (this.LeftBottomCorner[1] - Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					return false;
				return true;
			}
		}
		return false;
	}*/
// return int
	public int Check(WhiteCharacter Character, String Direction) {
		this.UpdateMap();
//Get Value for Check Movement
		int PointX = Character.RealX;
		int PointY = Character.RealY;
		int Speed = Character.Speed;
		this.LeftBottomCorner[0] = this.LeftTopCorner[0] = PointX;
		this.LeftBottomCorner[1] = this.RightBottomCorner[1] = PointY;
		this.RightBottomCorner[0] = this.RightTopCorner[0] = PointX + this.Map.SizeBlock;
		this.LeftTopCorner[1] = this.RightTopCorner[1] = PointY + this.Map.SizeBlock;
		for(Speed = Character.Speed ; Speed > 0; Speed -= 1) {
			if(Direction == "Right") {
				CheckX = (this.RightBottomCorner[0] + Speed)/this.Map.SizeBlock;
				CheckY = (this.RightBottomCorner[1] + 1)/this.Map.SizeBlock;
				//System.out.println("Line 39 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1) 
					continue;
				CheckX = (this.RightTopCorner[0] + Speed)/this.Map.SizeBlock;
				CheckY = (this.RightTopCorner[1] - 1)/this.Map.SizeBlock;
				//System.out.println("Line 44 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
			else if(Direction == "Left") {
				CheckX = (this.LeftBottomCorner[0] - Speed)/this.Map.SizeBlock;
				CheckY = (this.LeftBottomCorner[1] + 1 )/this.Map.SizeBlock;
				//System.out.println("Line 52 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				CheckX = (this.LeftTopCorner[0] - Speed)/this.Map.SizeBlock;
				CheckY = (this.LeftTopCorner[1] - 1)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
			else if(Direction == "Up") {
				CheckX = (this.RightTopCorner[0] - 1)/this.Map.SizeBlock;
				CheckY = (this.RightTopCorner[1] + Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				CheckX = (this.LeftTopCorner[0] + 1)/this.Map.SizeBlock;
				CheckY = (this.LeftTopCorner[1] + Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
			else {
				CheckX = (this.RightBottomCorner[0] - 1)/this.Map.SizeBlock;
				CheckY = (this.RightBottomCorner[1] - Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				CheckX = (this.LeftBottomCorner[0] + 1)/this.Map.SizeBlock;
				CheckY = (this.LeftBottomCorner[1] - Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
		}
		this.BlinkIt.Blink(this, Character, Direction);
		return 0;
	}		
	
	public int Check(YellowCharacter Character, String Direction) {
		this.UpdateMap();
//Get Value for Check Movement
		int PointX = Character.RealX;
		int PointY = Character.RealY;
		int Speed = Character.Speed;
		this.LeftBottomCorner[0] = this.LeftTopCorner[0] = PointX;
		this.LeftBottomCorner[1] = this.RightBottomCorner[1] = PointY;
		this.RightBottomCorner[0] = this.RightTopCorner[0] = PointX + this.Map.SizeBlock;
		this.LeftTopCorner[1] = this.RightTopCorner[1] = PointY + this.Map.SizeBlock;
		for(Speed = Character.Speed ; Speed > 0; Speed -= 1) {
			if(Direction == "Right") {
				CheckX = (this.RightBottomCorner[0] + Speed)/this.Map.SizeBlock;
				CheckY = (this.RightBottomCorner[1] + 1)/this.Map.SizeBlock;
				//System.out.println("Line 39 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1) 
					continue;
				CheckX = (this.RightTopCorner[0] + Speed)/this.Map.SizeBlock;
				CheckY = (this.RightTopCorner[1] - 1)/this.Map.SizeBlock;
				//System.out.println("Line 44 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
			else if(Direction == "Left") {
				CheckX = (this.LeftBottomCorner[0] - Speed)/this.Map.SizeBlock;
				CheckY = (this.LeftBottomCorner[1] + 1 )/this.Map.SizeBlock;
				//System.out.println("Line 52 : "+CheckX+" "+CheckY + "   Value of Map : "+this.Map.ArrayMap[CheckX][CheckY]);
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				CheckX = (this.LeftTopCorner[0] - Speed)/this.Map.SizeBlock;
				CheckY = (this.LeftTopCorner[1] - 1)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
			else if(Direction == "Up") {
				CheckX = (this.RightTopCorner[0] - 1)/this.Map.SizeBlock;
				CheckY = (this.RightTopCorner[1] + Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				CheckX = (this.LeftTopCorner[0] + 1)/this.Map.SizeBlock;
				CheckY = (this.LeftTopCorner[1] + Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
			else {
				CheckX = (this.RightBottomCorner[0] - 1)/this.Map.SizeBlock;
				CheckY = (this.RightBottomCorner[1] - Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				CheckX = (this.LeftBottomCorner[0] + 1)/this.Map.SizeBlock;
				CheckY = (this.LeftBottomCorner[1] - Speed)/this.Map.SizeBlock;
				if(this.Map.ArrayMap[CheckX][CheckY]==1)
					continue;
				return Speed;
			}
		}
		this.BlinkIt.Blink(this, Character, Direction);
		return 0;
	}	
}
