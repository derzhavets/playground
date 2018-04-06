package com.derzhavets.playground.headfirst.midi.miniMiniMidi;

import javax.sound.midi.*;

public class MiniMiniMidiApp {
	public static void main(String[] args) {
		MiniMiniMidiApp mini = new MiniMiniMidiApp();
		mini.play();
	}
	
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 5);
			track.add(noteOff);
			
			player.setSequence(seq);
			player.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
