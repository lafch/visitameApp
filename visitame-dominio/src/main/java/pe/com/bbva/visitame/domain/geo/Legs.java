package pe.com.bbva.visitame.domain.geo;

import java.util.List;

public class Legs {
	
	List<Path> mPathsList;
	int mDistance;
	int mDuration;
	String mStartAddress;
	String mEndAddress;

	public Legs(List<Path> pathsList) {
		super();
		this.mPathsList = pathsList;
	}

	public final List<Path> getPathsList() {
		return mPathsList;
	}

	public final void setPathsList(List<Path> mPathsList) {
		this.mPathsList = mPathsList;
	}
	
	public final int getmDistance() {
		return mDistance;
	}
	
	public final void setmDistance(int mDistance) {
		this.mDistance = mDistance;
	}

	public final int getmDuration() {
		return mDuration;
	}

	public final void setmDuration(int mDuration) {
		this.mDuration = mDuration;
	}

	public final String getmStartAddress() {
		return mStartAddress;
	}

	public final void setmStartAddress(String mStartAddress) {
		this.mStartAddress = mStartAddress;
	}

	public final String getmEndAddress() {
		return mEndAddress;
	}

	public final void setmEndAddress(String mEndAddress) {
		this.mEndAddress = mEndAddress;
	}

	@Override
	public String toString() {
		StringBuilder strB=new StringBuilder("GLegs\r\n");
		for(Path path:mPathsList) {
			strB.append(path.toString());
			strB.append("\r\n");
		}
		return strB.toString();
	}
}
