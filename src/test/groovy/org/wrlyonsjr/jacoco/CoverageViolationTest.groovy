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

import org.wrlyonsjr.jacoco.CoverageType
import spock.lang.Specification

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertThat

class CoverageViolationTest extends Specification {

	def 'toString should print pretty percentages'() {
		given: 'a CoverageViolation'
		def unit = new CoverageViolation('the-thing', 2, 0.80, 10000, CoverageType.INSTRUCTION)

		when: 'a toString is called'
		def text = unit.toString()

		then:
		assertNotNull(text)
		assert text.contains('0.02%')
		assert text.contains('80.0%')
	}
}
