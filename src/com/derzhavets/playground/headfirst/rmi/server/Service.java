package com.derzhavets.playground.headfirst.rmi.server;

import java.io.Serializable;
import javax.swing.JPanel;

public interface Service extends Serializable {
	public JPanel getGuiPanel();
}
