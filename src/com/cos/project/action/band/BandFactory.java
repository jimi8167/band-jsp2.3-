package com.cos.project.action.band;

import com.cos.project.action.Action;

public class BandFactory {

	public static Action route(String cmd) {
		// TODO Auto-generated method stub
		if (cmd.equals("list")||cmd.equals("")) {
			return new BandListAction();
			
		}else if (cmd.equals("write")) {
			return new BandWriteAction();
		}else if (cmd.equals("detail")) {
			return new BandDetailAction();
		}else if (cmd.equals("delete")) {
			return new BandDeleteAction();
		}else if (cmd.equals("update")) {
			return new BandUpdateAction();
		}else if (cmd.equals("writeProc")) {
			return new BandWriteProcAction();
		}else if (cmd.equals("writeProc")) {
			return new BandUpdateProcAction();
		}else if (cmd.equals("bandPage")) {
			return new BandbandPageAction();
			
		}else if (cmd.equals("tableList")) {
			return new BandtableListAction();
			
			
		}else if (cmd.equals("calendar")) {
			return new BandCalendarAction();
		}
		return null;
	}

}
