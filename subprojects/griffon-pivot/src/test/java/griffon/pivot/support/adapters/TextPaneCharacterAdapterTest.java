/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2008-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package griffon.pivot.support.adapters;

import griffon.core.CallableWithArgs;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TextPaneCharacterAdapterTest {
    private final TextPaneCharacterAdapter adapter = new TextPaneCharacterAdapter();

    @Test
    public void testCharactersInserted() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getCharactersInserted());
        adapter.charactersInserted(null, 0, 0);
        assertFalse(invoked[0]);

        adapter.setCharactersInserted(callable);
        adapter.charactersInserted(null, 0, 0);
        assertTrue(invoked[0]);
    }

    @Test
    public void testCharactersRemoved() {
        final boolean[] invoked = new boolean[1];
        CallableWithArgs<Void> callable = args -> {
            invoked[0] = true;
            return null;
        };

        assertNull(adapter.getCharactersRemoved());
        adapter.charactersRemoved(null, 0, 0);
        assertFalse(invoked[0]);

        adapter.setCharactersRemoved(callable);
        adapter.charactersRemoved(null, 0, 0);
        assertTrue(invoked[0]);
    }

}
