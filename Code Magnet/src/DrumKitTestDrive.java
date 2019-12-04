//Alexandra Zhang Jiang
//December 4, 2019
//Code Magnet 
//Client class

public class DrumKitTestDrive {

	public static void main(String[] args) {
		DrumKit d = new DrumKit();
		d.snare = false;
		if (d.snare == true) {
			d.playSnare();
		}
		d.playSnare();
		d.playTopHat();

	}

}
