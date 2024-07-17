package Util;

import java.security.SecureRandom;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Dao.StudentDao;

/**
 * generate a random password contain letters and numbers of given length
 */
public class RandomPwd {

	private static final String lowStr = "abcdefghijklmnopqrstuvwxyz";
	private static final String numStr = "0123456789";

	private static char getRandomChar(String str) {
		SecureRandom random = new SecureRandom();
		return str.charAt(random.nextInt(str.length()));
	}

	private static char getLowChar() {
		return getRandomChar(lowStr);
	}

	private static char getUpperChar() {
		return Character.toUpperCase(getLowChar());
	}

	private static char getNumChar() {
		return getRandomChar(numStr);
	}

	private static char getRandomChar(int funNum) {
		switch (funNum) {
		case 0:
			return getLowChar();
		case 1:
			return getUpperChar();
		default:
			return getNumChar();

		}
	}

	public static String getRandomPwd(Connection con, int num) {
		while (true) {
			List<Character> list = new ArrayList<>(num);
			list.add(getLowChar());
			list.add(getUpperChar());
			list.add(getNumChar());

			for (int i = 4; i < num; i++) {
				SecureRandom random = new SecureRandom();
				int funNum = random.nextInt(4);
				list.add(getRandomChar(funNum));
			}

			Collections.shuffle(list);
			StringBuilder stringBuilder = new StringBuilder(list.size());
			for (Character c : list) {
				stringBuilder.append(c);
			}

			String passwd = stringBuilder.toString();
			try {
				if (StudentDao.CheckPassword(con, passwd)) {
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return passwd;
		}
	}

}
