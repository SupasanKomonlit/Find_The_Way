package com.findthewaygame.mygdx.game;

public class BlinkToGap {
	// [0] is X and [1] is Y
		public int[] LeftBottomCorner = new int[2];
		public int[] RightBottomCorner = new int[2];
		public int[] LeftTopCorner = new int[2];
		public int[] RightTopCorner = new int[2];
		public int HaveBlink = 0;
		
	public BlinkToGap() {
		System.out.println("Welcome To Blink");
	}
	
	public void Blink(Wall Wall, WhiteCharacter Character, String Direction) {
		int PointX = Character.RealX;
		int PointY = Character.RealY;
		this.LeftBottomCorner[0] = this.LeftTopCorner[0] = PointX;
		this.LeftBottomCorner[1] = this.RightBottomCorner[1] = PointY;
		this.RightBottomCorner[0] = this.RightTopCorner[0] = PointX + Wall.Map.SizeBlock;
		this.LeftTopCorner[1] = this.RightTopCorner[1] = PointY + Wall.Map.SizeBlock;
		
		if(Direction == "Right") {
			if(Wall.MapArray[this.RightBottomCorner[0]/Wall.Map.SizeBlock + 1][(this.RightBottomCorner[1]+1)/Wall.Map.SizeBlock] == 1 || Wall.MapArray[this.RightTopCorner[0]/Wall.Map.SizeBlock + 1][(this.RightTopCorner[1]-1)/Wall.Map.SizeBlock] == 1) {
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock +1][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock] != 1) {
					Character.RealY = (PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
				}
			}	
		}
		else if(Direction == "Left") {
			//System.out.println("In Left 1");
			if(Wall.MapArray[(this.LeftBottomCorner[0]+1)/Wall.Map.SizeBlock -1][(this.LeftBottomCorner[1]+1)/Wall.Map.SizeBlock] == 1 || Wall.Map.ArrayMap[(this.LeftTopCorner[0]+1)/Wall.Map.SizeBlock -1][(this.LeftTopCorner[1]-1)/Wall.Map.SizeBlock] == 1) {
				//System.out.println("In Left 2");
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock -1][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock] != 1) {
					//System.out.println("In Left 3");
					Character.RealY = (PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
				}
			}
		}
		else if(Direction == "Up") {
			//System.out.println("In Up");
			if(Wall.MapArray[(this.LeftTopCorner[0]+1)/Wall.Map.SizeBlock][(this.LeftTopCorner[1]-1)/Wall.Map.SizeBlock + 1] == 1 || Wall.MapArray[(this.RightTopCorner[0])/Wall.Map.SizeBlock][(this.RightTopCorner[1]-1)/Wall.Map.SizeBlock + 1] == 1) {
				//System.out.println("In Up 2");
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock + 1] != 1) {
					//System.out.println("In Up 3");
					Character.RealX = (PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
				}
			}
		}
		else if(Direction == "Down"){
			//System.out.println("In Down");
			if(Wall.MapArray[(this.LeftBottomCorner[0]+1)/Wall.Map.SizeBlock][this.LeftBottomCorner[1]/Wall.Map.SizeBlock - 1] == 1 || Wall.MapArray[this.RightBottomCorner[0]/Wall.Map.SizeBlock][this.RightBottomCorner[1]/Wall.Map.SizeBlock -1] ==1) {
				//System.out.println("In Down 2");
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock - 1] != 1) {
					//System.out.println("In Down 3");
					Character.RealX = (PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
				}
			}
		}
		else {
			//System.out.println("Nothing");
		}
	}
	
	public void Blink(Wall Wall, YellowCharacter Character, String Direction) {
		int PointX = Character.RealX;
		int PointY = Character.RealY;
		this.LeftBottomCorner[0] = this.LeftTopCorner[0] = PointX;
		this.LeftBottomCorner[1] = this.RightBottomCorner[1] = PointY;
		this.RightBottomCorner[0] = this.RightTopCorner[0] = PointX + Wall.Map.SizeBlock;
		this.LeftTopCorner[1] = this.RightTopCorner[1] = PointY + Wall.Map.SizeBlock;
		
		if(Direction == "Right") {
			if(Wall.MapArray[this.RightBottomCorner[0]/Wall.Map.SizeBlock + 1][(this.RightBottomCorner[1]+1)/Wall.Map.SizeBlock] == 1 || Wall.MapArray[this.RightTopCorner[0]/Wall.Map.SizeBlock + 1][(this.RightTopCorner[1]-1)/Wall.Map.SizeBlock] == 1) {
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock +1][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock] != 1) {
					Character.RealY = (PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
					this.HaveBlink = 1;
				}
			}	
		}
		else if(Direction == "Left") {
			System.out.println("In Left 1");
			if(Wall.MapArray[(this.LeftBottomCorner[0]+1)/Wall.Map.SizeBlock -1][(this.LeftBottomCorner[1]+1)/Wall.Map.SizeBlock] == 1 || Wall.Map.ArrayMap[(this.LeftTopCorner[0]+1)/Wall.Map.SizeBlock -1][(this.LeftTopCorner[1]-1)/Wall.Map.SizeBlock] == 1) {
				System.out.println("In Left 2");
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock -1][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock] != 1) {
					System.out.println("In Left 3");
					Character.RealY = (PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
					this.HaveBlink = 1;
				}
			}
		}
		else if(Direction == "Up") {
			System.out.println("In Up");
			System.out.println((this.LeftTopCorner[0]+1)/Wall.Map.SizeBlock);
			System.out.println(this.LeftTopCorner[1]/Wall.Map.SizeBlock + 1);
			System.out.println(Wall.MapArray[(this.LeftTopCorner[0]+1)/Wall.Map.SizeBlock][(this.LeftTopCorner[1]-1)/Wall.Map.SizeBlock + 1]);
			if(Wall.MapArray[(this.LeftTopCorner[0]+1)/Wall.Map.SizeBlock][(this.LeftTopCorner[1]-1)/Wall.Map.SizeBlock + 1] == 1 ) {//|| Wall.MapArray[this.RightTopCorner[0]/Wall.Map.SizeBlock][this.RightTopCorner[1]/Wall.Map.SizeBlock + 1] == 1) {
				System.out.println("In Up 2");
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock + 1] != 1) {
					System.out.println("In Up 3");
					Character.RealX = (PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
					this.HaveBlink = 1;
				}
			}
		}
		else if(Direction == "Down"){
			System.out.println("In Down");
			if(Wall.MapArray[(this.LeftBottomCorner[0]+1)/Wall.Map.SizeBlock][this.LeftBottomCorner[1]/Wall.Map.SizeBlock - 1] == 1 || Wall.MapArray[this.RightBottomCorner[0]/Wall.Map.SizeBlock][this.RightBottomCorner[1]/Wall.Map.SizeBlock -1] ==1) {
				System.out.println("In Down 2");
				if(Wall.MapArray[(PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock][(PointY+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock - 1] != 1) {
					System.out.println("In Down 3");
					Character.RealX = (PointX+Wall.Map.SizeBlock/2)/Wall.Map.SizeBlock*Wall.Map.SizeBlock;
					this.HaveBlink = 1;
				}
			}
		}
		else {
			System.out.println("Nothing");
			this.HaveBlink = 0;
		}
	}
	
}
