import com.badlogic.gdx.math.*;
import java.util.*;
import runner.*;
import java.io.*;

public class Th902Interface {
	/*  public static ArrayList<Barrage> bullets = new ArrayList<Barrage>();

	 public static ArrayList<Barrage> GetBulletList() {
	 return bullets;
	 }
	 */
	public static int GetBulletCount() {
		int size=0;
		for (Layer la:Layer.LayerArray) {
			size += la.Barrages.size();
		}
		return size;
	}

	public static void OpenMbg(String mbgPath) {
		try {
			Main.OpenMbgFile(mbgPath);
		} catch (IOException e) {

		} catch (NumberFormatException e) {

		}
	}

	public static void Update() {
		Main.updateAll();
	}

	public static Vector2 GetPalyerPosition() {
		return Player.position;
	}

	public static void SetPlayerX(float x) {
		Player.position.x = x;
	}

	public static void SetPlayerY(float y) {
		Player.position.y = y;
	}

	public static void SetPlayerPosition(float x, float y) {
		Player.position.x = x;
		Player.position.y = y;
	}

	public static void SetRandomSeed(int seed) {
		Main.rand = new Random(seed);
	}
}
