package cfd.hireme.bosses.utilities;

import java.util.List;

public class Random {
	public static boolean random(Double chance) {
		// lowest : 0.001
		Integer min = 1;
		Integer max = 1000;
		Integer range = max - min + 1;
		Double num = (double) ((int) (Math.random() * range) + min);
		if (chance >= (num / 1000)) {
			return true;
		} else {
			return false;
		}
	}

	public static Integer random(Integer min, Integer max) {
		Integer range = max - min + 1;
		Integer num = (int) (Math.random() * range) + min;
		return num;
	}

	public static double randomNumber(double min, double max) {
		double range = max - min;
		double num = Math.random() * range + min;
		return num;
	}

	public static <T> void addWeight(T obj, List<T> list, int amount) {
		for (int i = 0; i <= amount; i++) {
			list.add(obj);
		}
	}
}
