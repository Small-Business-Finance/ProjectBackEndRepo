package com.smartCapital.sbfApp.app.serviceimpl;

import java.util.Comparator;

import com.smartCapital.sbfApp.app.model.EMITable;

public class SortEmi implements Comparator<EMITable>
{
	

	@Override
	public int compare(EMITable o1 , EMITable o2) {
		
		return o1.getEmidate().compareTo(o2.getEmidate());
	}


}
