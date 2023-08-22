package app;

import java.text.ParseException;

import controller.FrameController;
import view.FrameDePaineis;

public class Aplicacao {
	public static void main(String[] args) {
		try {
			new FrameController(new FrameDePaineis());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
