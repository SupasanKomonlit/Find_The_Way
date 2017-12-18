package com.findthewaygame.mygdx.game;

public class CheckHero {
	private DrawMap Map;
	public CheckHero(DrawMap Map) {
		this.Map = Map;
	}
	public boolean CheckBlock(WhiteCharacter Player, YellowCharacter Enemy){
		//System.out.println(this.CenterPoint(Player.RealX));
		//System.out.println(this.CenterPoint(Player.RealY));
		//System.out.println(this.CenterPoint(Enemy.RealX));
		//System.out.println(this.CenterPoint(Enemy.RealY));
		if(this.CenterPoint(Player.RealX)==this.CenterPoint(Enemy.RealX) && this.CenterPoint(Player.RealY) == this.CenterPoint(Enemy.RealY)) {
			return true;
		}
		else
			return false;
	}
	
	private int CenterPoint(int Position) {
		return (Position + this.Map.SizeBlock/2)/this.Map.SizeBlock;
	}
}
