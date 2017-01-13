
package com.staggeringbeauty.www.desktop;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.staggeringbeauty.www.MonkeyMania;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = MonkeyMania.WIDTH;
                config.height = MonkeyMania.HEIGHT;
		new LwjglApplication(new MonkeyMania(), config);
	}
}
