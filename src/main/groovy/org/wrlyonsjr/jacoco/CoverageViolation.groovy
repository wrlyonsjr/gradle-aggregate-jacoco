/*
 * Copyright 2020 William Lyons Jr.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wrlyonsjr.jacoco

import groovy.transform.EqualsAndHashCode

/**
 * A coverage violation observed for the given {@code clazz}.
 */
@EqualsAndHashCode
public class CoverageViolation {
	String clazz
	int covered
	double threshold
	int total
	CoverageType type

	public CoverageViolation(String clazz, int covered, double threshold, int total, CoverageType type) {
		this.clazz = clazz
		this.threshold = threshold
		this.type = type
		this.covered = covered
		this.total = total
	}

	@Override
	public String toString() {
		double coverage = covered/(double)total
		return String.format("%s (%d/%d or %s %s coverage < %s)",
			clazz, covered, total, toPercentage(coverage), type,
			toPercentage(threshold))
	}

	private static String toPercentage(double input) {
		double percent = input * 100
		return "${percent}%"
	}
}
