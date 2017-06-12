package pe.com.bbva.visitame.domain.geo;

import java.util.List;

public class Path {
	
	List<Point> mPath;
	int mDistance;
	int mDuration;
	String mTravelMode;
	String mHtmlText;

	public Path(List<Point> path) {
		super();
		this.mPath = path;
	}

	public final List<Point> getPath() {
		return mPath;
	}

	public final void setPath(List<Point> mPath) {
		this.mPath = mPath;
	}

	public final List<Point> getmPath() {
		return mPath;
	}

	public final int getDistance() {
		return mDistance;
	}

	public final int getDuration() {
		return mDuration;
	}

	public final String getTravelMode() {
		return mTravelMode;
	}

	public final String getHtmlText() {
		return mHtmlText;
	}
	
	public final void setmPath(List<Point> mPath) {
		this.mPath = mPath;
	}

	public final void setDistance(int distance) {
		this.mDistance = distance;
	}

	public final void setDuration(int duration) {
		this.mDuration = duration;
	}

	public final void setTravelMode(String travelMode) {
		this.mTravelMode = travelMode;
	}

	public final void setHtmlText(String htmlText) {
		this.mHtmlText = htmlText;
	}
	
	@Override
	public String toString() {
		StringBuilder strB=new StringBuilder("GPath\r\n");
		for(Point point:mPath) {
			strB.append(point.toString());
			strB.append(point.toString());
			strB.append(",");
		}
		return strB.toString();
	}

}
