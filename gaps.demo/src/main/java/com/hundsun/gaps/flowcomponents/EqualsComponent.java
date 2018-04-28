package com.hundsun.gaps.flowcomponents;

import java.lang.Object;

public class EqualsComponent {

	public static boolean equals(Object object1, Object object2){
		if (null == object1 || null == object2) {
			return false;
		}
		return object1.equals(object2);
	}
}
