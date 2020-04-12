package runner;

public class MathHelper {

	public static double ToRadians(float degrees) {
		return degrees * 0.017453292519943294;//(Math.PI/180);
	}

	public static double ToDegrees(float radians) {
		return radians * 57.29577951308232522;
	}

	public static float Distance(float value1, float value2) {
		return Math.abs(value1 - value2);
	}

	public static float Min(float value1, float value2) {
		return Math.min(value1, value2);
	}

	public static float Max(float value1, float value2) {
		return Math.max(value1, value2);
	}

	public static float Clamp(float value, float min, float max) {
		value = value > max ? max : value;
		value = value < min ? min : value;
		return value;
	}

	public static float Lerp(float value1, float value2, float amount) {
		return value1 + (value2 - value1) * amount;
	}

	public static float Barycentric(float value1, float value2, float value3, float amount1, float amount2) {
		return value1 + amount1 * (value2 - value1) + amount2 * (value3 - value1);
	}

	public static float SmoothStep(float value1, float value2, float amount) {
		float num = Clamp(amount, 0.0f, 1f);
		return Lerp(value1, value2, (float)(num * (double)num * (3.0 - 2.0 * num)));
	}

	public static float CatmullRom(float value1, float value2, float value3, float value4, float amount) {
		float num1 = amount * amount;
		float num2 = amount * num1;
		return 0.5f * (2.0f * value2 + (-value1 + value3) * amount + (2.0f * value1 - 5.0f * value2 + 4.0f * value3 - value4) * num1 + (-value1 + 3.0f * value2 - 3.0f * value3 + value4) * num2);
	}

	public static float Hermite(float value1, float tangent1, float value2, float tangent2, float amount) {
		float num1 = amount;
		float num2 = num1 * num1;
		float num3 = num1 * num2;
		float num4 = 2.0f * num3 - 3.0f * num2 + 1.0f;
		float num5 = -2.0f * num3 + 3.0f * num2;
		float num6 = num3 - 2f * num2 + num1;
		float num7 = num3 - num2;
		return value1 * num4 + value2 * num5 + tangent1 * num6 + tangent2 * num7;
	}

	public static float WrapAngle(float angle) {
		angle = (float) Math.IEEEremainder(angle, 6.28318548202515);
		if (angle <= -3.14159274101257) {
			angle += 6.283185307179586;
		} else if (angle > 3.14159274101257) {
			angle -= 6.283185307179586;
		}
		return angle;
	}
}
