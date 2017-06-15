package pe.com.bbva.visitame.domain.geo;

import java.util.List;


import com.google.maps.model.LatLng;

public class Direction {
	
	List<Legs> mLegsList;
	LatLng mNorthEastBound;
	LatLng mSouthWestBound;
	String copyrights;
	
	public Direction(List<Legs> legsList) {
		super();
		this.mLegsList = legsList;
	}

	public final List<Legs> getLegsList() {
		return mLegsList;
	}
	
	public final void setPathsList(List<Legs> mLegsList) {
		this.mLegsList = mLegsList;
	}
	
	public final LatLng getmNorthEastBound() {
		return mNorthEastBound;
	}
	
	public final void setmNorthEastBound(LatLng mNorthEastBound) {
		this.mNorthEastBound = mNorthEastBound;
	}

	public final LatLng getmSouthWestBound() {
		return mSouthWestBound;
	}
	
	public final void setmSouthWestBound(LatLng mSouthWestBound) {
		this.mSouthWestBound = mSouthWestBound;
	}
	
	public final String getCopyrights() {
		return copyrights;
	}

	public final void setCopyrights(String copyrights) {
		this.copyrights = copyrights;
	}

	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder("GDirection\r\n");
		for (Legs path : mLegsList) {
			strB.append(path.toString());
			strB.append("\r\n");
		}
		return strB.toString();
	}

}
