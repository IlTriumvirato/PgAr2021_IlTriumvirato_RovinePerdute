package arnaldo.anno2021.triumvirato.rovineperdute;

import it.unibs.fp.mylib.CustomMath;

public class Posizione {
	private double x;
	private double y;
	private double h;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	
	public double getHorizontalDistance(Posizione p) {
		return CustomMath.pitagora(x-p.getX(), y-p.getY());
	}
	
	public double getVerticalDistance(Posizione p) {
		return Math.abs(h-p.getH());
	}
	
	
}
