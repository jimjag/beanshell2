/*****************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one                *
 * or more contributor license agreements.  See the NOTICE file              *
 * distributed with this work for additional information                     *
 * regarding copyright ownership.  The ASF licenses this file                *
 * to you under the Apache License, Version 2.0 (the                         *
 * "License"); you may not use this file except in compliance                *
 * with the License.  You may obtain a copy of the License at                *
 *                                                                           *
 *     http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                           *
 * Unless required by applicable law or agreed to in writing,                *
 * software distributed under the License is distributed on an               *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY                    *
 * KIND, either express or implied.  See the License for the                 *
 * specific language governing permissions and limitations                   *
 * under the License.                                                        *
 *                                                                           *
 * This file is part of the BeanShell Java Scripting distribution.           *
 * Documentation and updates may be found at                                 *
 *      https://github.com/jimjag/beanshell2                                 *
 *                                                                           *
 * This file is part of the BeanShell Java Scripting distribution.           *
 * Documentation and updates may be found at http://www.beanshell.org/       *
 * Patrick Niemeyer (pat@pat.net)                                            *
 * Author of Learning Java, O'Reilly & Associates                            *
 *                                                                           *
 *****************************************************************************/

package bsh;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static bsh.TestUtil.eval;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(FilteredTestRunner.class)
public class GoogleReports {

	/**
	 * <a href="https://github.com/pejobo/beanshell2/issues/detail?id=57">issue#57</a>
	 */
	@Test
	@SuppressWarnings({"ConstantIfStatement"})
	public void issue_57() throws Exception {
		int loopCount = 0;
		do {
			loopCount++;
			if (true) continue;
		} while (false);
		assertEquals(1, loopCount);
		loopCount = (Integer) eval(
				"int loopCount = 0;",
				"do{",
				"	loopCount++;",
				"	if (loopCount > 100) return loopCount;",
				"	if (true) continue;",
				"} while (false);",
				"return loopCount"
		);
		assertEquals(1, loopCount);
		loopCount = (Integer) eval(
				"int loopCount = 0;",
				"while (loopCount < 1) {",
				"	loopCount++;",
				"	if (loopCount > 100) return loopCount;",
				"	if (true) continue;",
				"}",
				"return loopCount"
		);
		assertEquals(1, loopCount);
		assertEquals(Boolean.TRUE, eval("while(true) { break; return false; } return true;"));
		assertEquals(Boolean.TRUE, eval("do { break; return false; } while(true); return true;"));
		loopCount = (Integer) eval(
				"int loopCount = 0;",
				"while (++loopCount < 2);",
				"return loopCount"
		);
		assertEquals(2, loopCount);
		loopCount = (Integer) eval(
				"int loopCount = 0;",
				"do { } while (++loopCount < 2);",
				"return loopCount"
		);
		assertEquals(2, loopCount);
	}


	/**
	 * <a href="https://github.com/pejobo/beanshell2/issues/detail?id=60">issue#60</a>
	 */
	@Test
	public void issue_60() throws Exception {
		final String script =
				"String foo = null;" +
				"if (foo != null && foo.length() > 0) return \"not empty\";" +
				"return \"empty\";";
		final ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		scriptEngineManager.registerEngineName("beanshell", new BshScriptEngineFactory());
		final ScriptEngine engine = scriptEngineManager.getEngineByName("beanshell");
		assertNotNull(engine);
		Object result;
		result = engine.eval(script);
		assertEquals("empty", result);
		result = eval(script);
		assertEquals("empty", result);
	}

}
