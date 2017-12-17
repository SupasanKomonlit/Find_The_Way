package com.findthewaygame.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class YellowCharacter {
	public int RealX;
	public int RealY;
	public int Speed;
	public int status;
	public String Direction = "Down";
	
	private int CountMove = 0;
	private Random Random = new Random();
	private Texture YellowCircle = new Texture("YellowCircle.png");
	public DrawMap Map;
	private GameRunning Game;
	private SpriteBatch DrawEnemy = new SpriteBatch();
	
	public YellowCharacter(int StartX, int StartY, DrawMap Map, GameRunning Game) {
		this.Map = Map;
		this.status = 1;
		this.Game = Game;
		this.Speed = this.Game.NormalSpeed;
		RealX = StartX*this.Map.SizeBlock;
		RealY = StartY*this.Map.SizeBlock;
		this.ChangeDirection("Down");

	}
	
	public void ChangeDirection(String OriginDirection) {
		for(;OriginDirection==this.Direction;) {
			int random = this.Random.nextInt(4);
			if(random == 0)
				this.Direction = "Left";
			else if(random == 1)
				this.Direction = "Right";
			else if(random == 2)
				this.Direction = "Up";
			else if(random == 3)
				this.Direction = "Down";
			//System.out.println("Line46: "+this.Direction);
		}
	}
	
	private void Update() {
		int Move = 0;
		for(;;) {
			this.Game.Wall.BlinkIt.HaveBlink = 0;
			Move = this.Game.Wall.Check(this, this.Direction);
			if(this.Game.Wall.BlinkIt.HaveBlink == 1) {
				this.CountMove ++;
				break;
			}
			else if(Move == 0) {
				//System.out.println("Line55: "+"Change because wall");
				this.ChangeDirection(this.Direction);
				this.CountMove = 0;
			}
			else if((this.Game.CheckMap.ReadMap(RealX+this.Map.SizeBlock/2, RealY+this.Map.SizeBlock/2) == 8) & (this.CountMove > 5 )) {
				//System.out.println("Line60: Change because Map");
				this.ChangeDirection(this.Direction);
				this.CountMove = 0;
			}
			else {
				//System.out.println("Line65: Move:  "+Move);
				this.CountMove ++;
				break;
			}
		}
		//System.out.println("Line69: CountMove: "+this.CountMove);
		if(this.Direction=="Left")
			this.RealX -= Move;
		
		if(this.Direction== "Right")
        	this.RealX += Move;

		if(this.Direction=="Up")
        	this.RealY += Move;
        	
		if(this.Direction=="Down")
        	this.RealY -= Move;
/*		if(this.CountMove < 5) {
			this.CountMove++;
		}
		else if(this.Game.CheckMap.ReadMap(RealX, RealY)== 8) {
			this.ChangeDirection(this.Direction);
		}
		else {}*/
		
		//if(random == 0)
 //       	if (this.Game.Wall.Check(this, "Left"))
        		//this.RealX -= this.Speed;
		/*if(this.Direction=="Left")
			this.RealX -= this.Game.Wall.Check(this, "Left");
        
        //if(random == 1) 
        	//if (this.Game.Wall.Check(this, "Right")) 
        		//this.RealX += this.Speed;
		if(this.Direction== "Right")
        	this.RealX += this.Game.Wall.Check(this, "Right");
        
        //if(random == 2) 
        	//if (this.Game.Wall.Check(this, "Up")) 
        		//this.RealY += this.Speed;
		if(this.Direction=="Up")
        	this.RealY += this.Game.Wall.Check(this, "Up");
        	
        //if(random == 3) 
        	//if (this.Game.Wall.Check(this, "Down"))
        		//this.RealY -= this.Speed;
		if(this.Direction=="Down")
        	this.RealY -= this.Game.Wall.Check(this, "Down");*/
	}
	
	public void DrawPicture() {
		this.Update();
		DrawEnemy.begin();
		DrawEnemy.draw(YellowCircle,RealX,RealY);
		DrawEnemy.end();
	}
}
